package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.NxtSensorMode;
import com.google.appinventor.components.common.NxtSensorType;
import com.google.appinventor.components.runtime.LegoMindstormsNxtSensor;
import com.google.appinventor.components.runtime.util.Ev3Constants;

@SimpleObject
@DesignerComponent(category = ComponentCategory.LEGOMINDSTORMS, description = "A component that provides a high-level interface to an ultrasonic sensor on a LEGO MINDSTORMS NXT robot.", iconName = "images/legoMindstormsNxt.png", nonVisible = true, version = 1)
public class NxtUltrasonicSensor extends LegoMindstormsNxtSensor implements Deleteable {
    private static final int DEFAULT_BOTTOM_OF_RANGE = 30;
    private static final String DEFAULT_SENSOR_PORT = "4";
    private static final int DEFAULT_TOP_OF_RANGE = 90;
    /* access modifiers changed from: private */
    public boolean aboveRangeEventEnabled;
    /* access modifiers changed from: private */
    public boolean belowRangeEventEnabled;
    /* access modifiers changed from: private */
    public int bottomOfRange;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public State previousState = State.UNKNOWN;
    /* access modifiers changed from: private */
    public final Runnable sensorReader = new Runnable() {
        public void run() {
            State currentState;
            if (NxtUltrasonicSensor.this.bluetooth != null && NxtUltrasonicSensor.this.bluetooth.IsConnected()) {
                LegoMindstormsNxtSensor.SensorValue<Integer> sensorValue = NxtUltrasonicSensor.this.getDistanceValue("");
                if (sensorValue.valid) {
                    if (((Integer) sensorValue.value).intValue() < NxtUltrasonicSensor.this.bottomOfRange) {
                        currentState = State.BELOW_RANGE;
                    } else if (((Integer) sensorValue.value).intValue() > NxtUltrasonicSensor.this.topOfRange) {
                        currentState = State.ABOVE_RANGE;
                    } else {
                        currentState = State.WITHIN_RANGE;
                    }
                    if (currentState != NxtUltrasonicSensor.this.previousState) {
                        if (currentState == State.BELOW_RANGE && NxtUltrasonicSensor.this.belowRangeEventEnabled) {
                            NxtUltrasonicSensor.this.BelowRange();
                        }
                        if (currentState == State.WITHIN_RANGE && NxtUltrasonicSensor.this.withinRangeEventEnabled) {
                            NxtUltrasonicSensor.this.WithinRange();
                        }
                        if (currentState == State.ABOVE_RANGE && NxtUltrasonicSensor.this.aboveRangeEventEnabled) {
                            NxtUltrasonicSensor.this.AboveRange();
                        }
                    }
                    NxtUltrasonicSensor.this.previousState = currentState;
                }
            }
            if (NxtUltrasonicSensor.this.isHandlerNeeded()) {
                NxtUltrasonicSensor.this.handler.post(NxtUltrasonicSensor.this.sensorReader);
            }
        }
    };
    /* access modifiers changed from: private */
    public int topOfRange;
    /* access modifiers changed from: private */
    public boolean withinRangeEventEnabled;

    private enum State {
        UNKNOWN,
        BELOW_RANGE,
        WITHIN_RANGE,
        ABOVE_RANGE
    }

