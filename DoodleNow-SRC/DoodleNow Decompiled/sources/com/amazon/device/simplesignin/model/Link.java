package com.amazon.device.simplesignin.model;

public class Link {
    private String amazonUserId;
    private String identityProviderName;
    private String linkId;
    private long linkedTimestamp;
    private String partnerUserId;
    private Token ssiToken;

    public String getAmazonUserId() {
        return this.amazonUserId;
    }

    public String getIdentityProviderName() {
        return this.identityProviderName;
    }

    public String getLinkId() {
        return this.linkId;
    }

    public long getLinkedTimestamp() {
        return this.linkedTimestamp;
    }

    public String getPartnerUserId() {
        return this.partnerUserId;
    }

    public Token getSsiToken() {
        return this.ssiToken;
    }

    public void setAmazonUserId(String str) {
        this.amazonUserId = str;
    }

    public void setIdentityProviderName(String str) {
        this.identityProviderName = str;
    }

    public void setLinkId(String str) {
        this.linkId = str;
    }

    public void setLinkedTimestamp(long j) {
        this.linkedTimestamp = j;
    }

    public void setPartnerUserId(String str) {
        this.partnerUserId = str;
    }

    public void setSsiToken(Token token) {
        this.ssiToken = token;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof Link;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link link = (Link) obj;
        if (!link.canEqual(this) || getLinkedTimestamp() != link.getLinkedTimestamp()) {
            return false;
        }
        String linkId2 = getLinkId();
        String linkId3 = link.getLinkId();
        if (linkId2 != null ? !linkId2.equals(linkId3) : linkId3 != null) {
            return false;
        }
        String amazonUserId2 = getAmazonUserId();
        String amazonUserId3 = link.getAmazonUserId();
        if (amazonUserId2 != null ? !amazonUserId2.equals(amazonUserId3) : amazonUserId3 != null) {
            return false;
        }
        String partnerUserId2 = getPartnerUserId();
        String partnerUserId3 = link.getPartnerUserId();
        if (partnerUserId2 != null ? !partnerUserId2.equals(partnerUserId3) : partnerUserId3 != null) {
            return false;
        }
        String identityProviderName2 = getIdentityProviderName();
        String identityProviderName3 = link.getIdentityProviderName();
        if (identityProviderName2 != null ? !identityProviderName2.equals(identityProviderName3) : identityProviderName3 != null) {
            return false;
        }
        Token ssiToken2 = getSsiToken();
        Token ssiToken3 = link.getSsiToken();
        return ssiToken2 != null ? ssiToken2.equals(ssiToken3) : ssiToken3 == null;
    }

    public int hashCode() {
        long linkedTimestamp2 = getLinkedTimestamp();
        String linkId2 = getLinkId();
        int i = 43;
        int hashCode = ((((int) (linkedTimestamp2 ^ (linkedTimestamp2 >>> 32))) + 59) * 59) + (linkId2 == null ? 43 : linkId2.hashCode());
        String amazonUserId2 = getAmazonUserId();
        int hashCode2 = (hashCode * 59) + (amazonUserId2 == null ? 43 : amazonUserId2.hashCode());
        String partnerUserId2 = getPartnerUserId();
        int hashCode3 = (hashCode2 * 59) + (partnerUserId2 == null ? 43 : partnerUserId2.hashCode());
        String identityProviderName2 = getIdentityProviderName();
        int hashCode4 = (hashCode3 * 59) + (identityProviderName2 == null ? 43 : identityProviderName2.hashCode());
        Token ssiToken2 = getSsiToken();
        int i2 = hashCode4 * 59;
        if (ssiToken2 != null) {
            i = ssiToken2.hashCode();
        }
        return i2 + i;
    }
}
