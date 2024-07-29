package com.rnmaps.maps;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import java.util.HashMap;

public class SizeReportingShadowNode extends LayoutShadowNode {
    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        HashMap hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(getLayoutWidth()));
        hashMap.put("height", Float.valueOf(getLayoutHeight()));
        uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), hashMap);
    }
}
