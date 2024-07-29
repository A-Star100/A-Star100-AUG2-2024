package com.reactnativegooglesignin;

import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/reactnativegooglesignin/ErrorDto;", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errCodeFallback", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "code", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "react-native-google-signin_google-signin_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ErrorDto.kt */
public final class ErrorDto {
    private String code;
    private String message;

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public ErrorDto(Exception exc, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(exc, "e");
        String localizedMessage = exc.getLocalizedMessage();
        localizedMessage = localizedMessage == null ? exc.getMessage() : localizedMessage;
        if (exc instanceof ApiException) {
            ApiException apiException = (ApiException) exc;
            int statusCode = apiException.getStatusCode();
            if (localizedMessage == null || localizedMessage.length() <= 10 || localizedMessage == null) {
                str2 = GoogleSignInStatusCodes.getStatusCodeString(statusCode);
                Intrinsics.checkNotNullExpressionValue(str2, "getStatusCodeString(...)");
            } else {
                str2 = new Regex(statusCode + ": ").replaceFirst(localizedMessage, "");
            }
            this.code = String.valueOf((statusCode == 12501 || apiException.getStatus().isCanceled()) ? 12501 : statusCode);
            this.message = str2;
        } else if (exc instanceof UnsupportedApiCallException) {
            this.code = str;
            this.message = localizedMessage + " Make sure you have the latest version of Google Play Services installed.";
        } else {
            this.code = str;
            this.message = localizedMessage;
        }
    }
}
