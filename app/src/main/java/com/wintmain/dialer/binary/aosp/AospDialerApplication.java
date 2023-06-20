/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */

package com.wintmain.dialer.binary.aosp;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.contacts.common.extensions.PhoneDirectoryExtender;
import com.android.contacts.common.extensions.PhoneDirectoryExtenderFactory;
import com.android.incallui.bindings.InCallUiBindings;
import com.android.incallui.bindings.InCallUiBindingsFactory;
import com.android.incallui.bindings.InCallUiBindingsStub;
import com.wintmain.dialer.binary.common.DialerApplication;
import com.wintmain.dialer.inject.ContextModule;
import com.wintmain.dialer.lookup.LookupCacheService;
import com.wintmain.dialer.lookup.LookupProvider;
import com.wintmain.dialer.lookup.LookupSettings;
import com.wintmain.dialer.phonenumbercache.PhoneNumberCacheBindings;
import com.wintmain.dialer.phonenumbercache.PhoneNumberCacheBindingsFactory;

/**
 * The application class for the AOSP Dialer. This is a version of the Dialer app that has no
 * dependency on Google Play Services.
 */
public class AospDialerApplication extends DialerApplication implements
        PhoneNumberCacheBindingsFactory, PhoneDirectoryExtenderFactory, InCallUiBindingsFactory {

    /**
     * Returns a new instance of the root component for the AOSP Dialer.
     */
    @Override
    @NonNull
    protected Object buildRootComponent() {
        return DaggerAospDialerRootComponent.builder().contextModule(new ContextModule(this)).build();
    }

    @NonNull
    @Override
    public PhoneDirectoryExtender newPhoneDirectoryExtender() {
        return new PhoneDirectoryExtender() {
            @Override
            public boolean isEnabled(Context context) {
                return LookupSettings.isForwardLookupEnabled(AospDialerApplication.this);
            }

            @Override
            @Nullable
            public Uri getContentUri() {
                return LookupProvider.NEARBY_AND_PEOPLE_LOOKUP_URI;
            }
        };
    }

    @Override
    public InCallUiBindings newInCallUiBindings() {
        return new InCallUiBindingsStub();
    }

    @Override
    public PhoneNumberCacheBindings newPhoneNumberCacheBindings() {
        return LookupCacheService::new;
    }
}
