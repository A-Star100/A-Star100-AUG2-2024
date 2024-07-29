package expo.modules.location;

import android.os.Bundle;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.location.records.PermissionRequestResponse;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"expo/modules/location/LocationHelpers$Companion$getPermissionsWithPermissionsManager$2$1", "Lexpo/modules/kotlin/Promise;", "reject", "", "code", "", "message", "cause", "", "resolve", "value", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationHelpers.kt */
public final class LocationHelpers$Companion$getPermissionsWithPermissionsManager$2$1 implements Promise {
    final /* synthetic */ Continuation<PermissionRequestResponse> $continuation;

    LocationHelpers$Companion$getPermissionsWithPermissionsManager$2$1(Continuation<? super PermissionRequestResponse> continuation) {
        this.$continuation = continuation;
    }

    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    public void resolve() {
        Promise.DefaultImpls.resolve(this);
    }

    public void resolve(double d) {
        Promise.DefaultImpls.resolve((Promise) this, d);
    }

    public void resolve(float f) {
        Promise.DefaultImpls.resolve((Promise) this, f);
    }

    public void resolve(int i) {
        Promise.DefaultImpls.resolve((Promise) this, i);
    }

    public void resolve(String str) {
        Promise.DefaultImpls.resolve((Promise) this, str);
    }

    public void resolve(boolean z) {
        Promise.DefaultImpls.resolve((Promise) this, z);
    }

    public void resolve(Object obj) {
        Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
        if (bundle != null) {
            Continuation<PermissionRequestResponse> continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1230constructorimpl(new PermissionRequestResponse(bundle)));
            return;
        }
        throw new ConversionException(Object.class, Bundle.class, "value returned by the permission promise is not a Bundle");
    }

    public void reject(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "code");
        Continuation<PermissionRequestResponse> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1230constructorimpl(ResultKt.createFailure(new CodedException(str, str2, th))));
    }
}
