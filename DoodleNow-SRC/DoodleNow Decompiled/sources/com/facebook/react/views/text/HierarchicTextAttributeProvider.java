package com.facebook.react.views.text;

import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0012\u0010!\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u0012\u0010#\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u0010R\u0012\u0010%\u001a\u00020&X\u0005¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0012\u0010(\u001a\u00020&X\u0005¢\u0006\u0006\u001a\u0004\b(\u0010'R\u0012\u0010)\u001a\u00020&X\u0005¢\u0006\u0006\u001a\u0004\b)\u0010'R\u0012\u0010*\u001a\u00020&X\u0005¢\u0006\u0006\u001a\u0004\b*\u0010'R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010,X\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u0016X\u0005¢\u0006\u0006\u001a\u0004\b2\u0010\u0018R\u0012\u00103\u001a\u00020\u0016X\u0005¢\u0006\u0006\u001a\u0004\b4\u0010\u0018R\u0012\u00105\u001a\u00020\u0016X\u0005¢\u0006\u0006\u001a\u0004\b6\u0010\u0018R\u0014\u00107\u001a\u0002088VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/facebook/react/views/text/HierarchicTextAttributeProvider;", "Lcom/facebook/react/views/text/EffectiveTextAttributeProvider;", "Lcom/facebook/react/views/text/BasicTextAttributeProvider;", "textShadowNode", "Lcom/facebook/react/views/text/ReactBaseTextShadowNode;", "parentTextAttributes", "Lcom/facebook/react/views/text/TextAttributes;", "textAttributes", "(Lcom/facebook/react/views/text/ReactBaseTextShadowNode;Lcom/facebook/react/views/text/TextAttributes;Lcom/facebook/react/views/text/TextAttributes;)V", "accessibilityRole", "Lcom/facebook/react/uimanager/ReactAccessibilityDelegate$AccessibilityRole;", "getAccessibilityRole", "()Lcom/facebook/react/uimanager/ReactAccessibilityDelegate$AccessibilityRole;", "backgroundColor", "", "getBackgroundColor", "()I", "color", "getColor", "effectiveFontSize", "getEffectiveFontSize", "effectiveLetterSpacing", "", "getEffectiveLetterSpacing", "()F", "effectiveLineHeight", "getEffectiveLineHeight", "fontFamily", "", "getFontFamily", "()Ljava/lang/String;", "fontFeatureSettings", "getFontFeatureSettings", "fontStyle", "getFontStyle", "fontWeight", "getFontWeight", "isBackgroundColorSet", "", "()Z", "isColorSet", "isLineThroughTextDecorationSet", "isUnderlineTextDecorationSet", "role", "Lcom/facebook/react/uimanager/ReactAccessibilityDelegate$Role;", "getRole", "()Lcom/facebook/react/uimanager/ReactAccessibilityDelegate$Role;", "textShadowColor", "getTextShadowColor", "textShadowOffsetDx", "getTextShadowOffsetDx", "textShadowOffsetDy", "getTextShadowOffsetDy", "textShadowRadius", "getTextShadowRadius", "textTransform", "Lcom/facebook/react/views/text/TextTransform;", "getTextTransform", "()Lcom/facebook/react/views/text/TextTransform;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HierarchicTextAttributeProvider.kt */
public final class HierarchicTextAttributeProvider implements EffectiveTextAttributeProvider, BasicTextAttributeProvider {
    private final TextAttributes parentTextAttributes;
    private final TextAttributes textAttributes;
    private final ReactBaseTextShadowNode textShadowNode;

    public ReactAccessibilityDelegate.AccessibilityRole getAccessibilityRole() {
        return this.textShadowNode.getAccessibilityRole();
    }

    public int getBackgroundColor() {
        return this.textShadowNode.getBackgroundColor();
    }

    public int getColor() {
        return this.textShadowNode.getColor();
    }

    public String getFontFamily() {
        return this.textShadowNode.getFontFamily();
    }

    public String getFontFeatureSettings() {
        return this.textShadowNode.getFontFeatureSettings();
    }

    public int getFontStyle() {
        return this.textShadowNode.getFontStyle();
    }

    public int getFontWeight() {
        return this.textShadowNode.getFontWeight();
    }

    public ReactAccessibilityDelegate.Role getRole() {
        return this.textShadowNode.getRole();
    }

    public int getTextShadowColor() {
        return this.textShadowNode.getTextShadowColor();
    }

    public float getTextShadowOffsetDx() {
        return this.textShadowNode.getTextShadowOffsetDx();
    }

    public float getTextShadowOffsetDy() {
        return this.textShadowNode.getTextShadowOffsetDy();
    }

    public float getTextShadowRadius() {
        return this.textShadowNode.getTextShadowRadius();
    }

    public boolean isBackgroundColorSet() {
        return this.textShadowNode.isBackgroundColorSet();
    }

    public boolean isColorSet() {
        return this.textShadowNode.isColorSet();
    }

    public boolean isLineThroughTextDecorationSet() {
        return this.textShadowNode.isLineThroughTextDecorationSet();
    }

    public boolean isUnderlineTextDecorationSet() {
        return this.textShadowNode.isUnderlineTextDecorationSet();
    }

    public HierarchicTextAttributeProvider(ReactBaseTextShadowNode reactBaseTextShadowNode, TextAttributes textAttributes2, TextAttributes textAttributes3) {
        Intrinsics.checkNotNullParameter(reactBaseTextShadowNode, "textShadowNode");
        Intrinsics.checkNotNullParameter(textAttributes3, "textAttributes");
        this.textShadowNode = reactBaseTextShadowNode;
        this.parentTextAttributes = textAttributes2;
        this.textAttributes = textAttributes3;
    }

    public TextTransform getTextTransform() {
        TextTransform textTransform = this.textAttributes.getTextTransform();
        Intrinsics.checkNotNullExpressionValue(textTransform, "getTextTransform(...)");
        return textTransform;
    }

    public float getEffectiveLetterSpacing() {
        float effectiveLetterSpacing = this.textAttributes.getEffectiveLetterSpacing();
        TextAttributes textAttributes2 = this.parentTextAttributes;
        boolean z = textAttributes2 == null || textAttributes2.getEffectiveLetterSpacing() != effectiveLetterSpacing;
        if (Float.isNaN(effectiveLetterSpacing) || !z) {
            return Float.NaN;
        }
        return effectiveLetterSpacing;
    }

    public int getEffectiveFontSize() {
        int effectiveFontSize = this.textAttributes.getEffectiveFontSize();
        TextAttributes textAttributes2 = this.parentTextAttributes;
        if (textAttributes2 == null || textAttributes2.getEffectiveFontSize() != effectiveFontSize) {
            return effectiveFontSize;
        }
        return -1;
    }

    public float getEffectiveLineHeight() {
        float effectiveLineHeight = this.textAttributes.getEffectiveLineHeight();
        TextAttributes textAttributes2 = this.parentTextAttributes;
        boolean z = textAttributes2 == null || textAttributes2.getEffectiveLineHeight() != effectiveLineHeight;
        if (Float.isNaN(effectiveLineHeight) || !z) {
            return Float.NaN;
        }
        return effectiveLineHeight;
    }
}
