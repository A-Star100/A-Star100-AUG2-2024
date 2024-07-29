package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    public Operation getOperation() {
        return this.mOperation;
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = operationImpl;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.markState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
        } catch (Throwable th) {
            this.mOperation.markState(new Operation.State.FAILURE(th));
        }
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z |= processContinuation(next);
                } else {
                    Logger logger = Logger.get();
                    String str = TAG;
                    logger.warning(str, "Already enqueued work ids (" + TextUtils.join(", ", next.getIds()) + ")");
                }
            }
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r16, java.util.List<? extends androidx.work.WorkRequest> r17, java.lang.String[] r18, java.lang.String r19, androidx.work.ExistingWorkPolicy r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            long r3 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r16.getWorkDatabase()
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0017
            int r8 = r0.length
            if (r8 <= 0) goto L_0x0017
            r8 = r6
            goto L_0x0018
        L_0x0017:
            r8 = r7
        L_0x0018:
            if (r8 == 0) goto L_0x0062
            int r9 = r0.length
            r11 = r6
            r10 = r7
            r12 = r10
            r13 = r12
        L_0x001f:
            if (r10 >= r9) goto L_0x0065
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.workSpecDao()
            androidx.work.impl.model.WorkSpec r15 = r15.getWorkSpec(r14)
            if (r15 != 0) goto L_0x004a
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Prerequisite "
            r2.<init>(r3)
            r2.append(r14)
            java.lang.String r3 = " doesn't exist; not enqueuing"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.error(r1, r2)
            return r7
        L_0x004a:
            androidx.work.WorkInfo$State r14 = r15.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x0052
            r15 = r6
            goto L_0x0053
        L_0x0052:
            r15 = r7
        L_0x0053:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x005a
            r13 = r6
            goto L_0x005f
        L_0x005a:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x005f
            r12 = r6
        L_0x005f:
            int r10 = r10 + 1
            goto L_0x001f
        L_0x0062:
            r11 = r6
            r12 = r7
            r13 = r12
        L_0x0065:
            boolean r9 = android.text.TextUtils.isEmpty(r19)
            r9 = r9 ^ r6
            if (r9 == 0) goto L_0x014d
            if (r8 != 0) goto L_0x014d
            androidx.work.impl.model.WorkSpecDao r10 = r5.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x014d
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x00cf
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x0085
            goto L_0x00cf
        L_0x0085:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x00a9
            java.util.Iterator r2 = r10.iterator()
        L_0x008d:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00a9
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r15 = r14.state
            androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 == r6) goto L_0x00a8
            androidx.work.WorkInfo$State r6 = r14.state
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.RUNNING
            if (r6 != r14) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r6 = 1
            goto L_0x008d
        L_0x00a8:
            return r7
        L_0x00a9:
            r6 = r16
            androidx.work.impl.utils.CancelWorkRunnable r2 = androidx.work.impl.utils.CancelWorkRunnable.forName(r1, r6, r7)
            r2.run()
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00ba:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x00cc
            java.lang.Object r14 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            java.lang.String r14 = r14.id
            r2.delete(r14)
            goto L_0x00ba
        L_0x00cc:
            r2 = 1
            goto L_0x014e
        L_0x00cf:
            r6 = r16
            androidx.work.impl.model.DependencyDao r8 = r5.dependencyDao()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00de:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0115
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r7 = r15.id
            boolean r7 = r8.hasDependents(r7)
            if (r7 != 0) goto L_0x0111
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r6) goto L_0x00fa
            r6 = 1
            goto L_0x00fb
        L_0x00fa:
            r6 = 0
        L_0x00fb:
            r6 = r6 & r11
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x0104
            r13 = 1
            goto L_0x010b
        L_0x0104:
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x010b
            r12 = 1
        L_0x010b:
            java.lang.String r7 = r15.id
            r14.add(r7)
            r11 = r6
        L_0x0111:
            r6 = r16
            r7 = 0
            goto L_0x00de
        L_0x0115:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x0141
            if (r12 != 0) goto L_0x011d
            if (r13 == 0) goto L_0x0141
        L_0x011d:
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.List r6 = r2.getWorkSpecIdAndStatesForName(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0129:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x013b
            java.lang.Object r7 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r7 = r7.id
            r2.delete(r7)
            goto L_0x0129
        L_0x013b:
            java.util.List r14 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x0141:
            java.lang.Object[] r0 = r14.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x014c
            r8 = 1
            goto L_0x014d
        L_0x014c:
            r8 = 0
        L_0x014d:
            r2 = 0
        L_0x014e:
            java.util.Iterator r6 = r17.iterator()
        L_0x0152:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01df
            java.lang.Object r7 = r6.next()
            androidx.work.WorkRequest r7 = (androidx.work.WorkRequest) r7
            androidx.work.impl.model.WorkSpec r10 = r7.getWorkSpec()
            if (r8 == 0) goto L_0x0179
            if (r11 != 0) goto L_0x0179
            if (r13 == 0) goto L_0x016d
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.FAILED
            r10.state = r14
            goto L_0x017b
        L_0x016d:
            if (r12 == 0) goto L_0x0174
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.CANCELLED
            r10.state = r14
            goto L_0x017b
        L_0x0174:
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.BLOCKED
            r10.state = r14
            goto L_0x017b
        L_0x0179:
            r10.lastEnqueueTime = r3
        L_0x017b:
            androidx.work.WorkInfo$State r14 = r10.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 != r15) goto L_0x0182
            r2 = 1
        L_0x0182:
            androidx.work.impl.model.WorkSpecDao r14 = r5.workSpecDao()
            java.util.List r15 = r16.getSchedulers()
            androidx.work.impl.model.WorkSpec r10 = androidx.work.impl.utils.EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(r15, r10)
            r14.insertWorkSpec(r10)
            if (r8 == 0) goto L_0x01b4
            int r10 = r0.length
            r14 = 0
        L_0x0195:
            if (r14 >= r10) goto L_0x01b4
            r15 = r0[r14]
            r18 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r17 = r2
            java.lang.String r2 = r7.getStringId()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r5.dependencyDao()
            r2.insertDependency(r0)
            int r14 = r14 + 1
            r2 = r17
            r0 = r18
            goto L_0x0195
        L_0x01b4:
            r18 = r0
            r17 = r2
            androidx.work.impl.model.WorkTagDao r0 = r5.workTagDao()
            java.lang.String r2 = r7.getStringId()
            java.util.Set r10 = r7.getTags()
            r0.insertTags(r2, r10)
            if (r9 == 0) goto L_0x01d9
            androidx.work.impl.model.WorkNameDao r0 = r5.workNameDao()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r7 = r7.getStringId()
            r2.<init>(r1, r7)
            r0.insert(r2)
        L_0x01d9:
            r2 = r17
            r0 = r18
            goto L_0x0152
        L_0x01df:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }
}
