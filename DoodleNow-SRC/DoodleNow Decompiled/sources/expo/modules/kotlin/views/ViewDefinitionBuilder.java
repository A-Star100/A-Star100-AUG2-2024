package expo.modules.kotlin.views;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.defaultmodules.ErrorManagerModule;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
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
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u000bJ,\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u00012\u0006\u00106\u001a\u00020\u000b2\u000e\b\u0004\u00108\u001a\b\u0012\u0004\u0012\u0002H709H\bø\u0001\u0000J+\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u000b2\u0010\b\u0004\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000309H\bø\u0001\u0000¢\u0006\u0002\b:JI\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u00012\u0006\u00106\u001a\u00020\u000b2#\b\u0004\u00108\u001a\u001d\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70\u0018H\bø\u0001\u0000Jf\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\u0004\u00108\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002H70?H\bø\u0001\u0000J\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u00012\u0006\u00106\u001a\u00020\u000b2M\b\u0004\u00108\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H70BH\bø\u0001\u0000J \u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u00012\u0006\u00106\u001a\u00020\u000b2b\b\u0004\u00108\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0004\u0012\u0002H70EH\bø\u0001\u0000J½\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u00012\u0006\u00106\u001a\u00020\u000b2w\b\u0004\u00108\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0004\u0012\u0002H70HH\bø\u0001\u0000JÜ\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u00012\u0006\u00106\u001a\u00020\u000b2\u0001\b\u0004\u00108\u001a\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0004\u0012\u0002H70KH\bø\u0001\u0000Jù\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u0001\"\u0006\b\b\u0010M\u0018\u00012\u0006\u00106\u001a\u00020\u000b2¢\u0001\b\u0004\u00108\u001a\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0013\u0012\u0011HM¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002H70NH\bø\u0001\u0000J\u0002\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u0001\"\u0006\b\b\u0010M\u0018\u0001\"\u0006\b\t\u0010P\u0018\u00012\u0006\u00106\u001a\u00020\u000b2·\u0001\b\u0004\u00108\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0013\u0012\u0011HM¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(O\u0012\u0013\u0012\u0011HP¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(R\u0012\u0004\u0012\u0002H70QH\bø\u0001\u0000J\u0002\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u0001\"\u0006\b\b\u0010M\u0018\u00012\u0006\u00106\u001a\u00020\u000b2·\u0001\b\u0004\u00108\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0013\u0012\u0011HM¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(R\u0012\u0004\u0012\u0002H70QH\bø\u0001\u0000¢\u0006\u0002\bTJö\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u0001\"\u0006\b\u0007\u0010J\u0018\u00012\u0006\u00106\u001a\u00020\u000b2¢\u0001\b\u0004\u00108\u001a\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u0011HJ¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002H70NH\bø\u0001\u0000¢\u0006\u0002\bTJÙ\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u0001\"\u0006\b\u0006\u0010G\u0018\u00012\u0006\u00106\u001a\u00020\u000b2\u0001\b\u0004\u00108\u001a\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u0011HG¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(L\u0012\u0004\u0012\u0002H70KH\bø\u0001\u0000¢\u0006\u0002\bTJº\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u0001\"\u0006\b\u0005\u0010D\u0018\u00012\u0006\u00106\u001a\u00020\u000b2w\b\u0004\u00108\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011HD¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(I\u0012\u0004\u0012\u0002H70HH\bø\u0001\u0000¢\u0006\u0002\bTJ\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u0001\"\u0006\b\u0004\u0010A\u0018\u00012\u0006\u00106\u001a\u00020\u000b2b\b\u0004\u00108\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u0011HA¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(F\u0012\u0004\u0012\u0002H70EH\bø\u0001\u0000¢\u0006\u0002\bTJ\u0001\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010>\u0018\u00012\u0006\u00106\u001a\u00020\u000b2M\b\u0004\u00108\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H>¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H70BH\bø\u0001\u0000¢\u0006\u0002\bTJc\u00105\u001a\u00020\f\"\u0006\b\u0001\u00107\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\u0004\u00108\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110S¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002H70?H\bø\u0001\u0000¢\u0006\u0002\bTJ\u001d\u0010U\u001a\u00020\u00192\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000b0WH\u0007¢\u0006\u0004\bX\u0010YJ\u001f\u0010U\u001a\u00020\u00192\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0W\"\u00020\u000b¢\u0006\u0002\u0010YJ7\u0010Z\u001a\u00020\u0019\"\n\b\u0001\u0010[\u0018\u0001*\u00020\\2\u001d\u00108\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H[0]\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b^H\bø\u0001\u0000J1\u0010_\u001a\u00020\u00192#\b\u0004\u00108\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u00190\u0018H\bø\u0001\u0000JB\u0010_\u001a\u00020\u0019\"\n\b\u0001\u0010a\u0018\u0001*\u00028\u00002#\b\b\u00108\u001a\u001d\u0012\u0013\u0012\u0011Ha¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u00190\u0018H\bø\u0001\u0000¢\u0006\u0002\bbJ1\u0010c\u001a\u00020\u00192#\b\u0004\u00108\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u00190\u0018H\bø\u0001\u0000JB\u0010c\u001a\u00020\u0019\"\n\b\u0001\u0010a\u0018\u0001*\u00028\u00002#\b\b\u00108\u001a\u001d\u0012\u0013\u0012\u0011Ha¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020\u00190\u0018H\bø\u0001\u0000¢\u0006\u0002\bdJV\u0010e\u001a\u00020\u0019\"\u0006\b\u0001\u0010f\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\b\u00108\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011Hf¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00190?H\bø\u0001\u0000Jg\u0010e\u001a\u00020\u0019\"\n\b\u0001\u0010a\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010f\u0018\u00012\u0006\u00106\u001a\u00020\u000b28\b\b\u00108\u001a2\u0012\u0013\u0012\u0011Ha¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011Hf¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00190?H\bø\u0001\u0000¢\u0006\u0002\bhJ¨\u0001\u0010i\u001a\u00020\u0019\"\n\b\u0001\u0010a\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010f\u0018\u0001\"\u0006\b\u0003\u0010j\u0018\u00012*\u0010#\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002Hj0k0W\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002Hj0k2M\b\b\u00108\u001aG\u0012\u0013\u0012\u0011Ha¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011Hj¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(l\u0012\u0013\u0012\u0011Hf¢\u0006\f\b<\u0012\b\b6\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00190BH\bø\u0001\u0000¢\u0006\u0002\u0010mJ\u0006\u0010n\u001a\u00020oJ\u001a\u0010p\u001a\u0014\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u00020?H\u0002J \u0010s\u001a\u00020\u00022\u0006\u0010t\u001a\u00020q2\u0006\u0010u\u001a\u00020r2\u0006\u0010v\u001a\u00020wH\u0002R0\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00160\nX\u000e¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR2\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR0\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020$0\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010*R&\u0010+\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u000e\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u0006\u001a\u00020\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u000e\u001a\u0004\b3\u00104\u0002\u0007\n\u0005\b20\u0001¨\u0006x"}, d2 = {"Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "T", "Landroid/view/View;", "", "viewClass", "Lkotlin/reflect/KClass;", "viewType", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KType;)V", "asyncFunctions", "", "", "Lexpo/modules/kotlin/functions/AsyncFunction;", "getAsyncFunctions$annotations", "()V", "getAsyncFunctions", "()Ljava/util/Map;", "setAsyncFunctions", "(Ljava/util/Map;)V", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "functionBuilders", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "onViewDestroys", "Lkotlin/Function1;", "", "getOnViewDestroys$annotations", "getOnViewDestroys", "()Lkotlin/jvm/functions/Function1;", "setOnViewDestroys", "(Lkotlin/jvm/functions/Function1;)V", "onViewDidUpdateProps", "getOnViewDidUpdateProps$annotations", "getOnViewDidUpdateProps", "setOnViewDidUpdateProps", "props", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps$annotations", "getProps", "setProps", "getViewClass$annotations", "getViewClass", "()Lkotlin/reflect/KClass;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$annotations", "getViewGroupDefinition", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "setViewGroupDefinition", "(Lexpo/modules/kotlin/views/ViewGroupDefinition;)V", "getViewType$annotations", "getViewType", "()Lkotlin/reflect/KType;", "AsyncFunction", "name", "R", "body", "Lkotlin/Function0;", "AsyncFunctionWithoutArgs", "P0", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Lexpo/modules/kotlin/Promise;", "AsyncFunctionWithPromise", "Events", "callbacks", "", "EventsWithArray", "([Ljava/lang/String;)V", "GroupView", "ParentType", "Landroid/view/ViewGroup;", "Lexpo/modules/kotlin/views/ViewGroupDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "OnViewDestroys", "view", "ViewType", "OnViewDestroysGeneric", "OnViewDidUpdateProps", "OnViewDidUpdatePropsGeneric", "Prop", "PropType", "prop", "PropGeneric", "PropGroup", "CustomValueType", "Lkotlin/Pair;", "value", "([Lkotlin/Pair;Lkotlin/jvm/functions/Function3;)V", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "createViewFactory", "Landroid/content/Context;", "Lexpo/modules/kotlin/AppContext;", "handleFailureDuringViewCreation", "context", "appContext", "e", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@DefinitionMarker
/* compiled from: ViewDefinitionBuilder.kt */
public final class ViewDefinitionBuilder<T extends View> {
    private Map<String, AsyncFunction> asyncFunctions = new LinkedHashMap();
    private CallbacksDefinition callbacksDefinition;
    private Map<String, AsyncFunctionBuilder> functionBuilders = new LinkedHashMap();
    private Function1<? super View, Unit> onViewDestroys;
    private Function1<? super View, Unit> onViewDidUpdateProps;
    private Map<String, AnyViewProp> props = new LinkedHashMap();
    private final KClass<T> viewClass;
    private ViewGroupDefinition viewGroupDefinition;
    private final KType viewType;

