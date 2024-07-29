package com.onesignal.core.internal.language.impl;

import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/onesignal/core/internal/language/impl/LanguageContext;", "Lcom/onesignal/core/internal/language/ILanguageContext;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "(Lcom/onesignal/user/internal/properties/PropertiesModelStore;)V", "deviceLanguageProvider", "Lcom/onesignal/core/internal/language/impl/LanguageProviderDevice;", "value", "", "language", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LanguageContext.kt */
public final class LanguageContext implements ILanguageContext {
    private final PropertiesModelStore _propertiesModelStore;
    private LanguageProviderDevice deviceLanguageProvider = new LanguageProviderDevice();

    public LanguageContext(PropertiesModelStore propertiesModelStore) {
        Intrinsics.checkNotNullParameter(propertiesModelStore, "_propertiesModelStore");
        this._propertiesModelStore = propertiesModelStore;
    }

    public String getLanguage() {
        String language = ((PropertiesModel) this._propertiesModelStore.getModel()).getLanguage();
        return language == null ? this.deviceLanguageProvider.getLanguage() : language;
    }

    public void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        ((PropertiesModel) this._propertiesModelStore.getModel()).setLanguage(str);
    }
}
