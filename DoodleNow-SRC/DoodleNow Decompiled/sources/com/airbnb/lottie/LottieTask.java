package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieThreadFactory;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool(new LottieThreadFactory());
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    private volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;

    public LottieResult<T> getResult() {
        return this.result;
    }

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    public LottieTask(T t) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        setResult(new LottieResult(t));
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        if (z) {
            try {
                setResult(callable.call());
            } catch (Throwable th) {
                setResult(new LottieResult(th));
            }
        } else {
            EXECUTOR.execute(new LottieFutureTask(this, callable));
        }
    }

    /* access modifiers changed from: private */
    public void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (!(lottieResult == null || lottieResult.getValue() == null)) {
            lottieListener.onResult(lottieResult.getValue());
        }
        this.successListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        LottieResult<T> lottieResult = this.result;
        if (!(lottieResult == null || lottieResult.getException() == null)) {
            lottieListener.onResult(lottieResult.getException());
        }
        this.failureListeners.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        return this;
    }

    private void notifyListeners() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            notifyListenersInternal();
        } else {
            this.handler.post(new LottieTask$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public void notifyListenersInternal() {
        LottieResult<T> lottieResult = this.result;
        if (lottieResult != null) {
            if (lottieResult.getValue() != null) {
                notifySuccessListeners(lottieResult.getValue());
            } else {
                notifyFailureListeners(lottieResult.getException());
            }
        }
    }

    private synchronized void notifySuccessListeners(T t) {
        for (LottieListener onResult : new ArrayList(this.successListeners)) {
            onResult.onResult(t);
        }
    }

    private synchronized void notifyFailureListeners(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.failureListeners);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    private static class LottieFutureTask<T> extends FutureTask<LottieResult<T>> {
        private LottieTask<T> lottieTask;

        LottieFutureTask(LottieTask<T> lottieTask2, Callable<LottieResult<T>> callable) {
            super(callable);
            this.lottieTask = lottieTask2;
        }

        /* access modifiers changed from: protected */
        public void done() {
            try {
                if (isCancelled()) {
                    this.lottieTask = null;
                    return;
                }
                this.lottieTask.setResult((LottieResult) get());
                this.lottieTask = null;
            } catch (InterruptedException | ExecutionException e) {
                this.lottieTask.setResult(new LottieResult(e));
            } catch (Throwable th) {
                this.lottieTask = null;
                throw th;
            }
        }
    }
}
