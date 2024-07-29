package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.text.fragments.BridgeTextFragmentList;
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
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaMeasureMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TextLayoutManager {
    private static final boolean DEFAULT_INCLUDE_FONT_PADDING = true;
    private static final boolean ENABLE_MEASURE_LOGGING = false;
    private static final String HYPHENATION_FREQUENCY_KEY = "android_hyphenationFrequency";
    private static final String INCLUDE_FONT_PADDING_KEY = "includeFontPadding";
    private static final String INLINE_VIEW_PLACEHOLDER = "0";
    private static final String MAXIMUM_NUMBER_OF_LINES_KEY = "maximumNumberOfLines";
    private static final String TAG = "TextLayoutManager";
    private static final String TEXT_BREAK_STRATEGY_KEY = "textBreakStrategy";
    private static final LruCache<ReadableNativeMap, Spannable> sSpannableCache = new LruCache<>(100);
    private static final Object sSpannableCacheLock = new Object();
    private static final ConcurrentHashMap<Integer, Spannable> sTagToSpannableCache = new ConcurrentHashMap<>();
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private static final int spannableCacheSize = 100;

    public static boolean isRTL(ReadableMap readableMap) {
        ReadableMap map;
        ReadableArray array = readableMap.getArray("fragments");
        if (array == null || array.size() <= 0 || (map = array.getMap(0).getMap("textAttributes")) == null || TextAttributeProps.getLayoutDirection(map.getString(ViewProps.LAYOUT_DIRECTION)) != 1) {
            return false;
        }
        return true;
    }

    public static void setCachedSpannabledForTag(int i, Spannable spannable) {
        sTagToSpannableCache.put(Integer.valueOf(i), spannable);
    }

    public static void deleteCachedSpannableForTag(int i) {
        sTagToSpannableCache.remove(Integer.valueOf(i));
    }

    private static void buildSpannableFromFragments(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        if (ReactNativeFeatureFlags.enableSpannableBuildingUnification()) {
            buildSpannableFromFragmentsUnified(context, readableArray, spannableStringBuilder, list);
        } else {
            buildSpannableFromFragmentsDuplicated(context, readableArray, spannableStringBuilder, list);
        }
    }

    private static void buildSpannableFromFragmentsDuplicated(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int i;
        List<SetSpanOperation> list2 = list;
        int i2 = 0;
        for (int size = readableArray.size(); i2 < size; size = i) {
            ReadableMap map = readableArray.getMap(i2);
            int length = spannableStringBuilder.length();
            TextAttributeProps fromReadableMap = TextAttributeProps.fromReadableMap(new ReactStylesDiffMap(map.getMap("textAttributes")));
            spannableStringBuilder.append(TextTransform.apply(map.getString("string"), fromReadableMap.mTextTransform));
            int length2 = spannableStringBuilder.length();
            int i3 = map.hasKey("reactTag") ? map.getInt("reactTag") : -1;
            if (map.hasKey(ViewProps.IS_ATTACHMENT) && map.getBoolean(ViewProps.IS_ATTACHMENT)) {
                list2.add(new SetSpanOperation(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new TextInlineViewPlaceholderSpan(i3, (int) PixelUtil.toPixelFromSP(map.getDouble("width")), (int) PixelUtil.toPixelFromSP(map.getDouble("height")))));
            } else if (length2 >= length) {
                if (fromReadableMap.mRole == null ? fromReadableMap.mAccessibilityRole == ReactAccessibilityDelegate.AccessibilityRole.LINK : fromReadableMap.mRole == ReactAccessibilityDelegate.Role.LINK) {
                    list2.add(new SetSpanOperation(length, length2, new ReactClickableSpan(i3)));
                }
                if (fromReadableMap.mIsColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactForegroundColorSpan(fromReadableMap.mColor)));
                }
                if (fromReadableMap.mIsBackgroundColorSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactBackgroundColorSpan(fromReadableMap.mBackgroundColor)));
                }
                if (!Float.isNaN(fromReadableMap.getLetterSpacing())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLetterSpacingSpan(fromReadableMap.getLetterSpacing())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactAbsoluteSizeSpan(fromReadableMap.mFontSize)));
                if (fromReadableMap.mFontStyle == -1 && fromReadableMap.mFontWeight == -1 && fromReadableMap.mFontFamily == null) {
                    i = size;
                } else {
                    i = size;
                    CustomStyleSpan customStyleSpan = r10;
                    CustomStyleSpan customStyleSpan2 = new CustomStyleSpan(fromReadableMap.mFontStyle, fromReadableMap.mFontWeight, fromReadableMap.mFontFeatureSettings, fromReadableMap.mFontFamily, context.getAssets());
                    list2.add(new SetSpanOperation(length, length2, customStyleSpan));
                }
                if (fromReadableMap.mIsUnderlineTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactUnderlineSpan()));
                }
                if (fromReadableMap.mIsLineThroughTextDecorationSet) {
                    list2.add(new SetSpanOperation(length, length2, new ReactStrikethroughSpan()));
                }
                if (!((fromReadableMap.mTextShadowOffsetDx == 0.0f && fromReadableMap.mTextShadowOffsetDy == 0.0f && fromReadableMap.mTextShadowRadius == 0.0f) || Color.alpha(fromReadableMap.mTextShadowColor) == 0)) {
                    list2.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(fromReadableMap.mTextShadowOffsetDx, fromReadableMap.mTextShadowOffsetDy, fromReadableMap.mTextShadowRadius, fromReadableMap.mTextShadowColor)));
                }
                if (!Float.isNaN(fromReadableMap.getEffectiveLineHeight())) {
                    list2.add(new SetSpanOperation(length, length2, new CustomLineHeightSpan(fromReadableMap.getEffectiveLineHeight())));
                }
                list2.add(new SetSpanOperation(length, length2, new ReactTagSpan(i3)));
                i2++;
            }
            i = size;
            i2++;
        }
    }

    private static void buildSpannableFromFragmentsUnified(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        TextLayoutUtils.buildSpannableFromTextFragmentList(context, new BridgeTextFragmentList(readableArray), spannableStringBuilder, list);
    }

    public static Spannable getOrCreateSpannableForText(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return createSpannableFromAttributedString(context, readableMap, reactTextViewManagerCallback);
    }

    private static Spannable createSpannableFromAttributedString(Context context, ReadableMap readableMap, ReactTextViewManagerCallback reactTextViewManagerCallback) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList arrayList = new ArrayList();
        buildSpannableFromFragments(context, readableMap.getArray("fragments"), spannableStringBuilder, arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            ((SetSpanOperation) arrayList.get((arrayList.size() - i) - 1)).execute(spannableStringBuilder, i);
        }
        if (reactTextViewManagerCallback != null) {
            reactTextViewManagerCallback.onPostProcessSpannable(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    private static Layout createLayout(Spannable spannable, BoringLayout.Metrics metrics, float f, YogaMeasureMode yogaMeasureMode, boolean z, int i, int i2) {
        int i3;
        Spannable spannable2 = spannable;
        BoringLayout.Metrics metrics2 = metrics;
        float f2 = f;
        boolean z2 = z;
        int i4 = i;
        int i5 = i2;
        int length = spannable.length();
        boolean z3 = yogaMeasureMode == YogaMeasureMode.UNDEFINED || f2 < 0.0f;
        float desiredWidth = metrics2 == null ? Layout.getDesiredWidth(spannable, sTextPaintInstance) : Float.NaN;
        if (metrics2 == null && (z3 || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f2))) {
            return StaticLayout.Builder.obtain(spannable, 0, length, sTextPaintInstance, (int) Math.ceil((double) desiredWidth)).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i4).setHyphenationFrequency(i5).build();
        } else if (metrics2 == null || (!z3 && ((float) metrics2.width) > f2)) {
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable, 0, length, sTextPaintInstance, (int) f2).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(z2).setBreakStrategy(i4).setHyphenationFrequency(i5);
            if (Build.VERSION.SDK_INT >= 28) {
                StaticLayout.Builder unused = hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        } else {
            int i6 = metrics2.width;
            if (metrics2.width < 0) {
                String str = TAG;
                ReactSoftExceptionLogger.logSoftException(str, new ReactNoCrashSoftException("Text width is invalid: " + metrics2.width));
                i3 = 0;
            } else {
                i3 = i6;
            }
            return BoringLayout.make(spannable, sTextPaintInstance, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, metrics, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bf, code lost:
        if (r3 > r21) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00df, code lost:
        if (r1 > r23) goto L_0x00e1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long measureText(android.content.Context r18, com.facebook.react.bridge.ReadableMap r19, com.facebook.react.bridge.ReadableMap r20, float r21, com.facebook.yoga.YogaMeasureMode r22, float r23, com.facebook.yoga.YogaMeasureMode r24, com.facebook.react.views.text.ReactTextViewManagerCallback r25, float[] r26) {
        /*
            r0 = r19
            r1 = r20
            r9 = r22
            r10 = r24
            java.lang.String r2 = "cacheId"
            boolean r3 = r0.hasKey(r2)
            if (r3 == 0) goto L_0x002e
            int r0 = r0.getInt(r2)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.text.Spannable> r2 = sTagToSpannableCache
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            boolean r3 = r2.containsKey(r3)
            if (r3 == 0) goto L_0x002b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r2.get(r0)
            android.text.Spannable r0 = (android.text.Spannable) r0
            goto L_0x0036
        L_0x002b:
            r0 = 0
            return r0
        L_0x002e:
            r2 = r18
            r3 = r25
            android.text.Spannable r0 = getOrCreateSpannableForText(r2, r0, r3)
        L_0x0036:
            java.lang.String r2 = "textBreakStrategy"
            java.lang.String r2 = r1.getString(r2)
            int r7 = com.facebook.react.views.text.TextAttributeProps.getTextBreakStrategy(r2)
            java.lang.String r2 = "includeFontPadding"
            boolean r3 = r1.hasKey(r2)
            r11 = 1
            if (r3 == 0) goto L_0x004f
            boolean r2 = r1.getBoolean(r2)
            r6 = r2
            goto L_0x0050
        L_0x004f:
            r6 = r11
        L_0x0050:
            java.lang.String r2 = "android_hyphenationFrequency"
            java.lang.String r2 = r1.getString(r2)
            int r8 = com.facebook.react.views.text.TextAttributeProps.getHyphenationFrequency(r2)
            if (r0 == 0) goto L_0x01c0
            android.text.TextPaint r2 = sTextPaintInstance
            android.text.BoringLayout$Metrics r3 = android.text.BoringLayout.isBoring(r0, r2)
            r2 = r0
            r4 = r21
            r5 = r22
            android.text.Layout r2 = createLayout(r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r3 = "maximumNumberOfLines"
            boolean r4 = r1.hasKey(r3)
            r5 = -1
            if (r4 == 0) goto L_0x0079
            int r1 = r1.getInt(r3)
            goto L_0x007a
        L_0x0079:
            r1 = r5
        L_0x007a:
            if (r1 == r5) goto L_0x0088
            if (r1 != 0) goto L_0x007f
            goto L_0x0088
        L_0x007f:
            int r3 = r2.getLineCount()
            int r1 = java.lang.Math.min(r1, r3)
            goto L_0x008c
        L_0x0088:
            int r1 = r2.getLineCount()
        L_0x008c:
            com.facebook.yoga.YogaMeasureMode r3 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            r4 = 10
            if (r9 != r3) goto L_0x0093
            goto L_0x00c1
        L_0x0093:
            r3 = 0
            r7 = 0
        L_0x0095:
            if (r7 >= r1) goto L_0x00b9
            int r8 = r0.length()
            if (r8 <= 0) goto L_0x00ad
            int r8 = r2.getLineEnd(r7)
            int r8 = r8 - r11
            char r8 = r0.charAt(r8)
            if (r8 != r4) goto L_0x00ad
            float r8 = r2.getLineMax(r7)
            goto L_0x00b1
        L_0x00ad:
            float r8 = r2.getLineWidth(r7)
        L_0x00b1:
            int r12 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r12 <= 0) goto L_0x00b6
            r3 = r8
        L_0x00b6:
            int r7 = r7 + 1
            goto L_0x0095
        L_0x00b9:
            com.facebook.yoga.YogaMeasureMode r7 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r9 != r7) goto L_0x00c3
            int r7 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r7 <= 0) goto L_0x00c3
        L_0x00c1:
            r3 = r21
        L_0x00c3:
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 29
            if (r7 <= r8) goto L_0x00cf
            double r7 = (double) r3
            double r7 = java.lang.Math.ceil(r7)
            float r3 = (float) r7
        L_0x00cf:
            com.facebook.yoga.YogaMeasureMode r7 = com.facebook.yoga.YogaMeasureMode.EXACTLY
            if (r10 == r7) goto L_0x00e1
            int r1 = r1 - r11
            int r1 = r2.getLineBottom(r1)
            float r1 = (float) r1
            com.facebook.yoga.YogaMeasureMode r7 = com.facebook.yoga.YogaMeasureMode.AT_MOST
            if (r10 != r7) goto L_0x00e3
            int r7 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r7 <= 0) goto L_0x00e3
        L_0x00e1:
            r1 = r23
        L_0x00e3:
            r7 = 0
            r8 = 0
        L_0x00e5:
            int r9 = r0.length()
            if (r7 >= r9) goto L_0x01b3
            int r9 = r0.length()
            java.lang.Class<com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan> r10 = com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan.class
            int r9 = r0.nextSpanTransition(r7, r9, r10)
            java.lang.Class<com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan> r10 = com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan.class
            java.lang.Object[] r7 = r0.getSpans(r7, r9, r10)
            com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan[] r7 = (com.facebook.react.views.text.internal.span.TextInlineViewPlaceholderSpan[]) r7
            int r10 = r7.length
            r12 = 0
        L_0x00ff:
            if (r12 >= r10) goto L_0x01b0
            r13 = r7[r12]
            int r14 = r0.getSpanStart(r13)
            int r15 = r2.getLineForOffset(r14)
            int r16 = r2.getEllipsisCount(r15)
            if (r16 <= 0) goto L_0x0128
            int r16 = r2.getLineStart(r15)
            int r17 = r2.getEllipsisStart(r15)
            int r6 = r16 + r17
            if (r14 < r6) goto L_0x0128
            int r6 = r2.getLineEnd(r15)
            if (r14 < r6) goto L_0x0124
            goto L_0x0128
        L_0x0124:
            r5 = r4
            r6 = r11
            goto L_0x01a9
        L_0x0128:
            int r6 = r13.getWidth()
            float r6 = (float) r6
            int r13 = r13.getHeight()
            float r13 = (float) r13
            boolean r4 = r2.isRtlCharAt(r14)
            int r11 = r2.getParagraphDirection(r15)
            if (r11 != r5) goto L_0x013e
            r11 = 1
            goto L_0x013f
        L_0x013e:
            r11 = 0
        L_0x013f:
            int r16 = r0.length()
            r17 = 1
            int r5 = r16 + -1
            if (r14 != r5) goto L_0x0173
            int r4 = r0.length()
            if (r4 <= 0) goto L_0x0162
            int r4 = r2.getLineEnd(r15)
            int r4 = r4 + -1
            char r4 = r0.charAt(r4)
            r5 = 10
            if (r4 != r5) goto L_0x0164
            float r4 = r2.getLineMax(r15)
            goto L_0x0168
        L_0x0162:
            r5 = 10
        L_0x0164:
            float r4 = r2.getLineWidth(r15)
        L_0x0168:
            if (r11 == 0) goto L_0x016d
            float r4 = r3 - r4
            goto L_0x0191
        L_0x016d:
            float r4 = r2.getLineRight(r15)
            float r4 = r4 - r6
            goto L_0x0191
        L_0x0173:
            r5 = 10
            if (r11 != r4) goto L_0x017c
            float r14 = r2.getPrimaryHorizontal(r14)
            goto L_0x0180
        L_0x017c:
            float r14 = r2.getSecondaryHorizontal(r14)
        L_0x0180:
            if (r11 == 0) goto L_0x018a
            float r11 = r2.getLineRight(r15)
            float r11 = r11 - r14
            float r11 = r3 - r11
            goto L_0x018b
        L_0x018a:
            r11 = r14
        L_0x018b:
            if (r4 == 0) goto L_0x0190
            float r4 = r11 - r6
            goto L_0x0191
        L_0x0190:
            r4 = r11
        L_0x0191:
            int r6 = r2.getLineBaseline(r15)
            float r6 = (float) r6
            float r6 = r6 - r13
            int r11 = r8 * 2
            float r6 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r6)
            r26[r11] = r6
            r6 = 1
            int r11 = r11 + r6
            float r4 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r4)
            r26[r11] = r4
            int r8 = r8 + 1
        L_0x01a9:
            int r12 = r12 + 1
            r4 = r5
            r11 = r6
            r5 = -1
            goto L_0x00ff
        L_0x01b0:
            r7 = r9
            goto L_0x00e5
        L_0x01b3:
            float r0 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r3)
            float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
            long r0 = com.facebook.yoga.YogaMeasureOutput.make((float) r0, (float) r1)
            return r0
        L_0x01c0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Spannable element has not been prepared in onBeforeLayout"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.measureText(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode, com.facebook.react.views.text.ReactTextViewManagerCallback, float[]):long");
    }

    public static WritableArray measureLines(Context context, ReadableMap readableMap, ReadableMap readableMap2, float f) {
        Spannable orCreateSpannableForText = getOrCreateSpannableForText(context, readableMap, (ReactTextViewManagerCallback) null);
        TextPaint textPaint = sTextPaintInstance;
        return FontMetricsUtil.getFontMetrics(orCreateSpannableForText, createLayout(orCreateSpannableForText, BoringLayout.isBoring(orCreateSpannableForText, textPaint), f, YogaMeasureMode.EXACTLY, readableMap2.hasKey("includeFontPadding") ? readableMap2.getBoolean("includeFontPadding") : true, TextAttributeProps.getTextBreakStrategy(readableMap2.getString("textBreakStrategy")), TextAttributeProps.getTextBreakStrategy(readableMap2.getString(HYPHENATION_FREQUENCY_KEY))), textPaint, context);
    }
}
