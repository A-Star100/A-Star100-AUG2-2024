package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.views.text.fragments.TextFragment;
import com.facebook.react.views.text.fragments.TextFragmentList;
import com.facebook.react.views.text.internal.span.CustomLetterSpacingSpan;
import com.facebook.react.views.text.internal.span.CustomLineHeightSpan;
import com.facebook.react.views.text.internal.span.CustomStyleSpan;
import com.facebook.react.views.text.internal.span.ReactAbsoluteSizeSpan;
import com.facebook.react.views.text.internal.span.ReactBackgroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactClickableSpan;
import com.facebook.react.views.text.internal.span.ReactForegroundColorSpan;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;
import com.facebook.react.views.text.internal.span.ReactTagSpan;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;
import com.facebook.react.views.text.internal.span.SetSpanOperation;
import com.facebook.react.views.text.internal.span.ShadowStyleSpan;
import com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J>\u0010\u0010\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0007J.\u0010\u0017\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J.\u0010\u0018\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J6\u0010\u0019\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J.\u0010\u001a\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J6\u0010\u001b\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J.\u0010\u001f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J.\u0010 \u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J6\u0010!\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J.\u0010\"\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J.\u0010#\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J.\u0010$\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J\"\u0010%\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J.\u0010'\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0003J.\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/facebook/react/views/text/TextLayoutUtils;", "", "()V", "INLINE_VIEW_PLACEHOLDER", "", "addApplicableFragmentSpans", "", "context", "Landroid/content/Context;", "fragment", "Lcom/facebook/react/views/text/fragments/TextFragment;", "sb", "Landroid/text/SpannableStringBuilder;", "ops", "", "Lcom/facebook/react/views/text/internal/span/SetSpanOperation;", "addApplicableTextAttributeSpans", "textAttributeProvider", "Lcom/facebook/react/views/text/EffectiveTextAttributeProvider;", "reactTag", "", "start", "end", "addBackgroundColorSpanIfApplicable", "addColorSpanIfApplicable", "addCustomStyleSpanIfApplicable", "addFontSizeSpanIfApplicable", "addInlineViewPlaceholderSpan", "width", "", "height", "addLetterSpacingSpanIfApplicable", "addLineHeightSpanIfApplicable", "addLinkSpanIfApplicable", "addReactTagSpan", "addShadowStyleSpanIfApplicable", "addStrikethroughSpanIfApplicable", "addText", "text", "addUnderlineSpanIfApplicable", "buildSpannableFromTextFragmentList", "textFragmentList", "Lcom/facebook/react/views/text/fragments/TextFragmentList;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TextLayoutUtils.kt */
public final class TextLayoutUtils {
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    public static final TextLayoutUtils INSTANCE = new TextLayoutUtils();

    private TextLayoutUtils() {
    }

