package com.onesignal.inAppMessages.internal.preferences.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0018\u0010$\u001a\u00020\"2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R4\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR4\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR4\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\n\"\u0004\b \u0010\f¨\u0006&"}, d2 = {"Lcom/onesignal/inAppMessages/internal/preferences/impl/InAppPreferencesController;", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "value", "", "", "clickedMessagesId", "getClickedMessagesId", "()Ljava/util/Set;", "setClickedMessagesId", "(Ljava/util/Set;)V", "dismissedMessagesId", "getDismissedMessagesId", "setDismissedMessagesId", "impressionesMessagesId", "getImpressionesMessagesId", "setImpressionesMessagesId", "", "lastTimeInAppDismissed", "getLastTimeInAppDismissed", "()Ljava/lang/Long;", "setLastTimeInAppDismissed", "(Ljava/lang/Long;)V", "savedIAMs", "getSavedIAMs", "()Ljava/lang/String;", "setSavedIAMs", "(Ljava/lang/String;)V", "viewPageImpressionedIds", "getViewPageImpressionedIds", "setViewPageImpressionedIds", "cleanInAppMessageClickedClickIds", "", "oldClickedClickIds", "cleanInAppMessageIds", "oldMessageIds", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppPreferencesController.kt */
public final class InAppPreferencesController implements IInAppPreferencesController {
    private final IPreferencesService _prefs;

    public InAppPreferencesController(IPreferencesService iPreferencesService) {
        Intrinsics.checkNotNullParameter(iPreferencesService, "_prefs");
        this._prefs = iPreferencesService;
    }

    public void cleanInAppMessageIds(Set<String> set) {
        if (set != null) {
            Collection collection = set;
            if (!collection.isEmpty()) {
                Set<String> stringSet = this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, (Set<String>) null);
                Set<String> stringSet2 = this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, (Set<String>) null);
                if (stringSet != null && (!stringSet.isEmpty())) {
                    Set mutableSet = CollectionsKt.toMutableSet(stringSet);
                    mutableSet.removeAll(collection);
                    this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, mutableSet);
                }
                if (stringSet2 != null && (!stringSet2.isEmpty())) {
                    Set mutableSet2 = CollectionsKt.toMutableSet(stringSet2);
                    mutableSet2.removeAll(collection);
                    this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, mutableSet2);
                }
            }
        }
    }

    public void cleanInAppMessageClickedClickIds(Set<String> set) {
        Set<String> stringSet;
        if (set != null) {
            Collection collection = set;
            if ((!collection.isEmpty()) && (stringSet = this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, (Set<String>) null)) != null && (!stringSet.isEmpty())) {
                Set mutableSet = CollectionsKt.toMutableSet(stringSet);
                mutableSet.removeAll(collection);
                this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, mutableSet);
            }
        }
    }

    public Set<String> getClickedMessagesId() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, (Set<String>) null);
    }

    public void setClickedMessagesId(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CLICKED_CLICK_IDS_IAMS, set);
    }

    public Set<String> getImpressionesMessagesId() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, (Set<String>) null);
    }

    public void setImpressionesMessagesId(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IMPRESSIONED_IAMS, set);
    }

    public Set<String> getViewPageImpressionedIds() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_PAGE_IMPRESSIONED_IAMS, (Set<String>) null);
    }

    public void setViewPageImpressionedIds(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_PAGE_IMPRESSIONED_IAMS, set);
    }

    public Set<String> getDismissedMessagesId() {
        return this._prefs.getStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, (Set<String>) null);
    }

    public void setDismissedMessagesId(Set<String> set) {
        this._prefs.saveStringSet(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_DISMISSED_IAMS, set);
    }

    public String getSavedIAMs() {
        return this._prefs.getString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CACHED_IAMS, (String) null);
    }

    public void setSavedIAMs(String str) {
        this._prefs.saveString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_CACHED_IAMS, str);
    }

    public Long getLastTimeInAppDismissed() {
        return this._prefs.getLong(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IAM_LAST_DISMISSED_TIME, (Long) null);
    }

    public void setLastTimeInAppDismissed(Long l) {
        this._prefs.saveLong(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_IAM_LAST_DISMISSED_TIME, l);
    }
}
