package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public interface RNSVGTSpanManagerInterface<T extends View> {
    void setAlignmentBaseline(T t, String str);

    void setBaselineShift(T t, Dynamic dynamic);

    void setClipPath(T t, String str);

    void setClipRule(T t, int i);

    void setContent(T t, String str);

    void setDisplay(T t, String str);

    void setDx(T t, Dynamic dynamic);

    void setDy(T t, Dynamic dynamic);

    void setFill(T t, ReadableMap readableMap);

    void setFillOpacity(T t, float f);

    void setFillRule(T t, int i);

    void setFont(T t, Dynamic dynamic);

    void setFontSize(T t, Dynamic dynamic);

    void setFontWeight(T t, Dynamic dynamic);

    void setInlineSize(T t, Dynamic dynamic);

    void setLengthAdjust(T t, String str);

    void setMarkerEnd(T t, String str);

    void setMarkerMid(T t, String str);

    void setMarkerStart(T t, String str);

    void setMask(T t, String str);

    void setMatrix(T t, ReadableArray readableArray);

    void setName(T t, String str);

    void setOpacity(T t, float f);

    void setPointerEvents(T t, String str);

    void setPropList(T t, ReadableArray readableArray);

    void setResponsible(T t, boolean z);

    void setRotate(T t, Dynamic dynamic);

    void setStroke(T t, ReadableMap readableMap);

    void setStrokeDasharray(T t, Dynamic dynamic);

    void setStrokeDashoffset(T t, float f);

    void setStrokeLinecap(T t, int i);

    void setStrokeLinejoin(T t, int i);

    void setStrokeMiterlimit(T t, float f);

    void setStrokeOpacity(T t, float f);

    void setStrokeWidth(T t, Dynamic dynamic);

    void setTextLength(T t, Dynamic dynamic);

    void setVectorEffect(T t, int i);

    void setVerticalAlign(T t, Dynamic dynamic);

    void setX(T t, Dynamic dynamic);

    void setY(T t, Dynamic dynamic);
}
