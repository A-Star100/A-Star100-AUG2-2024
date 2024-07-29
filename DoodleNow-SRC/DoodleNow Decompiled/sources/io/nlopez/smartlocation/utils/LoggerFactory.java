package io.nlopez.smartlocation.utils;

import android.util.Log;

public class LoggerFactory {
    public static Logger buildLogger(boolean z) {
        return z ? new Blabber() : new Sssht();
    }

    private static class Sssht implements Logger {
        public void d(String str, Object... objArr) {
        }

        public void d(Throwable th, String str, Object... objArr) {
        }

        public void e(String str, Object... objArr) {
        }

        public void e(Throwable th, String str, Object... objArr) {
        }

        public void i(String str, Object... objArr) {
        }

        public void i(Throwable th, String str, Object... objArr) {
        }

        public void v(String str, Object... objArr) {
        }

        public void v(Throwable th, String str, Object... objArr) {
        }

        public void w(String str, Object... objArr) {
        }

        public void w(Throwable th, String str, Object... objArr) {
        }

        private Sssht() {
        }
    }

    private static class Blabber implements Logger {
        private Blabber() {
        }

        private String getTag() {
            return new Exception().getStackTrace()[3].getMethodName();
        }

        private String formatMessage(String str, Object... objArr) {
            return objArr.length == 0 ? str : String.format(str, objArr);
        }

        public void v(String str, Object... objArr) {
            Log.v(getTag(), formatMessage(str, objArr));
        }

        public void v(Throwable th, String str, Object... objArr) {
            Log.v(getTag(), formatMessage(str, objArr), th);
        }

        public void d(String str, Object... objArr) {
            Log.d(getTag(), formatMessage(str, objArr));
        }

        public void d(Throwable th, String str, Object... objArr) {
            Log.d(getTag(), formatMessage(str, objArr), th);
        }

        public void i(String str, Object... objArr) {
            Log.i(getTag(), formatMessage(str, objArr));
        }

        public void i(Throwable th, String str, Object... objArr) {
            Log.i(getTag(), formatMessage(str, objArr), th);
        }

        public void w(String str, Object... objArr) {
            Log.w(getTag(), formatMessage(str, objArr));
        }

        public void w(Throwable th, String str, Object... objArr) {
            Log.w(getTag(), formatMessage(str, objArr), th);
        }

        public void e(String str, Object... objArr) {
            Log.e(getTag(), formatMessage(str, objArr));
        }

        public void e(Throwable th, String str, Object... objArr) {
            Log.e(getTag(), formatMessage(str, objArr), th);
        }
    }
}
