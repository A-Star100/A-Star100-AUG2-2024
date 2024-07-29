package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.InfluenceChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/onesignal/session/internal/outcomes/impl/CachedUniqueOutcome;", "", "influenceId", "", "channel", "Lcom/onesignal/session/internal/influence/InfluenceChannel;", "(Ljava/lang/String;Lcom/onesignal/session/internal/influence/InfluenceChannel;)V", "getChannel", "()Lcom/onesignal/session/internal/influence/InfluenceChannel;", "getInfluenceId", "()Ljava/lang/String;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CachedUniqueOutcome.kt */
public final class CachedUniqueOutcome {
    private final InfluenceChannel channel;
    private final String influenceId;

    public final InfluenceChannel getChannel() {
        return this.channel;
    }

    public final String getInfluenceId() {
        return this.influenceId;
    }

    public CachedUniqueOutcome(String str, InfluenceChannel influenceChannel) {
        Intrinsics.checkNotNullParameter(str, "influenceId");
        Intrinsics.checkNotNullParameter(influenceChannel, "channel");
        this.influenceId = str;
        this.channel = influenceChannel;
    }
}
