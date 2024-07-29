package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzcc {
    private static final String zza = "zzcc";
    private static Context zzb;
    private static zzf zzc;

    public static zzf zza(Context context, MapsInitializer.Renderer renderer) throws GooglePlayServicesNotAvailableException {
        Preconditions.checkNotNull(context);
        Log.d(zza, "preferredRenderer: ".concat(String.valueOf(String.valueOf(renderer))));
        zzf zzf = zzc;
        if (zzf != null) {
            return zzf;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
        if (isGooglePlayServicesAvailable == 0) {
            zzf zzd = zzd(context, renderer);
            zzc = zzd;
            try {
                if (zzd.zzd() == 2) {
                    try {
                        zzc.zzm(ObjectWrapper.wrap(zzc(context, renderer)));
                    } catch (UnsatisfiedLinkError unused) {
                        Log.w(zza, "Caught UnsatisfiedLinkError attempting to load the LATEST renderer's native library. Attempting to use the LEGACY renderer instead.");
                        zzb = null;
                        zzc = zzd(context, MapsInitializer.Renderer.LEGACY);
                    } catch (RemoteException e) {
                        throw new RuntimeRemoteException(e);
                    }
                }
                try {
                    zzf zzf2 = zzc;
                    Context zzc2 = zzc(context, renderer);
                    zzc2.getClass();
                    zzf2.zzk(ObjectWrapper.wrap(zzc2.getResources()), 18020000);
                    return zzc;
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            } catch (RemoteException e3) {
                throw new RuntimeRemoteException(e3);
            }
        } else {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static Context zzb(Exception exc, Context context) {
        Log.e(zza, "Failed to load maps module, use pre-Chimera", exc);
        return GooglePlayServicesUtil.getRemoteContext(context);
    }

    private static Context zzc(Context context, MapsInitializer.Renderer renderer) {
        Context context2;
        Context context3 = zzb;
        if (context3 != null) {
            return context3;
        }
        String str = renderer == MapsInitializer.Renderer.LEGACY ? "com.google.android.gms.maps_legacy_dynamite" : "com.google.android.gms.maps_core_dynamite";
        try {
            context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str).getModuleContext();
        } catch (Exception e) {
            if (!str.equals("com.google.android.gms.maps_dynamite")) {
                try {
                    Log.d(zza, "Attempting to load maps_dynamite again.");
                    context2 = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.maps_dynamite").getModuleContext();
                } catch (Exception e2) {
                    context2 = zzb(e2, context);
                }
            } else {
                context2 = zzb(e, context);
            }
        }
        zzb = context2;
        return context2;
    }

    private static zzf zzd(Context context, MapsInitializer.Renderer renderer) {
        Log.i(zza, "Making Creator dynamically");
        try {
            IBinder iBinder = (IBinder) zze(((ClassLoader) Preconditions.checkNotNull(zzc(context, renderer).getClassLoader())).loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            if (queryLocalInterface instanceof zzf) {
                return (zzf) queryLocalInterface;
            }
            return new zze(iBinder);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class com.google.android.gms.maps.internal.CreatorImpl", e);
        }
    }

    private static Object zze(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class ".concat(String.valueOf(cls.getName())), e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of ".concat(String.valueOf(cls.getName())), e2);
        }
    }
}
