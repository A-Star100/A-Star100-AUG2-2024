package com.swmansion.rnscreens;

import android.util.Log;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSSearchBarManagerDelegate;
import com.facebook.react.viewmanagers.RNSSearchBarManagerInterface;
import com.swmansion.rnscreens.events.SearchBarBlurEvent;
import com.swmansion.rnscreens.events.SearchBarChangeTextEvent;
import com.swmansion.rnscreens.events.SearchBarCloseEvent;
import com.swmansion.rnscreens.events.SearchBarFocusEvent;
import com.swmansion.rnscreens.events.SearchBarOpenEvent;
import com.swmansion.rnscreens.events.SearchBarSearchButtonPressEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\b\u0007\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u00019B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0017J\u001f\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0002\u0010\"J\u001c\u0010#\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u001dH\u0017J\u001f\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0002\u0010\"J\u001a\u0010(\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u001dH\u0016J\u001a\u0010)\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u001dH\u0016J\u001f\u0010*\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0002\u0010\"J\u001a\u0010+\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010,\u001a\u0004\u0018\u00010\u0013H\u0017J\u001a\u0010-\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010$\u001a\u00020\u001dH\u0016J\u001a\u0010.\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0017J\u001a\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u00101\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u001dH\u0017J\u001c\u00103\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u00104\u001a\u0004\u0018\u00010\u0013H\u0016J\u001f\u00105\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010!H\u0017¢\u0006\u0002\u0010\"J!\u00106\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0002\u0010\"J\u001a\u00107\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u00108\u001a\u00020\u001dH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/SearchBarView;", "Lcom/facebook/react/viewmanagers/RNSSearchBarManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "blur", "", "view", "cancelSearch", "clearText", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "focus", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "logNotAvailable", "propName", "onAfterUpdateTransaction", "setAutoCapitalize", "autoCapitalize", "setAutoFocus", "autoFocus", "", "(Lcom/swmansion/rnscreens/SearchBarView;Ljava/lang/Boolean;)V", "setBarTintColor", "color", "", "(Lcom/swmansion/rnscreens/SearchBarView;Ljava/lang/Integer;)V", "setCancelButtonText", "value", "setDisableBackButtonOverride", "disableBackButtonOverride", "setHeaderIconColor", "setHideNavigationBar", "setHideWhenScrolling", "setHintTextColor", "setInputType", "inputType", "setObscureBackground", "setPlaceholder", "placeholder", "setPlacement", "setShouldShowHintSearchIcon", "shouldShowHintSearchIcon", "setText", "text", "setTextColor", "setTintColor", "toggleCancelButton", "flag", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ReactModule(name = "RNSSearchBar")
/* compiled from: SearchBarManager.kt */
public final class SearchBarManager extends ViewGroupManager<SearchBarView> implements RNSSearchBarManagerInterface<SearchBarView> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSSearchBar";
    private final ViewManagerDelegate<SearchBarView> delegate = new RNSSearchBarManagerDelegate(this);

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<SearchBarView> getDelegate() {
        return this.delegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public SearchBarView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new SearchBarView(themedReactContext);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(SearchBarView searchBarView) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        super.onAfterUpdateTransaction(searchBarView);
        searchBarView.onUpdate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r3.equals("none") != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Forbidden auto capitalize value passed");
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "autoCapitalize")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAutoCapitalize(com.swmansion.rnscreens.SearchBarView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0041
            int r0 = r3.hashCode()
            switch(r0) {
                case 3387192: goto L_0x0030;
                case 113318569: goto L_0x0025;
                case 490141296: goto L_0x001a;
                case 1245424234: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0039
        L_0x000f:
            java.lang.String r0 = "characters"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.CHARACTERS
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "sentences"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.SENTENCES
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "words"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.WORDS
            goto L_0x0043
        L_0x0030:
            java.lang.String r0 = "none"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden auto capitalize value passed"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            com.swmansion.rnscreens.SearchBarView$SearchBarAutoCapitalize r3 = com.swmansion.rnscreens.SearchBarView.SearchBarAutoCapitalize.NONE
        L_0x0043:
            r2.setAutoCapitalize(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setAutoCapitalize(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @ReactProp(name = "autoFocus")
    public final void setAutoFocus(SearchBarView searchBarView, Boolean bool) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setAutoFocus(bool != null ? bool.booleanValue() : false);
    }

    @ReactProp(customType = "Color", name = "barTintColor")
    public void setBarTintColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setTintColor(num);
    }

    @ReactProp(name = "disableBackButtonOverride")
    public void setDisableBackButtonOverride(SearchBarView searchBarView, boolean z) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        boolean z2 = true;
        if (z) {
            z2 = false;
        }
        searchBarView.setShouldOverrideBackButton(z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r3.equals("text") != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Forbidden input type value");
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "inputType")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInputType(com.swmansion.rnscreens.SearchBarView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x0041
            int r0 = r3.hashCode()
            switch(r0) {
                case -1034364087: goto L_0x002e;
                case 3556653: goto L_0x0025;
                case 96619420: goto L_0x001a;
                case 106642798: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0039
        L_0x000f:
            java.lang.String r0 = "phone"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.PHONE
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "email"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.EMAIL
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "text"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            goto L_0x0041
        L_0x002e:
            java.lang.String r0 = "number"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.NUMBER
            goto L_0x0043
        L_0x0039:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden input type value"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            com.swmansion.rnscreens.SearchBarView$SearchBarInputTypes r3 = com.swmansion.rnscreens.SearchBarView.SearchBarInputTypes.TEXT
        L_0x0043:
            r2.setInputType(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setInputType(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(SearchBarView searchBarView, String str) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        if (str != null) {
            searchBarView.setPlaceholder(str);
        }
    }

    @ReactProp(customType = "Color", name = "textColor")
    public void setTextColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setTextColor(num);
    }

    @ReactProp(customType = "Color", name = "headerIconColor")
    public void setHeaderIconColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setHeaderIconColor(num);
    }

    @ReactProp(customType = "Color", name = "hintTextColor")
    public void setHintTextColor(SearchBarView searchBarView, Integer num) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setHintTextColor(num);
    }

    @ReactProp(name = "shouldShowHintSearchIcon")
    public void setShouldShowHintSearchIcon(SearchBarView searchBarView, boolean z) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        searchBarView.setShouldShowHintSearchIcon(z);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(SearchBarBlurEvent.EVENT_NAME, MapBuilder.of("registrationName", "onSearchBlur"), SearchBarChangeTextEvent.EVENT_NAME, MapBuilder.of("registrationName", "onChangeText"), SearchBarCloseEvent.EVENT_NAME, MapBuilder.of("registrationName", "onClose"), SearchBarFocusEvent.EVENT_NAME, MapBuilder.of("registrationName", "onSearchFocus"), SearchBarOpenEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOpen"), SearchBarSearchButtonPressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onSearchButtonPress"));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/SearchBarManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SearchBarManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void logNotAvailable(String str) {
        Log.w("RN SCREENS", str + " prop is not available on Android");
    }

    public void blur(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleBlurJsRequest();
        }
    }

    public void focus(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleFocusJsRequest();
        }
    }

    public void clearText(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleClearTextJsRequest();
        }
    }

    public void toggleCancelButton(SearchBarView searchBarView, boolean z) {
        if (searchBarView != null) {
            searchBarView.handleToggleCancelButtonJsRequest(z);
        }
    }

    public void setText(SearchBarView searchBarView, String str) {
        if (searchBarView != null) {
            searchBarView.handleSetTextJsRequest(str);
        }
    }

    public void cancelSearch(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.handleFocusJsRequest();
        }
    }

    public void setPlacement(SearchBarView searchBarView, String str) {
        Intrinsics.checkNotNullParameter(searchBarView, "view");
        logNotAvailable("setPlacement");
    }

    public void setHideWhenScrolling(SearchBarView searchBarView, boolean z) {
        logNotAvailable("hideWhenScrolling");
    }

    public void setObscureBackground(SearchBarView searchBarView, boolean z) {
        logNotAvailable("hideNavigationBar");
    }

    public void setHideNavigationBar(SearchBarView searchBarView, boolean z) {
        logNotAvailable("hideNavigationBar");
    }

    public void setCancelButtonText(SearchBarView searchBarView, String str) {
        logNotAvailable("cancelButtonText");
    }

    public void setTintColor(SearchBarView searchBarView, Integer num) {
        logNotAvailable("tintColor");
    }
}
