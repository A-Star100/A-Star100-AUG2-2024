package io.nlopez.smartlocation.utils;

public interface Logger {
    void d(String str, Object... objArr);

    void d(Throwable th, String str, Object... objArr);

    void e(String str, Object... objArr);

    void e(Throwable th, String str, Object... objArr);

    void i(String str, Object... objArr);

    void i(Throwable th, String str, Object... objArr);

    void v(String str, Object... objArr);

    void v(Throwable th, String str, Object... objArr);

    void w(String str, Object... objArr);

    void w(Throwable th, String str, Object... objArr);
}
