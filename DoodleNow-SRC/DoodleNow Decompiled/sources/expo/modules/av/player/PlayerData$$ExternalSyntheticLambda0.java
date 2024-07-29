package expo.modules.av.player;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PlayerData$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ PlayerData f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ double f$2;

    public /* synthetic */ PlayerData$$ExternalSyntheticLambda0(PlayerData playerData, byte[] bArr, double d) {
        this.f$0 = playerData;
        this.f$1 = bArr;
        this.f$2 = d;
    }

    public final void run() {
        this.f$0.lambda$emitSampleBufferEvent$2(this.f$1, this.f$2);
    }
}
