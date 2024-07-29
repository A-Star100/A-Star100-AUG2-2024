package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public interface RNSVGPatternManagerInterface<T extends View> {
    void setAlign(T t, String str);

    void setClipPath(T t, String str);

    void setClipRule(T t, int i);

    void setDisplay(T t, String str);

    void setFill(T t, ReadableMap readableMap);

    void setFillOpacity(T t, float f);

    void setFillRule(T t, int i);

    void setFont(T t, Dynamic dynamic);

    void setFontSize(T t, Dynamic dynamic);

    void setFontWeight(T t, Dynamic dynamic);

    void setHeight(T t, Dynamic dynamic);

    void setMarkerEnd(T t, String str);

    void setMarkerMid(T t, String str);

    void setMarkerStart(T t, String str);

    void setMask(T t, String str);

    void setMatrix(T t, ReadableArray readableArray);

    void setMeetOrSlice(T t, int i);

    void setMinX(T t, float f);

    void setMinY(T t, float f);

    void setName(T t, String str);

    void setOpacity(T t, float f);

    void setPatternContentUnits(T t, int i);

    void setPatternTransform(T t, ReadableArray readableArray);

    void setPatternUnits(T t, int i);

    void setPointerEvents(T t, String str);

    void setPropList(T t, ReadableArray readableArray);

    void setResponsible(T t, boolean z);

    void setStroke(T t, ReadableMap readableMap);

    void setStrokeDasharray(T t, Dynamic dynamic);

    void setStrokeDashoffset(T t, float f);

    void setStrokeLinecap(T t, int i);

    void setStrokeLinejoin(T t, int i);

    void setStrokeMiterlimit(T t, float f);

    void setStrokeOpacity(T t, float f);

    void setStrokeWidth(T t, Dynamic dynamic);

    void setVbHeight(T t, float f);

    void setVbWidth(T t, float f);

    void setVectorEffect(T t, int i);

    void setWidth(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
