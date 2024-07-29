package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickResult;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010.\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0006\u0010/\u001a\u00020\u0003R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\nR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "json", "Lorg/json/JSONObject;", "promptFactory", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "(Lorg/json/JSONObject;Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;)V", "actionId", "", "getActionId", "()Ljava/lang/String;", "clickId", "getClickId", "closingMessage", "", "getClosingMessage", "()Z", "isFirstClick", "setFirstClick", "(Z)V", "outcomes", "", "Lcom/onesignal/inAppMessages/internal/InAppMessageOutcome;", "getOutcomes", "()Ljava/util/List;", "pageId", "getPageId", "prompts", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "getPrompts", "tags", "Lcom/onesignal/inAppMessages/internal/InAppMessageTag;", "getTags", "()Lcom/onesignal/inAppMessages/internal/InAppMessageTag;", "setTags", "(Lcom/onesignal/inAppMessages/internal/InAppMessageTag;)V", "url", "getUrl", "urlTarget", "Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "getUrlTarget", "()Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "setUrlTarget", "(Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;)V", "parseOutcomes", "", "parsePrompts", "toJSONObject", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageClickResult.kt */
public final class InAppMessageClickResult implements IInAppMessageClickResult {
    private static final String CLICK_NAME = "click_name";
    private static final String CLICK_URL = "click_url";
    private static final String CLOSE = "close";
    private static final String CLOSES_MESSAGE = "closes_message";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIRST_CLICK = "first_click";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String OUTCOMES = "outcomes";
    private static final String PAGE_ID = "pageId";
    private static final String PROMPTS = "prompts";
    private static final String TAGS = "tags";
    private static final String URL = "url";
    private static final String URL_TARGET = "url_target";
    private final String actionId;
    private final String clickId;
    private final boolean closingMessage;
    private boolean isFirstClick;
    private final List<InAppMessageOutcome> outcomes = new ArrayList();
    private final String pageId;
    private final List<InAppMessagePrompt> prompts = new ArrayList();
    private InAppMessageTag tags;
    private final String url;
    private InAppMessageActionUrlType urlTarget;

    public String getActionId() {
        return this.actionId;
    }

    public final String getClickId() {
        return this.clickId;
    }

    public boolean getClosingMessage() {
        return this.closingMessage;
    }

    public final List<InAppMessageOutcome> getOutcomes() {
        return this.outcomes;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final List<InAppMessagePrompt> getPrompts() {
        return this.prompts;
    }

    public final InAppMessageTag getTags() {
        return this.tags;
    }

    public String getUrl() {
        return this.url;
    }

    public InAppMessageActionUrlType getUrlTarget() {
        return this.urlTarget;
    }

    public final boolean isFirstClick() {
        return this.isFirstClick;
    }

    public final void setFirstClick(boolean z) {
        this.isFirstClick = z;
    }

    public final void setTags(InAppMessageTag inAppMessageTag) {
        this.tags = inAppMessageTag;
    }

    public void setUrlTarget(InAppMessageActionUrlType inAppMessageActionUrlType) {
        this.urlTarget = inAppMessageActionUrlType;
    }

    public InAppMessageClickResult(JSONObject jSONObject, IInAppMessagePromptFactory iInAppMessagePromptFactory) {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        Intrinsics.checkNotNullParameter(iInAppMessagePromptFactory, "promptFactory");
        this.clickId = jSONObject.optString("id", (String) null);
        this.actionId = jSONObject.optString("name", (String) null);
        this.url = jSONObject.optString("url", (String) null);
        this.pageId = jSONObject.optString("pageId", (String) null);
        setUrlTarget(InAppMessageActionUrlType.Companion.fromString(jSONObject.optString(URL_TARGET, (String) null)));
        if (getUrlTarget() == null) {
            setUrlTarget(InAppMessageActionUrlType.IN_APP_WEBVIEW);
        }
        this.closingMessage = jSONObject.optBoolean(CLOSE, true);
        if (jSONObject.has(OUTCOMES)) {
            parseOutcomes(jSONObject);
        }
        if (jSONObject.has("tags")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("tags");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(TAGS)");
            this.tags = new InAppMessageTag(jSONObject2);
        }
        if (jSONObject.has(PROMPTS)) {
            parsePrompts(jSONObject, iInAppMessagePromptFactory);
        }
    }

    private final void parseOutcomes(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(OUTCOMES);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            List<InAppMessageOutcome> list = this.outcomes;
            Object obj = jSONArray.get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            list.add(new InAppMessageOutcome((JSONObject) obj));
        }
    }

    private final void parsePrompts(JSONObject jSONObject, IInAppMessagePromptFactory iInAppMessagePromptFactory) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(PROMPTS);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String string = jSONArray.getString(i);
            Intrinsics.checkNotNullExpressionValue(string, "promptType");
            InAppMessagePrompt createPrompt = iInAppMessagePromptFactory.createPrompt(string);
            if (createPrompt != null) {
                this.prompts.add(createPrompt);
            }
        }
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CLICK_NAME, getActionId());
            jSONObject.put(CLICK_URL, getUrl());
            jSONObject.put(FIRST_CLICK, this.isFirstClick);
            jSONObject.put(CLOSES_MESSAGE, getClosingMessage());
            JSONArray jSONArray = new JSONArray();
            for (InAppMessageOutcome jSONObject2 : this.outcomes) {
                jSONArray.put(jSONObject2.toJSONObject());
            }
            jSONObject.put(OUTCOMES, jSONArray);
            InAppMessageTag inAppMessageTag = this.tags;
            if (inAppMessageTag != null) {
                Intrinsics.checkNotNull(inAppMessageTag);
                jSONObject.put("tags", inAppMessageTag.toJSONObject());
            }
            if (getUrlTarget() != null) {
                jSONObject.put(URL_TARGET, String.valueOf(getUrlTarget()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult$Companion;", "", "()V", "CLICK_NAME", "", "CLICK_URL", "CLOSE", "CLOSES_MESSAGE", "FIRST_CLICK", "ID", "NAME", "OUTCOMES", "PAGE_ID", "PROMPTS", "TAGS", "URL", "URL_TARGET", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessageClickResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
