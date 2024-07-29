package expo.modules.kotlin.functions;

import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u00012\u000e\b\u0004\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\bø\u0001\u0000J#\u0010\u0010\u001a\u00020\u00112\u0010\b\u0004\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\bø\u0001\u0000¢\u0006\u0002\b\u0015JA\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u00012#\b\u0004\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00120\u0017H\bø\u0001\u0000J^\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u000128\b\u0004\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00120\u001bH\bø\u0001\u0000J{\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012M\b\u0004\u0010\u0013\u001aG\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00120\u001eH\bø\u0001\u0000J\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012b\b\u0004\u0010\u0013\u001a\\\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00120!H\bø\u0001\u0000Jµ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012w\b\u0004\u0010\u0013\u001aq\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u00120$H\bø\u0001\u0000JÔ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012\u0001\b\u0004\u0010\u0013\u001a\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00120'H\bø\u0001\u0000Jñ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012¢\u0001\b\u0004\u0010\u0013\u001a\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00120*H\bø\u0001\u0000J\u0002\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u0001\"\u0006\b\b\u0010,\u0018\u00012·\u0001\b\u0004\u0010\u0013\u001a°\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u00120-H\bø\u0001\u0000J\u0002\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012·\u0001\b\u0004\u0010\u0013\u001a°\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H\u00120-H\bø\u0001\u0000¢\u0006\u0002\b0Jî\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012¢\u0001\b\u0004\u0010\u0013\u001a\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H\u00120*H\bø\u0001\u0000¢\u0006\u0002\b0JÑ\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012\u0001\b\u0004\u0010\u0013\u001a\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00120'H\bø\u0001\u0000¢\u0006\u0002\b0J²\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012w\b\u0004\u0010\u0013\u001aq\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0004\u0012\u0002H\u00120$H\bø\u0001\u0000¢\u0006\u0002\b0J\u0001\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012b\b\u0004\u0010\u0013\u001a\\\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u00120!H\bø\u0001\u0000¢\u0006\u0002\b0Jx\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u00012M\b\u0004\u0010\u0013\u001aG\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u0002H\u00120\u001eH\bø\u0001\u0000¢\u0006\u0002\b0J[\u0010\u0010\u001a\u00020\u0011\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u000128\b\u0004\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u00120\u001bH\bø\u0001\u0000¢\u0006\u0002\b0J6\u00101\u001a\u00020\u0006\"\u0006\b\u0000\u0010\u0012\u0018\u00012\u001e\b\u0004\u00102\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\b¢\u0006\u0002\u00104JS\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u000123\b\u0004\u00102\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bH\b¢\u0006\u0002\u00106Jp\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u00012H\b\u0004\u00102\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\b¢\u0006\u0002\u00107J\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u00012]\b\u0004\u00102\u001aW\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\b¢\u0006\u0002\u00108Jª\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u00012r\b\u0004\u00102\u001al\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\b¢\u0006\u0002\u00109JÉ\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u00012\u0001\b\u0004\u00102\u001a\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010'H\b¢\u0006\u0002\u0010:Jæ\u0001\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u00012\u0001\b\u0004\u00102\u001a\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010*H\b¢\u0006\u0002\u0010;J\u0002\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u00012²\u0001\b\u0004\u00102\u001a«\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010-H\b¢\u0006\u0002\u0010<J \u0002\u00101\u001a\u000205\"\u0006\b\u0000\u0010\u0012\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001a\u0018\u0001\"\u0006\b\u0003\u0010\u001d\u0018\u0001\"\u0006\b\u0004\u0010 \u0018\u0001\"\u0006\b\u0005\u0010#\u0018\u0001\"\u0006\b\u0006\u0010&\u0018\u0001\"\u0006\b\u0007\u0010)\u0018\u0001\"\u0006\b\b\u0010,\u0018\u00012Ç\u0001\b\u0004\u00102\u001aÀ\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H ¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\"\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H&¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H)¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(+\u0012\u0013\u0012\u0011H,¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001203\u0012\u0006\u0012\u0004\u0018\u00010\u00010=H\b¢\u0006\u0002\u0010>J\r\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b20\u0001¨\u0006A"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "", "name", "", "(Ljava/lang/String;)V", "asyncFunctionComponent", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "getAsyncFunctionComponent$annotations", "()V", "getAsyncFunctionComponent", "()Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "setAsyncFunctionComponent", "(Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;)V", "getName$annotations", "getName", "()Ljava/lang/String;", "AsyncBody", "Lexpo/modules/kotlin/functions/AsyncFunction;", "R", "body", "Lkotlin/Function0;", "AsyncBodyWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "SuspendBody", "block", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function2;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function3;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function4;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function5;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function6;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function7;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "(Lkotlin/jvm/functions/Function8;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "Lkotlin/Function9;", "(Lkotlin/jvm/functions/Function9;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AsyncFunctionBuilder.kt */
public final class AsyncFunctionBuilder {
    private BaseAsyncFunctionComponent asyncFunctionComponent;
    private final String name;

