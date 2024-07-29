package com.onesignal.user.internal;

import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.state.UserChangedState;
import com.onesignal.user.state.UserState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/user/state/IUserStateObserver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: UserManager.kt */
final class UserManager$onModelUpdated$1 extends Lambda implements Function1<IUserStateObserver, Unit> {
    final /* synthetic */ UserState $newUserState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserManager$onModelUpdated$1(UserState userState) {
        super(1);
        this.$newUserState = userState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IUserStateObserver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IUserStateObserver iUserStateObserver) {
        Intrinsics.checkNotNullParameter(iUserStateObserver, "it");
        iUserStateObserver.onUserStateChange(new UserChangedState(this.$newUserState));
    }
}
