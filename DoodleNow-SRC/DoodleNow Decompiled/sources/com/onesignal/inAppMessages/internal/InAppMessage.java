package com.onesignal.inAppMessages.internal;

import com.onesignal.common.DateUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.IInAppMessage;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 N2\u00020\u0001:\u0001NB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B5\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eB\u0017\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u000e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u000208J\u0013\u0010;\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\b\u0010>\u001a\u00020?H\u0016J\u000e\u0010@\u001a\u00020\u00032\u0006\u00109\u001a\u00020\bJ\u0012\u0010A\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J6\u0010B\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0C0Cj\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020/0Cj\b\u0012\u0004\u0012\u00020/`D`D2\u0006\u0010E\u001a\u00020FH\u0002JT\u0010G\u001aF\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0H0Hj*\u0012\u0004\u0012\u00020\b\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0Hj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`I`I2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010J\u001a\u0002082\u0006\u00109\u001a\u00020\bJ\u0006\u0010K\u001a\u00020\u0003J\u0006\u0010L\u001a\u00020\u0010J\b\u0010M\u001a\u00020\bH\u0016R\u000e\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010#\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010#R\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010#R\u001a\u0010(\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010&R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R6\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0.2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0.@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u00102RN\u00104\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b03032\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0303@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006O"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessage;", "Lcom/onesignal/inAppMessages/IInAppMessage;", "isPreview", "", "time", "Lcom/onesignal/core/internal/time/ITime;", "(ZLcom/onesignal/core/internal/time/ITime;)V", "messageId", "", "clickIds", "", "displayedInSession", "redisplayStats", "Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;", "(Ljava/lang/String;Ljava/util/Set;ZLcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;Lcom/onesignal/core/internal/time/ITime;)V", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lcom/onesignal/core/internal/time/ITime;)V", "(Ljava/lang/String;Lcom/onesignal/core/internal/time/ITime;)V", "actionTaken", "<set-?>", "", "clickedClickIds", "getClickedClickIds", "()Ljava/util/Set;", "displayDuration", "", "getDisplayDuration", "()D", "setDisplayDuration", "(D)V", "endTime", "Ljava/util/Date;", "hasLiquid", "getHasLiquid", "()Z", "isDisplayedInSession", "setDisplayedInSession", "(Z)V", "isFinished", "isTriggerChanged", "setTriggerChanged", "getMessageId", "()Ljava/lang/String;", "getRedisplayStats", "()Lcom/onesignal/inAppMessages/internal/InAppMessageRedisplayStats;", "", "Lcom/onesignal/inAppMessages/internal/Trigger;", "triggers", "getTriggers", "()Ljava/util/List;", "", "variants", "getVariants", "()Ljava/util/Map;", "addClickId", "", "clickId", "clearClickIds", "equals", "o", "", "hashCode", "", "isClickAvailable", "parseEndTimeJson", "parseTriggerJson", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "triggersJson", "Lorg/json/JSONArray;", "parseVariants", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "removeClickId", "takeActionAsUnique", "toJSONObject", "toString", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessage.kt */
public final class InAppMessage implements IInAppMessage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DISPLAY_DURATION = "displayDuration";
    private static final String END_TIME = "end_time";
    private static final String HAS_LIQUID = "has_liquid";
    private static final String IAM_ID = "messageId";
    private static final String IAM_REDISPLAY_STATS = "redisplay";
    private static final String IAM_TRIGGERS = "triggers";
    private static final String IAM_VARIANTS = "variants";
    private static final String ID = "id";
    private boolean actionTaken;
    private Set<String> clickedClickIds;
    private double displayDuration;
    private Date endTime;
    private boolean hasLiquid;
    private boolean isDisplayedInSession;
    private boolean isPreview;
    private boolean isTriggerChanged;
    private final String messageId;
    private InAppMessageRedisplayStats redisplayStats;
    private List<? extends List<Trigger>> triggers;
    private Map<String, ? extends Map<String, String>> variants;

    public final Set<String> getClickedClickIds() {
        return this.clickedClickIds;
    }

    public final double getDisplayDuration() {
        return this.displayDuration;
    }

    public final boolean getHasLiquid() {
        return this.hasLiquid;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public final InAppMessageRedisplayStats getRedisplayStats() {
        return this.redisplayStats;
    }

    public final List<List<Trigger>> getTriggers() {
        return this.triggers;
    }

    public final Map<String, Map<String, String>> getVariants() {
        return this.variants;
    }

    public final boolean isDisplayedInSession() {
        return this.isDisplayedInSession;
    }

    public final boolean isPreview() {
        return this.isPreview;
    }

    public final boolean isTriggerChanged() {
        return this.isTriggerChanged;
    }

    public final void setDisplayDuration(double d) {
        this.displayDuration = d;
    }

    public final void setDisplayedInSession(boolean z) {
        this.isDisplayedInSession = z;
    }

    public final void setTriggerChanged(boolean z) {
        this.isTriggerChanged = z;
    }

    public final boolean takeActionAsUnique() {
        if (this.actionTaken) {
            return false;
        }
        this.actionTaken = true;
        return true;
    }

    public InAppMessage(String str, ITime iTime) {
        Intrinsics.checkNotNullParameter(str, IAM_ID);
        Intrinsics.checkNotNullParameter(iTime, "time");
        this.messageId = str;
        this.variants = MapsKt.emptyMap();
        this.triggers = CollectionsKt.emptyList();
        this.clickedClickIds = new LinkedHashSet();
        this.redisplayStats = new InAppMessageRedisplayStats(iTime);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessage(boolean z, ITime iTime) {
        this("", iTime);
        Intrinsics.checkNotNullParameter(iTime, "time");
        this.isPreview = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public InAppMessage(String str, Set<String> set, boolean z, InAppMessageRedisplayStats inAppMessageRedisplayStats, ITime iTime) {
        this(str, iTime);
        Intrinsics.checkNotNullParameter(str, IAM_ID);
        Intrinsics.checkNotNullParameter(set, "clickIds");
        Intrinsics.checkNotNullParameter(inAppMessageRedisplayStats, "redisplayStats");
        Intrinsics.checkNotNullParameter(iTime, "time");
        this.clickedClickIds = CollectionsKt.toMutableSet(set);
        this.isDisplayedInSession = z;
        this.redisplayStats = inAppMessageRedisplayStats;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InAppMessage(org.json.JSONObject r3, com.onesignal.core.internal.time.ITime r4) {
        /*
            r2 = this;
            java.lang.String r0 = "json"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "time"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "id"
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "json.getString(ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>((java.lang.String) r0, (com.onesignal.core.internal.time.ITime) r4)
            java.lang.String r0 = "variants"
            org.json.JSONObject r0 = r3.getJSONObject(r0)
            java.lang.String r1 = "json.getJSONObject(IAM_VARIANTS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.HashMap r0 = r2.parseVariants(r0)
            java.util.Map r0 = (java.util.Map) r0
            r2.variants = r0
            java.lang.String r0 = "triggers"
            org.json.JSONArray r0 = r3.getJSONArray(r0)
            java.lang.String r1 = "json.getJSONArray(IAM_TRIGGERS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.ArrayList r0 = r2.parseTriggerJson(r0)
            java.util.List r0 = (java.util.List) r0
            r2.triggers = r0
            java.util.Date r0 = r2.parseEndTimeJson(r3)
            r2.endTime = r0
            java.lang.String r0 = "has_liquid"
            boolean r1 = r3.has(r0)
            if (r1 == 0) goto L_0x0052
            boolean r0 = r3.getBoolean(r0)
            r2.hasLiquid = r0
        L_0x0052:
            java.lang.String r0 = "redisplay"
            boolean r1 = r3.has(r0)
            if (r1 == 0) goto L_0x006a
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r1 = new com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats
            org.json.JSONObject r3 = r3.getJSONObject(r0)
            java.lang.String r0 = "json.getJSONObject(IAM_REDISPLAY_STATS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r1.<init>(r3, r4)
            r2.redisplayStats = r1
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessage.<init>(org.json.JSONObject, com.onesignal.core.internal.time.ITime):void");
    }

    private final Date parseEndTimeJson(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(END_TIME);
            Intrinsics.checkNotNullExpressionValue(string, "{\n                json.g…g(END_TIME)\n            }");
            if (Intrinsics.areEqual((Object) string, (Object) "null")) {
                return null;
            }
            try {
                return DateUtils.INSTANCE.iso8601Format().parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        } catch (JSONException unused) {
            return null;
        }
    }

    private final HashMap<String, HashMap<String, String>> parseVariants(JSONObject jSONObject) throws JSONException {
        HashMap<String, HashMap<String, String>> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            HashMap hashMap2 = new HashMap();
            Iterator<String> keys2 = jSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                Intrinsics.checkNotNullExpressionValue(next2, "languageType");
                String string = jSONObject2.getString(next2);
                Intrinsics.checkNotNullExpressionValue(string, "variant.getString(languageType)");
                hashMap2.put(next2, string);
            }
            Intrinsics.checkNotNullExpressionValue(next, "variantType");
            hashMap.put(next, hashMap2);
        }
        return hashMap;
    }

    private final ArrayList<ArrayList<Trigger>> parseTriggerJson(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<Trigger>> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            ArrayList arrayList2 = new ArrayList();
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "ands.getJSONObject(j)");
                arrayList2.add(new Trigger(jSONObject));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAM_ID, getMessageId());
            JSONObject jSONObject2 = new JSONObject();
            for (String next : this.variants.keySet()) {
                Object obj = this.variants.get(next);
                Intrinsics.checkNotNull(obj);
                Map map = (Map) obj;
                JSONObject jSONObject3 = new JSONObject();
                for (String str : map.keySet()) {
                    jSONObject3.put(str, map.get(str));
                }
                jSONObject2.put(next, jSONObject3);
            }
            jSONObject.put(IAM_VARIANTS, jSONObject2);
            jSONObject.put(DISPLAY_DURATION, this.displayDuration);
            jSONObject.put(IAM_REDISPLAY_STATS, this.redisplayStats.toJSONObject());
            JSONArray jSONArray = new JSONArray();
            for (List<Trigger> it : this.triggers) {
                JSONArray jSONArray2 = new JSONArray();
                for (Trigger jSONObject4 : it) {
                    jSONArray2.put(jSONObject4.toJSONObject());
                }
                jSONArray.put(jSONArray2);
            }
            jSONObject.put(IAM_TRIGGERS, jSONArray);
            if (this.endTime != null) {
                jSONObject.put(END_TIME, DateUtils.INSTANCE.iso8601Format().format(this.endTime));
            }
            jSONObject.put(HAS_LIQUID, this.hasLiquid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final boolean isClickAvailable(String str) {
        Intrinsics.checkNotNullParameter(str, "clickId");
        return !this.clickedClickIds.contains(str);
    }

    public final void clearClickIds() {
        this.clickedClickIds.clear();
    }

    public final void addClickId(String str) {
        Intrinsics.checkNotNullParameter(str, "clickId");
        this.clickedClickIds.add(str);
    }

    public final void removeClickId(String str) {
        Intrinsics.checkNotNullParameter(str, "clickId");
        this.clickedClickIds.remove(str);
    }

    public String toString() {
        return "OSInAppMessage{messageId='" + getMessageId() + "', variants=" + this.variants + ", triggers=" + this.triggers + ", clickedClickIds=" + this.clickedClickIds + ", redisplayStats=" + this.redisplayStats + ", displayDuration=" + this.displayDuration + ", displayedInSession=" + this.isDisplayedInSession + ", triggerChanged=" + this.isTriggerChanged + ", actionTaken=" + this.actionTaken + ", isPreview=" + this.isPreview + ", endTime=" + this.endTime + ", hasLiquid=" + this.hasLiquid + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual((Object) getMessageId(), (Object) ((InAppMessage) obj).getMessageId());
    }

    public int hashCode() {
        return getMessageId().hashCode();
    }

    public final boolean isFinished() {
        if (this.endTime == null) {
            return false;
        }
        Date date = new Date();
        Date date2 = this.endTime;
        Intrinsics.checkNotNull(date2);
        return date2.before(date);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessage$Companion;", "", "()V", "DISPLAY_DURATION", "", "END_TIME", "HAS_LIQUID", "IAM_ID", "IAM_REDISPLAY_STATS", "IAM_TRIGGERS", "IAM_VARIANTS", "ID", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
