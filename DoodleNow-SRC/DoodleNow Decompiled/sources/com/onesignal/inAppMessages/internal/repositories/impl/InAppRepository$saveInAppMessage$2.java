package com.onesignal.inAppMessages.internal.repositories.impl;

import android.content.ContentValues;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.inAppMessages.internal.InAppMessage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$saveInAppMessage$2", f = "InAppRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppRepository.kt */
final class InAppRepository$saveInAppMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessage $inAppMessage;
    final /* synthetic */ ContentValues $values;
    int label;
    final /* synthetic */ InAppRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppRepository$saveInAppMessage$2(InAppRepository inAppRepository, ContentValues contentValues, InAppMessage inAppMessage, Continuation<? super InAppRepository$saveInAppMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppRepository;
        this.$values = contentValues;
        this.$inAppMessage = inAppMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppRepository$saveInAppMessage$2(this.this$0, this.$values, this.$inAppMessage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppRepository$saveInAppMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0._databaseProvider.getOs().update(OneSignalDbContract.InAppMessageTable.TABLE_NAME, this.$values, "message_id = ?", new String[]{this.$inAppMessage.getMessageId()}) == 0) {
                this.this$0._databaseProvider.getOs().insert(OneSignalDbContract.InAppMessageTable.TABLE_NAME, (String) null, this.$values);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
