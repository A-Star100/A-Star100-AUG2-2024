package expo.modules.imagepicker;

import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.kotlin.Promise;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImagePickerModule$$ExternalSyntheticLambda0 implements PermissionsResponseListener {
    public final /* synthetic */ Promise f$0;
    public final /* synthetic */ WeakReference f$1;
    public final /* synthetic */ ImagePickerModule f$2;

    public /* synthetic */ ImagePickerModule$$ExternalSyntheticLambda0(Promise promise, WeakReference weakReference, ImagePickerModule imagePickerModule) {
        this.f$0 = promise;
        this.f$1 = weakReference;
        this.f$2 = imagePickerModule;
    }

    public final void onResult(Map map) {
        ImagePickerModule.createPermissionsDecorator$lambda$14(this.f$0, this.f$1, this.f$2, map);
    }
}
