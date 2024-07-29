package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Util;
import com.revenuecat.purchases.common.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class RtspAuthenticationInfo {
    private static final String ALGORITHM = "MD5";
    public static final int BASIC = 1;
    private static final String BASIC_AUTHORIZATION_HEADER_FORMAT = "Basic %s";
    public static final int DIGEST = 2;
    private static final String DIGEST_AUTHORIZATION_HEADER_FORMAT = "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"";
    private static final String DIGEST_AUTHORIZATION_HEADER_FORMAT_WITH_OPAQUE = "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"";
    public final int authenticationMechanism;
    public final String nonce;
    public final String opaque;
    public final String realm;

    public RtspAuthenticationInfo(int i, String str, String str2, String str3) {
        this.authenticationMechanism = i;
        this.realm = str;
        this.nonce = str2;
        this.opaque = str3;
    }

    public String getAuthorizationHeaderValue(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, Uri uri, int i) throws ParserException {
        int i2 = this.authenticationMechanism;
        if (i2 == 1) {
            return getBasicAuthorizationHeaderValue(rtspAuthUserInfo);
        }
        if (i2 == 2) {
            return getDigestAuthorizationHeaderValue(rtspAuthUserInfo, uri, i);
        }
        throw ParserException.createForManifestWithUnsupportedFeature((String) null, new UnsupportedOperationException());
    }

    private String getBasicAuthorizationHeaderValue(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo) {
        return Util.formatInvariant(BASIC_AUTHORIZATION_HEADER_FORMAT, Base64.encodeToString(RtspMessageUtil.getStringBytes(rtspAuthUserInfo.username + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + rtspAuthUserInfo.password), 0));
    }

    private String getDigestAuthorizationHeaderValue(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, Uri uri, int i) throws ParserException {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            String methodString = RtspMessageUtil.toMethodString(i);
            String hexString = Util.toHexString(instance.digest(RtspMessageUtil.getStringBytes(rtspAuthUserInfo.username + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.realm + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + rtspAuthUserInfo.password)));
            StringBuilder sb = new StringBuilder();
            sb.append(methodString);
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(uri);
            String hexString2 = Util.toHexString(instance.digest(RtspMessageUtil.getStringBytes(sb.toString())));
            String hexString3 = Util.toHexString(instance.digest(RtspMessageUtil.getStringBytes(hexString + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.nonce + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + hexString2)));
            if (this.opaque.isEmpty()) {
                return Util.formatInvariant(DIGEST_AUTHORIZATION_HEADER_FORMAT, rtspAuthUserInfo.username, this.realm, this.nonce, uri, hexString3);
            }
            return Util.formatInvariant(DIGEST_AUTHORIZATION_HEADER_FORMAT_WITH_OPAQUE, rtspAuthUserInfo.username, this.realm, this.nonce, uri, hexString3, this.opaque);
        } catch (NoSuchAlgorithmException e) {
            throw ParserException.createForManifestWithUnsupportedFeature((String) null, e);
        }
    }
}
