package expo.modules.av;

import expo.modules.core.Promise;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0003j\u0002`\u0004H\u0002*\f\b\u0002\u0010\u0005\"\u00020\u00032\u00020\u0003*\f\b\u0002\u0010\u0006\"\u00020\u00012\u00020\u0001¨\u0006\u0007"}, d2 = {"toLegacyPromise", "Lexpo/modules/core/Promise;", "Lexpo/modules/av/LegacyPromise;", "Lexpo/modules/kotlin/Promise;", "Lexpo/modules/av/KotlinPromise;", "KotlinPromise", "LegacyPromise", "expo-av_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: AVModule.kt */
public final class AVModuleKt {
    /* access modifiers changed from: private */
    public static final Promise toLegacyPromise(expo.modules.kotlin.Promise promise) {
        return new AVModuleKt$toLegacyPromise$1(promise);
    }
}
