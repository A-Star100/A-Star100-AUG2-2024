package cl.json;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import cl.json.social.DiscordShare;
import cl.json.social.EmailShare;
import cl.json.social.FacebookPagesManagerShare;
import cl.json.social.FacebookShare;
import cl.json.social.FacebookStoriesShare;
import cl.json.social.GenericShare;
import cl.json.social.GooglePlusShare;
import cl.json.social.InstagramShare;
import cl.json.social.InstagramStoriesShare;
import cl.json.social.LinkedinShare;
import cl.json.social.MessengerShare;
import cl.json.social.PinterestShare;
import cl.json.social.SMSShare;
import cl.json.social.ShareIntent;
import cl.json.social.SnapChatShare;
import cl.json.social.TargetChosenReceiver;
import cl.json.social.TelegramShare;
import cl.json.social.TwitterShare;
import cl.json.social.ViberShare;
import cl.json.social.WhatsAppBusinessShare;
import cl.json.social.WhatsAppShare;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RNShareImpl implements ActivityEventListener {
    public static final String NAME = "RNShare";
    static ReactApplicationContext RCTContext = null;
    public static final int SHARE_REQUEST_CODE = 16845;

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 16845) {
            return;
        }
        if (i2 == 0) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean("success", false);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "CANCELED");
            TargetChosenReceiver.callbackResolve(createMap);
        } else if (i2 == -1) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putBoolean("success", true);
            TargetChosenReceiver.callbackResolve(createMap2);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    private enum SHARES {
        facebook,
        facebookstories,
        generic,
        pagesmanager,
        twitter,
        whatsapp,
        whatsappbusiness,
        instagram,
        instagramstories,
        googleplus,
        email,
        pinterest,
        messenger,
        snapchat,
        sms,
        linkedin,
        telegram,
        viber,
        discord;

        public static ShareIntent getShareClass(String str, ReactApplicationContext reactApplicationContext) {
            switch (valueOf(str).ordinal()) {
                case 0:
                    return new FacebookShare(reactApplicationContext);
                case 1:
                    return new FacebookStoriesShare(reactApplicationContext);
                case 2:
                    return new GenericShare(reactApplicationContext);
                case 3:
                    return new FacebookPagesManagerShare(reactApplicationContext);
                case 4:
                    return new TwitterShare(reactApplicationContext);
                case 5:
                    return new WhatsAppShare(reactApplicationContext);
                case 6:
                    return new WhatsAppBusinessShare(reactApplicationContext);
                case 7:
                    return new InstagramShare(reactApplicationContext);
                case 8:
                    return new InstagramStoriesShare(reactApplicationContext);
                case 9:
                    return new GooglePlusShare(reactApplicationContext);
                case 10:
                    return new EmailShare(reactApplicationContext);
                case 11:
                    return new PinterestShare(reactApplicationContext);
                case 12:
                    return new MessengerShare(reactApplicationContext);
                case 13:
                    return new SnapChatShare(reactApplicationContext);
                case 14:
                    return new SMSShare(reactApplicationContext);
                case 15:
                    return new LinkedinShare(reactApplicationContext);
                case 16:
                    return new TelegramShare(reactApplicationContext);
                case 17:
                    return new ViberShare(reactApplicationContext);
                case 18:
                    return new DiscordShare(reactApplicationContext);
                default:
                    return null;
            }
        }
    }

    public RNShareImpl(ReactApplicationContext reactApplicationContext) {
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(this);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        for (SHARES shares : SHARES.values()) {
            hashMap.put(shares.toString().toUpperCase(Locale.ROOT), shares.toString());
        }
        return hashMap;
    }

    public void open(ReadableMap readableMap, Promise promise) {
        TargetChosenReceiver.registerCallbacks(promise);
        try {
            new GenericShare(RCTContext).open(readableMap);
        } catch (ActivityNotFoundException e) {
            Log.e(NAME, e.getMessage());
            e.printStackTrace(System.out);
            TargetChosenReceiver.callbackReject("not_available");
        } catch (Exception e2) {
            Log.e(NAME, e2.getMessage());
            e2.printStackTrace(System.out);
            TargetChosenReceiver.callbackReject(e2.getMessage());
        }
    }

    public void shareSingle(ReadableMap readableMap, Promise promise) {
        TargetChosenReceiver.registerCallbacks(promise);
        if (ShareIntent.hasValidKey(NotificationCompat.CATEGORY_SOCIAL, readableMap)) {
            try {
                ShareIntent shareClass = SHARES.getShareClass(readableMap.getString(NotificationCompat.CATEGORY_SOCIAL), RCTContext);
                if (shareClass == null || !(shareClass instanceof ShareIntent)) {
                    throw new ActivityNotFoundException("Invalid share activity");
                }
                shareClass.open(readableMap);
            } catch (ActivityNotFoundException e) {
                Log.e(NAME, e.getMessage());
                e.printStackTrace(System.out);
                TargetChosenReceiver.callbackReject(e.getMessage());
            } catch (Exception e2) {
                Log.e(NAME, e2.getMessage());
                e2.printStackTrace(System.out);
                TargetChosenReceiver.callbackReject(e2.getMessage());
            }
        } else {
            TargetChosenReceiver.callbackReject("key 'social' missing in options");
        }
    }

    public void isPackageInstalled(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(ShareIntent.isPackageInstalled(str, RCTContext)));
        } catch (Exception e) {
            Log.e(NAME, e.getMessage());
            promise.reject(e.getMessage());
        }
    }

    public void isBase64File(String str, Promise promise) {
        try {
            String scheme = Uri.parse(str).getScheme();
            if (scheme == null || !scheme.equals("data")) {
                promise.resolve(false);
            } else {
                promise.resolve(true);
            }
        } catch (Exception e) {
            Log.e(NAME, e.getMessage());
            e.printStackTrace(System.out);
            promise.reject(e.getMessage());
        }
    }
}
