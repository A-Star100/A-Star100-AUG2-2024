package com.airbnb.lottie.network;

public enum FileExtension {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");
    
    public final String extension;

    public String toString() {
        return this.extension;
    }

    private FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }
}
