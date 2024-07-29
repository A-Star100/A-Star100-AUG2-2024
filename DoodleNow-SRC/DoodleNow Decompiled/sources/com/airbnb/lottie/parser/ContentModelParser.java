package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

class ContentModelParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("ty", "d");

    private ContentModelParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c6, code lost:
        if (r2.equals("gf") == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ContentModel parse(com.airbnb.lottie.parser.moshi.JsonReader r7, com.airbnb.lottie.LottieComposition r8) throws java.io.IOException {
        /*
            r7.beginObject()
            r0 = 2
            r1 = r0
        L_0x0005:
            boolean r2 = r7.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = NAMES
            int r2 = r7.selectName(r2)
            if (r2 == 0) goto L_0x0023
            if (r2 == r3) goto L_0x001e
            r7.skipName()
            r7.skipValue()
            goto L_0x0005
        L_0x001e:
            int r1 = r7.nextInt()
            goto L_0x0005
        L_0x0023:
            java.lang.String r2 = r7.nextString()
            goto L_0x0029
        L_0x0028:
            r2 = r4
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r2.hashCode()
            int r5 = r2.hashCode()
            r6 = -1
            switch(r5) {
                case 3239: goto L_0x00d6;
                case 3270: goto L_0x00ca;
                case 3295: goto L_0x00c0;
                case 3307: goto L_0x00b4;
                case 3308: goto L_0x00a9;
                case 3488: goto L_0x009e;
                case 3633: goto L_0x0093;
                case 3634: goto L_0x0088;
                case 3646: goto L_0x007c;
                case 3669: goto L_0x006f;
                case 3679: goto L_0x0062;
                case 3681: goto L_0x0055;
                case 3705: goto L_0x0048;
                case 3710: goto L_0x003a;
                default: goto L_0x0037;
            }
        L_0x0037:
            r0 = r6
            goto L_0x00e1
        L_0x003a:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0044
            goto L_0x0037
        L_0x0044:
            r0 = 13
            goto L_0x00e1
        L_0x0048:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0051
            goto L_0x0037
        L_0x0051:
            r0 = 12
            goto L_0x00e1
        L_0x0055:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x005e
            goto L_0x0037
        L_0x005e:
            r0 = 11
            goto L_0x00e1
        L_0x0062:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x006b
            goto L_0x0037
        L_0x006b:
            r0 = 10
            goto L_0x00e1
        L_0x006f:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0078
            goto L_0x0037
        L_0x0078:
            r0 = 9
            goto L_0x00e1
        L_0x007c:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0085
            goto L_0x0037
        L_0x0085:
            r0 = 8
            goto L_0x00e1
        L_0x0088:
            java.lang.String r0 = "rd"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0091
            goto L_0x0037
        L_0x0091:
            r0 = 7
            goto L_0x00e1
        L_0x0093:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x009c
            goto L_0x0037
        L_0x009c:
            r0 = 6
            goto L_0x00e1
        L_0x009e:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00a7
            goto L_0x0037
        L_0x00a7:
            r0 = 5
            goto L_0x00e1
        L_0x00a9:
            java.lang.String r0 = "gs"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00b2
            goto L_0x0037
        L_0x00b2:
            r0 = 4
            goto L_0x00e1
        L_0x00b4:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00be
            goto L_0x0037
        L_0x00be:
            r0 = 3
            goto L_0x00e1
        L_0x00c0:
            java.lang.String r3 = "gf"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00e1
            goto L_0x0037
        L_0x00ca:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00d4
            goto L_0x0037
        L_0x00d4:
            r0 = r3
            goto L_0x00e1
        L_0x00d6:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x00e0
            goto L_0x0037
        L_0x00e0:
            r0 = 0
        L_0x00e1:
            switch(r0) {
                case 0: goto L_0x013c;
                case 1: goto L_0x0137;
                case 2: goto L_0x0132;
                case 3: goto L_0x012d;
                case 4: goto L_0x0128;
                case 5: goto L_0x011e;
                case 6: goto L_0x0119;
                case 7: goto L_0x0114;
                case 8: goto L_0x010f;
                case 9: goto L_0x010a;
                case 10: goto L_0x0105;
                case 11: goto L_0x0100;
                case 12: goto L_0x00fb;
                case 13: goto L_0x00f6;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Unknown shape type "
            r8.<init>(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.airbnb.lottie.utils.Logger.warning(r8)
            goto L_0x0140
        L_0x00f6:
            com.airbnb.lottie.model.animatable.AnimatableTransform r4 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r7, r8)
            goto L_0x0140
        L_0x00fb:
            com.airbnb.lottie.model.content.ShapeTrimPath r4 = com.airbnb.lottie.parser.ShapeTrimPathParser.parse(r7, r8)
            goto L_0x0140
        L_0x0100:
            com.airbnb.lottie.model.content.ShapeStroke r4 = com.airbnb.lottie.parser.ShapeStrokeParser.parse(r7, r8)
            goto L_0x0140
        L_0x0105:
            com.airbnb.lottie.model.content.PolystarShape r4 = com.airbnb.lottie.parser.PolystarShapeParser.parse(r7, r8, r1)
            goto L_0x0140
        L_0x010a:
            com.airbnb.lottie.model.content.ShapePath r4 = com.airbnb.lottie.parser.ShapePathParser.parse(r7, r8)
            goto L_0x0140
        L_0x010f:
            com.airbnb.lottie.model.content.Repeater r4 = com.airbnb.lottie.parser.RepeaterParser.parse(r7, r8)
            goto L_0x0140
        L_0x0114:
            com.airbnb.lottie.model.content.RoundedCorners r4 = com.airbnb.lottie.parser.RoundedCornersParser.parse(r7, r8)
            goto L_0x0140
        L_0x0119:
            com.airbnb.lottie.model.content.RectangleShape r4 = com.airbnb.lottie.parser.RectangleShapeParser.parse(r7, r8)
            goto L_0x0140
        L_0x011e:
            com.airbnb.lottie.model.content.MergePaths r4 = com.airbnb.lottie.parser.MergePathsParser.parse(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.addWarning(r0)
            goto L_0x0140
        L_0x0128:
            com.airbnb.lottie.model.content.GradientStroke r4 = com.airbnb.lottie.parser.GradientStrokeParser.parse(r7, r8)
            goto L_0x0140
        L_0x012d:
            com.airbnb.lottie.model.content.ShapeGroup r4 = com.airbnb.lottie.parser.ShapeGroupParser.parse(r7, r8)
            goto L_0x0140
        L_0x0132:
            com.airbnb.lottie.model.content.GradientFill r4 = com.airbnb.lottie.parser.GradientFillParser.parse(r7, r8)
            goto L_0x0140
        L_0x0137:
            com.airbnb.lottie.model.content.ShapeFill r4 = com.airbnb.lottie.parser.ShapeFillParser.parse(r7, r8)
            goto L_0x0140
        L_0x013c:
            com.airbnb.lottie.model.content.CircleShape r4 = com.airbnb.lottie.parser.CircleShapeParser.parse(r7, r8, r1)
        L_0x0140:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x014a
            r7.skipValue()
            goto L_0x0140
        L_0x014a:
            r7.endObject()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ContentModelParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
