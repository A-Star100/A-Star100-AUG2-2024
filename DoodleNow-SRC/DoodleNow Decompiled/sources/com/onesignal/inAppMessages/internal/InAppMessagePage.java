package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0010\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "pageId", "", "getPageId", "()Ljava/lang/String;", "setPageId", "(Ljava/lang/String;)V", "pageIndex", "getPageIndex", "setPageIndex", "toJSONObject", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessagePage.kt */
public class InAppMessagePage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAGE_ID = "pageId";
    public static final String PAGE_INDEX = "pageIndex";
    private String pageId;
    private String pageIndex;

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageIndex() {
        return this.pageIndex;
    }

    public final void setPageId(String str) {
        this.pageId = str;
    }

    public final void setPageIndex(String str) {
        this.pageIndex = str;
    }

    public InAppMessagePage(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.pageId = jSONObject.optString(PAGE_ID, (String) null);
        this.pageIndex = jSONObject.optString(PAGE_INDEX, (String) null);
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PAGE_ID, this.pageId);
            jSONObject.put(PAGE_INDEX, this.pageIndex);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessagePage$Companion;", "", "()V", "PAGE_ID", "", "PAGE_INDEX", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessagePage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
