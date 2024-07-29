package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.revenuecat.purchases.common.Constants;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhw extends zzgp {
    private final Context zza;
    private zzhb zzb;
    private AssetFileDescriptor zzc;
    private InputStream zzd;
    private long zze;
    private boolean zzf;

    public zzhw(Context context) {
        super(false);
        this.zza = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    private static int zzk(String str) throws zzhv {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new zzhv("Resource identifier must be an integer.", (Throwable) null, 1004);
        }
    }

    private static AssetFileDescriptor zzl(Context context, zzhb zzhb) throws zzhv {
        Resources resources;
        int i;
        String str;
        Uri normalizeScheme = zzhb.zza.normalizeScheme();
        if (TextUtils.equals(RawResourceDataSource.RAW_RESOURCE_SCHEME, normalizeScheme.getScheme())) {
            resources = context.getResources();
            List<String> pathSegments = normalizeScheme.getPathSegments();
            if (pathSegments.size() == 1) {
                i = zzk(pathSegments.get(0));
            } else {
                int size = pathSegments.size();
                throw new zzhv("rawresource:// URI must have exactly one path element, found " + size);
            }
        } else if (TextUtils.equals(UriUtil.QUALIFIED_RESOURCE_SCHEME, normalizeScheme.getScheme())) {
            String path = normalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            if (TextUtils.isEmpty(normalizeScheme.getHost())) {
                str = context.getPackageName();
            } else {
                str = normalizeScheme.getHost();
            }
            if (str.equals(context.getPackageName())) {
                resources = context.getResources();
            } else {
                try {
                    resources = context.getPackageManager().getResourcesForApplication(str);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new zzhv("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
                }
            }
            if (path.matches("\\d+")) {
                i = zzk(path);
            } else {
                i = resources.getIdentifier(str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + path, "raw", (String) null);
                if (i == 0) {
                    throw new zzhv("Resource not found.", (Throwable) null, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
                }
            }
        } else {
            String scheme = normalizeScheme.getScheme();
            throw new zzhv("Unsupported URI scheme (" + scheme + "). Only android.resource is supported.", (Throwable) null, 1004);
        }
        try {
            AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(i);
            if (openRawResourceFd != null) {
                return openRawResourceFd;
            }
            throw new zzhv("Resource is compressed: ".concat(String.valueOf(String.valueOf(normalizeScheme))), (Throwable) null, 2000);
        } catch (Resources.NotFoundException e2) {
            throw new zzhv((String) null, e2, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzhv {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzhv((String) null, e, 2000);
            }
        }
        InputStream inputStream = this.zzd;
        int i3 = zzfx.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.zze;
            if (j2 != -1) {
                this.zze = j2 - ((long) read);
            }
            zzg(read);
            return read;
        } else if (this.zze == -1) {
            return -1;
        } else {
            throw new zzhv("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }

    public final long zzb(zzhb zzhb) throws zzhv {
        long j;
        this.zzb = zzhb;
        zzi(zzhb);
        AssetFileDescriptor zzl = zzl(this.zza, zzhb);
        this.zzc = zzl;
        long length = zzl.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.zzc.getFileDescriptor());
        this.zzd = fileInputStream;
        int i = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i != 0) {
            try {
                if (zzhb.zze > length) {
                    throw new zzhv((String) null, (Throwable) null, 2008);
                }
            } catch (zzhv e) {
                throw e;
            } catch (IOException e2) {
                throw new zzhv((String) null, e2, 2000);
            }
        }
        long startOffset = this.zzc.getStartOffset();
        long skip = fileInputStream.skip(zzhb.zze + startOffset) - startOffset;
        if (skip == zzhb.zze) {
            if (i == 0) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.zze = -1;
                    j = -1;
                } else {
                    j = channel.size() - channel.position();
                    this.zze = j;
                    if (j < 0) {
                        throw new zzhv((String) null, (Throwable) null, 2008);
                    }
                }
            } else {
                j = length - skip;
                this.zze = j;
                if (j < 0) {
                    throw new zzgw(2008);
                }
            }
            long j2 = zzhb.zzf;
            if (j2 != -1) {
                if (j != -1) {
                    j2 = Math.min(j, j2);
                }
                this.zze = j2;
            }
            this.zzf = true;
            zzj(zzhb);
            long j3 = zzhb.zzf;
            return j3 != -1 ? j3 : this.zze;
        }
        throw new zzhv((String) null, (Throwable) null, 2008);
    }

    public final Uri zzc() {
        zzhb zzhb = this.zzb;
        if (zzhb != null) {
            return zzhb.zza;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        throw new com.google.android.gms.internal.ads.zzhv((java.lang.String) null, r3, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004f, code lost:
        throw new com.google.android.gms.internal.ads.zzhv((java.lang.String) null, r3, 2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0050, code lost:
        r5.zzc = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0054, code lost:
        if (r5.zzf != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r5.zzf = false;
        zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x000f, B:15:0x0025, B:24:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() throws com.google.android.gms.internal.ads.zzhv {
        /*
            r5 = this;
            r0 = 0
            r5.zzb = r0
            r1 = 0
            r2 = 2000(0x7d0, float:2.803E-42)
            java.io.InputStream r3 = r5.zzd     // Catch:{ IOException -> 0x002d }
            if (r3 == 0) goto L_0x000d
            r3.close()     // Catch:{ IOException -> 0x002d }
        L_0x000d:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r3 = r5.zzc     // Catch:{ IOException -> 0x0024 }
            if (r3 == 0) goto L_0x0016
            r3.close()     // Catch:{ IOException -> 0x0024 }
        L_0x0016:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0021
            r5.zzf = r1
            r5.zzh()
        L_0x0021:
            return
        L_0x0022:
            r2 = move-exception
            goto L_0x0050
        L_0x0024:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzhv r4 = new com.google.android.gms.internal.ads.zzhv     // Catch:{ all -> 0x0022 }
            r4.<init>(r0, r3, r2)     // Catch:{ all -> 0x0022 }
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x002b:
            r3 = move-exception
            goto L_0x0034
        L_0x002d:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzhv r4 = new com.google.android.gms.internal.ads.zzhv     // Catch:{ all -> 0x002b }
            r4.<init>(r0, r3, r2)     // Catch:{ all -> 0x002b }
            throw r4     // Catch:{ all -> 0x002b }
        L_0x0034:
            r5.zzd = r0
            android.content.res.AssetFileDescriptor r4 = r5.zzc     // Catch:{ IOException -> 0x0049 }
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ IOException -> 0x0049 }
        L_0x003d:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x0048
            r5.zzf = r1
            r5.zzh()
        L_0x0048:
            throw r3
        L_0x0049:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzhv r4 = new com.google.android.gms.internal.ads.zzhv     // Catch:{ all -> 0x0022 }
            r4.<init>(r0, r3, r2)     // Catch:{ all -> 0x0022 }
            throw r4     // Catch:{ all -> 0x0022 }
        L_0x0050:
            r5.zzc = r0
            boolean r0 = r5.zzf
            if (r0 == 0) goto L_0x005b
            r5.zzf = r1
            r5.zzh()
        L_0x005b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhw.zzd():void");
    }
}
