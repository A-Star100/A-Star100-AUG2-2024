package com.facebook.hermes.intl;

import android.icu.util.ULocale;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class LocaleObjectICU implements ILocaleObject<ULocale> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mIsDirty;
    private ULocale m_icuLocale;
    private ULocale.Builder m_icuLocaleBuilder;

    private LocaleObjectICU(ULocale uLocale) {
        this.m_icuLocaleBuilder = null;
        this.mIsDirty = false;
        this.m_icuLocale = uLocale;
    }

    private LocaleObjectICU(String str) throws JSRangeErrorException {
        this.m_icuLocale = null;
        this.m_icuLocaleBuilder = null;
        this.mIsDirty = false;
        ULocale.Builder m = Intl$$ExternalSyntheticApiModelOutline0.m();
        this.m_icuLocaleBuilder = m;
        try {
            ULocale.Builder unused = m.setLanguageTag(str);
            this.mIsDirty = true;
        } catch (RuntimeException e) {
            throw new JSRangeErrorException(e.getMessage());
        }
    }

    private void ensureNotDirty() throws JSRangeErrorException {
        if (this.mIsDirty) {
            try {
                this.m_icuLocale = Intl$$ExternalSyntheticApiModelOutline0.m(this.m_icuLocaleBuilder);
                this.mIsDirty = false;
            } catch (RuntimeException e) {
                throw new JSRangeErrorException(e.getMessage());
            }
        }
    }

    public ArrayList<String> getUnicodeExtensions(String str) throws JSRangeErrorException {
        ensureNotDirty();
        String CanonicalKeyToICUKey = UnicodeExtensionKeys.CanonicalKeyToICUKey(str);
        ArrayList<String> arrayList = new ArrayList<>();
        String m$2 = this.m_icuLocale.getKeywordValue(CanonicalKeyToICUKey);
        if (m$2 != null && !m$2.isEmpty()) {
            Collections.addAll(arrayList, m$2.split("-|_"));
        }
        return arrayList;
    }

    public HashMap<String, String> getUnicodeExtensions() throws JSRangeErrorException {
        ensureNotDirty();
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator m = Intl$$ExternalSyntheticApiModelOutline0.m(this.m_icuLocale);
        if (m != null) {
            while (m.hasNext()) {
                String str = (String) m.next();
                hashMap.put(UnicodeExtensionKeys.ICUKeyToCanonicalKey(str), this.m_icuLocale.getKeywordValue(str));
            }
        }
        return hashMap;
    }

    public void setUnicodeExtensions(String str, ArrayList<String> arrayList) throws JSRangeErrorException {
        ensureNotDirty();
        if (this.m_icuLocaleBuilder == null) {
            this.m_icuLocaleBuilder = Intl$$ExternalSyntheticApiModelOutline0.m().setLocale(this.m_icuLocale);
        }
        try {
            ULocale.Builder unused = this.m_icuLocaleBuilder.setUnicodeLocaleKeyword(str, TextUtils.join("-", arrayList));
            this.mIsDirty = true;
        } catch (RuntimeException e) {
            throw new JSRangeErrorException(e.getMessage());
        }
    }

    public ULocale getLocale() throws JSRangeErrorException {
        ensureNotDirty();
        return this.m_icuLocale;
    }

    public ULocale getLocaleWithoutExtensions() throws JSRangeErrorException {
        ensureNotDirty();
        ULocale.Builder m = Intl$$ExternalSyntheticApiModelOutline0.m();
        ULocale.Builder unused = m.setLocale(this.m_icuLocale);
        Intl$$ExternalSyntheticApiModelOutline0.m(m);
        return Intl$$ExternalSyntheticApiModelOutline0.m(m);
    }

    public String toCanonicalTag() throws JSRangeErrorException {
        return Intl$$ExternalSyntheticApiModelOutline0.m(getLocale());
    }

    public String toCanonicalTagWithoutExtensions() throws JSRangeErrorException {
        return Intl$$ExternalSyntheticApiModelOutline0.m(getLocaleWithoutExtensions());
    }

    public ILocaleObject<ULocale> cloneObject() throws JSRangeErrorException {
        ensureNotDirty();
        return new LocaleObjectICU(this.m_icuLocale);
    }

    public static ILocaleObject<ULocale> createFromLocaleId(String str) throws JSRangeErrorException {
        return new LocaleObjectICU(str);
    }

    public static ILocaleObject<ULocale> createFromULocale(ULocale uLocale) {
        return new LocaleObjectICU(uLocale);
    }

    public static ILocaleObject<ULocale> createDefault() {
        return new LocaleObjectICU(ULocale.getDefault(Intl$$ExternalSyntheticApiModelOutline0.m()));
    }
}
