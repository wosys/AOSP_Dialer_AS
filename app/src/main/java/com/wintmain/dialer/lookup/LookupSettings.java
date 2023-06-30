/*
 * Copyright (C) 2014 Xiao-Long Chen <chillermillerlong@hotmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wintmain.dialer.lookup;

import android.content.Context;
import android.content.SharedPreferences;

public final class LookupSettings {
    /** Reverse lookup providers */
    public static final String RLP_OPENCNAM = "OpenCnam";
    public static final String RLP_YELLOWPAGES = "YellowPages";
    public static final String RLP_YELLOWPAGES_CA = "YellowPages_CA";
    public static final String RLP_ZABASEARCH = "ZabaSearch";
    public static final String RLP_DEFAULT = RLP_OPENCNAM;

    /**
     * Preferences
     */
    private static final String SHARED_PREFERENCES_NAME = "lookup_settings";
    private static final String ENABLE_FORWARD_LOOKUP = "enable_forward_lookup";
    private static final String ENABLE_PEOPLE_LOOKUP = "enable_people_lookup";
    private static final String ENABLE_REVERSE_LOOKUP = "enable_reverse_lookup";
    private static final String REVERSE_LOOKUP_PROVIDER = "reverse_lookup_provider";

    private LookupSettings() {
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static boolean isForwardLookupEnabled(Context context) {
        return getSharedPreferences(context).getBoolean(ENABLE_FORWARD_LOOKUP, false);
    }

    public static void setForwardLookupEnabled(Context context, boolean value) {
        getSharedPreferences(context).edit().putBoolean(ENABLE_FORWARD_LOOKUP, value).apply();
    }

    public static boolean isPeopleLookupEnabled(Context context) {
        return getSharedPreferences(context).getBoolean(ENABLE_PEOPLE_LOOKUP, false);
    }

    public static void setPeopleLookupEnabled(Context context, boolean value) {
        getSharedPreferences(context).edit().putBoolean(ENABLE_FORWARD_LOOKUP, value).apply();
    }

    public static boolean isReverseLookupEnabled(Context context) {
        return getSharedPreferences(context).getBoolean(ENABLE_REVERSE_LOOKUP, false);
    }

    public static String getReverseLookupProvider(Context context) {
        return getSharedPreferences(context).getString(REVERSE_LOOKUP_PROVIDER, RLP_DEFAULT);
    }

    public static void setReverseLookupProvider(Context context, String value) {
        getSharedPreferences(context).edit().putString(REVERSE_LOOKUP_PROVIDER, value).apply();
    }
}
