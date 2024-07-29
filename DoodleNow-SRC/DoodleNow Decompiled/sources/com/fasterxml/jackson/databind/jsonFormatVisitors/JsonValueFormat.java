package com.fasterxml.jackson.databind.jsonFormatVisitors;

import androidx.autofill.HintConstants;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JsonValueFormat {
    COLOR("color"),
    DATE("date"),
    DATE_TIME("date-time"),
    EMAIL("email"),
    HOST_NAME("host-name"),
    IP_ADDRESS("ip-address"),
    IPV6("ipv6"),
    PHONE(HintConstants.AUTOFILL_HINT_PHONE),
    REGEX("regex"),
    STYLE(TtmlNode.TAG_STYLE),
    TIME("time"),
    URI("uri"),
    UTC_MILLISEC("utc-millisec");
    
    private final String _desc;

    @JsonValue
    public String toString() {
        return this._desc;
    }

    private JsonValueFormat(String str) {
        this._desc = str;
    }
}
