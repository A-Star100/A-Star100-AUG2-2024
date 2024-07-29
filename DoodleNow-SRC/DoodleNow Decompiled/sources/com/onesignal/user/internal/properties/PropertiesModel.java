package com.onesignal.user.internal.properties;

import com.amplitude.api.Constants;
import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.Model;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u00108\u001a\u0004\u0018\u00010\u00012\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;H\u0014R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u00198F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0003\u001a\u0004\u0018\u00010\"8F@FX\u000e¢\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0003\u001a\u0004\u0018\u00010(8F@FX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u0004028F¢\u0006\u0006\u001a\u0004\b3\u00104R(\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\t¨\u0006<"}, d2 = {"Lcom/onesignal/user/internal/properties/PropertiesModel;", "Lcom/onesignal/common/modeling/Model;", "()V", "value", "", "country", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "language", "getLanguage", "setLanguage", "", "locationAccuracy", "getLocationAccuracy", "()Ljava/lang/Float;", "setLocationAccuracy", "(Ljava/lang/Float;)V", "", "locationBackground", "getLocationBackground", "()Ljava/lang/Boolean;", "setLocationBackground", "(Ljava/lang/Boolean;)V", "", "locationLatitude", "getLocationLatitude", "()Ljava/lang/Double;", "setLocationLatitude", "(Ljava/lang/Double;)V", "locationLongitude", "getLocationLongitude", "setLocationLongitude", "", "locationTimestamp", "getLocationTimestamp", "()Ljava/lang/Long;", "setLocationTimestamp", "(Ljava/lang/Long;)V", "", "locationType", "getLocationType", "()Ljava/lang/Integer;", "setLocationType", "(Ljava/lang/Integer;)V", "onesignalId", "getOnesignalId", "setOnesignalId", "tags", "Lcom/onesignal/common/modeling/MapModel;", "getTags", "()Lcom/onesignal/common/modeling/MapModel;", "timezone", "getTimezone", "setTimezone", "createModelForProperty", "property", "jsonObject", "Lorg/json/JSONObject;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PropertiesModel.kt */
public final class PropertiesModel extends Model {
    public PropertiesModel() {
        super((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, "onesignalId", (Function0) null, 2, (Object) null);
    }

    public final void setOnesignalId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, "onesignalId", str, (String) null, false, 12, (Object) null);
    }

    public final String getLanguage() {
        return Model.getOptStringProperty$default(this, Constants.AMP_TRACKING_OPTION_LANGUAGE, (Function0) null, 2, (Object) null);
    }

    public final void setLanguage(String str) {
        Model.setOptStringProperty$default(this, Constants.AMP_TRACKING_OPTION_LANGUAGE, str, (String) null, false, 12, (Object) null);
    }

    public final String getCountry() {
        return getStringProperty(Constants.AMP_TRACKING_OPTION_COUNTRY, PropertiesModel$country$2.INSTANCE);
    }

    public final void setCountry(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Model.setStringProperty$default(this, Constants.AMP_TRACKING_OPTION_COUNTRY, str, (String) null, false, 12, (Object) null);
    }

    public final String getTimezone() {
        return Model.getOptStringProperty$default(this, "timezone", (Function0) null, 2, (Object) null);
    }

    public final void setTimezone(String str) {
        Model.setOptStringProperty$default(this, "timezone", str, (String) null, false, 12, (Object) null);
    }

    public final MapModel<String> getTags() {
        return getMapModelProperty("tags", new PropertiesModel$tags$2(this));
    }

    public final Double getLocationLatitude() {
        return Model.getOptDoubleProperty$default(this, "locationLatitude", (Function0) null, 2, (Object) null);
    }

    public final void setLocationLatitude(Double d) {
        Model.setOptDoubleProperty$default(this, "locationLatitude", d, (String) null, false, 12, (Object) null);
    }

    public final Double getLocationLongitude() {
        return Model.getOptDoubleProperty$default(this, "locationLongitude", (Function0) null, 2, (Object) null);
    }

    public final void setLocationLongitude(Double d) {
        Model.setOptDoubleProperty$default(this, "locationLongitude", d, (String) null, false, 12, (Object) null);
    }

    public final Float getLocationAccuracy() {
        return Model.getOptFloatProperty$default(this, "locationAccuracy", (Function0) null, 2, (Object) null);
    }

    public final void setLocationAccuracy(Float f) {
        Model.setOptFloatProperty$default(this, "locationAccuracy", f, (String) null, false, 12, (Object) null);
    }

    public final Integer getLocationType() {
        return Model.getOptIntProperty$default(this, "locationType", (Function0) null, 2, (Object) null);
    }

    public final void setLocationType(Integer num) {
        Model.setOptIntProperty$default(this, "locationType", num, (String) null, false, 12, (Object) null);
    }

    public final Boolean getLocationBackground() {
        return Model.getOptBooleanProperty$default(this, "locationBackground", (Function0) null, 2, (Object) null);
    }

    public final void setLocationBackground(Boolean bool) {
        Model.setOptBooleanProperty$default(this, "locationBackground", bool, (String) null, false, 12, (Object) null);
    }

    public final Long getLocationTimestamp() {
        return Model.getOptLongProperty$default(this, "locationTimestamp", (Function0) null, 2, (Object) null);
    }

    public final void setLocationTimestamp(Long l) {
        Model.setOptLongProperty$default(this, "locationTimestamp", l, (String) null, false, 12, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Model createModelForProperty(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "property");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        if (!Intrinsics.areEqual((Object) str, (Object) "tags")) {
            return null;
        }
        MapModel mapModel = new MapModel(this, "tags");
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, SubscriberAttributeKt.JSON_NAME_KEY);
            String string = jSONObject.getString(next);
            Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
            Model.setStringProperty$default(mapModel, next, string, (String) null, false, 12, (Object) null);
        }
        return mapModel;
    }
}
