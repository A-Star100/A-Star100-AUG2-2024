package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.StringOpsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0017J\b\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000b¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/json/JsonLiteral;", "Lkotlinx/serialization/json/JsonPrimitive;", "body", "", "isString", "", "(Ljava/lang/Object;Z)V", "content", "", "getContent", "()Ljava/lang/String;", "()Z", "equals", "other", "hashCode", "", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JsonElement.kt */
public final class JsonLiteral extends JsonPrimitive {
    private final String content;
    private final boolean isString;

    public String getContent() {
        return this.content;
    }

    public boolean isString() {
        return this.isString;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonLiteral(Object obj, boolean z) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(obj, TtmlNode.TAG_BODY);
        this.isString = z;
        this.content = obj.toString();
    }

    public String toString() {
        if (!isString()) {
            return getContent();
        }
        StringBuilder sb = new StringBuilder();
        StringOpsKt.printQuoted(sb, getContent());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(getClass()), (Object) Reflection.getOrCreateKotlinClass(obj.getClass()))) {
            return false;
        }
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        return isString() == jsonLiteral.isString() && Intrinsics.areEqual((Object) getContent(), (Object) jsonLiteral.getContent());
    }

    public int hashCode() {
        return (UByte$$ExternalSyntheticBackport0.m(isString()) * 31) + getContent().hashCode();
    }
}
