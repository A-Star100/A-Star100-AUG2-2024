package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/PropertyOperationHelper;", "", "()V", "createPropertiesFromOperation", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "operation", "Lcom/onesignal/user/internal/operations/DeleteTagOperation;", "propertiesObject", "Lcom/onesignal/user/internal/operations/SetPropertyOperation;", "Lcom/onesignal/user/internal/operations/SetTagOperation;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PropertyOperationHelper.kt */
public final class PropertyOperationHelper {
    public static final PropertyOperationHelper INSTANCE = new PropertyOperationHelper();

    private PropertyOperationHelper() {
    }

    public final PropertiesObject createPropertiesFromOperation(SetTagOperation setTagOperation, PropertiesObject propertiesObject) {
        Intrinsics.checkNotNullParameter(setTagOperation, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject, "propertiesObject");
        Map<String, String> tags = propertiesObject.getTags();
        Map<String, String> mutableMap = tags != null ? MapsKt.toMutableMap(tags) : null;
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap<>();
        }
        Map<String, String> map = mutableMap;
        map.put(setTagOperation.getKey(), setTagOperation.getValue());
        return new PropertiesObject(map, propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }

    public final PropertiesObject createPropertiesFromOperation(DeleteTagOperation deleteTagOperation, PropertiesObject propertiesObject) {
        Intrinsics.checkNotNullParameter(deleteTagOperation, "operation");
        Intrinsics.checkNotNullParameter(propertiesObject, "propertiesObject");
        Map<String, String> tags = propertiesObject.getTags();
        Map<String, String> mutableMap = tags != null ? MapsKt.toMutableMap(tags) : null;
        if (mutableMap == null) {
            mutableMap = new LinkedHashMap<>();
        }
        Map<String, String> map = mutableMap;
        map.put(deleteTagOperation.getKey(), (Object) null);
        return new PropertiesObject(map, propertiesObject.getLanguage(), propertiesObject.getTimezoneId(), propertiesObject.getCountry(), propertiesObject.getLatitude(), propertiesObject.getLongitude());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.lang.Double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: java.lang.Double} */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.onesignal.user.internal.backend.PropertiesObject createPropertiesFromOperation(com.onesignal.user.internal.operations.SetPropertyOperation r20, com.onesignal.user.internal.backend.PropertiesObject r21) {
        /*
            r19 = this;
            java.lang.String r0 = "operation"
            r1 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "propertiesObject"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = r20.getProperty()
            java.lang.String r3 = "language"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            r4 = 0
            if (r3 == 0) goto L_0x0042
            com.onesignal.user.internal.backend.PropertiesObject r0 = new com.onesignal.user.internal.backend.PropertiesObject
            java.util.Map r6 = r21.getTags()
            java.lang.Object r1 = r20.getValue()
            if (r1 == 0) goto L_0x002b
            java.lang.String r4 = r1.toString()
        L_0x002b:
            r7 = r4
            java.lang.String r8 = r21.getTimezoneId()
            java.lang.String r9 = r21.getCountry()
            java.lang.Double r10 = r21.getLatitude()
            java.lang.Double r11 = r21.getLongitude()
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            goto L_0x012e
        L_0x0042:
            java.lang.String r3 = "timezone"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0071
            com.onesignal.user.internal.backend.PropertiesObject r0 = new com.onesignal.user.internal.backend.PropertiesObject
            java.util.Map r6 = r21.getTags()
            java.lang.String r7 = r21.getLanguage()
            java.lang.Object r1 = r20.getValue()
            if (r1 == 0) goto L_0x005e
            java.lang.String r4 = r1.toString()
        L_0x005e:
            r8 = r4
            java.lang.String r9 = r21.getCountry()
            java.lang.Double r10 = r21.getLatitude()
            java.lang.Double r11 = r21.getLongitude()
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            goto L_0x012e
        L_0x0071:
            java.lang.String r3 = "country"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00a0
            com.onesignal.user.internal.backend.PropertiesObject r0 = new com.onesignal.user.internal.backend.PropertiesObject
            java.util.Map r6 = r21.getTags()
            java.lang.String r7 = r21.getLanguage()
            java.lang.String r8 = r21.getTimezoneId()
            java.lang.Object r1 = r20.getValue()
            if (r1 == 0) goto L_0x0091
            java.lang.String r4 = r1.toString()
        L_0x0091:
            r9 = r4
            java.lang.Double r10 = r21.getLatitude()
            java.lang.Double r11 = r21.getLongitude()
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            goto L_0x012e
        L_0x00a0:
            java.lang.String r3 = "locationLatitude"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00d8
            com.onesignal.user.internal.backend.PropertiesObject r0 = new com.onesignal.user.internal.backend.PropertiesObject
            java.util.Map r6 = r21.getTags()
            java.lang.String r7 = r21.getLanguage()
            java.lang.String r8 = r21.getTimezoneId()
            java.lang.String r9 = r21.getCountry()
            java.lang.Object r1 = r20.getValue()
            if (r1 == 0) goto L_0x00ce
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x00ce
            double r3 = java.lang.Double.parseDouble(r1)
            java.lang.Double r4 = java.lang.Double.valueOf(r3)
        L_0x00ce:
            r10 = r4
            java.lang.Double r11 = r21.getLongitude()
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            goto L_0x012e
        L_0x00d8:
            java.lang.String r3 = "locationLongitude"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0110
            com.onesignal.user.internal.backend.PropertiesObject r0 = new com.onesignal.user.internal.backend.PropertiesObject
            java.util.Map r6 = r21.getTags()
            java.lang.String r7 = r21.getLanguage()
            java.lang.String r8 = r21.getTimezoneId()
            java.lang.String r9 = r21.getCountry()
            java.lang.Double r10 = r21.getLatitude()
            java.lang.Object r1 = r20.getValue()
            if (r1 == 0) goto L_0x010a
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x010a
            double r1 = java.lang.Double.parseDouble(r1)
            java.lang.Double r4 = java.lang.Double.valueOf(r1)
        L_0x010a:
            r11 = r4
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            goto L_0x012e
        L_0x0110:
            com.onesignal.user.internal.backend.PropertiesObject r0 = new com.onesignal.user.internal.backend.PropertiesObject
            java.util.Map r13 = r21.getTags()
            java.lang.String r14 = r21.getLanguage()
            java.lang.String r15 = r21.getTimezoneId()
            java.lang.String r16 = r21.getCountry()
            java.lang.Double r17 = r21.getLatitude()
            java.lang.Double r18 = r21.getLongitude()
            r12 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18)
        L_0x012e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.operations.impl.executors.PropertyOperationHelper.createPropertiesFromOperation(com.onesignal.user.internal.operations.SetPropertyOperation, com.onesignal.user.internal.backend.PropertiesObject):com.onesignal.user.internal.backend.PropertiesObject");
    }
}
