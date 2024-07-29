package io.nlopez.smartlocation.utils;

public interface ServiceConnectionListener {
    void onConnected();

    void onConnectionFailed();

    void onConnectionSuspended();
}
