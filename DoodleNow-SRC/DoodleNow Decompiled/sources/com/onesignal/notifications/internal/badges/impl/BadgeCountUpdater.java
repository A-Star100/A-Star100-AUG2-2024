package com.onesignal.notifications.internal.badges.impl;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadgeException;
import com.onesignal.notifications.internal.badges.impl.shortcutbadger.ShortcutBadger;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/notifications/internal/badges/impl/BadgeCountUpdater;", "Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_queryHelper", "Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;Lcom/onesignal/core/internal/database/IDatabaseProvider;)V", "badgesEnabled", "", "areBadgeSettingsEnabled", "", "areBadgesEnabled", "update", "", "updateCount", "count", "updateFallback", "updateStandard", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BadgeCountUpdater.kt */
public final class BadgeCountUpdater implements IBadgeCountUpdater {
    private final IApplicationService _applicationService;
    private final IDatabaseProvider _databaseProvider;
    private final INotificationQueryHelper _queryHelper;
    private int badgesEnabled = -1;

    public BadgeCountUpdater(IApplicationService iApplicationService, INotificationQueryHelper iNotificationQueryHelper, IDatabaseProvider iDatabaseProvider) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationQueryHelper, "_queryHelper");
        Intrinsics.checkNotNullParameter(iDatabaseProvider, "_databaseProvider");
        this._applicationService = iApplicationService;
        this._queryHelper = iNotificationQueryHelper;
        this._databaseProvider = iDatabaseProvider;
    }

    private final boolean areBadgeSettingsEnabled() {
        int i = this.badgesEnabled;
        if (i != -1) {
            return i == 1;
        }
        try {
            ApplicationInfo applicationInfo = this._applicationService.getAppContext().getPackageManager().getApplicationInfo(this._applicationService.getAppContext().getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "_applicationService.appC…A_DATA,\n                )");
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                this.badgesEnabled = Intrinsics.areEqual((Object) "DISABLE", (Object) bundle.getString("com.onesignal.BadgeCount")) ^ true ? 1 : 0;
            } else {
                this.badgesEnabled = 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            this.badgesEnabled = 0;
            Logging.error("Error reading meta-data tag 'com.onesignal.BadgeCount'. Disabling badge setting.", e);
        }
        if (this.badgesEnabled == 1) {
            return true;
        }
        return false;
    }

    private final boolean areBadgesEnabled() {
        return areBadgeSettingsEnabled() && NotificationHelper.areNotificationsEnabled$default(NotificationHelper.INSTANCE, this._applicationService.getAppContext(), (String) null, 2, (Object) null);
    }

    public void update() {
        if (areBadgesEnabled()) {
            updateStandard();
        }
    }

    private final void updateStandard() {
        int i = 0;
        for (StatusBarNotification isGroupSummary : NotificationHelper.INSTANCE.getActiveNotifications(this._applicationService.getAppContext())) {
            if (!NotificationHelper.INSTANCE.isGroupSummary(isGroupSummary)) {
                i++;
            }
        }
        updateCount(i);
    }

    private final void updateFallback() {
        Ref.IntRef intRef = new Ref.IntRef();
        IDatabase.DefaultImpls.query$default(this._databaseProvider.getOs(), OneSignalDbContract.NotificationTable.TABLE_NAME, (String[]) null, this._queryHelper.recentUninteractedWithNotificationsWhere().toString(), (String[]) null, (String) null, (String) null, (String) null, String.valueOf(INotificationLimitManager.Constants.INSTANCE.getMaxNumberOfNotifications()), new BadgeCountUpdater$updateFallback$1(intRef), 122, (Object) null);
        updateCount(intRef.element);
    }

    public void updateCount(int i) {
        if (areBadgeSettingsEnabled()) {
            try {
                ShortcutBadger.applyCountOrThrow(this._applicationService.getAppContext(), i);
            } catch (ShortcutBadgeException unused) {
            }
        }
    }
}
