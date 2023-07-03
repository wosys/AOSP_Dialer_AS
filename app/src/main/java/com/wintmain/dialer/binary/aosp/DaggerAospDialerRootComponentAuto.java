//package com.android.dialer.binary.aosp;
//
//import android.content.SharedPreferences;
//import android.support.compat.R$id;
//import com.android.bubble.Bubble;
//import com.android.bubble.BubbleComponent;
//import com.android.bubble.stub.BubbleStub_Factory;
//import com.android.dialer.activecalls.ActiveCalls;
//import com.android.dialer.activecalls.ActiveCallsComponent;
//import com.android.dialer.activecalls.impl.ActiveCallsImpl_Factory;
//import com.android.dialer.calllog.AnnotatedCallLogMigrator_Factory;
//import com.android.dialer.calllog.CallLogCacheUpdater_Factory;
//import com.android.dialer.calllog.CallLogComponent;
//import com.android.dialer.calllog.CallLogFramework;
//import com.android.dialer.calllog.CallLogFramework_Factory;
//import com.android.dialer.calllog.CallLogModule_ProvideCallLogDataSourcesFactory;
//import com.android.dialer.calllog.CallLogState_Factory;
//import com.android.dialer.calllog.ClearMissedCalls;
//import com.android.dialer.calllog.ClearMissedCalls_Factory;
//import com.android.dialer.calllog.RefreshAnnotatedCallLogWorker;
//import com.android.dialer.calllog.RefreshAnnotatedCallLogWorker_Factory;
//import com.android.dialer.calllog.config.CallLogConfig;
//import com.android.dialer.calllog.config.CallLogConfigComponent;
//import com.android.dialer.calllog.config.CallLogConfigImpl_Factory;
//import com.android.dialer.calllog.database.AnnotatedCallLogDatabaseHelper;
//import com.android.dialer.calllog.database.AnnotatedCallLogDatabaseHelper_Factory;
//import com.android.dialer.calllog.database.CallLogDatabaseComponent;
//import com.android.dialer.calllog.database.Coalescer;
//import com.android.dialer.calllog.database.Coalescer_Factory;
//import com.android.dialer.calllog.database.MutationApplier_Factory;
//import com.android.dialer.calllog.datasources.phonelookup.PhoneLookupDataSource_Factory;
//import com.android.dialer.calllog.datasources.systemcalllog.SystemCallLogDataSource;
//import com.android.dialer.calllog.datasources.systemcalllog.SystemCallLogDataSource_Factory;
//import com.android.dialer.calllog.datasources.voicemail.VoicemailDataSource_Factory;
//import com.android.dialer.calllog.notifier.RefreshAnnotatedCallLogNotifier;
//import com.android.dialer.calllog.notifier.RefreshAnnotatedCallLogNotifier_Factory;
//import com.android.dialer.calllog.observer.MarkDirtyObserver_Factory;
//import com.android.dialer.calllog.ui.CallLogUiComponent;
//import com.android.dialer.calllog.ui.RealtimeRowProcessor;
//import com.android.dialer.calllog.ui.RealtimeRowProcessor_Factory;
//import com.android.dialer.commandline.Command;
//import com.android.dialer.commandline.CommandLineComponent;
//import com.android.dialer.commandline.CommandLineModule_AospCommandInjector_Factory;
//import com.android.dialer.commandline.CommandLineModule_ProvideCommandSupplierFactory;
//import com.android.dialer.commandline.impl.ActiveCallsCommand_Factory;
//import com.android.dialer.commandline.impl.BlockingCommand_Factory;
//import com.android.dialer.commandline.impl.CallCommand_Factory;
//import com.android.dialer.commandline.impl.Help_Factory;
//import com.android.dialer.commandline.impl.Version_Factory;
//import com.android.dialer.common.concurrent.DefaultDialerExecutorFactory_Factory;
//import com.android.dialer.common.concurrent.DialerExecutorComponent;
//import com.android.dialer.common.concurrent.DialerExecutorFactory;
//import com.android.dialer.common.concurrent.DialerExecutorModule_ProvideBackgroundExecutorFactory;
//import com.android.dialer.common.concurrent.DialerExecutorModule_ProvideLightweightExecutorFactory;
//import com.android.dialer.common.concurrent.DialerExecutorModule_ProvideNonUiSerialExecutorServiceFactory;
//import com.android.dialer.common.concurrent.DialerExecutorModule_ProvideNonUiThreadPoolFactory;
//import com.android.dialer.common.concurrent.DialerExecutorModule_ProvideUiSerialExecutorServiceFactory;
//import com.android.dialer.common.concurrent.DialerExecutorModule_ProvideUiThreadExecutorServiceFactory;
//import com.android.dialer.configprovider.ConfigProvider;
//import com.android.dialer.configprovider.ConfigProviderComponent;
//import com.android.dialer.configprovider.SharedPrefConfigProvider_Factory;
//import com.android.dialer.contacts.ContactsComponent;
//import com.android.dialer.contacts.ContactsModule_ProvideContactDisplayPreferencesFactory;
//import com.android.dialer.contacts.displaypreference.ContactDisplayPreferences;
//import com.android.dialer.contacts.displaypreference.ContactDisplayPreferencesImpl_Factory;
//import com.android.dialer.contacts.hiresphoto.HighResolutionPhotoRequester;
//import com.android.dialer.contacts.hiresphoto.HighResolutionPhotoRequesterImpl_Factory;
//import com.android.dialer.duo.Duo;
//import com.android.dialer.duo.DuoComponent;
//import com.android.dialer.duo.stub.DuoStub_Factory;
//import com.android.dialer.enrichedcall.EnrichedCallComponent;
//import com.android.dialer.enrichedcall.EnrichedCallManager;
//import com.android.dialer.enrichedcall.RcsVideoShareFactory;
//import com.android.dialer.enrichedcall.stub.StubEnrichedCallModule_ProvideEnrichedCallManagerFactory;
//import com.android.dialer.enrichedcall.stub.StubEnrichedCallModule_ProvidesRcsVideoShareFactoryFactory;
//import com.android.dialer.feedback.FeedbackComponent;
//import com.android.dialer.feedback.stub.StubFeedbackModule_ProvideCallFeedbackListenerFactory;
//import com.android.dialer.function.Supplier;
//import com.android.dialer.glidephotomanager.GlidePhotoManager;
//import com.android.dialer.glidephotomanager.GlidePhotoManagerComponent;
//import com.android.dialer.glidephotomanager.impl.GlidePhotoManagerImpl_Factory;
//import com.android.dialer.inject.ContextModule;
//import com.android.dialer.inject.ContextModule_ProvideContextFactory;
//import com.android.dialer.metrics.FutureTimer;
//import com.android.dialer.metrics.FutureTimer_Factory;
//import com.android.dialer.metrics.Metrics;
//import com.android.dialer.metrics.MetricsComponent;
//import com.android.dialer.metrics.StubMetrics;
//import com.android.dialer.metrics.StubMetrics_Factory;
//import com.android.dialer.phonelookup.PhoneLookupComponent;
//import com.android.dialer.phonelookup.PhoneLookupModule_ProvidePhoneLookupListFactory;
//import com.android.dialer.phonelookup.blockednumber.SystemBlockedNumberPhoneLookup_Factory;
//import com.android.dialer.phonelookup.cequint.CequintPhoneLookup_Factory;
//import com.android.dialer.phonelookup.cnap.CnapPhoneLookup_Factory;
//import com.android.dialer.phonelookup.composite.CompositePhoneLookup;
//import com.android.dialer.phonelookup.composite.CompositePhoneLookup_Factory;
//import com.android.dialer.phonelookup.cp2.Cp2DefaultDirectoryPhoneLookup_Factory;
//import com.android.dialer.phonelookup.cp2.Cp2ExtendedDirectoryPhoneLookup_Factory;
//import com.android.dialer.phonelookup.cp2.MissingPermissionsOperations_Factory;
//import com.android.dialer.phonelookup.database.PhoneLookupDatabaseComponent;
//import com.android.dialer.phonelookup.database.PhoneLookupHistoryDatabaseHelper;
//import com.android.dialer.phonelookup.database.PhoneLookupHistoryDatabaseHelper_Factory;
//import com.android.dialer.phonelookup.emergency.EmergencyPhoneLookup_Factory;
//import com.android.dialer.phonelookup.spam.SpamPhoneLookup_Factory;
//import com.android.dialer.phonenumbergeoutil.PhoneNumberGeoUtil;
//import com.android.dialer.phonenumbergeoutil.PhoneNumberGeoUtilComponent;
//import com.android.dialer.phonenumbergeoutil.impl.PhoneNumberGeoUtilImpl_Factory;
//import com.android.dialer.precall.PreCall;
//import com.android.dialer.precall.PreCallAction;
//import com.android.dialer.precall.PreCallComponent;
//import com.android.dialer.precall.impl.CallingAccountSelector_Factory;
//import com.android.dialer.precall.impl.DuoAction_Factory;
//import com.android.dialer.precall.impl.PreCallImpl_Factory;
//import com.android.dialer.precall.impl.PreCallModule_ProvideActionsFactory;
//import com.android.dialer.preferredsim.PreferredAccountWorker;
//import com.android.dialer.preferredsim.PreferredSimComponent;
//import com.android.dialer.preferredsim.impl.PreferredAccountWorkerImpl_Factory;
//import com.android.dialer.preferredsim.suggestion.SimSuggestionComponent;
//import com.android.dialer.preferredsim.suggestion.SuggestionProvider;
//import com.android.dialer.preferredsim.suggestion.stub.StubSuggestionProvider_Factory;
//import com.android.dialer.promotion.PromotionComponent;
//import com.android.dialer.promotion.PromotionManager;
//import com.android.dialer.promotion.PromotionManager_Factory;
//import com.android.dialer.promotion.impl.DuoPromotion_Factory;
//import com.android.dialer.promotion.impl.PromotionModule_ProvidePriorityPromotionListFactory;
//import com.android.dialer.promotion.impl.RttPromotion_Factory;
//import com.android.dialer.simulator.Simulator;
//import com.android.dialer.simulator.SimulatorComponent;
//import com.android.dialer.simulator.SimulatorConnectionsBank;
//import com.android.dialer.simulator.SimulatorEnrichedCall;
//import com.android.dialer.simulator.impl.SimulatorConnectionsBankImpl_Factory;
//import com.android.dialer.simulator.impl.SimulatorImpl_Factory;
//import com.android.dialer.simulator.stub.SimulatorEnrichedCallStub_Factory;
//import com.android.dialer.spam.Spam;
//import com.android.dialer.spam.SpamComponent;
//import com.android.dialer.spam.stub.SpamSettingsStub;
//import com.android.dialer.spam.stub.SpamSettingsStub_Factory;
//import com.android.dialer.spam.stub.SpamStub_Factory;
//import com.android.dialer.speeddial.loader.SpeedDialUiItemMutator;
//import com.android.dialer.speeddial.loader.SpeedDialUiItemMutator_Factory;
//import com.android.dialer.speeddial.loader.UiItemLoaderComponent;
//import com.android.dialer.storage.StorageComponent;
//import com.android.dialer.storage.StorageModule_ProvideUnencryptedSharedPrefsFactory;
//import com.android.dialer.strictmode.DialerStrictMode;
//import com.android.dialer.strictmode.StrictModeComponent;
//import com.android.dialer.strictmode.impl.SystemDialerStrictMode_Factory;
//import com.android.dialer.theme.base.Theme;
//import com.android.dialer.theme.base.ThemeComponent;
//import com.android.dialer.theme.base.impl.AospThemeModule_ProvideThemeModuleFactory;
//import com.android.incallui.call.CallList;
//import com.android.incallui.calllocation.CallLocation;
//import com.android.incallui.calllocation.CallLocationComponent;
//import com.android.incallui.calllocation.stub.StubCallLocationModule_StubCallLocation_Factory;
//import com.android.incallui.maps.Maps;
//import com.android.incallui.maps.MapsComponent;
//import com.android.incallui.maps.stub.StubMapsModule_StubMaps_Factory;
//import com.android.incallui.speakeasy.SpeakEasyCallManagerStub_Factory;
//import com.android.incallui.speakeasy.SpeakEasyComponent;
//import com.android.incallui.speakeasy.StubSpeakEasyModule_ProvideSpeakEasyChipFactory;
//import com.android.voicemail.VoicemailClient;
//import com.android.voicemail.VoicemailComponent;
//import com.android.voicemail.impl.VoicemailModule_ProvideVoicemailClientFactory;
//import com.google.common.base.Optional;
//import com.google.common.collect.ImmutableList;
//import com.google.common.collect.ImmutableMap;
//import com.google.common.util.concurrent.ListeningExecutorService;
//import dagger.internal.DoubleCheck;
//import dagger.internal.MembersInjectors;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.ScheduledExecutorService;
//import javax.inject.Provider;
//
///**
// * 使用Dagger，编译时会自动生成该文件。 该文件xxxAuto只提供参考。
// * 最后binary/aosp下就只有该文件和AospDialerApplication是apk里生效的。
// */
///* loaded from: classes.dex */
//public final class DaggerAospDialerRootComponentAuto implements ActiveCallsComponent.HasComponent,
//  BubbleComponent.HasComponent, CallLocationComponent.HasComponent, CallLogComponent.HasComponent,
//  CallLogConfigComponent.HasComponent, CallLogDatabaseComponent.HasComponent,
//  CallLogUiComponent.HasComponent, ConfigProviderComponent.HasComponent,
//  CommandLineComponent.HasComponent, ContactsComponent.HasComponent,
//  DialerExecutorComponent.HasComponent, DuoComponent.HasComponent,
//  EnrichedCallComponent.HasComponent, FeedbackComponent.HasComponent,
//  GlidePhotoManagerComponent.HasComponent, MapsComponent.HasComponent,
//  MetricsComponent.HasComponent, PhoneLookupComponent.HasComponent,
//  PhoneLookupDatabaseComponent.HasComponent, PhoneNumberGeoUtilComponent.HasComponent,
//  PreCallComponent.HasComponent, PreferredSimComponent.HasComponent,
//  PromotionComponent.HasComponent, UiItemLoaderComponent.HasComponent,
//  SimSuggestionComponent.HasComponent, SimulatorComponent.HasComponent,
//  SpamComponent.HasComponent, SpeakEasyComponent.HasComponent, StorageComponent.HasComponent,
//  StrictModeComponent.HasComponent, ThemeComponent.HasComponent, VoicemailComponent.HasComponent {
//    private ActiveCallsCommand_Factory activeCallsCommandProvider;
//    private Provider<AnnotatedCallLogDatabaseHelper> annotatedCallLogDatabaseHelperProvider;
//    private AnnotatedCallLogMigrator_Factory annotatedCallLogMigratorProvider;
//    private CommandLineModule_AospCommandInjector_Factory aospCommandInjectorProvider;
//    private Provider<DialerStrictMode> bindDialerStrictModeProvider;
//    private Provider<GlidePhotoManager> bindGlidePhotoManagerProvider;
//    private Provider<Maps> bindMapsProvider;
//    private Provider<Metrics> bindMetricsProvider;
//    private Provider<PhoneNumberGeoUtil> bindPhoneNumberGeoUtilProvider;
//    private Provider<Spam> bindSpamProvider;
//    private Provider<SuggestionProvider> bindSuggestionProvider;
//    private Provider<Duo> bindsDuoProvider;
//    private Provider<SimulatorConnectionsBank> bindsSimulatorConnectionsBankProvider;
//    private Provider<SimulatorEnrichedCall> bindsSimulatorEnrichedCallProvider;
//    private Provider<Simulator> bindsSimulatorProvider;
//    private BlockingCommand_Factory blockingCommandProvider;
//    private CallCommand_Factory callCommandProvider;
//    private CallLogCacheUpdater_Factory callLogCacheUpdaterProvider;
//    private Provider<CallLogFramework> callLogFrameworkProvider;
//    private CallLogState_Factory callLogStateProvider;
//    private CallingAccountSelector_Factory callingAccountSelectorProvider;
//    private CequintPhoneLookup_Factory cequintPhoneLookupProvider;
//    private CnapPhoneLookup_Factory cnapPhoneLookupProvider;
//    private CompositePhoneLookup_Factory compositePhoneLookupProvider;
//    private ContactDisplayPreferencesImpl_Factory contactDisplayPreferencesImplProvider;
//    private Cp2DefaultDirectoryPhoneLookup_Factory cp2DefaultDirectoryPhoneLookupProvider;
//    private Cp2ExtendedDirectoryPhoneLookup_Factory cp2ExtendedDirectoryPhoneLookupProvider;
//    private DuoAction_Factory duoActionProvider;
//    private DuoPromotion_Factory duoPromotionProvider;
//    private EmergencyPhoneLookup_Factory emergencyPhoneLookupProvider;
//    private FutureTimer_Factory futureTimerProvider;
//    private GlidePhotoManagerImpl_Factory glidePhotoManagerImplProvider;
//    private Help_Factory helpProvider;
//    private HighResolutionPhotoRequesterImpl_Factory highResolutionPhotoRequesterImplProvider;
//    private MarkDirtyObserver_Factory markDirtyObserverProvider;
//    private MissingPermissionsOperations_Factory missingPermissionsOperationsProvider;
//    private MutationApplier_Factory mutationApplierProvider;
//    private PhoneLookupDataSource_Factory phoneLookupDataSourceProvider;
//    private Provider<PhoneLookupHistoryDatabaseHelper> phoneLookupHistoryDatabaseHelperProvider;
//    private PreCallImpl_Factory preCallImplProvider;
//    private PreferredAccountWorkerImpl_Factory preferredAccountWorkerImplProvider;
//    private PreCallModule_ProvideActionsFactory provideActionsProvider;
//    private Provider<ListeningExecutorService> provideBackgroundExecutorProvider;
//    private StubFeedbackModule_ProvideCallFeedbackListenerFactory provideCallFeedbackListenerProvider;
//    private CallLogModule_ProvideCallLogDataSourcesFactory provideCallLogDataSourcesProvider;
//    private CommandLineModule_ProvideCommandSupplierFactory provideCommandSupplierProvider;
//    private ContactsModule_ProvideContactDisplayPreferencesFactory provideContactDisplayPreferencesProvider;
//    private ContextModule_ProvideContextFactory provideContextProvider;
//    private Provider<EnrichedCallManager> provideEnrichedCallManagerProvider;
//    private Provider<ListeningExecutorService> provideLightweightExecutorProvider;
//    private Provider<ScheduledExecutorService> provideNonUiSerialExecutorServiceProvider;
//    private Provider<ExecutorService> provideNonUiThreadPoolProvider;
//    private PhoneLookupModule_ProvidePhoneLookupListFactory providePhoneLookupListProvider;
//    private PromotionModule_ProvidePriorityPromotionListFactory providePriorityPromotionListProvider;
//    private AospThemeModule_ProvideThemeModuleFactory provideThemeModuleProvider;
//    private Provider<ScheduledExecutorService> provideUiSerialExecutorServiceProvider;
//    private Provider<ListeningExecutorService> provideUiThreadExecutorServiceProvider;
//    private Provider<SharedPreferences> provideUnencryptedSharedPrefsProvider;
//    private Provider<VoicemailClient> provideVoicemailClientProvider;
//    private Provider<RcsVideoShareFactory> providesRcsVideoShareFactoryProvider;
//    private Provider<RefreshAnnotatedCallLogNotifier> refreshAnnotatedCallLogNotifierProvider;
//    private Provider<RefreshAnnotatedCallLogWorker> refreshAnnotatedCallLogWorkerProvider;
//    private RttPromotion_Factory rttPromotionProvider;
//    private SharedPrefConfigProvider_Factory sharedPrefConfigProvider;
//    private SpamPhoneLookup_Factory spamPhoneLookupProvider;
//    private SpamStub_Factory spamStubProvider;
//    private Provider<SpeedDialUiItemMutator> speedDialUiItemMutatorProvider;
//    private Provider<StubMetrics> stubMetricsProvider;
//    private SystemBlockedNumberPhoneLookup_Factory systemBlockedNumberPhoneLookupProvider;
//    private Provider<SystemCallLogDataSource> systemCallLogDataSourceProvider;
//    private Provider<HighResolutionPhotoRequester> toHighResolutionPhotoRequesterImplProvider;
//    private Provider<ConfigProvider> toProvider2;
//    private Provider<PreferredAccountWorker> toProvider3;
//    private Provider<PreCall> toProvider4;
//    private Version_Factory versionProvider;
//    private VoicemailDataSource_Factory voicemailDataSourceProvider;
//    private Provider<ActiveCalls> toProvider = DoubleCheck.provider(ActiveCallsImpl_Factory.INSTANCE);
//    private Provider<Bubble> bindsBubbleProvider = DoubleCheck.provider(BubbleStub_Factory.INSTANCE);
//
//    /* loaded from: classes.dex */
//    private final class ActiveCallsComponentImpl extends ActiveCallsComponent {
//        ActiveCallsComponentImpl() {
//        }
//
//        @Override // com.android.dialer.activecalls.ActiveCallsComponent
//        public final ActiveCalls activeCalls() {
//            return (ActiveCalls) DaggerAospDialerRootComponent.this.toProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class BubbleComponentImpl extends BubbleComponent {
//        BubbleComponentImpl() {
//        }
//
//        @Override // com.android.bubble.BubbleComponent
//        public final Bubble getBubble() {
//            return (Bubble) DaggerAospDialerRootComponent.this.bindsBubbleProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    public static final class Builder {
//        private ContextModule contextModule;
//
//        public final DaggerAospDialerRootComponent build() {
//            if (this.contextModule != null) {
//                return new DaggerAospDialerRootComponent(this);
//            }
//            throw new IllegalStateException(ContextModule.class.getCanonicalName() + " must be set");
//        }
//
//        public final void contextModule(ContextModule contextModule) {
//            this.contextModule = contextModule;
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class CallLocationComponentImpl extends CallLocationComponent {
//        private StubCallLocationModule_StubCallLocation_Factory bindCallLocationProvider = StubCallLocationModule_StubCallLocation_Factory.INSTANCE;
//
//        @Override // com.android.incallui.calllocation.CallLocationComponent
//        public final CallLocation getCallLocation() {
//            return (CallLocation) this.bindCallLocationProvider.get();
//        }
//
//        CallLocationComponentImpl() {
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class CallLogComponentImpl extends CallLogComponent {
//        private ClearMissedCalls_Factory clearMissedCallsProvider;
//
//        CallLogComponentImpl() {
//            this.clearMissedCallsProvider = new ClearMissedCalls_Factory(DaggerAospDialerRootComponent.this.provideContextProvider, DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider, DaggerAospDialerRootComponent.this.provideUiThreadExecutorServiceProvider);
//        }
//
//        @Override // com.android.dialer.calllog.CallLogComponent
//        public final CallLogFramework callLogFramework() {
//            return (CallLogFramework) DaggerAospDialerRootComponent.this.callLogFrameworkProvider.get();
//        }
//
//        @Override // com.android.dialer.calllog.CallLogComponent
//        public final ClearMissedCalls getClearMissedCalls() {
//            return (ClearMissedCalls) this.clearMissedCallsProvider.get();
//        }
//
//        @Override // com.android.dialer.calllog.CallLogComponent
//        public final RefreshAnnotatedCallLogNotifier getRefreshAnnotatedCallLogNotifier() {
//            return (RefreshAnnotatedCallLogNotifier) DaggerAospDialerRootComponent.this.refreshAnnotatedCallLogNotifierProvider.get();
//        }
//
//        @Override // com.android.dialer.calllog.CallLogComponent
//        public final RefreshAnnotatedCallLogWorker getRefreshAnnotatedCallLogWorker() {
//            return (RefreshAnnotatedCallLogWorker) DaggerAospDialerRootComponent.this.refreshAnnotatedCallLogWorkerProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class CallLogConfigComponentImpl extends CallLogConfigComponent {
//        private CallLogConfigImpl_Factory callLogConfigImplProvider;
//        private CallLogConfigImpl_Factory toProvider;
//
//        @Override // com.android.dialer.calllog.config.CallLogConfigComponent
//        public final CallLogConfig callLogConfig() {
//            return (CallLogConfig) this.toProvider.get();
//        }
//
//        CallLogConfigComponentImpl(DaggerAospDialerRootComponent daggerAospDialerRootComponent) {
//            CallLogConfigImpl_Factory callLogConfigImpl_Factory = new CallLogConfigImpl_Factory(daggerAospDialerRootComponent.provideContextProvider, daggerAospDialerRootComponent.callLogFrameworkProvider, daggerAospDialerRootComponent.provideUnencryptedSharedPrefsProvider, daggerAospDialerRootComponent.toProvider2, daggerAospDialerRootComponent.provideBackgroundExecutorProvider);
//            this.callLogConfigImplProvider = callLogConfigImpl_Factory;
//            this.toProvider = callLogConfigImpl_Factory;
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class CallLogDatabaseComponentImpl extends CallLogDatabaseComponent {
//        private Coalescer_Factory coalescerProvider;
//
//        CallLogDatabaseComponentImpl() {
//            this.coalescerProvider = new Coalescer_Factory(DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider, DaggerAospDialerRootComponent.this.futureTimerProvider);
//        }
//
//        @Override // com.android.dialer.calllog.database.CallLogDatabaseComponent
//        public final AnnotatedCallLogDatabaseHelper annotatedCallLogDatabaseHelper() {
//            return (AnnotatedCallLogDatabaseHelper) DaggerAospDialerRootComponent.this.annotatedCallLogDatabaseHelperProvider.get();
//        }
//
//        @Override // com.android.dialer.calllog.database.CallLogDatabaseComponent
//        public final Coalescer coalescer() {
//            return (Coalescer) this.coalescerProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class CallLogUiComponentImpl extends CallLogUiComponent {
//        private RealtimeRowProcessor_Factory realtimeRowProcessorProvider;
//
//        @Override // com.android.dialer.calllog.ui.CallLogUiComponent
//        public final RealtimeRowProcessor realtimeRowProcessor() {
//            return (RealtimeRowProcessor) this.realtimeRowProcessorProvider.get();
//        }
//
//        CallLogUiComponentImpl(DaggerAospDialerRootComponent daggerAospDialerRootComponent) {
//            this.realtimeRowProcessorProvider = new RealtimeRowProcessor_Factory(daggerAospDialerRootComponent.provideContextProvider, daggerAospDialerRootComponent.provideUiThreadExecutorServiceProvider, daggerAospDialerRootComponent.provideBackgroundExecutorProvider, daggerAospDialerRootComponent.compositePhoneLookupProvider);
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class CommandLineComponentImpl extends CommandLineComponent {
//        CommandLineComponentImpl() {
//        }
//
//        @Override // com.android.dialer.commandline.CommandLineComponent
//        public final Supplier<ImmutableMap<String, Command>> commandSupplier() {
//            return (Supplier) DaggerAospDialerRootComponent.this.provideCommandSupplierProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class ConfigProviderComponentImpl extends ConfigProviderComponent {
//        ConfigProviderComponentImpl() {
//        }
//
//        @Override // com.android.dialer.configprovider.ConfigProviderComponent
//        public final ConfigProvider getConfigProvider() {
//            return (ConfigProvider) DaggerAospDialerRootComponent.this.toProvider2.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class ContactsComponentImpl extends ContactsComponent {
//        private HighResolutionPhotoRequesterImpl_Factory highResolutionPhotoRequesterImplProvider;
//        private HighResolutionPhotoRequesterImpl_Factory toHighResolutionPhotoRequesterImplProvider;
//
//        ContactsComponentImpl() {
//            HighResolutionPhotoRequesterImpl_Factory highResolutionPhotoRequesterImpl_Factory = new HighResolutionPhotoRequesterImpl_Factory(DaggerAospDialerRootComponent.this.provideContextProvider, DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider);
//            this.highResolutionPhotoRequesterImplProvider = highResolutionPhotoRequesterImpl_Factory;
//            this.toHighResolutionPhotoRequesterImplProvider = highResolutionPhotoRequesterImpl_Factory;
//        }
//
//        @Override // com.android.dialer.contacts.ContactsComponent
//        public final ContactDisplayPreferences contactDisplayPreferences() {
//            return (ContactDisplayPreferences) DaggerAospDialerRootComponent.this.provideContactDisplayPreferencesProvider.get();
//        }
//
//        @Override // com.android.dialer.contacts.ContactsComponent
//        public final HighResolutionPhotoRequester highResolutionPhotoLoader() {
//            return (HighResolutionPhotoRequester) this.toHighResolutionPhotoRequesterImplProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class DialerExecutorComponentImpl extends DialerExecutorComponent {
//        private DefaultDialerExecutorFactory_Factory bindDialerExecutorFactoryProvider;
//        private DefaultDialerExecutorFactory_Factory defaultDialerExecutorFactoryProvider;
//
//        DialerExecutorComponentImpl() {
//            DefaultDialerExecutorFactory_Factory defaultDialerExecutorFactory_Factory = new DefaultDialerExecutorFactory_Factory(DaggerAospDialerRootComponent.this.provideNonUiThreadPoolProvider, DaggerAospDialerRootComponent.this.provideNonUiSerialExecutorServiceProvider, DaggerAospDialerRootComponent.this.provideUiSerialExecutorServiceProvider);
//            this.defaultDialerExecutorFactoryProvider = defaultDialerExecutorFactory_Factory;
//            this.bindDialerExecutorFactoryProvider = defaultDialerExecutorFactory_Factory;
//        }
//
//        @Override // com.android.dialer.common.concurrent.DialerExecutorComponent
//        public final ListeningExecutorService backgroundExecutor() {
//            return (ListeningExecutorService) DaggerAospDialerRootComponent.this.provideBackgroundExecutorProvider.get();
//        }
//
//        @Override // com.android.dialer.common.concurrent.DialerExecutorComponent
//        public final DialerExecutorFactory dialerExecutorFactory() {
//            return (DialerExecutorFactory) this.bindDialerExecutorFactoryProvider.get();
//        }
//
//        @Override // com.android.dialer.common.concurrent.DialerExecutorComponent
//        public final ListeningExecutorService lightweightExecutor() {
//            return (ListeningExecutorService) DaggerAospDialerRootComponent.this.provideLightweightExecutorProvider.get();
//        }
//
//        @Override // com.android.dialer.common.concurrent.DialerExecutorComponent
//        public final ListeningExecutorService uiExecutor() {
//            return (ListeningExecutorService) DaggerAospDialerRootComponent.this.provideUiThreadExecutorServiceProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class DuoComponentImpl extends DuoComponent {
//        DuoComponentImpl() {
//        }
//
//        @Override // com.android.dialer.duo.DuoComponent
//        public final Duo getDuo() {
//            return (Duo) DaggerAospDialerRootComponent.this.bindsDuoProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class EnrichedCallComponentImpl extends EnrichedCallComponent {
//        EnrichedCallComponentImpl() {
//        }
//
//        @Override // com.android.dialer.enrichedcall.EnrichedCallComponent
//        public final EnrichedCallManager getEnrichedCallManager() {
//            return (EnrichedCallManager) DaggerAospDialerRootComponent.this.provideEnrichedCallManagerProvider.get();
//        }
//
//        @Override // com.android.dialer.enrichedcall.EnrichedCallComponent
//        public final RcsVideoShareFactory getRcsVideoShareFactory() {
//            return (RcsVideoShareFactory) DaggerAospDialerRootComponent.this.providesRcsVideoShareFactoryProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class FeedbackComponentImpl extends FeedbackComponent {
//        FeedbackComponentImpl() {
//        }
//
//        @Override // com.android.dialer.feedback.FeedbackComponent
//        public final CallList.Listener getCallFeedbackListener() {
//            return (CallList.Listener) DaggerAospDialerRootComponent.this.provideCallFeedbackListenerProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class GlidePhotoManagerComponentImpl extends GlidePhotoManagerComponent {
//        GlidePhotoManagerComponentImpl() {
//        }
//
//        @Override // com.android.dialer.glidephotomanager.GlidePhotoManagerComponent
//        public final GlidePhotoManager glidePhotoManager() {
//            return (GlidePhotoManager) DaggerAospDialerRootComponent.this.bindGlidePhotoManagerProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class MapsComponentImpl extends MapsComponent {
//        MapsComponentImpl() {
//        }
//
//        @Override // com.android.incallui.maps.MapsComponent
//        public final Maps getMaps() {
//            return (Maps) DaggerAospDialerRootComponent.this.bindMapsProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class MetricsComponentImpl extends MetricsComponent {
//        MetricsComponentImpl() {
//        }
//
//        @Override // com.android.dialer.metrics.MetricsComponent
//        public final FutureTimer futureTimer() {
//            return (FutureTimer) DaggerAospDialerRootComponent.this.futureTimerProvider.get();
//        }
//
//        @Override // com.android.dialer.metrics.MetricsComponent
//        public final Metrics metrics() {
//            return (Metrics) DaggerAospDialerRootComponent.this.bindMetricsProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class PhoneLookupComponentImpl extends PhoneLookupComponent {
//        PhoneLookupComponentImpl() {
//        }
//
//        @Override // com.android.dialer.phonelookup.PhoneLookupComponent
//        public final CompositePhoneLookup compositePhoneLookup() {
//            return (CompositePhoneLookup) DaggerAospDialerRootComponent.this.compositePhoneLookupProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class PhoneLookupDatabaseComponentImpl extends PhoneLookupDatabaseComponent {
//        PhoneLookupDatabaseComponentImpl() {
//        }
//
//        @Override // com.android.dialer.phonelookup.database.PhoneLookupDatabaseComponent
//        public final PhoneLookupHistoryDatabaseHelper phoneLookupHistoryDatabaseHelper() {
//            return (PhoneLookupHistoryDatabaseHelper) DaggerAospDialerRootComponent.this.phoneLookupHistoryDatabaseHelperProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class PhoneNumberGeoUtilComponentImpl extends PhoneNumberGeoUtilComponent {
//        PhoneNumberGeoUtilComponentImpl() {
//        }
//
//        @Override // com.android.dialer.phonenumbergeoutil.PhoneNumberGeoUtilComponent
//        public final PhoneNumberGeoUtil getPhoneNumberGeoUtil() {
//            return (PhoneNumberGeoUtil) DaggerAospDialerRootComponent.this.bindPhoneNumberGeoUtilProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class PreCallComponentImpl extends PreCallComponent {
//        PreCallComponentImpl() {
//        }
//
//        @Override // com.android.dialer.precall.PreCallComponent
//        public final ImmutableList<PreCallAction> createActions() {
//            return (ImmutableList) DaggerAospDialerRootComponent.this.provideActionsProvider.get();
//        }
//
//        @Override // com.android.dialer.precall.PreCallComponent
//        public final PreCall getPreCall() {
//            return (PreCall) DaggerAospDialerRootComponent.this.toProvider4.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class PreferredSimComponentImpl extends PreferredSimComponent {
//        PreferredSimComponentImpl() {
//        }
//
//        @Override // com.android.dialer.preferredsim.PreferredSimComponent
//        public final PreferredAccountWorker preferredAccountWorker() {
//            return (PreferredAccountWorker) DaggerAospDialerRootComponent.this.toProvider3.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class PromotionComponentImpl extends PromotionComponent {
//        private PromotionManager_Factory promotionManagerProvider;
//
//        @Override // com.android.dialer.promotion.PromotionComponent
//        public final PromotionManager promotionManager() {
//            return (PromotionManager) this.promotionManagerProvider.get();
//        }
//
//        PromotionComponentImpl(DaggerAospDialerRootComponent daggerAospDialerRootComponent) {
//            this.promotionManagerProvider = new PromotionManager_Factory(daggerAospDialerRootComponent.providePriorityPromotionListProvider);
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class SimSuggestionComponentImpl extends SimSuggestionComponent {
//        SimSuggestionComponentImpl() {
//        }
//
//        @Override // com.android.dialer.preferredsim.suggestion.SimSuggestionComponent
//        public final SuggestionProvider getSuggestionProvider() {
//            return (SuggestionProvider) DaggerAospDialerRootComponent.this.bindSuggestionProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class SimulatorComponentImpl extends SimulatorComponent {
//        SimulatorComponentImpl() {
//        }
//
//        @Override // com.android.dialer.simulator.SimulatorComponent
//        public final Simulator getSimulator() {
//            return (Simulator) DaggerAospDialerRootComponent.this.bindsSimulatorProvider.get();
//        }
//
//        @Override // com.android.dialer.simulator.SimulatorComponent
//        public final SimulatorConnectionsBank getSimulatorConnectionsBank() {
//            return (SimulatorConnectionsBank) DaggerAospDialerRootComponent.this.bindsSimulatorConnectionsBankProvider.get();
//        }
//
//        @Override // com.android.dialer.simulator.SimulatorComponent
//        public final SimulatorEnrichedCall getSimulatorEnrichedCall() {
//            return (SimulatorEnrichedCall) DaggerAospDialerRootComponent.this.bindsSimulatorEnrichedCallProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class SpamComponentImpl extends SpamComponent {
//        private SpamSettingsStub_Factory bindSpamSettingsProvider = SpamSettingsStub_Factory.INSTANCE;
//
//        SpamComponentImpl() {
//        }
//
//        @Override // com.android.dialer.spam.SpamComponent
//        public final Spam spam() {
//            return (Spam) DaggerAospDialerRootComponent.this.bindSpamProvider.get();
//        }
//
//        @Override // com.android.dialer.spam.SpamComponent
//        public final SpamSettingsStub spamSettings() {
//            this.bindSpamSettingsProvider.getClass();
//            return new SpamSettingsStub();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class SpeakEasyComponentImpl extends SpeakEasyComponent {
//        private SpeakEasyCallManagerStub_Factory bindsSpeakEasyProvider = SpeakEasyCallManagerStub_Factory.INSTANCE;
//
//        @Override // com.android.incallui.speakeasy.SpeakEasyComponent
//        public final R$id speakEasyCallManager() {
//            this.bindsSpeakEasyProvider.getClass();
//            return new R$id();
//        }
//
//        @Override // com.android.incallui.speakeasy.SpeakEasyComponent
//        public final Optional<Integer> speakEasyChip() {
//            return (Optional) StubSpeakEasyModule_ProvideSpeakEasyChipFactory.INSTANCE.get();
//        }
//
//        SpeakEasyComponentImpl() {
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class StorageComponentImpl extends StorageComponent {
//        StorageComponentImpl() {
//        }
//
//        @Override // com.android.dialer.storage.StorageComponent
//        public final SharedPreferences unencryptedSharedPrefs() {
//            return (SharedPreferences) DaggerAospDialerRootComponent.this.provideUnencryptedSharedPrefsProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class StrictModeComponentImpl extends StrictModeComponent {
//        StrictModeComponentImpl() {
//        }
//
//        @Override // com.android.dialer.strictmode.StrictModeComponent
//        public final DialerStrictMode getDialerStrictMode() {
//            return (DialerStrictMode) DaggerAospDialerRootComponent.this.bindDialerStrictModeProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class ThemeComponentImpl extends ThemeComponent {
//        ThemeComponentImpl() {
//        }
//
//        @Override // com.android.dialer.theme.base.ThemeComponent
//        public final Theme theme() {
//            return (Theme) DaggerAospDialerRootComponent.this.provideThemeModuleProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class UiItemLoaderComponentImpl extends UiItemLoaderComponent {
//        UiItemLoaderComponentImpl() {
//        }
//
//        @Override // com.android.dialer.speeddial.loader.UiItemLoaderComponent
//        public final SpeedDialUiItemMutator speedDialUiItemMutator() {
//            return (SpeedDialUiItemMutator) DaggerAospDialerRootComponent.this.speedDialUiItemMutatorProvider.get();
//        }
//    }
//
//    /* loaded from: classes.dex */
//    private final class VoicemailComponentImpl extends VoicemailComponent {
//        VoicemailComponentImpl() {
//        }
//
//        @Override // com.android.voicemail.VoicemailComponent
//        public final VoicemailClient getVoicemailClient() {
//            return (VoicemailClient) DaggerAospDialerRootComponent.this.provideVoicemailClientProvider.get();
//        }
//    }
//
//    DaggerAospDialerRootComponent(Builder builder) {
//        this.provideContextProvider = new ContextModule_ProvideContextFactory(builder.contextModule);
//        Provider<ExecutorService> provider = DoubleCheck.provider(DialerExecutorModule_ProvideNonUiThreadPoolFactory.INSTANCE);
//        this.provideNonUiThreadPoolProvider = provider;
//        this.provideBackgroundExecutorProvider = DoubleCheck.provider(new DialerExecutorModule_ProvideBackgroundExecutorFactory(provider));
//        Provider<SharedPreferences> provider2 = DoubleCheck.provider(new StorageModule_ProvideUnencryptedSharedPrefsFactory(this.provideContextProvider));
//        this.provideUnencryptedSharedPrefsProvider = provider2;
//        this.refreshAnnotatedCallLogNotifierProvider = DoubleCheck.provider(new RefreshAnnotatedCallLogNotifier_Factory(this.provideContextProvider, provider2));
//        this.markDirtyObserverProvider = new MarkDirtyObserver_Factory(MembersInjectors.noOp(), this.refreshAnnotatedCallLogNotifierProvider);
//        this.annotatedCallLogDatabaseHelperProvider = DoubleCheck.provider(new AnnotatedCallLogDatabaseHelper_Factory(MembersInjectors.noOp(), this.provideContextProvider, this.provideBackgroundExecutorProvider));
//        Provider<Duo> provider3 = DoubleCheck.provider(DuoStub_Factory.INSTANCE);
//        this.bindsDuoProvider = provider3;
//        this.systemCallLogDataSourceProvider = DoubleCheck.provider(new SystemCallLogDataSource_Factory(this.provideContextProvider, this.provideBackgroundExecutorProvider, this.markDirtyObserverProvider, this.provideUnencryptedSharedPrefsProvider, this.annotatedCallLogDatabaseHelperProvider, provider3));
//        Provider<ListeningExecutorService> provider4 = DoubleCheck.provider(new DialerExecutorModule_ProvideLightweightExecutorFactory());
//        this.provideLightweightExecutorProvider = provider4;
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory = this.provideContextProvider;
//        Provider<ListeningExecutorService> provider5 = this.provideBackgroundExecutorProvider;
//        this.cequintPhoneLookupProvider = new CequintPhoneLookup_Factory(contextModule_ProvideContextFactory, provider5, provider4);
//        this.cnapPhoneLookupProvider = new CnapPhoneLookup_Factory(contextModule_ProvideContextFactory, provider5);
//        SharedPrefConfigProvider_Factory sharedPrefConfigProvider_Factory = new SharedPrefConfigProvider_Factory(this.provideUnencryptedSharedPrefsProvider);
//        this.sharedPrefConfigProvider = sharedPrefConfigProvider_Factory;
//        Provider<ConfigProvider> provider6 = DoubleCheck.provider(sharedPrefConfigProvider_Factory);
//        this.toProvider2 = provider6;
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory2 = this.provideContextProvider;
//        Provider<ListeningExecutorService> provider7 = this.provideBackgroundExecutorProvider;
//        Provider<ListeningExecutorService> provider8 = this.provideLightweightExecutorProvider;
//        MissingPermissionsOperations_Factory missingPermissionsOperations_Factory = new MissingPermissionsOperations_Factory(contextModule_ProvideContextFactory2, provider7, provider8);
//        this.missingPermissionsOperationsProvider = missingPermissionsOperations_Factory;
//        this.cp2DefaultDirectoryPhoneLookupProvider = new Cp2DefaultDirectoryPhoneLookup_Factory(contextModule_ProvideContextFactory2, this.provideUnencryptedSharedPrefsProvider, provider7, provider8, provider6, missingPermissionsOperations_Factory);
//        Provider<ScheduledExecutorService> provider9 = DoubleCheck.provider(DialerExecutorModule_ProvideNonUiSerialExecutorServiceFactory.INSTANCE);
//        this.provideNonUiSerialExecutorServiceProvider = provider9;
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory3 = this.provideContextProvider;
//        Provider<ListeningExecutorService> provider10 = this.provideBackgroundExecutorProvider;
//        Provider<ListeningExecutorService> provider11 = this.provideLightweightExecutorProvider;
//        Cp2ExtendedDirectoryPhoneLookup_Factory cp2ExtendedDirectoryPhoneLookup_Factory = new Cp2ExtendedDirectoryPhoneLookup_Factory(contextModule_ProvideContextFactory3, provider10, provider11, provider9, this.toProvider2, this.missingPermissionsOperationsProvider);
//        this.cp2ExtendedDirectoryPhoneLookupProvider = cp2ExtendedDirectoryPhoneLookup_Factory;
//        EmergencyPhoneLookup_Factory emergencyPhoneLookup_Factory = new EmergencyPhoneLookup_Factory(contextModule_ProvideContextFactory3, provider10);
//        this.emergencyPhoneLookupProvider = emergencyPhoneLookup_Factory;
//        SystemBlockedNumberPhoneLookup_Factory systemBlockedNumberPhoneLookup_Factory = new SystemBlockedNumberPhoneLookup_Factory(contextModule_ProvideContextFactory3, provider10, this.markDirtyObserverProvider);
//        this.systemBlockedNumberPhoneLookupProvider = systemBlockedNumberPhoneLookup_Factory;
//        SpamStub_Factory spamStub_Factory = new SpamStub_Factory(provider10);
//        this.spamStubProvider = spamStub_Factory;
//        this.bindSpamProvider = spamStub_Factory;
//        SpamPhoneLookup_Factory spamPhoneLookup_Factory = new SpamPhoneLookup_Factory(provider10, provider11, this.provideUnencryptedSharedPrefsProvider, spamStub_Factory);
//        this.spamPhoneLookupProvider = spamPhoneLookup_Factory;
//        this.providePhoneLookupListProvider = new PhoneLookupModule_ProvidePhoneLookupListFactory(this.cequintPhoneLookupProvider, this.cnapPhoneLookupProvider, this.cp2DefaultDirectoryPhoneLookupProvider, cp2ExtendedDirectoryPhoneLookup_Factory, emergencyPhoneLookup_Factory, systemBlockedNumberPhoneLookup_Factory, spamPhoneLookup_Factory);
//        Provider<StubMetrics> provider12 = DoubleCheck.provider(StubMetrics_Factory.INSTANCE);
//        this.stubMetricsProvider = provider12;
//        this.bindMetricsProvider = provider12;
//        Provider<ListeningExecutorService> provider13 = this.provideLightweightExecutorProvider;
//        FutureTimer_Factory futureTimer_Factory = new FutureTimer_Factory(provider12, provider13);
//        this.futureTimerProvider = futureTimer_Factory;
//        CallLogState_Factory callLogState_Factory = new CallLogState_Factory(this.provideUnencryptedSharedPrefsProvider, this.provideBackgroundExecutorProvider);
//        this.callLogStateProvider = callLogState_Factory;
//        this.compositePhoneLookupProvider = new CompositePhoneLookup_Factory(this.provideContextProvider, this.providePhoneLookupListProvider, futureTimer_Factory, callLogState_Factory, provider13);
//        Provider<PhoneLookupHistoryDatabaseHelper> provider14 = DoubleCheck.provider(new PhoneLookupHistoryDatabaseHelper_Factory(MembersInjectors.noOp(), this.provideContextProvider, this.provideBackgroundExecutorProvider));
//        this.phoneLookupHistoryDatabaseHelperProvider = provider14;
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory4 = this.provideContextProvider;
//        CompositePhoneLookup_Factory compositePhoneLookup_Factory = this.compositePhoneLookupProvider;
//        Provider<ListeningExecutorService> provider15 = this.provideBackgroundExecutorProvider;
//        Provider<ListeningExecutorService> provider16 = this.provideLightweightExecutorProvider;
//        PhoneLookupDataSource_Factory phoneLookupDataSource_Factory = new PhoneLookupDataSource_Factory(contextModule_ProvideContextFactory4, compositePhoneLookup_Factory, provider15, provider16, provider14);
//        this.phoneLookupDataSourceProvider = phoneLookupDataSource_Factory;
//        VoicemailDataSource_Factory voicemailDataSource_Factory = new VoicemailDataSource_Factory(contextModule_ProvideContextFactory4, provider15);
//        this.voicemailDataSourceProvider = voicemailDataSource_Factory;
//        CallLogModule_ProvideCallLogDataSourcesFactory callLogModule_ProvideCallLogDataSourcesFactory = new CallLogModule_ProvideCallLogDataSourcesFactory(this.systemCallLogDataSourceProvider, phoneLookupDataSource_Factory, voicemailDataSource_Factory);
//        this.provideCallLogDataSourcesProvider = callLogModule_ProvideCallLogDataSourcesFactory;
//        MutationApplier_Factory mutationApplier_Factory = new MutationApplier_Factory(provider15);
//        this.mutationApplierProvider = mutationApplier_Factory;
//        CallLogState_Factory callLogState_Factory2 = this.callLogStateProvider;
//        CallLogCacheUpdater_Factory callLogCacheUpdater_Factory = new CallLogCacheUpdater_Factory(contextModule_ProvideContextFactory4, provider15, callLogState_Factory2);
//        this.callLogCacheUpdaterProvider = callLogCacheUpdater_Factory;
//        Provider<RefreshAnnotatedCallLogWorker> provider17 = DoubleCheck.provider(new RefreshAnnotatedCallLogWorker_Factory(contextModule_ProvideContextFactory4, callLogModule_ProvideCallLogDataSourcesFactory, this.provideUnencryptedSharedPrefsProvider, mutationApplier_Factory, this.futureTimerProvider, callLogState_Factory2, callLogCacheUpdater_Factory, provider15, provider16));
//        this.refreshAnnotatedCallLogWorkerProvider = provider17;
//        this.annotatedCallLogMigratorProvider = new AnnotatedCallLogMigrator_Factory(this.provideUnencryptedSharedPrefsProvider, this.provideBackgroundExecutorProvider, provider17);
//        Provider<ListeningExecutorService> provider18 = DoubleCheck.provider(DialerExecutorModule_ProvideUiThreadExecutorServiceFactory.INSTANCE);
//        this.provideUiThreadExecutorServiceProvider = provider18;
//        this.callLogFrameworkProvider = DoubleCheck.provider(new CallLogFramework_Factory(this.provideContextProvider, this.provideCallLogDataSourcesProvider, this.annotatedCallLogMigratorProvider, provider18, this.callLogStateProvider));
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory5 = this.provideContextProvider;
//        Help_Factory help_Factory = new Help_Factory(contextModule_ProvideContextFactory5);
//        this.helpProvider = help_Factory;
//        Version_Factory version_Factory = new Version_Factory(contextModule_ProvideContextFactory5);
//        this.versionProvider = version_Factory;
//        BlockingCommand_Factory blockingCommand_Factory = new BlockingCommand_Factory(contextModule_ProvideContextFactory5, this.provideBackgroundExecutorProvider);
//        this.blockingCommandProvider = blockingCommand_Factory;
//        CallCommand_Factory callCommand_Factory = new CallCommand_Factory(contextModule_ProvideContextFactory5);
//        this.callCommandProvider = callCommand_Factory;
//        ActiveCallsCommand_Factory activeCallsCommand_Factory = new ActiveCallsCommand_Factory(contextModule_ProvideContextFactory5);
//        this.activeCallsCommandProvider = activeCallsCommand_Factory;
//        CommandLineModule_AospCommandInjector_Factory commandLineModule_AospCommandInjector_Factory = new CommandLineModule_AospCommandInjector_Factory(help_Factory, version_Factory, blockingCommand_Factory, callCommand_Factory, activeCallsCommand_Factory);
//        this.aospCommandInjectorProvider = commandLineModule_AospCommandInjector_Factory;
//        this.provideCommandSupplierProvider = new CommandLineModule_ProvideCommandSupplierFactory(commandLineModule_AospCommandInjector_Factory);
//        ContactDisplayPreferencesImpl_Factory contactDisplayPreferencesImpl_Factory = new ContactDisplayPreferencesImpl_Factory(contextModule_ProvideContextFactory5);
//        this.contactDisplayPreferencesImplProvider = contactDisplayPreferencesImpl_Factory;
//        this.provideContactDisplayPreferencesProvider = new ContactsModule_ProvideContactDisplayPreferencesFactory(contextModule_ProvideContextFactory5, contactDisplayPreferencesImpl_Factory);
//        this.provideUiSerialExecutorServiceProvider = DoubleCheck.provider(DialerExecutorModule_ProvideUiSerialExecutorServiceFactory.INSTANCE);
//        this.provideEnrichedCallManagerProvider = DoubleCheck.provider(StubEnrichedCallModule_ProvideEnrichedCallManagerFactory.INSTANCE);
//        this.providesRcsVideoShareFactoryProvider = DoubleCheck.provider(StubEnrichedCallModule_ProvidesRcsVideoShareFactoryFactory.INSTANCE);
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory6 = this.provideContextProvider;
//        this.provideCallFeedbackListenerProvider = new StubFeedbackModule_ProvideCallFeedbackListenerFactory(contextModule_ProvideContextFactory6);
//        GlidePhotoManagerImpl_Factory glidePhotoManagerImpl_Factory = new GlidePhotoManagerImpl_Factory(contextModule_ProvideContextFactory6);
//        this.glidePhotoManagerImplProvider = glidePhotoManagerImpl_Factory;
//        this.bindGlidePhotoManagerProvider = DoubleCheck.provider(glidePhotoManagerImpl_Factory);
//        this.bindMapsProvider = DoubleCheck.provider(StubMapsModule_StubMaps_Factory.INSTANCE);
//        this.bindPhoneNumberGeoUtilProvider = DoubleCheck.provider(PhoneNumberGeoUtilImpl_Factory.INSTANCE);
//        DuoAction_Factory duoAction_Factory = new DuoAction_Factory(this.provideUiThreadExecutorServiceProvider);
//        this.duoActionProvider = duoAction_Factory;
//        PreferredAccountWorkerImpl_Factory preferredAccountWorkerImpl_Factory = new PreferredAccountWorkerImpl_Factory(this.provideContextProvider, this.provideBackgroundExecutorProvider);
//        this.preferredAccountWorkerImplProvider = preferredAccountWorkerImpl_Factory;
//        this.toProvider3 = preferredAccountWorkerImpl_Factory;
//        CallingAccountSelector_Factory callingAccountSelector_Factory = new CallingAccountSelector_Factory(preferredAccountWorkerImpl_Factory);
//        this.callingAccountSelectorProvider = callingAccountSelector_Factory;
//        PreCallModule_ProvideActionsFactory preCallModule_ProvideActionsFactory = new PreCallModule_ProvideActionsFactory(duoAction_Factory, callingAccountSelector_Factory);
//        this.provideActionsProvider = preCallModule_ProvideActionsFactory;
//        PreCallImpl_Factory preCallImpl_Factory = new PreCallImpl_Factory(preCallModule_ProvideActionsFactory);
//        this.preCallImplProvider = preCallImpl_Factory;
//        this.toProvider4 = DoubleCheck.provider(preCallImpl_Factory);
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory7 = this.provideContextProvider;
//        Provider<SharedPreferences> provider19 = this.provideUnencryptedSharedPrefsProvider;
//        Provider<ConfigProvider> provider20 = this.toProvider2;
//        RttPromotion_Factory rttPromotion_Factory = new RttPromotion_Factory(contextModule_ProvideContextFactory7, provider19, provider20);
//        this.rttPromotionProvider = rttPromotion_Factory;
//        DuoPromotion_Factory duoPromotion_Factory = new DuoPromotion_Factory(contextModule_ProvideContextFactory7, provider20, this.bindsDuoProvider, provider19);
//        this.duoPromotionProvider = duoPromotion_Factory;
//        this.providePriorityPromotionListProvider = new PromotionModule_ProvidePriorityPromotionListFactory(rttPromotion_Factory, duoPromotion_Factory);
//        Provider<ListeningExecutorService> provider21 = this.provideBackgroundExecutorProvider;
//        HighResolutionPhotoRequesterImpl_Factory highResolutionPhotoRequesterImpl_Factory = new HighResolutionPhotoRequesterImpl_Factory(contextModule_ProvideContextFactory7, provider21);
//        this.highResolutionPhotoRequesterImplProvider = highResolutionPhotoRequesterImpl_Factory;
//        this.toHighResolutionPhotoRequesterImplProvider = highResolutionPhotoRequesterImpl_Factory;
//        this.speedDialUiItemMutatorProvider = DoubleCheck.provider(new SpeedDialUiItemMutator_Factory(contextModule_ProvideContextFactory7, provider21, this.provideContactDisplayPreferencesProvider, highResolutionPhotoRequesterImpl_Factory));
//        this.bindSuggestionProvider = DoubleCheck.provider(StubSuggestionProvider_Factory.INSTANCE);
//        this.bindsSimulatorProvider = DoubleCheck.provider(SimulatorImpl_Factory.INSTANCE);
//        this.bindsSimulatorEnrichedCallProvider = DoubleCheck.provider(SimulatorEnrichedCallStub_Factory.INSTANCE);
//        this.bindsSimulatorConnectionsBankProvider = DoubleCheck.provider(SimulatorConnectionsBankImpl_Factory.INSTANCE);
//        this.bindDialerStrictModeProvider = DoubleCheck.provider(SystemDialerStrictMode_Factory.INSTANCE);
//        ContextModule_ProvideContextFactory contextModule_ProvideContextFactory8 = this.provideContextProvider;
//        this.provideThemeModuleProvider = new AospThemeModule_ProvideThemeModuleFactory(contextModule_ProvideContextFactory8);
//        this.provideVoicemailClientProvider = DoubleCheck.provider(new VoicemailModule_ProvideVoicemailClientFactory(contextModule_ProvideContextFactory8));
//    }
//
//    @Override // com.android.dialer.activecalls.ActiveCallsComponent.HasComponent
//    public final ActiveCallsComponent activeCallsComponent() {
//        return new ActiveCallsComponentImpl();
//    }
//
//    @Override // com.android.bubble.BubbleComponent.HasComponent
//    public final BubbleComponent bubbleComponent() {
//        return new BubbleComponentImpl();
//    }
//
//    @Override // com.android.incallui.calllocation.CallLocationComponent.HasComponent
//    public final CallLocationComponent callLocationComponent() {
//        return new CallLocationComponentImpl();
//    }
//
//    @Override // com.android.dialer.calllog.CallLogComponent.HasComponent
//    public final CallLogComponent callLogComponent() {
//        return new CallLogComponentImpl();
//    }
//
//    @Override // com.android.dialer.calllog.config.CallLogConfigComponent.HasComponent
//    public final CallLogConfigComponent callLogConfigComponent() {
//        return new CallLogConfigComponentImpl(this);
//    }
//
//    @Override // com.android.dialer.calllog.database.CallLogDatabaseComponent.HasComponent
//    public final CallLogDatabaseComponent callLogDatabaseComponent() {
//        return new CallLogDatabaseComponentImpl();
//    }
//
//    @Override // com.android.dialer.calllog.ui.CallLogUiComponent.HasComponent
//    public final CallLogUiComponent callLogUiComponent() {
//        return new CallLogUiComponentImpl(this);
//    }
//
//    @Override // com.android.dialer.commandline.CommandLineComponent.HasComponent
//    public final CommandLineComponent commandLineComponent() {
//        return new CommandLineComponentImpl();
//    }
//
//    @Override // com.android.dialer.configprovider.ConfigProviderComponent.HasComponent
//    public final ConfigProviderComponent configProviderComponent() {
//        return new ConfigProviderComponentImpl();
//    }
//
//    @Override // com.android.dialer.contacts.ContactsComponent.HasComponent
//    public final ContactsComponent contactsComponent() {
//        return new ContactsComponentImpl();
//    }
//
//    @Override // com.android.dialer.common.concurrent.DialerExecutorComponent.HasComponent
//    public final DialerExecutorComponent dialerExecutorComponent() {
//        return new DialerExecutorComponentImpl();
//    }
//
//    @Override // com.android.dialer.duo.DuoComponent.HasComponent
//    public final DuoComponent duoComponent() {
//        return new DuoComponentImpl();
//    }
//
//    @Override // com.android.dialer.enrichedcall.EnrichedCallComponent.HasComponent
//    public final EnrichedCallComponent enrichedCallComponent() {
//        return new EnrichedCallComponentImpl();
//    }
//
//    @Override // com.android.dialer.feedback.FeedbackComponent.HasComponent
//    public final FeedbackComponent feedbackComponent() {
//        return new FeedbackComponentImpl();
//    }
//
//    @Override // com.android.dialer.glidephotomanager.GlidePhotoManagerComponent.HasComponent
//    public final GlidePhotoManagerComponent glidePhotoManagerComponent() {
//        return new GlidePhotoManagerComponentImpl();
//    }
//
//    @Override // com.android.incallui.maps.MapsComponent.HasComponent
//    public final MapsComponent mapsComponent() {
//        return new MapsComponentImpl();
//    }
//
//    @Override // com.android.dialer.metrics.MetricsComponent.HasComponent
//    public final MetricsComponent metricsComponent() {
//        return new MetricsComponentImpl();
//    }
//
//    @Override // com.android.dialer.phonelookup.PhoneLookupComponent.HasComponent
//    public final PhoneLookupComponent phoneLookupComponent() {
//        return new PhoneLookupComponentImpl();
//    }
//
//    @Override // com.android.dialer.phonelookup.database.PhoneLookupDatabaseComponent.HasComponent
//    public final PhoneLookupDatabaseComponent phoneLookupDatabaseComponent() {
//        return new PhoneLookupDatabaseComponentImpl();
//    }
//
//    @Override // com.android.dialer.phonenumbergeoutil.PhoneNumberGeoUtilComponent.HasComponent
//    public final PhoneNumberGeoUtilComponent phoneNumberGeoUtilComponent() {
//        return new PhoneNumberGeoUtilComponentImpl();
//    }
//
//    @Override // com.android.dialer.precall.PreCallComponent.HasComponent
//    public final PreCallComponent preCallActionsComponent() {
//        return new PreCallComponentImpl();
//    }
//
//    @Override // com.android.dialer.preferredsim.PreferredSimComponent.HasComponent
//    public final PreferredSimComponent preferredSimComponent() {
//        return new PreferredSimComponentImpl();
//    }
//
//    @Override // com.android.dialer.promotion.PromotionComponent.HasComponent
//    public final PromotionComponent promotionComponent() {
//        return new PromotionComponentImpl(this);
//    }
//
//    @Override // com.android.dialer.preferredsim.suggestion.SimSuggestionComponent.HasComponent
//    public final SimSuggestionComponent simSuggestionComponent() {
//        return new SimSuggestionComponentImpl();
//    }
//
//    @Override // com.android.dialer.simulator.SimulatorComponent.HasComponent
//    public final SimulatorComponent simulatorComponent() {
//        return new SimulatorComponentImpl();
//    }
//
//    @Override // com.android.dialer.spam.SpamComponent.HasComponent
//    public final SpamComponent spamComponent() {
//        return new SpamComponentImpl();
//    }
//
//    @Override // com.android.incallui.speakeasy.SpeakEasyComponent.HasComponent
//    public final SpeakEasyComponent speakEasyComponent() {
//        return new SpeakEasyComponentImpl();
//    }
//
//    @Override // com.android.dialer.storage.StorageComponent.HasComponent
//    public final StorageComponent storageComponent() {
//        return new StorageComponentImpl();
//    }
//
//    @Override // com.android.dialer.strictmode.StrictModeComponent.HasComponent
//    public final StrictModeComponent strictModeComponent() {
//        return new StrictModeComponentImpl();
//    }
//
//    @Override // com.android.dialer.theme.base.ThemeComponent.HasComponent
//    public final ThemeComponent themeComponent() {
//        return new ThemeComponentImpl();
//    }
//
//    @Override // com.android.dialer.speeddial.loader.UiItemLoaderComponent.HasComponent
//    public final UiItemLoaderComponent uiItemLoaderComponent() {
//        return new UiItemLoaderComponentImpl();
//    }
//
//    @Override // com.android.voicemail.VoicemailComponent.HasComponent
//    public final VoicemailComponent voicemailComponent() {
//        return new VoicemailComponentImpl();
//    }
//}
