package com.facebook.react.views.text.fragments;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/views/text/fragments/BridgeTextFragmentList;", "Lcom/facebook/react/views/text/fragments/TextFragmentList;", "fragments", "Lcom/facebook/react/bridge/ReadableArray;", "(Lcom/facebook/react/bridge/ReadableArray;)V", "count", "", "getCount", "()I", "getFragment", "Lcom/facebook/react/views/text/fragments/TextFragment;", "index", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BridgeTextFragmentList.kt */
public final class BridgeTextFragmentList implements TextFragmentList {
    private final ReadableArray fragments;

    public BridgeTextFragmentList(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "fragments");
        this.fragments = readableArray;
    }

    public TextFragment getFragment(int i) {
        ReadableMap map = this.fragments.getMap(i);
        Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
        return new BridgeTextFragment(map);
    }

    public int getCount() {
        return this.fragments.size();
    }
}
