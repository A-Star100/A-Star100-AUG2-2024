package appinventor.ai_sonicforces207.ChatWorld;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.CloudDB;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.StopBlocksExecution;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

/* compiled from: Screen1.yail */
public class Screen1 extends Form implements Runnable {
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("Screen1").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("getMessage").readResolve());
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("ActionBar").readResolve());
    static final SimpleSymbol Lit100 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit101 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit102 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit103 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit104 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit105 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit106 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit107 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit108 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit109 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit110;
    static final SimpleSymbol Lit12 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14 = ((SimpleSymbol) new SimpleSymbol("Icon").readResolve());
    static final SimpleSymbol Lit15 = ((SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve());
    static final SimpleSymbol Lit16 = ((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve());
    static final SimpleSymbol Lit17 = ((SimpleSymbol) new SimpleSymbol("Sizing").readResolve());
    static final SimpleSymbol Lit18 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol("VersionCode").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final IntNum Lit20 = IntNum.make(11);
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("VersionName").readResolve());
    static final SimpleSymbol Lit22 = ((SimpleSymbol) new SimpleSymbol("Notifier1").readResolve());
    static final SimpleSymbol Lit23 = ((SimpleSymbol) new SimpleSymbol("ShowTextDialog").readResolve());
    static final PairWithPosition Lit24;
    static final SimpleSymbol Lit25 = ((SimpleSymbol) new SimpleSymbol("Screen1$Initialize").readResolve());
    static final SimpleSymbol Lit26 = ((SimpleSymbol) new SimpleSymbol("Initialize").readResolve());
    static final FString Lit27 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit28 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve());
    static final SimpleSymbol Lit29 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("g$username").readResolve());
    static final IntNum Lit30 = IntNum.make(3);
    static final SimpleSymbol Lit31 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit32 = IntNum.make(2);
    static final SimpleSymbol Lit33 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final IntNum Lit34 = IntNum.make(16777215);
    static final SimpleSymbol Lit35 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit36 = IntNum.make(-2);
    static final FString Lit37 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit38 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit39 = ((SimpleSymbol) new SimpleSymbol("Label1").readResolve());
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol("g$joined").readResolve());
    static final SimpleSymbol Lit40 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final DFloNum Lit41 = DFloNum.make(15.5d);
    static final SimpleSymbol Lit42 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final FString Lit43 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit44 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit45 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement2").readResolve());
    static final IntNum Lit46 = IntNum.make(16777215);
    static final FString Lit47 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit48 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol("TextBox1").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("g$chatRoom").readResolve());
    static final SimpleSymbol Lit50 = ((SimpleSymbol) new SimpleSymbol("Hint").readResolve());
    static final FString Lit51 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit52 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit53 = ((SimpleSymbol) new SimpleSymbol("SubmitButton").readResolve());
    static final FString Lit54 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit55;
    static final PairWithPosition Lit56;
    static final PairWithPosition Lit57;
    static final PairWithPosition Lit58;
    static final PairWithPosition Lit59;
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("g$chatList").readResolve());
    static final SimpleSymbol Lit60 = ((SimpleSymbol) new SimpleSymbol("CloudDB1").readResolve());
    static final SimpleSymbol Lit61 = ((SimpleSymbol) new SimpleSymbol("AppendValueToList").readResolve());
    static final PairWithPosition Lit62;
    static final PairWithPosition Lit63;
    static final SimpleSymbol Lit64 = ((SimpleSymbol) new SimpleSymbol("GetValue").readResolve());
    static final PairWithPosition Lit65;
    static final SimpleSymbol Lit66 = ((SimpleSymbol) new SimpleSymbol("SubmitButton$Click").readResolve());
    static final SimpleSymbol Lit67 = ((SimpleSymbol) new SimpleSymbol("Click").readResolve());
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit69 = ((SimpleSymbol) new SimpleSymbol("ListView1").readResolve());
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("AccentColor").readResolve());
    static final IntNum Lit70 = IntNum.make(16777215);
    static final SimpleSymbol Lit71 = ((SimpleSymbol) new SimpleSymbol("TextColor").readResolve());
    static final IntNum Lit72;
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit74 = new FString("com.google.appinventor.components.runtime.CloudDB");
    static final SimpleSymbol Lit75 = ((SimpleSymbol) new SimpleSymbol("DefaultRedisServer").readResolve());
    static final SimpleSymbol Lit76 = ((SimpleSymbol) new SimpleSymbol("ProjectID").readResolve());
    static final SimpleSymbol Lit77 = ((SimpleSymbol) new SimpleSymbol("Token").readResolve());
    static final FString Lit78 = new FString("com.google.appinventor.components.runtime.CloudDB");
    static final SimpleSymbol Lit79 = ((SimpleSymbol) new SimpleSymbol("$tag").readResolve());
    static final IntNum Lit8;
    static final PairWithPosition Lit80;
    static final SimpleSymbol Lit81 = ((SimpleSymbol) new SimpleSymbol("$value").readResolve());
    static final SimpleSymbol Lit82 = ((SimpleSymbol) new SimpleSymbol("Elements").readResolve());
    static final SimpleSymbol Lit83 = ((SimpleSymbol) new SimpleSymbol("list").readResolve());
    static final SimpleSymbol Lit84 = ((SimpleSymbol) new SimpleSymbol("CloudDB1$GotValue").readResolve());
    static final SimpleSymbol Lit85 = ((SimpleSymbol) new SimpleSymbol("GotValue").readResolve());
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit87 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit88 = ((SimpleSymbol) new SimpleSymbol("Notifier1$AfterChoosing").readResolve());
    static final SimpleSymbol Lit89 = ((SimpleSymbol) new SimpleSymbol("AfterChoosing").readResolve());
    static final SimpleSymbol Lit9 = ((SimpleSymbol) new SimpleSymbol("number").readResolve());
    static final SimpleSymbol Lit90 = ((SimpleSymbol) new SimpleSymbol("$response").readResolve());
    static final PairWithPosition Lit91;
    static final PairWithPosition Lit92;
    static final PairWithPosition Lit93;
    static final SimpleSymbol Lit94 = ((SimpleSymbol) new SimpleSymbol("Notifier1$AfterTextInput").readResolve());
    static final SimpleSymbol Lit95 = ((SimpleSymbol) new SimpleSymbol("AfterTextInput").readResolve());
    static final SimpleSymbol Lit96 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit97 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit98 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit99 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    public static Screen1 Screen1;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public CloudDB CloudDB1;
    public final ModuleMethod CloudDB1$GotValue;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public Label Label1;
    public ListView ListView1;
    public Notifier Notifier1;
    public final ModuleMethod Notifier1$AfterChoosing;
    public final ModuleMethod Notifier1$AfterTextInput;
    public final ModuleMethod Screen1$Initialize;
    public Button SubmitButton;
    public final ModuleMethod SubmitButton$Click;
    public TextBox TextBox1;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("any").readResolve();
        Lit110 = simpleSymbol;
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit13 = simpleSymbol2;
        Lit93 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 438790), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 438784);
        Lit92 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 438610), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 438604);
        Lit91 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 438374), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 438369);
        Lit80 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 401519), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 401514);
        int[] iArr = new int[2];
        iArr[0] = -16777216;
        Lit72 = IntNum.make(iArr);
        Lit65 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312794), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312788);
        Lit63 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312619), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312613);
        Lit62 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312596), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312591), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312585);
        SimpleSymbol simpleSymbol3 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit11 = simpleSymbol3;
        Lit59 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312354), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312349), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 312343);
        Lit58 = PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 311831);
        Lit57 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 311804);
        Lit56 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 311653), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 311648), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 311642);
        Lit55 = PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 311376);
        Lit24 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 110848), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 110843), "/tmp/1722486104005_5276918718652257280-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld/Screen1.yail", 110837);
        int[] iArr2 = new int[2];
        iArr2[0] = -14430977;
        Lit8 = IntNum.make(iArr2);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit96, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frame2, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit97, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit98, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit99, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit100, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit101, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit102, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit103, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit104, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit105, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 13, Lit106, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 15, Lit107, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 16, Lit108, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 17, Lit109, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 18, (Object) null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime16112522701524516325.scm:634");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 20, (Object) null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 21, (Object) null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 22, (Object) null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 23, (Object) null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 24, (Object) null, 0);
        this.Screen1$Initialize = new ModuleMethod(frame2, 25, Lit25, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 26, (Object) null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 27, (Object) null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 28, (Object) null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 29, (Object) null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 30, (Object) null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 31, (Object) null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 32, (Object) null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 33, (Object) null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 34, (Object) null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 35, (Object) null, 0);
        this.SubmitButton$Click = new ModuleMethod(frame2, 36, Lit66, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 37, (Object) null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 38, (Object) null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 39, (Object) null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 40, (Object) null, 0);
        this.CloudDB1$GotValue = new ModuleMethod(frame2, 41, Lit84, 8194);
        this.Notifier1$AfterChoosing = new ModuleMethod(frame2, 42, Lit88, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.Notifier1$AfterTextInput = new ModuleMethod(frame2, 43, Lit94, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
    }

    static Boolean lambda4() {
        return Boolean.FALSE;
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        Consumer $result = $ctx.consumer;
        Object find = require.find("com.google.youngandroid.runtime");
        try {
            ((Runnable) find).run();
            this.$Stdebug$Mnform$St = Boolean.FALSE;
            SimpleSymbol simpleSymbol = Lit0;
            this.form$Mnenvironment = Environment.make(misc.symbol$To$String(simpleSymbol));
            FString stringAppend = strings.stringAppend(misc.symbol$To$String(simpleSymbol), "-global-vars");
            this.global$Mnvar$Mnenvironment = Environment.make(stringAppend == null ? null : stringAppend.toString());
            Screen1 = null;
            this.form$Mnname$Mnsymbol = simpleSymbol;
            this.events$Mnto$Mnregister = LList.Empty;
            this.components$Mnto$Mncreate = LList.Empty;
            this.global$Mnvars$Mnto$Mncreate = LList.Empty;
            this.form$Mndo$Mnafter$Mncreation = LList.Empty;
            Object find2 = require.find("com.google.youngandroid.runtime");
            try {
                ((Runnable) find2).run();
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, ""), $result);
                } else {
                    addToGlobalVars(Lit3, lambda$Fn2);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit4, Boolean.FALSE), $result);
                } else {
                    addToGlobalVars(Lit4, lambda$Fn3);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, "chatworld123"), $result);
                } else {
                    addToGlobalVars(Lit5, lambda$Fn4);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit6, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), $result);
                } else {
                    addToGlobalVars(Lit6, lambda$Fn5);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    SimpleSymbol simpleSymbol2 = Lit7;
                    IntNum intNum = Lit8;
                    SimpleSymbol simpleSymbol3 = Lit9;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
                    SimpleSymbol simpleSymbol4 = Lit10;
                    Boolean bool = Boolean.TRUE;
                    SimpleSymbol simpleSymbol5 = Lit11;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, bool, simpleSymbol5);
                    SimpleSymbol simpleSymbol6 = Lit12;
                    SimpleSymbol simpleSymbol7 = Lit13;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, "ChatWorld", simpleSymbol7);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit14, "2665038.png", simpleSymbol7);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit15, "unspecified", simpleSymbol7);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit16, Boolean.TRUE, simpleSymbol5);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit17, "Responsive", simpleSymbol7);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit18, "Screen1", simpleSymbol7);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit19, Lit20, simpleSymbol3);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit21, "1 (final)", simpleSymbol7), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn6));
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit25, this.Screen1$Initialize);
                } else {
                    addToFormEnvironment(Lit25, this.Screen1$Initialize);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Screen1", "Initialize");
                } else {
                    addToEvents(simpleSymbol, Lit26);
                }
                this.HorizontalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit27, Lit28, lambda$Fn7), $result);
                } else {
                    addToComponents(simpleSymbol, Lit37, Lit28, lambda$Fn8);
                }
                this.Label1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit28, Lit38, Lit39, lambda$Fn9), $result);
                } else {
                    addToComponents(Lit28, Lit43, Lit39, lambda$Fn10);
                }
                this.HorizontalArrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit44, Lit45, lambda$Fn11), $result);
                } else {
                    addToComponents(simpleSymbol, Lit47, Lit45, lambda$Fn12);
                }
                this.TextBox1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit45, Lit48, Lit49, lambda$Fn13), $result);
                } else {
                    addToComponents(Lit45, Lit51, Lit49, lambda$Fn14);
                }
                this.SubmitButton = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit45, Lit52, Lit53, lambda$Fn15), $result);
                } else {
                    addToComponents(Lit45, Lit54, Lit53, lambda$Fn16);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit66, this.SubmitButton$Click);
                } else {
                    addToFormEnvironment(Lit66, this.SubmitButton$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "SubmitButton", "Click");
                } else {
                    addToEvents(Lit53, Lit67);
                }
                this.ListView1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit68, Lit69, lambda$Fn17), $result);
                } else {
                    addToComponents(simpleSymbol, Lit73, Lit69, lambda$Fn18);
                }
                this.CloudDB1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit74, Lit60, lambda$Fn19), $result);
                } else {
                    addToComponents(simpleSymbol, Lit78, Lit60, lambda$Fn20);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit84, this.CloudDB1$GotValue);
                } else {
                    addToFormEnvironment(Lit84, this.CloudDB1$GotValue);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "CloudDB1", "GotValue");
                } else {
                    addToEvents(Lit60, Lit85);
                }
                this.Notifier1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit86, Lit22, Boolean.FALSE), $result);
                } else {
                    addToComponents(simpleSymbol, Lit87, Lit22, Boolean.FALSE);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit88, this.Notifier1$AfterChoosing);
                } else {
                    addToFormEnvironment(Lit88, this.Notifier1$AfterChoosing);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Notifier1", "AfterChoosing");
                } else {
                    addToEvents(Lit22, Lit89);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit94, this.Notifier1$AfterTextInput);
                } else {
                    addToFormEnvironment(Lit94, this.Notifier1$AfterTextInput);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Notifier1", "AfterTextInput");
                } else {
                    addToEvents(Lit22, Lit95);
                }
                runtime.initRuntime();
            } catch (ClassCastException e) {
                throw new WrongType(e, "java.lang.Runnable.run()", 1, find2);
            }
        } catch (ClassCastException e2) {
            throw new WrongType(e2, "java.lang.Runnable.run()", 1, find);
        }
    }

    static String lambda3() {
        return "";
    }

    static String lambda5() {
        return "chatworld123";
    }

    static Object lambda6() {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list");
    }

    static Object lambda7() {
        SimpleSymbol simpleSymbol = Lit0;
        SimpleSymbol simpleSymbol2 = Lit7;
        IntNum intNum = Lit8;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit10;
        Boolean bool = Boolean.TRUE;
        SimpleSymbol simpleSymbol5 = Lit11;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, bool, simpleSymbol5);
        SimpleSymbol simpleSymbol6 = Lit12;
        SimpleSymbol simpleSymbol7 = Lit13;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol6, "ChatWorld", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit14, "2665038.png", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit15, "unspecified", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit16, Boolean.TRUE, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit17, "Responsive", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit18, "Screen1", simpleSymbol7);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit19, Lit20, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit21, "1 (final)", simpleSymbol7);
    }

    public Object Screen1$Initialize() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit22, Lit23, LList.list3("Enter the name of the chat room you would like to join below, no input will lead to the universal chat room being used:", "Specify the room to create/join below:", Boolean.TRUE), Lit24);
    }

    static Object lambda8() {
        SimpleSymbol simpleSymbol = Lit28;
        SimpleSymbol simpleSymbol2 = Lit29;
        IntNum intNum = Lit30;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit31, Lit32, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit33, Lit34, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit35, Lit36, simpleSymbol3);
    }

    static Object lambda9() {
        SimpleSymbol simpleSymbol = Lit28;
        SimpleSymbol simpleSymbol2 = Lit29;
        IntNum intNum = Lit30;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit31, Lit32, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit33, Lit34, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit35, Lit36, simpleSymbol3);
    }

    static Object lambda10() {
        SimpleSymbol simpleSymbol = Lit39;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit40, Lit41, Lit9);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit42, "Enter your name to join the chat", Lit13);
    }

    static Object lambda11() {
        SimpleSymbol simpleSymbol = Lit39;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit40, Lit41, Lit9);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit42, "Enter your name to join the chat", Lit13);
    }

    static Object lambda12() {
        SimpleSymbol simpleSymbol = Lit45;
        SimpleSymbol simpleSymbol2 = Lit29;
        IntNum intNum = Lit30;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit33, Lit46, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit35, Lit36, simpleSymbol3);
    }

    static Object lambda13() {
        SimpleSymbol simpleSymbol = Lit45;
        SimpleSymbol simpleSymbol2 = Lit29;
        IntNum intNum = Lit30;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit33, Lit46, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit35, Lit36, simpleSymbol3);
    }

    static Object lambda14() {
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit50, "Your Name Here", Lit13);
    }

    static Object lambda15() {
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit50, "Your Name Here", Lit13);
    }

    static Object lambda16() {
        return runtime.setAndCoerceProperty$Ex(Lit53, Lit42, "Submit", Lit13);
    }

    static Object lambda17() {
        return runtime.setAndCoerceProperty$Ex(Lit53, Lit42, "Submit", Lit13);
    }

    public Object SubmitButton$Click() {
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnnot;
        SimpleSymbol simpleSymbol = Lit4;
        if (runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit55, "not") != Boolean.FALSE) {
            SimpleSymbol simpleSymbol2 = Lit22;
            SimpleSymbol simpleSymbol3 = Lit23;
            runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list3("Enter the name of the chat room you would like to join below, no input will lead to the universal chat room being used:", "Specify the room to create/join below:", Boolean.TRUE), Lit56);
            ModuleMethod moduleMethod2 = runtime.yail$Mnnot;
            ModuleMethod moduleMethod3 = runtime.string$Mnempty$Qu;
            SimpleSymbol simpleSymbol4 = Lit49;
            SimpleSymbol simpleSymbol5 = Lit42;
            if (runtime.callYailPrimitive(moduleMethod2, LList.list1(runtime.callYailPrimitive(moduleMethod3, LList.list1(runtime.getProperty$1(simpleSymbol4, simpleSymbol5)), Lit57, "is text empty?")), Lit58, "not") != Boolean.FALSE) {
                runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.getProperty$1(simpleSymbol4, simpleSymbol5));
                runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, Boolean.TRUE);
                SimpleSymbol simpleSymbol6 = Lit39;
                SimpleSymbol simpleSymbol7 = Lit13;
                runtime.setAndCoerceProperty$Ex(simpleSymbol6, simpleSymbol5, "Type in your message below and press Submit to send it.", simpleSymbol7);
                runtime.setAndCoerceProperty$Ex(simpleSymbol4, Lit50, "Your message here", simpleSymbol7);
                runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list3("Enter the name of the chat room you would like to join below, no input will lead to the universal chat room being used:", "Specify the room to create/join below:", Boolean.TRUE), Lit59);
            }
        } else {
            SimpleSymbol simpleSymbol8 = Lit60;
            SimpleSymbol simpleSymbol9 = Lit61;
            SimpleSymbol simpleSymbol10 = Lit5;
            runtime.callComponentMethod(simpleSymbol8, simpleSymbol9, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol10, runtime.$Stthe$Mnnull$Mnvalue$St), runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), ": ", runtime.getProperty$1(Lit49, Lit42)), Lit62, "join")), Lit63);
            runtime.callComponentMethod(simpleSymbol8, Lit64, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol10, runtime.$Stthe$Mnnull$Mnvalue$St), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit65);
        }
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit42, "", Lit13);
    }

    static Object lambda18() {
        SimpleSymbol simpleSymbol = Lit69;
        SimpleSymbol simpleSymbol2 = Lit33;
        IntNum intNum = Lit70;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit71, Lit72, simpleSymbol3);
    }

    static Object lambda19() {
        SimpleSymbol simpleSymbol = Lit69;
        SimpleSymbol simpleSymbol2 = Lit33;
        IntNum intNum = Lit70;
        SimpleSymbol simpleSymbol3 = Lit9;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit71, Lit72, simpleSymbol3);
    }

    static Object lambda20() {
        SimpleSymbol simpleSymbol = Lit60;
        SimpleSymbol simpleSymbol2 = Lit75;
        SimpleSymbol simpleSymbol3 = Lit13;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "clouddb.appinventor.mit.edu", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit76, "ChatWorld", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit77, "C7uFtZt84pgYCQWvUL9Z9je7LsjqWcPV1Azb9aBAsa2W3SVssuE1rHKWiwyZzGAcXSicDuthd1R4Lyd4iUkYBw5DymoFy6j48hJX8zKDpjrRbMEBXwLQX", simpleSymbol3);
    }

    static Object lambda21() {
        SimpleSymbol simpleSymbol = Lit60;
        SimpleSymbol simpleSymbol2 = Lit75;
        SimpleSymbol simpleSymbol3 = Lit13;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "clouddb.appinventor.mit.edu", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit76, "ChatWorld", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit77, "C7uFtZt84pgYCQWvUL9Z9je7LsjqWcPV1Azb9aBAsa2W3SVssuE1rHKWiwyZzGAcXSicDuthd1R4Lyd4iUkYBw5DymoFy6j48hJX8zKDpjrRbMEBXwLQX", simpleSymbol3);
    }

    public Object CloudDB1$GotValue(Object $tag, Object $value) {
        Object obj;
        Object obj2;
        Object $tag2 = runtime.sanitizeComponentData($tag);
        Object $value2 = runtime.sanitizeComponentData($value);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        if ($tag2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit79), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $tag2;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit80, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        SimpleSymbol simpleSymbol = Lit6;
        if ($value2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit81), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $value2;
        }
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, obj2);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit82, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), Lit83);
    }

    public Object Notifier1$AfterChoosing(Object $choice) {
        runtime.sanitizeComponentData($choice);
        runtime.setThisForm();
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit2, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    public Object Notifier1$AfterTextInput(Object $response) {
        Object obj;
        Object obj2;
        Object $response2 = runtime.sanitizeComponentData($response);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnnot$Mnequal$Qu;
        if ($response2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit90), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $response2;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj, ""), Lit91, "=") == Boolean.FALSE) {
            return runtime.callComponentMethod(Lit60, Lit64, LList.list2("chatworld123", runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit93);
        }
        SimpleSymbol simpleSymbol = Lit5;
        if ($response2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit90), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $response2;
        }
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, obj2);
        return runtime.callComponentMethod(Lit60, Lit64, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit92);
    }

    /* compiled from: Screen1.yail */
    public class frame extends ModuleBody {
        Screen1 $main;

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 7:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 12:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 13:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 14:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 42:
                case 43:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 8:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 17:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 41:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 10:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 15:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    if (!(obj4 instanceof String)) {
                        return -786428;
                    }
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 16:
                    if (!(obj instanceof Screen1)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    return this.$main.getSimpleName(obj);
                case 2:
                    try {
                        this.$main.onCreate((Bundle) obj);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "onCreate", 1, obj);
                    }
                case 3:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 7:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "is-bound-in-form-environment", 1, obj);
                    }
                case 12:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 13:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 14:
                    this.$main.processException(obj);
                    return Values.empty;
                case 42:
                    return this.$main.Notifier1$AfterChoosing(obj);
                case 43:
                    return this.$main.Notifier1$AfterTextInput(obj);
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            boolean z = true;
            switch (moduleMethod.selector) {
                case 10:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                case 16:
                    Screen1 screen1 = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    screen1.dispatchGenericEvent(component, str, z, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 4:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 8:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 9:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 11:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 17:
                    return this.$main.lookupHandler(obj, obj2);
                case 41:
                    return this.$main.CloudDB1$GotValue(obj, obj2);
                default:
                    return super.apply2(moduleMethod, obj, obj2);
            }
        }

        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 18:
                    return Screen1.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Screen1.lambda3();
                case 21:
                    return Screen1.lambda4();
                case 22:
                    return Screen1.lambda5();
                case 23:
                    return Screen1.lambda6();
                case 24:
                    return Screen1.lambda7();
                case 25:
                    return this.$main.Screen1$Initialize();
                case 26:
                    return Screen1.lambda8();
                case 27:
                    return Screen1.lambda9();
                case 28:
                    return Screen1.lambda10();
                case 29:
                    return Screen1.lambda11();
                case 30:
                    return Screen1.lambda12();
                case 31:
                    return Screen1.lambda13();
                case 32:
                    return Screen1.lambda14();
                case 33:
                    return Screen1.lambda15();
                case 34:
                    return Screen1.lambda16();
                case 35:
                    return Screen1.lambda17();
                case 36:
                    return this.$main.SubmitButton$Click();
                case 37:
                    return Screen1.lambda18();
                case 38:
                    return Screen1.lambda19();
                case 39:
                    return Screen1.lambda20();
                case 40:
                    return Screen1.lambda21();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    public void onCreate(Bundle icicle) {
        AppInventorCompatActivity.setClassicModeFromYail(true);
        super.onCreate(icicle);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        Environment environment = this.form$Mnenvironment;
        boolean x = true & ((environment == null ? 1 : 0) + 1);
        if (!x ? !x : !environment.isBound(name)) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            return false;
        } else if (lookupInFormEnvironment(registeredObject) != componentObject) {
            return false;
        } else {
            boolean x = true;
            try {
                Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                return true;
            } catch (StopBlocksExecution e) {
                StopBlocksExecution exception = e;
                return false;
            } catch (PermissionException e2) {
                PermissionException exception2 = e2;
                exception2.printStackTrace();
                if (this != componentObject) {
                    x = false;
                }
                if (!x ? !x : !IsEqual.apply(eventName, "PermissionNeeded")) {
                    PermissionDenied(componentObject, eventName, exception2.getPermissionNeeded());
                    return false;
                }
                processException(exception2);
                return false;
            } catch (Throwable th) {
                Throwable exception3 = th;
                androidLogForm(exception3.getMessage());
                exception3.printStackTrace();
                processException(exception3);
                return false;
            }
        }
    }

    public void dispatchGenericEvent(Component componentObject, String eventName, boolean notAlreadyHandled, Object[] args) {
        boolean x = false;
        Object handler = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(componentObject), "$", eventName)));
        if (handler != Boolean.FALSE) {
            try {
                Scheme.apply.apply2(handler, lists.cons(componentObject, lists.cons(notAlreadyHandled ? Boolean.TRUE : Boolean.FALSE, LList.makeList(args, 0))));
            } catch (StopBlocksExecution e) {
                StopBlocksExecution exception = e;
            } catch (PermissionException e2) {
                PermissionException exception2 = e2;
                exception2.printStackTrace();
                if (this == componentObject) {
                    x = true;
                }
                if (!x ? !x : !IsEqual.apply(eventName, "PermissionNeeded")) {
                    PermissionDenied(componentObject, eventName, exception2.getPermissionNeeded());
                } else {
                    processException(exception2);
                }
            } catch (Throwable th) {
                Throwable exception3 = th;
                androidLogForm(exception3.getMessage());
                exception3.printStackTrace();
                processException(exception3);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        String str = null;
        String obj = componentName == null ? null : componentName.toString();
        if (eventName != null) {
            str = eventName.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj, str)));
    }

    public void $define() {
        int i;
        Object arg0;
        Object arg02;
        Object arg03;
        WrongType wrongType;
        Object var;
        Object apply1;
        Object component$Mnname;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            Exception exception2 = exception;
            androidLogForm(exception2.getMessage());
            processException(exception2);
        }
        Screen1 = this;
        addToFormEnvironment(Lit0, this);
        Object obj = this.events$Mnto$Mnregister;
        Object components = obj;
        Object arg04 = obj;
        while (true) {
            i = -2;
            if (arg04 == LList.Empty) {
                try {
                    break;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "arg0", -2, arg0);
                } catch (ClassCastException e2) {
                    throw new WrongType(e2, "arg0", -2, arg02);
                } catch (ClassCastException e3) {
                    throw new WrongType(e3, "lookup-in-form-environment", 0, apply1);
                } catch (ClassCastException e4) {
                    throw new WrongType(e4, "add-to-form-environment", 0, component$Mnname);
                } catch (ClassCastException e5) {
                    throw new WrongType(e5, "arg0", i, arg03);
                } catch (ClassCastException e6) {
                    throw new WrongType(e6, "add-to-global-var-environment", 0, var);
                } catch (YailRuntimeError exception3) {
                    Object obj2 = components;
                    processException(exception3);
                    return;
                }
            } else {
                try {
                    Pair arg05 = (Pair) arg04;
                    Object event$Mninfo = arg05.getCar();
                    Object apply12 = lists.car.apply1(event$Mninfo);
                    String obj3 = apply12 == null ? null : apply12.toString();
                    Object apply13 = lists.cdr.apply1(event$Mninfo);
                    EventDispatcher.registerEventForDelegation(this, obj3, apply13 == null ? null : apply13.toString());
                    arg04 = arg05.getCdr();
                } catch (ClassCastException e7) {
                    throw new WrongType(e7, "arg0", -2, arg04);
                }
            }
        }
        components = lists.reverse(this.components$Mnto$Mncreate);
        addToGlobalVars(Lit2, lambda$Fn1);
        arg0 = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
        while (arg0 != LList.Empty) {
            Pair arg06 = (Pair) arg0;
            misc.force(arg06.getCar());
            arg0 = arg06.getCdr();
            i = -2;
        }
        Object var$Mnval = null;
        arg02 = components;
        while (arg02 != LList.Empty) {
            Pair arg07 = (Pair) arg02;
            Object component$Mninfo = arg07.getCar();
            Object apply14 = lists.caddr.apply1(component$Mninfo);
            lists.cadddr.apply1(component$Mninfo);
            Object component$Mntype = lists.cadr.apply1(component$Mninfo);
            apply1 = lists.car.apply1(component$Mninfo);
            component$Mnname = apply14;
            Object obj4 = apply1;
            Object component$Mnobject = Invoke.make.apply2(component$Mntype, lookupInFormEnvironment((Symbol) apply1));
            SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
            addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
            arg02 = arg07.getCdr();
            Pair pair = arg07;
            var$Mnval = component$Mninfo;
            i = -2;
        }
        arg03 = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
        while (arg03 != LList.Empty) {
            Pair arg08 = (Pair) arg03;
            var$Mnval = arg08.getCar();
            var = lists.car.apply1(var$Mnval);
            addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
            arg03 = arg08.getCdr();
            Pair pair2 = arg08;
        }
        Object component$Mndescriptors = components;
        Object arg09 = component$Mndescriptors;
        while (arg09 != LList.Empty) {
            try {
                Pair arg010 = (Pair) arg09;
                Object component$Mninfo2 = arg010.getCar();
                lists.caddr.apply1(component$Mninfo2);
                Object obj5 = var$Mnval;
                var$Mnval = lists.cadddr.apply1(component$Mninfo2);
                if (var$Mnval != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(var$Mnval);
                }
                arg09 = arg010.getCdr();
            } catch (ClassCastException e8) {
                wrongType = new WrongType(e8, "arg0", i, arg09);
                throw wrongType;
            }
        }
        Object arg011 = component$Mndescriptors;
        while (arg011 != LList.Empty) {
            try {
                Pair arg012 = (Pair) arg011;
                Object component$Mninfo3 = arg012.getCar();
                Object apply15 = lists.caddr.apply1(component$Mninfo3);
                lists.cadddr.apply1(component$Mninfo3);
                Object obj6 = var$Mnval;
                var$Mnval = apply15;
                callInitialize(SlotGet.field.apply2(this, var$Mnval));
                arg011 = arg012.getCdr();
            } catch (ClassCastException e9) {
                wrongType = new WrongType(e9, "arg0", i, arg011);
                throw wrongType;
            }
        }
        Object obj7 = components;
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        Object symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object result = LList.Empty;
        Object arg0 = symbols;
        while (arg0 != LList.Empty) {
            try {
                Pair arg02 = (Pair) arg0;
                Object cdr = arg02.getCdr();
                Object car = arg02.getCar();
                try {
                    result = Pair.make(misc.symbol$To$String((Symbol) car), result);
                    arg0 = cdr;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, arg0);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(result));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
