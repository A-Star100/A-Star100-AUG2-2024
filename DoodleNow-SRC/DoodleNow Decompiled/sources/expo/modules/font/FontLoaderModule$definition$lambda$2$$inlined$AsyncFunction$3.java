package expo.modules.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import expo.modules.interfaces.font.FontManagerInterface;
import expo.modules.kotlin.exception.Exceptions;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "P1", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$8"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$3 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ FontLoaderModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontLoaderModule$definition$lambda$2$$inlined$AsyncFunction$3(FontLoaderModule fontLoaderModule) {
        super(1);
        this.this$0 = fontLoaderModule;
    }

    public final Unit invoke(Object[] objArr) {
        Typeface typeface;
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        String str2 = objArr[1];
        String str3 = str;
        Context reactContext = this.this$0.getAppContext().getReactContext();
        if (reactContext != null) {
            Object obj = null;
            if (StringsKt.startsWith$default(str2, "asset://", false, 2, (Object) null)) {
                AssetManager assets = reactContext.getAssets();
                String substring = str2.substring(9);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                typeface = Typeface.createFromAsset(assets, substring);
                Intrinsics.checkNotNull(typeface);
            } else {
                String path = Uri.parse(str2).getPath();
                if (path != null) {
                    typeface = Typeface.createFromFile(new File(path));
                    Intrinsics.checkNotNull(typeface);
                } else {
                    throw new FileNotFoundException(str2);
                }
            }
            try {
                obj = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(FontManagerInterface.class);
            } catch (Exception unused) {
            }
            FontManagerInterface fontManagerInterface = (FontManagerInterface) obj;
            if (fontManagerInterface != null) {
                String prefix = this.this$0.getPrefix();
                fontManagerInterface.setTypeface(prefix + str3, 0, typeface);
                return Unit.INSTANCE;
            }
            throw new FontManagerInterfaceNotFoundException();
        }
        throw new Exceptions.ReactContextLost();
    }
}
