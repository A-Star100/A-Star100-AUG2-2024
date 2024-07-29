package com.reactnativerate;

import android.app.Activity;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;

@ReactModule(name = "RNRate")
public class RNRateModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RNRate";
    private final ReactApplicationContext reactContext;

    public String getName() {
        return NAME;
    }

    public RNRateModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void rate(ReadableMap readableMap, final Callback callback) {
        final ReviewManager create = ReviewManagerFactory.create(this.reactContext);
        create.requestReviewFlow().addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
            public void onComplete(final Task<ReviewInfo> task) {
                if (task.isSuccessful()) {
                    ReviewInfo result = task.getResult();
                    Activity access$000 = RNRateModule.this.getCurrentActivity();
                    if (access$000 == null) {
                        callback.invoke(false, "getCurrentActivity() unsuccessful");
                        return;
                    }
                    create.launchReviewFlow(access$000, result).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                callback.invoke(true);
                                return;
                            }
                            callback.invoke(false, "launchReviewFlow() unsuccessful");
                        }
                    });
                    return;
                }
                callback.invoke(false, "requestReviewFlow() unsuccessful");
            }
        });
    }
}
