/*
 * Copyright (C) 2017 The Android Open Source Project
 * Copyright (C) 2023-2024 wintmain
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

package com.wintmain.dialer.main.impl;

import static com.wintmain.dialer.app.settings.DialerSettingsActivityCompt.PrefsFragment.getThemeButtonBehavior;

import android.app.Activity;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.telecom.TelecomManager;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.wintmain.dialer.R;
import com.wintmain.dialer.app.settings.DialerSettingsActivityCompt;
import com.wintmain.dialer.blockreportspam.ShowBlockReportSpamDialogReceiver;
import com.wintmain.dialer.calllog.config.CallLogConfigComponent;
import com.wintmain.dialer.common.Assert;
import com.wintmain.dialer.common.LogUtil;
import com.wintmain.dialer.constants.ActivityRequestCodes;
import com.wintmain.dialer.interactions.PhoneNumberInteraction.DisambigDialogDismissedListener;
import com.wintmain.dialer.interactions.PhoneNumberInteraction.InteractionErrorCode;
import com.wintmain.dialer.interactions.PhoneNumberInteraction.InteractionErrorListener;
import com.wintmain.dialer.main.impl.bottomnav.BottomNavBar;
import com.wintmain.dialer.telecom.TelecomUtil;
import com.wintmain.dialer.util.TransactionSafeActivity;

import java.util.Objects;


/** This is the main activity for dialer. It hosts favorites, call log, search, dialpad, etc... */
public class MainActivity extends TransactionSafeActivity implements TBDMainActivityPeer.PeerSupplier,
        // TODO(calderwoodra): remove these 2 interfaces when we migrate to new speed dial fragment
        InteractionErrorListener,
        DisambigDialogDismissedListener {

    private com.wintmain.dialer.main.MainActivityPeer activePeer;

    public static Activity main;
    public static Boolean boolConfigUsingLatestAbout;
    public static Boolean boolConfigUsingLatestPeer;
    /**
     * {@link android.content.BroadcastReceiver} that shows a dialog to block a number and/or report
     * it as spam when notified.
     */
    private ShowBlockReportSpamDialogReceiver showBlockReportSpamDialogReceiver;

    public static Intent getShowCallLogIntent(Context context) {
        return getShowTabIntent(context, BottomNavBar.TabIndex.CALL_LOG);
    }

    /** Returns intent that will open MainActivity to the specified tab. */
    public static Intent getShowTabIntent(Context context, @BottomNavBar.TabIndex int tabIndex) {
        if (CallLogConfigComponent.get(context).callLogConfig().isNewPeerEnabled()) {
            // TODO(calderwoodra): implement this in NewMainActivityPeer
            return null;
        }
        return OldMainActivityPeer.getShowTabIntent(context, tabIndex);
    }

    /**
     * Returns intent that will open MainActivity to the specified tab.
     *
     * @param context Context of the application package implementing MainActivity class.
     * @return intent for MainActivity.class
     */
    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class)
                .setAction(Intent.ACTION_VIEW)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public static Boolean getBoolConfigUsingLatestAbout() {
        return boolConfigUsingLatestAbout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolConfigUsingLatestAbout = getApplicationContext().
                getResources().getBoolean(R.bool.config_using_latest_about);
        if (!boolConfigUsingLatestAbout) {
            SharedPreferences themeprefs = DialerSettingsActivityCompt.PrefsFragment.getSharedPreferences(this);
            DialerSettingsActivityCompt.PrefsFragment.ThemeButtonBehavior mThemeBehavior = getThemeButtonBehavior(themeprefs);

            if (mThemeBehavior == DialerSettingsActivityCompt.PrefsFragment.ThemeButtonBehavior.DARK) {
                LogUtil.enterBlock("MainActivity.dark");
                this.getTheme().applyStyle(R.style.MainActivityThemeDark, true);
            }
            if (mThemeBehavior == DialerSettingsActivityCompt.PrefsFragment.ThemeButtonBehavior.LIGHT) {
                LogUtil.enterBlock("MainActivity.light");
                this.getTheme().applyStyle(R.style.MainActivityThemeLight, true);
            }
        }

        super.onCreate(savedInstanceState);
        main = this;
        LogUtil.enterBlock("MainActivity.onCreate");
        // If peer was set by the super, don't reset it.
        activePeer = getNewPeer();
        activePeer.onActivityCreate(savedInstanceState);

        showBlockReportSpamDialogReceiver =
                new ShowBlockReportSpamDialogReceiver(getSupportFragmentManager());
        setdialer();
    }

    // function to set default dialer
    private void setdialer() {
        TelecomManager manager = (TelecomManager) getSystemService(Context.TELECOM_SERVICE);
        if (Objects.equals(manager.getDefaultDialerPackage(), getPackageName())) {
            LogUtil.enterBlock("App Already Default Dialer");
        } else {
            launchSetDefaultDialerIntent();
        }
    }

    private void launchSetDefaultDialerIntent() {
        RoleManager roleManager;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            roleManager = (RoleManager) getSystemService(Context.ROLE_SERVICE);
            Intent intent = roleManager.createRequestRoleIntent(RoleManager.ROLE_DIALER);
            startActivityForResult(intent, ActivityRequestCodes.DEFAULT_DIALER);
        }
    }

    protected com.wintmain.dialer.main.MainActivityPeer getNewPeer() {
        boolConfigUsingLatestPeer = getApplicationContext().
                getResources().getBoolean(R.bool.config_using_latest_peer);
        if (boolConfigUsingLatestPeer) {
            // TODO 这边用新的有个bug，暂时还是用原来的Peer
            return new NewMainActivityPeer(this);
        } else {
            return new TBDMainActivityPeer(this);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        activePeer.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (Build.TYPE.equals("user") && !TelecomUtil.isDefaultDialer(this)) {
                startActivity(new Intent(this, DefaultDialerActivity.class));
                return;
            }
        }

        activePeer.onActivityResume();

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(
                        showBlockReportSpamDialogReceiver, ShowBlockReportSpamDialogReceiver.getIntentFilter());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        activePeer.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        activePeer.onUserLeaveHint();
    }

    @Override
    protected void onPause() {
        super.onPause();
        activePeer.onActivityPause();

        LocalBroadcastManager.getInstance(this).unregisterReceiver(showBlockReportSpamDialogReceiver);
    }

    @Override
    protected void onStop() {
        super.onStop();
        activePeer.onActivityStop();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        activePeer.onSaveInstanceState(bundle);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        activePeer.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (activePeer.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void interactionError(@InteractionErrorCode int interactionErrorCode) {
        switch (interactionErrorCode) {
            case InteractionErrorCode.USER_LEAVING_ACTIVITY:
                // This is expected to happen if the user exits the activity before the interaction occurs.
                return;
            case InteractionErrorCode.CONTACT_NOT_FOUND:
            case InteractionErrorCode.CONTACT_HAS_NO_NUMBER:
            case InteractionErrorCode.OTHER_ERROR:
            default:
                // All other error codes are unexpected. For example, it should be impossible to start an
                // interaction with an invalid contact from this activity.
                throw Assert.createIllegalStateFailException(
                        "PhoneNumberInteraction error: " + interactionErrorCode);
        }
    }

    @Override
    public void onDisambigDialogDismissed() {
        // Don't do anything; the app will remain open with favorites tiles displayed.
    }

    @Override
    public com.wintmain.dialer.main.MainActivityPeer getPeer() {
        return activePeer;
    }

}
