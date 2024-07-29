package com.amazon.device.simplesignin;

import android.content.Context;
import android.util.Log;
import com.amazon.device.simplesignin.a.c;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import java.util.Map;

public final class SimpleSignInService {
    public static final String SDK_VERSION = "1.0.0";
    private static final String TAG = "SimpleSignInService";

    static {
        Log.i(TAG, "Amazon Simple Sign-In SDK initializing. SDK version : 1.0.0");
    }

    public static void registerResponseHandler(Context context, ISimpleSignInResponseHandler iSimpleSignInResponseHandler) {
        if (context == null) {
            throw new NullPointerException("appContext is marked non-null but is null");
        } else if (iSimpleSignInResponseHandler != null) {
            c.a().a(context, iSimpleSignInResponseHandler);
        } else {
            throw new NullPointerException("responseHandler is marked non-null but is null");
        }
    }

    public static RequestId getUserAndLinks(String str) {
        if (str != null) {
            return c.a().a(str);
        }
        throw new NullPointerException("identityProviderName is marked non-null but is null");
    }

    public static RequestId linkUserAccount(LinkUserAccountRequest linkUserAccountRequest) {
        if (linkUserAccountRequest != null) {
            return c.a().a(linkUserAccountRequest);
        }
        throw new NullPointerException("linkUserAccountRequest is marked non-null but is null");
    }

    public static RequestId showLoginSelection(Map<String, String> map) {
        if (map != null) {
            return c.a().a(map);
        }
        throw new NullPointerException("loginNames is marked non-null but is null");
    }

    public static RequestId unlinkUserAccount(String str) {
        if (str != null) {
            return c.a().b(str);
        }
        throw new NullPointerException("identityProviderName is marked non-null but is null");
    }

    public static String getSDKMode() {
        return c.a().b();
    }
}
