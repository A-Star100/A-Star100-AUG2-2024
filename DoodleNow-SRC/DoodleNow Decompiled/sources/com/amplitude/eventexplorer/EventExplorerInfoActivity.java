package com.amplitude.eventexplorer;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amplitude.R;
import com.amplitude.api.Amplitude;

public class EventExplorerInfoActivity extends Activity {
    private ImageView closeImageView;
    private Button deviceIdCopyButton;
    private TextView deviceIdTextView;
    private Button userIdCopyButton;
    private TextView userIdTextView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        String str2;
        super.onCreate(bundle);
        setContentView(R.layout.amp_activity_eventexplorer_info);
        ImageView imageView = (ImageView) findViewById(R.id.amp_eeInfo_iv_close);
        this.closeImageView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EventExplorerInfoActivity.this.onBackPressed();
            }
        });
        this.deviceIdTextView = (TextView) findViewById(R.id.amp_eeInfo_tv_deviceId);
        this.userIdTextView = (TextView) findViewById(R.id.amp_eeInfo_tv_userId);
        String string = getIntent().getExtras().getString("instanceName");
        final String deviceId = Amplitude.getInstance(string).getDeviceId();
        final String userId = Amplitude.getInstance(string).getUserId();
        TextView textView = this.deviceIdTextView;
        if (deviceId != null) {
            str = deviceId;
        } else {
            str = getString(R.string.amp_label_not_avail);
        }
        textView.setText(str);
        TextView textView2 = this.userIdTextView;
        if (userId != null) {
            str2 = userId;
        } else {
            str2 = getString(R.string.amp_label_not_avail);
        }
        textView2.setText(str2);
        Button button = (Button) findViewById(R.id.amp_eeInfo_btn_copyDeviceId);
        this.deviceIdCopyButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EventExplorerInfoActivity.this.copyText(view.getContext(), deviceId);
            }
        });
        Button button2 = (Button) findViewById(R.id.amp_eeInfo_btn_copyUserId);
        this.userIdCopyButton = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EventExplorerInfoActivity.this.copyText(view.getContext(), userId);
            }
        });
    }

    /* access modifiers changed from: private */
    public void copyText(Context context, String str) {
        if (str != null) {
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copied text", str));
            Toast.makeText(context, getString(R.string.amp_label_copied), 0).show();
        }
    }
}
