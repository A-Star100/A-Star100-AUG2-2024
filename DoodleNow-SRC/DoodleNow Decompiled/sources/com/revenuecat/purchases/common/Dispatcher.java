package com.revenuecat.purchases.common;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.json.JSONException;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher;", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "mainHandler", "Landroid/os/Handler;", "runningIntegrationTests", "", "(Ljava/util/concurrent/ExecutorService;Landroid/os/Handler;Z)V", "close", "", "enqueue", "command", "Ljava/lang/Runnable;", "delay", "Lcom/revenuecat/purchases/common/Delay;", "isClosed", "AsyncCall", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Dispatcher.kt */
public class Dispatcher {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final double INTEGRATION_TEST_DELAY_PERCENTAGE = 0.01d;
    private final ExecutorService executorService;
    private final Handler mainHandler;
    private final boolean runningIntegrationTests;

    public Dispatcher(ExecutorService executorService2, Handler handler, boolean z) {
        Intrinsics.checkNotNullParameter(executorService2, "executorService");
        this.executorService = executorService2;
        this.mainHandler = handler;
        this.runningIntegrationTests = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Dispatcher(ExecutorService executorService2, Handler handler, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(executorService2, (i & 2) != 0 ? new Handler(Looper.getMainLooper()) : handler, (i & 4) != 0 ? false : z);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$Companion;", "", "()V", "INTEGRATION_TEST_DELAY_PERCENTAGE", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Dispatcher.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "Ljava/lang/Runnable;", "()V", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "run", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Dispatcher.kt */
    public static abstract class AsyncCall implements Runnable {
        public abstract HTTPResult call() throws JSONException, IOException;

        public void onCompletion(HTTPResult hTTPResult) {
            Intrinsics.checkNotNullParameter(hTTPResult, "result");
        }

        public void onError(PurchasesError purchasesError) {
            Intrinsics.checkNotNullParameter(purchasesError, "error");
        }

        public void run() {
            try {
                onCompletion(call());
            } catch (JSONException e) {
                PurchasesError purchasesError = ErrorsKt.toPurchasesError((Exception) e);
                LogUtilsKt.errorLog(purchasesError);
                onError(purchasesError);
            } catch (IOException e2) {
                PurchasesError purchasesError2 = ErrorsKt.toPurchasesError((Exception) e2);
                LogUtilsKt.errorLog(purchasesError2);
                onError(purchasesError2);
            } catch (SecurityException e3) {
                PurchasesError purchasesError3 = ErrorsKt.toPurchasesError((Exception) e3);
                LogUtilsKt.errorLog(purchasesError3);
                onError(purchasesError3);
            } catch (SignatureVerificationException e4) {
                PurchasesError purchasesError4 = ErrorsKt.toPurchasesError((Exception) e4);
                LogUtilsKt.errorLog(purchasesError4);
                onError(purchasesError4);
            }
        }
    }

    public static /* synthetic */ void enqueue$default(Dispatcher dispatcher, Runnable runnable, Delay delay, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                delay = Delay.NONE;
            }
            dispatcher.enqueue(runnable, delay);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enqueue");
    }

    public void enqueue(Runnable runnable, Delay delay) {
        Intrinsics.checkNotNullParameter(runnable, "command");
        Intrinsics.checkNotNullParameter(delay, "delay");
        synchronized (this.executorService) {
            if (!this.executorService.isShutdown()) {
                Dispatcher$$ExternalSyntheticLambda0 dispatcher$$ExternalSyntheticLambda0 = new Dispatcher$$ExternalSyntheticLambda0(runnable, this);
                if (delay == Delay.NONE || !(this.executorService instanceof ScheduledExecutorService)) {
                    this.executorService.submit(dispatcher$$ExternalSyntheticLambda0);
                } else {
                    long random = RangesKt.random(new LongRange(Duration.m2581getInWholeMillisecondsimpl(delay.m1092getMinDelayUwyO8pc()), Duration.m2581getInWholeMillisecondsimpl(delay.m1091getMaxDelayUwyO8pc())), (Random) Random.Default);
                    if (this.runningIntegrationTests) {
                        random = (long) (((double) random) * 0.01d);
                    }
                    ((ScheduledExecutorService) this.executorService).schedule(dispatcher$$ExternalSyntheticLambda0, random, TimeUnit.MILLISECONDS);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public static final void enqueue$lambda$2$lambda$1(Runnable runnable, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(runnable, "$command");
        Intrinsics.checkNotNullParameter(dispatcher, "this$0");
        try {
            runnable.run();
        } catch (Exception e) {
            LogUtilsKt.errorLog$default("Exception running command: " + e, (Throwable) null, 2, (Object) null);
            Handler handler = dispatcher.mainHandler;
            if (handler != null) {
                handler.post(new Dispatcher$$ExternalSyntheticLambda1(e));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void enqueue$lambda$2$lambda$1$lambda$0(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "$e");
        throw exc;
    }

    public void close() {
        synchronized (this.executorService) {
            this.executorService.shutdownNow();
        }
    }

    public boolean isClosed() {
        boolean isShutdown;
        synchronized (this.executorService) {
            isShutdown = this.executorService.isShutdown();
        }
        return isShutdown;
    }
}
