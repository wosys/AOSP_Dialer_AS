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
import android.telephony.TelephonyManager;

import com.android.incallui.bindings.PhoneNumberService;
import com.wintmain.dialer.logging.ContactLookupResult;
import com.wintmain.dialer.phonenumbercache.ContactInfo;

public class ReverseLookupService implements PhoneNumberService, Handler.Callback {
    private final HandlerThread backgroundThread;
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
        backgroundThread = new HandlerThread("ReverseLookup");
        backgroundThread.start();

        backgroundHandler = new Handler(backgroundThread.getLooper(), this);
        handler = new Handler(this);
    }

    @Override
    public void getPhoneNumberInfo(String phoneNumber, NumberLookupListener numberListener) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_LOOKUP: {
                // background thread
                break;
            }
            case MSG_NOTIFY_NUMBER: {
                // main thread
                break;
            }
        }

        return true;
    }
    private static class LookupNumberInfo implements PhoneNumberInfo {
        private final ContactInfo info;
        private LookupNumberInfo(ContactInfo info) {
            this.info = info;
        }

        @Override
        public String getDisplayName() {
            return info.name;
        }
        @Override
        public String getNumber() {
            return info.number;
        }
        @Override
        public int getPhoneType() {
            return info.type;
        }
        @Override
        public String getPhoneLabel() {
            return info.label;
        }
        @Override
        public String getNormalizedNumber() {
            return info.normalizedNumber;
        }
        @Override
        public String getImageUrl() {
            return info.photoUri != null ? info.photoUri.toString() : null;
        }
        @Override
        public boolean isBusiness() {
            // FIXME
            return false;
        }
        @Override
        public String getLookupKey() {
            return info.lookupKey;
        }
        @Override
        public ContactLookupResult.Type getLookupSource() {
            return ContactLookupResult.Type.REMOTE;
        }
    }
}