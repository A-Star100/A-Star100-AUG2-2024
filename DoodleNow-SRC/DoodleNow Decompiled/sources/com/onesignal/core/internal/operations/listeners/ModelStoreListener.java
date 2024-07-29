package com.onesignal.core.internal.operations.listeners;

import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J;\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/onesignal/core/internal/operations/listeners/ModelStoreListener;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "Ljava/io/Closeable;", "store", "Lcom/onesignal/common/modeling/IModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "(Lcom/onesignal/common/modeling/IModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;)V", "bootstrap", "", "close", "getAddOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "(Lcom/onesignal/common/modeling/Model;)Lcom/onesignal/core/internal/operations/Operation;", "getRemoveOperation", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/onesignal/core/internal/operations/Operation;", "onModelAdded", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModelStoreListener.kt */
public abstract class ModelStoreListener<TModel extends Model> implements IModelStoreChangeHandler<TModel>, IBootstrapService, Closeable {
    private final IOperationRepo opRepo;
    private final IModelStore<TModel> store;

    public abstract Operation getAddOperation(TModel tmodel);

    public abstract Operation getRemoveOperation(TModel tmodel);

    public abstract Operation getUpdateOperation(TModel tmodel, String str, String str2, Object obj, Object obj2);

    public ModelStoreListener(IModelStore<TModel> iModelStore, IOperationRepo iOperationRepo) {
        Intrinsics.checkNotNullParameter(iModelStore, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(iOperationRepo, "opRepo");
        this.store = iModelStore;
        this.opRepo = iOperationRepo;
    }

    public void bootstrap() {
        this.store.subscribe(this);
    }

    public void close() {
        this.store.unsubscribe(this);
    }

    public void onModelAdded(TModel tmodel, String str) {
        Operation addOperation;
        Intrinsics.checkNotNullParameter(tmodel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.NORMAL) && (addOperation = getAddOperation(tmodel)) != null) {
            IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, addOperation, false, 2, (Object) null);
        }
    }

    public void onModelUpdated(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.NORMAL)) {
            Model model = modelChangedArgs.getModel();
            Intrinsics.checkNotNull(model, "null cannot be cast to non-null type TModel of com.onesignal.core.internal.operations.listeners.ModelStoreListener");
            Operation updateOperation = getUpdateOperation(model, modelChangedArgs.getPath(), modelChangedArgs.getProperty(), modelChangedArgs.getOldValue(), modelChangedArgs.getNewValue());
            if (updateOperation != null) {
                IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, updateOperation, false, 2, (Object) null);
            }
        }
    }

    public void onModelRemoved(TModel tmodel, String str) {
        Operation removeOperation;
        Intrinsics.checkNotNullParameter(tmodel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        if (Intrinsics.areEqual((Object) str, (Object) ModelChangeTags.NORMAL) && (removeOperation = getRemoveOperation(tmodel)) != null) {
            IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, removeOperation, false, 2, (Object) null);
        }
    }
}
