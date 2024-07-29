package expo.modules.sensors.modules;

import expo.modules.sensors.modules.DeviceMotionModule;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceMotionModule$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DeviceMotionModule.ScheduleDispatchFrameCallback f$0;

    public /* synthetic */ DeviceMotionModule$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0(DeviceMotionModule.ScheduleDispatchFrameCallback scheduleDispatchFrameCallback) {
        this.f$0 = scheduleDispatchFrameCallback;
    }

    public final void run() {
        DeviceMotionModule.ScheduleDispatchFrameCallback.maybePostFromNonUI$lambda$0(this.f$0);
    }
}
