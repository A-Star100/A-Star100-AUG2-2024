package com.facebook.react.views.text.internal;

import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;

public abstract class ReactTextInlineImageShadowNode extends LayoutShadowNode {
    public abstract TextInlineImageSpan buildInlineImageSpan();
}
