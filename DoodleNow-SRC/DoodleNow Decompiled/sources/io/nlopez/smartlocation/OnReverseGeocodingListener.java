package io.nlopez.smartlocation;

import android.location.Address;
import android.location.Location;
import java.util.List;

public interface OnReverseGeocodingListener {
    void onAddressResolved(Location location, List<Address> list);
}
