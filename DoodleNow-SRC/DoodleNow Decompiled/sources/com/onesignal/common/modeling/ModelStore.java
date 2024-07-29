package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00020\u0006B\u001d\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u001bJ%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010#\u001a\u00020\bH\u0016¢\u0006\u0002\u0010$J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016J\b\u0010'\u001a\u00020\u0018H\u0004J\u0018\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0006\u0010+\u001a\u00020\u0018J\u0018\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u001d\u0010-\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u0010.\u001a\u00020\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0016\u00100\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u0016\u00102\u001a\u00020\u00182\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00063"}, d2 = {"Lcom/onesignal/common/modeling/ModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/common/modeling/IModelStore;", "Lcom/onesignal/common/modeling/IModelChangedHandler;", "name", "", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Ljava/lang/String;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "changeSubscription", "Lcom/onesignal/common/events/EventProducer;", "hasLoadedFromCache", "", "hasSubscribers", "getHasSubscribers", "()Z", "models", "", "getName", "()Ljava/lang/String;", "add", "", "model", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "index", "", "(ILcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "addItem", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/Integer;)V", "clear", "get", "id", "(Ljava/lang/String;)Lcom/onesignal/common/modeling/Model;", "list", "", "load", "onChanged", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "persist", "remove", "removeItem", "replaceAll", "", "subscribe", "handler", "unsubscribe", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModelStore.kt */
public abstract class ModelStore<TModel extends Model> implements IEventNotifier<IModelStoreChangeHandler<TModel>>, IModelStore<TModel>, IModelChangedHandler {
    private final IPreferencesService _prefs;
    private final EventProducer<IModelStoreChangeHandler<TModel>> changeSubscription;
    private boolean hasLoadedFromCache;
    private final List<TModel> models;
    private final String name;

    public ModelStore() {
        this((String) null, (IPreferencesService) null, 3, (DefaultConstructorMarker) null);
    }

    public final String getName() {
        return this.name;
    }

    public ModelStore(String str, IPreferencesService iPreferencesService) {
        this.name = str;
        this._prefs = iPreferencesService;
        this.changeSubscription = new EventProducer<>();
        this.models = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModelStore(String str, IPreferencesService iPreferencesService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : iPreferencesService);
    }

