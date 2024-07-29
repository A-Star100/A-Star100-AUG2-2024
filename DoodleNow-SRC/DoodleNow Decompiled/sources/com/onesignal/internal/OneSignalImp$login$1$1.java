package com.onesignal.internal;

import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.properties.PropertiesModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "identityModel", "Lcom/onesignal/user/internal/identity/IdentityModel;", "<anonymous parameter 1>", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalImp.kt */
final class OneSignalImp$login$1$1 extends Lambda implements Function2<IdentityModel, PropertiesModel, Unit> {
    final /* synthetic */ String $externalId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneSignalImp$login$1$1(String str) {
        super(2);
        this.$externalId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IdentityModel) obj, (PropertiesModel) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(IdentityModel identityModel, PropertiesModel propertiesModel) {
        Intrinsics.checkNotNullParameter(identityModel, "identityModel");
        Intrinsics.checkNotNullParameter(propertiesModel, "<anonymous parameter 1>");
        identityModel.setExternalId(this.$externalId);
    }
}
