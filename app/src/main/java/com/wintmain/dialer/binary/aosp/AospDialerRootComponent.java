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

import com.android.bubble.stub.StubBubbleModule;
import com.android.incallui.calllocation.stub.StubCallLocationModule;
import com.android.incallui.maps.stub.StubMapsModule;
import com.android.incallui.speakeasy.StubSpeakEasyModule;
import com.android.voicemail.impl.VoicemailModule;
import com.wintmain.dialer.activecalls.ActiveCallsModule;
import com.wintmain.dialer.binary.basecomponent.BaseDialerRootComponent;
import com.wintmain.dialer.calllog.CallLogModule;
import com.wintmain.dialer.calllog.config.CallLogConfigModule;
import com.wintmain.dialer.commandline.CommandLineModule;
import com.wintmain.dialer.common.concurrent.DialerExecutorModule;
import com.wintmain.dialer.configprovider.SharedPrefConfigProviderModule;
import com.wintmain.dialer.contacts.ContactsModule;
import com.wintmain.dialer.duo.stub.StubDuoModule;
import com.wintmain.dialer.enrichedcall.stub.StubEnrichedCallModule;
import com.wintmain.dialer.feedback.stub.StubFeedbackModule;
import com.wintmain.dialer.glidephotomanager.GlidePhotoManagerModule;
import com.wintmain.dialer.inject.ContextModule;
import com.wintmain.dialer.metrics.StubMetricsModule;
import com.wintmain.dialer.phonelookup.PhoneLookupModule;
import com.wintmain.dialer.phonenumbergeoutil.impl.PhoneNumberGeoUtilModule;
import com.wintmain.dialer.precall.impl.PreCallModule;
import com.wintmain.dialer.preferredsim.PreferredSimModule;
import com.wintmain.dialer.preferredsim.suggestion.stub.StubSimSuggestionModule;
import com.wintmain.dialer.promotion.impl.PromotionModule;
import com.wintmain.dialer.simulator.impl.SimulatorModule;
import com.wintmain.dialer.simulator.stub.StubSimulatorEnrichedCallModule;
import com.wintmain.dialer.spam.stub.StubSpamModule;
import com.wintmain.dialer.storage.StorageModule;
import com.wintmain.dialer.strictmode.impl.SystemStrictModeModule;

import javax.inject.Singleton;

import dagger.Component;

/** Root component for the AOSP Dialer application. */
@Singleton
@Component(
        modules = {
                ActiveCallsModule.class,
                CallLogModule.class,
                CallLogConfigModule.class,
                CommandLineModule.class,
                ContactsModule.class,
                ContextModule.class,
                DialerExecutorModule.class,
                GlidePhotoManagerModule.class,
                PhoneLookupModule.class,
                PhoneNumberGeoUtilModule.class,
                PreCallModule.class,
                PreferredSimModule.class,
                PromotionModule.class,
                SharedPrefConfigProviderModule.class,
                SimulatorModule.class,
                StubSimulatorEnrichedCallModule.class,
                StorageModule.class,
                StubCallLocationModule.class,
                StubDuoModule.class,
                StubEnrichedCallModule.class,
                StubBubbleModule.class,
                StubMetricsModule.class,
                StubFeedbackModule.class,
                StubMapsModule.class,
                StubSimSuggestionModule.class,
                StubSpamModule.class,
                StubSpeakEasyModule.class,
                SystemStrictModeModule.class,
                VoicemailModule.class,
        })
public interface AospDialerRootComponent extends BaseDialerRootComponent {}
