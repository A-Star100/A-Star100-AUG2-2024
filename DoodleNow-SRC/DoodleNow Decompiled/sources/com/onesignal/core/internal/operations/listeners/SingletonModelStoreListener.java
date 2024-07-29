package com.onesignal.core.internal.operations.listeners;

import com.onesignal.common.modeling.ISingletonModelStore;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J;\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/operations/listeners/SingletonModelStoreListener;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "Ljava/io/Closeable;", "store", "Lcom/onesignal/common/modeling/ISingletonModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "(Lcom/onesignal/common/modeling/ISingletonModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;)V", "bootstrap", "", "close", "getReplaceOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "(Lcom/onesignal/common/modeling/Model;)Lcom/onesignal/core/internal/operations/Operation;", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/onesignal/core/internal/operations/Operation;", "onModelReplaced", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SingletonModelStoreListener.kt */
public abstract class SingletonModelStoreListener<TModel extends Model> implements ISingletonModelStoreChangeHandler<TModel>, IBootstrapService, Closeable {
    private final IOperationRepo opRepo;
    private final ISingletonModelStore<TModel> store;

    public abstract Operation getReplaceOperation(TModel tmodel);

    public abstract Operation getUpdateOperation(TModel tmodel, String str, String str2, Object obj, Object obj2);

    public SingletonModelStoreListener(ISingletonModelStore<TModel> iSingletonModelStore, IOperationRepo iOperationRepo) {
        Intrinsics.checkNotNullParameter(iSingletonModelStore, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(iOperationRepo, "opRepo");
        this.store = iSingletonModelStore;
        this.opRepo = iOperationRepo;
    }

    public void bootstrap() {
        this.store.subscribe(this);
    }

    public void close() {
        this.store.unsubscribe(this);
    }

    public void onModelReplaced(TModel tmodel, String str) {
        Operation replaceOperation;
        Intrinsics.checkNotNullParameter(tmodel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.NORMAL) && (replaceOperation = getReplaceOperation(tmodel)) != null) {
            IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, replaceOperation, false, 2, (Object) null);
        }
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.NORMAL)) {
            Model model = modelChangedArgs.getModel();
            Intrinsics.checkNotNull(model, "null cannot be cast to non-null type TModel of com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener");
            Operation updateOperation = getUpdateOperation(model, modelChangedArgs.getPath(), modelChangedArgs.getProperty(), modelChangedArgs.getOldValue(), modelChangedArgs.getNewValue());
            if (updateOperation != null) {
                IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, updateOperation, false, 2, (Object) null);
            }
        }
    }
}
