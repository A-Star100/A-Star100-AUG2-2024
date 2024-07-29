package expo.modules.location.taskConsumers;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationTaskConsumer$$ExternalSyntheticLambda2 implements OnCompleteListener {
    public final /* synthetic */ LocationTaskConsumer f$0;

    public /* synthetic */ LocationTaskConsumer$$ExternalSyntheticLambda2(LocationTaskConsumer locationTaskConsumer) {
        this.f$0 = locationTaskConsumer;
    }

    public final void onComplete(Task task) {
        LocationTaskConsumer.didReceiveBroadcast$lambda$1(this.f$0, task);
    }
}
