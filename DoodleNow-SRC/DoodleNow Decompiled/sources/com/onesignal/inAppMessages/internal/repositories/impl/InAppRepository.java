package com.onesignal.inAppMessages.internal.repositories.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/repositories/impl/InAppRepository;", "Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;", "_databaseProvider", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_prefs", "Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "(Lcom/onesignal/core/internal/database/IDatabaseProvider;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;)V", "cleanCachedInAppMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listInAppMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "saveInAppMessage", "inAppMessage", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppRepository.kt */
public final class InAppRepository implements IInAppRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long IAM_CACHE_DATA_LIFETIME = 15552000;
    /* access modifiers changed from: private */
    public final IDatabaseProvider _databaseProvider;
    /* access modifiers changed from: private */
    public final IInAppPreferencesController _prefs;
    /* access modifiers changed from: private */
    public final ITime _time;

    public InAppRepository(IDatabaseProvider iDatabaseProvider, ITime iTime, IInAppPreferencesController iInAppPreferencesController) {
        Intrinsics.checkNotNullParameter(iDatabaseProvider, "_databaseProvider");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        Intrinsics.checkNotNullParameter(iInAppPreferencesController, "_prefs");
        this._databaseProvider = iDatabaseProvider;
        this._time = iTime;
        this._prefs = iInAppPreferencesController;
    }

    public Object saveInAppMessage(InAppMessage inAppMessage, Continuation<? super Unit> continuation) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", inAppMessage.getMessageId());
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_DISPLAY_QUANTITY, Boxing.boxInt(inAppMessage.getRedisplayStats().getDisplayQuantity()));
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_LAST_DISPLAY, Boxing.boxLong(inAppMessage.getRedisplayStats().getLastDisplayTime()));
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS, inAppMessage.getClickedClickIds().toString());
        contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_DISPLAYED_IN_SESSION, Boxing.boxBoolean(inAppMessage.isDisplayedInSession()));
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new InAppRepository$saveInAppMessage$2(this, contentValues, inAppMessage, (Continuation<? super InAppRepository$saveInAppMessage$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object listInAppMessages(kotlin.coroutines.Continuation<? super java.util.List<com.onesignal.inAppMessages.internal.InAppMessage>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2 r4 = new com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2
            r5 = 0
            r4.<init>(r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r0 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r7
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository.listInAppMessages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object cleanCachedInAppMessages(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new InAppRepository$cleanCachedInAppMessages$2(this, (Continuation<? super InAppRepository$cleanCachedInAppMessages$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/inAppMessages/internal/repositories/impl/InAppRepository$Companion;", "", "()V", "IAM_CACHE_DATA_LIFETIME", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