    public NxtUltrasonicSensor(ComponentContainer container) {
        super(container, "NxtUltrasonicSensor");
        SensorPort(DEFAULT_SENSOR_PORT);
        BottomOfRange(30);
        TopOfRange(90);
        BelowRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void initializeSensor(String functionName) {
        setInputMode(functionName, this.port, NxtSensorType.Digital12C9V, NxtSensorMode.Raw);
        configureUltrasonicSensor(functionName);
    }

    private void configureUltrasonicSensor(String functionName) {
        lsWrite(functionName, this.port, new byte[]{2, Ev3Constants.Opcode.JR_FALSE, 2}, 0);
    }

    @DesignerProperty(defaultValue = "4", editorType = "lego_nxt_sensor_port")
    @SimpleProperty(userVisible = false)
    public void SensorPort(String sensorPortLetter) {
        setSensorPort(sensorPortLetter);
    }

    @SimpleFunction(description = "Returns the current distance in centimeters as a value between 0 and 254, or -1 if the distance can not be read.")
    public int GetDistance() {
        if (!checkBluetooth("GetDistance")) {
            return -1;
        }
        LegoMindstormsNxtSensor.SensorValue<Integer> sensorValue = getDistanceValue("GetDistance");
        if (sensorValue.valid) {
            return ((Integer) sensorValue.value).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public LegoMindstormsNxtSensor.SensorValue<Integer> getDistanceValue(String functionName) {
        int value;
        lsWrite(functionName, this.port, new byte[]{2, Ev3Constants.Opcode.JR_TRUE}, 1);
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            } else if (lsGetStatus(functionName, this.port) > 0) {
                byte[] returnPackage = lsRead(functionName, this.port);
                if (returnPackage != null && (value = getUBYTEValueFromBytes(returnPackage, 4)) >= 0 && value <= 254) {
                    return new LegoMindstormsNxtSensor.SensorValue<>(true, Integer.valueOf(value));
                }
            } else {
                i++;
            }
        }
        return new LegoMindstormsNxtSensor.SensorValue<>(false, null);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The bottom of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int BottomOfRange() {
        return this.bottomOfRange;
    }

    @DesignerProperty(defaultValue = "30", editorType = "non_negative_integer")
    @SimpleProperty
    public void BottomOfRange(int bottomOfRange2) {
        this.bottomOfRange = bottomOfRange2;
        this.previousState = State.UNKNOWN;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "The top of the range used for the BelowRange, WithinRange, and AboveRange events.")
    public int TopOfRange() {
        return this.topOfRange;
    }

    @DesignerProperty(defaultValue = "90", editorType = "non_negative_integer")
    @SimpleProperty
    public void TopOfRange(int topOfRange2) {
        this.topOfRange = topOfRange2;
        this.previousState = State.UNKNOWN;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the BelowRange event should fire when the distance goes below the BottomOfRange.")
    public boolean BelowRangeEventEnabled() {
        return this.belowRangeEventEnabled;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void BelowRangeEventEnabled(boolean enabled) {
        boolean handlerWasNeeded = isHandlerNeeded();
        this.belowRangeEventEnabled = enabled;
        boolean handlerIsNeeded = isHandlerNeeded();
        if (handlerWasNeeded && !handlerIsNeeded) {
            this.handler.removeCallbacks(this.sensorReader);
        }
        if (!handlerWasNeeded && handlerIsNeeded) {
            this.previousState = State.UNKNOWN;
            this.handler.post(this.sensorReader);
        }
    }

    @SimpleEvent(description = "Distance has gone below the range.")
    public void BelowRange() {
        EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the WithinRange event should fire when the distance goes between the BottomOfRange and the TopOfRange.")
    public boolean WithinRangeEventEnabled() {
        return this.withinRangeEventEnabled;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void WithinRangeEventEnabled(boolean enabled) {
        boolean handlerWasNeeded = isHandlerNeeded();
        this.withinRangeEventEnabled = enabled;
        boolean handlerIsNeeded = isHandlerNeeded();
        if (handlerWasNeeded && !handlerIsNeeded) {
            this.handler.removeCallbacks(this.sensorReader);
        }
        if (!handlerWasNeeded && handlerIsNeeded) {
            this.previousState = State.UNKNOWN;
            this.handler.post(this.sensorReader);
        }
    }

    @SimpleEvent(description = "Distance has gone within the range.")
    public void WithinRange() {
        EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether the AboveRange event should fire when the distance goes above the TopOfRange.")
    public boolean AboveRangeEventEnabled() {
        return this.aboveRangeEventEnabled;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty
    public void AboveRangeEventEnabled(boolean enabled) {
        boolean handlerWasNeeded = isHandlerNeeded();
        this.aboveRangeEventEnabled = enabled;
        boolean handlerIsNeeded = isHandlerNeeded();
        if (handlerWasNeeded && !handlerIsNeeded) {
            this.handler.removeCallbacks(this.sensorReader);
        }
        if (!handlerWasNeeded && handlerIsNeeded) {
            this.previousState = State.UNKNOWN;
            this.handler.post(this.sensorReader);
        }
    }

    @SimpleEvent(description = "Distance has gone above the range.")
    public void AboveRange() {
        EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
    }

    /* access modifiers changed from: private */
    public boolean isHandlerNeeded() {
        return this.belowRangeEventEnabled || this.withinRangeEventEnabled || this.aboveRangeEventEnabled;
    }

    public void onDelete() {
        this.handler.removeCallbacks(this.sensorReader);
        super.onDelete();
    }
}
