package com.onesignal.inAppMessages.internal.hydrators;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator;", "", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "(Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/user/internal/properties/PropertiesModelStore;)V", "hydrateIAMMessageContent", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "jsonObject", "Lorg/json/JSONObject;", "hydrateIAMMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "jsonArray", "Lorg/json/JSONArray;", "taggedHTMLString", "", "untaggedString", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppHydrator.kt */
public final class InAppHydrator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LIQUID_TAG_SCRIPT = "\n\n<script>\n    setPlayerTags(%s);\n</script>";
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;

    public InAppHydrator(ITime iTime, PropertiesModelStore propertiesModelStore) {
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        this._time = iTime;
        this._propertiesModelStore = propertiesModelStore;
    }

    public final List<InAppMessage> hydrateIAMMessages(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonArray.getJSONObject(i)");
            InAppMessage inAppMessage = new InAppMessage(jSONObject, this._time);
            if (inAppMessage.getMessageId() != null) {
                arrayList.add(inAppMessage);
            }
        }
        return arrayList;
    }

    public final InAppMessageContent hydrateIAMMessageContent(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        try {
            InAppMessageContent inAppMessageContent = new InAppMessageContent(jSONObject);
            if (inAppMessageContent.getContentHtml() == null) {
                Logging.debug$default("displayMessage:OnSuccess: No HTML retrieved from loadMessageContent", (Throwable) null, 2, (Object) null);
                return null;
            }
            String contentHtml = inAppMessageContent.getContentHtml();
            Intrinsics.checkNotNull(contentHtml);
            inAppMessageContent.setContentHtml(taggedHTMLString(contentHtml));
            return inAppMessageContent;
        } catch (JSONException e) {
            Logging.error("Error attempting to hydrate InAppMessageContent: " + jSONObject, e);
            return null;
        }
    }

    private final String taggedHTMLString(String str) {
        MapModel<String> tags = ((PropertiesModel) this._propertiesModelStore.getModel()).getTags();
        Intrinsics.checkNotNull(tags, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        String jSONObject = new JSONObject(tags).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "tagsAsJson.toString()");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(LIQUID_TAG_SCRIPT, Arrays.copyOf(new Object[]{jSONObject}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/inAppMessages/internal/hydrators/InAppHydrator$Companion;", "", "()V", "LIQUID_TAG_SCRIPT", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppHydrator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
