package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ShapePath implements ContentModel {
    private final boolean hidden;
    private final int index;
    private final String name;
    private final AnimatableShapeValue shapePath;

    public String getName() {
        return this.name;
    }

    public AnimatableShapeValue getShapePath() {
        return this.shapePath;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public ShapePath(String str, int i, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.name = str;
        this.index = i;
        this.shapePath = animatableShapeValue;
        this.hidden = z;
    }

    public Content toContent(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + AbstractJsonLexerKt.END_OBJ;
    }
}
