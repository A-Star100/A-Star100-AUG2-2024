package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnresolvedForwardReference extends JsonMappingException {
    private static final long serialVersionUID = 1;
    private ReadableObjectId _roid;
    private List<UnresolvedId> _unresolvedIds;

    public ReadableObjectId getRoid() {
        return this._roid;
    }

    public List<UnresolvedId> getUnresolvedIds() {
        return this._unresolvedIds;
    }

    public UnresolvedForwardReference(JsonParser jsonParser, String str, JsonLocation jsonLocation, ReadableObjectId readableObjectId) {
        super((Closeable) jsonParser, str, jsonLocation);
        this._roid = readableObjectId;
    }

    public UnresolvedForwardReference(JsonParser jsonParser, String str) {
        super((Closeable) jsonParser, str);
        this._unresolvedIds = new ArrayList();
    }

    @Deprecated
    public UnresolvedForwardReference(String str, JsonLocation jsonLocation, ReadableObjectId readableObjectId) {
        super(str, jsonLocation);
        this._roid = readableObjectId;
    }

    @Deprecated
    public UnresolvedForwardReference(String str) {
        super(str);
        this._unresolvedIds = new ArrayList();
    }

    public Object getUnresolvedId() {
        return this._roid.getKey().key;
    }

    public void addUnresolvedId(Object obj, Class<?> cls, JsonLocation jsonLocation) {
        this._unresolvedIds.add(new UnresolvedId(obj, cls, jsonLocation));
    }

    public String getMessage() {
        String message = super.getMessage();
        if (this._unresolvedIds == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(message);
        Iterator<UnresolvedId> it = this._unresolvedIds.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('.');
        return sb.toString();
    }
}
