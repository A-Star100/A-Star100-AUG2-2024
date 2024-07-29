package expo.modules.av.player;

import expo.modules.interfaces.permissions.PermissionsResponseListener;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PlayerData$$ExternalSyntheticLambda3 implements PermissionsResponseListener {
    public final /* synthetic */ PlayerData f$0;

    public /* synthetic */ PlayerData$$ExternalSyntheticLambda3(PlayerData playerData) {
        this.f$0 = playerData;
    }

    public final void onResult(Map map) {
        this.f$0.lambda$setEnableSampleBufferCallback$1(map);
    }
}
