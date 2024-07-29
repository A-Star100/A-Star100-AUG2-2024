package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b)\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\"\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010#H\u0004J\"\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010#H\u0004J\"\u0010&\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010#H\u0004J\"\u0010'\u001a\u00020(2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010#H\u0004J(\u0010)\u001a\u0002H*\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u0005H\b¢\u0006\u0002\u0010,J\"\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010#H\u0004J\"\u0010/\u001a\u0002002\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010#H\u0004J4\u00101\u001a\b\u0012\u0004\u0012\u0002H*0\u0019\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0016\b\u0002\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\u0019\u0018\u00010#H\u0004J\"\u00102\u001a\u0002032\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010#H\u0004J4\u00104\u001a\b\u0012\u0004\u0012\u0002H*05\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0016\b\u0002\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*05\u0018\u00010#H\u0004J&\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010#H\u0004J&\u00107\u001a\u0004\u0018\u00010%2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010#H\u0004J+\u00108\u001a\u0004\u0018\u00010\u000f2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010#H\u0004¢\u0006\u0002\u00109J+\u0010:\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010#H\u0004¢\u0006\u0002\u0010;J*\u0010<\u001a\u0004\u0018\u0001H*\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u0005H\b¢\u0006\u0002\u0010,J+\u0010=\u001a\u0004\u0018\u00010.2\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010#H\u0004¢\u0006\u0002\u0010>J+\u0010?\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010#H\u0004¢\u0006\u0002\u0010@J8\u0010A\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u0019\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0018\b\u0002\u0010\"\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u0019\u0018\u00010#H\u0004J+\u0010B\u001a\u0004\u0018\u0001032\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010#H\u0004¢\u0006\u0002\u0010CJ8\u0010D\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u000105\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u0018\b\u0002\u0010\"\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H*\u0018\u000105\u0018\u00010#H\u0004J&\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u00052\u0012\b\u0002\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010#H\u0004J\"\u0010F\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010#H\u0004J\u000e\u0010G\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010H\u001a\u00020I2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010J\u001a\u00020I2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010K\u001a\u00020\u0000J4\u0010L\u001a\u00020I2\u0006\u0010M\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010N\u001a\u00020\u00052\b\u0010O\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J*\u0010Q\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010S\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020%2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010T\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010U\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020(2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJD\u0010V\u001a\u00020I\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002H*2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fH\b¢\u0006\u0002\u0010WJ*\u0010X\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020.2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010Y\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002002\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ6\u0010Z\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H*0\u00192\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010[\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u0002032\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ6\u0010\\\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H*052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ,\u0010]\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ,\u0010^\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ1\u0010_\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010`J1\u0010a\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010bJF\u0010c\u001a\u00020I\"\u0010\b\u0000\u0010*\u0018\u0001*\b\u0012\u0004\u0012\u0002H*0+2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u0001H*2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fH\b¢\u0006\u0002\u0010WJ1\u0010d\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010eJ1\u0010f\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u0001002\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010gJ8\u0010h\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u00010\u00192\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ1\u0010i\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u0001032\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000f¢\u0006\u0002\u0010jJ8\u0010k\u001a\u00020I\"\u0004\b\u0000\u0010*2\u0006\u0010!\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H*\u0018\u0001052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ,\u0010l\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ*\u0010m\u001a\u00020I2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u00052\b\b\u0002\u0010R\u001a\u00020\u000fJ\u0010\u0010n\u001a\u00020I2\u0006\u0010o\u001a\u00020\u0002H\u0016J\u0006\u0010p\u001a\u00020\u001fJ\u0010\u0010q\u001a\u00020I2\u0006\u0010o\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006r"}, d2 = {"Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/IModelChangedHandler;", "_parentModel", "_parentProperty", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "changeNotifier", "Lcom/onesignal/common/events/EventProducer;", "data", "", "", "getData", "()Ljava/util/Map;", "hasSubscribers", "", "getHasSubscribers", "()Z", "value", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "createListForProperty", "", "property", "jsonArray", "Lorg/json/JSONArray;", "createModelForProperty", "jsonObject", "Lorg/json/JSONObject;", "getAnyProperty", "name", "create", "Lkotlin/Function0;", "getBigDecimalProperty", "Ljava/math/BigDecimal;", "getBooleanProperty", "getDoubleProperty", "", "getEnumProperty", "T", "", "(Ljava/lang/String;)Ljava/lang/Enum;", "getFloatProperty", "", "getIntProperty", "", "getListProperty", "getLongProperty", "", "getMapModelProperty", "Lcom/onesignal/common/modeling/MapModel;", "getOptAnyProperty", "getOptBigDecimalProperty", "getOptBooleanProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Boolean;", "getOptDoubleProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Double;", "getOptEnumProperty", "getOptFloatProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Float;", "getOptIntProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "getOptListProperty", "getOptLongProperty", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Long;", "getOptMapModelProperty", "getOptStringProperty", "getStringProperty", "hasProperty", "initializeFromJson", "", "initializeFromModel", "model", "notifyChanged", "path", "tag", "oldValue", "newValue", "setAnyProperty", "forceChange", "setBigDecimalProperty", "setBooleanProperty", "setDoubleProperty", "setEnumProperty", "(Ljava/lang/String;Ljava/lang/Enum;Ljava/lang/String;Z)V", "setFloatProperty", "setIntProperty", "setListProperty", "setLongProperty", "setMapModelProperty", "setOptAnyProperty", "setOptBigDecimalProperty", "setOptBooleanProperty", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)V", "setOptDoubleProperty", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Z)V", "setOptEnumProperty", "setOptFloatProperty", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Z)V", "setOptIntProperty", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "setOptListProperty", "setOptLongProperty", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Z)V", "setOptMapModelProperty", "setOptStringProperty", "setStringProperty", "subscribe", "handler", "toJSON", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Model.kt */
public class Model implements IEventNotifier<IModelChangedHandler> {
    private Model _parentModel;
    private final String _parentProperty;
    private final EventProducer<IModelChangedHandler> changeNotifier;
    private final Map<String, Object> data;

