package com.google.mlkit.common.internal;

import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.internal.model.zzg;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.CloseGuard;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public class CommonComponentRegistrar implements ComponentRegistrar {
    public static final /* synthetic */ int zza = 0;

    public final List getComponents() {
        return zzar.zzi(SharedPrefManager.COMPONENT, Component.builder(ModelFileHelper.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(zza.zza).build(), Component.builder(MlKitThreadPool.class).factory(zzb.zza).build(), Component.builder(RemoteModelManager.class).add(Dependency.setOf((Class<?>) RemoteModelManager.RemoteModelManagerRegistration.class)).factory(zzc.zza).build(), Component.builder(ExecutorSelector.class).add(Dependency.requiredProvider((Class<?>) MlKitThreadPool.class)).factory(zzd.zza).build(), Component.builder(Cleaner.class).factory(zze.zza).build(), Component.builder(CloseGuard.Factory.class).add(Dependency.required((Class<?>) Cleaner.class)).factory(zzf.zza).build(), Component.builder(zzg.class).add(Dependency.required((Class<?>) MlKitContext.class)).factory(zzg.zza).build(), Component.intoSetBuilder(RemoteModelManager.RemoteModelManagerRegistration.class).add(Dependency.requiredProvider((Class<?>) zzg.class)).factory(zzh.zza).build());
    }
}
