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

package com.wintmain.dialer.phonelookup;

import com.wintmain.dialer.inject.DialerVariant;
import com.wintmain.dialer.inject.InstallIn;
import com.wintmain.dialer.phonelookup.blockednumber.SystemBlockedNumberPhoneLookup;
import com.wintmain.dialer.phonelookup.cequint.CequintPhoneLookup;
import com.wintmain.dialer.phonelookup.cnap.CnapPhoneLookup;
import com.wintmain.dialer.phonelookup.cp2.Cp2DefaultDirectoryPhoneLookup;
import com.wintmain.dialer.phonelookup.cp2.Cp2ExtendedDirectoryPhoneLookup;
import com.wintmain.dialer.phonelookup.emergency.EmergencyPhoneLookup;
import com.wintmain.dialer.phonelookup.spam.SpamPhoneLookup;
import com.google.common.collect.ImmutableList;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module which binds the PhoneLookup implementation.
 */
@InstallIn(variants = {DialerVariant.DIALER_TEST})
@Module
public abstract class PhoneLookupModule {

    @Provides
    @SuppressWarnings({"rawtype"})
    static ImmutableList<PhoneLookup> providePhoneLookupList(
            CequintPhoneLookup cequintPhoneLookup,
            CnapPhoneLookup cnapPhoneLookup,
            Cp2DefaultDirectoryPhoneLookup cp2DefaultDirectoryPhoneLookup,
            Cp2ExtendedDirectoryPhoneLookup cp2ExtendedDirectoryPhoneLookup,
            EmergencyPhoneLookup emergencyPhoneLookup,
            SystemBlockedNumberPhoneLookup systemBlockedNumberPhoneLookup,
            SpamPhoneLookup spamPhoneLookup) {
        return ImmutableList.of(
                cequintPhoneLookup,
                cnapPhoneLookup,
                cp2DefaultDirectoryPhoneLookup,
                cp2ExtendedDirectoryPhoneLookup,
                emergencyPhoneLookup,
                systemBlockedNumberPhoneLookup,
                spamPhoneLookup);
    }
}