    public static /* synthetic */ void getAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getOnViewDestroys$annotations() {
    }

    public static /* synthetic */ void getOnViewDidUpdateProps$annotations() {
    }

    public static /* synthetic */ void getProps$annotations() {
    }

    public static /* synthetic */ void getViewClass$annotations() {
    }

    public static /* synthetic */ void getViewGroupDefinition$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public final Map<String, AsyncFunction> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final Function1<View, Unit> getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final Function1<View, Unit> getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final Map<String, AnyViewProp> getProps() {
        return this.props;
    }

    public final KClass<T> getViewClass() {
        return this.viewClass;
    }

    public final ViewGroupDefinition getViewGroupDefinition() {
        return this.viewGroupDefinition;
    }

    public final KType getViewType() {
        return this.viewType;
    }

    public final void setAsyncFunctions(Map<String, AsyncFunction> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.asyncFunctions = map;
    }

    public final void setOnViewDestroys(Function1<? super View, Unit> function1) {
        this.onViewDestroys = function1;
    }

    public final void setOnViewDidUpdateProps(Function1<? super View, Unit> function1) {
        this.onViewDidUpdateProps = function1;
    }

    public final void setProps(Map<String, AnyViewProp> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.props = map;
    }

    public final void setViewGroupDefinition(ViewGroupDefinition viewGroupDefinition2) {
        this.viewGroupDefinition = viewGroupDefinition2;
    }

