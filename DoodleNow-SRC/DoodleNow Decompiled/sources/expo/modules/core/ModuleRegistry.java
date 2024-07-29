package expo.modules.core;

import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleRegistry {
    private final List<WeakReference<RegistryLifecycleListener>> mExtraRegistryLifecycleListeners = new ArrayList();
    private final Map<Class, InternalModule> mInternalModulesMap = new HashMap();
    private volatile boolean mIsInitialized = false;
    private final Map<String, SingletonModule> mSingletonModulesMap = new HashMap();

    public ModuleRegistry(Collection<InternalModule> collection, Collection<SingletonModule> collection2) {
        for (InternalModule registerInternalModule : collection) {
            registerInternalModule(registerInternalModule);
        }
        for (SingletonModule registerSingletonModule : collection2) {
            registerSingletonModule(registerSingletonModule);
        }
    }

    public <T> T getModule(Class<T> cls) {
        return this.mInternalModulesMap.get(cls);
    }

    public <T> T getSingletonModule(String str, Class<T> cls) {
        return this.mSingletonModulesMap.get(str);
    }

    public void registerInternalModule(InternalModule internalModule) {
        for (Class put : internalModule.getExportedInterfaces()) {
            this.mInternalModulesMap.put(put, internalModule);
        }
    }

    public InternalModule unregisterInternalModule(Class cls) {
        return this.mInternalModulesMap.remove(cls);
    }

    public void registerSingletonModule(SingletonModule singletonModule) {
        this.mSingletonModulesMap.put(singletonModule.getName(), singletonModule);
    }

    public void registerExtraListener(RegistryLifecycleListener registryLifecycleListener) {
        this.mExtraRegistryLifecycleListeners.add(new WeakReference(registryLifecycleListener));
    }

    public synchronized void ensureIsInitialized() {
        if (!this.mIsInitialized) {
            initialize();
            this.mIsInitialized = true;
        }
    }

    public void initialize() {
        ArrayList<RegistryLifecycleListener> arrayList = new ArrayList<>(this.mInternalModulesMap.values());
        for (WeakReference next : this.mExtraRegistryLifecycleListeners) {
            if (next.get() != null) {
                arrayList.add((RegistryLifecycleListener) next.get());
            }
        }
        for (RegistryLifecycleListener onCreate : arrayList) {
            onCreate.onCreate(this);
        }
    }

    public void onDestroy() {
        ArrayList<RegistryLifecycleListener> arrayList = new ArrayList<>(this.mInternalModulesMap.values());
        for (WeakReference next : this.mExtraRegistryLifecycleListeners) {
            if (next.get() != null) {
                arrayList.add((RegistryLifecycleListener) next.get());
            }
        }
        for (RegistryLifecycleListener onDestroy : arrayList) {
            onDestroy.onDestroy();
        }
    }
}
