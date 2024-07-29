package com.amazon.a.a.b;

import android.app.Application;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.a;
import com.amazon.a.a.k.d;
import com.amazon.a.a.o.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: CrashManagerImpl */
public class b implements a, d, Thread.UncaughtExceptionHandler {
    private static final c a = new c("CrashManagerImpl");
    private static final String b = "s-";
    private static final String c = ".amzst";
    private static final int d = 99999;
    private static final int e = 5;
    @a
    private f f;
    @a
    private Application g;
    private Thread.UncaughtExceptionHandler h;
    /* access modifiers changed from: private */
    public Map<c, String> i = new HashMap();

    public void e() {
        com.amazon.a.a.o.a.a.a();
        b();
    }

    private void b() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof a)) {
            if (c.a) {
                a.a("Registering Crash Handler");
            }
            this.h = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (c.a) {
            a.a("Crash detected", th);
        }
        try {
            a(th);
            this.f.a((com.amazon.a.a.c.a) new com.amazon.a.a.b.a.a());
        } catch (Throwable th2) {
            if (c.a) {
                a.a("Error occured while handling exception", th2);
            }
        }
        if (c.a) {
            a.a("Calling previous handler");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.h;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void a(Throwable th) {
        try {
            a(a(new c(this.g, th)));
        } catch (Throwable th2) {
            if (c.b) {
                a.b("Could not handle uncaught exception", th2);
            }
        }
    }

    private String a(c cVar) {
        return com.amazon.a.a.o.c.a.a((Serializable) cVar);
    }

    private synchronized void a(String str) {
        int nextInt = new Random().nextInt(d);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.g.openFileOutput(b + nextInt + c, 0);
            fileOutputStream.write(str.getBytes());
        } catch (Exception e2) {
            try {
                if (c.b) {
                    a.b("Coud not save crash report to file", e2);
                }
            } catch (Throwable th) {
                com.amazon.a.a.o.a.a((OutputStream) fileOutputStream);
                throw th;
            }
        }
        com.amazon.a.a.o.a.a((OutputStream) fileOutputStream);
    }

    public List<c> a() {
        if (c()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String[] d2 = d();
        for (int i2 = 0; i2 < d2.length && !c(); i2++) {
            String e2 = e(d2[i2]);
            c b2 = b(e2);
            if (b2 != null) {
                this.i.put(b2, e2);
                arrayList.add(b2);
            } else {
                d(e2);
            }
        }
        return arrayList;
    }

    private boolean c() {
        return this.i.size() >= 5;
    }

    private c b(String str) {
        try {
            return (c) com.amazon.a.a.o.c.a.a(c(str));
        } catch (Exception unused) {
            if (!c.b) {
                return null;
            }
            c cVar = a;
            cVar.b("Failed to load crash report: " + str);
            return null;
        }
    }

    private String c(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (bufferedReader2.ready()) {
                try {
                    sb.append(bufferedReader2.readLine());
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.amazon.a.a.o.a.a((Reader) bufferedReader);
                    throw th;
                }
            }
            com.amazon.a.a.o.a.a((Reader) bufferedReader2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            com.amazon.a.a.o.a.a((Reader) bufferedReader);
            throw th;
        }
    }

    private String[] d() {
        return new File(this.g.getFilesDir().getAbsolutePath() + "/").list(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.endsWith(b.c) && !b.this.i.containsValue(str);
            }
        });
    }

    public void a(List<c> list) {
        for (c next : list) {
            d(this.i.get(next));
            this.i.remove(next);
        }
    }

    private void d(String str) {
        try {
            new File(str).delete();
        } catch (Exception e2) {
            if (c.b) {
                c cVar = a;
                cVar.b("Cannot delete file: " + str, e2);
            }
        }
    }

    private String e(String str) {
        return this.g.getFilesDir().getAbsolutePath() + "/" + str;
    }
}
