package io.nlopez.smartlocation.geofencing.utils;

import io.nlopez.smartlocation.geofencing.model.GeofenceModel;

public class TransitionGeofence {
    private GeofenceModel geofenceModel;
    private int transitionType;

    public GeofenceModel getGeofenceModel() {
        return this.geofenceModel;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public TransitionGeofence(GeofenceModel geofenceModel2, int i) {
        this.geofenceModel = geofenceModel2;
        this.transitionType = i;
    }
}
