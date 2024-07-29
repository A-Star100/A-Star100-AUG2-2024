package io.nlopez.smartlocation.location;

import io.nlopez.smartlocation.utils.ServiceConnectionListener;

public interface ServiceLocationProvider extends LocationProvider {
    ServiceConnectionListener getServiceListener();

    void setServiceListener(ServiceConnectionListener serviceConnectionListener);
}
