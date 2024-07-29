package com.onesignal.common.modeling;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/onesignal/common/modeling/ModelChangedArgs;", "", "model", "Lcom/onesignal/common/modeling/Model;", "path", "", "property", "oldValue", "newValue", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getModel", "()Lcom/onesignal/common/modeling/Model;", "getNewValue", "()Ljava/lang/Object;", "getOldValue", "getPath", "()Ljava/lang/String;", "getProperty", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IModelChangedHandler.kt */
public final class ModelChangedArgs {
    private final Model model;
    private final Object newValue;
    private final Object oldValue;
    private final String path;
    private final String property;

    public final Model getModel() {
        return this.model;
    }

    public final Object getNewValue() {
        return this.newValue;
    }

    public final Object getOldValue() {
        return this.oldValue;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getProperty() {
        return this.property;
    }

    public ModelChangedArgs(Model model2, String str, String str2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        Intrinsics.checkNotNullParameter(str2, "property");
        this.model = model2;
        this.path = str;
        this.property = str2;
        this.oldValue = obj;
        this.newValue = obj2;
    }
}
