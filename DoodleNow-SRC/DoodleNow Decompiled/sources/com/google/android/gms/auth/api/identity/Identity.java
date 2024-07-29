package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p001authapi.zbaa;
import com.google.android.gms.internal.p001authapi.zbag;
import com.google.android.gms.internal.p001authapi.zbaq;

/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final class Identity {
    private Identity() {
    }

    public static AuthorizationClient getAuthorizationClient(Activity activity) {
        return new zbaa((Activity) Preconditions.checkNotNull(activity), new zbb((zba) null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(Activity activity) {
        return new zbag((Activity) Preconditions.checkNotNull(activity), new zbh());
    }

    public static SignInClient getSignInClient(Activity activity) {
        return new zbaq((Activity) Preconditions.checkNotNull(activity), new zbu());
    }

    public static AuthorizationClient getAuthorizationClient(Context context) {
        return new zbaa((Context) Preconditions.checkNotNull(context), new zbb((zba) null).zbb());
    }

    public static CredentialSavingClient getCredentialSavingClient(Context context) {
        return new zbag((Context) Preconditions.checkNotNull(context), new zbh());
    }

    public static SignInClient getSignInClient(Context context) {
        return new zbaq((Context) Preconditions.checkNotNull(context), new zbu());
    }
}
