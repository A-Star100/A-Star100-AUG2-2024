package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.9.0 */
final class zzgo implements ObjectEncoder {
    static final zzgo zza = new zzgo();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("modelInfo");
        zzbk zzbk = new zzbk();
        zzbk.zza(1);
        zzb = builder.withProperty(zzbk.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("initialDownloadConditions");
        zzbk zzbk2 = new zzbk();
        zzbk2.zza(2);
        zzc = builder2.withProperty(zzbk2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("updateDownloadConditions");
        zzbk zzbk3 = new zzbk();
        zzbk3.zza(3);
        zzd = builder3.withProperty(zzbk3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("isModelUpdateEnabled");
        zzbk zzbk4 = new zzbk();
        zzbk4.zza(4);
        zze = builder4.withProperty(zzbk4.zzb()).build();
    }

    private zzgo() {
    }

    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, (Object) ((zzmd) obj).zza());
        objectEncoderContext.add(zzc, (Object) null);
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, (Object) null);
    }
}
