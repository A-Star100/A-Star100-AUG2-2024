package expo.modules.adapters.react;

import android.content.Context;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryProvider;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.SingletonModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ReactModuleRegistryProvider extends ModuleRegistryProvider {
    private Collection<ViewManager> mReactViewManagers;
    private Collection<SingletonModule> mSingletonModules;

    public ReactModuleRegistryProvider(List<Package> list) {
        this(list, (List<SingletonModule>) null);
    }

    public ReactModuleRegistryProvider(List<Package> list, List<SingletonModule> list2) {
        super(list);
        this.mSingletonModules = list2;
    }

    public ModuleRegistry get(Context context) {
        ArrayList arrayList = new ArrayList();
        ReactPackagesProvider reactPackagesProvider = new ReactPackagesProvider();
        for (Package next : getPackages()) {
            arrayList.addAll(next.createInternalModules(context));
            if (next instanceof ReactPackage) {
                reactPackagesProvider.addPackage((ReactPackage) next);
            }
        }
        arrayList.add(reactPackagesProvider);
        return new ModuleRegistry(arrayList, getSingletonModules(context));
    }

    private Collection<SingletonModule> getSingletonModules(Context context) {
        Collection<SingletonModule> collection = this.mSingletonModules;
        if (collection != null) {
            return collection;
        }
        ArrayList arrayList = new ArrayList();
        for (Package createSingletonModules : getPackages()) {
            arrayList.addAll(createSingletonModules.createSingletonModules(context));
        }
        return arrayList;
    }

    public Collection<ViewManager> getReactViewManagers(ReactApplicationContext reactApplicationContext) {
        Collection<ViewManager> collection = this.mReactViewManagers;
        if (collection != null) {
            return collection;
        }
        this.mReactViewManagers = new HashSet();
        for (Package next : getPackages()) {
            if (next instanceof ReactPackage) {
                this.mReactViewManagers.addAll(((ReactPackage) next).createViewManagers(reactApplicationContext));
            }
        }
        return this.mReactViewManagers;
    }
}