    public Model() {
        this((Model) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public List<?> createListForProperty(String str, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(str, "property");
        Intrinsics.checkNotNullParameter(jSONArray, "jsonArray");
        return null;
    }

    /* access modifiers changed from: protected */
    public Model createModelForProperty(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "property");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        return null;
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getData() {
        return this.data;
    }

    public Model(Model model, String str) {
        this._parentModel = model;
        this._parentProperty = str;
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.data = synchronizedMap;
        this.changeNotifier = new EventProducer<>();
        Model model2 = this._parentModel;
        if (model2 != null && str == null) {
            throw new Exception("If parent model is set, parent property must also be set.");
        } else if (model2 == null && str != null) {
            throw new Exception("If parent property is set, parent model must also be set.");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Model(Model model, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : model, (i & 2) != 0 ? null : str);
    }

    public final String getId() {
        return getStringProperty$default(this, "id", (Function0) null, 2, (Object) null);
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        setStringProperty$default(this, "id", str, (String) null, false, 12, (Object) null);
    }

    public final void initializeFromJson(JSONObject jSONObject) {
        Method method;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        synchronized (this.data) {
            this.data.clear();
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONObject) {
                    Intrinsics.checkNotNullExpressionValue(next, "property");
                    Model createModelForProperty = createModelForProperty(next, (JSONObject) obj);
                    if (createModelForProperty != null) {
                        this.data.put(next, createModelForProperty);
                    }
                } else if (obj instanceof JSONArray) {
                    Intrinsics.checkNotNullExpressionValue(next, "property");
                    List<?> createListForProperty = createListForProperty(next, (JSONArray) obj);
                    if (createListForProperty != null) {
                        this.data.put(next, createListForProperty);
                    }
                } else {
                    Method[] methods = getClass().getMethods();
                    Intrinsics.checkNotNullExpressionValue(methods, "this.javaClass.methods");
                    Object[] objArr = (Object[]) methods;
                    int length = objArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            method = null;
                            break;
                        }
                        method = objArr[i];
                        Method method2 = (Method) method;
                        if (!Intrinsics.areEqual((Object) method2.getReturnType(), (Object) Void.class)) {
                            String name = method2.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "it.name");
                            Intrinsics.checkNotNullExpressionValue(next, "property");
                            if (StringsKt.contains((CharSequence) name, (CharSequence) next, true)) {
                                break;
                            }
                        }
                        i++;
                    }
                    Method method3 = method;
                    if (method3 == null) {
                        Map<String, Object> map = this.data;
                        Intrinsics.checkNotNullExpressionValue(next, "property");
                        map.put(next, jSONObject.get(next));
                    } else {
                        Class<?> returnType = method3.getReturnType();
                        if (!Intrinsics.areEqual((Object) returnType, (Object) Double.TYPE)) {
                            if (!Intrinsics.areEqual((Object) returnType, (Object) Double.class)) {
                                if (!Intrinsics.areEqual((Object) returnType, (Object) Long.TYPE)) {
                                    if (!Intrinsics.areEqual((Object) returnType, (Object) Long.class)) {
                                        if (!Intrinsics.areEqual((Object) returnType, (Object) Float.TYPE)) {
                                            if (!Intrinsics.areEqual((Object) returnType, (Object) Float.class)) {
                                                if (!Intrinsics.areEqual((Object) returnType, (Object) Integer.TYPE)) {
                                                    if (!Intrinsics.areEqual((Object) returnType, (Object) Integer.class)) {
                                                        if (!Intrinsics.areEqual((Object) returnType, (Object) Boolean.TYPE)) {
                                                            if (!Intrinsics.areEqual((Object) returnType, (Object) Boolean.class)) {
                                                                if (!Intrinsics.areEqual((Object) returnType, (Object) String.class)) {
                                                                    if (!Intrinsics.areEqual((Object) returnType, (Object) String.class)) {
                                                                        Map<String, Object> map2 = this.data;
                                                                        Intrinsics.checkNotNullExpressionValue(next, "property");
                                                                        map2.put(next, jSONObject.get(next));
                                                                    }
                                                                }
                                                                Map<String, Object> map3 = this.data;
                                                                Intrinsics.checkNotNullExpressionValue(next, "property");
                                                                map3.put(next, jSONObject.getString(next));
                                                            }
                                                        }
                                                        Map<String, Object> map4 = this.data;
                                                        Intrinsics.checkNotNullExpressionValue(next, "property");
                                                        map4.put(next, Boolean.valueOf(jSONObject.getBoolean(next)));
                                                    }
                                                }
                                                Map<String, Object> map5 = this.data;
                                                Intrinsics.checkNotNullExpressionValue(next, "property");
                                                map5.put(next, Integer.valueOf(jSONObject.getInt(next)));
                                            }
                                        }
                                        Map<String, Object> map6 = this.data;
                                        Intrinsics.checkNotNullExpressionValue(next, "property");
                                        map6.put(next, Float.valueOf((float) jSONObject.getDouble(next)));
                                    }
                                }
                                Map<String, Object> map7 = this.data;
                                Intrinsics.checkNotNullExpressionValue(next, "property");
                                map7.put(next, Long.valueOf(jSONObject.getLong(next)));
                            }
                        }
                        Map<String, Object> map8 = this.data;
                        Intrinsics.checkNotNullExpressionValue(next, "property");
                        map8.put(next, Double.valueOf(jSONObject.getDouble(next)));
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void initializeFromModel(String str, Model model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        for (Map.Entry next : model.data.entrySet()) {
            if (next.getValue() instanceof Model) {
                Object value = next.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.onesignal.common.modeling.Model");
                Model model2 = (Model) value;
                model2._parentModel = this;
                Intrinsics.checkNotNullExpressionValue(synchronizedMap, "newData");
                synchronizedMap.put(next.getKey(), model2);
            } else {
                Intrinsics.checkNotNullExpressionValue(synchronizedMap, "newData");
                synchronizedMap.put(next.getKey(), next.getValue());
            }
        }
        if (str != null) {
            Intrinsics.checkNotNullExpressionValue(synchronizedMap, "newData");
            synchronizedMap.put("id", str);
        }
        synchronized (this.data) {
            this.data.clear();
            Map<String, Object> map = this.data;
            Intrinsics.checkNotNullExpressionValue(synchronizedMap, "newData");
            map.putAll(synchronizedMap);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void setEnumProperty$default(Model model, String str, Enum enumR, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(enumR, "value");
            Intrinsics.checkNotNullParameter(str2, "tag");
            model.setOptAnyProperty(str, enumR.toString(), str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEnumProperty");
    }

    public static /* synthetic */ void setMapModelProperty$default(Model model, String str, MapModel mapModel, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setMapModelProperty(str, mapModel, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMapModelProperty");
    }

    public final <T> void setMapModelProperty(String str, MapModel<T> mapModel, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(mapModel, "value");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptMapModelProperty(str, mapModel, str2, z);
    }

    public static /* synthetic */ void setListProperty$default(Model model, String str, List list, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setListProperty(str, list, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setListProperty");
    }

    public final <T> void setListProperty(String str, List<? extends T> list, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "value");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptListProperty(str, list, str2, z);
    }

    public static /* synthetic */ void setStringProperty$default(Model model, String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str3 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setStringProperty(str, str2, str3, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStringProperty");
    }

    public final void setStringProperty(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(str3, "tag");
        setOptStringProperty(str, str2, str3, z);
    }

    public static /* synthetic */ void setBooleanProperty$default(Model model, String str, boolean z, String str2, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z2 = false;
            }
            model.setBooleanProperty(str, z, str2, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBooleanProperty");
    }

    public final void setBooleanProperty(String str, boolean z, String str2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptBooleanProperty(str, Boolean.valueOf(z), str2, z2);
    }

    public static /* synthetic */ void setLongProperty$default(Model model, String str, long j, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                z = false;
            }
            model.setLongProperty(str, j, str3, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLongProperty");
    }

    public final void setLongProperty(String str, long j, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptLongProperty(str, Long.valueOf(j), str2, z);
    }

    public static /* synthetic */ void setDoubleProperty$default(Model model, String str, double d, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            String str3 = str2;
            if ((i & 8) != 0) {
                z = false;
            }
            model.setDoubleProperty(str, d, str3, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDoubleProperty");
    }

    public final void setDoubleProperty(String str, double d, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptDoubleProperty(str, Double.valueOf(d), str2, z);
    }

    public static /* synthetic */ void setFloatProperty$default(Model model, String str, float f, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setFloatProperty(str, f, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFloatProperty");
    }

    public final void setFloatProperty(String str, float f, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptFloatProperty(str, Float.valueOf(f), str2, z);
    }

    public static /* synthetic */ void setIntProperty$default(Model model, String str, int i, String str2, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            model.setIntProperty(str, i, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setIntProperty");
    }

    public final void setIntProperty(String str, int i, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptIntProperty(str, Integer.valueOf(i), str2, z);
    }

    public static /* synthetic */ void setBigDecimalProperty$default(Model model, String str, BigDecimal bigDecimal, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setBigDecimalProperty(str, bigDecimal, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBigDecimalProperty");
    }

    public final void setBigDecimalProperty(String str, BigDecimal bigDecimal, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bigDecimal, "value");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptBigDecimalProperty(str, bigDecimal, str2, z);
    }

    public static /* synthetic */ void setAnyProperty$default(Model model, String str, Object obj, String str2, boolean z, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setAnyProperty(str, obj, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAnyProperty");
    }

    public final void setAnyProperty(String str, Object obj, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(obj, "value");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, obj, str2, z);
    }

    public static /* synthetic */ void setOptEnumProperty$default(Model model, String str, Enum enumR, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "tag");
            model.setOptAnyProperty(str, enumR != null ? enumR.toString() : null, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptEnumProperty");
    }

    public final /* synthetic */ <T extends Enum<T>> void setOptEnumProperty(String str, T t, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, t != null ? t.toString() : null, str2, z);
    }

    public static /* synthetic */ void setOptMapModelProperty$default(Model model, String str, MapModel mapModel, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptMapModelProperty(str, mapModel, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptMapModelProperty");
    }

    public final <T> void setOptMapModelProperty(String str, MapModel<T> mapModel, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, mapModel, str2, z);
    }

    public static /* synthetic */ void setOptListProperty$default(Model model, String str, List list, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptListProperty(str, list, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptListProperty");
    }

    public final <T> void setOptListProperty(String str, List<? extends T> list, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, list, str2, z);
    }

    public static /* synthetic */ void setOptStringProperty$default(Model model, String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str3 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptStringProperty(str, str2, str3, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptStringProperty");
    }

    public final void setOptStringProperty(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str3, "tag");
        setOptAnyProperty(str, str2, str3, z);
    }

    public static /* synthetic */ void setOptBooleanProperty$default(Model model, String str, Boolean bool, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptBooleanProperty(str, bool, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBooleanProperty");
    }

    public final void setOptBooleanProperty(String str, Boolean bool, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, bool, str2, z);
    }

    public static /* synthetic */ void setOptLongProperty$default(Model model, String str, Long l, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptLongProperty(str, l, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptLongProperty");
    }

    public final void setOptLongProperty(String str, Long l, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, l, str2, z);
    }

    public static /* synthetic */ void setOptDoubleProperty$default(Model model, String str, Double d, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptDoubleProperty(str, d, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptDoubleProperty");
    }

    public final void setOptDoubleProperty(String str, Double d, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, d, str2, z);
    }

    public static /* synthetic */ void setOptFloatProperty$default(Model model, String str, Float f, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptFloatProperty(str, f, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptFloatProperty");
    }

    public final void setOptFloatProperty(String str, Float f, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, f, str2, z);
    }

    public static /* synthetic */ void setOptIntProperty$default(Model model, String str, Integer num, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptIntProperty(str, num, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptIntProperty");
    }

    public final void setOptIntProperty(String str, Integer num, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, num, str2, z);
    }

    public static /* synthetic */ void setOptBigDecimalProperty$default(Model model, String str, BigDecimal bigDecimal, String str2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptBigDecimalProperty(str, bigDecimal, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptBigDecimalProperty");
    }

    public final void setOptBigDecimalProperty(String str, BigDecimal bigDecimal, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, bigDecimal != null ? bigDecimal.toString() : null, str2, z);
    }

    public static /* synthetic */ void setOptAnyProperty$default(Model model, String str, Object obj, String str2, boolean z, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 4) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            model.setOptAnyProperty(str, obj, str2, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setOptAnyProperty");
    }

    public final void setOptAnyProperty(String str, Object obj, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Object obj2 = this.data.get(str);
        synchronized (this.data) {
            if (!Intrinsics.areEqual(obj2, obj) || z) {
                if (obj != null) {
                    this.data.put(str, obj);
                } else if (this.data.containsKey(str)) {
                    this.data.remove(str);
                }
                Unit unit = Unit.INSTANCE;
                notifyChanged(str, str, str2, obj2, obj);
            }
        }
    }

    public final boolean hasProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this.data.containsKey(str);
    }

    public static /* synthetic */ MapModel getMapModelProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getMapModelProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMapModelProperty");
    }

    /* access modifiers changed from: protected */
    public final <T> MapModel<T> getMapModelProperty(String str, Function0<? extends MapModel<T>> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        MapModel<T> optMapModelProperty = getOptMapModelProperty(str, function0);
        Intrinsics.checkNotNull(optMapModelProperty, "null cannot be cast to non-null type com.onesignal.common.modeling.MapModel<T of com.onesignal.common.modeling.Model.getMapModelProperty>");
        return optMapModelProperty;
    }

    public static /* synthetic */ List getListProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getListProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getListProperty");
    }

    /* access modifiers changed from: protected */
    public final <T> List<T> getListProperty(String str, Function0<? extends List<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        List<T> optListProperty = getOptListProperty(str, function0);
        Intrinsics.checkNotNull(optListProperty, "null cannot be cast to non-null type kotlin.collections.List<T of com.onesignal.common.modeling.Model.getListProperty>");
        return optListProperty;
    }

    public static /* synthetic */ String getStringProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getStringProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getStringProperty");
    }

    /* access modifiers changed from: protected */
    public final String getStringProperty(String str, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        String optStringProperty = getOptStringProperty(str, function0);
        Intrinsics.checkNotNull(optStringProperty, "null cannot be cast to non-null type kotlin.String");
        return optStringProperty;
    }

    public static /* synthetic */ boolean getBooleanProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getBooleanProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBooleanProperty");
    }

    /* access modifiers changed from: protected */
    public final boolean getBooleanProperty(String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Boolean optBooleanProperty = getOptBooleanProperty(str, function0);
        Intrinsics.checkNotNull(optBooleanProperty, "null cannot be cast to non-null type kotlin.Boolean");
        return optBooleanProperty.booleanValue();
    }

    public static /* synthetic */ long getLongProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getLongProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLongProperty");
    }

    /* access modifiers changed from: protected */
    public final long getLongProperty(String str, Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Long optLongProperty = getOptLongProperty(str, function0);
        Intrinsics.checkNotNull(optLongProperty, "null cannot be cast to non-null type kotlin.Long");
        return optLongProperty.longValue();
    }

    public static /* synthetic */ double getDoubleProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getDoubleProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDoubleProperty");
    }

    /* access modifiers changed from: protected */
    public final double getDoubleProperty(String str, Function0<Double> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Double optDoubleProperty = getOptDoubleProperty(str, function0);
        Intrinsics.checkNotNull(optDoubleProperty, "null cannot be cast to non-null type kotlin.Double");
        return optDoubleProperty.doubleValue();
    }

    public static /* synthetic */ float getFloatProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getFloatProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFloatProperty");
    }

    /* access modifiers changed from: protected */
    public final float getFloatProperty(String str, Function0<Float> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Float optFloatProperty = getOptFloatProperty(str, function0);
        Intrinsics.checkNotNull(optFloatProperty, "null cannot be cast to non-null type kotlin.Float");
        return optFloatProperty.floatValue();
    }

    public static /* synthetic */ int getIntProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getIntProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getIntProperty");
    }

    /* access modifiers changed from: protected */
    public final int getIntProperty(String str, Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Integer optIntProperty = getOptIntProperty(str, function0);
        Intrinsics.checkNotNull(optIntProperty, "null cannot be cast to non-null type kotlin.Int");
        return optIntProperty.intValue();
    }

    public static /* synthetic */ BigDecimal getBigDecimalProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getBigDecimalProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBigDecimalProperty");
    }

