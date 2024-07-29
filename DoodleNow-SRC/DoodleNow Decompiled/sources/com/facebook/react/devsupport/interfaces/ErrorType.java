package com.facebook.react.devsupport.interfaces;

public enum ErrorType {
    JS("JS"),
    NATIVE("Native");
    
    private final String name;

    public String getName() {
        return this.name;
    }

    private ErrorType(String str) {
        this.name = str;
    }
}
