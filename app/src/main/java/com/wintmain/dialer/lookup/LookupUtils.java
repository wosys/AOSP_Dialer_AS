/*
 * Copyright (C) 2014 The CyanogenMod Project
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


import android.text.Html;

import com.android.incallui.bindings.PhoneNumberService;
import com.wintmain.dialer.logging.ContactLookupResult;
import com.wintmain.dialer.phonenumbercache.ContactInfo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LookupUtils {
    private static final String USER_AGENT =
            "Mozilla/5.0 (X11; Linux x86_64; rv:42.0) Gecko/20100101 Firefox/42.0";

    private static HttpURLConnection prepareHttpConnection(String url, Map<String, String> headers)
            throws IOException {
        // open connection
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(url).openConnection();
        // set user agent (default value is null)
        urlConnection.setRequestProperty("User-Agent", USER_AGENT);
        // set all other headers if not null
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                urlConnection.setRequestProperty(header.getKey(), header.getValue());
            }
        }

        return urlConnection;
    }

    private static byte[] httpFetch(HttpURLConnection urlConnection) throws IOException {
        // query url, read and return buffered response body
        // we want to make sure that the connection gets closed here
        InputStream is = new BufferedInputStream(urlConnection.getInputStream());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] result;
        try {
            byte[] partial = new byte[4096];
            int read;
            while ((read = is.read(partial, 0, 4096)) != -1) {
                baos.write(partial, 0, read);
            }
            result = baos.toByteArray();
        } finally {
            is.close();
            baos.close();
        }
        return result;
    }

    private static Charset determineCharset(HttpURLConnection connection) {
        String contentType = connection.getContentType();
        if (contentType != null) {
            String[] split = contentType.split(";");
            for (String s : split) {
                String trimmed = s.trim();
                if (trimmed.startsWith("charset=")) {
                    try {
                        return Charset.forName(trimmed.substring(8));
                    } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
                        // we don't know about this charset -> ignore
                    }
                }
            }
        }
        return Charset.defaultCharset();
    }

    public static String httpGet(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = prepareHttpConnection(url, headers);
        try {
            byte[] response = httpFetch(connection);
            return new String(response, determineCharset(connection));
        } finally {
            connection.disconnect();
        }
    }

    public static byte[] httpGetBytes(String url, Map<String, String> headers) throws IOException {
        HttpURLConnection connection = prepareHttpConnection(url, headers);
        try {
            return httpFetch(connection);
        } finally {
            connection.disconnect();
        }
    }

    public static String firstRegexResult(String input, String regex, boolean dotall) {
        if (input == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex, dotall ? Pattern.DOTALL : 0);
        Matcher m = pattern.matcher(input);
        return m.find() ? m.group(1).trim() : null;
    }

    public static String fromHtml(String input) {
        if (input == null) {
            return null;
        }
        return Html.fromHtml(input).toString().trim();
    }

    static class LookupRequest {
        String normalizedNumber;
        String formattedNumber;
        PhoneNumberService.NumberLookupListener numberListener;
        ContactInfo contactInfo;
    }

    static class LookupNumberInfo implements PhoneNumberService.PhoneNumberInfo {
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
