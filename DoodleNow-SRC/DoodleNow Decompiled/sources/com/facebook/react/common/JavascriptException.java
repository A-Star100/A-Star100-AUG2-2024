package com.facebook.react.common;

import javax.annotation.Nullable;

public class JavascriptException extends RuntimeException implements HasJavascriptExceptionMetadata {
    @Nullable
    private String extraDataAsJson;

    @Nullable
    public String getExtraDataAsJson() {
        return this.extraDataAsJson;
    }

    public JavascriptException setExtraDataAsJson(@Nullable String str) {
        this.extraDataAsJson = str;
        return this;
    }

    public JavascriptException(String str) {
        super(str);
    }
}
