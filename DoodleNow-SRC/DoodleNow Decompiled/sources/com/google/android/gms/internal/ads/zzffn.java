package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzffn {
    public final String zzA;
    public final zzbzl zzB;
    public final String zzC;
    public final JSONObject zzD;
    public final JSONObject zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final String zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final int zzR;
    public final int zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final String zzV;
    public final zzfgl zzW;
    public final boolean zzX;
    public final boolean zzY;
    public final int zzZ;
    public final List zza;
    public final String zzaa;
    public final int zzab;
    public final String zzac;
    public final boolean zzad;
    public final zzbuv zzae;
    public final zzs zzaf;
    public final String zzag;
    public final boolean zzah;
    public final JSONObject zzai;
    public final boolean zzaj;
    public final JSONObject zzak;
    public final boolean zzal;
    public final String zzam;
    public final boolean zzan;
    public final String zzao;
    public final String zzap;
    public final String zzaq;
    public final boolean zzar;
    public final int zzas;
    public final String zzat;
    public final List zzau;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final List zze;
    public final int zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final List zzj;
    public final String zzk;
    public final String zzl;
    public final zzbyc zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final List zzq;
    public final int zzr;
    public final List zzs;
    public final zzffs zzt;
    public final List zzu;
    public final List zzv;
    public final JSONObject zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0715, code lost:
        r10 = r81;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x0880, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0882, code lost:
        r9 = r79;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzffn(android.util.JsonReader r81) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r80 = this;
            r0 = r80
            r80.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            java.util.List r14 = java.util.Collections.emptyList()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            org.json.JSONObject r20 = new org.json.JSONObject
            r20.<init>()
            com.google.android.gms.internal.ads.zzfzn r21 = com.google.android.gms.internal.ads.zzfzn.zzm()
            com.google.android.gms.internal.ads.zzfzn r22 = com.google.android.gms.internal.ads.zzfzn.zzm()
            r81.beginObject()
            java.lang.String r23 = ""
            r24 = 0
            r25 = 0
            r26 = -1
            r27 = r16
            r28 = r17
            r29 = r18
            r30 = r19
            r31 = r20
            r32 = r21
            r33 = r22
            r39 = r23
            r40 = r39
            r41 = r40
            r42 = r41
            r43 = r42
            r54 = r43
            r58 = r54
            r60 = r58
            r62 = r60
            r64 = r62
            r65 = r64
            r66 = r65
            r67 = r66
            r68 = r67
            r73 = r68
            r74 = r73
            r75 = r74
            r78 = r75
            r38 = r24
            r44 = r38
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r49 = r48
            r50 = r49
            r52 = r50
            r53 = r52
            r55 = r53
            r56 = r55
            r57 = r56
            r61 = r57
            r63 = r61
            r69 = r63
            r70 = r69
            r71 = r70
            r72 = r71
            r76 = r72
            r77 = r76
            r19 = r25
            r34 = r19
            r35 = r34
            r36 = r35
            r37 = r36
            r51 = r26
            r59 = r51
            r21 = r11
            r20 = r12
            r18 = r13
            r17 = r14
            r16 = r15
            r11 = r78
            r12 = r11
            r13 = r77
            r14 = r13
            r15 = r37
        L_0x00ea:
            boolean r22 = r81.hasNext()
            if (r22 == 0) goto L_0x0886
            java.lang.String r22 = r81.nextName()
            if (r22 != 0) goto L_0x00f9
            r25 = r23
            goto L_0x00fb
        L_0x00f9:
            r25 = r22
        L_0x00fb:
            int r22 = r25.hashCode()
            switch(r22) {
                case -2138196627: goto L_0x061e;
                case -1980587809: goto L_0x060d;
                case -1965512151: goto L_0x05fc;
                case -1871425831: goto L_0x05eb;
                case -1843156475: goto L_0x05da;
                case -1812055556: goto L_0x05c9;
                case -1785028569: goto L_0x05b7;
                case -1776946669: goto L_0x05a5;
                case -1662989631: goto L_0x0593;
                case -1620470467: goto L_0x0581;
                case -1550155393: goto L_0x056f;
                case -1440104884: goto L_0x055d;
                case -1439500848: goto L_0x054b;
                case -1428969291: goto L_0x0539;
                case -1406227629: goto L_0x0527;
                case -1403779768: goto L_0x0515;
                case -1375413093: goto L_0x0503;
                case -1360811658: goto L_0x04f1;
                case -1306015996: goto L_0x04df;
                case -1303332046: goto L_0x04cd;
                case -1289032093: goto L_0x04bb;
                case -1240082064: goto L_0x04a9;
                case -1234181075: goto L_0x0497;
                case -1168140544: goto L_0x0485;
                case -1152230954: goto L_0x0474;
                case -1146534047: goto L_0x0462;
                case -1115838944: goto L_0x0450;
                case -1081936678: goto L_0x043e;
                case -1078050970: goto L_0x042c;
                case -1051269058: goto L_0x041a;
                case -982608540: goto L_0x0408;
                case -972056451: goto L_0x03f6;
                case -776859333: goto L_0x03e5;
                case -570101180: goto L_0x03d3;
                case -544216775: goto L_0x03c1;
                case -437057161: goto L_0x03b0;
                case -404433734: goto L_0x039e;
                case -404326515: goto L_0x038c;
                case -397704715: goto L_0x037a;
                case -388807511: goto L_0x0368;
                case -369773488: goto L_0x0356;
                case -213449460: goto L_0x0344;
                case -213424028: goto L_0x0332;
                case -180214626: goto L_0x0320;
                case -154616268: goto L_0x030e;
                case -29338502: goto L_0x02fc;
                case 3107: goto L_0x02ea;
                case 3355: goto L_0x02d8;
                case 3076010: goto L_0x02c6;
                case 37109963: goto L_0x02b4;
                case 63195984: goto L_0x02a2;
                case 107433883: goto L_0x0290;
                case 230323073: goto L_0x027f;
                case 418392395: goto L_0x026d;
                case 542250332: goto L_0x025b;
                case 549176928: goto L_0x0249;
                case 597473788: goto L_0x0237;
                case 754887508: goto L_0x0225;
                case 791122864: goto L_0x0214;
                case 1010584092: goto L_0x0202;
                case 1100650276: goto L_0x01f0;
                case 1141602460: goto L_0x01de;
                case 1186014765: goto L_0x01cc;
                case 1321720943: goto L_0x01ba;
                case 1437255331: goto L_0x01a8;
                case 1637553475: goto L_0x0196;
                case 1638957285: goto L_0x0185;
                case 1686319423: goto L_0x0173;
                case 1688341040: goto L_0x0162;
                case 1799285870: goto L_0x0150;
                case 1839650832: goto L_0x013e;
                case 1875425491: goto L_0x012c;
                case 2068142375: goto L_0x011a;
                case 2072888499: goto L_0x0108;
                default: goto L_0x0102;
            }
        L_0x0102:
            r79 = r9
            r22 = r10
            goto L_0x062f
        L_0x0108:
            r22 = r10
            java.lang.String r10 = "manual_tracking_urls"
            r79 = r9
            r9 = r25
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 15
            goto L_0x0631
        L_0x011a:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "rule_line_external_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 52
            goto L_0x0631
        L_0x012c:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_analytics_logging_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 42
            goto L_0x0631
        L_0x013e:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "renderers"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = r24
            goto L_0x0631
        L_0x0150:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "use_third_party_container_height"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 48
            goto L_0x0631
        L_0x0162:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "video_reward_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 7
            goto L_0x0631
        L_0x0173:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_network_class_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 55
            goto L_0x0631
        L_0x0185:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "video_start_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 6
            goto L_0x0631
        L_0x0196:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "bid_response"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 40
            goto L_0x0631
        L_0x01a8:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 58
            goto L_0x0631
        L_0x01ba:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allow_pub_owned_ad_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 31
            goto L_0x0631
        L_0x01cc:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "cache_hit_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 66
            goto L_0x0631
        L_0x01de:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "adapter_response_info_key"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 56
            goto L_0x0631
        L_0x01f0:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "rewards"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 11
            goto L_0x0631
        L_0x0202:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "transaction_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 9
            goto L_0x0631
        L_0x0214:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 5
            goto L_0x0631
        L_0x0225:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "container_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 17
            goto L_0x0631
        L_0x0237:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "debug_dialog_string"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 27
            goto L_0x0631
        L_0x0249:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "presentation_error_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 16
            goto L_0x0631
        L_0x025b:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "consent_form_action_identifier"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 71
            goto L_0x0631
        L_0x026d:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_closable_area_disabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 36
            goto L_0x0631
        L_0x027f:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 4
            goto L_0x0631
        L_0x0290:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "qdata"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 24
            goto L_0x0631
        L_0x02a2:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "render_test_label"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 33
            goto L_0x0631
        L_0x02b4:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "request_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 68
            goto L_0x0631
        L_0x02c6:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 22
            goto L_0x0631
        L_0x02d8:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 23
            goto L_0x0631
        L_0x02ea:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 18
            goto L_0x0631
        L_0x02fc:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allow_custom_click_gesture"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 32
            goto L_0x0631
        L_0x030e:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_offline_ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 61
            goto L_0x0631
        L_0x0320:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "native_required_asset_viewability"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 63
            goto L_0x0631
        L_0x0332:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "watermark"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 46
            goto L_0x0631
        L_0x0344:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "force_disable_hardware_acceleration"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 65
            goto L_0x0631
        L_0x0356:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_close_button_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 50
            goto L_0x0631
        L_0x0368:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "content_url"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 64
            goto L_0x0631
        L_0x037a:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_close_time_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 45
            goto L_0x0631
        L_0x038c:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "render_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 38
            goto L_0x0631
        L_0x039e:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "rtb_native_required_assets"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 62
            goto L_0x0631
        L_0x03b0:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "imp_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 3
            goto L_0x0631
        L_0x03c1:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "safe_browsing"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 26
            goto L_0x0631
        L_0x03d3:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "late_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 73
            goto L_0x0631
        L_0x03e5:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "click_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 2
            goto L_0x0631
        L_0x03f6:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_instance_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 60
            goto L_0x0631
        L_0x0408:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "valid_from_timestamp"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 10
            goto L_0x0631
        L_0x041a:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "active_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 25
            goto L_0x0631
        L_0x042c:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "video_complete_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 8
            goto L_0x0631
        L_0x043e:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allocation_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 21
            goto L_0x0631
        L_0x0450:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "fill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 12
            goto L_0x0631
        L_0x0462:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_scroll_aware"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 43
            goto L_0x0631
        L_0x0474:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 1
            goto L_0x0631
        L_0x0485:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "presentation_error_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 14
            goto L_0x0631
        L_0x0497:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allow_pub_rendered_attribution"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 30
            goto L_0x0631
        L_0x04a9:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_event_value"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 51
            goto L_0x0631
        L_0x04bb:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "extras"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 29
            goto L_0x0631
        L_0x04cd:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "test_mode_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 34
            goto L_0x0631
        L_0x04df:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "adapters"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 20
            goto L_0x0631
        L_0x04f1:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 19
            goto L_0x0631
        L_0x0503:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_cover"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 54
            goto L_0x0631
        L_0x0515:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "showable_impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 44
            goto L_0x0631
        L_0x0527:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "buffer_click_url_as_ready_to_ping"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 67
            goto L_0x0631
        L_0x0539:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "enable_omid"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 39
            goto L_0x0631
        L_0x054b:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "orientation"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 37
            goto L_0x0631
        L_0x055d:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_custom_close_blocked"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 35
            goto L_0x0631
        L_0x056f:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "nofill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 13
            goto L_0x0631
        L_0x0581:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "backend_query_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 47
            goto L_0x0631
        L_0x0593:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_interscroller"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 53
            goto L_0x0631
        L_0x05a5:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 57
            goto L_0x0631
        L_0x05b7:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "parallel_key"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 72
            goto L_0x0631
        L_0x05c9:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "play_prewarm_options"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 49
            goto L_0x0631
        L_0x05da:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_consent"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 70
            goto L_0x0631
        L_0x05eb:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "recursive_server_response_data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 69
            goto L_0x0631
        L_0x05fc:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "omid_settings"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 41
            goto L_0x0631
        L_0x060d:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "debug_signals"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 28
            goto L_0x0631
        L_0x061e:
            r79 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_instance_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x062f
            r9 = 59
            goto L_0x0631
        L_0x062f:
            r9 = r26
        L_0x0631:
            switch(r9) {
                case 0: goto L_0x087a;
                case 1: goto L_0x086f;
                case 2: goto L_0x0868;
                case 3: goto L_0x0861;
                case 4: goto L_0x085a;
                case 5: goto L_0x084f;
                case 6: goto L_0x0848;
                case 7: goto L_0x0841;
                case 8: goto L_0x083a;
                case 9: goto L_0x0833;
                case 10: goto L_0x082c;
                case 11: goto L_0x0821;
                case 12: goto L_0x0819;
                case 13: goto L_0x080f;
                case 14: goto L_0x0806;
                case 15: goto L_0x07fe;
                case 16: goto L_0x07f6;
                case 17: goto L_0x07ee;
                case 18: goto L_0x07e3;
                case 19: goto L_0x07dd;
                case 20: goto L_0x07d7;
                case 21: goto L_0x07d1;
                case 22: goto L_0x07cb;
                case 23: goto L_0x07c5;
                case 24: goto L_0x07bf;
                case 25: goto L_0x07b5;
                case 26: goto L_0x07ab;
                case 27: goto L_0x07a5;
                case 28: goto L_0x079f;
                case 29: goto L_0x0799;
                case 30: goto L_0x0793;
                case 31: goto L_0x078d;
                case 32: goto L_0x0787;
                case 33: goto L_0x0781;
                case 34: goto L_0x077b;
                case 35: goto L_0x0775;
                case 36: goto L_0x076f;
                case 37: goto L_0x0765;
                case 38: goto L_0x075f;
                case 39: goto L_0x0759;
                case 40: goto L_0x0753;
                case 41: goto L_0x074d;
                case 42: goto L_0x0747;
                case 43: goto L_0x0741;
                case 44: goto L_0x073b;
                case 45: goto L_0x0735;
                case 46: goto L_0x072f;
                case 47: goto L_0x0729;
                case 48: goto L_0x0723;
                case 49: goto L_0x0719;
                case 50: goto L_0x0712;
                case 51: goto L_0x0708;
                case 52: goto L_0x0702;
                case 53: goto L_0x06fc;
                case 54: goto L_0x06f6;
                case 55: goto L_0x06f0;
                case 56: goto L_0x06ea;
                case 57: goto L_0x06d2;
                case 58: goto L_0x06ba;
                case 59: goto L_0x06a2;
                case 60: goto L_0x0689;
                case 61: goto L_0x0683;
                case 62: goto L_0x067d;
                case 63: goto L_0x0677;
                case 64: goto L_0x0671;
                case 65: goto L_0x066b;
                case 66: goto L_0x0665;
                case 67: goto L_0x065f;
                case 68: goto L_0x0659;
                case 69: goto L_0x0653;
                case 70: goto L_0x064d;
                case 71: goto L_0x0647;
                case 72: goto L_0x0641;
                case 73: goto L_0x063b;
                default: goto L_0x0634;
            }
        L_0x0634:
            r10 = r81
            r81.skipValue()
            goto L_0x0880
        L_0x063b:
            java.util.List r33 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0641:
            java.lang.String r78 = r81.nextString()
            goto L_0x0880
        L_0x0647:
            int r77 = r81.nextInt()
            goto L_0x0880
        L_0x064d:
            boolean r76 = r81.nextBoolean()
            goto L_0x0880
        L_0x0653:
            java.lang.String r74 = r81.nextString()
            goto L_0x0880
        L_0x0659:
            java.lang.String r73 = r81.nextString()
            goto L_0x0880
        L_0x065f:
            boolean r72 = r81.nextBoolean()
            goto L_0x0880
        L_0x0665:
            java.util.List r32 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x066b:
            boolean r71 = r81.nextBoolean()
            goto L_0x0880
        L_0x0671:
            java.lang.String r37 = r81.nextString()
            goto L_0x0880
        L_0x0677:
            boolean r70 = r81.nextBoolean()
            goto L_0x0880
        L_0x067d:
            org.json.JSONObject r31 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            goto L_0x0880
        L_0x0683:
            boolean r69 = r81.nextBoolean()
            goto L_0x0880
        L_0x0689:
            com.google.android.gms.internal.ads.zzbdq r9 = com.google.android.gms.internal.ads.zzbdz.zzgR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x069d
            java.lang.String r68 = r81.nextString()
            goto L_0x0880
        L_0x069d:
            r81.skipValue()
            goto L_0x0715
        L_0x06a2:
            com.google.android.gms.internal.ads.zzbdq r9 = com.google.android.gms.internal.ads.zzbdz.zzgR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x06b6
            java.lang.String r67 = r81.nextString()
            goto L_0x0880
        L_0x06b6:
            r81.skipValue()
            goto L_0x0715
        L_0x06ba:
            com.google.android.gms.internal.ads.zzbdq r9 = com.google.android.gms.internal.ads.zzbdz.zzgR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x06ce
            java.lang.String r66 = r81.nextString()
            goto L_0x0880
        L_0x06ce:
            r81.skipValue()
            goto L_0x0715
        L_0x06d2:
            com.google.android.gms.internal.ads.zzbdq r9 = com.google.android.gms.internal.ads.zzbdz.zzgR
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x06e6
            java.lang.String r65 = r81.nextString()
            goto L_0x0880
        L_0x06e6:
            r81.skipValue()
            goto L_0x0715
        L_0x06ea:
            java.lang.String r75 = r81.nextString()
            goto L_0x0880
        L_0x06f0:
            java.lang.String r64 = r81.nextString()
            goto L_0x0880
        L_0x06f6:
            org.json.JSONObject r30 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            goto L_0x0880
        L_0x06fc:
            boolean r63 = r81.nextBoolean()
            goto L_0x0880
        L_0x0702:
            java.lang.String r62 = r81.nextString()
            goto L_0x0880
        L_0x0708:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            com.google.android.gms.ads.internal.client.zzs r36 = com.google.android.gms.ads.internal.client.zzs.zza(r9)
            goto L_0x0880
        L_0x0712:
            r81.nextBoolean()
        L_0x0715:
            r10 = r81
            goto L_0x0880
        L_0x0719:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            com.google.android.gms.internal.ads.zzbuv r35 = com.google.android.gms.internal.ads.zzbuv.zza(r9)
            goto L_0x0880
        L_0x0723:
            boolean r61 = r81.nextBoolean()
            goto L_0x0880
        L_0x0729:
            java.lang.String r60 = r81.nextString()
            goto L_0x0880
        L_0x072f:
            java.lang.String r58 = r81.nextString()
            goto L_0x0880
        L_0x0735:
            int r59 = r81.nextInt()
            goto L_0x0880
        L_0x073b:
            int r57 = r81.nextInt()
            goto L_0x0880
        L_0x0741:
            boolean r56 = r81.nextBoolean()
            goto L_0x0880
        L_0x0747:
            boolean r55 = r81.nextBoolean()
            goto L_0x0880
        L_0x074d:
            org.json.JSONObject r29 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            goto L_0x0880
        L_0x0753:
            java.lang.String r54 = r81.nextString()
            goto L_0x0880
        L_0x0759:
            boolean r53 = r81.nextBoolean()
            goto L_0x0880
        L_0x075f:
            int r52 = r81.nextInt()
            goto L_0x0880
        L_0x0765:
            java.lang.String r9 = r81.nextString()
            int r51 = zzd(r9)
            goto L_0x0880
        L_0x076f:
            boolean r50 = r81.nextBoolean()
            goto L_0x0880
        L_0x0775:
            boolean r49 = r81.nextBoolean()
            goto L_0x0880
        L_0x077b:
            boolean r48 = r81.nextBoolean()
            goto L_0x0880
        L_0x0781:
            boolean r47 = r81.nextBoolean()
            goto L_0x0880
        L_0x0787:
            boolean r46 = r81.nextBoolean()
            goto L_0x0880
        L_0x078d:
            boolean r45 = r81.nextBoolean()
            goto L_0x0880
        L_0x0793:
            boolean r44 = r81.nextBoolean()
            goto L_0x0880
        L_0x0799:
            org.json.JSONObject r28 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            goto L_0x0880
        L_0x079f:
            org.json.JSONObject r27 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            goto L_0x0880
        L_0x07a5:
            java.lang.String r43 = r81.nextString()
            goto L_0x0880
        L_0x07ab:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            com.google.android.gms.internal.ads.zzbzl r34 = com.google.android.gms.internal.ads.zzbzl.zza(r9)
            goto L_0x0880
        L_0x07b5:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            java.lang.String r42 = r9.toString()
            goto L_0x0880
        L_0x07bf:
            java.lang.String r41 = r81.nextString()
            goto L_0x0880
        L_0x07c5:
            java.lang.String r40 = r81.nextString()
            goto L_0x0880
        L_0x07cb:
            org.json.JSONObject r16 = com.google.android.gms.ads.internal.util.zzbw.zzh(r81)
            goto L_0x0880
        L_0x07d1:
            java.lang.String r39 = r81.nextString()
            goto L_0x0880
        L_0x07d7:
            java.util.List r18 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x07dd:
            java.util.List r17 = com.google.android.gms.internal.ads.zzffo.zza(r81)
            goto L_0x0880
        L_0x07e3:
            com.google.android.gms.internal.ads.zzffs r9 = new com.google.android.gms.internal.ads.zzffs
            r10 = r81
            r9.<init>(r10)
            r19 = r9
            goto L_0x0880
        L_0x07ee:
            r10 = r81
            java.util.List r20 = com.google.android.gms.internal.ads.zzffo.zza(r81)
            goto L_0x0880
        L_0x07f6:
            r10 = r81
            int r38 = r81.nextInt()
            goto L_0x0880
        L_0x07fe:
            r10 = r81
            java.util.List r21 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0806:
            r10 = r81
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            r10 = r9
            goto L_0x0882
        L_0x080f:
            r10 = r81
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            r10 = r22
            goto L_0x00ea
        L_0x0819:
            r10 = r81
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0821:
            r10 = r81
            org.json.JSONArray r9 = com.google.android.gms.ads.internal.util.zzbw.zze(r81)
            com.google.android.gms.internal.ads.zzbyc r15 = com.google.android.gms.internal.ads.zzbyc.zza(r9)
            goto L_0x0880
        L_0x082c:
            r10 = r81
            java.lang.String r11 = r81.nextString()
            goto L_0x0880
        L_0x0833:
            r10 = r81
            java.lang.String r12 = r81.nextString()
            goto L_0x0880
        L_0x083a:
            r10 = r81
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0841:
            r10 = r81
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0848:
            r10 = r81
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x084f:
            r10 = r81
            int r9 = r81.nextInt()
            int r14 = zzc(r9)
            goto L_0x0880
        L_0x085a:
            r10 = r81
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0861:
            r10 = r81
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x0868:
            r10 = r81
            java.util.List r2 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
            goto L_0x0880
        L_0x086f:
            r10 = r81
            java.lang.String r9 = r81.nextString()
            int r13 = zzb(r9)
            goto L_0x0880
        L_0x087a:
            r10 = r81
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbw.zzd(r81)
        L_0x0880:
            r10 = r22
        L_0x0882:
            r9 = r79
            goto L_0x00ea
        L_0x0886:
            r79 = r9
            r22 = r10
            r10 = r81
            r81.endObject()
            r0.zza = r1
            r0.zzb = r13
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            r0.zzf = r14
            r0.zzh = r5
            r0.zzi = r6
            r0.zzj = r7
            r0.zzk = r12
            r0.zzl = r11
            r0.zzm = r15
            r0.zzn = r8
            r0.zzo = r9
            r9 = r22
            r0.zzp = r9
            r11 = r21
            r0.zzq = r11
            r1 = r38
            r0.zzr = r1
            r12 = r20
            r0.zzs = r12
            r9 = r19
            r0.zzt = r9
            r13 = r18
            r0.zzu = r13
            r14 = r17
            r0.zzv = r14
            r1 = r39
            r0.zzx = r1
            r15 = r16
            r0.zzw = r15
            r1 = r40
            r0.zzy = r1
            r1 = r41
            r0.zzz = r1
            r1 = r42
            r0.zzA = r1
            r1 = r34
            r0.zzB = r1
            r1 = r43
            r0.zzC = r1
            r1 = r27
            r0.zzD = r1
            r1 = r28
            r0.zzE = r1
            r1 = r44
            r0.zzK = r1
            r1 = r45
            r0.zzL = r1
            r1 = r46
            r0.zzM = r1
            r1 = r47
            r0.zzN = r1
            r1 = r48
            r0.zzO = r1
            r1 = r49
            r0.zzP = r1
            r1 = r50
            r0.zzQ = r1
            r1 = r51
            r0.zzR = r1
            r1 = r52
            r0.zzS = r1
            r1 = r53
            r0.zzU = r1
            r1 = r54
            r0.zzV = r1
            com.google.android.gms.internal.ads.zzfgl r1 = new com.google.android.gms.internal.ads.zzfgl
            r2 = r29
            r1.<init>(r2)
            r0.zzW = r1
            r1 = r55
            r0.zzX = r1
            r1 = r56
            r0.zzY = r1
            r1 = r57
            r0.zzZ = r1
            r1 = r58
            r0.zzaa = r1
            r1 = r59
            r0.zzab = r1
            r1 = r60
            r0.zzac = r1
            r1 = r61
            r0.zzad = r1
            r1 = r35
            r0.zzae = r1
            r1 = r36
            r0.zzaf = r1
            r1 = r62
            r0.zzag = r1
            r1 = r63
            r0.zzah = r1
            r1 = r30
            r0.zzai = r1
            r1 = r64
            r0.zzF = r1
            r1 = r65
            r0.zzG = r1
            r1 = r66
            r0.zzH = r1
            r1 = r67
            r0.zzI = r1
            r1 = r68
            r0.zzJ = r1
            r1 = r69
            r0.zzaj = r1
            r1 = r31
            r0.zzak = r1
            r1 = r70
            r0.zzal = r1
            r1 = r37
            r0.zzam = r1
            r1 = r71
            r0.zzan = r1
            r1 = r32
            r0.zze = r1
            r1 = r72
            r0.zzT = r1
            r1 = r73
            r0.zzao = r1
            r1 = r74
            r0.zzap = r1
            r1 = r75
            r0.zzaq = r1
            r1 = r76
            r0.zzar = r1
            r1 = r77
            r0.zzas = r1
            r1 = r33
            r0.zzau = r1
            r1 = r78
            r0.zzat = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffn.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zzc(int i) {
        if (i == 0 || i == 1 || i == 3) {
            return i;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }
}
