package com.rnmaps.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class ImageReader {
    private final Context context;
    /* access modifiers changed from: private */
    public DataSource<CloseableReference<CloseableImage>> dataSource;
    /* access modifiers changed from: private */
    public final ImageReadable imp;
    private final DraweeHolder<?> logoHolder;
    private final ControllerListener<ImageInfo> mLogoControllerListener = new BaseControllerListener<ImageInfo>() {
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onFinalImageSet(java.lang.String r3, com.facebook.imagepipeline.image.ImageInfo r4, android.graphics.drawable.Animatable r5) {
            /*
                r2 = this;
                r3 = 0
                com.rnmaps.maps.ImageReader r4 = com.rnmaps.maps.ImageReader.this     // Catch:{ all -> 0x0059 }
                com.facebook.datasource.DataSource r4 = r4.dataSource     // Catch:{ all -> 0x0059 }
                java.lang.Object r4 = r4.getResult()     // Catch:{ all -> 0x0059 }
                com.facebook.common.references.CloseableReference r4 = (com.facebook.common.references.CloseableReference) r4     // Catch:{ all -> 0x0059 }
                if (r4 == 0) goto L_0x0041
                java.lang.Object r3 = r4.get()     // Catch:{ all -> 0x003f }
                com.facebook.imagepipeline.image.CloseableImage r3 = (com.facebook.imagepipeline.image.CloseableImage) r3     // Catch:{ all -> 0x003f }
                boolean r5 = r3 instanceof com.facebook.imagepipeline.image.CloseableStaticBitmap     // Catch:{ all -> 0x003f }
                if (r5 == 0) goto L_0x0041
                com.facebook.imagepipeline.image.CloseableStaticBitmap r3 = (com.facebook.imagepipeline.image.CloseableStaticBitmap) r3     // Catch:{ all -> 0x003f }
                android.graphics.Bitmap r3 = r3.getUnderlyingBitmap()     // Catch:{ all -> 0x003f }
                if (r3 == 0) goto L_0x0041
                android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x003f }
                r0 = 1
                android.graphics.Bitmap r3 = r3.copy(r5, r0)     // Catch:{ all -> 0x003f }
                com.rnmaps.maps.ImageReader r5 = com.rnmaps.maps.ImageReader.this     // Catch:{ all -> 0x003f }
                com.rnmaps.maps.ImageReadable r5 = r5.imp     // Catch:{ all -> 0x003f }
                r5.setIconBitmap(r3)     // Catch:{ all -> 0x003f }
                com.rnmaps.maps.ImageReader r5 = com.rnmaps.maps.ImageReader.this     // Catch:{ all -> 0x003f }
                com.rnmaps.maps.ImageReadable r5 = r5.imp     // Catch:{ all -> 0x003f }
                com.google.android.gms.maps.model.BitmapDescriptor r3 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r3)     // Catch:{ all -> 0x003f }
                r5.setIconBitmapDescriptor(r3)     // Catch:{ all -> 0x003f }
                goto L_0x0041
            L_0x003f:
                r3 = move-exception
                goto L_0x005d
            L_0x0041:
                com.rnmaps.maps.ImageReader r3 = com.rnmaps.maps.ImageReader.this
                com.facebook.datasource.DataSource r3 = r3.dataSource
                r3.close()
                if (r4 == 0) goto L_0x004f
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r4)
            L_0x004f:
                com.rnmaps.maps.ImageReader r3 = com.rnmaps.maps.ImageReader.this
                com.rnmaps.maps.ImageReadable r3 = r3.imp
                r3.update()
                return
            L_0x0059:
                r4 = move-exception
                r1 = r4
                r4 = r3
                r3 = r1
            L_0x005d:
                com.rnmaps.maps.ImageReader r5 = com.rnmaps.maps.ImageReader.this
                com.facebook.datasource.DataSource r5 = r5.dataSource
                r5.close()
                if (r4 == 0) goto L_0x006b
                com.facebook.common.references.CloseableReference.closeSafely((com.facebook.common.references.CloseableReference<?>) r4)
            L_0x006b:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.ImageReader.AnonymousClass1.onFinalImageSet(java.lang.String, com.facebook.imagepipeline.image.ImageInfo, android.graphics.drawable.Animatable):void");
        }
    };
    private final Resources resources;

    public ImageReader(Context context2, Resources resources2, ImageReadable imageReadable) {
        this.context = context2;
        this.resources = resources2;
        this.imp = imageReadable;
        DraweeHolder<?> create = DraweeHolder.create(createDraweeHeirarchy(resources2), context2);
        this.logoHolder = create;
        create.onAttach();
    }

    private GenericDraweeHierarchy createDraweeHeirarchy(Resources resources2) {
        return new GenericDraweeHierarchyBuilder(resources2).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0).build();
    }

    public void setImage(String str) {
        if (str == null) {
            this.imp.setIconBitmapDescriptor((BitmapDescriptor) null);
            this.imp.update();
        } else if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("file://") || str.startsWith("asset://") || str.startsWith("data:")) {
            ImageRequest build = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build();
            this.dataSource = Fresco.getImagePipeline().fetchDecodedImage(build, this);
            this.logoHolder.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setImageRequest(build)).setControllerListener(this.mLogoControllerListener)).setOldController(this.logoHolder.getController())).build());
        } else {
            this.imp.setIconBitmapDescriptor(getBitmapDescriptorByName(str));
            this.imp.setIconBitmap(BitmapFactory.decodeResource(this.resources, getDrawableResourceByName(str)));
            this.imp.update();
        }
    }

    private int getDrawableResourceByName(String str) {
        return this.resources.getIdentifier(str, "drawable", this.context.getPackageName());
    }

    private BitmapDescriptor getBitmapDescriptorByName(String str) {
        return BitmapDescriptorFactory.fromResource(getDrawableResourceByName(str));
    }
}
