package expo.modules.kotlin;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\t\u001a(\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"safeGetParcelable", "T", "Landroid/os/Parcelable;", "Landroid/os/Bundle;", "name", "", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "safeGetParcelableExtra", "Landroid/content/Intent;", "(Landroid/content/Intent;Ljava/lang/String;)Landroid/os/Parcelable;", "safeGetSerializable", "Ljava/io/Serializable;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: AndroidExtensions.kt */
public final class AndroidExtensionsKt {
    public static final /* synthetic */ <T extends Parcelable> T safeGetParcelableExtra(Intent intent, String str) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (Build.VERSION.SDK_INT < 33) {
            return intent.getParcelableExtra(str);
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Parcelable> cls = Parcelable.class;
        Class cls2 = cls;
        return (Parcelable) intent.getParcelableExtra(str, cls);
    }

    public static final /* synthetic */ <T extends Parcelable> T safeGetParcelable(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (Build.VERSION.SDK_INT < 33) {
            return bundle.getParcelable(str);
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Parcelable> cls = Parcelable.class;
        Class cls2 = cls;
        return (Parcelable) Downloader$$ExternalSyntheticApiModelOutline0.m(bundle, str, (Class) cls);
    }

    public static final /* synthetic */ <T extends Serializable> T safeGetSerializable(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker(4, "T");
            Class<Serializable> cls = Serializable.class;
            Class cls2 = cls;
            return Downloader$$ExternalSyntheticApiModelOutline0.m(bundle, str, (Class) cls);
        }
        T serializable = bundle.getSerializable(str);
        Intrinsics.reifiedOperationMarker(1, "T?");
        Serializable serializable2 = (Serializable) serializable;
        Serializable serializable3 = (Serializable) serializable;
        return serializable;
    }
}
