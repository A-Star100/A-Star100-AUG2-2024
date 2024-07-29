package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003*\f\b\u0002\u0010\r\"\u00020\u000e2\u00020\u000e¨\u0006\u000f"}, d2 = {"CONDITION_FALSE", "", "getCONDITION_FALSE$annotations", "()V", "getCONDITION_FALSE", "()Ljava/lang/Object;", "FAILURE", "", "getFAILURE$annotations", "SUCCESS", "getSUCCESS$annotations", "UNDECIDED", "getUNDECIDED$annotations", "Node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: LockFreeLinkedList.kt */
public final class LockFreeLinkedListKt {
    private static final Object CONDITION_FALSE = new Symbol("CONDITION_FALSE");
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;

    public static final Object getCONDITION_FALSE() {
        return CONDITION_FALSE;
    }

    public static /* synthetic */ void getCONDITION_FALSE$annotations() {
    }

    public static /* synthetic */ void getFAILURE$annotations() {
    }

    public static /* synthetic */ void getSUCCESS$annotations() {
    }

    public static /* synthetic */ void getUNDECIDED$annotations() {
    }
}
