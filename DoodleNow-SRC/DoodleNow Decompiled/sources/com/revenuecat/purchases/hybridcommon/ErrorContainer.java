package com.revenuecat.purchases.hybridcommon;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/ErrorContainer;", "", "code", "", "message", "", "info", "", "(ILjava/lang/String;Ljava/util/Map;)V", "getCode", "()I", "getInfo", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "hybridcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
public final class ErrorContainer {
    private final int code;
    private final Map<String, Object> info;
    private final String message;

    public static /* synthetic */ ErrorContainer copy$default(ErrorContainer errorContainer, int i, String str, Map<String, Object> map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = errorContainer.code;
        }
        if ((i2 & 2) != 0) {
            str = errorContainer.message;
        }
        if ((i2 & 4) != 0) {
            map = errorContainer.info;
        }
        return errorContainer.copy(i, str, map);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final Map<String, Object> component3() {
        return this.info;
    }

    public final ErrorContainer copy(int i, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(map, "info");
        return new ErrorContainer(i, str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorContainer)) {
            return false;
        }
        ErrorContainer errorContainer = (ErrorContainer) obj;
        return this.code == errorContainer.code && Intrinsics.areEqual((Object) this.message, (Object) errorContainer.message) && Intrinsics.areEqual((Object) this.info, (Object) errorContainer.info);
    }

    public final int getCode() {
        return this.code;
    }

    public final Map<String, Object> getInfo() {
        return this.info;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (((this.code * 31) + this.message.hashCode()) * 31) + this.info.hashCode();
    }

    public String toString() {
        return "ErrorContainer(code=" + this.code + ", message=" + this.message + ", info=" + this.info + ')';
    }

    public ErrorContainer(int i, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(map, "info");
        this.code = i;
        this.message = str;
        this.info = map;
    }
}
