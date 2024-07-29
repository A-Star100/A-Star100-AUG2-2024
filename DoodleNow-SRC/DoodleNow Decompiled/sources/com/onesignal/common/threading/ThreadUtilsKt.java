package com.onesignal.common.threading;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a,\u0010\u0007\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a6\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a>\u0010\b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"suspendifyBlocking", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "suspendifyOnMain", "suspendifyOnThread", "priority", "", "(ILkotlin/jvm/functions/Function1;)V", "name", "", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "com.onesignal.core"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThreadUtils.kt */
public final class ThreadUtilsKt {
    public static final void suspendifyBlocking(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ThreadUtilsKt$suspendifyBlocking$1(function1, (Continuation<? super ThreadUtilsKt$suspendifyBlocking$1>) null), 1, (Object) null);
    }

    public static final void suspendifyOnMain(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new ThreadUtilsKt$suspendifyOnMain$1(function1), 31, (Object) null);
    }

    public static /* synthetic */ void suspendifyOnThread$default(int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        suspendifyOnThread(i, function1);
    }

    public static final void suspendifyOnThread(int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, i, new ThreadUtilsKt$suspendifyOnThread$1(function1), 15, (Object) null);
    }

    public static /* synthetic */ void suspendifyOnThread$default(String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        suspendifyOnThread(str, i, function1);
    }

    public static final void suspendifyOnThread(String str, int i, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        ThreadsKt.thread$default(false, false, (ClassLoader) null, str, i, new ThreadUtilsKt$suspendifyOnThread$2(str, function1), 7, (Object) null);
    }
}
