package com.facebook.react.fabric.internal.interop;

import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.fabric.interop.UIBlock;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/facebook/react/fabric/internal/interop/InteropUIBlockListener;", "Lcom/facebook/react/bridge/UIManagerListener;", "()V", "afterUIBlocks", "", "Lcom/facebook/react/fabric/interop/UIBlock;", "getAfterUIBlocks$ReactAndroid_release", "()Ljava/util/List;", "beforeUIBlocks", "getBeforeUIBlocks$ReactAndroid_release", "addUIBlock", "", "block", "didDispatchMountItems", "uiManager", "Lcom/facebook/react/bridge/UIManager;", "didMountItems", "didScheduleMountItems", "prependUIBlock", "willDispatchViewUpdates", "willMountItems", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InteropUiBlockListener.kt */
public final class InteropUIBlockListener implements UIManagerListener {
    private final List<UIBlock> afterUIBlocks = new ArrayList();
    private final List<UIBlock> beforeUIBlocks = new ArrayList();

    public void didScheduleMountItems(UIManager uIManager) {
        Intrinsics.checkNotNullParameter(uIManager, "uiManager");
    }

    public final List<UIBlock> getAfterUIBlocks$ReactAndroid_release() {
        return this.afterUIBlocks;
    }

    public final List<UIBlock> getBeforeUIBlocks$ReactAndroid_release() {
        return this.beforeUIBlocks;
    }

    public final synchronized void prependUIBlock(UIBlock uIBlock) {
        Intrinsics.checkNotNullParameter(uIBlock, "block");
        this.beforeUIBlocks.add(uIBlock);
    }

    public final synchronized void addUIBlock(UIBlock uIBlock) {
        Intrinsics.checkNotNullParameter(uIBlock, "block");
        this.afterUIBlocks.add(uIBlock);
    }

    public void willMountItems(UIManager uIManager) {
        Intrinsics.checkNotNullParameter(uIManager, "uiManager");
        if (!this.beforeUIBlocks.isEmpty()) {
            for (UIBlock uIBlock : this.beforeUIBlocks) {
                if (uIManager instanceof UIBlockViewResolver) {
                    uIBlock.execute((UIBlockViewResolver) uIManager);
                }
            }
            this.beforeUIBlocks.clear();
        }
    }

    public void didMountItems(UIManager uIManager) {
        Intrinsics.checkNotNullParameter(uIManager, "uiManager");
        if (!this.afterUIBlocks.isEmpty()) {
            for (UIBlock uIBlock : this.afterUIBlocks) {
                if (uIManager instanceof UIBlockViewResolver) {
                    uIBlock.execute((UIBlockViewResolver) uIManager);
                }
            }
            this.afterUIBlocks.clear();
        }
    }

    public void didDispatchMountItems(UIManager uIManager) {
        Intrinsics.checkNotNullParameter(uIManager, "uiManager");
        didMountItems(uIManager);
    }

    public void willDispatchViewUpdates(UIManager uIManager) {
        Intrinsics.checkNotNullParameter(uIManager, "uiManager");
        willMountItems(uIManager);
    }
}
