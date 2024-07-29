package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;
import com.google.gson.internal.GsonBuildConfig;

public final class PackageVersion implements Versioned {
    public static final Version VERSION = VersionUtil.parseVersion(GsonBuildConfig.VERSION, "com.fasterxml.jackson.core", "jackson-core");

    public Version version() {
        return VERSION;
    }
}
