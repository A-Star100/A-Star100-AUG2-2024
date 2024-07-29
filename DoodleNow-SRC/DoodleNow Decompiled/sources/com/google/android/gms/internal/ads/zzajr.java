package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.net.HttpHeaders;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzajr {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    public static zzbx zza(zzfo zzfo) {
        String str;
        zzbx zzago;
        int zzd = zzfo.zzd() + zzfo.zzg();
        int zzg = zzfo.zzg();
        int i = (zzg >> 24) & 255;
        zzbx zzbx = null;
        if (i == 169 || i == 253) {
            int i2 = zzg & ViewCompat.MEASURED_SIZE_MASK;
            if (i2 == 6516084) {
                int zzg2 = zzfo.zzg();
                if (zzfo.zzg() == 1684108385) {
                    zzfo.zzL(8);
                    String zzz = zzfo.zzz(zzg2 - 16);
                    zzbx = new zzagw(C.LANGUAGE_UNDETERMINED, zzz, zzz);
                } else {
                    zzfe.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzaja.zzf(zzg)));
                }
            } else {
                if (i2 != 7233901) {
                    if (i2 != 7631467) {
                        if (i2 != 6516589) {
                            if (i2 != 7828084) {
                                if (i2 == 6578553) {
                                    zzbx = zze(zzg, "TDRC", zzfo);
                                } else if (i2 == 4280916) {
                                    zzbx = zze(zzg, "TPE1", zzfo);
                                } else if (i2 == 7630703) {
                                    zzbx = zze(zzg, "TSSE", zzfo);
                                } else if (i2 == 6384738) {
                                    zzbx = zze(zzg, "TALB", zzfo);
                                } else if (i2 == 7108978) {
                                    zzbx = zze(zzg, "USLT", zzfo);
                                } else if (i2 == 6776174) {
                                    zzbx = zze(zzg, "TCON", zzfo);
                                } else if (i2 == 6779504) {
                                    zzbx = zze(zzg, "TIT1", zzfo);
                                }
                            }
                        }
                        zzbx = zze(zzg, "TCOM", zzfo);
                    }
                }
                zzbx = zze(zzg, "TIT2", zzfo);
            }
            return zzbx;
        }
        if (zzg == 1735291493) {
            try {
                int zzb2 = zzb(zzfo);
                String str2 = (zzb2 <= 0 || zzb2 > 192) ? null : zza[zzb2 - 1];
                if (str2 != null) {
                    zzago = new zzahl("TCON", (String) null, zzfzn.zzn(str2));
                } else {
                    zzfe.zzf("MetadataUtil", "Failed to parse standard genre code");
                    return zzbx;
                }
            } finally {
                zzfo.zzK(zzd);
            }
        } else {
            if (zzg == 1684632427) {
                zzbx = zzd(1684632427, "TPOS", zzfo);
            } else if (zzg == 1953655662) {
                zzbx = zzd(1953655662, "TRCK", zzfo);
            } else if (zzg == 1953329263) {
                zzbx = zzc(1953329263, "TBPM", zzfo, true, false);
            } else if (zzg == 1668311404) {
                zzbx = zzc(1668311404, "TCMP", zzfo, true, true);
            } else if (zzg == 1668249202) {
                int zzg3 = zzfo.zzg();
                if (zzfo.zzg() == 1684108385) {
                    int zzg4 = zzfo.zzg() & ViewCompat.MEASURED_SIZE_MASK;
                    if (zzg4 == 13) {
                        str = MimeTypes.IMAGE_JPEG;
                    } else if (zzg4 == 14) {
                        str = "image/png";
                        zzg4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzfe.zzf("MetadataUtil", "Unrecognized cover art flags: " + zzg4);
                    } else {
                        zzfo.zzL(4);
                        int i3 = zzg3 - 16;
                        byte[] bArr = new byte[i3];
                        zzfo.zzG(bArr, 0, i3);
                        zzago = new zzago(str, (String) null, 3, bArr);
                    }
                } else {
                    zzfe.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (zzg == 1631670868) {
                zzbx = zze(1631670868, "TPE2", zzfo);
            } else if (zzg == 1936682605) {
                zzbx = zze(1936682605, "TSOT", zzfo);
            } else if (zzg == 1936679276) {
                zzbx = zze(1936679276, "TSO2", zzfo);
            } else if (zzg == 1936679282) {
                zzbx = zze(1936679282, "TSOA", zzfo);
            } else if (zzg == 1936679265) {
                zzbx = zze(1936679265, "TSOP", zzfo);
            } else if (zzg == 1936679791) {
                zzbx = zze(1936679791, "TSOC", zzfo);
            } else if (zzg == 1920233063) {
                zzbx = zzc(1920233063, "ITUNESADVISORY", zzfo, false, false);
            } else if (zzg == 1885823344) {
                zzbx = zzc(1885823344, "ITUNESGAPLESS", zzfo, false, true);
            } else if (zzg == 1936683886) {
                zzbx = zze(1936683886, "TVSHOWSORT", zzfo);
            } else if (zzg == 1953919848) {
                zzbx = zze(1953919848, "TVSHOW", zzfo);
            } else if (zzg == 757935405) {
                int i4 = -1;
                int i5 = -1;
                String str3 = null;
                String str4 = null;
                while (zzfo.zzd() < zzd) {
                    int zzd2 = zzfo.zzd();
                    int zzg5 = zzfo.zzg();
                    int zzg6 = zzfo.zzg();
                    zzfo.zzL(4);
                    if (zzg6 == 1835360622) {
                        str3 = zzfo.zzz(zzg5 - 12);
                    } else {
                        int i6 = zzg5 - 12;
                        if (zzg6 == 1851878757) {
                            str4 = zzfo.zzz(i6);
                        } else {
                            if (zzg6 == 1684108385) {
                                i5 = zzg5;
                            }
                            if (zzg6 == 1684108385) {
                                i4 = zzd2;
                            }
                            zzfo.zzL(i6);
                        }
                    }
                }
                if (!(str3 == null || str4 == null)) {
                    if (i4 != -1) {
                        zzfo.zzK(i4);
                        zzfo.zzL(16);
                        zzbx = new zzahf(str3, str4, zzfo.zzz(i5 - 16));
                    }
                }
            }
            return zzbx;
        }
        zzbx = zzago;
        return zzbx;
        zzfe.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaja.zzf(zzg));
        return zzbx;
    }

    private static int zzb(zzfo zzfo) {
        zzfo.zzL(4);
        if (zzfo.zzg() == 1684108385) {
            zzfo.zzL(8);
            return zzfo.zzm();
        }
        zzfe.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzahd zzc(int i, String str, zzfo zzfo, boolean z, boolean z2) {
        int zzb2 = zzb(zzfo);
        if (z2) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            zzfe.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzaja.zzf(i)));
            return null;
        } else if (z) {
            return new zzahl(str, (String) null, zzfzn.zzn(Integer.toString(zzb2)));
        } else {
            return new zzagw(C.LANGUAGE_UNDETERMINED, str, Integer.toString(zzb2));
        }
    }

    private static zzahl zzd(int i, String str, zzfo zzfo) {
        int zzg = zzfo.zzg();
        if (zzfo.zzg() == 1684108385 && zzg >= 22) {
            zzfo.zzL(10);
            int zzq = zzfo.zzq();
            if (zzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(zzq);
                String sb2 = sb.toString();
                int zzq2 = zzfo.zzq();
                if (zzq2 > 0) {
                    sb2 = sb2 + "/" + zzq2;
                }
                return new zzahl(str, (String) null, zzfzn.zzn(sb2));
            }
        }
        zzfe.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzaja.zzf(i)));
        return null;
    }

    private static zzahl zze(int i, String str, zzfo zzfo) {
        int zzg = zzfo.zzg();
        if (zzfo.zzg() == 1684108385) {
            zzfo.zzL(8);
            return new zzahl(str, (String) null, zzfzn.zzn(zzfo.zzz(zzg - 16)));
        }
        zzfe.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzaja.zzf(i)));
        return null;
    }
}
