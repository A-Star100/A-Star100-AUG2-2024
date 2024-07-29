package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.camera.video.AudioStats;
import androidx.collection.LongSparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 22;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 512;
    static final double WORLD_WIDTH = 1.0d;
    private Bounds mBounds;
    private int[] mColorMap;
    private double mCustomMaxIntensity;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private PointQuadTree<WeightedLatLng> mTree;

    static {
        int[] iArr = {Color.rgb(102, JfifUtil.MARKER_APP1, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Collection<WeightedLatLng> data;
        /* access modifiers changed from: private */
        public Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        /* access modifiers changed from: private */
        public double intensity = AudioStats.AUDIO_AMPLITUDE_NONE;
        /* access modifiers changed from: private */
        public double opacity = 0.7d;
        /* access modifiers changed from: private */
        public int radius = 20;

        public Builder gradient(Gradient gradient2) {
            this.gradient = gradient2;
            return this;
        }

        public Builder maxIntensity(double d) {
            this.intensity = d;
            return this;
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.wrapData(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            if (!collection.isEmpty()) {
                return this;
            }
            throw new IllegalArgumentException("No input points.");
        }

        public Builder radius(int i) {
            this.radius = i;
            if (i >= 10 && i <= 50) {
                return this;
            }
            throw new IllegalArgumentException("Radius not within bounds.");
        }

        public Builder opacity(double d) {
            this.opacity = d;
            if (d >= AudioStats.AUDIO_AMPLITUDE_NONE && d <= 1.0d) {
                return this;
            }
            throw new IllegalArgumentException("Opacity must be in range [0, 1]");
        }

        public HeatmapTileProvider build() {
            if (this.data != null) {
                return new HeatmapTileProvider(this);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        this.mGradient = builder.gradient;
        this.mOpacity = builder.opacity;
        this.mCustomMaxIntensity = builder.intensity;
        int i = this.mRadius;
        this.mKernel = generateKernel(i, ((double) i) / 3.0d);
        setGradient(this.mGradient);
        setWeightedData(this.mData);
    }

    public void setWeightedData(Collection<WeightedLatLng> collection) {
        this.mData = collection;
        if (!collection.isEmpty()) {
            Bounds bounds = getBounds(this.mData);
            this.mBounds = bounds;
            this.mTree = new PointQuadTree<>(bounds);
            for (WeightedLatLng add : this.mData) {
                this.mTree.add(add);
            }
            this.mMaxIntensity = getMaxIntensities(this.mRadius);
            return;
        }
        throw new IllegalArgumentException("No input points.");
    }

    public void setData(Collection<LatLng> collection) {
        setWeightedData(wrapData(collection));
    }

    /* access modifiers changed from: private */
    public static Collection<WeightedLatLng> wrapData(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.maps.model.Tile getTile(int r36, int r37, int r38) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            r3 = r38
            double r4 = (double) r3
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r6, r4)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r8 / r4
            int r10 = r0.mRadius
            double r11 = (double) r10
            double r11 = r11 * r4
            r13 = 4647714815446351872(0x4080000000000000, double:512.0)
            double r11 = r11 / r13
            double r6 = r6 * r11
            double r6 = r6 + r4
            int r10 = r10 * 2
            int r10 = r10 + 512
            double r13 = (double) r10
            double r6 = r6 / r13
            double r13 = (double) r1
            double r13 = r13 * r4
            double r13 = r13 - r11
            int r1 = r1 + 1
            double r8 = (double) r1
            double r8 = r8 * r4
            double r18 = r8 + r11
            double r8 = (double) r2
            double r8 = r8 * r4
            double r8 = r8 - r11
            int r1 = r2 + 1
            double r1 = (double) r1
            double r1 = r1 * r4
            double r1 = r1 + r11
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r20 = 0
            int r5 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r5 >= 0) goto L_0x005a
            com.google.maps.android.geometry.Bounds r4 = new com.google.maps.android.geometry.Bounds
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r21 = r13 + r15
            r23 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r20 = r4
            r25 = r8
            r27 = r1
            r20.<init>(r21, r23, r25, r27)
            com.google.maps.android.quadtree.PointQuadTree<com.google.maps.android.heatmaps.WeightedLatLng> r5 = r0.mTree
            java.util.Collection r4 = r5.search(r4)
            r15 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x0057:
            r24 = r15
            goto L_0x0078
        L_0x005a:
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r18 > r15 ? 1 : (r18 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x0076
            com.google.maps.android.geometry.Bounds r4 = new com.google.maps.android.geometry.Bounds
            r21 = 0
            double r23 = r18 - r15
            r20 = r4
            r25 = r8
            r27 = r1
            r20.<init>(r21, r23, r25, r27)
            com.google.maps.android.quadtree.PointQuadTree<com.google.maps.android.heatmaps.WeightedLatLng> r5 = r0.mTree
            java.util.Collection r4 = r5.search(r4)
            goto L_0x0057
        L_0x0076:
            r24 = r20
        L_0x0078:
            com.google.maps.android.geometry.Bounds r5 = new com.google.maps.android.geometry.Bounds
            r15 = r5
            r16 = r13
            r20 = r8
            r22 = r1
            r15.<init>(r16, r18, r20, r22)
            com.google.maps.android.geometry.Bounds r1 = new com.google.maps.android.geometry.Bounds
            com.google.maps.android.geometry.Bounds r2 = r0.mBounds
            double r2 = r2.minX
            double r27 = r2 - r11
            com.google.maps.android.geometry.Bounds r2 = r0.mBounds
            double r2 = r2.maxX
            double r29 = r2 + r11
            com.google.maps.android.geometry.Bounds r2 = r0.mBounds
            double r2 = r2.minY
            double r31 = r2 - r11
            com.google.maps.android.geometry.Bounds r2 = r0.mBounds
            double r2 = r2.maxY
            double r33 = r2 + r11
            r26 = r1
            r26.<init>(r27, r29, r31, r33)
            boolean r1 = r5.intersects(r1)
            if (r1 != 0) goto L_0x00ac
            com.google.android.gms.maps.model.Tile r1 = com.google.android.gms.maps.model.TileProvider.NO_TILE
            return r1
        L_0x00ac:
            com.google.maps.android.quadtree.PointQuadTree<com.google.maps.android.heatmaps.WeightedLatLng> r1 = r0.mTree
            java.util.Collection r1 = r1.search(r5)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x00bb
            com.google.android.gms.maps.model.Tile r1 = com.google.android.gms.maps.model.TileProvider.NO_TILE
            return r1
        L_0x00bb:
            int r2 = r0.mRadius
            int r3 = r2 * 2
            int r3 = r3 + 512
            int r2 = r2 * 2
            int r2 = r2 + 512
            int[] r2 = new int[]{r3, r2}
            java.lang.Class r3 = java.lang.Double.TYPE
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r3, r2)
            double[][] r2 = (double[][]) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00d5:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00fb
            java.lang.Object r3 = r1.next()
            com.google.maps.android.heatmaps.WeightedLatLng r3 = (com.google.maps.android.heatmaps.WeightedLatLng) r3
            com.google.maps.android.geometry.Point r5 = r3.getPoint()
            double r10 = r5.x
            double r10 = r10 - r13
            double r10 = r10 / r6
            int r10 = (int) r10
            double r11 = r5.y
            double r11 = r11 - r8
            double r11 = r11 / r6
            int r5 = (int) r11
            r10 = r2[r10]
            r11 = r10[r5]
            double r15 = r3.getIntensity()
            double r11 = r11 + r15
            r10[r5] = r11
            goto L_0x00d5
        L_0x00fb:
            java.util.Iterator r1 = r4.iterator()
        L_0x00ff:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0127
            java.lang.Object r3 = r1.next()
            com.google.maps.android.heatmaps.WeightedLatLng r3 = (com.google.maps.android.heatmaps.WeightedLatLng) r3
            com.google.maps.android.geometry.Point r4 = r3.getPoint()
            double r10 = r4.x
            double r10 = r10 + r24
            double r10 = r10 - r13
            double r10 = r10 / r6
            int r5 = (int) r10
            double r10 = r4.y
            double r10 = r10 - r8
            double r10 = r10 / r6
            int r4 = (int) r10
            r5 = r2[r5]
            r10 = r5[r4]
            double r15 = r3.getIntensity()
            double r10 = r10 + r15
            r5[r4] = r10
            goto L_0x00ff
        L_0x0127:
            double[] r1 = r0.mKernel
            double[][] r1 = convolve(r2, r1)
            int[] r2 = r0.mColorMap
            double[] r3 = r0.mMaxIntensity
            r4 = r3[r38]
            android.graphics.Bitmap r1 = colorize(r1, r2, r4)
            com.google.android.gms.maps.model.Tile r1 = convertBitmap(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.heatmaps.HeatmapTileProvider.getTile(int, int, int):com.google.android.gms.maps.model.Tile");
    }

    public void setGradient(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    public void setRadius(int i) {
        this.mRadius = i;
        this.mKernel = generateKernel(i, ((double) i) / 3.0d);
        this.mMaxIntensity = getMaxIntensities(this.mRadius);
    }

    public void setOpacity(double d) {
        this.mOpacity = d;
        setGradient(this.mGradient);
    }

    public void setMaxIntensity(double d) {
        this.mCustomMaxIntensity = d;
        setWeightedData(this.mData);
    }

    private double[] getMaxIntensities(int i) {
        int i2;
        double[] dArr = new double[22];
        if (this.mCustomMaxIntensity != AudioStats.AUDIO_AMPLITUDE_NONE) {
            for (int i3 = 0; i3 < 22; i3++) {
                dArr[i3] = this.mCustomMaxIntensity;
            }
            return dArr;
        }
        int i4 = 5;
        while (true) {
            if (i4 >= 11) {
                break;
            }
            dArr[i4] = getMaxValue(this.mData, this.mBounds, i, (int) (Math.pow(2.0d, (double) (i4 - 3)) * 1280.0d));
            if (i4 == 5) {
                for (int i5 = 0; i5 < i4; i5++) {
                    dArr[i5] = dArr[i4];
                }
            }
            i4++;
        }
        for (i2 = 11; i2 < 22; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static Tile convertBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(512, 512, byteArrayOutputStream.toByteArray());
    }

    static Bounds getBounds(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().x;
        double d2 = next.getPoint().x;
        double d3 = d;
        double d4 = d2;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new Bounds(d3, d4, d5, d6);
    }

    static double[] generateKernel(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    static double[][] convolve(double[][] dArr, double[] dArr2) {
        double[][] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int floor = (int) Math.floor(((double) dArr4.length) / 2.0d);
        int length = dArr3.length;
        int i = length - (floor * 2);
        int i2 = floor + i;
        int i3 = i2 - 1;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{length, length});
        int i4 = 0;
        while (true) {
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (i4 >= length) {
                break;
            }
            int i5 = 0;
            while (i5 < length) {
                double d2 = dArr3[i4][i5];
                if (d2 != d) {
                    int i6 = i4 + floor;
                    if (i3 < i6) {
                        i6 = i3;
                    }
                    int i7 = i6 + 1;
                    int i8 = i4 - floor;
                    for (int i9 = floor > i8 ? floor : i8; i9 < i7; i9++) {
                        double[] dArr6 = dArr5[i9];
                        dArr6[i5] = dArr6[i5] + (dArr4[i9 - i8] * d2);
                    }
                }
                i5++;
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            i4++;
        }
        double[][] dArr7 = (double[][]) Array.newInstance(Double.TYPE, new int[]{i, i});
        for (int i10 = floor; i10 < i2; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                double d3 = dArr5[i10][i11];
                if (d3 != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    int i12 = i11 + floor;
                    if (i3 < i12) {
                        i12 = i3;
                    }
                    int i13 = i12 + 1;
                    int i14 = i11 - floor;
                    for (int i15 = floor > i14 ? floor : i14; i15 < i13; i15++) {
                        double[] dArr8 = dArr7[i10 - floor];
                        int i16 = i15 - floor;
                        dArr8[i16] = dArr8[i16] + (dArr4[i15 - i14] * d3);
                    }
                }
            }
        }
        return dArr7;
    }

    static Bitmap colorize(double[][] dArr, int[] iArr, double d) {
        double[][] dArr2 = dArr;
        int[] iArr2 = iArr;
        int i = iArr2[iArr2.length - 1];
        double length = ((double) (iArr2.length - 1)) / d;
        int length2 = dArr2.length;
        int[] iArr3 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr2[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    iArr3[i4] = 0;
                } else if (i5 < iArr2.length) {
                    iArr3[i4] = iArr2[i5];
                } else {
                    iArr3[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr3, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    static double getMaxValue(Collection<WeightedLatLng> collection, Bounds bounds, int i, int i2) {
        Bounds bounds2 = bounds;
        double d = bounds2.minX;
        double d2 = bounds2.maxX;
        double d3 = bounds2.minY;
        double d4 = d2 - d;
        double d5 = bounds2.maxY - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (WeightedLatLng next : collection) {
            double d8 = next.getPoint().x;
            int i3 = (int) ((next.getPoint().y - d3) * d6);
            long j = (long) ((int) ((d8 - d) * d6));
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = (long) i3;
            Double d9 = (Double) longSparseArray2.get(j2);
            if (d9 == null) {
                d9 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            Double valueOf = Double.valueOf(d9.doubleValue() + next.getIntensity());
            longSparseArray2.put(j2, valueOf);
            if (valueOf.doubleValue() > d7) {
                d7 = valueOf.doubleValue();
            }
        }
        return d7;
    }
}
