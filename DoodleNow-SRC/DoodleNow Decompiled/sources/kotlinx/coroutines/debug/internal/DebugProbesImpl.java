package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001}B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u00101\u001a\b\u0012\u0004\u0012\u0002H302\"\u0004\b\u0000\u001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H3022\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0001J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J\u0011\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\u0010?J9\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0;\"\b\b\u0000\u0010A*\u00020\u00012\u001e\b\u0004\u0010B\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u0002HA0CH\bJ\u0010\u0010E\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0002J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0;J\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010I\u001a\u00020<2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;J\u000e\u0010K\u001a\u00020)2\u0006\u0010I\u001a\u00020<J.\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010M\u001a\u00020)2\b\u0010N\u001a\u0004\u0018\u00010'2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J=\u0010O\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020Q0P2\u0006\u0010R\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010TJ1\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0015\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020*H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020\u0014H\u0000¢\u0006\u0002\b]J\u001e\u0010^\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J\u0014\u0010`\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J'\u0010b\u001a\b\u0012\u0004\u0012\u0002H302\"\u0004\b\u0000\u001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H302H\u0000¢\u0006\u0002\bcJ\u0019\u0010d\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0002\beJ\u0019\u0010f\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0002\bgJ%\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040;\"\b\b\u0000\u00103*\u00020i2\u0006\u0010j\u001a\u0002H3H\u0002¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020\u0014H\u0002J\b\u0010m\u001a\u00020\u0014H\u0002J\r\u0010n\u001a\u00020\u0014H\u0000¢\u0006\u0002\boJ\u0018\u0010p\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00072\u0006\u0010M\u001a\u00020)H\u0002J\u001c\u0010q\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010M\u001a\u00020)H\u0002J(\u0010q\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u00105\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010M\u001a\u00020)H\u0002J4\u0010r\u001a\u00020\u0014*\u00020*2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0t2\n\u0010u\u001a\u00060vj\u0002`w2\u0006\u0010x\u001a\u00020)H\u0002J\u0010\u0010y\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u0016\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u0006\u0012\u0002\b\u000302H\u0002J\u0013\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u00020\u0007H\u0010J\u000f\u0010z\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0010J\u0012\u0010{\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00040;H\u0002J\f\u0010|\u001a\u00020)*\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\t\u0010\u001d\u001a\u00020\u001eX\u0004R\u0011\u0010\u001f\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\t\u0010$\u001a\u00020%X\u0004R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)*\u00020*8BX\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00020\u000f*\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006~"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "capturedCoroutines", "", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutinesMap", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/Function1;", "", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "()Z", "setEnableCreationStackTraces$kotlinx_coroutines_core", "(Z)V", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "weakRefCleanerThread", "Ljava/lang/Thread;", "debugString", "", "Lkotlinx/coroutines/Job;", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "createOwner", "Lkotlin/coroutines/Continuation;", "T", "completion", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "dumpCoroutinesInfo", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "dumpCoroutinesInfoImpl", "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesSynchronized", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "enhanceStackTraceWithThreadDump", "info", "coroutineTrace", "enhanceStackTraceWithThreadDumpAsJson", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "getDynamicAttach", "hierarchyToString", "job", "hierarchyToString$kotlinx_coroutines_core", "install", "install$kotlinx_coroutines_core", "printStackTrace", "frames", "probeCoroutineCompleted", "owner", "probeCoroutineCreated", "probeCoroutineCreated$kotlinx_coroutines_core", "probeCoroutineResumed", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "uninstall$kotlinx_coroutines_core", "updateRunningState", "updateState", "build", "map", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "isFinished", "realCaller", "toStackTraceFrame", "toStringRepr", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl {
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
    public static final DebugProbesImpl INSTANCE;
    /* access modifiers changed from: private */
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache = new ConcurrentWeakMap<>(true);
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    /* access modifiers changed from: private */
    public static final /* synthetic */ DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private debugProbesImpl$VolatileWrapper$atomicfu$private = new DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private((DefaultConstructorMarker) null);
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces;
    private static boolean ignoreCoroutinesWithEmptyContext = true;
    private static boolean sanitizeStackTraces = true;
    private static Thread weakRefCleanerThread;

    private static /* synthetic */ void getDebugString$annotations(Job job) {
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    public final boolean isInstalled$kotlinx_coroutines_debug() {
        return DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.installations$volatile$FU.get(debugProbesImpl$VolatileWrapper$atomicfu$private) > 0;
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean z) {
        enableCreationStackTraces = z;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean z) {
        ignoreCoroutinesWithEmptyContext = z;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean z) {
        sanitizeStackTraces = z;
    }

    private DebugProbesImpl() {
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        dynamicAttach = debugProbesImpl.getDynamicAttach();
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            obj = Result.m1230constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1230constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1236isFailureimpl(obj)) {
            obj = null;
        }
        return (Function1) obj;
    }

    public final void install$kotlinx_coroutines_core() {
        Function1<Boolean, Unit> function1;
        if (DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.installations$volatile$FU.incrementAndGet(debugProbesImpl$VolatileWrapper$atomicfu$private) <= 1) {
            startWeakRefCleanerThread();
            if (!AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() && (function1 = dynamicAttach) != null) {
                function1.invoke(true);
            }
        }
    }

    public final void uninstall$kotlinx_coroutines_core() {
        Function1<Boolean, Unit> function1;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Agent was not installed".toString());
        } else if (DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.installations$volatile$FU.decrementAndGet(debugProbesImpl$VolatileWrapper$atomicfu$private) == 0) {
            stopWeakRefCleanerThread();
            capturedCoroutinesMap.clear();
            callerInfoCache.clear();
            if (!AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() && (function1 = dynamicAttach) != null) {
                function1.invoke(false);
            }
        }
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, (ClassLoader) null, "Coroutines Debugger Cleaner", 0, DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE, 21, (Object) null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread != null) {
            weakRefCleanerThread = null;
            thread.interrupt();
            thread.join();
        }
    }

    public final String hierarchyToString$kotlinx_coroutines_core(Job job) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            Collection arrayList = new ArrayList();
            for (Object next : getCapturedCoroutines()) {
                if (((CoroutineOwner) next).delegate.getContext().get(Job.Key) != null) {
                    arrayList.add(next);
                }
            }
            Iterable<CoroutineOwner> iterable = (List) arrayList;
            Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (CoroutineOwner coroutineOwner : iterable) {
                linkedHashMap.put(JobKt.getJob(coroutineOwner.delegate.getContext()), coroutineOwner.info);
            }
            StringBuilder sb = new StringBuilder();
            INSTANCE.build(job, linkedHashMap, sb, "");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void build(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl != null) {
            String state$kotlinx_coroutines_core = debugCoroutineInfoImpl.getState$kotlinx_coroutines_core();
            sb.append(str + getDebugString(job) + ", continuation is " + state$kotlinx_coroutines_core + " at line " + ((StackTraceElement) CollectionsKt.firstOrNull(debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core())) + 10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(9);
            str = sb2.toString();
        } else if (!(job instanceof ScopeCoroutine)) {
            sb.append(str + getDebugString(job) + 10);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(9);
            str = sb3.toString();
        }
        for (Job build : job.getChildren()) {
            build(build, map, sb, str);
        }
    }

    private final String getDebugString(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> function2) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfoImpl$3(function2)));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003a, code lost:
        r8 = r8.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        /*
            r17 = this;
            r0 = r17
            java.util.List r1 = r17.dumpCoroutinesInfo()
            int r2 = r1.size()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
            java.util.Iterator r2 = r1.iterator()
        L_0x001d:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00be
            java.lang.Object r6 = r2.next()
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo r6 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfo) r6
            kotlin.coroutines.CoroutineContext r7 = r6.getContext()
            kotlinx.coroutines.CoroutineName$Key r8 = kotlinx.coroutines.CoroutineName.Key
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8
            kotlin.coroutines.CoroutineContext$Element r8 = r7.get(r8)
            kotlinx.coroutines.CoroutineName r8 = (kotlinx.coroutines.CoroutineName) r8
            r9 = 0
            if (r8 == 0) goto L_0x0045
            java.lang.String r8 = r8.getName()
            if (r8 == 0) goto L_0x0045
            java.lang.String r8 = r0.toStringRepr(r8)
            goto L_0x0046
        L_0x0045:
            r8 = r9
        L_0x0046:
            kotlinx.coroutines.CoroutineDispatcher$Key r10 = kotlinx.coroutines.CoroutineDispatcher.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r10 = r7.get(r10)
            kotlinx.coroutines.CoroutineDispatcher r10 = (kotlinx.coroutines.CoroutineDispatcher) r10
            if (r10 == 0) goto L_0x0057
            java.lang.String r10 = r0.toStringRepr(r10)
            goto L_0x0058
        L_0x0057:
            r10 = r9
        L_0x0058:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "\n                {\n                    \"name\": "
            r11.<init>(r12)
            r11.append(r8)
            java.lang.String r8 = ",\n                    \"id\": "
            r11.append(r8)
            kotlinx.coroutines.CoroutineId$Key r8 = kotlinx.coroutines.CoroutineId.Key
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)
            kotlinx.coroutines.CoroutineId r7 = (kotlinx.coroutines.CoroutineId) r7
            if (r7 == 0) goto L_0x007b
            long r7 = r7.getId()
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
        L_0x007b:
            r11.append(r9)
            java.lang.String r7 = ",\n                    \"dispatcher\": "
            r11.append(r7)
            r11.append(r10)
            java.lang.String r7 = ",\n                    \"sequenceNumber\": "
            r11.append(r7)
            long r7 = r6.getSequenceNumber()
            r11.append(r7)
            java.lang.String r7 = ",\n                    \"state\": \""
            r11.append(r7)
            java.lang.String r7 = r6.getState()
            r11.append(r7)
            java.lang.String r7 = "\"\n                } \n                "
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            java.lang.String r7 = kotlin.text.StringsKt.trimIndent(r7)
            r5.add(r7)
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r6.getLastObservedFrame()
            r4.add(r7)
            java.lang.Thread r6 = r6.getLastObservedThread()
            r3.add(r6)
            goto L_0x001d
        L_0x00be:
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "["
            r6.<init>(r7)
            r8 = r5
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 63
            r16 = 0
            java.lang.String r5 = kotlin.collections.CollectionsKt.joinToString$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r6.append(r5)
            r5 = 93
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r6 = 0
            r2[r6] = r5
            java.util.Collection r3 = (java.util.Collection) r3
            java.lang.Thread[] r5 = new java.lang.Thread[r6]
            java.lang.Object[] r3 = r3.toArray(r5)
            r5 = 1
            r2[r5] = r3
            java.util.Collection r4 = (java.util.Collection) r4
            kotlin.coroutines.jvm.internal.CoroutineStackFrame[] r3 = new kotlin.coroutines.jvm.internal.CoroutineStackFrame[r6]
            java.lang.Object[] r3 = r4.toArray(r3)
            r4 = 2
            r2[r4] = r3
            java.util.Collection r1 = (java.util.Collection) r1
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo[] r3 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo[r6]
            java.lang.Object[] r1 = r1.toArray(r3)
            r3 = 3
            r2[r3] = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoAsJsonAndReferences():java.lang.Object[]");
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo debugCoroutineInfo) {
        List<StackTraceElement> enhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(debugCoroutineInfo, debugCoroutineInfo.lastObservedStackTrace());
        List arrayList = new ArrayList();
        for (StackTraceElement next : enhanceStackTraceWithThreadDump) {
            StringBuilder sb = new StringBuilder("\n                {\n                    \"declaringClass\": \"");
            sb.append(next.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(next.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = next.getFileName();
            sb.append(fileName != null ? toStringRepr(fileName) : null);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(next.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(StringsKt.trimIndent(sb.toString()));
        }
        return "[" + CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + AbstractJsonLexerKt.END_LIST;
    }

    private final String toStringRepr(Object obj) {
        return DebugProbesImplKt.repr(obj.toString());
    }

    public final void dumpCoroutines(PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.dumpCoroutinesSynchronized(printStream);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        Job job;
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (job = (Job) context.get(Job.Key)) == null || !job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    private final void dumpCoroutinesSynchronized(PrintStream printStream) {
        String str;
        if (isInstalled$kotlinx_coroutines_debug()) {
            printStream.print("Coroutines dump " + dateFormat.format(Long.valueOf(System.currentTimeMillis())));
            for (CoroutineOwner coroutineOwner : SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(getCapturedCoroutines()), DebugProbesImpl$dumpCoroutinesSynchronized$2.INSTANCE), new DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1())) {
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = coroutineOwner.info;
                List<StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
                DebugProbesImpl debugProbesImpl = INSTANCE;
                List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl = debugProbesImpl.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfoImpl.getState$kotlinx_coroutines_core(), debugCoroutineInfoImpl.lastObservedThread, lastObservedStackTrace$kotlinx_coroutines_core);
                if (!Intrinsics.areEqual((Object) debugCoroutineInfoImpl.getState$kotlinx_coroutines_core(), (Object) DebugCoroutineInfoImplKt.RUNNING) || enhanceStackTraceWithThreadDumpImpl != lastObservedStackTrace$kotlinx_coroutines_core) {
                    str = debugCoroutineInfoImpl.getState$kotlinx_coroutines_core();
                } else {
                    str = debugCoroutineInfoImpl.getState$kotlinx_coroutines_core() + " (Last suspension stacktrace, not an actual stacktrace)";
                }
                printStream.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + str);
                if (lastObservedStackTrace$kotlinx_coroutines_core.isEmpty()) {
                    printStream.print("\n\tat " + ARTIFICIAL_FRAME);
                    debugProbesImpl.printStackTrace(printStream, debugCoroutineInfoImpl.getCreationStackTrace());
                } else {
                    debugProbesImpl.printStackTrace(printStream, enhanceStackTraceWithThreadDumpImpl);
                }
            }
            return;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void printStackTrace(PrintStream printStream, List<StackTraceElement> list) {
        for (StackTraceElement stackTraceElement : list) {
            printStream.print("\n\tat " + stackTraceElement);
        }
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo, List<StackTraceElement> list) {
        return enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String str, Thread thread, List<StackTraceElement> list) {
        Object obj;
        if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return list;
        }
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            obj = Result.m1230constructorimpl(thread.getStackTrace());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1230constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m1236isFailureimpl(obj)) {
            obj = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) "resumeWith") && Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) "ContinuationImpl.kt")) {
                break;
            }
            i++;
        }
        Pair<Integer, Integer> findContinuationStartIndex = findContinuationStartIndex(i, stackTraceElementArr, list);
        int intValue = findContinuationStartIndex.component1().intValue();
        int intValue2 = findContinuationStartIndex.component2().intValue();
        if (intValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i) - intValue) - 1) - intValue2);
        int i2 = i - intValue2;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(stackTraceElementArr[i3]);
        }
        int size = list.size();
        for (int i4 = intValue + 1; i4 < size; i4++) {
            arrayList.add(list.get(i4));
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i2 = 0; i2 < 3; i2++) {
            int findIndexOfFrame = INSTANCE.findIndexOfFrame((i - 1) - i2, stackTraceElementArr, list);
            if (findIndexOfFrame != -1) {
                return TuplesKt.to(Integer.valueOf(findIndexOfFrame), Integer.valueOf(i2));
            }
        }
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull((T[]) stackTraceElementArr, i);
        if (stackTraceElement == null) {
            return -1;
        }
        int i2 = 0;
        for (StackTraceElement next : list) {
            if (Intrinsics.areEqual((Object) next.getFileName(), (Object) stackTraceElement.getFileName()) && Intrinsics.areEqual((Object) next.getClassName(), (Object) stackTraceElement.getClassName()) && Intrinsics.areEqual((Object) next.getMethodName(), (Object) stackTraceElement.getMethodName())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    private final void updateState(Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            if (ignoreCoroutinesWithEmptyContext && continuation.getContext() == EmptyCoroutineContext.INSTANCE) {
                return;
            }
            if (Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING)) {
                CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
                if (coroutineStackFrame != null) {
                    updateRunningState(coroutineStackFrame, str);
                    return;
                }
                return;
            }
            CoroutineOwner<?> owner = owner(continuation);
            if (owner != null) {
                updateState(owner, continuation, str);
            }
        }
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame, String str) {
        boolean z;
        if (isInstalled$kotlinx_coroutines_debug()) {
            ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> concurrentWeakMap = callerInfoCache;
            DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(coroutineStackFrame);
            if (remove != null) {
                z = false;
            } else {
                CoroutineOwner<?> owner = owner(coroutineStackFrame);
                if (owner != null && (remove = owner.info) != null) {
                    CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                    CoroutineStackFrame realCaller = lastObservedFrame$kotlinx_coroutines_core != null ? realCaller(lastObservedFrame$kotlinx_coroutines_core) : null;
                    if (realCaller != null) {
                        concurrentWeakMap.remove(realCaller);
                    }
                    z = true;
                } else {
                    return;
                }
            }
            Intrinsics.checkNotNull(coroutineStackFrame, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame, z);
            CoroutineStackFrame realCaller2 = realCaller(coroutineStackFrame);
            if (realCaller2 != null) {
                concurrentWeakMap.put(realCaller2, remove);
            }
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final void updateState(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            coroutineOwner.info.updateState$kotlinx_coroutines_core(str, continuation, true);
        }
    }

    private final CoroutineOwner<?> owner(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return owner(coroutineStackFrame);
        }
        return null;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> continuation) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return continuation;
        }
        if ((ignoreCoroutinesWithEmptyContext && continuation.getContext() == EmptyCoroutineContext.INSTANCE) || owner((Continuation<?>) continuation) != null) {
            return continuation;
        }
        return createOwner(continuation, enableCreationStackTraces ? toStackTraceFrame(sanitizeStackTrace(new Exception())) : null);
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return continuation;
        }
        CoroutineOwner coroutineOwner = new CoroutineOwner(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, DebugProbesImpl$DebugProbesImpl$VolatileWrapper$atomicfu$private.sequenceNumber$volatile$FU.incrementAndGet(debugProbesImpl$VolatileWrapper$atomicfu$private)));
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> concurrentWeakMap = capturedCoroutinesMap;
        concurrentWeakMap.put(coroutineOwner, true);
        if (!isInstalled$kotlinx_coroutines_debug()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    /* access modifiers changed from: private */
    public final void probeCoroutineCompleted(CoroutineOwner<?> coroutineOwner) {
        CoroutineStackFrame realCaller;
        capturedCoroutinesMap.remove(coroutineOwner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = coroutineOwner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core != null && (realCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core)) != null) {
            callerInfoCache.remove(realCaller);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001d\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001b\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DebugProbesImpl.kt */
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        public final DebugCoroutineInfoImpl info;

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom$kotlinx_coroutines_core();
        }

        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getCallerFrame();
            }
            return null;
        }

        public StackTraceElement getStackTraceElement() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getStackTraceElement();
            }
            return null;
        }

        public void resumeWith(Object obj) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(obj);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (Intrinsics.areEqual((Object) stackTrace[length2].getClassName(), (Object) "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i = length2;
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length2 = i2;
                }
            }
        }
        int i3 = i + 1;
        if (!sanitizeStackTraces) {
            int i4 = length - i3;
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(stackTrace[i5 + i3]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i3) + 1);
        while (i3 < length) {
            if (isInternalMethod(stackTrace[i3])) {
                Collection collection = arrayList2;
                collection.add(stackTrace[i3]);
                int i6 = i3 + 1;
                while (i6 < length && isInternalMethod(stackTrace[i6])) {
                    i6++;
                }
                int i7 = i6 - 1;
                int i8 = i7;
                while (i8 > i3 && stackTrace[i8].getFileName() == null) {
                    i8--;
                }
                if (i8 > i3 && i8 < i7) {
                    collection.add(stackTrace[i8]);
                }
                collection.add(stackTrace[i7]);
                i3 = i6;
            } else {
                arrayList2.add(stackTrace[i3]);
                i3++;
            }
        }
        return arrayList2;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return new StackTraceFrame(stackTraceFrame, ARTIFICIAL_FRAME);
    }
}
