package expo.modules.av;

import expo.modules.core.Promise;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AVManager$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ AVManager f$0;
    public final /* synthetic */ Integer f$1;
    public final /* synthetic */ Promise f$2;

    public /* synthetic */ AVManager$$ExternalSyntheticLambda7(AVManager aVManager, Integer num, Promise promise) {
        this.f$0 = aVManager;
        this.f$1 = num;
        this.f$2 = promise;
    }

    public final void run() {
        this.f$0.lambda$unloadForSound$2(this.f$1, this.f$2);
    }
}
