package appinventor.ai_sonicforces207.ChatWorld_Neo;

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
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.TextBox;
import com.google.appinventor.components.runtime.TinyDB;
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
    static final SimpleSymbol Lit10 = ((SimpleSymbol) new SimpleSymbol("number").readResolve());
    static final IntNum Lit100;
    static final FString Lit101 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit102 = new FString("com.google.appinventor.components.runtime.CloudDB");
    static final SimpleSymbol Lit103 = ((SimpleSymbol) new SimpleSymbol("DefaultRedisServer").readResolve());
    static final SimpleSymbol Lit104 = ((SimpleSymbol) new SimpleSymbol("ProjectID").readResolve());
    static final SimpleSymbol Lit105 = ((SimpleSymbol) new SimpleSymbol("Token").readResolve());
    static final FString Lit106 = new FString("com.google.appinventor.components.runtime.CloudDB");
    static final SimpleSymbol Lit107 = ((SimpleSymbol) new SimpleSymbol("$tag").readResolve());
    static final PairWithPosition Lit108;
    static final PairWithPosition Lit109;
    static final SimpleSymbol Lit11 = ((SimpleSymbol) new SimpleSymbol("ActionBar").readResolve());
    static final SimpleSymbol Lit110 = ((SimpleSymbol) new SimpleSymbol("$value").readResolve());
    static final SimpleSymbol Lit111 = ((SimpleSymbol) new SimpleSymbol("MsgServer$GotValue").readResolve());
    static final SimpleSymbol Lit112 = ((SimpleSymbol) new SimpleSymbol("GotValue").readResolve());
    static final PairWithPosition Lit113;
    static final PairWithPosition Lit114;
    static final SimpleSymbol Lit115 = ((SimpleSymbol) new SimpleSymbol("MsgServer$DataChanged").readResolve());
    static final SimpleSymbol Lit116 = ((SimpleSymbol) new SimpleSymbol("DataChanged").readResolve());
    static final FString Lit117 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit118 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit119 = new FString("com.google.appinventor.components.runtime.TinyDB");
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit120 = ((SimpleSymbol) new SimpleSymbol("Namespace").readResolve());
    static final FString Lit121 = new FString("com.google.appinventor.components.runtime.TinyDB");
    static final SimpleSymbol Lit122 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit123 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit124 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit125 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final SimpleSymbol Lit126 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit127 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit128 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit129 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final SimpleSymbol Lit130 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit131 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit132 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit133 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit134 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit135 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit136;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15 = ((SimpleSymbol) new SimpleSymbol("BackgroundImage").readResolve());
    static final SimpleSymbol Lit16 = ((SimpleSymbol) new SimpleSymbol("Icon").readResolve());
    static final SimpleSymbol Lit17 = ((SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve());
    static final SimpleSymbol Lit18 = ((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve());
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol("Sizing").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final SimpleSymbol Lit20 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("VersionName").readResolve());
    static final SimpleSymbol Lit22 = ((SimpleSymbol) new SimpleSymbol(TinyDB.DEFAULT_NAMESPACE).readResolve());
    static final SimpleSymbol Lit23 = ((SimpleSymbol) new SimpleSymbol("GetValue").readResolve());
    static final PairWithPosition Lit24;
    static final PairWithPosition Lit25;
    static final SimpleSymbol Lit26 = ((SimpleSymbol) new SimpleSymbol("StoreValue").readResolve());
    static final IntNum Lit27 = IntNum.make(0);
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("g$roomname").readResolve());
    static final PairWithPosition Lit30;
    static final SimpleSymbol Lit31 = ((SimpleSymbol) new SimpleSymbol("Notifier1").readResolve());
    static final SimpleSymbol Lit32 = ((SimpleSymbol) new SimpleSymbol("ShowMessageDialog").readResolve());
    static final PairWithPosition Lit33;
    static final SimpleSymbol Lit34 = ((SimpleSymbol) new SimpleSymbol("ClearAll").readResolve());
    static final IntNum Lit35 = IntNum.make(1);
    static final PairWithPosition Lit36;
    static final PairWithPosition Lit37;
    static final PairWithPosition Lit38;
    static final PairWithPosition Lit39;
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol("g$username").readResolve());
    static final SimpleSymbol Lit40 = ((SimpleSymbol) new SimpleSymbol("roomPicker").readResolve());
    static final SimpleSymbol Lit41 = ((SimpleSymbol) new SimpleSymbol("Elements").readResolve());
    static final SimpleSymbol Lit42 = ((SimpleSymbol) new SimpleSymbol("list").readResolve());
    static final SimpleSymbol Lit43 = ((SimpleSymbol) new SimpleSymbol("MsgServer").readResolve());
    static final PairWithPosition Lit44;
    static final PairWithPosition Lit45;
    static final SimpleSymbol Lit46 = ((SimpleSymbol) new SimpleSymbol("Screen1$Initialize").readResolve());
    static final SimpleSymbol Lit47 = ((SimpleSymbol) new SimpleSymbol("Initialize").readResolve());
    static final FString Lit48 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("g$joinedStatus").readResolve());
    static final SimpleSymbol Lit50 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit51 = IntNum.make(3);
    static final SimpleSymbol Lit52 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit53 = IntNum.make(2);
    static final SimpleSymbol Lit54 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit55 = IntNum.make(-2);
    static final FString Lit56 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit57 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit58 = ((SimpleSymbol) new SimpleSymbol("FontBold").readResolve());
    static final SimpleSymbol Lit59 = ((SimpleSymbol) new SimpleSymbol(Component.LISTVIEW_KEY_IMAGE).readResolve());
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("g$roomList").readResolve());
    static final SimpleSymbol Lit60 = ((SimpleSymbol) new SimpleSymbol("Shape").readResolve());
    static final SimpleSymbol Lit61 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final SimpleSymbol Lit62 = ((SimpleSymbol) new SimpleSymbol("TextColor").readResolve());
    static final IntNum Lit63;
    static final FString Lit64 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit65 = ((SimpleSymbol) new SimpleSymbol("Selection").readResolve());
    static final PairWithPosition Lit66;
    static final PairWithPosition Lit67;
    static final PairWithPosition Lit68;
    static final PairWithPosition Lit69;
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("g$chatMsg").readResolve());
    static final SimpleSymbol Lit70 = ((SimpleSymbol) new SimpleSymbol("roomPicker$AfterPicking").readResolve());
    static final SimpleSymbol Lit71 = ((SimpleSymbol) new SimpleSymbol("AfterPicking").readResolve());
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit73 = ((SimpleSymbol) new SimpleSymbol("instruction").readResolve());
    static final IntNum Lit74;
    static final FString Lit75 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit77 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement2").readResolve());
    static final FString Lit78 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit79 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("AccentColor").readResolve());
    static final SimpleSymbol Lit80 = ((SimpleSymbol) new SimpleSymbol("msgtxt").readResolve());
    static final SimpleSymbol Lit81 = ((SimpleSymbol) new SimpleSymbol("Hint").readResolve());
    static final FString Lit82 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit83 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit84 = ((SimpleSymbol) new SimpleSymbol("sendbtn").readResolve());
    static final IntNum Lit85;
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit87;
    static final PairWithPosition Lit88;
    static final PairWithPosition Lit89;
    static final IntNum Lit9;
    static final SimpleSymbol Lit90 = ((SimpleSymbol) new SimpleSymbol("AppendValueToList").readResolve());
    static final PairWithPosition Lit91;
    static final PairWithPosition Lit92;
    static final PairWithPosition Lit93;
    static final SimpleSymbol Lit94 = ((SimpleSymbol) new SimpleSymbol("sendbtn$Click").readResolve());
    static final SimpleSymbol Lit95 = ((SimpleSymbol) new SimpleSymbol("Click").readResolve());
    static final FString Lit96 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit97 = ((SimpleSymbol) new SimpleSymbol("msglist").readResolve());
    static final SimpleSymbol Lit98 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final IntNum Lit99;
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
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public CloudDB MsgServer;
    public final ModuleMethod MsgServer$DataChanged;
    public final ModuleMethod MsgServer$GotValue;
    public Notifier Notifier1;
    public final ModuleMethod Screen1$Initialize;
    public TinyDB TinyDB1;
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
    public Label instruction;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public ListView msglist;
    public TextBox msgtxt;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public ListPicker roomPicker;
    public final ModuleMethod roomPicker$AfterPicking;
    public final ModuleMethod send$Mnerror;
    public Button sendbtn;
    public final ModuleMethod sendbtn$Click;

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("any").readResolve();
        Lit136 = simpleSymbol;
        Lit114 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 516293), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 516288);
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit14 = simpleSymbol2;
        Lit113 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 516271), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 516265);
        Lit109 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 508101), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 508096);
        Lit108 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 508079), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 508073);
        int[] iArr = new int[2];
        iArr[0] = -16777216;
        Lit100 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -1;
        Lit99 = IntNum.make(iArr2);
        Lit93 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418677), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418671);
        Lit92 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418654), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418649), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418643);
        Lit91 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418514), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418508);
        SimpleSymbol simpleSymbol3 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit12 = simpleSymbol3;
        Lit89 = PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418071);
        Lit88 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 418044);
        Lit87 = PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 417878);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit85 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -1;
        Lit74 = IntNum.make(iArr4);
        Lit69 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229947), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229941);
        Lit68 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229846), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229840);
        Lit67 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229684), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229679), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229673);
        Lit66 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229624), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 229618);
        int[] iArr5 = new int[2];
        iArr5[0] = -1;
        Lit63 = IntNum.make(iArr5);
        Lit45 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 116270), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 116264);
        Lit44 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 116169), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 116163);
        Lit39 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115917), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115913), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115909), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115905), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115901), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115897), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115892);
        Lit38 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115711), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115706);
        Lit37 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115696), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115690);
        Lit36 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115529), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115523);
        Lit33 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115359), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115354), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115348);
        Lit30 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115160), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115155);
        Lit29 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115145), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 115139);
        Lit28 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 114978), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 114972);
        Lit25 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 114862), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 114857);
        Lit24 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 114846), "/tmp/1722529600598_301631772768269312-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo/Screen1.yail", 114840);
        int[] iArr6 = new int[2];
        iArr6[0] = -14833153;
        Lit9 = IntNum.make(iArr6);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit122, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frame2, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit123, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit124, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit125, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit126, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit127, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit128, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit129, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit130, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit131, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 13, Lit132, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 15, Lit133, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 16, Lit134, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 17, Lit135, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 18, (Object) null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime3034390928356725239.scm:634");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 20, (Object) null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 21, (Object) null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 22, (Object) null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 23, (Object) null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 24, (Object) null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 25, (Object) null, 0);
        this.Screen1$Initialize = new ModuleMethod(frame2, 26, Lit46, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 27, (Object) null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 28, (Object) null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 29, (Object) null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 30, (Object) null, 0);
        this.roomPicker$AfterPicking = new ModuleMethod(frame2, 31, Lit70, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 32, (Object) null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 33, (Object) null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 34, (Object) null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 35, (Object) null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 36, (Object) null, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 37, (Object) null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 38, (Object) null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 39, (Object) null, 0);
        this.sendbtn$Click = new ModuleMethod(frame2, 40, Lit94, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 41, (Object) null, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 42, (Object) null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 43, (Object) null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 44, (Object) null, 0);
        this.MsgServer$GotValue = new ModuleMethod(frame2, 45, Lit111, 8194);
        this.MsgServer$DataChanged = new ModuleMethod(frame2, 46, Lit115, 8194);
        lambda$Fn24 = new ModuleMethod(frame2, 47, (Object) null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 48, (Object) null, 0);
    }

    static Boolean lambda5() {
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
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit4, ""), $result);
                } else {
                    addToGlobalVars(Lit4, lambda$Fn3);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, Boolean.FALSE), $result);
                } else {
                    addToGlobalVars(Lit5, lambda$Fn4);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit6, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), $result);
                } else {
                    addToGlobalVars(Lit6, lambda$Fn5);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit7, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), $result);
                } else {
                    addToGlobalVars(Lit7, lambda$Fn6);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit8, Lit9, Lit10);
                    SimpleSymbol simpleSymbol2 = Lit11;
                    Boolean bool = Boolean.TRUE;
                    SimpleSymbol simpleSymbol3 = Lit12;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
                    SimpleSymbol simpleSymbol4 = Lit13;
                    SimpleSymbol simpleSymbol5 = Lit14;
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "ChatWorld", simpleSymbol5);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit15, "Screenshot2024-08-01104307.png", simpleSymbol5);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit16, "2b8b1b58d954d43a4da6e84972e3d40a.jpg", simpleSymbol5);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit17, "portrait", simpleSymbol5);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit18, Boolean.TRUE, simpleSymbol3);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit19, "Responsive", simpleSymbol5);
                    runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit20, "ChatWorld Neo", simpleSymbol5);
                    Values.writeValues(runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit21, "1.0 (Neo)", simpleSymbol5), $result);
                } else {
                    addToFormDoAfterCreation(new Promise(lambda$Fn7));
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit46, this.Screen1$Initialize);
                } else {
                    addToFormEnvironment(Lit46, this.Screen1$Initialize);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Screen1", "Initialize");
                } else {
                    addToEvents(simpleSymbol, Lit47);
                }
                this.HorizontalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit48, Lit49, lambda$Fn8), $result);
                } else {
                    addToComponents(simpleSymbol, Lit56, Lit49, lambda$Fn9);
                }
                this.roomPicker = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit49, Lit57, Lit40, lambda$Fn10), $result);
                } else {
                    addToComponents(Lit49, Lit64, Lit40, lambda$Fn11);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit70, this.roomPicker$AfterPicking);
                } else {
                    addToFormEnvironment(Lit70, this.roomPicker$AfterPicking);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "roomPicker", "AfterPicking");
                } else {
                    addToEvents(Lit40, Lit71);
                }
                this.instruction = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit72, Lit73, lambda$Fn12), $result);
                } else {
                    addToComponents(simpleSymbol, Lit75, Lit73, lambda$Fn13);
                }
                this.HorizontalArrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit76, Lit77, lambda$Fn14), $result);
                } else {
                    addToComponents(simpleSymbol, Lit78, Lit77, lambda$Fn15);
                }
                this.msgtxt = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit77, Lit79, Lit80, lambda$Fn16), $result);
                } else {
                    addToComponents(Lit77, Lit82, Lit80, lambda$Fn17);
                }
                this.sendbtn = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit77, Lit83, Lit84, lambda$Fn18), $result);
                } else {
                    addToComponents(Lit77, Lit86, Lit84, lambda$Fn19);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit94, this.sendbtn$Click);
                } else {
                    addToFormEnvironment(Lit94, this.sendbtn$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "sendbtn", "Click");
                } else {
                    addToEvents(Lit84, Lit95);
                }
                this.msglist = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit96, Lit97, lambda$Fn20), $result);
                } else {
                    addToComponents(simpleSymbol, Lit101, Lit97, lambda$Fn21);
                }
                this.MsgServer = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit102, Lit43, lambda$Fn22), $result);
                } else {
                    addToComponents(simpleSymbol, Lit106, Lit43, lambda$Fn23);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit111, this.MsgServer$GotValue);
                } else {
                    addToFormEnvironment(Lit111, this.MsgServer$GotValue);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "MsgServer", "GotValue");
                } else {
                    addToEvents(Lit43, Lit112);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit115, this.MsgServer$DataChanged);
                } else {
                    addToFormEnvironment(Lit115, this.MsgServer$DataChanged);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "MsgServer", "DataChanged");
                } else {
                    addToEvents(Lit43, Lit116);
                }
                this.Notifier1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit117, Lit31, Boolean.FALSE), $result);
                } else {
                    addToComponents(simpleSymbol, Lit118, Lit31, Boolean.FALSE);
                }
                this.TinyDB1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit119, Lit22, lambda$Fn24), $result);
                } else {
                    addToComponents(simpleSymbol, Lit121, Lit22, lambda$Fn25);
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

    static String lambda4() {
        return "";
    }

    static Object lambda6() {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list");
    }

    static Object lambda7() {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list");
    }

    static Object lambda8() {
        SimpleSymbol simpleSymbol = Lit0;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit8, Lit9, Lit10);
        SimpleSymbol simpleSymbol2 = Lit11;
        Boolean bool = Boolean.TRUE;
        SimpleSymbol simpleSymbol3 = Lit12;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, bool, simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit13;
        SimpleSymbol simpleSymbol5 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, "ChatWorld", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit15, "Screenshot2024-08-01104307.png", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit16, "2b8b1b58d954d43a4da6e84972e3d40a.jpg", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit17, "portrait", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit18, Boolean.TRUE, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit19, "Responsive", simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit20, "ChatWorld Neo", simpleSymbol5);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit21, "1.0 (Neo)", simpleSymbol5);
    }

    public Object Screen1$Initialize() {
        SimpleSymbol simpleSymbol;
        Pair list2;
        PairWithPosition pairWithPosition;
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        SimpleSymbol simpleSymbol2 = Lit22;
        SimpleSymbol simpleSymbol3 = Lit23;
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list2("notify-data-consent", ""), Lit24), ""), Lit25, "=") != Boolean.FALSE) {
            simpleSymbol = Lit26;
            list2 = LList.list2("notify-data-consent", Lit27);
            pairWithPosition = Lit28;
        } else if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list2("notify-data-consent", ""), Lit29), Lit27), Lit30, "=") != Boolean.FALSE) {
            runtime.callComponentMethod(Lit31, Lit32, LList.list3("Don't send overly personal messages! Data transferred may be monitored!", "Hey There!", "OK"), Lit33);
            runtime.callComponentMethod(simpleSymbol2, Lit34, LList.Empty, LList.Empty);
            simpleSymbol = Lit26;
            list2 = LList.list2("notify-data-consent", Lit35);
            pairWithPosition = Lit36;
        } else {
            runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list2("notify-data-consent", ""), Lit37), Lit35), Lit38, "=");
            Boolean bool = Boolean.FALSE;
            SimpleSymbol simpleSymbol4 = Lit6;
            ModuleMethod moduleMethod2 = runtime.make$Mnyail$Mnlist;
            Pair list1 = LList.list1("General");
            LList.chain1(LList.chain1(LList.chain4(list1, "Entertainment", "Education", "Cooking", "Sports"), "Gaming"), "Socials");
            runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol4, runtime.callYailPrimitive(moduleMethod2, list1, Lit39, "make a list"));
            runtime.setAndCoerceProperty$Ex(Lit40, Lit41, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol4, runtime.$Stthe$Mnnull$Mnvalue$St), Lit42);
            return runtime.callComponentMethod(Lit43, simpleSymbol3, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "Chat"), Lit44, "join"), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit45);
        }
        runtime.callComponentMethod(simpleSymbol2, simpleSymbol, list2, pairWithPosition);
        SimpleSymbol simpleSymbol42 = Lit6;
        ModuleMethod moduleMethod22 = runtime.make$Mnyail$Mnlist;
        Pair list12 = LList.list1("General");
        LList.chain1(LList.chain1(LList.chain4(list12, "Entertainment", "Education", "Cooking", "Sports"), "Gaming"), "Socials");
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol42, runtime.callYailPrimitive(moduleMethod22, list12, Lit39, "make a list"));
        runtime.setAndCoerceProperty$Ex(Lit40, Lit41, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol42, runtime.$Stthe$Mnnull$Mnvalue$St), Lit42);
        return runtime.callComponentMethod(Lit43, simpleSymbol3, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "Chat"), Lit44, "join"), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit45);
    }

    static Object lambda10() {
        SimpleSymbol simpleSymbol = Lit49;
        SimpleSymbol simpleSymbol2 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, Lit53, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit54, Lit55, simpleSymbol3);
    }

    static Object lambda9() {
        SimpleSymbol simpleSymbol = Lit49;
        SimpleSymbol simpleSymbol2 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, Lit53, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit54, Lit55, simpleSymbol3);
    }

    static Object lambda11() {
        SimpleSymbol simpleSymbol = Lit40;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit58, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit59;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01104552.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit60;
        IntNum intNum = Lit35;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit61, "Choose Room", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit63, simpleSymbol5);
    }

    static Object lambda12() {
        SimpleSymbol simpleSymbol = Lit40;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit58, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit59;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01104552.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit60;
        IntNum intNum = Lit35;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit61, "Choose Room", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit63, simpleSymbol5);
    }

    public Object roomPicker$AfterPicking() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit3;
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, runtime.getProperty$1(Lit40, Lit65));
        runtime.callComponentMethod(Lit31, Lit32, LList.list3(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("The following room is: ", runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit66, "join"), "You have joined a room", "OK"), Lit67);
        return runtime.callComponentMethod(Lit43, Lit23, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), "Chat"), Lit68, "join"), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit69);
    }

    static Object lambda13() {
        SimpleSymbol simpleSymbol = Lit73;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit58, Boolean.TRUE, Lit12);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit61, "Enter your name to join the chat!", Lit14);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit74, Lit10);
    }

    static Object lambda14() {
        SimpleSymbol simpleSymbol = Lit73;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit58, Boolean.TRUE, Lit12);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit61, "Enter your name to join the chat!", Lit14);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit74, Lit10);
    }

    static Object lambda15() {
        SimpleSymbol simpleSymbol = Lit77;
        SimpleSymbol simpleSymbol2 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, Lit53, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit54, Lit55, simpleSymbol3);
    }

    static Object lambda16() {
        SimpleSymbol simpleSymbol = Lit77;
        SimpleSymbol simpleSymbol2 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, Lit53, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit54, Lit55, simpleSymbol3);
    }

    static Object lambda17() {
        return runtime.setAndCoerceProperty$Ex(Lit80, Lit81, "Name here", Lit14);
    }

    static Object lambda18() {
        return runtime.setAndCoerceProperty$Ex(Lit80, Lit81, "Name here", Lit14);
    }

    static Object lambda19() {
        SimpleSymbol simpleSymbol = Lit84;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit58, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit59;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01105847.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit60;
        IntNum intNum = Lit35;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit61, "Send", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit85, simpleSymbol5);
    }

    static Object lambda20() {
        SimpleSymbol simpleSymbol = Lit84;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit58, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit59;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01105847.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit60;
        IntNum intNum = Lit35;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit61, "Send", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit85, simpleSymbol5);
    }

    public Object sendbtn$Click() {
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnnot;
        SimpleSymbol simpleSymbol = Lit5;
        if (runtime.callYailPrimitive(moduleMethod, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit87, "not") != Boolean.FALSE) {
            ModuleMethod moduleMethod2 = runtime.yail$Mnnot;
            ModuleMethod moduleMethod3 = runtime.string$Mnempty$Qu;
            SimpleSymbol simpleSymbol2 = Lit80;
            SimpleSymbol simpleSymbol3 = Lit61;
            if (runtime.callYailPrimitive(moduleMethod2, LList.list1(runtime.callYailPrimitive(moduleMethod3, LList.list1(runtime.getProperty$1(simpleSymbol2, simpleSymbol3)), Lit88, "is text empty?")), Lit89, "not") != Boolean.FALSE) {
                runtime.addGlobalVarToCurrentFormEnvironment(Lit4, runtime.getProperty$1(simpleSymbol2, simpleSymbol3));
                runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, Boolean.TRUE);
                SimpleSymbol simpleSymbol4 = Lit73;
                SimpleSymbol simpleSymbol5 = Lit14;
                runtime.setAndCoerceProperty$Ex(simpleSymbol4, simpleSymbol3, "Type in your message below and press send", simpleSymbol5);
                runtime.setAndCoerceProperty$Ex(simpleSymbol2, Lit81, "Your message here", simpleSymbol5);
            }
        } else {
            runtime.callComponentMethod(Lit43, Lit90, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "Chat"), Lit91, "join"), runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), ": ", runtime.getProperty$1(Lit80, Lit61)), Lit92, "join")), Lit93);
        }
        return runtime.setAndCoerceProperty$Ex(Lit80, Lit61, "", Lit14);
    }

    static Object lambda21() {
        SimpleSymbol simpleSymbol = Lit97;
        SimpleSymbol simpleSymbol2 = Lit98;
        IntNum intNum = Lit99;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit100, simpleSymbol3);
    }

    static Object lambda22() {
        SimpleSymbol simpleSymbol = Lit97;
        SimpleSymbol simpleSymbol2 = Lit98;
        IntNum intNum = Lit99;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit62, Lit100, simpleSymbol3);
    }

    static Object lambda23() {
        SimpleSymbol simpleSymbol = Lit43;
        SimpleSymbol simpleSymbol2 = Lit103;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "clouddb.appinventor.mit.edu", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit104, "ChatWorld_Neo", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit105, "C7uFtZt84pgYCQWvUL9Z9je7LsjqWcPV1Azb9aBAsa2W3SVssuE1rHKWiwyZzGAcXSicDuthd1R4Lyd4iUkYBw5DymoFy6j48hJX8zKDpjrRbMEBXwLQX", simpleSymbol3);
    }

    static Object lambda24() {
        SimpleSymbol simpleSymbol = Lit43;
        SimpleSymbol simpleSymbol2 = Lit103;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "clouddb.appinventor.mit.edu", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit104, "ChatWorld_Neo", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit105, "C7uFtZt84pgYCQWvUL9Z9je7LsjqWcPV1Azb9aBAsa2W3SVssuE1rHKWiwyZzGAcXSicDuthd1R4Lyd4iUkYBw5DymoFy6j48hJX8zKDpjrRbMEBXwLQX", simpleSymbol3);
    }

    public Object MsgServer$GotValue(Object $tag, Object $value) {
        Object obj;
        Object obj2;
        Object $tag2 = runtime.sanitizeComponentData($tag);
        Object $value2 = runtime.sanitizeComponentData($value);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        if ($tag2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit107), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $tag2;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "Chat"), Lit108, "join")), Lit109, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        SimpleSymbol simpleSymbol = Lit7;
        if ($value2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit110), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $value2;
        }
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, obj2);
        return runtime.setAndCoerceProperty$Ex(Lit97, Lit41, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), Lit42);
    }

    public Object MsgServer$DataChanged(Object $tag, Object $value) {
        Object obj;
        Object obj2;
        Object $tag2 = runtime.sanitizeComponentData($tag);
        Object $value2 = runtime.sanitizeComponentData($value);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        if ($tag2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit107), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $tag2;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "Chat"), Lit113, "join")), Lit114, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        SimpleSymbol simpleSymbol = Lit7;
        if ($value2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit110), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $value2;
        }
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, obj2);
        return runtime.setAndCoerceProperty$Ex(Lit97, Lit41, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), Lit42);
    }

    static Object lambda25() {
        return runtime.setAndCoerceProperty$Ex(Lit22, Lit120, "DB-Chat-neo", Lit14);
    }

    static Object lambda26() {
        return runtime.setAndCoerceProperty$Ex(Lit22, Lit120, "DB-Chat-neo", Lit14);
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
                case 45:
                case 46:
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
                case 45:
                    return this.$main.MsgServer$GotValue(obj, obj2);
                case 46:
                    return this.$main.MsgServer$DataChanged(obj, obj2);
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
                    return Screen1.lambda8();
                case 26:
                    return this.$main.Screen1$Initialize();
                case 27:
                    return Screen1.lambda9();
                case 28:
                    return Screen1.lambda10();
                case 29:
                    return Screen1.lambda11();
                case 30:
                    return Screen1.lambda12();
                case 31:
                    return this.$main.roomPicker$AfterPicking();
                case 32:
                    return Screen1.lambda13();
                case 33:
                    return Screen1.lambda14();
                case 34:
                    return Screen1.lambda15();
                case 35:
                    return Screen1.lambda16();
                case 36:
                    return Screen1.lambda17();
                case 37:
                    return Screen1.lambda18();
                case 38:
                    return Screen1.lambda19();
                case 39:
                    return Screen1.lambda20();
                case 40:
                    return this.$main.sendbtn$Click();
                case 41:
                    return Screen1.lambda21();
                case 42:
                    return Screen1.lambda22();
                case 43:
                    return Screen1.lambda23();
                case 44:
                    return Screen1.lambda24();
                case 47:
                    return Screen1.lambda25();
                case 48:
                    return Screen1.lambda26();
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
                case 41:
                case 42:
                case 43:
                case 44:
                case 47:
                case 48:
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
