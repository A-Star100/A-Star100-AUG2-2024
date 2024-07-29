package com.facebook.react.views.text.internal.span;

public class ReactTagSpan implements ReactSpan {
    private final int mReactTag;

    public int getReactTag() {
        return this.mReactTag;
    }

    public ReactTagSpan(int i) {
        this.mReactTag = i;
    }
}