    public static /* synthetic */ void getAsyncFunctionComponent$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public final BaseAsyncFunctionComponent getAsyncFunctionComponent() {
        return this.asyncFunctionComponent;
    }

    public final String getName() {
        return this.name;
    }

    public final void setAsyncFunctionComponent(BaseAsyncFunctionComponent baseAsyncFunctionComponent) {
        this.asyncFunctionComponent = baseAsyncFunctionComponent;
    }

    public AsyncFunctionBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final /* synthetic */ <R> BaseAsyncFunctionComponent SuspendBody(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        BaseAsyncFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(getName(), new AnyType[0], new AsyncFunctionBuilder$SuspendBody$1(function1, (Continuation<? super AsyncFunctionBuilder$SuspendBody$1>) null));
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SuspendFunctionComponent SuspendBody(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$3(function2, (Continuation<? super AsyncFunctionBuilder$SuspendBody$3>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SuspendFunctionComponent SuspendBody(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$3.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$5(function3, (Continuation<? super AsyncFunctionBuilder$SuspendBody$5>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SuspendFunctionComponent SuspendBody(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$4.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$6.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$7(function4, (Continuation<? super AsyncFunctionBuilder$SuspendBody$7>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SuspendFunctionComponent SuspendBody(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> function5) {
        Intrinsics.checkNotNullParameter(function5, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$7.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$10.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$9(function5, (Continuation<? super AsyncFunctionBuilder$SuspendBody$9>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SuspendFunctionComponent SuspendBody(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function6) {
        Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function62 = function6;
        Intrinsics.checkNotNullParameter(function62, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$15.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$11(function62, (Continuation<? super AsyncFunctionBuilder$SuspendBody$11>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SuspendFunctionComponent SuspendBody(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> function7) {
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> function72 = function7;
        Intrinsics.checkNotNullParameter(function72, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$16.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$21.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$13(function72, (Continuation<? super AsyncFunctionBuilder$SuspendBody$13>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SuspendFunctionComponent SuspendBody(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> function8) {
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> function82 = function8;
        Intrinsics.checkNotNullParameter(function82, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$25.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$28.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$15(function82, (Continuation<? super AsyncFunctionBuilder$SuspendBody$15>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SuspendFunctionComponent SuspendBody(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> function9) {
        Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> function92 = function9;
        Intrinsics.checkNotNullParameter(function92, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P7");
        Class cls8 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$31.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$36.INSTANCE))}, new AsyncFunctionBuilder$SuspendBody$17(function92, (Continuation<? super AsyncFunctionBuilder$SuspendBody$17>) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        setAsyncFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public final AsyncFunction AsyncBodyWithoutArgs(Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        AsyncFunction asyncFunctionComponent2 = new AsyncFunctionComponent(getName(), new AnyType[0], new AsyncFunctionBuilder$AsyncBody$1(function0));
        setAsyncFunctionComponent(asyncFunctionComponent2);
        return asyncFunctionComponent2;
    }

    public final /* synthetic */ <R> AsyncFunction AsyncBody(Function0<? extends R> function0) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        String name2 = getName();
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$3 = new AsyncFunctionBuilder$AsyncBody$3(function0);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$3);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$3);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncBody(Function1<? super P0, ? extends R> function1) {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunctionComponent2;
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(getName(), new AnyType[0], new AsyncFunctionBuilder$AsyncBody$5(function1));
        } else {
            String name2 = getName();
            Intrinsics.reifiedOperationMarker(4, "P0");
            Class cls = Object.class;
            Intrinsics.needClassReification();
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$1.INSTANCE))};
            Intrinsics.needClassReification();
            Function1 asyncFunctionBuilder$AsyncBody$6 = new AsyncFunctionBuilder$AsyncBody$6(function1);
            Intrinsics.reifiedOperationMarker(3, "R");
            Intrinsics.reifiedOperationMarker(4, "R");
            Class<Object> cls2 = Object.class;
            Class cls3 = cls2;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunctionComponent2 = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunctionComponent2 = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunctionComponent2 = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunctionComponent2 = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$6);
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$6);
            }
            asyncFunction = asyncFunctionComponent2;
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncBody(Function2<? super P0, ? super P1, ? extends R> function2) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$3.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$8 = new AsyncFunctionBuilder$AsyncBody$8(function2);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls3 = Object.class;
        Class cls4 = cls3;
        if (Intrinsics.areEqual((Object) cls3, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$8);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$8);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunctionWithPromise(Function2<? super P0, ? super Promise, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$4.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$10(function2));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncBody(Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$6.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$7.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$12 = new AsyncFunctionBuilder$AsyncBody$12(function3);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls4 = Object.class;
        Class cls5 = cls4;
        if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$12);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$12);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncFunctionWithPromise(Function3<? super P0, ? super P1, ? super Promise, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$9.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$14(function3));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncBody(Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(function4, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$10.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$13.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$16 = new AsyncFunctionBuilder$AsyncBody$16(function4);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls5 = Object.class;
        Class cls6 = cls5;
        if (Intrinsics.areEqual((Object) cls5, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$16);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$16);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncFunctionWithPromise(Function4<? super P0, ? super P1, ? super P2, ? super Promise, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(function4, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$15.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$16.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$18(function4));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncBody(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(function5, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$21.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$20 = new AsyncFunctionBuilder$AsyncBody$20(function5);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls6 = Object.class;
        Class cls7 = cls6;
        if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$20);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$20);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncFunctionWithPromise(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Promise, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(function5, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$25.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$22(function5));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncBody(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(function6, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$28.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$31.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$24 = new AsyncFunctionBuilder$AsyncBody$24(function6);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls7 = Object.class;
        Class cls8 = cls7;
        if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$24);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$24);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncFunctionWithPromise(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Promise, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(function6, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$36.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$26(function6));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncBody(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        AsyncFunction asyncFunction;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(function72, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$37.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$38.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$39.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$40.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$41.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$42.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$43.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$28 = new AsyncFunctionBuilder$AsyncBody$28(function72);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls8 = Object.class;
        Class cls9 = cls8;
        if (Intrinsics.areEqual((Object) cls8, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$28);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$28);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncFunctionWithPromise(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> function7) {
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(function72, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$44.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$45.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$46.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$47.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$48.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$49.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$30(function72));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunction AsyncBody(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        AsyncFunction asyncFunction;
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(function82, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P7");
        Class cls8 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$50.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$51.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$52.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$53.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$54.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$55.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$56.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$57.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 asyncFunctionBuilder$AsyncBody$32 = new AsyncFunctionBuilder$AsyncBody$32(function82);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls9 = Object.class;
        Class cls10 = cls9;
        if (Intrinsics.areEqual((Object) cls9, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$32);
        } else {
            asyncFunction = new AsyncFunctionComponent(name2, anyTypeArr, asyncFunctionBuilder$AsyncBody$32);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        setAsyncFunctionComponent(asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncFunctionWithPromise(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> function8) {
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(function82, TtmlNode.TAG_BODY);
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P1");
        Class cls2 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P2");
        Class cls3 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P3");
        Class cls4 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P4");
        Class cls5 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P5");
        Class cls6 = Object.class;
        Intrinsics.reifiedOperationMarker(4, "P6");
        Class cls7 = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$58.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$59.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$60.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$61.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$62.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$63.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, AsyncFunctionBuilder$AsyncBody$$inlined$toArgsArray$default$64.INSTANCE))}, new AsyncFunctionBuilder$AsyncBody$34(function82));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        setAsyncFunctionComponent(asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final BaseAsyncFunctionComponent build$expo_modules_core_release() {
        BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.asyncFunctionComponent;
        if (baseAsyncFunctionComponent != null) {
            return baseAsyncFunctionComponent;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
