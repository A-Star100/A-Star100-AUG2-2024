package com.onesignal.common.services;

import com.onesignal.debug.internal.logging.Logging;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/services/ServiceRegistrationReflection;", "T", "Lcom/onesignal/common/services/ServiceRegistration;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "obj", "Ljava/lang/Object;", "doesHaveAllParameters", "", "constructor", "Ljava/lang/reflect/Constructor;", "provider", "Lcom/onesignal/common/services/IServiceProvider;", "resolve", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ServiceRegistration.kt */
public final class ServiceRegistrationReflection<T> extends ServiceRegistration<T> {
    private final Class<?> clazz;
    private T obj;

    public ServiceRegistrationReflection(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.clazz = cls;
    }

    public Object resolve(IServiceProvider iServiceProvider) {
        Intrinsics.checkNotNullParameter(iServiceProvider, "provider");
        if (this.obj != null) {
            Logging.debug$default(ServiceProvider.Companion.getIndent() + "Already instantiated: " + this.obj, (Throwable) null, 2, (Object) null);
            return this.obj;
        }
        Constructor[] constructors = this.clazz.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "clazz.constructors");
        int length = constructors.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Constructor constructor = constructors[i];
            Intrinsics.checkNotNullExpressionValue(constructor, "constructor");
            if (doesHaveAllParameters(constructor, iServiceProvider)) {
                Logging.debug$default(ServiceProvider.Companion.getIndent() + "Found constructor: " + constructor, (Throwable) null, 2, (Object) null);
                List arrayList = new ArrayList();
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
                for (Type type : genericParameterTypes) {
                    if (type instanceof ParameterizedType) {
                        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "param.actualTypeArguments");
                        Type type2 = (Type) ArraysKt.firstOrNull((T[]) (Object[]) actualTypeArguments);
                        if (type2 instanceof WildcardType) {
                            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                            Intrinsics.checkNotNullExpressionValue(upperBounds, "argType.upperBounds");
                            Type type3 = (Type) ArraysKt.first((T[]) (Object[]) upperBounds);
                            if (type3 instanceof Class) {
                                arrayList.add(iServiceProvider.getAllServices((Class) type3));
                            } else {
                                arrayList.add((Object) null);
                            }
                        } else if (type2 instanceof Class) {
                            arrayList.add(iServiceProvider.getAllServices((Class) type2));
                        } else {
                            arrayList.add((Object) null);
                        }
                    } else if (type instanceof Class) {
                        arrayList.add(iServiceProvider.getService((Class) type));
                    } else {
                        arrayList.add((Object) null);
                    }
                }
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                this.obj = constructor.newInstance(Arrays.copyOf(array, array.length));
            } else {
                i++;
            }
        }
        return this.obj;
    }

    private final boolean doesHaveAllParameters(Constructor<?> constructor, IServiceProvider iServiceProvider) {
        Type[] genericParameterTypes = constructor.getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
        for (Type type : genericParameterTypes) {
            if (type instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "param.actualTypeArguments");
                Type type2 = (Type) ArraysKt.firstOrNull((T[]) (Object[]) actualTypeArguments);
                if (type2 instanceof WildcardType) {
                    Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                    Intrinsics.checkNotNullExpressionValue(upperBounds, "argType.upperBounds");
                    Type type3 = (Type) ArraysKt.first((T[]) (Object[]) upperBounds);
                    if ((type3 instanceof Class) && !iServiceProvider.hasService((Class) type3)) {
                        Logging.debug$default("Constructor " + constructor + " could not find service: " + type3, (Throwable) null, 2, (Object) null);
                        return false;
                    }
                } else {
                    if (type2 instanceof Class) {
                        if (!iServiceProvider.hasService((Class) type2)) {
                            Logging.debug$default("Constructor " + constructor + " could not find service: " + type2, (Throwable) null, 2, (Object) null);
                        }
                    }
                    return false;
                }
            } else if (!(type instanceof Class)) {
                Logging.debug$default("Constructor " + constructor + " could not identify param type: " + type, (Throwable) null, 2, (Object) null);
                return false;
            } else if (!iServiceProvider.hasService((Class) type)) {
                Logging.debug$default("Constructor " + constructor + " could not find service: " + type, (Throwable) null, 2, (Object) null);
                return false;
            }
        }
        return true;
    }
}
