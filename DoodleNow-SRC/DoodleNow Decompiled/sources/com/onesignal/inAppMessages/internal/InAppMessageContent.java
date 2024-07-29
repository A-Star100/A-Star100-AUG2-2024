package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000 )2\u00020\u0001:\u0001)B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001a\u0010&\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001c¨\u0006*"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "contentHtml", "", "getContentHtml", "()Ljava/lang/String;", "setContentHtml", "(Ljava/lang/String;)V", "displayDuration", "", "getDisplayDuration", "()Ljava/lang/Double;", "setDisplayDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "displayLocation", "Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "getDisplayLocation", "()Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;", "setDisplayLocation", "(Lcom/onesignal/inAppMessages/internal/display/impl/WebViewManager$Position;)V", "isFullBleed", "", "()Z", "setFullBleed", "(Z)V", "pageHeight", "", "getPageHeight", "()I", "setPageHeight", "(I)V", "useHeightMargin", "getUseHeightMargin", "setUseHeightMargin", "useWidthMargin", "getUseWidthMargin", "setUseWidthMargin", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageContent.kt */
public class InAppMessageContent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DISPLAY_DURATION = "display_duration";
    public static final String HTML = "html";
    public static final String REMOVE_HEIGHT_MARGIN = "remove_height_margin";
    public static final String REMOVE_WIDTH_MARGIN = "remove_width_margin";
    public static final String STYLES = "styles";
    private String contentHtml;
    private Double displayDuration;
    private WebViewManager.Position displayLocation;
    private boolean isFullBleed;
    private int pageHeight;
    private boolean useHeightMargin = true;
    private boolean useWidthMargin = true;

    public final String getContentHtml() {
        return this.contentHtml;
    }

    public final Double getDisplayDuration() {
        return this.displayDuration;
    }

    public final WebViewManager.Position getDisplayLocation() {
        return this.displayLocation;
    }

    public final int getPageHeight() {
        return this.pageHeight;
    }

    public final boolean getUseHeightMargin() {
        return this.useHeightMargin;
    }

    public final boolean getUseWidthMargin() {
        return this.useWidthMargin;
    }

    public final boolean isFullBleed() {
        return this.isFullBleed;
    }

    public final void setContentHtml(String str) {
        this.contentHtml = str;
    }

    public final void setDisplayDuration(Double d) {
        this.displayDuration = d;
    }

    public final void setDisplayLocation(WebViewManager.Position position) {
        this.displayLocation = position;
    }

    public final void setFullBleed(boolean z) {
        this.isFullBleed = z;
    }

    public final void setPageHeight(int i) {
        this.pageHeight = i;
    }

    public final void setUseHeightMargin(boolean z) {
        this.useHeightMargin = z;
    }

    public final void setUseWidthMargin(boolean z) {
        this.useWidthMargin = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0026, code lost:
        r2 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r4, REMOVE_HEIGHT_MARGIN);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InAppMessageContent(org.json.JSONObject r4) {
        /*
            r3 = this;
            java.lang.String r0 = "jsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.<init>()
            r0 = 1
            r3.useHeightMargin = r0
            r3.useWidthMargin = r0
            java.lang.String r1 = "html"
            java.lang.String r1 = com.onesignal.common.JSONObjectExtensionsKt.safeString(r4, r1)
            r3.contentHtml = r1
            java.lang.String r1 = "display_duration"
            java.lang.Double r1 = com.onesignal.common.JSONObjectExtensionsKt.safeDouble(r4, r1)
            r3.displayDuration = r1
            java.lang.String r1 = "styles"
            org.json.JSONObject r4 = com.onesignal.common.JSONObjectExtensionsKt.safeJSONObject(r4, r1)
            r1 = 0
            if (r4 == 0) goto L_0x0033
            java.lang.String r2 = "remove_height_margin"
            java.lang.Boolean r2 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r4, r2)
            if (r2 == 0) goto L_0x0033
            boolean r2 = r2.booleanValue()
            goto L_0x0034
        L_0x0033:
            r2 = r1
        L_0x0034:
            r2 = r2 ^ r0
            r3.useHeightMargin = r2
            if (r4 == 0) goto L_0x0045
            java.lang.String r2 = "remove_width_margin"
            java.lang.Boolean r4 = com.onesignal.common.JSONObjectExtensionsKt.safeBool(r4, r2)
            if (r4 == 0) goto L_0x0045
            boolean r1 = r4.booleanValue()
        L_0x0045:
            r4 = r1 ^ 1
            r3.useWidthMargin = r4
            boolean r4 = r3.useHeightMargin
            r4 = r4 ^ r0
            r3.isFullBleed = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessageContent.<init>(org.json.JSONObject):void");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageContent$Companion;", "", "()V", "DISPLAY_DURATION", "", "HTML", "REMOVE_HEIGHT_MARGIN", "REMOVE_WIDTH_MARGIN", "STYLES", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InAppMessageContent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
