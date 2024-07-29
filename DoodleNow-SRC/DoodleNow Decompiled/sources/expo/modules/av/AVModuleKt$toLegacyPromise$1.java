package expo.modules.av;

import androidx.core.os.EnvironmentCompat;
import expo.modules.core.Promise;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"expo/modules/av/AVModuleKt$toLegacyPromise$1", "Lexpo/modules/core/Promise;", "Lexpo/modules/av/LegacyPromise;", "reject", "", "c", "", "m", "e", "", "resolve", "value", "", "expo-av_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AVModule.kt */
public final class AVModuleKt$toLegacyPromise$1 implements Promise {
    final /* synthetic */ expo.modules.kotlin.Promise $newPromise;

    public /* synthetic */ void reject(String str, String str2) {
        Promise.CC.$default$reject((Promise) this, str, str2);
    }

    public /* synthetic */ void reject(String str, Throwable th) {
        Promise.CC.$default$reject((Promise) this, str, th);
    }

    public /* synthetic */ void reject(Throwable th) {
        Promise.CC.$default$reject(this, th);
    }

    AVModuleKt$toLegacyPromise$1(expo.modules.kotlin.Promise promise) {
        this.$newPromise = promise;
    }

    public void resolve(Object obj) {
        this.$newPromise.resolve(obj);
    }

    public void reject(String str, String str2, Throwable th) {
        expo.modules.kotlin.Promise promise = this.$newPromise;
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        promise.reject(str, str2, th);
    }
}
