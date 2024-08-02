package appinventor.ai_sonicforces207.ChatWorld_Neo_checkpoint1;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.CheckBox;
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
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit100 = ((SimpleSymbol) new SimpleSymbol("sendbtn").readResolve());
    static final IntNum Lit101;
    static final FString Lit102 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit103;
    static final PairWithPosition Lit104;
    static final PairWithPosition Lit105;
    static final PairWithPosition Lit106;
    static final SimpleSymbol Lit107 = ((SimpleSymbol) new SimpleSymbol("sendbtn$Click").readResolve());
    static final FString Lit108 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit109 = ((SimpleSymbol) new SimpleSymbol("msglist").readResolve());
    static final SimpleSymbol Lit11 = ((SimpleSymbol) new SimpleSymbol("ActionBar").readResolve());
    static final SimpleSymbol Lit110 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final IntNum Lit111;
    static final IntNum Lit112;
    static final FString Lit113 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit114 = new FString("com.google.appinventor.components.runtime.CloudDB");
    static final SimpleSymbol Lit115 = ((SimpleSymbol) new SimpleSymbol("DefaultRedisServer").readResolve());
    static final SimpleSymbol Lit116 = ((SimpleSymbol) new SimpleSymbol("ProjectID").readResolve());
    static final SimpleSymbol Lit117 = ((SimpleSymbol) new SimpleSymbol("Token").readResolve());
    static final FString Lit118 = new FString("com.google.appinventor.components.runtime.CloudDB");
    static final SimpleSymbol Lit119 = ((SimpleSymbol) new SimpleSymbol("ShowAlert").readResolve());
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit120 = ((SimpleSymbol) new SimpleSymbol("$message").readResolve());
    static final PairWithPosition Lit121;
    static final PairWithPosition Lit122;
    static final SimpleSymbol Lit123 = ((SimpleSymbol) new SimpleSymbol("MsgServer$CloudDBError").readResolve());
    static final SimpleSymbol Lit124 = ((SimpleSymbol) new SimpleSymbol("CloudDBError").readResolve());
    static final SimpleSymbol Lit125 = ((SimpleSymbol) new SimpleSymbol("$tag").readResolve());
    static final PairWithPosition Lit126;
    static final PairWithPosition Lit127;
    static final SimpleSymbol Lit128 = ((SimpleSymbol) new SimpleSymbol("$value").readResolve());
    static final PairWithPosition Lit129;
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final SimpleSymbol Lit130 = ((SimpleSymbol) new SimpleSymbol("MsgServer$GotValue").readResolve());
    static final SimpleSymbol Lit131 = ((SimpleSymbol) new SimpleSymbol("GotValue").readResolve());
    static final PairWithPosition Lit132;
    static final PairWithPosition Lit133;
    static final PairWithPosition Lit134;
    static final SimpleSymbol Lit135 = ((SimpleSymbol) new SimpleSymbol("MsgServer$DataChanged").readResolve());
    static final SimpleSymbol Lit136 = ((SimpleSymbol) new SimpleSymbol("DataChanged").readResolve());
    static final FString Lit137 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit138 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit139 = ((SimpleSymbol) new SimpleSymbol("Notifier1$AfterChoosing").readResolve());
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit140 = ((SimpleSymbol) new SimpleSymbol("AfterChoosing").readResolve());
    static final SimpleSymbol Lit141 = ((SimpleSymbol) new SimpleSymbol("StoreValue").readResolve());
    static final SimpleSymbol Lit142 = ((SimpleSymbol) new SimpleSymbol("$response").readResolve());
    static final PairWithPosition Lit143;
    static final SimpleSymbol Lit144 = ((SimpleSymbol) new SimpleSymbol("Notifier1$AfterTextInput").readResolve());
    static final SimpleSymbol Lit145 = ((SimpleSymbol) new SimpleSymbol("AfterTextInput").readResolve());
    static final IntNum Lit146 = IntNum.make(9999);
    static final PairWithPosition Lit147;
    static final PairWithPosition Lit148;
    static final PairWithPosition Lit149;
    static final SimpleSymbol Lit15 = ((SimpleSymbol) new SimpleSymbol("BackgroundImage").readResolve());
    static final PairWithPosition Lit150;
    static final PairWithPosition Lit151;
    static final SimpleSymbol Lit152 = ((SimpleSymbol) new SimpleSymbol("Notifier1$TextInputCanceled").readResolve());
    static final SimpleSymbol Lit153 = ((SimpleSymbol) new SimpleSymbol("TextInputCanceled").readResolve());
    static final FString Lit154 = new FString("com.google.appinventor.components.runtime.TinyDB");
    static final SimpleSymbol Lit155 = ((SimpleSymbol) new SimpleSymbol("Namespace").readResolve());
    static final FString Lit156 = new FString("com.google.appinventor.components.runtime.TinyDB");
    static final SimpleSymbol Lit157 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit158 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit159 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit16 = ((SimpleSymbol) new SimpleSymbol("Icon").readResolve());
    static final SimpleSymbol Lit160 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final SimpleSymbol Lit161 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit162 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit163 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit164 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit165 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit166 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit167 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit168 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit169 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit17 = ((SimpleSymbol) new SimpleSymbol("ScreenOrientation").readResolve());
    static final SimpleSymbol Lit170 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit171;
    static final SimpleSymbol Lit18 = ((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve());
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol("Sizing").readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final SimpleSymbol Lit20 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("VersionName").readResolve());
    static final PairWithPosition Lit22;
    static final SimpleSymbol Lit23 = ((SimpleSymbol) new SimpleSymbol("roomPicker").readResolve());
    static final SimpleSymbol Lit24 = ((SimpleSymbol) new SimpleSymbol("Elements").readResolve());
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26 = ((SimpleSymbol) new SimpleSymbol("MsgServer").readResolve());
    static final SimpleSymbol Lit27 = ((SimpleSymbol) new SimpleSymbol("GetValue").readResolve());
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("g$roomname").readResolve());
    static final SimpleSymbol Lit30 = ((SimpleSymbol) new SimpleSymbol(TinyDB.DEFAULT_NAMESPACE).readResolve());
    static final PairWithPosition Lit31;
    static final PairWithPosition Lit32;
    static final SimpleSymbol Lit33 = ((SimpleSymbol) new SimpleSymbol("Notifier1").readResolve());
    static final SimpleSymbol Lit34 = ((SimpleSymbol) new SimpleSymbol("ShowTextDialog").readResolve());
    static final PairWithPosition Lit35;
    static final SimpleSymbol Lit36 = ((SimpleSymbol) new SimpleSymbol("Screen1$Initialize").readResolve());
    static final SimpleSymbol Lit37 = ((SimpleSymbol) new SimpleSymbol("Initialize").readResolve());
    static final FString Lit38 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit39 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve());
    static final SimpleSymbol Lit4 = ((SimpleSymbol) new SimpleSymbol("g$username").readResolve());
    static final SimpleSymbol Lit40 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit41 = IntNum.make(3);
    static final SimpleSymbol Lit42 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit43 = IntNum.make(2);
    static final SimpleSymbol Lit44 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit45 = IntNum.make(-2);
    static final FString Lit46 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit47 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit48 = ((SimpleSymbol) new SimpleSymbol("FontBold").readResolve());
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol(Component.LISTVIEW_KEY_IMAGE).readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("g$joinedStatus").readResolve());
    static final SimpleSymbol Lit50 = ((SimpleSymbol) new SimpleSymbol("Shape").readResolve());
    static final IntNum Lit51 = IntNum.make(1);
    static final SimpleSymbol Lit52 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final SimpleSymbol Lit53 = ((SimpleSymbol) new SimpleSymbol("TextColor").readResolve());
    static final IntNum Lit54;
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit56 = ((SimpleSymbol) new SimpleSymbol("Selection").readResolve());
    static final SimpleSymbol Lit57 = ((SimpleSymbol) new SimpleSymbol("ShowMessageDialog").readResolve());
    static final PairWithPosition Lit58;
    static final PairWithPosition Lit59;
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("g$roomList").readResolve());
    static final PairWithPosition Lit60;
    static final PairWithPosition Lit61;
    static final SimpleSymbol Lit62 = ((SimpleSymbol) new SimpleSymbol("CheckBox1").readResolve());
    static final SimpleSymbol Lit63 = ((SimpleSymbol) new SimpleSymbol("Checked").readResolve());
    static final PairWithPosition Lit64;
    static final SimpleSymbol Lit65 = ((SimpleSymbol) new SimpleSymbol("AppendValueToList").readResolve());
    static final PairWithPosition Lit66;
    static final PairWithPosition Lit67;
    static final PairWithPosition Lit68;
    static final PairWithPosition Lit69;
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("g$chatMsg").readResolve());
    static final SimpleSymbol Lit70 = ((SimpleSymbol) new SimpleSymbol("roomPicker$AfterPicking").readResolve());
    static final SimpleSymbol Lit71 = ((SimpleSymbol) new SimpleSymbol("AfterPicking").readResolve());
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit73 = ((SimpleSymbol) new SimpleSymbol("user").readResolve());
    static final SimpleSymbol Lit74 = ((SimpleSymbol) new SimpleSymbol("Height").readResolve());
    static final IntNum Lit75 = IntNum.make(50);
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit77;
    static final SimpleSymbol Lit78 = ((SimpleSymbol) new SimpleSymbol("user$Click").readResolve());
    static final SimpleSymbol Lit79 = ((SimpleSymbol) new SimpleSymbol("Click").readResolve());
    static final SimpleSymbol Lit8 = ((SimpleSymbol) new SimpleSymbol("AccentColor").readResolve());
    static final FString Lit80 = new FString("com.google.appinventor.components.runtime.CheckBox");
    static final SimpleSymbol Lit81 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final IntNum Lit82 = IntNum.make(12);
    static final FString Lit83 = new FString("com.google.appinventor.components.runtime.CheckBox");
    static final PairWithPosition Lit84;
    static final PairWithPosition Lit85;
    static final SimpleSymbol Lit86 = ((SimpleSymbol) new SimpleSymbol("CheckBox1$Changed").readResolve());
    static final SimpleSymbol Lit87 = ((SimpleSymbol) new SimpleSymbol("Changed").readResolve());
    static final FString Lit88 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit89 = ((SimpleSymbol) new SimpleSymbol("instruction").readResolve());
    static final IntNum Lit9;
    static final IntNum Lit90;
    static final FString Lit91 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit92 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit93 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement2").readResolve());
    static final FString Lit94 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit95 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final SimpleSymbol Lit96 = ((SimpleSymbol) new SimpleSymbol("msgtxt").readResolve());
    static final SimpleSymbol Lit97 = ((SimpleSymbol) new SimpleSymbol("Hint").readResolve());
    static final FString Lit98 = new FString("com.google.appinventor.components.runtime.TextBox");
    static final FString Lit99 = new FString("com.google.appinventor.components.runtime.Button");
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
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn4 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn7 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public CheckBox CheckBox1;
    public final ModuleMethod CheckBox1$Changed;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public CloudDB MsgServer;
    public final ModuleMethod MsgServer$CloudDBError;
    public final ModuleMethod MsgServer$DataChanged;
    public final ModuleMethod MsgServer$GotValue;
    public Notifier Notifier1;
    public final ModuleMethod Notifier1$AfterChoosing;
    public final ModuleMethod Notifier1$AfterTextInput;
    public final ModuleMethod Notifier1$TextInputCanceled;
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
    public Button user;
    public final ModuleMethod user$Click;

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol("any").readResolve();
        Lit171 = simpleSymbol;
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit14 = simpleSymbol2;
        Lit151 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676455), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676449);
        Lit150 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676334);
        Lit149 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676317), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676312), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676306);
        Lit148 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676036), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676030);
        SimpleSymbol simpleSymbol3 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
        Lit10 = simpleSymbol3;
        Lit147 = PairWithPosition.make(simpleSymbol3, PairWithPosition.make(simpleSymbol3, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 676001), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 675993);
        Lit143 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 667772), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 667766);
        SimpleSymbol simpleSymbol4 = (SimpleSymbol) new SimpleSymbol("list").readResolve();
        Lit25 = simpleSymbol4;
        Lit134 = PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 631119);
        Lit133 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 630995), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 630990);
        Lit132 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 630973), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 630967);
        Lit129 = PairWithPosition.make(simpleSymbol4, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 622927);
        Lit127 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 622803), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 622798);
        Lit126 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 622781), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 622775);
        Lit122 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 614614);
        Lit121 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 614597), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 614592), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 614586);
        int[] iArr = new int[2];
        iArr[0] = -16777216;
        Lit112 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -1;
        Lit111 = IntNum.make(iArr2);
        Lit106 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524732), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524726);
        Lit105 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524709), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524704), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524698);
        Lit104 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524655), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524649);
        Lit103 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524472), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 524466);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit101 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -1;
        Lit90 = IntNum.make(iArr4);
        Lit85 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 336175), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 336170), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 336164);
        Lit84 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 335979), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 335974);
        SimpleSymbol simpleSymbol5 = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve();
        Lit12 = simpleSymbol5;
        Lit77 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 291040), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 291035), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 291029);
        Lit69 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230536), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230530);
        Lit68 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230513), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230508), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230502);
        Lit67 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230449), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230443);
        Lit66 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230266), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230260);
        Lit64 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230068), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 230063);
        Lit61 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229961), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229955);
        Lit60 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229860), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229854);
        Lit59 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229684), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229679), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229673);
        Lit58 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229624), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 229618);
        int[] iArr5 = new int[2];
        iArr5[0] = -1;
        Lit54 = IntNum.make(iArr5);
        Lit35 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol5, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115668), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115663), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115657);
        Lit32 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115430), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115425);
        Lit31 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115414), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115408);
        Lit29 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115258), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115252);
        Lit28 = PairWithPosition.make(simpleSymbol2, PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115157), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 115151);
        Lit22 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, PairWithPosition.make(simpleSymbol, LList.Empty, "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114891), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114887), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114883), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114879), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114875), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114871), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114867), "/tmp/1722617939099_6851643722386447360-0/youngandroidproject/../src/appinventor/ai_sonicforces207/ChatWorld_Neo_checkpoint1/Screen1.yail", 114862);
        int[] iArr6 = new int[2];
        iArr6[0] = -14833153;
        Lit9 = IntNum.make(iArr6);
    }

    public Screen1() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.$main = this;
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit157, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frame2, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit158, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit159, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit160, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit161, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit162, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit163, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit164, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit165, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit166, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 13, Lit167, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 15, Lit168, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 16, Lit169, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 17, Lit170, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 18, (Object) null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime10591150254616169825.scm:634");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 20, (Object) null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 21, (Object) null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 22, (Object) null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 23, (Object) null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 24, (Object) null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 25, (Object) null, 0);
        this.Screen1$Initialize = new ModuleMethod(frame2, 26, Lit36, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 27, (Object) null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 28, (Object) null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 29, (Object) null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 30, (Object) null, 0);
        this.roomPicker$AfterPicking = new ModuleMethod(frame2, 31, Lit70, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 32, (Object) null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 33, (Object) null, 0);
        this.user$Click = new ModuleMethod(frame2, 34, Lit78, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 35, (Object) null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 36, (Object) null, 0);
        this.CheckBox1$Changed = new ModuleMethod(frame2, 37, Lit86, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 38, (Object) null, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 39, (Object) null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 40, (Object) null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 41, (Object) null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 42, (Object) null, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 43, (Object) null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 44, (Object) null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 45, (Object) null, 0);
        this.sendbtn$Click = new ModuleMethod(frame2, 46, Lit107, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 47, (Object) null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 48, (Object) null, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 49, (Object) null, 0);
        lambda$Fn27 = new ModuleMethod(frame2, 50, (Object) null, 0);
        this.MsgServer$CloudDBError = new ModuleMethod(frame2, 51, Lit123, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.MsgServer$GotValue = new ModuleMethod(frame2, 52, Lit130, 8194);
        this.MsgServer$DataChanged = new ModuleMethod(frame2, 53, Lit135, 8194);
        this.Notifier1$AfterChoosing = new ModuleMethod(frame2, 54, Lit139, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.Notifier1$AfterTextInput = new ModuleMethod(frame2, 55, Lit144, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.Notifier1$TextInputCanceled = new ModuleMethod(frame2, 56, Lit152, 0);
        lambda$Fn28 = new ModuleMethod(frame2, 57, (Object) null, 0);
        lambda$Fn29 = new ModuleMethod(frame2, 58, (Object) null, 0);
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
                    runtime.addToCurrentFormEnvironment(Lit36, this.Screen1$Initialize);
                } else {
                    addToFormEnvironment(Lit36, this.Screen1$Initialize);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Screen1", "Initialize");
                } else {
                    addToEvents(simpleSymbol, Lit37);
                }
                this.HorizontalArrangement1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit38, Lit39, lambda$Fn8), $result);
                } else {
                    addToComponents(simpleSymbol, Lit46, Lit39, lambda$Fn9);
                }
                this.roomPicker = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit39, Lit47, Lit23, lambda$Fn10), $result);
                } else {
                    addToComponents(Lit39, Lit55, Lit23, lambda$Fn11);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit70, this.roomPicker$AfterPicking);
                } else {
                    addToFormEnvironment(Lit70, this.roomPicker$AfterPicking);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "roomPicker", "AfterPicking");
                } else {
                    addToEvents(Lit23, Lit71);
                }
                this.user = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit39, Lit72, Lit73, lambda$Fn12), $result);
                } else {
                    addToComponents(Lit39, Lit76, Lit73, lambda$Fn13);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit78, this.user$Click);
                } else {
                    addToFormEnvironment(Lit78, this.user$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "user", "Click");
                } else {
                    addToEvents(Lit73, Lit79);
                }
                this.CheckBox1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit39, Lit80, Lit62, lambda$Fn14), $result);
                } else {
                    addToComponents(Lit39, Lit83, Lit62, lambda$Fn15);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit86, this.CheckBox1$Changed);
                } else {
                    addToFormEnvironment(Lit86, this.CheckBox1$Changed);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "CheckBox1", "Changed");
                } else {
                    addToEvents(Lit62, Lit87);
                }
                this.instruction = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit88, Lit89, lambda$Fn16), $result);
                } else {
                    addToComponents(simpleSymbol, Lit91, Lit89, lambda$Fn17);
                }
                this.HorizontalArrangement2 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit92, Lit93, lambda$Fn18), $result);
                } else {
                    addToComponents(simpleSymbol, Lit94, Lit93, lambda$Fn19);
                }
                this.msgtxt = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit93, Lit95, Lit96, lambda$Fn20), $result);
                } else {
                    addToComponents(Lit93, Lit98, Lit96, lambda$Fn21);
                }
                this.sendbtn = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(Lit93, Lit99, Lit100, lambda$Fn22), $result);
                } else {
                    addToComponents(Lit93, Lit102, Lit100, lambda$Fn23);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit107, this.sendbtn$Click);
                } else {
                    addToFormEnvironment(Lit107, this.sendbtn$Click);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "sendbtn", "Click");
                } else {
                    addToEvents(Lit100, Lit79);
                }
                this.msglist = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit108, Lit109, lambda$Fn24), $result);
                } else {
                    addToComponents(simpleSymbol, Lit113, Lit109, lambda$Fn25);
                }
                this.MsgServer = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit114, Lit26, lambda$Fn26), $result);
                } else {
                    addToComponents(simpleSymbol, Lit118, Lit26, lambda$Fn27);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit123, this.MsgServer$CloudDBError);
                } else {
                    addToFormEnvironment(Lit123, this.MsgServer$CloudDBError);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "MsgServer", "CloudDBError");
                } else {
                    addToEvents(Lit26, Lit124);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit130, this.MsgServer$GotValue);
                } else {
                    addToFormEnvironment(Lit130, this.MsgServer$GotValue);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "MsgServer", "GotValue");
                } else {
                    addToEvents(Lit26, Lit131);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit135, this.MsgServer$DataChanged);
                } else {
                    addToFormEnvironment(Lit135, this.MsgServer$DataChanged);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "MsgServer", "DataChanged");
                } else {
                    addToEvents(Lit26, Lit136);
                }
                this.Notifier1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit137, Lit33, Boolean.FALSE), $result);
                } else {
                    addToComponents(simpleSymbol, Lit138, Lit33, Boolean.FALSE);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit139, this.Notifier1$AfterChoosing);
                } else {
                    addToFormEnvironment(Lit139, this.Notifier1$AfterChoosing);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Notifier1", "AfterChoosing");
                } else {
                    addToEvents(Lit33, Lit140);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit144, this.Notifier1$AfterTextInput);
                } else {
                    addToFormEnvironment(Lit144, this.Notifier1$AfterTextInput);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Notifier1", "AfterTextInput");
                } else {
                    addToEvents(Lit33, Lit145);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    runtime.addToCurrentFormEnvironment(Lit152, this.Notifier1$TextInputCanceled);
                } else {
                    addToFormEnvironment(Lit152, this.Notifier1$TextInputCanceled);
                }
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Notifier1", "TextInputCanceled");
                } else {
                    addToEvents(Lit33, Lit153);
                }
                this.TinyDB1 = null;
                if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
                    Values.writeValues(runtime.addComponentWithinRepl(simpleSymbol, Lit154, Lit30, lambda$Fn28), $result);
                } else {
                    addToComponents(simpleSymbol, Lit156, Lit30, lambda$Fn29);
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
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit6;
        ModuleMethod moduleMethod = runtime.make$Mnyail$Mnlist;
        Pair list1 = LList.list1("General");
        LList.chain1(LList.chain1(LList.chain1(LList.chain4(list1, "Entertainment", "Education", "Cooking", "Sports"), "Gaming"), "Social"), "App testing");
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, runtime.callYailPrimitive(moduleMethod, list1, Lit22, "make a list"));
        runtime.setAndCoerceProperty$Ex(Lit23, Lit24, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), Lit25);
        SimpleSymbol simpleSymbol2 = Lit26;
        SimpleSymbol simpleSymbol3 = Lit27;
        runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "ChatWorldNeo-final"), Lit28, "join"), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit29);
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callComponentMethod(Lit30, simpleSymbol3, LList.list2("username-dbstored", ""), Lit31), ""), Lit32, "=") != Boolean.FALSE ? runtime.callComponentMethod(Lit33, Lit34, LList.list3("This username will persist but can be changed by clicking on the button with the user icon at any time.", "What is your username?", Boolean.TRUE), Lit35) : Boolean.FALSE;
    }

    static Object lambda10() {
        SimpleSymbol simpleSymbol = Lit39;
        SimpleSymbol simpleSymbol2 = Lit40;
        IntNum intNum = Lit41;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit42, Lit43, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit44, Lit45, simpleSymbol3);
    }

    static Object lambda9() {
        SimpleSymbol simpleSymbol = Lit39;
        SimpleSymbol simpleSymbol2 = Lit40;
        IntNum intNum = Lit41;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit42, Lit43, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit44, Lit45, simpleSymbol3);
    }

    static Object lambda11() {
        SimpleSymbol simpleSymbol = Lit23;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit48, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit49;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01104552.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Choose Room", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit54, simpleSymbol5);
    }

    static Object lambda12() {
        SimpleSymbol simpleSymbol = Lit23;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit48, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit49;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01104552.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Choose Room", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit54, simpleSymbol5);
    }

    public Object roomPicker$AfterPicking() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit3;
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, runtime.getProperty$1(Lit23, Lit56));
        runtime.callComponentMethod(Lit33, Lit57, LList.list3(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("The following room is: ", runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit58, "join"), "You have joined a room", "OK"), Lit59);
        SimpleSymbol simpleSymbol2 = Lit26;
        SimpleSymbol simpleSymbol3 = Lit27;
        runtime.callComponentMethod(simpleSymbol2, simpleSymbol3, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), "ChatWorldNeo-final"), Lit60, "join"), runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.Empty, LList.Empty, "make a list")), Lit61);
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit62, Lit63), Boolean.TRUE), Lit64, "=") != Boolean.FALSE ? runtime.callComponentMethod(simpleSymbol2, Lit65, LList.list2(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), "ChatWorldNeo-final"), Lit66, "join"), runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.callComponentMethod(Lit30, simpleSymbol3, LList.list2("username-dbstored", runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit67), "has joined the room ", runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit68, "join")), Lit69) : Boolean.FALSE;
    }

    static Object lambda13() {
        SimpleSymbol simpleSymbol = Lit73;
        SimpleSymbol simpleSymbol2 = Lit74;
        IntNum intNum = Lit75;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit49, "ScreenShot2024-08-01at9.18.47PM.png", Lit14);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit50, Lit51, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit44, intNum, simpleSymbol3);
    }

    static Object lambda14() {
        SimpleSymbol simpleSymbol = Lit73;
        SimpleSymbol simpleSymbol2 = Lit74;
        IntNum intNum = Lit75;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit49, "ScreenShot2024-08-01at9.18.47PM.png", Lit14);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit50, Lit51, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit44, intNum, simpleSymbol3);
    }

    public Object user$Click() {
        runtime.setThisForm();
        return runtime.callComponentMethod(Lit33, Lit34, LList.list3("This username will persist but can be changed by clicking on the button with the user icon at any time.", "What is your username?", Boolean.TRUE), Lit77);
    }

    static Object lambda15() {
        SimpleSymbol simpleSymbol = Lit62;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit81, Lit82, Lit10);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Alert when joined", Lit14);
    }

    static Object lambda16() {
        SimpleSymbol simpleSymbol = Lit62;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit81, Lit82, Lit10);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Alert when joined", Lit14);
    }

    public Object CheckBox1$Changed() {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.getProperty$1(Lit62, Lit63), Boolean.TRUE), Lit84, "=") != Boolean.FALSE ? runtime.callComponentMethod(Lit33, Lit57, LList.list3("This will alert users when you join a room in the chat.", "Alert when joined is on", "OK"), Lit85) : Boolean.FALSE;
    }

    static Object lambda17() {
        SimpleSymbol simpleSymbol = Lit89;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit48, Boolean.TRUE, Lit12);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Enter your message below!", Lit14);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit90, Lit10);
    }

    static Object lambda18() {
        SimpleSymbol simpleSymbol = Lit89;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit48, Boolean.TRUE, Lit12);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Enter your message below!", Lit14);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit90, Lit10);
    }

    static Object lambda19() {
        SimpleSymbol simpleSymbol = Lit93;
        SimpleSymbol simpleSymbol2 = Lit40;
        IntNum intNum = Lit41;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit42, Lit43, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit44, Lit45, simpleSymbol3);
    }

    static Object lambda20() {
        SimpleSymbol simpleSymbol = Lit93;
        SimpleSymbol simpleSymbol2 = Lit40;
        IntNum intNum = Lit41;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit42, Lit43, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit44, Lit45, simpleSymbol3);
    }

    static Object lambda21() {
        return runtime.setAndCoerceProperty$Ex(Lit96, Lit97, "Your message here", Lit14);
    }

    static Object lambda22() {
        return runtime.setAndCoerceProperty$Ex(Lit96, Lit97, "Your message here", Lit14);
    }

    static Object lambda23() {
        SimpleSymbol simpleSymbol = Lit100;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit48, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit49;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01105847.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Send", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit101, simpleSymbol5);
    }

    static Object lambda24() {
        SimpleSymbol simpleSymbol = Lit100;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit48, Boolean.TRUE, Lit12);
        SimpleSymbol simpleSymbol2 = Lit49;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "Screenshot2024-08-01105847.png", simpleSymbol3);
        SimpleSymbol simpleSymbol4 = Lit50;
        IntNum intNum = Lit51;
        SimpleSymbol simpleSymbol5 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol4, intNum, simpleSymbol5);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit52, "Send", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit101, simpleSymbol5);
    }

    public Object sendbtn$Click() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit26;
        SimpleSymbol simpleSymbol2 = Lit65;
        Object callYailPrimitive = runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "ChatWorldNeo-final"), Lit103, "join");
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object callComponentMethod = runtime.callComponentMethod(Lit30, Lit27, LList.list2("username-dbstored", runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit104);
        SimpleSymbol simpleSymbol3 = Lit96;
        SimpleSymbol simpleSymbol4 = Lit52;
        runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list2(callYailPrimitive, runtime.callYailPrimitive(moduleMethod, LList.list3(callComponentMethod, ": ", runtime.getProperty$1(simpleSymbol3, simpleSymbol4)), Lit105, "join")), Lit106);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol3, simpleSymbol4, "", Lit14);
    }

    static Object lambda25() {
        SimpleSymbol simpleSymbol = Lit109;
        SimpleSymbol simpleSymbol2 = Lit110;
        IntNum intNum = Lit111;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit112, simpleSymbol3);
    }

    static Object lambda26() {
        SimpleSymbol simpleSymbol = Lit109;
        SimpleSymbol simpleSymbol2 = Lit110;
        IntNum intNum = Lit111;
        SimpleSymbol simpleSymbol3 = Lit10;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, intNum, simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit53, Lit112, simpleSymbol3);
    }

    static Object lambda27() {
        SimpleSymbol simpleSymbol = Lit26;
        SimpleSymbol simpleSymbol2 = Lit115;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "clouddb.appinventor.mit.edu", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit116, "ChatWorld_Neo", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit117, "C7uFtZt84pgYCQWvUL9Z9je7LsjqWcPV1Azb9aBAsa2W3SVssuE1rHKWiwyZzGAcXSicDuthd1R4Lyd4iUkYBw5DymoFy6j48hJX8zKDpjrRbMEBXwLQX", simpleSymbol3);
    }

    static Object lambda28() {
        SimpleSymbol simpleSymbol = Lit26;
        SimpleSymbol simpleSymbol2 = Lit115;
        SimpleSymbol simpleSymbol3 = Lit14;
        runtime.setAndCoerceProperty$Ex(simpleSymbol, simpleSymbol2, "clouddb.appinventor.mit.edu", simpleSymbol3);
        runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit116, "ChatWorld_Neo", simpleSymbol3);
        return runtime.setAndCoerceProperty$Ex(simpleSymbol, Lit117, "C7uFtZt84pgYCQWvUL9Z9je7LsjqWcPV1Azb9aBAsa2W3SVssuE1rHKWiwyZzGAcXSicDuthd1R4Lyd4iUkYBw5DymoFy6j48hJX8zKDpjrRbMEBXwLQX", simpleSymbol3);
    }

    public Object MsgServer$CloudDBError(Object $message) {
        Object obj;
        Object $message2 = runtime.sanitizeComponentData($message);
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit33;
        SimpleSymbol simpleSymbol2 = Lit119;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        if ($message2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit120), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $message2;
        }
        return runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list1(runtime.callYailPrimitive(moduleMethod, LList.list3("An error has occured, \"", obj, "\"."), Lit121, "join")), Lit122);
    }

    public Object MsgServer$GotValue(Object $tag, Object $value) {
        Object obj;
        Object obj2;
        Object $tag2 = runtime.sanitizeComponentData($tag);
        Object $value2 = runtime.sanitizeComponentData($value);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        if ($tag2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit125), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $tag2;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "ChatWorldNeo-final"), Lit126, "join")), Lit127, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        SimpleSymbol simpleSymbol = Lit7;
        ModuleMethod moduleMethod2 = runtime.yail$Mnlist$Mnreverse;
        if ($value2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit128), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $value2;
        }
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, runtime.callYailPrimitive(moduleMethod2, LList.list1(obj2), Lit129, "reverse list"));
        return runtime.setAndCoerceProperty$Ex(Lit109, Lit24, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), Lit25);
    }

    public Object MsgServer$DataChanged(Object $tag, Object $value) {
        Object obj;
        Object obj2;
        Object $tag2 = runtime.sanitizeComponentData($tag);
        Object $value2 = runtime.sanitizeComponentData($value);
        runtime.setThisForm();
        ModuleMethod moduleMethod = runtime.yail$Mnequal$Qu;
        if ($tag2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit125), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $tag2;
        }
        if (runtime.callYailPrimitive(moduleMethod, LList.list2(obj, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), "ChatWorldNeo-final"), Lit132, "join")), Lit133, "=") == Boolean.FALSE) {
            return Values.empty;
        }
        SimpleSymbol simpleSymbol = Lit7;
        ModuleMethod moduleMethod2 = runtime.yail$Mnlist$Mnreverse;
        if ($value2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit128), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $value2;
        }
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, runtime.callYailPrimitive(moduleMethod2, LList.list1(obj2), Lit134, "reverse list"));
        return runtime.setAndCoerceProperty$Ex(Lit109, Lit24, runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), Lit25);
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
        SimpleSymbol simpleSymbol = Lit30;
        SimpleSymbol simpleSymbol2 = Lit141;
        if ($response2 instanceof Package) {
            obj = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit142), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj = $response2;
        }
        runtime.callComponentMethod(simpleSymbol, simpleSymbol2, LList.list2("username-dbstored", obj), Lit143);
        SimpleSymbol simpleSymbol3 = Lit4;
        if ($response2 instanceof Package) {
            obj2 = runtime.signalRuntimeError(strings.stringAppend("The variable ", runtime.getDisplayRepresentation(Lit142), " is not bound in the current context"), "Unbound Variable");
        } else {
            obj2 = $response2;
        }
        return runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol3, obj2);
    }

    public Object Notifier1$TextInputCanceled() {
        runtime.setThisForm();
        SimpleSymbol simpleSymbol = Lit4;
        runtime.addGlobalVarToCurrentFormEnvironment(simpleSymbol, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("user", runtime.callYailPrimitive(runtime.random$Mninteger, LList.list2(Lit51, Lit146), Lit147, "random integer")), Lit148, "join"));
        runtime.callComponentMethod(Lit33, Lit119, LList.list1(runtime.callYailPrimitive(strings.string$Mnappend, LList.list3("You have been given the username: ", runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St), ". Click on the user icon to change your username if you do not like it."), Lit149, "join")), Lit150);
        return runtime.callComponentMethod(Lit30, Lit141, LList.list2("username-dbstored", runtime.lookupGlobalVarInCurrentFormEnvironment(simpleSymbol, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit151);
    }

    static Object lambda29() {
        return runtime.setAndCoerceProperty$Ex(Lit30, Lit155, "DB-Chat-neo", Lit14);
    }

    static Object lambda30() {
        return runtime.setAndCoerceProperty$Ex(Lit30, Lit155, "DB-Chat-neo", Lit14);
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
                case 51:
                case 54:
                case 55:
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
                case 52:
                case 53:
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
                case 51:
                    return this.$main.MsgServer$CloudDBError(obj);
                case 54:
                    return this.$main.Notifier1$AfterChoosing(obj);
                case 55:
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
                case 52:
                    return this.$main.MsgServer$GotValue(obj, obj2);
                case 53:
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
                    return this.$main.user$Click();
                case 35:
                    return Screen1.lambda15();
                case 36:
                    return Screen1.lambda16();
                case 37:
                    return this.$main.CheckBox1$Changed();
                case 38:
                    return Screen1.lambda17();
                case 39:
                    return Screen1.lambda18();
                case 40:
                    return Screen1.lambda19();
                case 41:
                    return Screen1.lambda20();
                case 42:
                    return Screen1.lambda21();
                case 43:
                    return Screen1.lambda22();
                case 44:
                    return Screen1.lambda23();
                case 45:
                    return Screen1.lambda24();
                case 46:
                    return this.$main.sendbtn$Click();
                case 47:
                    return Screen1.lambda25();
                case 48:
                    return Screen1.lambda26();
                case 49:
                    return Screen1.lambda27();
                case 50:
                    return Screen1.lambda28();
                case 56:
                    return this.$main.Notifier1$TextInputCanceled();
                case 57:
                    return Screen1.lambda29();
                case 58:
                    return Screen1.lambda30();
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
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 56:
                case 57:
                case 58:
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
