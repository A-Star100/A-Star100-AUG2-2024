package com.onesignal.inAppMessages.internal.repositories.impl;

import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$listInAppMessages$2", f = "InAppRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppRepository.kt */
final class InAppRepository$listInAppMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<InAppMessage> $inAppMessages;
    int label;
    final /* synthetic */ InAppRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppRepository$listInAppMessages$2(InAppRepository inAppRepository, List<InAppMessage> list, Continuation<? super InAppRepository$listInAppMessages$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppRepository;
        this.$inAppMessages = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppRepository$listInAppMessages$2(this.this$0, this.$inAppMessages, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppRepository$listInAppMessages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                IDatabase os = this.this$0._databaseProvider.getOs();
                final InAppRepository inAppRepository = this.this$0;
                final List<InAppMessage> list = this.$inAppMessages;
                IDatabase.DefaultImpls.query$default(os, OneSignalDbContract.InAppMessageTable.TABLE_NAME, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null, new Function1<ICursor, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ICursor) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ICursor iCursor) {
                        Intrinsics.checkNotNullParameter(iCursor, "it");
                        if (iCursor.moveToFirst()) {
                            do {
                                String string = iCursor.getString("message_id");
                                String string2 = iCursor.getString(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS);
                                int i = iCursor.getInt(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_DISPLAY_QUANTITY);
                                long j = iCursor.getLong(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_LAST_DISPLAY);
                                list.add(new InAppMessage(string, JSONUtils.INSTANCE.newStringSetFromJSONArray(new JSONArray(string2)), iCursor.getInt(OneSignalDbContract.InAppMessageTable.COLUMN_DISPLAYED_IN_SESSION) == 1, new InAppMessageRedisplayStats(i, j, inAppRepository._time), inAppRepository._time));
                            } while (iCursor.moveToNext());
                        }
                    }
                }, 254, (Object) null);
            } catch (JSONException e) {
                Logging.error("Generating JSONArray from iam click ids:JSON Failed.", e);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
