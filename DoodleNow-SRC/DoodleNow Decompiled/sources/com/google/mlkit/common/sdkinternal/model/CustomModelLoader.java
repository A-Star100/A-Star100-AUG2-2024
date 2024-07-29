package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzpz;
import com.google.android.gms.internal.mlkit_common.zzqk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.internal.model.zza;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.Constants;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public class CustomModelLoader {
    private static final GmsLogger zza = new GmsLogger("CustomModelLoader", "");
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;
    private final LocalModel zzd;
    private final CustomRemoteModel zze;
    private final RemoteModelDownloadManager zzf;
    private final RemoteModelFileManager zzg;
    private final zzpz zzh;
    private boolean zzi;

    /* compiled from: com.google.mlkit:common@@18.9.0 */
    public interface CustomModelLoaderHelper {
        void logLoad() throws MlKitException;

        boolean tryLoad(LocalModel localModel) throws MlKitException;
    }

    private CustomModelLoader(MlKitContext mlKitContext, LocalModel localModel, CustomRemoteModel customRemoteModel) {
        if (customRemoteModel != null) {
            RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, customRemoteModel, (ModelValidator) null, new ModelFileHelper(mlKitContext), new zza(mlKitContext, customRemoteModel.getUniqueModelNameForPersist()));
            this.zzg = remoteModelFileManager;
            this.zzf = RemoteModelDownloadManager.getInstance(mlKitContext, customRemoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
            this.zzi = true;
        } else {
            this.zzg = null;
            this.zzf = null;
        }
        this.zzc = mlKitContext;
        this.zzd = localModel;
        this.zze = customRemoteModel;
        this.zzh = zzqk.zzb("common");
    }

    public static synchronized CustomModelLoader getInstance(MlKitContext mlKitContext, LocalModel localModel, CustomRemoteModel customRemoteModel) {
        String str;
        CustomModelLoader customModelLoader;
        synchronized (CustomModelLoader.class) {
            if (customRemoteModel == null) {
                str = ((LocalModel) Preconditions.checkNotNull(localModel)).toString();
            } else {
                str = customRemoteModel.getUniqueModelNameForPersist();
            }
            Map map = zzb;
            if (!map.containsKey(str)) {
                map.put(str, new CustomModelLoader(mlKitContext, localModel, customRemoteModel));
            }
            customModelLoader = (CustomModelLoader) map.get(str);
        }
        return customModelLoader;
    }

    private final File zza() throws MlKitException {
        String zzb2 = ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzb();
        if (zzb2 == null) {
            zza.d("CustomModelLoader", "No existing model file");
            return null;
        }
        File file = new File(zzb2);
        File[] listFiles = file.listFiles();
        return ((File[]) Preconditions.checkNotNull(listFiles)).length == 1 ? listFiles[0] : file;
    }

    private final void zzb() throws MlKitException {
        ((RemoteModelDownloadManager) Preconditions.checkNotNull(this.zzf)).removeOrCancelDownload();
    }

    private static final LocalModel zzc(File file) {
        if (file.isDirectory()) {
            LocalModel.Builder builder = new LocalModel.Builder();
            builder.setAbsoluteManifestFilePath(new File(file.getAbsolutePath(), Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME).toString());
            return builder.build();
        }
        LocalModel.Builder builder2 = new LocalModel.Builder();
        builder2.setAbsoluteFilePath(file.getAbsolutePath());
        return builder2.build();
    }

    public synchronized LocalModel createLocalModelByLatestExistingModel() throws MlKitException {
        zza.d("CustomModelLoader", "Try to get the latest existing model file.");
        File zza2 = zza();
        if (zza2 == null) {
            return null;
        }
        return zzc(zza2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009b A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009d A[SYNTHETIC, Splitter:B:23:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.mlkit.common.model.LocalModel createLocalModelByNewlyDownloadedModel() throws com.google.mlkit.common.MlKitException {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.common.internal.GmsLogger r0 = zza     // Catch:{ all -> 0x00a3 }
            java.lang.String r1 = "CustomModelLoader"
            java.lang.String r2 = "Try to get newly downloaded model file."
            r0.d(r1, r2)     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r7.zzf     // Catch:{ all -> 0x00a3 }
            java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = (com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager) r1     // Catch:{ all -> 0x00a3 }
            java.lang.Long r1 = r1.getDownloadingId()     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r2 = r7.zzf     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = r2.getDownloadingModelHash()     // Catch:{ all -> 0x00a3 }
            r3 = 0
            if (r1 == 0) goto L_0x008e
            if (r2 != 0) goto L_0x0022
            goto L_0x008e
        L_0x0022:
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r4 = r7.zzf     // Catch:{ all -> 0x00a3 }
            java.lang.Integer r4 = r4.getDownloadingModelStatusCode()     // Catch:{ all -> 0x00a3 }
            if (r4 != 0) goto L_0x002e
            r7.zzb()     // Catch:{ all -> 0x00a3 }
            goto L_0x0098
        L_0x002e:
            java.lang.String r5 = "Download Status code: "
            java.util.Objects.toString(r4)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x00a3 }
            java.lang.String r5 = r5.concat(r6)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = "CustomModelLoader"
            r0.d(r6, r5)     // Catch:{ all -> 0x00a3 }
            int r5 = r4.intValue()     // Catch:{ all -> 0x00a3 }
            r6 = 8
            if (r5 != r6) goto L_0x006a
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r1 = r7.zzf     // Catch:{ all -> 0x00a3 }
            java.io.File r1 = r1.zzi(r2)     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0051
            goto L_0x0098
        L_0x0051:
            java.lang.String r4 = r1.getParent()     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00a3 }
            java.lang.String r5 = "Moved the downloaded model to private folder successfully: "
            java.lang.String r6 = "CustomModelLoader"
            java.lang.String r4 = r5.concat(r4)     // Catch:{ all -> 0x00a3 }
            r0.d(r6, r4)     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r0 = r7.zzf     // Catch:{ all -> 0x00a3 }
            r0.updateLatestModelHashAndType(r2)     // Catch:{ all -> 0x00a3 }
            goto L_0x0099
        L_0x006a:
            int r0 = r4.intValue()     // Catch:{ all -> 0x00a3 }
            r2 = 16
            if (r0 != r2) goto L_0x0098
            com.google.android.gms.internal.mlkit_common.zzpz r0 = r7.zzh     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.mlkit_common.zzpq r2 = com.google.android.gms.internal.mlkit_common.zzqc.zzg()     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.model.CustomRemoteModel r4 = r7.zze     // Catch:{ all -> 0x00a3 }
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.model.RemoteModel r4 = (com.google.mlkit.common.model.RemoteModel) r4     // Catch:{ all -> 0x00a3 }
            com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager r5 = r7.zzf     // Catch:{ all -> 0x00a3 }
            int r1 = r5.getFailureReason(r1)     // Catch:{ all -> 0x00a3 }
            r5 = 0
            r0.zze(r2, r4, r5, r1)     // Catch:{ all -> 0x00a3 }
            r7.zzb()     // Catch:{ all -> 0x00a3 }
            goto L_0x0098
        L_0x008e:
            java.lang.String r1 = "CustomModelLoader"
            java.lang.String r2 = "No new model is downloading."
            r0.d(r1, r2)     // Catch:{ all -> 0x00a3 }
            r7.zzb()     // Catch:{ all -> 0x00a3 }
        L_0x0098:
            r1 = r3
        L_0x0099:
            if (r1 != 0) goto L_0x009d
            monitor-exit(r7)
            return r3
        L_0x009d:
            com.google.mlkit.common.model.LocalModel r0 = zzc(r1)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r7)
            return r0
        L_0x00a3:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.CustomModelLoader.createLocalModelByNewlyDownloadedModel():com.google.mlkit.common.model.LocalModel");
    }

    public void deleteLatestExistingModel() throws MlKitException {
        File zza2 = zza();
        if (zza2 != null) {
            ((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzc(zza2);
            SharedPrefManager.getInstance(this.zzc).clearLatestModelHash((RemoteModel) Preconditions.checkNotNull(this.zze));
        }
    }

    public void deleteOldModels(LocalModel localModel) throws MlKitException {
        File parentFile = new File((String) Preconditions.checkNotNull(localModel.getAbsoluteFilePath())).getParentFile();
        if (((RemoteModelFileManager) Preconditions.checkNotNull(this.zzg)).zzd((File) Preconditions.checkNotNull(parentFile))) {
            zza.d("CustomModelLoader", "All old models are deleted.");
            this.zzg.zza(parentFile);
            return;
        }
        zza.e("CustomModelLoader", "Failed to delete old models");
    }

    public synchronized void load(CustomModelLoaderHelper customModelLoaderHelper) throws MlKitException {
        LocalModel localModel;
        LocalModel localModel2 = this.zzd;
        if (localModel2 == null) {
            localModel2 = createLocalModelByNewlyDownloadedModel();
        }
        if (localModel2 == null) {
            localModel2 = createLocalModelByLatestExistingModel();
        }
        if (localModel != null) {
            while (!customModelLoaderHelper.tryLoad(localModel)) {
                if (this.zze != null) {
                    deleteLatestExistingModel();
                    localModel = createLocalModelByLatestExistingModel();
                    continue;
                } else {
                    localModel = null;
                    continue;
                }
                if (localModel == null) {
                    customModelLoaderHelper.logLoad();
                    return;
                }
            }
            if (this.zze != null && this.zzi) {
                deleteOldModels((LocalModel) Preconditions.checkNotNull(localModel));
                this.zzi = false;
            }
            customModelLoaderHelper.logLoad();
            return;
        }
        throw new MlKitException("Model is not available.", 14);
    }
}
