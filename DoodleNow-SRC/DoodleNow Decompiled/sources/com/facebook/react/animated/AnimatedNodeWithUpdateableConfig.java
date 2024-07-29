package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

interface AnimatedNodeWithUpdateableConfig {
    void onUpdateConfig(ReadableMap readableMap);
}
