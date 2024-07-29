package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.maps.zzad;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public class AdvancedMarker extends Marker {
    public AdvancedMarker(zzad zzad) {
        super(zzad);
    }

    public View getIconView() {
        try {
            return (View) ObjectWrapper.unwrap(this.zza.zzh());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIconView(View view) {
        if (view == null || view.getParent() == null) {
            try {
                this.zza.zzu(ObjectWrapper.wrap(view));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            throw new IllegalArgumentException("View already has a parent, can not be used as Marker");
        }
    }
}
