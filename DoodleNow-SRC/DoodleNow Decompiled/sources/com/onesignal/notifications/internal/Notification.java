package com.onesignal.notifications.internal;

import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.BackgroundImageLayout;
import com.onesignal.notifications.IActionButton;
import com.onesignal.notifications.IDisplayableMutableNotification;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B/\b\u0016\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\b\u0010s\u001a\u00020tH\u0016J\u0006\u0010u\u001a\u00020vJ\u0018\u0010w\u001a\u00020t2\u0006\u0010x\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010y\u001a\u00020tH\u0002J\u0010\u0010z\u001a\u00020t2\u0006\u0010x\u001a\u00020\u0003H\u0002J\u0012\u0010{\u001a\u00020t2\b\u0010|\u001a\u0004\u0018\u00010JH\u0016J\u0006\u0010}\u001a\u00020\u0003J\b\u0010~\u001a\u00020#H\u0016R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u0011\u0010.\u001a\u00020/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R\u001c\u00105\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\u001c\u00108\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u0010'R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001c\u0010=\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\u001c\u0010@\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001c\u0010C\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u001a\u0010F\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'R\u001a\u0010R\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001bR\u001a\u0010U\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010%\"\u0004\bW\u0010'R\u001a\u0010X\u001a\u00020YX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010%\"\u0004\b`\u0010'R\u001c\u0010a\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010%\"\u0004\bc\u0010'R\u001c\u0010d\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010%\"\u0004\bf\u0010'R\u001c\u0010g\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010%\"\u0004\bi\u0010'R\u001c\u0010j\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010%\"\u0004\bl\u0010'R\u001c\u0010m\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010%\"\u0004\bo\u0010'R\u001a\u0010p\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0019\"\u0004\br\u0010\u001b¨\u0006\u0001"}, d2 = {"Lcom/onesignal/notifications/internal/Notification;", "Lcom/onesignal/notifications/IDisplayableMutableNotification;", "payload", "Lorg/json/JSONObject;", "time", "Lcom/onesignal/core/internal/time/ITime;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "groupedNotifications", "", "jsonPayload", "androidNotificationId", "", "(Ljava/util/List;Lorg/json/JSONObject;ILcom/onesignal/core/internal/time/ITime;)V", "actionButtons", "Lcom/onesignal/notifications/IActionButton;", "getActionButtons", "()Ljava/util/List;", "setActionButtons", "(Ljava/util/List;)V", "additionalData", "getAdditionalData", "()Lorg/json/JSONObject;", "setAdditionalData", "(Lorg/json/JSONObject;)V", "getAndroidNotificationId", "()I", "setAndroidNotificationId", "(I)V", "backgroundImageLayout", "Lcom/onesignal/notifications/BackgroundImageLayout;", "getBackgroundImageLayout", "()Lcom/onesignal/notifications/BackgroundImageLayout;", "setBackgroundImageLayout", "(Lcom/onesignal/notifications/BackgroundImageLayout;)V", "bigPicture", "", "getBigPicture", "()Ljava/lang/String;", "setBigPicture", "(Ljava/lang/String;)V", "body", "getBody", "setBody", "collapseId", "getCollapseId", "setCollapseId", "displayWaiter", "Lcom/onesignal/common/threading/Waiter;", "getDisplayWaiter", "()Lcom/onesignal/common/threading/Waiter;", "fromProjectNumber", "getFromProjectNumber", "setFromProjectNumber", "groupKey", "getGroupKey", "setGroupKey", "groupMessage", "getGroupMessage", "setGroupMessage", "getGroupedNotifications", "setGroupedNotifications", "largeIcon", "getLargeIcon", "setLargeIcon", "launchURL", "getLaunchURL", "setLaunchURL", "ledColor", "getLedColor", "setLedColor", "lockScreenVisibility", "getLockScreenVisibility", "setLockScreenVisibility", "notificationExtender", "Landroidx/core/app/NotificationCompat$Extender;", "getNotificationExtender", "()Landroidx/core/app/NotificationCompat$Extender;", "setNotificationExtender", "(Landroidx/core/app/NotificationCompat$Extender;)V", "notificationId", "getNotificationId", "setNotificationId", "priority", "getPriority", "setPriority", "rawPayload", "getRawPayload", "setRawPayload", "sentTime", "", "getSentTime", "()J", "setSentTime", "(J)V", "smallIcon", "getSmallIcon", "setSmallIcon", "smallIconAccentColor", "getSmallIconAccentColor", "setSmallIconAccentColor", "sound", "getSound", "setSound", "templateId", "getTemplateId", "setTemplateId", "templateName", "getTemplateName", "setTemplateName", "title", "getTitle", "setTitle", "ttl", "getTtl", "setTtl", "display", "", "hasNotificationId", "", "initPayloadData", "currentJsonPayload", "setActionButtonsFromData", "setBackgroundImageLayoutFromData", "setExtender", "extender", "toJSONObject", "toString", "ActionButton", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Notification.kt */
public final class Notification implements IDisplayableMutableNotification {
    private List<? extends IActionButton> actionButtons;
    private JSONObject additionalData;
    private int androidNotificationId;
    private BackgroundImageLayout backgroundImageLayout;
    private String bigPicture;
    private String body;
    private String collapseId;
    private final Waiter displayWaiter;
    private String fromProjectNumber;
    private String groupKey;
    private String groupMessage;
    private List<Notification> groupedNotifications;
    private String largeIcon;
    private String launchURL;
    private String ledColor;
    private int lockScreenVisibility;
    private NotificationCompat.Extender notificationExtender;
    private String notificationId;
    private int priority;
    private String rawPayload;
    private long sentTime;
    private String smallIcon;
    private String smallIconAccentColor;
    private String sound;
    private String templateId;
    private String templateName;
    private String title;
    private int ttl;

