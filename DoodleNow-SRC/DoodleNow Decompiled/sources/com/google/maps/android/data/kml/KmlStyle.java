package com.google.maps.android.data.kml;

import android.graphics.Color;
import com.amazon.a.a.o.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class KmlStyle extends Style {
    private static final int HSV_VALUES = 3;
    private static final int HUE_VALUE = 0;
    private static final int INITIAL_SCALE = 1;
    private final HashMap<String, String> mBalloonOptions = new HashMap<>();
    private boolean mFill = true;
    private boolean mIconRandomColorMode = false;
    private String mIconUrl;
    private boolean mLineRandomColorMode = false;
    float mMarkerColor = 0.0f;
    private boolean mOutline = true;
    private boolean mPolyRandomColorMode = false;
    private double mScale = 1.0d;
    private String mStyleId = null;
    private final HashSet<String> mStylesSet = new HashSet<>();

    public HashMap<String, String> getBalloonOptions() {
        return this.mBalloonOptions;
    }

    public double getIconScale() {
        return this.mScale;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    /* access modifiers changed from: package-private */
    public String getStyleId() {
        return this.mStyleId;
    }

    public boolean hasFill() {
        return this.mFill;
    }

    public boolean hasOutline() {
        return this.mOutline;
    }

    /* access modifiers changed from: package-private */
    public boolean isIconRandomColorMode() {
        return this.mIconRandomColorMode;
    }

    public boolean isLineRandomColorMode() {
        return this.mLineRandomColorMode;
    }

    public boolean isPolyRandomColorMode() {
        return this.mPolyRandomColorMode;
    }

    public void setFill(boolean z) {
        this.mFill = z;
    }

    /* access modifiers changed from: package-private */
    public void setStyleId(String str) {
        this.mStyleId = str;
    }

    KmlStyle() {
    }

    /* access modifiers changed from: package-private */
    public void setInfoWindowText(String str) {
        this.mBalloonOptions.put("text", str);
    }

    public boolean isStyleSet(String str) {
        return this.mStylesSet.contains(str);
    }

    /* access modifiers changed from: package-private */
    public void setIconScale(double d) {
        this.mScale = d;
        this.mStylesSet.add("iconScale");
    }

    public boolean hasBalloonStyle() {
        return this.mBalloonOptions.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public void setOutline(boolean z) {
        this.mOutline = z;
        this.mStylesSet.add("outline");
    }

    /* access modifiers changed from: package-private */
    public void setIconUrl(String str) {
        this.mIconUrl = str;
        this.mStylesSet.add(b.j);
    }

    /* access modifiers changed from: package-private */
    public void setFillColor(String str) {
        setPolygonFillColor(Color.parseColor("#" + convertColor(str)));
        this.mStylesSet.add("fillColor");
    }

    /* access modifiers changed from: package-private */
    public void setMarkerColor(String str) {
        this.mMarkerColor = getHueValue(Color.parseColor("#" + convertColor(str)));
        this.mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(this.mMarkerColor));
        this.mStylesSet.add("markerColor");
    }

    private static float getHueValue(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        return fArr[0];
    }

    private static String convertColor(String str) {
        String trim = str.trim();
        if (trim.length() > 6) {
            return trim.substring(0, 2) + trim.substring(6, 8) + trim.substring(4, 6) + trim.substring(2, 4);
        }
        return trim.substring(4, 6) + trim.substring(2, 4) + trim.substring(0, 2);
    }

    /* access modifiers changed from: package-private */
    public void setHeading(float f) {
        setMarkerRotation(f);
        this.mStylesSet.add("heading");
    }

    /* access modifiers changed from: package-private */
    public void setHotSpot(float f, float f2, String str, String str2) {
        setMarkerHotSpot(f, f2, str, str2);
        this.mStylesSet.add("hotSpot");
    }

    /* access modifiers changed from: package-private */
    public void setIconColorMode(String str) {
        this.mIconRandomColorMode = str.equals("random");
        this.mStylesSet.add("iconColorMode");
    }

    /* access modifiers changed from: package-private */
    public void setLineColorMode(String str) {
        this.mLineRandomColorMode = str.equals("random");
        this.mStylesSet.add("lineColorMode");
    }

    /* access modifiers changed from: package-private */
    public void setPolyColorMode(String str) {
        this.mPolyRandomColorMode = str.equals("random");
        this.mStylesSet.add("polyColorMode");
    }

    /* access modifiers changed from: package-private */
    public void setOutlineColor(String str) {
        PolylineOptions polylineOptions = this.mPolylineOptions;
        polylineOptions.color(Color.parseColor("#" + convertColor(str)));
        PolygonOptions polygonOptions = this.mPolygonOptions;
        polygonOptions.strokeColor(Color.parseColor("#" + convertColor(str)));
        this.mStylesSet.add("outlineColor");
    }

    /* access modifiers changed from: package-private */
    public void setWidth(Float f) {
        setLineStringWidth(f.floatValue());
        setPolygonStrokeWidth(f.floatValue());
        this.mStylesSet.add("width");
    }

    private static MarkerOptions createMarkerOptions(MarkerOptions markerOptions, boolean z, float f) {
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.rotation(markerOptions.getRotation());
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        if (z) {
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(getHueValue(computeRandomColor((int) f))));
        }
        markerOptions2.icon(markerOptions.getIcon());
        return markerOptions2;
    }

    private static PolylineOptions createPolylineOptions(PolylineOptions polylineOptions) {
        PolylineOptions polylineOptions2 = new PolylineOptions();
        polylineOptions2.color(polylineOptions.getColor());
        polylineOptions2.width(polylineOptions.getWidth());
        polylineOptions2.clickable(polylineOptions.isClickable());
        return polylineOptions2;
    }

    private static PolygonOptions createPolygonOptions(PolygonOptions polygonOptions, boolean z, boolean z2) {
        float f;
        PolygonOptions polygonOptions2 = new PolygonOptions();
        if (z) {
            polygonOptions2.fillColor(polygonOptions.getFillColor());
        }
        if (z2) {
            polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
            f = polygonOptions.getStrokeWidth();
        } else {
            f = 0.0f;
        }
        polygonOptions2.strokeWidth(f);
        polygonOptions2.clickable(polygonOptions.isClickable());
        return polygonOptions2;
    }

    public MarkerOptions getMarkerOptions() {
        return createMarkerOptions(this.mMarkerOptions, isIconRandomColorMode(), this.mMarkerColor);
    }

    public PolylineOptions getPolylineOptions() {
        return createPolylineOptions(this.mPolylineOptions);
    }

    public PolygonOptions getPolygonOptions() {
        return createPolygonOptions(this.mPolygonOptions, this.mFill, this.mOutline);
    }

    public static int computeRandomColor(int i) {
        Random random = new Random();
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    public String toString() {
        return "Style{\n balloon options=" + this.mBalloonOptions + ",\n fill=" + this.mFill + ",\n outline=" + this.mOutline + ",\n icon url=" + this.mIconUrl + ",\n scale=" + this.mScale + ",\n style id=" + this.mStyleId + "\n}\n";
    }
}