    @JvmStatic
    public static final void buildSpannableFromTextFragmentList(Context context, TextFragmentList textFragmentList, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textFragmentList, "textFragmentList");
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "sb");
        Intrinsics.checkNotNullParameter(list, "ops");
        int count = textFragmentList.getCount();
        for (int i = 0; i < count; i++) {
            INSTANCE.addApplicableFragmentSpans(context, textFragmentList.getFragment(i), spannableStringBuilder, list);
        }
    }

    private final void addApplicableFragmentSpans(Context context, TextFragment textFragment, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int length = spannableStringBuilder.length();
        EffectiveTextAttributeProvider textAttributeProps = textFragment.getTextAttributeProps();
        addText(spannableStringBuilder, textFragment.getString(), textAttributeProps);
        int length2 = spannableStringBuilder.length();
        int reactTag = textFragment.hasReactTag() ? textFragment.getReactTag() : -1;
        if (textFragment.hasIsAttachment() && textFragment.isAttachment()) {
            addInlineViewPlaceholderSpan(list, spannableStringBuilder, reactTag, PixelUtil.toPixelFromSP(textFragment.getWidth()), PixelUtil.toPixelFromSP(textFragment.getHeight()));
        } else if (length2 >= length) {
            addApplicableTextAttributeSpans(list, textAttributeProps, reactTag, context, length, length2);
        }
    }

    @JvmStatic
    public static final void addText(SpannableStringBuilder spannableStringBuilder, String str, EffectiveTextAttributeProvider effectiveTextAttributeProvider) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "sb");
        Intrinsics.checkNotNullParameter(effectiveTextAttributeProvider, "textAttributeProvider");
        spannableStringBuilder.append(TextTransform.apply(str, effectiveTextAttributeProvider.getTextTransform()));
    }

    @JvmStatic
    public static final void addInlineViewPlaceholderSpan(List<SetSpanOperation> list, SpannableStringBuilder spannableStringBuilder, int i, float f, float f2) {
        Intrinsics.checkNotNullParameter(list, "ops");
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "sb");
        list.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i, (int) f, (int) f2)));
    }

    @JvmStatic
    public static final void addApplicableTextAttributeSpans(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, Context context, int i2, int i3) {
        Intrinsics.checkNotNullParameter(list, "ops");
        Intrinsics.checkNotNullParameter(effectiveTextAttributeProvider, "textAttributeProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        addColorSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addBackgroundColorSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addLinkSpanIfApplicable(list, effectiveTextAttributeProvider, i, i2, i3);
        addLetterSpacingSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addFontSizeSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addCustomStyleSpanIfApplicable(list, effectiveTextAttributeProvider, context, i2, i3);
        addUnderlineSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addStrikethroughSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addShadowStyleSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addLineHeightSpanIfApplicable(list, effectiveTextAttributeProvider, i2, i3);
        addReactTagSpan(list, i2, i3, i);
    }

    @JvmStatic
    private static final void addLinkSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2, int i3) {
        ReactAccessibilityDelegate.Role role = effectiveTextAttributeProvider.getRole();
        if (role != null) {
            if (role != ReactAccessibilityDelegate.Role.LINK) {
                return;
            }
        } else if (effectiveTextAttributeProvider.getAccessibilityRole() != ReactAccessibilityDelegate.AccessibilityRole.LINK) {
            return;
        }
        list.add(new SetSpanOperation(i2, i3, new ReactClickableSpan(i)));
    }

    @JvmStatic
    private static final void addColorSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        if (effectiveTextAttributeProvider.isColorSet()) {
            list.add(new SetSpanOperation(i, i2, new ReactForegroundColorSpan(effectiveTextAttributeProvider.getColor())));
        }
    }

    @JvmStatic
    private static final void addBackgroundColorSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        if (effectiveTextAttributeProvider.isBackgroundColorSet()) {
            list.add(new SetSpanOperation(i, i2, new ReactBackgroundColorSpan(effectiveTextAttributeProvider.getBackgroundColor())));
        }
    }

    @JvmStatic
    private static final void addLetterSpacingSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        float effectiveLetterSpacing = effectiveTextAttributeProvider.getEffectiveLetterSpacing();
        if (!Float.isNaN(effectiveLetterSpacing)) {
            list.add(new SetSpanOperation(i, i2, new CustomLetterSpacingSpan(effectiveLetterSpacing)));
        }
    }

    @JvmStatic
    private static final void addFontSizeSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        int effectiveFontSize = effectiveTextAttributeProvider.getEffectiveFontSize();
        if (effectiveFontSize != -1) {
            list.add(new SetSpanOperation(i, i2, new ReactAbsoluteSizeSpan(effectiveFontSize)));
        }
    }

    @JvmStatic
    private static final void addCustomStyleSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, Context context, int i, int i2) {
        int fontStyle = effectiveTextAttributeProvider.getFontStyle();
        int fontWeight = effectiveTextAttributeProvider.getFontWeight();
        String fontFamily = effectiveTextAttributeProvider.getFontFamily();
        if (fontStyle != -1 || fontWeight != -1 || fontFamily != null) {
            list.add(new SetSpanOperation(i, i2, new CustomStyleSpan(fontStyle, fontWeight, effectiveTextAttributeProvider.getFontFeatureSettings(), fontFamily, context.getAssets())));
        }
    }

    @JvmStatic
    private static final void addUnderlineSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        if (effectiveTextAttributeProvider.isUnderlineTextDecorationSet()) {
            list.add(new SetSpanOperation(i, i2, new ReactUnderlineSpan()));
        }
    }

    @JvmStatic
    private static final void addStrikethroughSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        if (effectiveTextAttributeProvider.isLineThroughTextDecorationSet()) {
            list.add(new SetSpanOperation(i, i2, new ReactStrikethroughSpan()));
        }
    }

    @JvmStatic
    private static final void addShadowStyleSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        boolean z = false;
        boolean z2 = (effectiveTextAttributeProvider.getTextShadowOffsetDx() == 0.0f && effectiveTextAttributeProvider.getTextShadowOffsetDy() == 0.0f) ? false : true;
        boolean z3 = !(effectiveTextAttributeProvider.getTextShadowRadius() == 0.0f);
        if (Color.alpha(effectiveTextAttributeProvider.getTextShadowColor()) != 0) {
            z = true;
        }
        if ((z2 || z3) && z) {
            list.add(new SetSpanOperation(i, i2, new ShadowStyleSpan(effectiveTextAttributeProvider.getTextShadowOffsetDx(), effectiveTextAttributeProvider.getTextShadowOffsetDy(), effectiveTextAttributeProvider.getTextShadowRadius(), effectiveTextAttributeProvider.getTextShadowColor())));
        }
    }

    @JvmStatic
    private static final void addLineHeightSpanIfApplicable(List<SetSpanOperation> list, EffectiveTextAttributeProvider effectiveTextAttributeProvider, int i, int i2) {
        float effectiveLineHeight = effectiveTextAttributeProvider.getEffectiveLineHeight();
        if (!Float.isNaN(effectiveLineHeight)) {
            list.add(new SetSpanOperation(i, i2, new CustomLineHeightSpan(effectiveLineHeight)));
        }
    }

    @JvmStatic
    private static final void addReactTagSpan(List<SetSpanOperation> list, int i, int i2, int i3) {
        list.add(new SetSpanOperation(i, i2, new ReactTagSpan(i3)));
    }
}