    public void add(TModel tmodel, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(tmodel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        synchronized (this.models) {
            Iterator it = this.models.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((Model) obj).getId(), (Object) tmodel.getId())) {
                    break;
                }
            }
            Model model = (Model) obj;
            if (model != null) {
                removeItem(model, str);
            }
            addItem$default(this, tmodel, str, (Integer) null, 4, (Object) null);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void add(int i, TModel tmodel, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(tmodel, "model");
        Intrinsics.checkNotNullParameter(str, "tag");
        synchronized (this.models) {
            Iterator it = this.models.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((Model) obj).getId(), (Object) tmodel.getId())) {
                    break;
                }
            }
            Model model = (Model) obj;
            if (model != null) {
                removeItem(model, str);
            }
            addItem(tmodel, str, Integer.valueOf(i));
            Unit unit = Unit.INSTANCE;
        }
    }

    public Collection<TModel> list() {
        List list;
        synchronized (this.models) {
            list = CollectionsKt.toList(this.models);
        }
        return list;
    }

    public TModel get(String str) {
        TModel tmodel;
        Intrinsics.checkNotNullParameter(str, "id");
        Iterator it = this.models.iterator();
        while (true) {
            if (!it.hasNext()) {
                tmodel = null;
                break;
            }
            tmodel = it.next();
            if (Intrinsics.areEqual((Object) ((Model) tmodel).getId(), (Object) str)) {
                break;
            }
        }
        return (Model) tmodel;
    }

    public void remove(String str, String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "tag");
        synchronized (this.models) {
            Iterator it = this.models.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((Model) obj).getId(), (Object) str)) {
                    break;
                }
            }
            Model model = (Model) obj;
            if (model != null) {
                removeItem(model, str2);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public void onChanged(ModelChangedArgs modelChangedArgs, String str) {
        Intrinsics.checkNotNullParameter(modelChangedArgs, "args");
        Intrinsics.checkNotNullParameter(str, "tag");
        persist();
        this.changeSubscription.fire(new ModelStore$onChanged$1(modelChangedArgs, str));
    }

    public void replaceAll(List<? extends TModel> list, String str) {
        Intrinsics.checkNotNullParameter(list, "models");
        Intrinsics.checkNotNullParameter(str, "tag");
        synchronized (list) {
            clear(str);
            Iterator<? extends TModel> it = list.iterator();
            while (it.hasNext()) {
                add((Model) it.next(), str);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void clear(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        List<Model> list = CollectionsKt.toList(this.models);
        synchronized (this.models) {
            this.models.clear();
            persist();
            Unit unit = Unit.INSTANCE;
        }
        for (Model model : list) {
            model.unsubscribe((IModelChangedHandler) this);
            this.changeSubscription.fire(new ModelStore$clear$2(model, str));
        }
    }

    static /* synthetic */ void addItem$default(ModelStore modelStore, Model model, String str, Integer num, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                num = null;
            }
            modelStore.addItem(model, str, num);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItem");
    }

    private final void addItem(TModel tmodel, String str, Integer num) {
        synchronized (this.models) {
            if (num != null) {
                this.models.add(num.intValue(), tmodel);
            } else {
                this.models.add(tmodel);
            }
            tmodel.subscribe((IModelChangedHandler) this);
            persist();
            Unit unit = Unit.INSTANCE;
        }
        this.changeSubscription.fire(new ModelStore$addItem$2(tmodel, str));
    }

    private final void removeItem(TModel tmodel, String str) {
        synchronized (this.models) {
            this.models.remove(tmodel);
            tmodel.unsubscribe((IModelChangedHandler) this);
            persist();
            Unit unit = Unit.INSTANCE;
        }
        this.changeSubscription.fire(new ModelStore$removeItem$2(tmodel, str));
    }

    /* access modifiers changed from: protected */
    public final void load() {
        IPreferencesService iPreferencesService;
        if (this.name != null && (iPreferencesService = this._prefs) != null) {
            JSONArray jSONArray = new JSONArray(iPreferencesService.getString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.MODEL_STORE_PREFIX + this.name, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
            synchronized (this.models) {
                boolean z = !this.models.isEmpty();
                for (int length = jSONArray.length() - 1; -1 < length; length--) {
                    Model create = create(jSONArray.getJSONObject(length));
                    if (create != null) {
                        Iterable iterable = this.models;
                        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                            Iterator it = iterable.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (Intrinsics.areEqual((Object) ((Model) it.next()).getId(), (Object) create.getId())) {
                                        Logging.debug$default("ModelStore<" + this.name + ">: load - operation.id: " + create.getId() + " already exists in the store.", (Throwable) null, 2, (Object) null);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        this.models.add(0, create);
                        create.subscribe((IModelChangedHandler) this);
                    }
                }
                this.hasLoadedFromCache = true;
                if (z) {
                    persist();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void persist() {
        if (this.name != null && this._prefs != null && this.hasLoadedFromCache) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.models) {
                for (TModel json : this.models) {
                    jSONArray.put(json.toJSON());
                }
                Unit unit = Unit.INSTANCE;
            }
            IPreferencesService iPreferencesService = this._prefs;
            iPreferencesService.saveString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.MODEL_STORE_PREFIX + this.name, jSONArray.toString());
        }
    }

    public void subscribe(IModelStoreChangeHandler<TModel> iModelStoreChangeHandler) {
        Intrinsics.checkNotNullParameter(iModelStoreChangeHandler, "handler");
        this.changeSubscription.subscribe(iModelStoreChangeHandler);
    }

    public void unsubscribe(IModelStoreChangeHandler<TModel> iModelStoreChangeHandler) {
        Intrinsics.checkNotNullParameter(iModelStoreChangeHandler, "handler");
        this.changeSubscription.unsubscribe(iModelStoreChangeHandler);
    }

    public boolean getHasSubscribers() {
        return this.changeSubscription.getHasSubscribers();
    }
}
