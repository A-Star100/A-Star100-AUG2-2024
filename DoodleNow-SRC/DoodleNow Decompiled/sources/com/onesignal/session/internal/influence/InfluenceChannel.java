package com.onesignal.session.internal.influence;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003J\b\u0010\b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceChannel;", "", "nameValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "equalsName", "", "otherName", "toString", "IAM", "NOTIFICATION", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InfluenceChannel.kt */
public enum InfluenceChannel {
    IAM("iam"),
    NOTIFICATION(OneSignalDbContract.NotificationTable.TABLE_NAME);
    
    public static final Companion Companion = null;
    private final String nameValue;

    @JvmStatic
    public static final InfluenceChannel fromString(String str) {
        return Companion.fromString(str);
    }

    public String toString() {
        return this.nameValue;
    }

    private InfluenceChannel(String str) {
        this.nameValue = str;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public final boolean equalsName(String str) {
        Intrinsics.checkNotNullParameter(str, "otherName");
        return Intrinsics.areEqual((Object) this.nameValue, (Object) str);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/influence/InfluenceChannel$Companion;", "", "()V", "fromString", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "value", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InfluenceChannel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InfluenceChannel fromString(String str) {
            InfluenceChannel influenceChannel;
            if (str != null) {
                InfluenceChannel[] values = InfluenceChannel.values();
                int length = values.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        influenceChannel = values[length];
                        if (influenceChannel.equalsName(str)) {
                            break;
                        } else if (i < 0) {
                            break;
                        } else {
                            length = i;
                        }
                    }
                }
                influenceChannel = null;
                if (influenceChannel != null) {
                    return influenceChannel;
                }
            }
            return InfluenceChannel.NOTIFICATION;
        }
    }
}
