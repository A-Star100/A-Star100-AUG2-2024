package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.StampStyle;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public class SpriteStyle extends StampStyle {

    /* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
    public static final class Builder extends StampStyle.Builder<Builder> {
        private Builder() {
        }

        /* synthetic */ Builder(zzs zzs) {
        }

        public SpriteStyle build() {
            return new SpriteStyle(this.zza);
        }

        /* access modifiers changed from: protected */
        public Builder self() {
            return this;
        }
    }

    public SpriteStyle(BitmapDescriptor bitmapDescriptor) {
        super(bitmapDescriptor);
    }

    public static Builder newBuilder(BitmapDescriptor bitmapDescriptor) {
        return (Builder) new Builder((zzs) null).stamp(bitmapDescriptor);
    }
}
