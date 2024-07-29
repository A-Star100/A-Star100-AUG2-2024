package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzaa;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;
import com.google.android.gms.internal.maps.zzai;
import com.google.android.gms.internal.maps.zzaj;
import com.google.android.gms.internal.maps.zzal;
import com.google.android.gms.internal.maps.zzam;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzk;
import com.google.android.gms.internal.maps.zzl;
import com.google.android.gms.internal.maps.zzn;
import com.google.android.gms.internal.maps.zzo;
import com.google.android.gms.internal.maps.zzq;
import com.google.android.gms.internal.maps.zzr;
import com.google.android.gms.internal.maps.zzt;
import com.google.android.gms.internal.maps.zzu;
import com.google.android.gms.internal.maps.zzz;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.zzd;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzg extends zza implements IGoogleMapDelegate {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    public final zzl addCircle(CircleOptions circleOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, circleOptions);
        Parcel zzJ = zzJ(35, zza);
        zzl zzb = zzk.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final zzr addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, groundOverlayOptions);
        Parcel zzJ = zzJ(12, zza);
        zzr zzb = zzq.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final zzad addMarker(MarkerOptions markerOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, markerOptions);
        Parcel zzJ = zzJ(11, zza);
        zzad zzb = zzac.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final void addOnMapCapabilitiesChangedListener(zzal zzal) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzal);
        zzc(110, zza);
    }

    public final zzag addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, polygonOptions);
        Parcel zzJ = zzJ(10, zza);
        zzag zzb = zzaf.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final zzaj addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, polylineOptions);
        Parcel zzJ = zzJ(9, zza);
        zzaj zzb = zzai.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final zzam addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, tileOverlayOptions);
        Parcel zzJ = zzJ(13, zza);
        zzam zzb = zzal.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final void animateCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(5, zza);
    }

    public final void animateCameraWithCallback(IObjectWrapper iObjectWrapper, zzd zzd) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc.zze(zza, zzd);
        zzc(6, zza);
    }

    public final void animateCameraWithDurationAndCallback(IObjectWrapper iObjectWrapper, int i, zzd zzd) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zza.writeInt(i);
        zzc.zze(zza, zzd);
        zzc(7, zza);
    }

    public final void clear() throws RemoteException {
        zzc(14, zza());
    }

    public final CameraPosition getCameraPosition() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        CameraPosition cameraPosition = (CameraPosition) zzc.zza(zzJ, CameraPosition.CREATOR);
        zzJ.recycle();
        return cameraPosition;
    }

    public final zzo getFeatureLayer(zzd zzd) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzd);
        Parcel zzJ = zzJ(112, zza);
        zzo zzb = zzn.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final zzu getFocusedBuilding() throws RemoteException {
        Parcel zzJ = zzJ(44, zza());
        zzu zzb = zzt.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final void getMapAsync(zzat zzat) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzat);
        zzc(53, zza);
    }

    public final zzaa getMapCapabilities() throws RemoteException {
        Parcel zzJ = zzJ(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, zza());
        zzaa zzb = zzz.zzb(zzJ.readStrongBinder());
        zzJ.recycle();
        return zzb;
    }

    public final int getMapType() throws RemoteException {
        Parcel zzJ = zzJ(15, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final float getMaxZoomLevel() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final float getMinZoomLevel() throws RemoteException {
        Parcel zzJ = zzJ(3, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final Location getMyLocation() throws RemoteException {
        Parcel zzJ = zzJ(23, zza());
        Location location = (Location) zzc.zza(zzJ, Location.CREATOR);
        zzJ.recycle();
        return location;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.internal.IProjectionDelegate getProjection() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 26
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzJ(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.maps.internal.IProjectionDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.maps.internal.IProjectionDelegate
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.maps.internal.IProjectionDelegate r1 = (com.google.android.gms.maps.internal.IProjectionDelegate) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.maps.internal.zzbu r2 = new com.google.android.gms.maps.internal.zzbu
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzg.getProjection():com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.maps.internal.IUiSettingsDelegate getUiSettings() throws android.os.RemoteException {
        /*
            r4 = this;
            r0 = 25
            android.os.Parcel r1 = r4.zza()
            android.os.Parcel r0 = r4.zzJ(r0, r1)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.maps.internal.IUiSettingsDelegate"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.maps.internal.IUiSettingsDelegate
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.maps.internal.IUiSettingsDelegate r1 = (com.google.android.gms.maps.internal.IUiSettingsDelegate) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.maps.internal.zzca r2 = new com.google.android.gms.maps.internal.zzca
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.zzg.getUiSettings():com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    public final boolean isBuildingsEnabled() throws RemoteException {
        Parcel zzJ = zzJ(40, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isIndoorEnabled() throws RemoteException {
        Parcel zzJ = zzJ(19, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isMyLocationEnabled() throws RemoteException {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean isTrafficEnabled() throws RemoteException {
        Parcel zzJ = zzJ(17, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final void moveCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(4, zza);
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc(54, zza);
    }

    public final void onDestroy() throws RemoteException {
        zzc(57, zza());
    }

    public final void onEnterAmbient(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        zzc(81, zza);
    }

    public final void onExitAmbient() throws RemoteException {
        zzc(82, zza());
    }

    public final void onLowMemory() throws RemoteException {
        zzc(58, zza());
    }

    public final void onPause() throws RemoteException {
        zzc(56, zza());
    }

    public final void onResume() throws RemoteException {
        zzc(55, zza());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, bundle);
        Parcel zzJ = zzJ(60, zza);
        if (zzJ.readInt() != 0) {
            bundle.readFromParcel(zzJ);
        }
        zzJ.recycle();
    }

    public final void onStart() throws RemoteException {
        zzc(101, zza());
    }

    public final void onStop() throws RemoteException {
        zzc(102, zza());
    }

    public final void removeOnMapCapabilitiesChangedListener(zzal zzal) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzal);
        zzc(111, zza);
    }

    public final void resetMinMaxZoomPreference() throws RemoteException {
        zzc(94, zza());
    }

    public final void setBuildingsEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(41, zza);
    }

    public final void setContentDescription(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(61, zza);
    }

    public final boolean setIndoorEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        Parcel zzJ = zzJ(20, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final void setInfoWindowAdapter(zzi zzi) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzi);
        zzc(33, zza);
    }

    public final void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLngBounds);
        zzc(95, zza);
    }

    public final void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iLocationSourceDelegate);
        zzc(24, zza);
    }

    public final boolean setMapStyle(MapStyleOptions mapStyleOptions) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, mapStyleOptions);
        Parcel zzJ = zzJ(91, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final void setMapType(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(16, zza);
    }

    public final void setMaxZoomPreference(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(93, zza);
    }

    public final void setMinZoomPreference(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(92, zza);
    }

    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(22, zza);
    }

    public final void setOnCameraChangeListener(zzn zzn) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzn);
        zzc(27, zza);
    }

    public final void setOnCameraIdleListener(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzp);
        zzc(99, zza);
    }

    public final void setOnCameraMoveCanceledListener(zzr zzr) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzr);
        zzc(98, zza);
    }

    public final void setOnCameraMoveListener(zzt zzt) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzt);
        zzc(97, zza);
    }

    public final void setOnCameraMoveStartedListener(zzv zzv) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzv);
        zzc(96, zza);
    }

    public final void setOnCircleClickListener(zzx zzx) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzx);
        zzc(89, zza);
    }

    public final void setOnGroundOverlayClickListener(zzz zzz) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzz);
        zzc(83, zza);
    }

    public final void setOnIndoorStateChangeListener(zzab zzab) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzab);
        zzc(45, zza);
    }

    public final void setOnInfoWindowClickListener(zzad zzad) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzad);
        zzc(32, zza);
    }

    public final void setOnInfoWindowCloseListener(zzaf zzaf) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaf);
        zzc(86, zza);
    }

    public final void setOnInfoWindowLongClickListener(zzah zzah) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzah);
        zzc(84, zza);
    }

    public final void setOnMapClickListener(zzan zzan) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzan);
        zzc(28, zza);
    }

    public final void setOnMapLoadedCallback(zzap zzap) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzap);
        zzc(42, zza);
    }

    public final void setOnMapLongClickListener(zzar zzar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzar);
        zzc(29, zza);
    }

    public final void setOnMarkerClickListener(zzav zzav) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzav);
        zzc(30, zza);
    }

    public final void setOnMarkerDragListener(zzax zzax) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzax);
        zzc(31, zza);
    }

    public final void setOnMyLocationButtonClickListener(zzaz zzaz) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzaz);
        zzc(37, zza);
    }

    public final void setOnMyLocationChangeListener(zzbb zzbb) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbb);
        zzc(36, zza);
    }

    public final void setOnMyLocationClickListener(zzbd zzbd) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbd);
        zzc(107, zza);
    }

    public final void setOnPoiClickListener(zzbf zzbf) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbf);
        zzc(80, zza);
    }

    public final void setOnPolygonClickListener(zzbh zzbh) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbh);
        zzc(85, zza);
    }

    public final void setOnPolylineClickListener(zzbj zzbj) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbj);
        zzc(87, zza);
    }

    public final void setPadding(int i, int i2, int i3, int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        zza.writeInt(i4);
        zzc(39, zza);
    }

    public final void setTrafficEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(18, zza);
    }

    public final void setWatermarkEnabled(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(51, zza);
    }

    public final void snapshot(zzbw zzbw, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbw);
        zzc.zze(zza, iObjectWrapper);
        zzc(38, zza);
    }

    public final void snapshotForTest(zzbw zzbw) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzbw);
        zzc(71, zza);
    }

    public final void stopAnimation() throws RemoteException {
        zzc(8, zza());
    }

    public final boolean useViewLifecycleWhenInFragment() throws RemoteException {
        Parcel zzJ = zzJ(59, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
