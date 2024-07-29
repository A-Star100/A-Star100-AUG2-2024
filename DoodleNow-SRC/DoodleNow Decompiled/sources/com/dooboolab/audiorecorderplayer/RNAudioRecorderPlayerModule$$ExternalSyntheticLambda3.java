package com.dooboolab.audiorecorderplayer;

import android.media.MediaPlayer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNAudioRecorderPlayerModule$$ExternalSyntheticLambda3 implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ RNAudioRecorderPlayerModule f$0;

    public /* synthetic */ RNAudioRecorderPlayerModule$$ExternalSyntheticLambda3(RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule) {
        this.f$0 = rNAudioRecorderPlayerModule;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        RNAudioRecorderPlayerModule.startPlayer$lambda$5(this.f$0, mediaPlayer);
    }
}
