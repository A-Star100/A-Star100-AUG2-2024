package com.onesignal.inAppMessages.internal;

import androidx.core.app.NotificationCompat;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageClickEvent;
import com.onesignal.inAppMessages.IInAppMessageClickResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageClickEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageClickEvent;", "msg", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "actn", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;)V", "_message", "_result", "message", "Lcom/onesignal/inAppMessages/IInAppMessage;", "getMessage", "()Lcom/onesignal/inAppMessages/IInAppMessage;", "result", "Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "getResult", "()Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "toJSONObject", "Lorg/json/JSONObject;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageClickEvent.kt */
public final class InAppMessageClickEvent implements IInAppMessageClickEvent {
    private final InAppMessage _message;
    private final InAppMessageClickResult _result;

    public InAppMessageClickEvent(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
        Intrinsics.checkNotNullParameter(inAppMessage, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessageClickResult, "actn");
        this._message = inAppMessage;
        this._result = inAppMessageClickResult;
    }

    public IInAppMessage getMessage() {
        return this._message;
    }

    public IInAppMessageClickResult getResult() {
        return this._result;
    }

    public final JSONObject toJSONObject() {
        JSONObject put = new JSONObject().put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, this._message.toJSONObject()).put("action", this._result.toJSONObject());
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …, _result.toJSONObject())");
        return put;
    }
}
