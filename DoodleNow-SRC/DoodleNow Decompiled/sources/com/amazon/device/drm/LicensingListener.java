package com.amazon.device.drm;

import com.amazon.device.drm.model.LicenseResponse;

public interface LicensingListener {
    void onLicenseCommandResponse(LicenseResponse licenseResponse);
}
