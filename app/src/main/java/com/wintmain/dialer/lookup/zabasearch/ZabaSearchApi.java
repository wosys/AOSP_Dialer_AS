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

package com.wintmain.dialer.lookup.zabasearch;

import android.text.TextUtils;

import com.wintmain.dialer.lookup.LookupUtils;

import java.io.IOException;

public class ZabaSearchApi {
  private static final String TAG = ZabaSearchApi.class.getSimpleName();

  private static final String LOOKUP_URL = "https://www.zabasearch.com/phone/";

  private final String number;
  public String output = null;
  private ContactInfo info = null;

  public ZabaSearchApi(String number) {
    this.number = number;
  }

  private void fetchPage() throws IOException {
    output = LookupUtils.httpGet(LOOKUP_URL + number, null);
  }

  private void buildContactInfo() {
    // Name
    String name = LookupUtils.firstRegexResult(output,
        "itemprop=\"?name\"?>([^<]+)<", true);
    // Formatted phone number
    String phoneNumber = LookupUtils.firstRegexResult(output,
        "itemprop=\"?telephone\"?>([^<]+)<", true);
    // Address
    String addressStreet = LookupUtils.firstRegexResult(output,
        "itemprop=\"?streetAddress\"?>([^<]+?)(&nbsp;)*<", true);
    String addressCity = LookupUtils.firstRegexResult(output,
        "itemprop=\"?addressLocality\"?>([^<]+)<", true);
    String addressState = LookupUtils.firstRegexResult(output,
        "itemprop=\"?addressRegion\"?>([^<]+)<", true);
    String addressZip = LookupUtils.firstRegexResult(output,
        "itemprop=\"?postalCode\"?>([^<]+)<", true);

    StringBuilder sb = new StringBuilder();

    if (!TextUtils.isEmpty(addressStreet)) {
      sb.append(addressStreet);
    }
    if (!TextUtils.isEmpty(addressCity)) {
      sb.append(", ");
      sb.append(addressCity);
    }
    if (!TextUtils.isEmpty(addressState)) {
      sb.append(", ");
      sb.append(addressState);
    }
    if (!TextUtils.isEmpty(addressZip)) {
      sb.append(", ");
      sb.append(addressZip);
    }

    String address = sb.toString();
    if (address.isEmpty()) {
        address = null;
    }

    info = new ContactInfo();
    info.name = name;
    info.address = address;
    info.formattedNumber = number;
    info.website = LOOKUP_URL + info.formattedNumber;
  }

  public ContactInfo getContactInfo() throws IOException {
    if (info == null) {
      fetchPage();
      buildContactInfo();
    }

    return info;
  }

  public static class ContactInfo {
    String name;
    String address;
    String formattedNumber;
    String website;
  }
}
