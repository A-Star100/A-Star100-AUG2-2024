package com.onesignal.common.modeling;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.preferences.IPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/onesignal/common/modeling/SimpleModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/ModelStore;", "_create", "Lkotlin/Function0;", "name", "", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "create", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)Lcom/onesignal/common/modeling/Model;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SimpleModelStore.kt */
public class SimpleModelStore<TModel extends Model> extends ModelStore<TModel> {
    private final Function0<TModel> _create;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleModelStore(Function0 function0, String str, IPreferencesService iPreferencesService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : iPreferencesService);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleModelStore(Function0<? extends TModel> function0, String str, IPreferencesService iPreferencesService) {
        super(str, iPreferencesService);
        Intrinsics.checkNotNullParameter(function0, "_create");
        this._create = function0;
        load();
    }

    public TModel create(JSONObject jSONObject) {
        TModel tmodel = (Model) this._create.invoke();
        if (jSONObject != null) {
            tmodel.initializeFromJson(jSONObject);
        }
        return tmodel;
    }
}
