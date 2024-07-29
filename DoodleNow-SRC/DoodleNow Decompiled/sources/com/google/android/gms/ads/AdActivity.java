package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbup;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbup zza;

    private final void zza() {
        zzbup zzbup = this.zza;
        if (zzbup != null) {
            try {
                zzbup.zzx();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null && !zzbup.zzH()) {
                return;
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbup zzbup2 = this.zza;
            if (zzbup2 != null) {
                zzbup2.zzi();
            }
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzbup zzo = zzay.zza().zzo(this);
        this.zza = zzo;
        if (zzo != null) {
            try {
                zzo.zzl(bundle);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzm.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzm();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzo();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzq();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzr();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzt();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzu();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbup zzbup = this.zza;
            if (zzbup != null) {
                zzbup.zzv();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
