package androidx.webkit.internal;

import java.net.URLConnection;

class MimeUtil {
    MimeUtil() {
    }

    public static String getMimeFromFileName(String str) {
        if (str == null) {
            return null;
        }
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        if (guessContentTypeFromName != null) {
            return guessContentTypeFromName;
        }
        return guessHardcodedMime(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r5.equals("mhtml") == false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String guessHardcodedMime(java.lang.String r5) {
        /*
            r0 = 46
            int r1 = r5.lastIndexOf(r0)
            r2 = 0
            r3 = -1
            if (r1 != r3) goto L_0x000b
            return r2
        L_0x000b:
            r4 = 1
            int r1 = r1 + r4
            java.lang.String r5 = r5.substring(r1)
            java.lang.String r5 = r5.toLowerCase()
            r5.hashCode()
            int r1 = r5.hashCode()
            switch(r1) {
                case 3315: goto L_0x02bf;
                case 3401: goto L_0x02b3;
                case 97669: goto L_0x02a7;
                case 98819: goto L_0x029b;
                case 102340: goto L_0x028f;
                case 103649: goto L_0x0283;
                case 104085: goto L_0x0277;
                case 105441: goto L_0x026b;
                case 106458: goto L_0x025d;
                case 106479: goto L_0x024f;
                case 108089: goto L_0x0241;
                case 108150: goto L_0x0233;
                case 108272: goto L_0x0225;
                case 108273: goto L_0x0217;
                case 108324: goto L_0x0209;
                case 109961: goto L_0x01fb;
                case 109967: goto L_0x01ed;
                case 109973: goto L_0x01df;
                case 109982: goto L_0x01d1;
                case 110834: goto L_0x01c3;
                case 111030: goto L_0x01b5;
                case 111145: goto L_0x01a7;
                case 114276: goto L_0x0199;
                case 114791: goto L_0x018b;
                case 114833: goto L_0x017d;
                case 117484: goto L_0x016e;
                case 118660: goto L_0x015f;
                case 118807: goto L_0x0150;
                case 120609: goto L_0x0141;
                case 3000872: goto L_0x0133;
                case 3145576: goto L_0x0125;
                case 3213227: goto L_0x0117;
                case 3259225: goto L_0x0109;
                case 3268712: goto L_0x00fb;
                case 3271912: goto L_0x00ed;
                case 3358085: goto L_0x00df;
                case 3418175: goto L_0x00d1;
                case 3529614: goto L_0x00c3;
                case 3542678: goto L_0x00b5;
                case 3559925: goto L_0x00a7;
                case 3642020: goto L_0x0098;
                case 3645337: goto L_0x008a;
                case 3645340: goto L_0x007c;
                case 3655064: goto L_0x006e;
                case 3678569: goto L_0x0060;
                case 96488848: goto L_0x0053;
                case 103877016: goto L_0x004a;
                case 106703064: goto L_0x003d;
                case 109418142: goto L_0x0030;
                case 114035747: goto L_0x0022;
                default: goto L_0x001f;
            }
        L_0x001f:
            r0 = r3
            goto L_0x02ca
        L_0x0022:
            java.lang.String r0 = "xhtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x002c
            goto L_0x001f
        L_0x002c:
            r0 = 49
            goto L_0x02ca
        L_0x0030:
            java.lang.String r0 = "shtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0039
            goto L_0x001f
        L_0x0039:
            r0 = 48
            goto L_0x02ca
        L_0x003d:
            java.lang.String r0 = "pjpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0046
            goto L_0x001f
        L_0x0046:
            r0 = 47
            goto L_0x02ca
        L_0x004a:
            java.lang.String r1 = "mhtml"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x02ca
            goto L_0x001f
        L_0x0053:
            java.lang.String r0 = "ehtml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x005c
            goto L_0x001f
        L_0x005c:
            r0 = 45
            goto L_0x02ca
        L_0x0060:
            java.lang.String r0 = "xhtm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x006a
            goto L_0x001f
        L_0x006a:
            r0 = 44
            goto L_0x02ca
        L_0x006e:
            java.lang.String r0 = "woff"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0078
            goto L_0x001f
        L_0x0078:
            r0 = 43
            goto L_0x02ca
        L_0x007c:
            java.lang.String r0 = "webp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0086
            goto L_0x001f
        L_0x0086:
            r0 = 42
            goto L_0x02ca
        L_0x008a:
            java.lang.String r0 = "webm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0094
            goto L_0x001f
        L_0x0094:
            r0 = 41
            goto L_0x02ca
        L_0x0098:
            java.lang.String r0 = "wasm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00a3
            goto L_0x001f
        L_0x00a3:
            r0 = 40
            goto L_0x02ca
        L_0x00a7:
            java.lang.String r0 = "tiff"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00b1
            goto L_0x001f
        L_0x00b1:
            r0 = 39
            goto L_0x02ca
        L_0x00b5:
            java.lang.String r0 = "svgz"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00bf
            goto L_0x001f
        L_0x00bf:
            r0 = 38
            goto L_0x02ca
        L_0x00c3:
            java.lang.String r0 = "shtm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00cd
            goto L_0x001f
        L_0x00cd:
            r0 = 37
            goto L_0x02ca
        L_0x00d1:
            java.lang.String r0 = "opus"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00db
            goto L_0x001f
        L_0x00db:
            r0 = 36
            goto L_0x02ca
        L_0x00df:
            java.lang.String r0 = "mpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00e9
            goto L_0x001f
        L_0x00e9:
            r0 = 35
            goto L_0x02ca
        L_0x00ed:
            java.lang.String r0 = "json"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x00f7
            goto L_0x001f
        L_0x00f7:
            r0 = 34
            goto L_0x02ca
        L_0x00fb:
            java.lang.String r0 = "jpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0105
            goto L_0x001f
        L_0x0105:
            r0 = 33
            goto L_0x02ca
        L_0x0109:
            java.lang.String r0 = "jfif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0113
            goto L_0x001f
        L_0x0113:
            r0 = 32
            goto L_0x02ca
        L_0x0117:
            java.lang.String r0 = "html"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0121
            goto L_0x001f
        L_0x0121:
            r0 = 31
            goto L_0x02ca
        L_0x0125:
            java.lang.String r0 = "flac"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x012f
            goto L_0x001f
        L_0x012f:
            r0 = 30
            goto L_0x02ca
        L_0x0133:
            java.lang.String r0 = "apng"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x013d
            goto L_0x001f
        L_0x013d:
            r0 = 29
            goto L_0x02ca
        L_0x0141:
            java.lang.String r0 = "zip"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x014c
            goto L_0x001f
        L_0x014c:
            r0 = 28
            goto L_0x02ca
        L_0x0150:
            java.lang.String r0 = "xml"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x015b
            goto L_0x001f
        L_0x015b:
            r0 = 27
            goto L_0x02ca
        L_0x015f:
            java.lang.String r0 = "xht"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x016a
            goto L_0x001f
        L_0x016a:
            r0 = 26
            goto L_0x02ca
        L_0x016e:
            java.lang.String r0 = "wav"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0179
            goto L_0x001f
        L_0x0179:
            r0 = 25
            goto L_0x02ca
        L_0x017d:
            java.lang.String r0 = "tif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0187
            goto L_0x001f
        L_0x0187:
            r0 = 24
            goto L_0x02ca
        L_0x018b:
            java.lang.String r0 = "tgz"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0195
            goto L_0x001f
        L_0x0195:
            r0 = 23
            goto L_0x02ca
        L_0x0199:
            java.lang.String r0 = "svg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01a3
            goto L_0x001f
        L_0x01a3:
            r0 = 22
            goto L_0x02ca
        L_0x01a7:
            java.lang.String r0 = "png"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01b1
            goto L_0x001f
        L_0x01b1:
            r0 = 21
            goto L_0x02ca
        L_0x01b5:
            java.lang.String r0 = "pjp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01bf
            goto L_0x001f
        L_0x01bf:
            r0 = 20
            goto L_0x02ca
        L_0x01c3:
            java.lang.String r0 = "pdf"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01cd
            goto L_0x001f
        L_0x01cd:
            r0 = 19
            goto L_0x02ca
        L_0x01d1:
            java.lang.String r0 = "ogv"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01db
            goto L_0x001f
        L_0x01db:
            r0 = 18
            goto L_0x02ca
        L_0x01df:
            java.lang.String r0 = "ogm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01e9
            goto L_0x001f
        L_0x01e9:
            r0 = 17
            goto L_0x02ca
        L_0x01ed:
            java.lang.String r0 = "ogg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x01f7
            goto L_0x001f
        L_0x01f7:
            r0 = 16
            goto L_0x02ca
        L_0x01fb:
            java.lang.String r0 = "oga"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0205
            goto L_0x001f
        L_0x0205:
            r0 = 15
            goto L_0x02ca
        L_0x0209:
            java.lang.String r0 = "mpg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0213
            goto L_0x001f
        L_0x0213:
            r0 = 14
            goto L_0x02ca
        L_0x0217:
            java.lang.String r0 = "mp4"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0221
            goto L_0x001f
        L_0x0221:
            r0 = 13
            goto L_0x02ca
        L_0x0225:
            java.lang.String r0 = "mp3"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x022f
            goto L_0x001f
        L_0x022f:
            r0 = 12
            goto L_0x02ca
        L_0x0233:
            java.lang.String r0 = "mjs"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x023d
            goto L_0x001f
        L_0x023d:
            r0 = 11
            goto L_0x02ca
        L_0x0241:
            java.lang.String r0 = "mht"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x024b
            goto L_0x001f
        L_0x024b:
            r0 = 10
            goto L_0x02ca
        L_0x024f:
            java.lang.String r0 = "m4v"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0259
            goto L_0x001f
        L_0x0259:
            r0 = 9
            goto L_0x02ca
        L_0x025d:
            java.lang.String r0 = "m4a"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0267
            goto L_0x001f
        L_0x0267:
            r0 = 8
            goto L_0x02ca
        L_0x026b:
            java.lang.String r0 = "jpg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0275
            goto L_0x001f
        L_0x0275:
            r0 = 7
            goto L_0x02ca
        L_0x0277:
            java.lang.String r0 = "ico"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0281
            goto L_0x001f
        L_0x0281:
            r0 = 6
            goto L_0x02ca
        L_0x0283:
            java.lang.String r0 = "htm"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x028d
            goto L_0x001f
        L_0x028d:
            r0 = 5
            goto L_0x02ca
        L_0x028f:
            java.lang.String r0 = "gif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0299
            goto L_0x001f
        L_0x0299:
            r0 = 4
            goto L_0x02ca
        L_0x029b:
            java.lang.String r0 = "css"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x02a5
            goto L_0x001f
        L_0x02a5:
            r0 = 3
            goto L_0x02ca
        L_0x02a7:
            java.lang.String r0 = "bmp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x02b1
            goto L_0x001f
        L_0x02b1:
            r0 = 2
            goto L_0x02ca
        L_0x02b3:
            java.lang.String r0 = "js"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x02bd
            goto L_0x001f
        L_0x02bd:
            r0 = r4
            goto L_0x02ca
        L_0x02bf:
            java.lang.String r0 = "gz"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x02c9
            goto L_0x001f
        L_0x02c9:
            r0 = 0
        L_0x02ca:
            switch(r0) {
                case 0: goto L_0x0329;
                case 1: goto L_0x0326;
                case 2: goto L_0x0323;
                case 3: goto L_0x0320;
                case 4: goto L_0x031d;
                case 5: goto L_0x031a;
                case 6: goto L_0x0317;
                case 7: goto L_0x0314;
                case 8: goto L_0x0311;
                case 9: goto L_0x030d;
                case 10: goto L_0x030a;
                case 11: goto L_0x0326;
                case 12: goto L_0x0307;
                case 13: goto L_0x030d;
                case 14: goto L_0x0303;
                case 15: goto L_0x0300;
                case 16: goto L_0x0300;
                case 17: goto L_0x02fc;
                case 18: goto L_0x02fc;
                case 19: goto L_0x02f9;
                case 20: goto L_0x0314;
                case 21: goto L_0x02f6;
                case 22: goto L_0x02f3;
                case 23: goto L_0x0329;
                case 24: goto L_0x02f0;
                case 25: goto L_0x02ed;
                case 26: goto L_0x02ea;
                case 27: goto L_0x02e7;
                case 28: goto L_0x02e4;
                case 29: goto L_0x02e1;
                case 30: goto L_0x02de;
                case 31: goto L_0x031a;
                case 32: goto L_0x0314;
                case 33: goto L_0x0314;
                case 34: goto L_0x02db;
                case 35: goto L_0x0303;
                case 36: goto L_0x0300;
                case 37: goto L_0x031a;
                case 38: goto L_0x02f3;
                case 39: goto L_0x02f0;
                case 40: goto L_0x02d8;
                case 41: goto L_0x02d4;
                case 42: goto L_0x02d1;
                case 43: goto L_0x02ce;
                case 44: goto L_0x02ea;
                case 45: goto L_0x031a;
                case 46: goto L_0x030a;
                case 47: goto L_0x0314;
                case 48: goto L_0x031a;
                case 49: goto L_0x02ea;
                default: goto L_0x02cd;
            }
        L_0x02cd:
            return r2
        L_0x02ce:
            java.lang.String r5 = "application/font-woff"
            return r5
        L_0x02d1:
            java.lang.String r5 = "image/webp"
            return r5
        L_0x02d4:
            java.lang.String r5 = "video/webm"
            return r5
        L_0x02d8:
            java.lang.String r5 = "application/wasm"
            return r5
        L_0x02db:
            java.lang.String r5 = "application/json"
            return r5
        L_0x02de:
            java.lang.String r5 = "audio/flac"
            return r5
        L_0x02e1:
            java.lang.String r5 = "image/apng"
            return r5
        L_0x02e4:
            java.lang.String r5 = "application/zip"
            return r5
        L_0x02e7:
            java.lang.String r5 = "text/xml"
            return r5
        L_0x02ea:
            java.lang.String r5 = "application/xhtml+xml"
            return r5
        L_0x02ed:
            java.lang.String r5 = "audio/wav"
            return r5
        L_0x02f0:
            java.lang.String r5 = "image/tiff"
            return r5
        L_0x02f3:
            java.lang.String r5 = "image/svg+xml"
            return r5
        L_0x02f6:
            java.lang.String r5 = "image/png"
            return r5
        L_0x02f9:
            java.lang.String r5 = "application/pdf"
            return r5
        L_0x02fc:
            java.lang.String r5 = "video/ogg"
            return r5
        L_0x0300:
            java.lang.String r5 = "audio/ogg"
            return r5
        L_0x0303:
            java.lang.String r5 = "video/mpeg"
            return r5
        L_0x0307:
            java.lang.String r5 = "audio/mpeg"
            return r5
        L_0x030a:
            java.lang.String r5 = "multipart/related"
            return r5
        L_0x030d:
            java.lang.String r5 = "video/mp4"
            return r5
        L_0x0311:
            java.lang.String r5 = "audio/x-m4a"
            return r5
        L_0x0314:
            java.lang.String r5 = "image/jpeg"
            return r5
        L_0x0317:
            java.lang.String r5 = "image/x-icon"
            return r5
        L_0x031a:
            java.lang.String r5 = "text/html"
            return r5
        L_0x031d:
            java.lang.String r5 = "image/gif"
            return r5
        L_0x0320:
            java.lang.String r5 = "text/css"
            return r5
        L_0x0323:
            java.lang.String r5 = "image/bmp"
            return r5
        L_0x0326:
            java.lang.String r5 = "application/javascript"
            return r5
        L_0x0329:
            java.lang.String r5 = "application/gzip"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.webkit.internal.MimeUtil.guessHardcodedMime(java.lang.String):java.lang.String");
    }
}
