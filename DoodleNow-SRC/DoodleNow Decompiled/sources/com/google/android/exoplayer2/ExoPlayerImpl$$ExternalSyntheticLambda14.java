package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda14 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackInfo f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda14(PlaybackInfo playbackInfo) {
        this.f$0 = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerStateChanged(this.f$0.playWhenReady, this.f$0.playbackState);
    }
}
