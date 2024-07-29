package com.amplitude.api;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class IdentifyInterceptor {
    private static final String TAG = "com.amplitude.api.IdentifyInterceptor";
    private final AmplitudeClient client;
    private final DatabaseHelper dbHelper;
    private String deviceId;
    private long identifyBatchIntervalMillis;
    private final AtomicBoolean identitySet = new AtomicBoolean(false);
    private long lastIdentifyInterceptorId = -1;
    private final WorkerThread logThread;
    /* access modifiers changed from: private */
    public final AtomicBoolean transferScheduled = new AtomicBoolean(false);
    private String userId;

    public void setIdentifyBatchIntervalMillis(long j) {
        this.identifyBatchIntervalMillis = j;
    }

    public IdentifyInterceptor(DatabaseHelper databaseHelper, WorkerThread workerThread, long j, AmplitudeClient amplitudeClient) {
        this.dbHelper = databaseHelper;
        this.logThread = workerThread;
        this.identifyBatchIntervalMillis = j;
        if (databaseHelper.getIdentifyInterceptorCount() > 0) {
            this.lastIdentifyInterceptorId = databaseHelper.getLastIdentifyInterceptorId();
        }
        this.client = amplitudeClient;
    }

    public JSONObject intercept(String str, JSONObject jSONObject) {
        if (isIdentityUpdated(jSONObject)) {
            transferInterceptedIdentify();
        }
        if (str.equals(Constants.IDENTIFY_EVENT)) {
            if (isSetOnly(jSONObject) && !isSetGroups(jSONObject)) {
                this.lastIdentifyInterceptorId = saveIdentifyProperties(jSONObject);
                scheduleTransfer();
                return null;
            } else if (isClearAll(jSONObject)) {
                this.dbHelper.removeIdentifyInterceptors(this.lastIdentifyInterceptorId);
                return jSONObject;
            } else {
                transferInterceptedIdentify();
                return jSONObject;
            }
        } else if (str.equals(Constants.GROUP_IDENTIFY_EVENT)) {
            return jSONObject;
        } else {
            transferInterceptedIdentify();
            return jSONObject;
        }
    }

    private JSONObject getTransferIdentifyEvent() {
        try {
            List<JSONObject> identifyInterceptors = this.dbHelper.getIdentifyInterceptors(this.lastIdentifyInterceptorId, -1);
            if (identifyInterceptors.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = identifyInterceptors.get(0);
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_properties").getJSONObject("$set");
            mergeUserProperties(jSONObject2, mergeIdentifyInterceptList(identifyInterceptors.subList(1, identifyInterceptors.size())));
            jSONObject.getJSONObject("user_properties").put("$set", jSONObject2);
            this.dbHelper.removeIdentifyInterceptors(this.lastIdentifyInterceptorId);
            return jSONObject;
        } catch (JSONException e) {
            AmplitudeLog logger = AmplitudeLog.getLogger();
            String str = TAG;
            logger.w(str, "Identify Merge error: " + e.getMessage());
            return null;
        }
    }

    private void scheduleTransfer() {
        if (!this.transferScheduled.getAndSet(true)) {
            this.logThread.postDelayed(new Runnable() {
                public void run() {
                    IdentifyInterceptor.this.transferScheduled.set(false);
                    IdentifyInterceptor.this.transferInterceptedIdentify();
                }
            }, this.identifyBatchIntervalMillis);
        }
    }

    public void transferInterceptedIdentify() {
        JSONObject transferIdentifyEvent = getTransferIdentifyEvent();
        if (transferIdentifyEvent != null) {
            this.client.saveEvent(Constants.IDENTIFY_EVENT, transferIdentifyEvent);
        }
    }

    private JSONObject mergeIdentifyInterceptList(List<JSONObject> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : list) {
            mergeUserProperties(jSONObject, jSONObject2.getJSONObject("user_properties").getJSONObject("$set"));
        }
        return jSONObject;
    }

    private void mergeUserProperties(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!(jSONObject2.get(next) == null || jSONObject2.get(next) == JSONObject.NULL)) {
                jSONObject.put(next, jSONObject2.get(next));
            }
        }
    }

    private boolean isSetOnly(JSONObject jSONObject) {
        return isActionOnly(jSONObject, "$set");
    }

    private boolean isClearAll(JSONObject jSONObject) {
        return isActionOnly(jSONObject, "$clearAll");
    }

    private boolean isSetGroups(JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject("groups").length() > 0;
        } catch (JSONException unused) {
            return false;
        }
    }

    private boolean isActionOnly(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("user_properties");
            if (jSONObject2.length() != 1 || !jSONObject2.has(str)) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private long saveIdentifyProperties(JSONObject jSONObject) {
        return this.dbHelper.addIdentifyInterceptor(jSONObject.toString());
    }

    private boolean isIdentityUpdated(JSONObject jSONObject) {
        boolean z;
        try {
            if (!this.identitySet.getAndSet(true)) {
                this.userId = jSONObject.getString(AmplitudeClient.USER_ID_KEY);
                this.deviceId = jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY);
                return true;
            }
            if (isIdUpdated(this.userId, jSONObject.getString(AmplitudeClient.USER_ID_KEY))) {
                this.userId = jSONObject.getString(AmplitudeClient.USER_ID_KEY);
                z = true;
            } else {
                z = false;
            }
            if (!isIdUpdated(this.deviceId, jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY))) {
                return z;
            }
            this.deviceId = jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY);
            return true;
        } catch (JSONException unused) {
            return true;
        }
    }

    private boolean isIdUpdated(String str, String str2) {
        if (str == null && str2 == null) {
            return false;
        }
        if (str == null || str2 == null) {
            return true;
        }
        return !str.equals(str2);
    }
}
