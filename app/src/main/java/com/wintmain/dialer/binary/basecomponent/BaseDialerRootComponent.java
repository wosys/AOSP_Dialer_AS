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

package com.wintmain.dialer.binary.basecomponent;

import com.android.bubble.BubbleComponent;
import com.android.incallui.calllocation.CallLocationComponent;
import com.android.incallui.maps.MapsComponent;
import com.android.incallui.speakeasy.SpeakEasyComponent;
import com.android.voicemail.VoicemailComponent;
import com.wintmain.dialer.activecalls.ActiveCallsComponent;
import com.wintmain.dialer.calllog.CallLogComponent;
import com.wintmain.dialer.calllog.config.CallLogConfigComponent;
import com.wintmain.dialer.calllog.database.CallLogDatabaseComponent;
import com.wintmain.dialer.calllog.ui.CallLogUiComponent;
import com.wintmain.dialer.commandline.CommandLineComponent;
import com.wintmain.dialer.common.concurrent.DialerExecutorComponent;
import com.wintmain.dialer.configprovider.ConfigProviderComponent;
import com.wintmain.dialer.contacts.ContactsComponent;
import com.wintmain.dialer.duo.DuoComponent;
import com.wintmain.dialer.enrichedcall.EnrichedCallComponent;
import com.wintmain.dialer.feedback.FeedbackComponent;
import com.wintmain.dialer.glidephotomanager.GlidePhotoManagerComponent;
import com.wintmain.dialer.metrics.MetricsComponent;
import com.wintmain.dialer.phonelookup.PhoneLookupComponent;
import com.wintmain.dialer.phonelookup.database.PhoneLookupDatabaseComponent;
import com.wintmain.dialer.phonenumbergeoutil.PhoneNumberGeoUtilComponent;
import com.wintmain.dialer.precall.PreCallComponent;
import com.wintmain.dialer.preferredsim.PreferredSimComponent;
import com.wintmain.dialer.preferredsim.suggestion.SimSuggestionComponent;
import com.wintmain.dialer.promotion.PromotionComponent;
import com.wintmain.dialer.simulator.SimulatorComponent;
import com.wintmain.dialer.spam.SpamComponent;
import com.wintmain.dialer.speeddial.loader.UiItemLoaderComponent;
import com.wintmain.dialer.storage.StorageComponent;
import com.wintmain.dialer.strictmode.StrictModeComponent;

/**
 * Base class for the core application-wide component. All variants of the Dialer app should extend
 * from this component.
 */
public interface BaseDialerRootComponent
        extends ActiveCallsComponent.HasComponent,
        BubbleComponent.HasComponent,
        CallLocationComponent.HasComponent,
        CallLogComponent.HasComponent,
        CallLogConfigComponent.HasComponent,
        CallLogDatabaseComponent.HasComponent,
        CallLogUiComponent.HasComponent,
        ConfigProviderComponent.HasComponent,
        CommandLineComponent.HasComponent,
        ContactsComponent.HasComponent,
        DialerExecutorComponent.HasComponent,
        DuoComponent.HasComponent,
        EnrichedCallComponent.HasComponent,
        FeedbackComponent.HasComponent,
        GlidePhotoManagerComponent.HasComponent,
        MapsComponent.HasComponent,
        MetricsComponent.HasComponent,
        PhoneLookupComponent.HasComponent,
        PhoneLookupDatabaseComponent.HasComponent,
        PhoneNumberGeoUtilComponent.HasComponent,
        PreCallComponent.HasComponent,
        PreferredSimComponent.HasComponent,
        PromotionComponent.HasComponent,
        UiItemLoaderComponent.HasComponent,
        SimSuggestionComponent.HasComponent,
        SimulatorComponent.HasComponent,
        SpamComponent.HasComponent,
        SpeakEasyComponent.HasComponent,
        StorageComponent.HasComponent,
        StrictModeComponent.HasComponent,
        VoicemailComponent.HasComponent {}
