package expo.modules;

import com.facebook.react.ReactHost;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/facebook/react/ReactHost;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactActivityDelegateWrapper.kt */
final class ReactActivityDelegateWrapper$_reactHost$2 extends Lambda implements Function0<ReactHost> {
    final /* synthetic */ ReactActivityDelegateWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReactActivityDelegateWrapper$_reactHost$2(ReactActivityDelegateWrapper reactActivityDelegateWrapper) {
        super(0);
        this.this$0 = reactActivityDelegateWrapper;
    }

    public final ReactHost invoke() {
        return this.this$0.delegate.getReactHost();
    }
}
