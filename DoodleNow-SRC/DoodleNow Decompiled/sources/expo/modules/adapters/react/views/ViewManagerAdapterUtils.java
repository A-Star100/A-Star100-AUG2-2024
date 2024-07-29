package expo.modules.adapters.react.views;

import com.facebook.react.uimanager.ViewProps;

public class ViewManagerAdapterUtils {
    public static String normalizeEventName(String str) {
        if (!str.startsWith("on")) {
            return str;
        }
        return ViewProps.TOP + str.substring(2);
    }
}