    public ViewDefinitionBuilder(KClass<T> kClass, KType kType) {
        Intrinsics.checkNotNullParameter(kClass, "viewClass");
        Intrinsics.checkNotNullParameter(kType, "viewType");
        this.viewClass = kClass;
        this.viewType = kType;
    }

    public final void OnViewDestroys(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        setOnViewDestroys(new ViewDefinitionBuilder$OnViewDestroys$1(function1));
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDestroysGeneric(Function1<? super ViewType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.needClassReification();
        setOnViewDestroys(new ViewDefinitionBuilder$OnViewDestroys$2(function1));
    }

    public final void OnViewDidUpdateProps(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        setOnViewDidUpdateProps(new ViewDefinitionBuilder$OnViewDidUpdateProps$1(function1));
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDidUpdatePropsGeneric(Function1<? super ViewType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.needClassReification();
        setOnViewDidUpdateProps(new ViewDefinitionBuilder$OnViewDidUpdateProps$2(function1));
    }

    public final /* synthetic */ <PropType> void Prop(String str, Function2<? super T, ? super PropType, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
        Map<String, AnyViewProp> props2 = getProps();
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        props2.put(str, new ConcreteViewProp(str, new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$Prop$$inlined$toAnyType$1.INSTANCE)), function2));
    }

