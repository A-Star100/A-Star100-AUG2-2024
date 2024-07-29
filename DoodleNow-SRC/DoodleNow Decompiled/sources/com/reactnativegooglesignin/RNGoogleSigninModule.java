package com.reactnativegooglesignin;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class RNGoogleSigninModule extends NativeGoogleSigninSpec {
    public static final String PLAY_SERVICES_NOT_AVAILABLE = "PLAY_SERVICES_NOT_AVAILABLE";
    public static final int RC_SIGN_IN = 9001;
    public static final int REQUEST_CODE_ADD_SCOPES = 53295;
    public static final int REQUEST_CODE_RECOVER_AUTH = 53294;
    private static final String SHOULD_RECOVER = "SHOULD_RECOVER";
    private GoogleSignInClient _apiClient;
    /* access modifiers changed from: private */
    public PendingAuthRecovery pendingAuthRecovery;
    /* access modifiers changed from: private */
    public final PromiseWrapper signInOrAddScopesPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
    private final PromiseWrapper silentSignInPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
    private final PromiseWrapper tokenClearingPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);
    /* access modifiers changed from: private */
    public final PromiseWrapper tokenRetrievalPromiseWrapper = new PromiseWrapper(NativeGoogleSigninSpec.NAME);

    public PromiseWrapper getTokenClearingPromiseWrapper() {
        return this.tokenClearingPromiseWrapper;
    }

    public PromiseWrapper getTokenRetrievalPromiseWrapper() {
        return this.tokenRetrievalPromiseWrapper;
    }

    public RNGoogleSigninModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(new RNGoogleSigninActivityEventListener());
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getTypedExportedConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("BUTTON_SIZE_ICON", 2);
        hashMap.put("BUTTON_SIZE_STANDARD", 0);
        hashMap.put("BUTTON_SIZE_WIDE", 1);
        hashMap.put("SIGN_IN_CANCELLED", String.valueOf(GoogleSignInStatusCodes.SIGN_IN_CANCELLED));
        hashMap.put("SIGN_IN_REQUIRED", String.valueOf(4));
        hashMap.put("SCOPES_ALREADY_GRANTED", "NEVER_HAPPENS_ON_ANDROID");
        hashMap.put("ONE_TAP_START_FAILED", "ONE_TAP_START_FAILED");
        hashMap.put("NO_SAVED_CREDENTIAL_FOUND", "NO_SAVED_CREDENTIAL_FOUND");
        hashMap.put("IN_PROGRESS", PromiseWrapper.ASYNC_OP_IN_PROGRESS);
        hashMap.put(PLAY_SERVICES_NOT_AVAILABLE, PLAY_SERVICES_NOT_AVAILABLE);
        return hashMap;
    }

    @ReactMethod
    public void playServicesAvailable(boolean z, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.w(NativeGoogleSigninSpec.NAME, "could not determine playServicesAvailable, activity is null");
            rejectWithNullActivity(promise);
            return;
        }
        GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(currentActivity);
        if (isGooglePlayServicesAvailable != 0) {
            if (z && instance.isUserResolvableError(isGooglePlayServicesAvailable)) {
                instance.getErrorDialog(currentActivity, isGooglePlayServicesAvailable, 2404).show();
            }
            promise.reject(PLAY_SERVICES_NOT_AVAILABLE, "Play services not available");
            return;
        }
        promise.resolve(true);
    }

    static void rejectWithNullActivity(Promise promise) {
        promise.reject(NativeGoogleSigninSpec.NAME, "activity is null");
    }

    @ReactMethod
    public void configure(ReadableMap readableMap, Promise promise) {
        this._apiClient = GoogleSignIn.getClient((Context) getReactApplicationContext(), Utils.getSignInOptions(Utils.createScopesArray(readableMap.hasKey("scopes") ? readableMap.getArray("scopes") : Arguments.createArray()), readableMap.hasKey("webClientId") ? readableMap.getString("webClientId") : null, readableMap.hasKey("offlineAccess") && readableMap.getBoolean("offlineAccess"), readableMap.hasKey("forceCodeForRefreshToken") && readableMap.getBoolean("forceCodeForRefreshToken"), readableMap.hasKey("accountName") ? readableMap.getString("accountName") : null, readableMap.hasKey("hostedDomain") ? readableMap.getString("hostedDomain") : null));
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void signInSilently(Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        this.silentSignInPromiseWrapper.setPromiseWithInProgressCheck(promise, "signInSilently");
        UiThreadUtil.runOnUiThread(new RNGoogleSigninModule$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$signInSilently$1() {
        Task<GoogleSignInAccount> silentSignIn = this._apiClient.silentSignIn();
        if (silentSignIn.isSuccessful()) {
            handleSignInTaskResult(silentSignIn, this.silentSignInPromiseWrapper);
        } else {
            silentSignIn.addOnCompleteListener(new RNGoogleSigninModule$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$signInSilently$0(Task task) {
        handleSignInTaskResult(task, this.silentSignInPromiseWrapper);
    }

    /* access modifiers changed from: private */
    public void handleSignInTaskResult(Task<GoogleSignInAccount> task, PromiseWrapper promiseWrapper) {
        try {
            GoogleSignInAccount result = task.getResult(ApiException.class);
            if (result == null) {
                promiseWrapper.reject("GoogleSignInAccount instance was null");
            } else {
                promiseWrapper.resolve(Utils.getUserProperties(result));
            }
        } catch (ApiException e) {
            promiseWrapper.reject((Exception) e);
        }
    }

    @ReactMethod
    public void signIn(ReadableMap readableMap, Promise promise) {
        if (this._apiClient == null) {
            rejectWithNullClientError(promise);
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            rejectWithNullActivity(promise);
            return;
        }
        this.signInOrAddScopesPromiseWrapper.setPromiseWithInProgressCheck(promise, "signIn");
        UiThreadUtil.runOnUiThread(new RNGoogleSigninModule$$ExternalSyntheticLambda0(this, currentActivity));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$signIn$2(Activity activity) {
        activity.startActivityForResult(this._apiClient.getSignInIntent(), RC_SIGN_IN);
    }

    @ReactMethod
    public void addScopes(ReadableMap readableMap, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            rejectWithNullActivity(promise);
            return;
        }
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            promise.resolve(false);
            return;
        }
        this.signInOrAddScopesPromiseWrapper.setPromiseWithInProgressCheck(promise, "addScopes");
        GoogleSignIn.requestPermissions(currentActivity, (int) REQUEST_CODE_ADD_SCOPES, lastSignedInAccount, Utils.createScopesArray(readableMap.getArray("scopes")));
    }

    private class RNGoogleSigninActivityEventListener extends BaseActivityEventListener {
        private RNGoogleSigninActivityEventListener() {
        }

        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i == 9001) {
                Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(intent);
                RNGoogleSigninModule rNGoogleSigninModule = RNGoogleSigninModule.this;
                rNGoogleSigninModule.handleSignInTaskResult(signedInAccountFromIntent, rNGoogleSigninModule.signInOrAddScopesPromiseWrapper);
            } else if (i == 53294) {
                if (i2 == -1) {
                    RNGoogleSigninModule.this.rerunFailedAuthTokenTask();
                } else {
                    RNGoogleSigninModule.this.tokenRetrievalPromiseWrapper.reject("Failed authentication recovery attempt, probably user-rejected.");
                }
            } else if (i != 53295) {
            } else {
                if (i2 == -1) {
                    RNGoogleSigninModule.this.signInOrAddScopesPromiseWrapper.resolve(true);
                } else {
                    RNGoogleSigninModule.this.signInOrAddScopesPromiseWrapper.reject("Failed to add scopes.");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void rerunFailedAuthTokenTask() {
        WritableMap userProperties = this.pendingAuthRecovery.getUserProperties();
        if (userProperties != null) {
            new AccessTokenRetrievalTask(this).execute(new WritableMap[]{userProperties, null});
            return;
        }
        this.tokenRetrievalPromiseWrapper.reject("rerunFailedAuthTokenTask: recovery failed");
    }

    @ReactMethod
    public void signOut(Promise promise) {
        GoogleSignInClient googleSignInClient = this._apiClient;
        if (googleSignInClient == null) {
            rejectWithNullClientError(promise);
        } else {
            googleSignInClient.signOut().addOnCompleteListener(new RNGoogleSigninModule$$ExternalSyntheticLambda3(this, promise));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handleSignOutOrRevokeAccessTask */
    public void lambda$signOut$3(Task<Void> task, Promise promise) {
        if (task.isSuccessful()) {
            promise.resolve((Object) null);
            return;
        }
        int exceptionCode = Utils.getExceptionCode(task);
        promise.reject(String.valueOf(exceptionCode), GoogleSignInStatusCodes.getStatusCodeString(exceptionCode));
    }

    @ReactMethod
    public void revokeAccess(Promise promise) {
        GoogleSignInClient googleSignInClient = this._apiClient;
        if (googleSignInClient == null) {
            rejectWithNullClientError(promise);
        } else {
            googleSignInClient.revokeAccess().addOnCompleteListener(new RNGoogleSigninModule$$ExternalSyntheticLambda1(this, promise));
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean hasPreviousSignIn() {
        return GoogleSignIn.getLastSignedInAccount(getReactApplicationContext()) != null;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getCurrentUser() {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            return null;
        }
        return Utils.getUserProperties(lastSignedInAccount);
    }

    @ReactMethod
    public void clearCachedAccessToken(String str, Promise promise) {
        this.tokenClearingPromiseWrapper.setPromiseWithInProgressCheck(promise, "clearCachedAccessToken");
        new TokenClearingTask(this).execute(new String[]{str});
    }

    @ReactMethod
    public void getTokens(Promise promise) {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getReactApplicationContext());
        if (lastSignedInAccount == null) {
            promise.reject("getTokens", "getTokens requires a user to be signed in");
            return;
        }
        this.tokenRetrievalPromiseWrapper.setPromiseWithInProgressCheck(promise, "getTokens");
        startTokenRetrievalTaskWithRecovery(lastSignedInAccount);
    }

    private void startTokenRetrievalTaskWithRecovery(GoogleSignInAccount googleSignInAccount) {
        WritableMap userProperties = Utils.getUserProperties(googleSignInAccount);
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean(SHOULD_RECOVER, true);
        new AccessTokenRetrievalTask(this).execute(new WritableMap[]{userProperties, createMap});
    }

    private static class AccessTokenRetrievalTask extends AsyncTask<WritableMap, Void, Void> {
        private final WeakReference<RNGoogleSigninModule> weakModuleRef;

        AccessTokenRetrievalTask(RNGoogleSigninModule rNGoogleSigninModule) {
            this.weakModuleRef = new WeakReference<>(rNGoogleSigninModule);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(WritableMap... writableMapArr) {
            WritableMap writableMap = writableMapArr[0];
            RNGoogleSigninModule rNGoogleSigninModule = (RNGoogleSigninModule) this.weakModuleRef.get();
            if (rNGoogleSigninModule == null) {
                return null;
            }
            try {
                insertAccessTokenIntoUserProperties(rNGoogleSigninModule, writableMap);
                rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().resolve(writableMap);
            } catch (Exception e) {
                handleException(rNGoogleSigninModule, e, writableMap, writableMapArr.length >= 2 ? writableMapArr[1] : null);
            }
            return null;
        }

        private void insertAccessTokenIntoUserProperties(RNGoogleSigninModule rNGoogleSigninModule, WritableMap writableMap) throws IOException, GoogleAuthException {
            writableMap.putString("accessToken", GoogleAuthUtil.getToken((Context) rNGoogleSigninModule.getReactApplicationContext(), new Account(writableMap.getMap("user").getString("email"), "com.google"), Utils.scopesToString(writableMap.getArray("scopes"))));
        }

        private void handleException(RNGoogleSigninModule rNGoogleSigninModule, Exception exc, WritableMap writableMap, WritableMap writableMap2) {
            if (!(exc instanceof UserRecoverableAuthException)) {
                rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().reject(exc);
            } else if (writableMap2 == null || !writableMap2.hasKey(RNGoogleSigninModule.SHOULD_RECOVER) || !writableMap2.getBoolean(RNGoogleSigninModule.SHOULD_RECOVER)) {
                rNGoogleSigninModule.getTokenRetrievalPromiseWrapper().reject(exc);
            } else {
                attemptRecovery(rNGoogleSigninModule, exc, writableMap);
            }
        }

        private void attemptRecovery(RNGoogleSigninModule rNGoogleSigninModule, Exception exc, WritableMap writableMap) {
            Activity access$100 = rNGoogleSigninModule.getCurrentActivity();
            if (access$100 == null) {
                rNGoogleSigninModule.pendingAuthRecovery = null;
                PromiseWrapper tokenRetrievalPromiseWrapper = rNGoogleSigninModule.getTokenRetrievalPromiseWrapper();
                tokenRetrievalPromiseWrapper.reject("Cannot attempt recovery auth because app is not in foreground. " + exc.getLocalizedMessage());
                return;
            }
            rNGoogleSigninModule.pendingAuthRecovery = new PendingAuthRecovery(writableMap);
            access$100.startActivityForResult(((UserRecoverableAuthException) exc).getIntent(), RNGoogleSigninModule.REQUEST_CODE_RECOVER_AUTH);
        }
    }

    private static class TokenClearingTask extends AsyncTask<String, Void, Void> {
        private final WeakReference<RNGoogleSigninModule> weakModuleRef;

        TokenClearingTask(RNGoogleSigninModule rNGoogleSigninModule) {
            this.weakModuleRef = new WeakReference<>(rNGoogleSigninModule);
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... strArr) {
            RNGoogleSigninModule rNGoogleSigninModule = (RNGoogleSigninModule) this.weakModuleRef.get();
            if (rNGoogleSigninModule == null) {
                return null;
            }
            PromiseWrapper tokenClearingPromiseWrapper = rNGoogleSigninModule.getTokenClearingPromiseWrapper();
            try {
                GoogleAuthUtil.clearToken(rNGoogleSigninModule.getReactApplicationContext(), strArr[0]);
                tokenClearingPromiseWrapper.resolve((Object) null);
            } catch (Exception e) {
                tokenClearingPromiseWrapper.reject(e);
            }
            return null;
        }
    }

    private void rejectWithNullClientError(Promise promise) {
        promise.reject(NativeGoogleSigninSpec.NAME, "apiClient is null - call configure() first");
    }
}
