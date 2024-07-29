package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import com.google.android.gms.internal.play_billing.zzb;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public class ProxyBillingActivity extends ComponentActivity {
    static final String KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER = "alternative_billing_only_dialog_result_receiver";
    static final String KEY_IN_APP_MESSAGE_RESULT_RECEIVER = "in_app_message_result_receiver";
    static final String KEY_PRICE_CHANGE_RESULT_RECEIVER = "result_receiver";
    private static final String KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED = "send_cancelled_broadcast_if_finished";
    private static final int REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW = 110;
    private static final int REQUEST_CODE_IN_APP_MESSAGE_FLOW = 101;
    private static final int REQUEST_CODE_LAUNCH_ACTIVITY = 100;
    private static final String TAG = "ProxyBillingActivity";
    private ActivityResultLauncher<IntentSenderRequest> alternativeBillingOnlyDialogLauncher;
    private ResultReceiver alternativeBillingOnlyDialogResultReceiver;
    private ResultReceiver inAppMessageResultReceiver;
    private boolean isFlowFromFirstPartyClient;
    private ResultReceiver priceChangeResultReceiver;
    private boolean sendCancelledBroadcastIfFinished;

    private Intent makeAlternativeBillingIntent(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent makePurchasesUpdatedIntent() {
        getApplicationContext().getPackageName();
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, android.content.Intent r10) {
        /*
            r7 = this;
            super.onActivityResult(r8, r9, r10)
            r0 = 100
            r1 = 0
            r2 = 0
            r3 = 110(0x6e, float:1.54E-43)
            java.lang.String r4 = "ProxyBillingActivity"
            if (r8 == r0) goto L_0x0040
            if (r8 != r3) goto L_0x0010
            goto L_0x0040
        L_0x0010:
            r9 = 101(0x65, float:1.42E-43)
            if (r8 != r9) goto L_0x0028
            int r8 = com.google.android.gms.internal.play_billing.zzb.zza(r10, r4)
            android.os.ResultReceiver r9 = r7.inAppMessageResultReceiver
            if (r9 == 0) goto L_0x00ec
            if (r10 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            android.os.Bundle r1 = r10.getExtras()
        L_0x0023:
            r9.send(r8, r1)
            goto L_0x00ec
        L_0x0028:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Got onActivityResult with wrong requestCode: "
            r9.<init>(r10)
            r9.append(r8)
            java.lang.String r8 = "; skipping..."
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r8)
            goto L_0x00ec
        L_0x0040:
            int r0 = com.google.android.gms.internal.play_billing.zzb.zzc(r10, r4)
            r5 = -1
            if (r9 != r5) goto L_0x004d
            if (r0 == 0) goto L_0x004b
            r9 = r5
            goto L_0x004d
        L_0x004b:
            r0 = r2
            goto L_0x0066
        L_0x004d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Activity finished with resultCode "
            r5.<init>(r6)
            r5.append(r9)
            java.lang.String r9 = " and billing's responseCode: "
            r5.append(r9)
            r5.append(r0)
            java.lang.String r9 = r5.toString()
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r9)
        L_0x0066:
            android.os.ResultReceiver r9 = r7.priceChangeResultReceiver
            if (r9 == 0) goto L_0x0076
            if (r10 != 0) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            android.os.Bundle r1 = r10.getExtras()
        L_0x0071:
            r9.send(r0, r1)
            goto L_0x00ec
        L_0x0076:
            if (r10 == 0) goto L_0x00dd
            android.os.Bundle r9 = r10.getExtras()
            java.lang.String r0 = "LAUNCH_BILLING_FLOW"
            java.lang.String r1 = "INTENT_SOURCE"
            if (r9 == 0) goto L_0x00a5
            android.os.Bundle r9 = r10.getExtras()
            java.lang.String r4 = "ALTERNATIVE_BILLING_USER_CHOICE_DATA"
            java.lang.String r9 = r9.getString(r4)
            if (r9 == 0) goto L_0x0096
            android.content.Intent r9 = r7.makeAlternativeBillingIntent(r9)
            r9.putExtra(r1, r0)
            goto L_0x00e1
        L_0x0096:
            android.content.Intent r9 = r7.makePurchasesUpdatedIntent()
            android.os.Bundle r10 = r10.getExtras()
            r9.putExtras(r10)
            r9.putExtra(r1, r0)
            goto L_0x00e1
        L_0x00a5:
            android.content.Intent r9 = r7.makePurchasesUpdatedIntent()
            java.lang.String r10 = "Got null bundle!"
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r10)
            java.lang.String r10 = "RESPONSE_CODE"
            r4 = 6
            r9.putExtra(r10, r4)
            java.lang.String r10 = "DEBUG_MESSAGE"
            java.lang.String r5 = "An internal error occurred."
            r9.putExtra(r10, r5)
            com.android.billingclient.api.BillingResult$Builder r10 = com.android.billingclient.api.BillingResult.newBuilder()
            r10.setResponseCode(r4)
            r10.setDebugMessage(r5)
            com.android.billingclient.api.BillingResult r10 = r10.build()
            r4 = 22
            r5 = 2
            com.google.android.gms.internal.play_billing.zzhy r10 = com.android.billingclient.api.zzbh.zza(r4, r5, r10)
            byte[] r10 = r10.zzc()
            java.lang.String r4 = "FAILURE_LOGGING_PAYLOAD"
            r9.putExtra(r4, r10)
            r9.putExtra(r1, r0)
            goto L_0x00e1
        L_0x00dd:
            android.content.Intent r9 = r7.makePurchasesUpdatedIntent()
        L_0x00e1:
            if (r8 != r3) goto L_0x00e9
            java.lang.String r8 = "IS_FIRST_PARTY_PURCHASE"
            r10 = 1
            r9.putExtra(r8, r10)
        L_0x00e9:
            r7.sendBroadcast(r9)
        L_0x00ec:
            r7.sendCancelledBroadcastIfFinished = r2
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: package-private */
    public void onAlternativeBillingOnlyDialogResult(ActivityResult activityResult) {
        Bundle bundle;
        Intent data = activityResult.getData();
        int zzc = zzb.zzc(data, TAG);
        ResultReceiver resultReceiver = this.alternativeBillingOnlyDialogResultReceiver;
        if (resultReceiver != null) {
            if (data == null) {
                bundle = null;
            } else {
                bundle = data.getExtras();
            }
            resultReceiver.send(zzc, bundle);
        }
        if (!(activityResult.getResultCode() == -1 && zzc == 0)) {
            int resultCode = activityResult.getResultCode();
            zzb.zzk(TAG, "Alternative billing only dialog finished with resultCode " + resultCode + " and billing's responseCode: " + zzc);
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        PendingIntent pendingIntent;
        int i2;
        super.onCreate(bundle);
        this.alternativeBillingOnlyDialogLauncher = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new zzcd(this));
        if (bundle == null) {
            zzb.zzj(TAG, "Launching Play Store billing flow");
            if (getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                this.alternativeBillingOnlyDialogResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER);
                this.alternativeBillingOnlyDialogLauncher.launch(new IntentSenderRequest.Builder((PendingIntent) getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")).build());
                return;
            }
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
                if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    this.isFlowFromFirstPartyClient = true;
                    i2 = REQUEST_CODE_FIRST_PARTY_PURCHASE_FLOW;
                    i = i2;
                    this.sendCancelledBroadcastIfFinished = true;
                    startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
                }
            } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.priceChangeResultReceiver = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.inAppMessageResultReceiver = (ResultReceiver) getIntent().getParcelableExtra(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
                i2 = 101;
                i = i2;
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
            } else {
                i = 100;
                pendingIntent = null;
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
            }
            i = 100;
            try {
                this.sendCancelledBroadcastIfFinished = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e) {
                zzb.zzl(TAG, "Got exception while trying to start a purchase flow.", e);
                ResultReceiver resultReceiver = this.priceChangeResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(6, (Bundle) null);
                } else {
                    ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(0, (Bundle) null);
                    } else {
                        Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
                        if (this.isFlowFromFirstPartyClient) {
                            makePurchasesUpdatedIntent.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 6);
                        makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        sendBroadcast(makePurchasesUpdatedIntent);
                    }
                }
                this.sendCancelledBroadcastIfFinished = false;
                finish();
            }
        } else {
            zzb.zzj(TAG, "Launching Play Store billing flow from savedInstanceState");
            this.sendCancelledBroadcastIfFinished = bundle.getBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, false);
            if (bundle.containsKey("result_receiver")) {
                this.priceChangeResultReceiver = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey(KEY_IN_APP_MESSAGE_RESULT_RECEIVER)) {
                this.inAppMessageResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER);
            } else if (bundle.containsKey(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER)) {
                this.alternativeBillingOnlyDialogResultReceiver = (ResultReceiver) bundle.getParcelable(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER);
            }
            this.isFlowFromFirstPartyClient = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.sendCancelledBroadcastIfFinished) {
            Intent makePurchasesUpdatedIntent = makePurchasesUpdatedIntent();
            makePurchasesUpdatedIntent.putExtra("RESPONSE_CODE", 1);
            makePurchasesUpdatedIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(makePurchasesUpdatedIntent);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ResultReceiver resultReceiver = this.priceChangeResultReceiver;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.inAppMessageResultReceiver;
        if (resultReceiver2 != null) {
            bundle.putParcelable(KEY_IN_APP_MESSAGE_RESULT_RECEIVER, resultReceiver2);
        }
        ResultReceiver resultReceiver3 = this.alternativeBillingOnlyDialogResultReceiver;
        if (resultReceiver3 != null) {
            bundle.putParcelable(KEY_ALTERNATIVE_BILLING_ONLY_DIALOG_RESULT_RECEIVER, resultReceiver3);
        }
        bundle.putBoolean(KEY_SEND_CANCELLED_BROADCAST_IF_FINISHED, this.sendCancelledBroadcastIfFinished);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.isFlowFromFirstPartyClient);
    }
}