    public final /* synthetic */ <ViewType extends View, PropType> void PropGeneric(String str, Function2<? super ViewType, ? super PropType, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, TtmlNode.TAG_BODY);
        Map<String, AnyViewProp> props2 = getProps();
        Intrinsics.needClassReification();
        Intrinsics.reifiedOperationMarker(4, "PropType");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "PropType");
        props2.put(str, new ConcreteViewProp(str, new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$Prop$$inlined$toAnyType$2.INSTANCE)), function2));
    }

    public final /* synthetic */ <ViewType extends View, PropType, CustomValueType> void PropGroup(Pair<String, ? extends CustomValueType>[] pairArr, Function3<? super ViewType, ? super CustomValueType, ? super PropType, Unit> function3) {
        Intrinsics.checkNotNullParameter(pairArr, "props");
        Intrinsics.checkNotNullParameter(function3, TtmlNode.TAG_BODY);
        for (Pair<String, ? extends CustomValueType> pair : pairArr) {
            String component1 = pair.component1();
            Object component2 = pair.component2();
            Intrinsics.needClassReification();
            Map<String, AnyViewProp> props2 = getProps();
            Intrinsics.needClassReification();
            Intrinsics.reifiedOperationMarker(4, "PropType");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "PropType");
            props2.put(component1, new ConcreteViewProp(component1, new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$PropGroup$$inlined$PropGeneric$1.INSTANCE)), new ViewDefinitionBuilder$PropGroup$1(function3, component2)));
        }
    }

    public final void Events(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(strArr);
    }

    public final void EventsWithArray(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(strArr);
    }

    public final /* synthetic */ <ParentType extends ViewGroup> void GroupView(Function1<? super ViewGroupDefinitionBuilder<ParentType>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        KClass viewClass2 = getViewClass();
        Intrinsics.reifiedOperationMarker(4, "ParentType");
        Intrinsics.areEqual((Object) viewClass2, (Object) Reflection.getOrCreateKotlinClass(ViewGroup.class));
        if (getViewGroupDefinition() == null) {
            ViewGroupDefinitionBuilder viewGroupDefinitionBuilder = new ViewGroupDefinitionBuilder();
            function1.invoke(viewGroupDefinitionBuilder);
            setViewGroupDefinition(viewGroupDefinitionBuilder.build());
            return;
        }
        throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
    }

    public final AsyncFunction AsyncFunctionWithoutArgs(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        AsyncFunction asyncFunctionComponent = new AsyncFunctionComponent(str, new AnyType[0], new ViewDefinitionBuilder$AsyncFunction$1(function0));
        getAsyncFunctions().put(str, asyncFunctionComponent);
        return asyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunction AsyncFunction(String str, Function1<? super P0, ? extends R> function1) {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunctionComponent;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (Object.class == Promise.class) {
            Intrinsics.needClassReification();
            asyncFunction = new AsyncFunctionWithPromiseComponent(str, new AnyType[0], new ViewDefinitionBuilder$AsyncFunction$5(function1));
        } else {
            Intrinsics.reifiedOperationMarker(4, "P0");
            Class cls = Object.class;
            Intrinsics.needClassReification();
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$1.INSTANCE))};
            Intrinsics.needClassReification();
            Function1 viewDefinitionBuilder$AsyncFunction$6 = new ViewDefinitionBuilder$AsyncFunction$6(function1);
            Intrinsics.reifiedOperationMarker(3, "R");
            Intrinsics.reifiedOperationMarker(4, "R");
            Class<Object> cls2 = Object.class;
            Class cls3 = cls2;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunctionComponent = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunctionComponent = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunctionComponent = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunctionComponent = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$6);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunctionComponent = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$6);
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$6);
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$4.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$10(function2));
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$8.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$9.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$14(function3));
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$14.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$15.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$16.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$18(function4));
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$22.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$23.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$24.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$25.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$22(function5));
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$32.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$33.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$34.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$35.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$36.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$26(function6));
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$44.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$45.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$46.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$47.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$48.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$49.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$30(function72));
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
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(str2, new AnyType[]{new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$58.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$59.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$60.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$61.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$62.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$63.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$64.INSTANCE))}, new ViewDefinitionBuilder$AsyncFunction$34(function82));
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = asyncFunctionWithPromiseComponent;
        getAsyncFunctions().put(str2, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final AsyncFunctionBuilder AsyncFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(str);
        this.functionBuilders.put(str, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    private final Function2<Context, AppContext, View> createViewFactory() {
        return new ViewDefinitionBuilder$createViewFactory$1(this);
    }

    /* access modifiers changed from: private */
    public final View handleFailureDuringViewCreation(Context context, AppContext appContext, Throwable th) {
        CodedException codedException;
        KClass<T> kClass = this.viewClass;
        Log.e("ExpoModulesCore", "Couldn't create view of type " + kClass, th);
        ErrorManagerModule errorManager = appContext.getErrorManager();
        if (errorManager != null) {
            if (th instanceof CodedException) {
                codedException = (CodedException) th;
            } else {
                codedException = new UnexpectedException(th);
            }
            errorManager.reportExceptionToLogBox(codedException);
        }
        if (ViewGroup.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(this.viewClass))) {
            return new ErrorGroupView(context);
        }
        return new ErrorView(context);
    }

    public final ViewManagerDefinition build() {
        Map<String, AsyncFunction> map = this.asyncFunctions;
        Map<String, AsyncFunctionBuilder> map2 = this.functionBuilders;
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        for (Map.Entry entry : map2.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((AsyncFunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map<String, AsyncFunction> plus = MapsKt.plus(map, (Map<String, AsyncFunction>) linkedHashMap);
        for (Map.Entry<String, AsyncFunction> value : plus.entrySet()) {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = (BaseAsyncFunctionComponent) value.getValue();
            baseAsyncFunctionComponent.runOnQueue(Queues.MAIN);
            baseAsyncFunctionComponent.setOwnerType(this.viewType);
            baseAsyncFunctionComponent.setCanTakeOwner(true);
        }
        return new ViewManagerDefinition(createViewFactory(), JvmClassMappingKt.getJavaClass(this.viewClass), this.props, this.onViewDestroys, this.callbacksDefinition, this.viewGroupDefinition, this.onViewDidUpdateProps, CollectionsKt.toList(plus.values()));
    }

    public final /* synthetic */ <R> AsyncFunction AsyncFunction(String str, Function0<? extends R> function0) {
        AsyncFunction asyncFunction;
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function0, TtmlNode.TAG_BODY);
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$3 = new ViewDefinitionBuilder$AsyncFunction$3(function0);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$3);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$3);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$2.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$3.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$8 = new ViewDefinitionBuilder$AsyncFunction$8(function2);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls3 = Object.class;
        Class cls4 = cls3;
        if (Intrinsics.areEqual((Object) cls3, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$8);
        } else if (Intrinsics.areEqual((Object) cls3, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$8);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$8);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$5.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$6.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$7.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$12 = new ViewDefinitionBuilder$AsyncFunction$12(function3);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls4 = Object.class;
        Class cls5 = cls4;
        if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$12);
        } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$12);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$12);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$10.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$11.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$12.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$13.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$16 = new ViewDefinitionBuilder$AsyncFunction$16(function4);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls5 = Object.class;
        Class cls6 = cls5;
        if (Intrinsics.areEqual((Object) cls5, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$16);
        } else if (Intrinsics.areEqual((Object) cls5, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$16);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$16);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$17.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$18.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$19.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$20.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$21.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$20 = new ViewDefinitionBuilder$AsyncFunction$20(function5);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls6 = Object.class;
        Class cls7 = cls6;
        if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$20);
        } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$20);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$20);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$26.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$27.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$28.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$29.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$30.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$31.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$24 = new ViewDefinitionBuilder$AsyncFunction$24(function6);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls7 = Object.class;
        Class cls8 = cls7;
        if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$24);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$24);
        } else {
            asyncFunction = new AsyncFunctionComponent(str, anyTypeArr, viewDefinitionBuilder$AsyncFunction$24);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$37.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$38.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$39.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$40.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$41.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$42.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$43.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$28 = new ViewDefinitionBuilder$AsyncFunction$28(function72);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls8 = Object.class;
        Class cls9 = cls8;
        if (Intrinsics.areEqual((Object) cls8, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$28);
        } else if (Intrinsics.areEqual((Object) cls8, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$28);
        } else {
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$28);
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
        AnyType[] anyTypeArr = {new AnyType(new LazyKType(orCreateKotlinClass, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$50.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass2, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$51.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass3, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$52.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass4, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$53.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass5, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$54.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass6, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$55.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass7, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$56.INSTANCE)), new AnyType(new LazyKType(orCreateKotlinClass8, false, ViewDefinitionBuilder$AsyncFunction$$inlined$toArgsArray$default$57.INSTANCE))};
        Intrinsics.needClassReification();
        Function1 viewDefinitionBuilder$AsyncFunction$32 = new ViewDefinitionBuilder$AsyncFunction$32(function82);
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        Class<Object> cls9 = Object.class;
        Class cls10 = cls9;
        if (Intrinsics.areEqual((Object) cls9, (Object) Integer.TYPE)) {
            asyncFunction = new IntAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Boolean.TYPE)) {
            asyncFunction = new BoolAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Double.TYPE)) {
            asyncFunction = new DoubleAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) Float.TYPE)) {
            asyncFunction = new FloatAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$32);
        } else if (Intrinsics.areEqual((Object) cls9, (Object) String.class)) {
            asyncFunction = new StringAsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$32);
        } else {
            asyncFunction = new AsyncFunctionComponent(str2, anyTypeArr, viewDefinitionBuilder$AsyncFunction$32);
        }
        AsyncFunction asyncFunction2 = asyncFunction;
        getAsyncFunctions().put(str2, asyncFunction);
        return asyncFunction;
    }
}
