package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.Trigger;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0016\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\u001e\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016J\"\u0010/\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u00102\u0006\u00101\u001a\u00020\u00102\u0006\u00102\u001a\u000203H\u0002J \u00104\u001a\u00020\n2\u0006\u00100\u001a\u0002052\u0006\u00101\u001a\u0002052\u0006\u00102\u001a\u000203H\u0002J \u00106\u001a\u00020\n2\u0006\u00100\u001a\u0002052\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0002J \u00107\u001a\u00020\n2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00108\u001a\u00020\u00142\u0006\u0010-\u001a\u00020.H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u00069"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/impl/TriggerController;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModel;", "triggerModelStore", "Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;", "_dynamicTriggerController", "Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;", "(Lcom/onesignal/inAppMessages/internal/triggers/TriggerModelStore;Lcom/onesignal/inAppMessages/internal/triggers/impl/DynamicTriggerController;)V", "hasSubscribers", "", "getHasSubscribers", "()Z", "triggers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getTriggers", "()Ljava/util/concurrent/ConcurrentHashMap;", "addTriggers", "", "key", "value", "evaluateAndTriggers", "andConditions", "", "Lcom/onesignal/inAppMessages/internal/Trigger;", "evaluateMessageTriggers", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "evaluateTrigger", "trigger", "isTriggerOnMessage", "triggersKeys", "", "messageHasOnlyDynamicTriggers", "onModelAdded", "model", "tag", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "removeTriggersForKeys", "subscribe", "handler", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "triggerMatchesFlex", "triggerValue", "deviceValue", "operator", "Lcom/onesignal/inAppMessages/internal/Trigger$OSTriggerOperator;", "triggerMatchesNumericValue", "", "triggerMatchesNumericValueFlex", "triggerMatchesStringValue", "unsubscribe", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TriggerController.kt */
public final class TriggerController implements ITriggerController, IModelStoreChangeHandler<TriggerModel> {
    private DynamicTriggerController _dynamicTriggerController;
    private final ConcurrentHashMap<String, Object> triggers = new ConcurrentHashMap<>();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TriggerController.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Trigger.OSTriggerOperator.values().length];
            iArr[Trigger.OSTriggerOperator.EQUAL_TO.ordinal()] = 1;
            iArr[Trigger.OSTriggerOperator.NOT_EQUAL_TO.ordinal()] = 2;
            iArr[Trigger.OSTriggerOperator.EXISTS.ordinal()] = 3;
            iArr[Trigger.OSTriggerOperator.CONTAINS.ordinal()] = 4;
            iArr[Trigger.OSTriggerOperator.NOT_EXISTS.ordinal()] = 5;
            iArr[Trigger.OSTriggerOperator.LESS_THAN.ordinal()] = 6;
            iArr[Trigger.OSTriggerOperator.GREATER_THAN.ordinal()] = 7;
            iArr[Trigger.OSTriggerOperator.LESS_THAN_OR_EQUAL_TO.ordinal()] = 8;
            iArr[Trigger.OSTriggerOperator.GREATER_THAN_OR_EQUAL_TO.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ConcurrentHashMap<String, Object> getTriggers() {
        return this.triggers;
    }

    public TriggerController(TriggerModelStore triggerModelStore, DynamicTriggerController dynamicTriggerController) {
        Intrinsics.checkNotNullParameter(triggerModelStore, "triggerModelStore");
        Intrinsics.checkNotNullParameter(dynamicTriggerController, "_dynamicTriggerController");
        this._dynamicTriggerController = dynamicTriggerController;
        triggerModelStore.subscribe(this);
    }

    public boolean evaluateMessageTriggers(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (inAppMessage.getTriggers().isEmpty()) {
            return true;
        }
        for (List<Trigger> evaluateAndTriggers : inAppMessage.getTriggers()) {
            if (evaluateAndTriggers(evaluateAndTriggers)) {
                return true;
            }
        }
        return false;
    }

    private final boolean evaluateAndTriggers(List<Trigger> list) {
        for (Trigger evaluateTrigger : list) {
            if (!evaluateTrigger(evaluateTrigger)) {
                return false;
            }
        }
        return true;
    }

    private final boolean evaluateTrigger(Trigger trigger) {
        if (trigger.getKind() == Trigger.OSTriggerKind.UNKNOWN) {
            return false;
        }
        if (trigger.getKind() != Trigger.OSTriggerKind.CUSTOM) {
            return this._dynamicTriggerController.dynamicTriggerShouldFire(trigger);
        }
        Trigger.OSTriggerOperator operatorType = trigger.getOperatorType();
        Object obj = this.triggers.get(trigger.getProperty());
        if (obj == null) {
            if (operatorType != Trigger.OSTriggerOperator.NOT_EXISTS && (operatorType != Trigger.OSTriggerOperator.NOT_EQUAL_TO || trigger.getValue() == null)) {
                return false;
            }
            return true;
        } else if (operatorType == Trigger.OSTriggerOperator.EXISTS) {
            return true;
        } else {
            if (operatorType == Trigger.OSTriggerOperator.NOT_EXISTS) {
                return false;
            }
            if (operatorType != Trigger.OSTriggerOperator.CONTAINS) {
                if ((obj instanceof String) && (trigger.getValue() instanceof String)) {
                    String str = (String) trigger.getValue();
                    Intrinsics.checkNotNull(str);
                    if (triggerMatchesStringValue(str, (String) obj, operatorType)) {
                        return true;
                    }
                }
                if ((trigger.getValue() instanceof Number) && (obj instanceof Number)) {
                    Number number = (Number) trigger.getValue();
                    Intrinsics.checkNotNull(number);
                    if (triggerMatchesNumericValue(number, (Number) obj, operatorType)) {
                        return true;
                    }
                }
                return triggerMatchesFlex(trigger.getValue(), obj, operatorType);
            } else if (!(obj instanceof Collection) || !((Collection) obj).contains(trigger.getValue())) {
                return false;
            } else {
                return true;
            }
        }
    }

    private final boolean triggerMatchesStringValue(String str, String str2, Trigger.OSTriggerOperator oSTriggerOperator) {
        int i = WhenMappings.$EnumSwitchMapping$0[oSTriggerOperator.ordinal()];
        if (i == 1) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }
        if (i != 2) {
            Logging.error$default("Attempted to use an invalid operator for a string trigger comparison: " + oSTriggerOperator, (Throwable) null, 2, (Object) null);
        } else if (!Intrinsics.areEqual((Object) str, (Object) str2)) {
            return true;
        }
        return false;
    }

    private final boolean triggerMatchesFlex(Object obj, Object obj2, Trigger.OSTriggerOperator oSTriggerOperator) {
        if (obj == null) {
            return false;
        }
        if (oSTriggerOperator.checksEquality()) {
            String obj3 = obj.toString();
            String obj4 = obj2.toString();
            if (obj2 instanceof Number) {
                obj4 = new DecimalFormat("0.#").format(obj2);
                Intrinsics.checkNotNullExpressionValue(obj4, "format.format(deviceValue)");
            }
            return triggerMatchesStringValue(obj3, obj4, oSTriggerOperator);
        } else if (!(obj2 instanceof String) || !(obj instanceof Number)) {
            return false;
        } else {
            return triggerMatchesNumericValueFlex((Number) obj, (String) obj2, oSTriggerOperator);
        }
    }

    private final boolean triggerMatchesNumericValueFlex(Number number, String str, Trigger.OSTriggerOperator oSTriggerOperator) {
        try {
            return triggerMatchesNumericValue(Double.valueOf(number.doubleValue()), Double.valueOf(Double.parseDouble(str)), oSTriggerOperator);
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private final boolean triggerMatchesNumericValue(Number number, Number number2, Trigger.OSTriggerOperator oSTriggerOperator) {
        double doubleValue = number.doubleValue();
        double doubleValue2 = number2.doubleValue();
        switch (WhenMappings.$EnumSwitchMapping$0[oSTriggerOperator.ordinal()]) {
            case 1:
                if (doubleValue2 == doubleValue) {
                    return true;
                }
                break;
            case 2:
                if (doubleValue2 != doubleValue) {
                    return true;
                }
                break;
            case 3:
            case 4:
            case 5:
                Logging.error$default("Attempted to use an invalid operator with a numeric value: " + oSTriggerOperator, (Throwable) null, 2, (Object) null);
                break;
            case 6:
                if (doubleValue2 < doubleValue) {
                    return true;
                }
                break;
            case 7:
                if (doubleValue2 > doubleValue) {
                    return true;
                }
                break;
            case 8:
                int i = (doubleValue2 > doubleValue ? 1 : (doubleValue2 == doubleValue ? 0 : -1));
                if (i < 0 || i == 0) {
                    return true;
                }
            case 9:
                if (doubleValue2 > doubleValue || doubleValue2 == doubleValue) {
                    return true;
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002a A[LOOP:1: B:7:0x002a->B:21:0x002a, LOOP_END, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isTriggerOnMessage(com.onesignal.inAppMessages.internal.InAppMessage r7, java.util.Collection<java.lang.String> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "triggersKeys"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.List r0 = r7.getTriggers()
            r1 = 0
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.util.Iterator r8 = r8.iterator()
        L_0x0016:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r2 = r7.getTriggers()
            java.util.Iterator r2 = r2.iterator()
        L_0x002a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0016
            java.lang.Object r3 = r2.next()
            java.util.List r3 = (java.util.List) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x003a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002a
            java.lang.Object r4 = r3.next()
            com.onesignal.inAppMessages.internal.Trigger r4 = (com.onesignal.inAppMessages.internal.Trigger) r4
            java.lang.String r5 = r4.getProperty()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x005a
            java.lang.String r4 = r4.getTriggerId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x003a
        L_0x005a:
            r7 = 1
            return r7
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.triggers.impl.TriggerController.isTriggerOnMessage(com.onesignal.inAppMessages.internal.InAppMessage, java.util.Collection):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x001f A[LOOP:0: B:5:0x001f->B:20:0x001f, LOOP_END, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean messageHasOnlyDynamicTriggers(com.onesignal.inAppMessages.internal.InAppMessage r6) {
        /*
            r5 = this;
            java.lang.String r0 = "message"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.List r0 = r6.getTriggers()
            r1 = 0
            if (r0 == 0) goto L_0x004e
            java.util.List r0 = r6.getTriggers()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0017
            goto L_0x004e
        L_0x0017:
            java.util.List r6 = r6.getTriggers()
            java.util.Iterator r6 = r6.iterator()
        L_0x001f:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x004c
            java.lang.Object r0 = r6.next()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001f
            java.lang.Object r2 = r0.next()
            com.onesignal.inAppMessages.internal.Trigger r2 = (com.onesignal.inAppMessages.internal.Trigger) r2
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r3 = r2.getKind()
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r4 = com.onesignal.inAppMessages.internal.Trigger.OSTriggerKind.CUSTOM
            if (r3 == r4) goto L_0x004b
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r2 = r2.getKind()
            com.onesignal.inAppMessages.internal.Trigger$OSTriggerKind r3 = com.onesignal.inAppMessages.internal.Trigger.OSTriggerKind.UNKNOWN
            if (r2 != r3) goto L_0x002f
        L_0x004b:
            return r1
        L_0x004c:
            r6 = 1
            return r6
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.triggers.impl.TriggerController.messageHasOnlyDynamicTriggers(com.onesignal.inAppMessages.internal.InAppMessage):boolean");
    }

    public void onModelAdded(TriggerModel triggerModel, String str) {
        Intrinsics.checkNotNullParameter(triggerModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        addTriggers(triggerModel.getKey(), triggerModel.getValue());
        this._dynamicTriggerController.getEvents().fire(new TriggerController$onModelAdded$1(triggerModel));
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        Model model = modelChangedArgs.getModel();
        Intrinsics.checkNotNull(model, "null cannot be cast to non-null type com.onesignal.inAppMessages.internal.triggers.TriggerModel");
        TriggerModel triggerModel = (TriggerModel) model;
        addTriggers(triggerModel.getKey(), triggerModel.getValue());
        this._dynamicTriggerController.getEvents().fire(new TriggerController$onModelUpdated$1(triggerModel));
    }

    public void onModelRemoved(TriggerModel triggerModel, String str) {
        Intrinsics.checkNotNullParameter(triggerModel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        removeTriggersForKeys(triggerModel.getKey());
    }

    private final void addTriggers(String str, Object obj) {
        synchronized (this.triggers) {
            this.triggers.put(str, obj);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeTriggersForKeys(String str) {
        synchronized (this.triggers) {
            this.triggers.remove(str);
        }
    }

    public void subscribe(ITriggerHandler iTriggerHandler) {
        Intrinsics.checkNotNullParameter(iTriggerHandler, "handler");
        this._dynamicTriggerController.subscribe(iTriggerHandler);
    }

    public void unsubscribe(ITriggerHandler iTriggerHandler) {
        Intrinsics.checkNotNullParameter(iTriggerHandler, "handler");
        this._dynamicTriggerController.unsubscribe(iTriggerHandler);
    }

    public boolean getHasSubscribers() {
        return this._dynamicTriggerController.getHasSubscribers();
    }
}