    public List<IActionButton> getActionButtons() {
        return this.actionButtons;
    }

    public JSONObject getAdditionalData() {
        return this.additionalData;
    }

    public int getAndroidNotificationId() {
        return this.androidNotificationId;
    }

    public BackgroundImageLayout getBackgroundImageLayout() {
        return this.backgroundImageLayout;
    }

    public String getBigPicture() {
        return this.bigPicture;
    }

    public String getBody() {
        return this.body;
    }

    public String getCollapseId() {
        return this.collapseId;
    }

    public final Waiter getDisplayWaiter() {
        return this.displayWaiter;
    }

    public String getFromProjectNumber() {
        return this.fromProjectNumber;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public String getGroupMessage() {
        return this.groupMessage;
    }

    public List<Notification> getGroupedNotifications() {
        return this.groupedNotifications;
    }

    public String getLargeIcon() {
        return this.largeIcon;
    }

    public String getLaunchURL() {
        return this.launchURL;
    }

    public String getLedColor() {
        return this.ledColor;
    }

    public int getLockScreenVisibility() {
        return this.lockScreenVisibility;
    }

    public final NotificationCompat.Extender getNotificationExtender() {
        return this.notificationExtender;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getRawPayload() {
        return this.rawPayload;
    }

    public long getSentTime() {
        return this.sentTime;
    }

    public String getSmallIcon() {
        return this.smallIcon;
    }

    public String getSmallIconAccentColor() {
        return this.smallIconAccentColor;
    }

    public String getSound() {
        return this.sound;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setActionButtons(List<? extends IActionButton> list) {
        this.actionButtons = list;
    }

    public void setAdditionalData(JSONObject jSONObject) {
        this.additionalData = jSONObject;
    }

    public void setAndroidNotificationId(int i) {
        this.androidNotificationId = i;
    }

    public void setBackgroundImageLayout(BackgroundImageLayout backgroundImageLayout2) {
        this.backgroundImageLayout = backgroundImageLayout2;
    }

    public void setBigPicture(String str) {
        this.bigPicture = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCollapseId(String str) {
        this.collapseId = str;
    }

    public void setExtender(NotificationCompat.Extender extender) {
        this.notificationExtender = extender;
    }

    public void setFromProjectNumber(String str) {
        this.fromProjectNumber = str;
    }

    public void setGroupKey(String str) {
        this.groupKey = str;
    }

    public void setGroupMessage(String str) {
        this.groupMessage = str;
    }

    public void setGroupedNotifications(List<Notification> list) {
        this.groupedNotifications = list;
    }

    public void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    public void setLaunchURL(String str) {
        this.launchURL = str;
    }

    public void setLedColor(String str) {
        this.ledColor = str;
    }

    public void setLockScreenVisibility(int i) {
        this.lockScreenVisibility = i;
    }

    public final void setNotificationExtender(NotificationCompat.Extender extender) {
        this.notificationExtender = extender;
    }

    public void setNotificationId(String str) {
        this.notificationId = str;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setRawPayload(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.rawPayload = str;
    }

    public void setSentTime(long j) {
        this.sentTime = j;
    }

    public void setSmallIcon(String str) {
        this.smallIcon = str;
    }

    public void setSmallIconAccentColor(String str) {
        this.smallIconAccentColor = str;
    }

    public void setSound(String str) {
        this.sound = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Notification(JSONObject jSONObject, ITime iTime) {
        this((List<Notification>) null, jSONObject, 0, iTime);
        Intrinsics.checkNotNullParameter(jSONObject, "payload");
        Intrinsics.checkNotNullParameter(iTime, "time");
    }

    public Notification(List<Notification> list, JSONObject jSONObject, int i, ITime iTime) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonPayload");
        Intrinsics.checkNotNullParameter(iTime, "time");
        this.displayWaiter = new Waiter();
        this.lockScreenVisibility = 1;
        this.rawPayload = "";
        initPayloadData(jSONObject, iTime);
        setGroupedNotifications(list);
        setAndroidNotificationId(i);
    }

    private final void initPayloadData(JSONObject jSONObject, ITime iTime) {
        try {
            JSONObject customJSONObject = NotificationHelper.INSTANCE.getCustomJSONObject(jSONObject);
            long currentTimeMillis = iTime.getCurrentTimeMillis();
            if (jSONObject.has("google.ttl")) {
                setSentTime(jSONObject.optLong("google.sent_time", currentTimeMillis) / ((long) 1000));
                setTtl(jSONObject.optInt("google.ttl", 259200));
            } else if (jSONObject.has("hms.ttl")) {
                setSentTime(jSONObject.optLong("hms.sent_time", currentTimeMillis) / ((long) 1000));
                setTtl(jSONObject.optInt("hms.ttl", 259200));
            } else {
                setSentTime(currentTimeMillis / ((long) 1000));
                setTtl(259200);
            }
            setNotificationId(JSONObjectExtensionsKt.safeString(customJSONObject, "i"));
            setTemplateId(JSONObjectExtensionsKt.safeString(customJSONObject, "ti"));
            setTemplateName(JSONObjectExtensionsKt.safeString(customJSONObject, "tn"));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "currentJsonPayload.toString()");
            setRawPayload(jSONObject2);
            setAdditionalData(JSONObjectExtensionsKt.safeJSONObject(customJSONObject, "a"));
            setLaunchURL(JSONObjectExtensionsKt.safeString(customJSONObject, "u"));
            setBody(JSONObjectExtensionsKt.safeString(jSONObject, "alert"));
            setTitle(JSONObjectExtensionsKt.safeString(jSONObject, "title"));
            setSmallIcon(JSONObjectExtensionsKt.safeString(jSONObject, "sicon"));
            setBigPicture(JSONObjectExtensionsKt.safeString(jSONObject, "bicon"));
            setLargeIcon(JSONObjectExtensionsKt.safeString(jSONObject, "licon"));
            setSound(JSONObjectExtensionsKt.safeString(jSONObject, "sound"));
            setGroupKey(JSONObjectExtensionsKt.safeString(jSONObject, "grp"));
            setGroupMessage(JSONObjectExtensionsKt.safeString(jSONObject, "grp_msg"));
            setSmallIconAccentColor(JSONObjectExtensionsKt.safeString(jSONObject, "bgac"));
            setLedColor(JSONObjectExtensionsKt.safeString(jSONObject, "ledc"));
            String safeString = JSONObjectExtensionsKt.safeString(jSONObject, "vis");
            if (safeString != null) {
                setLockScreenVisibility(Integer.parseInt(safeString));
            }
            setFromProjectNumber(JSONObjectExtensionsKt.safeString(jSONObject, Constants.MessagePayloadKeys.FROM));
            setPriority(jSONObject.optInt("pri", 0));
            String safeString2 = JSONObjectExtensionsKt.safeString(jSONObject, Constants.MessagePayloadKeys.COLLAPSE_KEY);
            if (!Intrinsics.areEqual((Object) "do_not_collapse", (Object) safeString2)) {
                setCollapseId(safeString2);
            }
            try {
                setActionButtonsFromData();
            } catch (Throwable th) {
                Logging.error("Error assigning OSNotificationReceivedEvent.actionButtons values!", th);
            }
            try {
                setBackgroundImageLayoutFromData(jSONObject);
            } catch (Throwable th2) {
                Logging.error("Error assigning OSNotificationReceivedEvent.backgroundImageLayout values!", th2);
            }
        } catch (Throwable th3) {
            Logging.error("Error assigning OSNotificationReceivedEvent payload values!", th3);
        }
    }

    private final void setActionButtonsFromData() throws Throwable {
        if (getAdditionalData() != null) {
            JSONObject additionalData2 = getAdditionalData();
            Intrinsics.checkNotNull(additionalData2);
            if (additionalData2.has("actionButtons")) {
                JSONObject additionalData3 = getAdditionalData();
                Intrinsics.checkNotNull(additionalData3);
                JSONArray jSONArray = additionalData3.getJSONArray("actionButtons");
                List arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonActionButton");
                    arrayList.add(new ActionButton(JSONObjectExtensionsKt.safeString(jSONObject, "id"), JSONObjectExtensionsKt.safeString(jSONObject, "text"), JSONObjectExtensionsKt.safeString(jSONObject, "icon")));
                }
                setActionButtons(arrayList);
                JSONObject additionalData4 = getAdditionalData();
                Intrinsics.checkNotNull(additionalData4);
                additionalData4.remove(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID);
                JSONObject additionalData5 = getAdditionalData();
                Intrinsics.checkNotNull(additionalData5);
                additionalData5.remove("actionButtons");
            }
        }
    }

    private final void setBackgroundImageLayoutFromData(JSONObject jSONObject) throws Throwable {
        String safeString = JSONObjectExtensionsKt.safeString(jSONObject, "bg_img");
        if (safeString != null) {
            JSONObject jSONObject2 = new JSONObject(safeString);
            setBackgroundImageLayout(new BackgroundImageLayout(JSONObjectExtensionsKt.safeString(jSONObject2, "img"), JSONObjectExtensionsKt.safeString(jSONObject2, "tc"), JSONObjectExtensionsKt.safeString(jSONObject2, "bc")));
        }
    }

    public final boolean hasNotificationId() {
        return getAndroidNotificationId() != 0;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationConstants.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, getAndroidNotificationId());
            JSONArray jSONArray = new JSONArray();
            if (getGroupedNotifications() != null) {
                List<Notification> groupedNotifications2 = getGroupedNotifications();
                Intrinsics.checkNotNull(groupedNotifications2);
                for (Notification jSONObject2 : groupedNotifications2) {
                    jSONArray.put(jSONObject2.toJSONObject());
                }
            }
            jSONObject.put("groupedNotifications", jSONArray);
            jSONObject.put("notificationId", getNotificationId());
            jSONObject.put("templateName", getTemplateName());
            jSONObject.put("templateId", getTemplateId());
            jSONObject.put("title", getTitle());
            jSONObject.put(TtmlNode.TAG_BODY, getBody());
            jSONObject.put("smallIcon", getSmallIcon());
            jSONObject.put("largeIcon", getLargeIcon());
            jSONObject.put("bigPicture", getBigPicture());
            jSONObject.put("smallIconAccentColor", getSmallIconAccentColor());
            jSONObject.put("launchURL", getLaunchURL());
            jSONObject.put("sound", getSound());
            jSONObject.put("ledColor", getLedColor());
            jSONObject.put("lockScreenVisibility", getLockScreenVisibility());
            jSONObject.put("groupKey", getGroupKey());
            jSONObject.put("groupMessage", getGroupMessage());
            jSONObject.put("fromProjectNumber", getFromProjectNumber());
            jSONObject.put("collapseId", getCollapseId());
            jSONObject.put("priority", getPriority());
            if (getAdditionalData() != null) {
                jSONObject.put("additionalData", getAdditionalData());
            }
            if (getActionButtons() != null) {
                JSONArray jSONArray2 = new JSONArray();
                List<IActionButton> actionButtons2 = getActionButtons();
                Intrinsics.checkNotNull(actionButtons2);
                for (IActionButton next : actionButtons2) {
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.onesignal.notifications.internal.Notification.ActionButton");
                    jSONArray2.put(((ActionButton) next).toJSONObject());
                }
                jSONObject.put("actionButtons", jSONArray2);
            }
            jSONObject.put("rawPayload", getRawPayload());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "OSNotification{notificationExtender=" + this.notificationExtender + ", groupedNotifications=" + getGroupedNotifications() + ", androidNotificationId=" + getAndroidNotificationId() + ", notificationId='" + getNotificationId() + "', templateName='" + getTemplateName() + "', templateId='" + getTemplateId() + "', title='" + getTitle() + "', body='" + getBody() + "', additionalData=" + getAdditionalData() + ", smallIcon='" + getSmallIcon() + "', largeIcon='" + getLargeIcon() + "', bigPicture='" + getBigPicture() + "', smallIconAccentColor='" + getSmallIconAccentColor() + "', launchURL='" + getLaunchURL() + "', sound='" + getSound() + "', ledColor='" + getLedColor() + "', lockScreenVisibility=" + getLockScreenVisibility() + ", groupKey='" + getGroupKey() + "', groupMessage='" + getGroupMessage() + "', actionButtons=" + getActionButtons() + ", fromProjectNumber='" + getFromProjectNumber() + "', backgroundImageLayout=" + getBackgroundImageLayout() + ", collapseId='" + getCollapseId() + "', priority=" + getPriority() + ", rawPayload='" + getRawPayload() + "'}";
    }

    public void display() {
        this.displayWaiter.wake();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/onesignal/notifications/internal/Notification$ActionButton;", "Lcom/onesignal/notifications/IActionButton;", "id", "", "text", "icon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getId", "getText", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Notification.kt */
    public static final class ActionButton implements IActionButton {
        private final String icon;
        private final String id;
        private final String text;

        public ActionButton() {
            this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public String getIcon() {
            return this.icon;
        }

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public ActionButton(String str, String str2, String str3) {
            this.id = str;
            this.text = str2;
            this.icon = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionButton(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", getId());
                jSONObject.put("text", getText());
                jSONObject.put("icon", getIcon());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
    }
}
