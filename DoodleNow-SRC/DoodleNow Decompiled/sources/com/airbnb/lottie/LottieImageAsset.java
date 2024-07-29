package com.airbnb.lottie;

import android.graphics.Bitmap;

public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public LottieImageAsset(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.dirName = str3;
    }

    public LottieImageAsset copyWithScale(float f) {
        LottieImageAsset lottieImageAsset = new LottieImageAsset((int) (((float) this.width) * f), (int) (((float) this.height) * f), this.id, this.fileName, this.dirName);
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            lottieImageAsset.setBitmap(Bitmap.createScaledBitmap(bitmap2, lottieImageAsset.width, lottieImageAsset.height, true));
        }
        return lottieImageAsset;
    }

    public boolean hasBitmap() {
        return this.bitmap != null || (this.fileName.startsWith("data:") && this.fileName.indexOf("base64,") > 0);
    }
}