    /* access modifiers changed from: protected */
    public final BigDecimal getBigDecimalProperty(String str, Function0<? extends BigDecimal> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        BigDecimal optBigDecimalProperty = getOptBigDecimalProperty(str, function0);
        Intrinsics.checkNotNull(optBigDecimalProperty, "null cannot be cast to non-null type java.math.BigDecimal");
        return optBigDecimalProperty;
    }

    public static /* synthetic */ Object getAnyProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getAnyProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnyProperty");
    }

    /* access modifiers changed from: protected */
    public final Object getAnyProperty(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Object optAnyProperty = getOptAnyProperty(str, function0);
        Intrinsics.checkNotNull(optAnyProperty, "null cannot be cast to non-null type kotlin.Any");
        return optAnyProperty;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ <T extends Enum<T>> T getOptEnumProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        T optAnyProperty$default = getOptAnyProperty$default(this, str, (Function0) null, 2, (Object) null);
        if (optAnyProperty$default == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(3, "T");
        if (optAnyProperty$default instanceof Enum) {
            return (Enum) optAnyProperty$default;
        }
        if (optAnyProperty$default instanceof String) {
            Intrinsics.reifiedOperationMarker(5, "T");
            return Enum.valueOf((Class) null, (String) optAnyProperty$default);
        }
        Intrinsics.reifiedOperationMarker(1, "T");
        return (Enum) optAnyProperty$default;
    }

    public static /* synthetic */ MapModel getOptMapModelProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptMapModelProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptMapModelProperty");
    }

    /* access modifiers changed from: protected */
    public final <T> MapModel<T> getOptMapModelProperty(String str, Function0<? extends MapModel<T>> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        return (MapModel) getOptAnyProperty(str, function0);
    }

    public static /* synthetic */ List getOptListProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptListProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptListProperty");
    }

    /* access modifiers changed from: protected */
    public final <T> List<T> getOptListProperty(String str, Function0<? extends List<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        return (List) getOptAnyProperty(str, function0);
    }

    public static /* synthetic */ String getOptStringProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptStringProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptStringProperty");
    }

    /* access modifiers changed from: protected */
    public final String getOptStringProperty(String str, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        return (String) getOptAnyProperty(str, function0);
    }

    public static /* synthetic */ Boolean getOptBooleanProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptBooleanProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBooleanProperty");
    }

    /* access modifiers changed from: protected */
    public final Boolean getOptBooleanProperty(String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        return (Boolean) getOptAnyProperty(str, function0);
    }

    public static /* synthetic */ Long getOptLongProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptLongProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptLongProperty");
    }

    /* access modifiers changed from: protected */
    public final Long getOptLongProperty(String str, Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Object optAnyProperty = getOptAnyProperty(str, function0);
        if (optAnyProperty == null) {
            return null;
        }
        if (optAnyProperty instanceof Long) {
            return (Long) optAnyProperty;
        }
        if (optAnyProperty instanceof Integer) {
            return Long.valueOf((long) ((Number) optAnyProperty).intValue());
        }
        if (optAnyProperty instanceof Float) {
            return Long.valueOf((long) ((Number) optAnyProperty).floatValue());
        }
        if (optAnyProperty instanceof Double) {
            return Long.valueOf((long) ((Number) optAnyProperty).doubleValue());
        }
        return (Long) optAnyProperty;
    }

    public static /* synthetic */ Float getOptFloatProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptFloatProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptFloatProperty");
    }

    /* access modifiers changed from: protected */
    public final Float getOptFloatProperty(String str, Function0<Float> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Object optAnyProperty = getOptAnyProperty(str, function0);
        if (optAnyProperty == null) {
            return null;
        }
        if (optAnyProperty instanceof Float) {
            return (Float) optAnyProperty;
        }
        if (optAnyProperty instanceof Double) {
            return Float.valueOf((float) ((Number) optAnyProperty).doubleValue());
        }
        if (optAnyProperty instanceof Integer) {
            return Float.valueOf((float) ((Number) optAnyProperty).intValue());
        }
        if (optAnyProperty instanceof Long) {
            return Float.valueOf((float) ((Number) optAnyProperty).longValue());
        }
        return (Float) optAnyProperty;
    }

    public static /* synthetic */ Double getOptDoubleProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptDoubleProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptDoubleProperty");
    }

    /* access modifiers changed from: protected */
    public final Double getOptDoubleProperty(String str, Function0<Double> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Object optAnyProperty = getOptAnyProperty(str, function0);
        if (optAnyProperty == null) {
            return null;
        }
        if (optAnyProperty instanceof Double) {
            return (Double) optAnyProperty;
        }
        if (optAnyProperty instanceof Float) {
            return Double.valueOf((double) ((Number) optAnyProperty).floatValue());
        }
        if (optAnyProperty instanceof Integer) {
            return Double.valueOf((double) ((Number) optAnyProperty).intValue());
        }
        if (optAnyProperty instanceof Long) {
            return Double.valueOf((double) ((Number) optAnyProperty).longValue());
        }
        return (Double) optAnyProperty;
    }

    public static /* synthetic */ Integer getOptIntProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptIntProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptIntProperty");
    }

    /* access modifiers changed from: protected */
    public final Integer getOptIntProperty(String str, Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Object optAnyProperty = getOptAnyProperty(str, function0);
        if (optAnyProperty == null) {
            return null;
        }
        if (optAnyProperty instanceof Integer) {
            return (Integer) optAnyProperty;
        }
        if (optAnyProperty instanceof Long) {
            return Integer.valueOf((int) ((Number) optAnyProperty).longValue());
        }
        if (optAnyProperty instanceof Float) {
            return Integer.valueOf((int) ((Number) optAnyProperty).floatValue());
        }
        if (optAnyProperty instanceof Double) {
            return Integer.valueOf((int) ((Number) optAnyProperty).doubleValue());
        }
        return (Integer) optAnyProperty;
    }

    public static /* synthetic */ BigDecimal getOptBigDecimalProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptBigDecimalProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptBigDecimalProperty");
    }

    /* access modifiers changed from: protected */
    public final BigDecimal getOptBigDecimalProperty(String str, Function0<? extends BigDecimal> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Object optAnyProperty = getOptAnyProperty(str, function0);
        if (optAnyProperty == null) {
            return null;
        }
        if (optAnyProperty instanceof Integer) {
            return new BigDecimal(((Number) optAnyProperty).intValue());
        }
        if (optAnyProperty instanceof Long) {
            return new BigDecimal(((Number) optAnyProperty).longValue());
        }
        if (optAnyProperty instanceof Float) {
            return new BigDecimal((double) ((Number) optAnyProperty).floatValue());
        }
        if (optAnyProperty instanceof Double) {
            return new BigDecimal(((Number) optAnyProperty).doubleValue());
        }
        if (optAnyProperty instanceof String) {
            return new BigDecimal((String) optAnyProperty);
        }
        return (BigDecimal) optAnyProperty;
    }

    public static /* synthetic */ Object getOptAnyProperty$default(Model model, String str, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return model.getOptAnyProperty(str, function0);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOptAnyProperty");
    }

    /* access modifiers changed from: protected */
    public final Object getOptAnyProperty(String str, Function0<? extends Object> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "name");
        synchronized (this.data) {
            if (!this.data.containsKey(str)) {
                if (function0 != null) {
                    obj = function0.invoke();
                    this.data.put(str, obj);
                }
            }
            obj = this.data.get(str);
        }
        return obj;
    }

    private final void notifyChanged(String str, String str2, String str3, Object obj, Object obj2) {
        this.changeNotifier.fire(new Model$notifyChanged$1(new ModelChangedArgs(this, str, str2, obj, obj2), str3));
        if (this._parentModel != null) {
            Model model = this._parentModel;
            Intrinsics.checkNotNull(model);
            model.notifyChanged(this._parentProperty + '.' + str, str2, str3, obj, obj2);
        }
    }

    public final JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        synchronized (this.data) {
            for (Map.Entry next : this.data.entrySet()) {
                Object value = next.getValue();
                if (value instanceof Model) {
                    jSONObject.put((String) next.getKey(), ((Model) value).toJSON());
                } else if (value instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object next2 : (List) value) {
                        if (next2 instanceof Model) {
                            jSONArray.put(((Model) next2).toJSON());
                        } else {
                            jSONArray.put(next2);
                        }
                    }
                    jSONObject.put((String) next.getKey(), jSONArray);
                } else {
                    jSONObject.put((String) next.getKey(), value);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return jSONObject;
    }

    public void subscribe(IModelChangedHandler iModelChangedHandler) {
        Intrinsics.checkNotNullParameter(iModelChangedHandler, "handler");
        this.changeNotifier.subscribe(iModelChangedHandler);
    }

    public void unsubscribe(IModelChangedHandler iModelChangedHandler) {
        Intrinsics.checkNotNullParameter(iModelChangedHandler, "handler");
        this.changeNotifier.unsubscribe(iModelChangedHandler);
    }

    public boolean getHasSubscribers() {
        return this.changeNotifier.getHasSubscribers();
    }

    public final /* synthetic */ <T extends Enum<T>> void setEnumProperty(String str, T t, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(str2, "tag");
        setOptAnyProperty(str, t.toString(), str2, z);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ <T extends Enum<T>> T getEnumProperty(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        T t = null;
        T optAnyProperty$default = getOptAnyProperty$default(this, str, (Function0) null, 2, (Object) null);
        if (optAnyProperty$default != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (optAnyProperty$default instanceof Enum) {
                t = (Enum) optAnyProperty$default;
            } else if (optAnyProperty$default instanceof String) {
                Intrinsics.reifiedOperationMarker(5, "T");
                t = Enum.valueOf((Class) null, (String) optAnyProperty$default);
            } else {
                Intrinsics.reifiedOperationMarker(1, "T");
                t = (Enum) optAnyProperty$default;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T");
        Enum enumR = (Enum) t;
        return t;
    }
}
