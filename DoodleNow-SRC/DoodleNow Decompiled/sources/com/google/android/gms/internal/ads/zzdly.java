package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdly {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final zzg zzb;
    private final zzfgi zzc;
    private final zzdld zzd;
    private final zzdky zze;
    private final zzdmk zzf;
    private final zzdms zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbgt zzj;
    private final zzdkv zzk;

    public zzdly(zzg zzg2, zzfgi zzfgi, zzdld zzdld, zzdky zzdky, zzdmk zzdmk, zzdms zzdms, Executor executor, Executor executor2, zzdkv zzdkv) {
        this.zzb = zzg2;
        this.zzc = zzfgi;
        this.zzj = zzfgi.zzi;
        this.zzd = zzdld;
        this.zze = zzdky;
        this.zzf = zzdmk;
        this.zzg = zzdms;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdkv;
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View view;
        FrameLayout.LayoutParams layoutParams;
        if (z) {
            view = this.zze.zzf();
        } else {
            view = this.zze.zzg();
        }
        if (view == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdL)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(view, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        zzdky zzdky = this.zze;
        if (zzdky.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzdky.zzc() == 2 || zzdky.zzc() == 1) {
                this.zzb.zzH(this.zzc.zzf, String.valueOf(zzdky.zzc()), z);
            } else if (zzdky.zzc() == 6) {
                this.zzb.zzH(this.zzc.zzf, ExifInterface.GPS_MEASUREMENT_2D, z);
                this.zzb.zzH(this.zzc.zzf, "1", z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzdmu zzdmu) {
        ViewGroup viewGroup;
        View view;
        ViewGroup viewGroup2;
        zzbhb zza2;
        Drawable drawable;
        Context context = null;
        if (this.zzd.zzf() || this.zzd.zze()) {
            String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                View zzg2 = zzdmu.zzg(strArr[i]);
                if (zzg2 != null && (zzg2 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) zzg2;
                    break;
                }
                i++;
            }
        }
        viewGroup = null;
        Context context2 = zzdmu.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdky zzdky = this.zze;
        if (zzdky.zze() != null) {
            zzbgt zzbgt = this.zzj;
            view = zzdky.zze();
            if (zzbgt != null && viewGroup == null) {
                zzh(layoutParams, zzbgt.zze);
                view.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (!(zzdky.zzl() instanceof zzbgo)) {
            view = null;
        } else {
            zzbgo zzbgo = (zzbgo) zzdky.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbgo.zzc());
                viewGroup = null;
            }
            zzbgp zzbgp = new zzbgp(context2, zzbgo, layoutParams);
            zzbgp.setContentDescription((CharSequence) zzba.zzc().zza(zzbdz.zzdJ));
            view = zzbgp;
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            } else {
                zza zza3 = new zza(zzdmu.zzf().getContext());
                zza3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zza3.addView(view);
                FrameLayout zzh2 = zzdmu.zzh();
                if (zzh2 != null) {
                    zzh2.addView(zza3);
                }
            }
            zzdmu.zzq(zzdmu.zzk(), view, true);
        }
        zzfzn zzfzn = zzdlu.zza;
        int size = zzfzn.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View zzg3 = zzdmu.zzg((String) zzfzn.get(i2));
            i2++;
            if (zzg3 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) zzg3;
                break;
            }
        }
        this.zzi.execute(new zzdlv(this, viewGroup2));
        if (viewGroup2 != null) {
            if (zzi(viewGroup2, true)) {
                zzdky zzdky2 = this.zze;
                if (zzdky2.zzs() != null) {
                    zzdky2.zzs().zzap(new zzdlx(zzdmu, viewGroup2));
                    return;
                }
                return;
            }
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzjQ)).booleanValue() || !zzi(viewGroup2, false)) {
                viewGroup2.removeAllViews();
                View zzf2 = zzdmu.zzf();
                if (zzf2 != null) {
                    context = zzf2.getContext();
                }
                if (context != null && (zza2 = this.zzk.zza()) != null) {
                    try {
                        IObjectWrapper zzi2 = zza2.zzi();
                        if (zzi2 != null && (drawable = (Drawable) ObjectWrapper.unwrap(zzi2)) != null) {
                            ImageView imageView = new ImageView(context);
                            imageView.setImageDrawable(drawable);
                            IObjectWrapper zzj2 = zzdmu.zzj();
                            if (zzj2 != null) {
                                if (((Boolean) zzba.zzc().zza(zzbdz.zzgl)).booleanValue()) {
                                    imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(zzj2));
                                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                    viewGroup2.addView(imageView);
                                }
                            }
                            imageView.setScaleType(zza);
                            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                            viewGroup2.addView(imageView);
                        }
                    } catch (RemoteException unused) {
                        zzm.zzj("Could not get main image drawable");
                    }
                }
            } else {
                zzdky zzdky3 = this.zze;
                if (zzdky3.zzq() != null) {
                    zzdky3.zzq().zzap(new zzdlx(zzdmu, viewGroup2));
                }
            }
        }
    }

    public final void zzc(zzdmu zzdmu) {
        if (zzdmu != null && this.zzf != null && zzdmu.zzh() != null && this.zzd.zzg()) {
            try {
                zzdmu.zzh().addView(this.zzf.zza());
            } catch (zzcgy e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzdmu zzdmu) {
        if (zzdmu != null) {
            Context context = zzdmu.zzf().getContext();
            if (!zzbz.zzh(context, this.zzd.zza)) {
                return;
            }
            if (!(context instanceof Activity)) {
                zzm.zze("Activity context is needed for policy validator.");
            } else if (this.zzg != null && zzdmu.zzh() != null) {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    windowManager.addView(this.zzg.zza(zzdmu.zzh(), windowManager), zzbz.zzb());
                } catch (zzcgy e) {
                    zze.zzb("web view can not be obtained", e);
                }
            }
        }
    }

    public final void zze(zzdmu zzdmu) {
        this.zzh.execute(new zzdlw(this, zzdmu));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
