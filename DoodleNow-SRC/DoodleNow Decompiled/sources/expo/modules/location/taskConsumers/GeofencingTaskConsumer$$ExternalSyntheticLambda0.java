package expo.modules.location.taskConsumers;

import android.app.job.JobParameters;
import android.app.job.JobService;
import expo.modules.interfaces.taskManager.TaskExecutionCallback;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GeofencingTaskConsumer$$ExternalSyntheticLambda0 implements TaskExecutionCallback {
    public final /* synthetic */ JobService f$0;
    public final /* synthetic */ JobParameters f$1;

    public /* synthetic */ GeofencingTaskConsumer$$ExternalSyntheticLambda0(JobService jobService, JobParameters jobParameters) {
        this.f$0 = jobService;
        this.f$1 = jobParameters;
    }

    public final void onFinished(Map map) {
        GeofencingTaskConsumer.didExecuteJob$lambda$2(this.f$0, this.f$1, map);
    }
}
