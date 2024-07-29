package com.dooboolab.audiorecorderplayer;

import android.media.MediaPlayer;
import com.facebook.react.bridge.Promise;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNAudioRecorderPlayerModule$$ExternalSyntheticLambda2 implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ RNAudioRecorderPlayerModule f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Promise f$2;

    public /* synthetic */ RNAudioRecorderPlayerModule$$ExternalSyntheticLambda2(RNAudioRecorderPlayerModule rNAudioRecorderPlayerModule, String str, Promise promise) {
        this.f$0 = rNAudioRecorderPlayerModule;
        this.f$1 = str;
        this.f$2 = promise;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        RNAudioRecorderPlayerModule.startPlayer$lambda$4(this.f$0, this.f$1, this.f$2, mediaPlayer);
    }
}
