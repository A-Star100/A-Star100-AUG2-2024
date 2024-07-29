package com.amazon.a.a.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.amazon.a.a.i.c;
import com.amazon.a.a.i.h;
import com.amazon.a.a.k.d;
import com.amazon.a.a.o.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/* compiled from: ShutdownPrompt */
public class g extends h implements d {
    public static final long b = 31536000;
    private static final c e = new c("ShutdownPrompt");
    private static final String f = "https://www.amazon.com/appstore-error-help";
    private static final String g = "badcert";
    private static final String h = "1.1";
    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a i;
    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c j;

    /* access modifiers changed from: protected */
    public long h() {
        return b;
    }

    public String toString() {
        return "ShutdownPrompt";
    }

    public g(c cVar) {
        super(cVar, h.a.EXTENDED);
        e.a("new ShutdownPrompt called!");
    }

    /* access modifiers changed from: protected */
    public void i() {
        a(0);
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        c cVar = e;
        cVar.a("doAction(" + i2 + ")");
        c.a[] c = this.c.c();
        c.a aVar = c.a.DEFAULT;
        if (i2 < c.length) {
            aVar = c[i2];
        }
        if (aVar == c.a.HELP) {
            cVar.a("doAction() help");
            m();
        } else if (aVar == c.a.DEEPLINK) {
            cVar.a("doAction() deeplink");
            a(g);
        } else if (aVar == c.a.DEFAULT) {
            b(this.i);
        }
    }

    public void b() {
        this.i.g();
    }

    /* access modifiers changed from: private */
    public static void b(com.amazon.a.a.a.a aVar) {
        com.amazon.a.a.o.c cVar = e;
        cVar.a("doShutdown()");
        cVar.c("Killing application");
        System.exit(0);
    }

    /* access modifiers changed from: protected */
    public void m() {
        com.amazon.a.a.o.c cVar = e;
        cVar.a("Store contains " + this.j.toString());
        if (!this.c.i()) {
            cVar.a("Should not show fixup");
            new a(this.i).execute(new Void[0]);
            return;
        }
        cVar.a("Should show fixup");
        Activity a2 = this.i.a();
        a((Context) a2, a((Context) a2));
        cVar.a("Attempted to start browser.");
    }

    private final Intent a(Context context) {
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder(f);
        PackageManager packageManager = context.getPackageManager();
        a(sb, "?k=", h);
        a(sb, "&m=", this.c.e());
        a(sb, "&ec=", String.valueOf(this.c.g()));
        String str = (String) this.j.a(com.amazon.a.a.m.c.f);
        if (str != null) {
            a(sb, "&t=", str);
            a(sb, "&tv=", str, packageManager);
        }
        String str2 = (String) this.j.a(com.amazon.a.a.m.c.g);
        if (str2 != null) {
            a(sb, "&c=", str2);
        }
        String str3 = (String) this.j.a(com.amazon.a.a.m.c.d);
        if (str3 != null) {
            a(sb, "&e=", str3);
        }
        String str4 = Build.PRODUCT;
        if (str4 != null) {
            a(sb, "&d=", str4);
        }
        String str5 = Build.MANUFACTURER;
        if (str5 != null) {
            a(sb, "&ma=", str5);
        }
        String str6 = Build.MODEL;
        if (str6 != null) {
            a(sb, "&mo=", str6);
        }
        String str7 = Build.ID;
        if (str7 != null) {
            a(sb, "&bn=", str7);
        }
        a(sb, "&sz=", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
        a(sb, "&s=", String.valueOf(Build.VERSION.SDK_INT));
        a(sb, "&p=", packageName);
        a(sb, "&pv=", packageName, packageManager);
        a(sb, "&l=", n());
        String b2 = b(context);
        if (!TextUtils.isEmpty(b2)) {
            a(sb, "&mc=", b2);
        }
        String sb2 = sb.toString();
        com.amazon.a.a.o.c cVar = e;
        cVar.a("Starting browser for uri " + sb2);
        return new Intent("android.intent.action.VIEW", Uri.parse(sb2));
    }

    private final void a(StringBuilder sb, String str, String str2, PackageManager packageManager) {
        try {
            a(sb, str, String.valueOf(packageManager.getPackageInfo(str2, 0).versionCode));
        } catch (PackageManager.NameNotFoundException unused) {
            com.amazon.a.a.o.c cVar = e;
            cVar.b("Could not find information for package " + str2);
        }
    }

    private final void a(StringBuilder sb, String str, String str2) {
        try {
            String encode = URLEncoder.encode(str2, "UTF-8");
            sb.append(str);
            sb.append(encode);
        } catch (UnsupportedEncodingException e2) {
            e.b("Failed to URL-encode argument", e2);
        }
    }

    private String n() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }

    private String b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        if (telephonyManager == null) {
            e.a("tm was null!");
            return null;
        }
        com.amazon.a.a.o.c cVar = e;
        cVar.a("tm was not null.");
        int simState = telephonyManager.getSimState();
        if (simState == 5) {
            return telephonyManager.getSimOperator();
        }
        cVar.a("SIM not ready, returning null.  State was " + simState);
        return null;
    }

    private void a(String str) {
        e.a("Attempting to deep link to appstore.");
        Activity a2 = this.i.a();
        a((Context) a2, a((Context) a2, str));
    }

    private Intent a(Context context, String str) {
        String packageName = context.getPackageName();
        return new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/android?p=" + packageName + "&ref=" + str));
    }

    private void a(Context context, Intent intent) {
        if (!b(context, intent)) {
            e.b("Could not start activity, nothing resolves for the given data.");
            b(this.i);
            return;
        }
        new b(context, this.i).execute(new Intent[]{intent});
    }

    private boolean b(Context context, Intent intent) {
        intent.addFlags(268435456);
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    /* compiled from: ShutdownPrompt */
    private static class a extends AsyncTask<Void, Void, Void> {
        private final com.amazon.a.a.a.a a;

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            return null;
        }

        private a(com.amazon.a.a.a.a aVar) {
            this.a = aVar;
        }

        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            g.b(this.a);
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(c.a aVar) {
        Intent intent;
        if (aVar == c.a.DEFAULT) {
            return true;
        }
        Activity a2 = this.i.a();
        if (aVar == c.a.DEEPLINK) {
            intent = a((Context) a2, g);
        } else {
            intent = aVar == c.a.HELP ? a((Context) a2) : null;
        }
        if (intent != null) {
            return b(a2, intent);
        }
        com.amazon.a.a.o.c cVar = e;
        cVar.b("Unexpected action " + aVar + ", could not create intent.");
        return false;
    }

    /* compiled from: ShutdownPrompt */
    private static class b extends AsyncTask<Intent, Void, Void> {
        private final Context a;
        private final com.amazon.a.a.a.a b;

        private b(Context context, com.amazon.a.a.a.a aVar) {
            this.a = context;
            this.b = aVar;
        }

        /* renamed from: a */
        public Void doInBackground(Intent... intentArr) {
            this.a.startActivity(intentArr[0]);
            return null;
        }

        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            g.b(this.b);
        }
    }
}
