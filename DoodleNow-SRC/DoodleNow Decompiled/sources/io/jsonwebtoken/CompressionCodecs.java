package io.jsonwebtoken;

import io.jsonwebtoken.impl.compression.DeflateCompressionCodec;
import io.jsonwebtoken.impl.compression.GzipCompressionCodec;

public final class CompressionCodecs {
    public static final CompressionCodec DEFLATE = new DeflateCompressionCodec();
    public static final CompressionCodec GZIP = new GzipCompressionCodec();
    private static final CompressionCodecs INSTANCE = new CompressionCodecs();

    private CompressionCodecs() {
    }
}
