package expo.modules.av;

import android.content.Context;
import expo.modules.av.player.datasource.SharedCookiesDataSourceFactoryProvider;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import java.util.Arrays;
import java.util.List;

public class AVPackage extends BasePackage {
    public List<InternalModule> createInternalModules(Context context) {
        return Arrays.asList(new InternalModule[]{new AVManager(context), new SharedCookiesDataSourceFactoryProvider()});
    }
}
