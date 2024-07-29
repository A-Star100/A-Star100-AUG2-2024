package com.facebook.imagepipeline.core;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/facebook/imagepipeline/producers/Producer;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProducerSequenceFactory.kt */
final class ProducerSequenceFactory$qualifiedResourceFetchSequence$2 extends Lambda implements Function0<Producer<CloseableReference<CloseableImage>>> {
    final /* synthetic */ ProducerSequenceFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProducerSequenceFactory$qualifiedResourceFetchSequence$2(ProducerSequenceFactory producerSequenceFactory) {
        super(0);
        this.this$0 = producerSequenceFactory;
    }

    public final Producer<CloseableReference<CloseableImage>> invoke() {
        QualifiedResourceFetchProducer newQualifiedResourceFetchProducer = this.this$0.producerFactory.newQualifiedResourceFetchProducer();
        Intrinsics.checkNotNullExpressionValue(newQualifiedResourceFetchProducer, "producerFactory.newQuali…edResourceFetchProducer()");
        return this.this$0.newBitmapCacheGetToLocalTransformSequence(newQualifiedResourceFetchProducer);
    }
}
