package com.wintmain.dialer.lookup;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2023-06-30 0:10:10
 */
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;

import com.android.incallui.bindings.PhoneNumberService;
import com.wintmain.dialer.location.GeoUtil;
import com.wintmain.dialer.phonenumbercache.ContactInfo;

import java.io.IOException;

public class ReverseLookupService implements PhoneNumberService, Handler.Callback {
    private final Handler backgroundHandler;
    private final Handler handler;
    private final Context context;
    private final TelephonyManager telephonyManager;

    private static final int MSG_LOOKUP = 1;
    private static final int MSG_NOTIFY_NUMBER = 2;

    public ReverseLookupService(Context context) {
        this.context = context;
        telephonyManager = context.getSystemService(TelephonyManager.class);

        // TODO: stop after a while?
        HandlerThread backgroundThread = new HandlerThread("ReverseLookup");
        backgroundThread.start();

        backgroundHandler = new Handler(backgroundThread.getLooper(), this);
        handler = new Handler(this);
    }

    @Override
    public void getPhoneNumberInfo(String phoneNumber, NumberLookupListener numberListener) {
        if (!LookupSettings.isReverseLookupEnabled(context)){
            LookupCache.deleteCachedContacts(context);
            return;
        }
        String countryIso = telephonyManager.getSimCountryIso().toUpperCase();
        String normalizeNum = phoneNumber != null ? PhoneNumberUtils.formatNumberToE164(
                    phoneNumber, countryIso) : null;
        // Without a number, can't do reverse lookup
        if (normalizeNum == null) {
            return;
        }
        LookupUtils.LookupRequest request = new LookupUtils.LookupRequest();
        request.normalizedNumber = normalizeNum;
        request.formattedNumber = PhoneNumberUtils.formatNumber(phoneNumber,
                request.normalizedNumber, GeoUtil.getCurrentCountryIso(context));
        request.numberListener = numberListener;

        backgroundHandler.obtainMessage(MSG_LOOKUP, request).sendToTarget();
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_LOOKUP: {
                // background thread
                LookupUtils.LookupRequest request = (LookupUtils.LookupRequest) msg.obj;
                try {
                    request.contactInfo = doLookup(request);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (request.contactInfo != null){
                    handler.obtainMessage(MSG_NOTIFY_NUMBER, request).sendToTarget();
                }
                break;
            }
            case MSG_NOTIFY_NUMBER: {
                // main thread
                break;
            }
        }

        return true;
    }

    private ContactInfo doLookup(LookupUtils.LookupRequest request) throws IOException {
        final String number = request.normalizedNumber;

        if (LookupCache.hasCachedContact(context, number)) {
            ContactInfo info = LookupCache.getCachedContact(context, number);
            if (!ContactInfo.EMPTY.equals(info)) {
                return info;
            } else {
                // If we have an empty cached contact, remove it and redo lookup
                LookupCache.deleteCachedContact(context, number);
            }
        }

        ReverseLookup inst = ReverseLookup.getInstance(context);
        ContactInfo info = inst.lookupNumber(context, number, request.formattedNumber);
        if (info != null && !info.equals(ContactInfo.EMPTY)) {
            LookupCache.cacheContact(context, info);
            return info;
        }

        return null;
    }

}