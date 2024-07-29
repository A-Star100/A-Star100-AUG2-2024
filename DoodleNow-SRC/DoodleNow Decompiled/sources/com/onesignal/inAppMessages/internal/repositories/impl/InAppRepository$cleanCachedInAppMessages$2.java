package com.onesignal.inAppMessages.internal.repositories.impl;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.database.ICursor;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.debug.internal.logging.Logging;
import java.util.LinkedHashSet;
import java.util.Set;
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
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.repositories.impl.InAppRepository$cleanCachedInAppMessages$2", f = "InAppRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppRepository.kt */
final class InAppRepository$cleanCachedInAppMessages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InAppRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppRepository$cleanCachedInAppMessages$2(InAppRepository inAppRepository, Continuation<? super InAppRepository$cleanCachedInAppMessages$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppRepository$cleanCachedInAppMessages$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppRepository$cleanCachedInAppMessages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Set set;
        Set set2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String[] strArr = {"message_id", OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS};
            String[] strArr2 = {String.valueOf((System.currentTimeMillis() / 1000) - InAppRepository.IAM_CACHE_DATA_LIFETIME)};
            final Set linkedHashSet = new LinkedHashSet();
            final Set linkedHashSet2 = new LinkedHashSet();
            try {
                set2 = linkedHashSet2;
                set = linkedHashSet;
                try {
                    IDatabase.DefaultImpls.query$default(this.this$0._databaseProvider.getOs(), OneSignalDbContract.InAppMessageTable.TABLE_NAME, strArr, "last_display < ?", strArr2, (String) null, (String) null, (String) null, (String) null, new Function1<ICursor, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ICursor) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ICursor iCursor) {
                            Intrinsics.checkNotNullParameter(iCursor, "it");
                            if (iCursor.getCount() == 0) {
                                Logging.debug$default("Attempted to clean 6 month old IAM data, but none exists!", (Throwable) null, 2, (Object) null);
                            } else if (iCursor.moveToFirst()) {
                                do {
                                    String string = iCursor.getString("message_id");
                                    String string2 = iCursor.getString(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS);
                                    linkedHashSet.add(string);
                                    linkedHashSet2.addAll(JSONUtils.INSTANCE.newStringSetFromJSONArray(new JSONArray(string2)));
                                } while (iCursor.moveToNext());
                            }
                        }
                    }, PsExtractor.VIDEO_STREAM_MASK, (Object) null);
                } catch (JSONException e) {
                    e = e;
                }
            } catch (JSONException e2) {
                e = e2;
                set2 = linkedHashSet2;
                set = linkedHashSet;
                e.printStackTrace();
                this.this$0._databaseProvider.getOs().delete(OneSignalDbContract.InAppMessageTable.TABLE_NAME, "last_display < ?", strArr2);
                this.this$0._prefs.cleanInAppMessageIds(set);
                this.this$0._prefs.cleanInAppMessageClickedClickIds(set2);
                return Unit.INSTANCE;
            }
            this.this$0._databaseProvider.getOs().delete(OneSignalDbContract.InAppMessageTable.TABLE_NAME, "last_display < ?", strArr2);
            this.this$0._prefs.cleanInAppMessageIds(set);
            this.this$0._prefs.cleanInAppMessageClickedClickIds(set2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
