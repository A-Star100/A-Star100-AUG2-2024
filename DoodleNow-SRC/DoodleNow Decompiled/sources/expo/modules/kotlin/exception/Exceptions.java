package expo.modules.kotlin.exception;

import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.permissions.Permissions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions;", "", "()V", "AppContextLost", "FileSystemModuleNotFound", "IncorrectThreadException", "MissingActivity", "MissingPermissions", "MissingRootView", "ModuleNotFound", "PermissionsModuleNotFound", "ReactContextLost", "SimulatorNotSupported", "ViewNotFound", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CommonExceptions.kt */
public final class Exceptions {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ViewNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "viewType", "Lkotlin/reflect/KClass;", "viewTag", "", "(Lkotlin/reflect/KClass;I)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class ViewNotFound extends CodedException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewNotFound(KClass<?> kClass, int i) {
            super("Unable to find the " + kClass + " view with tag " + i, (Throwable) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(kClass, "viewType");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$AppContextLost;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class AppContextLost extends CodedException {
        public AppContextLost() {
            super("The app context has been lost", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ReactContextLost;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class ReactContextLost extends CodedException {
        public ReactContextLost() {
            super("The react context has been lost", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$ModuleNotFound;", "Lexpo/modules/kotlin/exception/CodedException;", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static class ModuleNotFound extends CodedException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ModuleNotFound(KClass<?> kClass) {
            super(kClass + " module not found, make sure that everything is linked correctly", (Throwable) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(kClass, "clazz");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$PermissionsModuleNotFound;", "Lexpo/modules/kotlin/exception/Exceptions$ModuleNotFound;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class PermissionsModuleNotFound extends ModuleNotFound {
        public PermissionsModuleNotFound() {
            super(Reflection.getOrCreateKotlinClass(Permissions.class));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$FileSystemModuleNotFound;", "Lexpo/modules/kotlin/exception/Exceptions$ModuleNotFound;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class FileSystemModuleNotFound extends ModuleNotFound {
        public FileSystemModuleNotFound() {
            super(Reflection.getOrCreateKotlinClass(FilePermissionModuleInterface.class));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$SimulatorNotSupported;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class SimulatorNotSupported extends CodedException {
        public SimulatorNotSupported() {
            super("This operation is not supported on the simulator", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingPermissions;", "Lexpo/modules/kotlin/exception/CodedException;", "permissions", "", "", "([Ljava/lang/String;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class MissingPermissions extends CodedException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public MissingPermissions(java.lang.String... r11) {
            /*
                r10 = this;
                java.lang.String r0 = "permissions"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.String r0 = ", "
                r2 = r0
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 62
                r9 = 0
                r1 = r11
                java.lang.String r11 = kotlin.collections.ArraysKt.joinToString$default((java.lang.Object[]) r1, (java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (int) r5, (java.lang.CharSequence) r6, (kotlin.jvm.functions.Function1) r7, (int) r8, (java.lang.Object) r9)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Missing permissions: "
                r0.<init>(r1)
                r0.append(r11)
                java.lang.String r11 = r0.toString()
                r0 = 0
                r1 = 2
                r10.<init>(r11, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.exception.Exceptions.MissingPermissions.<init>(java.lang.String[]):void");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingActivity;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class MissingActivity extends CodedException {
        public MissingActivity() {
            super("The current activity is no longer available", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$IncorrectThreadException;", "Lexpo/modules/kotlin/exception/CodedException;", "currentThreadName", "", "expectedThreadName", "(Ljava/lang/String;Ljava/lang/String;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class IncorrectThreadException extends CodedException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncorrectThreadException(String str, String str2) {
            super("Expected to run on " + str2 + " thread, but was run on " + str, (Throwable) null, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "currentThreadName");
            Intrinsics.checkNotNullParameter(str2, "expectedThreadName");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/exception/Exceptions$MissingRootView;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CommonExceptions.kt */
    public static final class MissingRootView extends CodedException {
        public MissingRootView() {
            super("The root view is missing", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }
}
