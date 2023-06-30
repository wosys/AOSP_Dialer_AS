package com.wintmain.dialer.lookup;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2023-06-30 23:34:56
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import com.wintmain.dialer.lookup.yellowpages.YellowPagesReverseLookup;
import com.wintmain.dialer.lookup.zabasearch.ZabaSearchReverseLookup;
import com.wintmain.dialer.phonenumbercache.ContactInfo;

import java.io.IOException;

public abstract class ReverseLookup {
    private static final String TAG = ReverseLookup.class.getSimpleName();

    private static ReverseLookup INSTANCE = null;

    public static ReverseLookup getInstance(Context context) {
        String provider = LookupSettings.getReverseLookupProvider(context);

        if (INSTANCE == null || !isInstance(provider)) {
            Log.d(TAG, "Chosen reverse lookup provider: " + provider);

            if (provider.equals(LookupSettings.RLP_YELLOWPAGES)
                    || provider.equals(LookupSettings.RLP_YELLOWPAGES_CA)) {
                INSTANCE = new YellowPagesReverseLookup(context, provider);
            } else if (provider.equals(LookupSettings.RLP_ZABASEARCH)) {
                INSTANCE = new ZabaSearchReverseLookup(context);
            }
        }

        return INSTANCE;
    }

    private static boolean isInstance(String provider) {
        if ((provider.equals(LookupSettings.RLP_YELLOWPAGES)
                || provider.equals(LookupSettings.RLP_YELLOWPAGES_CA))
                && INSTANCE instanceof YellowPagesReverseLookup) {
            return true;
        } else return provider.equals(LookupSettings.RLP_ZABASEARCH)
                && INSTANCE instanceof ZabaSearchReverseLookup;
    }

    /**
     * Lookup image
     *
     * @param context The application context
     * @param uri The image URI
     */
    public Bitmap lookupImage(Context context, Uri uri) {
        return null;
    }

    /**
     * Perform phone number lookup.
     *
     * @param context The application context
     * @param normalizedNumber The normalized phone number
     * @param formattedNumber The formatted phone number
     * @return The phone number info object
     */
    public abstract ContactInfo lookupNumber(Context context,
                String normalizedNumber, String formattedNumber) throws IOException;
}
