package expo.modules.kotlin.objects;

import com.amazon.a.a.o.b;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.FunctionBuilder;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.Enumerable;
import expo.modules.kotlin.types.LazyKType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0005J,\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u000fH\bø\u0001\u0000J+\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00052\u0010\b\u0004\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\bø\u0001\u0000¢\u0006\u0002\b+JI\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u00012\u0006\u0010(\u001a\u00020\u00052#\b\u0004\u0010*\u001a\u001d\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H)0-H\bø\u0001\u0000Jf\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u00012\u0006\u0010(\u001a\u00020\u000528\b\u0004\u0010*\u001a2\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002H)01H\bø\u0001\u0000J\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u00012\u0006\u0010(\u001a\u00020\u00052M\b\u0004\u0010*\u001aG\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002H)04H\bø\u0001\u0000J \u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u00012\u0006\u0010(\u001a\u00020\u00052b\b\u0004\u0010*\u001a\\\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H)07H\bø\u0001\u0000J½\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u00012\u0006\u0010(\u001a\u00020\u00052w\b\u0004\u0010*\u001aq\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H)0:H\bø\u0001\u0000JÜ\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u0001\b\u0004\u0010*\u001a\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002H)0=H\bø\u0001\u0000Jù\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u00012\u0006\u0010(\u001a\u00020\u00052¢\u0001\b\u0004\u0010*\u001a\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H)0@H\bø\u0001\u0000J\u0002\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u0001\"\u0006\b\b\u0010B\u0018\u00012\u0006\u0010(\u001a\u00020\u00052·\u0001\b\u0004\u0010*\u001a°\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002H)0CH\bø\u0001\u0000J\u0002\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u00012\u0006\u0010(\u001a\u00020\u00052·\u0001\b\u0004\u0010*\u001a°\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002H)0CH\bø\u0001\u0000¢\u0006\u0002\bFJö\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u00012\u0006\u0010(\u001a\u00020\u00052¢\u0001\b\u0004\u0010*\u001a\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H)0@H\bø\u0001\u0000¢\u0006\u0002\bFJÙ\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u0001\b\u0004\u0010*\u001a\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002H)0=H\bø\u0001\u0000¢\u0006\u0002\bFJº\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u00012\u0006\u0010(\u001a\u00020\u00052w\b\u0004\u0010*\u001aq\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H)0:H\bø\u0001\u0000¢\u0006\u0002\bFJ\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u00012\u0006\u0010(\u001a\u00020\u00052b\b\u0004\u0010*\u001a\\\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H)07H\bø\u0001\u0000¢\u0006\u0002\bFJ\u0001\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u00012\u0006\u0010(\u001a\u00020\u00052M\b\u0004\u0010*\u001aG\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002H)04H\bø\u0001\u0000¢\u0006\u0002\bFJc\u0010'\u001a\u00020\b\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u00012\u0006\u0010(\u001a\u00020\u000528\b\u0004\u0010*\u001a2\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110E¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002H)01H\bø\u0001\u0000¢\u0006\u0002\bFJ\"\u0010G\u001a\u00020H2\u001a\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00100\u000fJ;\u0010G\u001a\u00020H2.\u0010I\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010K0J\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010K¢\u0006\u0002\u0010LJ\u001f\u0010M\u001a\u00020H\"\u0014\b\u0000\u0010N\u0018\u0001*\u00020O*\b\u0012\u0004\u0012\u0002HN0PH\bJ\u001d\u0010M\u001a\u00020H2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00050JH\u0007¢\u0006\u0004\bR\u0010SJ\u001f\u0010M\u001a\u00020H2\u0012\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050J\"\u00020\u0005¢\u0006\u0002\u0010SJ\u000e\u0010T\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0005J,\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0\u000fH\bø\u0001\u0000J+\u0010T\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00052\u0010\b\u0004\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fH\bø\u0001\u0000¢\u0006\u0002\bUJI\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u00012\u0006\u0010(\u001a\u00020\u00052#\b\u0004\u0010*\u001a\u001d\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H)0-H\bø\u0001\u0000Jf\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u00012\u0006\u0010(\u001a\u00020\u000528\b\u0004\u0010*\u001a2\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002H)01H\bø\u0001\u0000J\u0001\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u00012\u0006\u0010(\u001a\u00020\u00052M\b\u0004\u0010*\u001aG\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002H)04H\bø\u0001\u0000J \u0001\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u00012\u0006\u0010(\u001a\u00020\u00052b\b\u0004\u0010*\u001a\\\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0004\u0012\u0002H)07H\bø\u0001\u0000J½\u0001\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u00012\u0006\u0010(\u001a\u00020\u00052w\b\u0004\u0010*\u001aq\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002H)0:H\bø\u0001\u0000JÜ\u0001\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u00012\u0006\u0010(\u001a\u00020\u00052\u0001\b\u0004\u0010*\u001a\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002H)0=H\bø\u0001\u0000Jù\u0001\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u00012\u0006\u0010(\u001a\u00020\u00052¢\u0001\b\u0004\u0010*\u001a\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002H)0@H\bø\u0001\u0000J\u0002\u0010T\u001a\u00020#\"\u0006\b\u0000\u0010)\u0018\u0001\"\u0006\b\u0001\u0010,\u0018\u0001\"\u0006\b\u0002\u00100\u0018\u0001\"\u0006\b\u0003\u00103\u0018\u0001\"\u0006\b\u0004\u00106\u0018\u0001\"\u0006\b\u0005\u00109\u0018\u0001\"\u0006\b\u0006\u0010<\u0018\u0001\"\u0006\b\u0007\u0010?\u0018\u0001\"\u0006\b\b\u0010B\u0018\u00012\u0006\u0010(\u001a\u00020\u00052·\u0001\b\u0004\u0010*\u001a°\u0001\u0012\u0013\u0012\u0011H,¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(/\u0012\u0013\u0012\u0011H0¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(2\u0012\u0013\u0012\u0011H3¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H6¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(8\u0012\u0013\u0012\u0011H9¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H<¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002H)0CH\bø\u0001\u0000J\u001c\u0010V\u001a\u00020H2\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020H0\u000fH\bø\u0001\u0000J\u001c\u0010W\u001a\u00020H2\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u00020H0\u000fH\bø\u0001\u0000J\u0010\u0010X\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0005H\u0016J*\u0010X\u001a\u00020\u0019\"\u0004\b\u0000\u0010N2\u0006\u0010(\u001a\u00020\u00052\u000e\b\u0004\u0010*\u001a\b\u0012\u0004\u0012\u0002HN0\u000fH\bø\u0001\u0000J\u0006\u0010Y\u001a\u00020ZR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00100\u000fX\u000e¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR0\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR0\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006["}, d2 = {"Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "", "()V", "asyncFunctionBuilders", "", "", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "asyncFunctions", "Lexpo/modules/kotlin/functions/AsyncFunction;", "getAsyncFunctions$annotations", "getAsyncFunctions", "()Ljava/util/Map;", "setAsyncFunctions", "(Ljava/util/Map;)V", "constantsProvider", "Lkotlin/Function0;", "", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "getEventsDefinition$annotations", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", "setEventsDefinition", "(Lexpo/modules/kotlin/events/EventsDefinition;)V", "properties", "Lexpo/modules/kotlin/objects/PropertyComponentBuilder;", "getProperties$annotations", "getProperties", "setProperties", "syncFunctionBuilder", "Lexpo/modules/kotlin/functions/FunctionBuilder;", "getSyncFunctionBuilder$annotations", "getSyncFunctionBuilder", "setSyncFunctionBuilder", "syncFunctions", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getSyncFunctions$annotations", "getSyncFunctions", "setSyncFunctions", "AsyncFunction", "name", "R", "body", "AsyncFunctionWithoutArgs", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "Constants", "", "constants", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "Events", "T", "Lexpo/modules/kotlin/types/Enumerable;", "", "events", "EventsWithArray", "([Ljava/lang/String;)V", "Function", "FunctionWithoutArgs", "OnStartObserving", "OnStopObserving", "Property", "buildObject", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public class ObjectDefinitionBuilder {
    private Map<String, AsyncFunctionBuilder> asyncFunctionBuilders = new LinkedHashMap();
    private Map<String, AsyncFunction> asyncFunctions = new LinkedHashMap();
    private Function0<? extends Map<String, ? extends Object>> constantsProvider = ObjectDefinitionBuilder$constantsProvider$1.INSTANCE;
    private EventsDefinition eventsDefinition;
    private Map<String, PropertyComponentBuilder> properties = new LinkedHashMap();
    private Map<String, FunctionBuilder> syncFunctionBuilder = new LinkedHashMap();
    private Map<String, SyncFunctionComponent> syncFunctions = new LinkedHashMap();

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getEventsDefinition$annotations() {
    }

    public static /* synthetic */ void getProperties$annotations() {
    }

    public static /* synthetic */ void getSyncFunctionBuilder$annotations() {
    }

    public static /* synthetic */ void getSyncFunctions$annotations() {
    }

    public final void Constants(Function0<? extends Map<String, ? extends Object>> function0) {
        Intrinsics.checkNotNullParameter(function0, "constantsProvider");
        this.constantsProvider = function0;
    }

    public final Map<String, AsyncFunction> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    public final Map<String, PropertyComponentBuilder> getProperties() {
        return this.properties;
    }

    public final Map<String, FunctionBuilder> getSyncFunctionBuilder() {
        return this.syncFunctionBuilder;
    }

    public final Map<String, SyncFunctionComponent> getSyncFunctions() {
        return this.syncFunctions;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunction> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final void setEventsDefinition(EventsDefinition eventsDefinition2) {
        this.eventsDefinition = eventsDefinition2;
    }

    public final void setProperties(Map<String, PropertyComponentBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.properties = map;
    }

    public final void setSyncFunctionBuilder(Map<String, FunctionBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctionBuilder = map;
    }

    public final void setSyncFunctions(Map<String, SyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.syncFunctions = map;
    }

    public final void Constants(Pair<String, ? extends Object>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "constants");
        this.constantsProvider = new ObjectDefinitionBuilder$Constants$1(pairArr);
    }

    public final FunctionBuilder Function(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        FunctionBuilder functionBuilder = new FunctionBuilder(str);
        this.syncFunctionBuilder.put(str, functionBuilder);
        return functionBuilder;
    }

    public final SyncFunctionComponent FunctionWithoutArgs(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$Function$2(function0));
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent Function(String str, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$Function$4(function0));
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent Function(String str, Function1<? super P0, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$3.INSTANCE))}, new ObjectDefinitionBuilder$Function$6(function1));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent Function(String str, Function2<? super P0, ? super P1, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$1.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$2.INSTANCE))}, new ObjectDefinitionBuilder$Function$8(function2));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent Function(String str, Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$4.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$6.INSTANCE))}, new ObjectDefinitionBuilder$Function$10(function3));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent Function(String str, Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$7.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$10.INSTANCE))}, new ObjectDefinitionBuilder$Function$12(function4));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent Function(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function5, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$15.INSTANCE))}, new ObjectDefinitionBuilder$Function$14(function5));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent Function(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        String str2 = str;
        Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function62 = function6;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function62, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$16.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$21.INSTANCE))}, new ObjectDefinitionBuilder$Function$16(function62));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str2, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Function(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        String str2 = str;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function72, TtmlNode.TAG_BODY);
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
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$25.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$28.INSTANCE))}, new ObjectDefinitionBuilder$Function$18(function72));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str2, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Function(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function82, TtmlNode.TAG_BODY);
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
        String str2 = str;
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$31.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, ObjectDefinitionBuilder$Function$$inlined$toArgsArray$default$36.INSTANCE))}, new ObjectDefinitionBuilder$Function$20(function82));
        SyncFunctionComponent syncFunctionComponent2 = syncFunctionComponent;
        getSyncFunctions().put(str2, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final AsyncFunction AsyncFunctionWithoutArgs(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        AsyncFunction asyncFunctionComponent = new AsyncFunctionComponent(str, new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$1(function0));
        getAsyncFunctions().put(str, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunction(String str, Function1<? super P0, ? extends R> function1) {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Intrinsics.areEqual((Object) Object.class, (Object) Promise.class)) {
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str, new AnyType[0], new ObjectDefinitionBuilder$AsyncFunction$5(function1));
        } else {
            Intrinsics.reifiedOperationMarker(4, "P0");
            Class cls = Object.class;
            Intrinsics.needClassReification();
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1.INSTANCE))};
            Intrinsics.needClassReification();
            Function1 objectDefinitionBuilder$AsyncFunction$6 = new ObjectDefinitionBuilder$AsyncFunction$6(function1);
            Intrinsics.reifiedOperationMarker(3, "R");
            Intrinsics.reifiedOperationMarker(4, "R");
            Class<Object> cls2 = Object.class;
            Class cls3 = cls2;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunctionComponent = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunctionComponent = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunctionComponent = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunctionComponent = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunctionComponent = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$6);
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$6);
            }
            asyncFunction = asyncFunctionComponent;
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunctionWithPromise(String str, Function2<? super P0, ? super Promise, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        Class cls = Object.class;
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$10(function2));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncFunctionWithPromise(String str, Function3<? super P0, ? super P1, ? super Promise, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$14(function3));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncFunctionWithPromise(String str, Function4<? super P0, ? super P1, ? super P2, ? super Promise, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, TtmlNode.TAG_BODY);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$18(function4));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncFunctionWithPromise(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Promise, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function5, TtmlNode.TAG_BODY);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$22(function5));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncFunctionWithPromise(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Promise, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function6, TtmlNode.TAG_BODY);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$26(function6));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncFunctionWithPromise(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> function7) {
        String str2 = str;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function72, TtmlNode.TAG_BODY);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$30(function72));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str2, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncFunctionWithPromise(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> function8) {
        String str2 = str;
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function82, TtmlNode.TAG_BODY);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64.INSTANCE))}, new ObjectDefinitionBuilder$AsyncFunction$34(function82));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str2, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final AsyncFunctionBuilder AsyncFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(str);
        this.asyncFunctionBuilders.put(str, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    public final void Events(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "events");
        this.eventsDefinition = new EventsDefinition(strArr);
    }

    public final void EventsWithArray(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "events");
        this.eventsDefinition = new EventsDefinition(strArr);
    }

    public final /* synthetic */ <T extends Enum<T> & Enumerable> void Events() {
        List list;
        List<KParameter> parameters;
        Object obj;
        Intrinsics.reifiedOperationMarker(4, "T");
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(Reflection.getOrCreateKotlinClass(Enum.class));
        if (primaryConstructor == null || (parameters = primaryConstructor.getParameters()) == null || parameters.size() != 1) {
            Intrinsics.reifiedOperationMarker(5, "T");
            list = new ArrayList(0);
        } else {
            String name = ((KParameter) CollectionsKt.first(primaryConstructor.getParameters())).getName();
            Intrinsics.reifiedOperationMarker(4, "T");
            Iterator it = KClasses.getDeclaredMemberProperties(Reflection.getOrCreateKotlinClass(Enum.class)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((KProperty1) obj).getName(), (Object) name)) {
                    break;
                }
            }
            KProperty1 kProperty1 = (KProperty1) obj;
            if (kProperty1 == null) {
                throw new IllegalArgumentException(("Cannot find a property for " + name + " parameter").toString());
            } else if (Intrinsics.areEqual((Object) kProperty1.getReturnType().getClassifier(), (Object) Reflection.getOrCreateKotlinClass(String.class))) {
                Intrinsics.reifiedOperationMarker(5, "T");
                list = new ArrayList(0);
            } else {
                throw new IllegalArgumentException("The enum parameter has to be a string.".toString());
            }
        }
        Collection collection = list;
        Collection collection2 = collection;
        setEventsDefinition(new EventsDefinition((String[]) collection.toArray(new String[0])));
    }

    public PropertyComponentBuilder Property(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(str);
        this.properties.put(str, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final <T> PropertyComponentBuilder Property(String str, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder(str);
        propertyComponentBuilder.setGetter(new SyncFunctionComponent(b.ar, new AnyType[0], new PropertyComponentBuilder$get$1$1(function0)));
        getProperties().put(str, propertyComponentBuilder);
        return propertyComponentBuilder;
    }

    public final ObjectDefinitionData buildObject() {
        Function0<? extends Map<String, ? extends Object>> function0 = this.constantsProvider;
        Map<String, SyncFunctionComponent> map = this.syncFunctions;
        Map<String, FunctionBuilder> map2 = this.syncFunctionBuilder;
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((FunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map<String, SyncFunctionComponent> plus = MapsKt.plus(map, (Map<String, SyncFunctionComponent>) linkedHashMap);
        Map<String, AsyncFunction> map3 = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map4 = this.asyncFunctionBuilders;
        Map linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        for (Map.Entry entry2 : map4.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), ((AsyncFunctionBuilder) entry2.getValue()).build$expo_modules_core_release());
        }
        Map<String, AsyncFunction> plus2 = MapsKt.plus(map3, (Map<String, AsyncFunction>) linkedHashMap2);
        EventsDefinition eventsDefinition2 = this.eventsDefinition;
        Map<String, PropertyComponentBuilder> map5 = this.properties;
        Map linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(map5.size()));
        for (Map.Entry entry3 : map5.entrySet()) {
            linkedHashMap3.put(entry3.getKey(), ((PropertyComponentBuilder) entry3.getValue()).build());
        }
        return new ObjectDefinitionData(function0, plus, plus2, eventsDefinition2, linkedHashMap3);
    }

    public final /* synthetic */ <R> AsyncFunction AsyncFunction(String str, Function0<? extends R> function0) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$3 = new ObjectDefinitionBuilder$AsyncFunction$3(function0);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$3);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$3);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunction AsyncFunction(String str, Function2<? super P0, ? super P1, ? extends R> function2) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$8 = new ObjectDefinitionBuilder$AsyncFunction$8(function2);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls3 = Object.class;
        Class cls4 = cls3;
        if (Intrinsics.areEqual((Object) cls3, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$8);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$8);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunction AsyncFunction(String str, Function3<? super P0, ? super P1, ? super P2, ? extends R> function3) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$12 = new ObjectDefinitionBuilder$AsyncFunction$12(function3);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls4 = Object.class;
        Class cls5 = cls4;
        if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$12);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$12);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunction AsyncFunction(String str, Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> function4) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$16 = new ObjectDefinitionBuilder$AsyncFunction$16(function4);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls5 = Object.class;
        Class cls6 = cls5;
        if (Intrinsics.areEqual((Object) cls5, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$16);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$16);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunction AsyncFunction(String str, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> function5) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function5, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$20 = new ObjectDefinitionBuilder$AsyncFunction$20(function5);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls6 = Object.class;
        Class cls7 = cls6;
        if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$20);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$20);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunction AsyncFunction(String str, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> function6) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function6, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$24 = new ObjectDefinitionBuilder$AsyncFunction$24(function6);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls7 = Object.class;
        Class cls8 = cls7;
        if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$24);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, objectDefinitionBuilder$AsyncFunction$24);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunction AsyncFunction(String str, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function7) {
        AsyncFunction asyncFunction;
        String str2 = str;
        Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> function72 = function7;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function72, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$28 = new ObjectDefinitionBuilder$AsyncFunction$28(function72);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls8 = Object.class;
        Class cls9 = cls8;
        if (Intrinsics.areEqual((Object) cls8, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$28);
        } else {
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$28);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunction AsyncFunction(String str, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function8) {
        AsyncFunction asyncFunction;
        String str2 = str;
        Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> function82 = function8;
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function82, TtmlNode.TAG_BODY);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, ObjectDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 objectDefinitionBuilder$AsyncFunction$32 = new ObjectDefinitionBuilder$AsyncFunction$32(function82);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls9 = Object.class;
        Class cls10 = cls9;
        if (Intrinsics.areEqual((Object) cls9, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$32);
        } else {
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr, objectDefinitionBuilder$AsyncFunction$32);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }

    public final void OnStartObserving(Function0<Unit> function0) {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
            asyncFunction = new AsyncFunctionWithPromiseComponent("startObserving", new AnyType[0], new ObjectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$1(function0));
        } else {
            Class<String> cls = String.class;
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, ObjectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$2.INSTANCE))};
            Function1 objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3 = new ObjectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3(function0);
            Class<Unit> cls2 = Unit.class;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunctionComponent = new IntAsyncFunctionComponent("startObserving", anyTypeArr, objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunctionComponent = new BoolAsyncFunctionComponent("startObserving", anyTypeArr, objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunctionComponent = new DoubleAsyncFunctionComponent("startObserving", anyTypeArr, objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunctionComponent = new FloatAsyncFunctionComponent("startObserving", anyTypeArr, objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunctionComponent = new StringAsyncFunctionComponent("startObserving", anyTypeArr, objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3);
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("startObserving", anyTypeArr, objectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3);
            }
            asyncFunction = asyncFunctionComponent;
        }
        getAsyncFunctions().put("startObserving", asyncFunction);
    }

    public final void OnStopObserving(Function0<Unit> function0) {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
            asyncFunction = new AsyncFunctionWithPromiseComponent("stopObserving", new AnyType[0], new ObjectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$1(function0));
        } else {
            Class<String> cls = String.class;
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, ObjectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$2.INSTANCE))};
            Function1 objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3 = new ObjectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3(function0);
            Class<Unit> cls2 = Unit.class;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunctionComponent = new IntAsyncFunctionComponent("stopObserving", anyTypeArr, objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunctionComponent = new BoolAsyncFunctionComponent("stopObserving", anyTypeArr, objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunctionComponent = new DoubleAsyncFunctionComponent("stopObserving", anyTypeArr, objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunctionComponent = new FloatAsyncFunctionComponent("stopObserving", anyTypeArr, objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunctionComponent = new StringAsyncFunctionComponent("stopObserving", anyTypeArr, objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3);
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("stopObserving", anyTypeArr, objectDefinitionBuilder$OnStopObserving$$inlined$AsyncFunction$3);
            }
            asyncFunction = asyncFunctionComponent;
        }
        getAsyncFunctions().put("stopObserving", asyncFunction);
    }
}
