package expo.modules.interfaces.constants;

import java.util.List;
import java.util.Map;

public interface ConstantsInterface {
    String getAppScopeKey();

    Map<String, Object> getConstants();

    String getDeviceName();

    int getStatusBarHeight();

    List<String> getSystemFonts();

    String getSystemVersion();
}
