package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import cl.json.RNSharePackage;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.amplitude.reactnative.AmplitudeReactNativePackage;
import com.bitgo.randombytes.RandomBytesPackage;
import com.bleplx.BlePlxPackage;
import com.dooboolab.audiorecorderplayer.RNAudioRecorderPlayerPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.horcrux.svg.SvgPackage;
import com.learnium.RNDeviceInfo.RNDeviceInfo;
import com.lugg.RNCConfig.RNCConfigPackage;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.mrousavy.camera.react.CameraPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.onesignal.rnonesignalandroid.ReactNativeOneSignalPackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.picker.RNCPickerPackage;
import com.reactnativecommunity.slider.ReactSliderPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativegooglesignin.RNGoogleSigninPackage;
import com.reactnativeimageresizer.ImageResizerPackage;
import com.reactnativelauncharguments.LaunchArgumentsPackage;
import com.reactnativepagerview.PagerViewPackage;
import com.reactnativerate.RNRatePackage;
import com.revenuecat.purchases.react.RNPurchasesPackage;
import com.rnfs.RNFSPackage;
import com.rnmaps.maps.MapsPackage;
import com.swmansion.gesturehandler.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.wenkesj.voice.VoicePackage;
import com.zaguiini.RNPureJwt.RNPureJwtPackage;
import expo.modules.ExpoModulesPackage;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsPackage;
import java.util.ArrayList;
import java.util.Arrays;
import org.linusu.RNGetRandomValuesPackage;
import org.th317erd.react.DynamicFontsPackage;
import org.wonday.pdf.RNPDFPackage;

public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    public PackageList(ReactNativeHost reactNativeHost2) {
        this(reactNativeHost2, (MainPackageConfig) null);
    }

    public PackageList(Application application2) {
        this(application2, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost2;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application2;
        this.mConfig = mainPackageConfig;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        ReactNativeHost reactNativeHost2 = this.reactNativeHost;
        return reactNativeHost2 == null ? this.application : reactNativeHost2.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new ReactPackage[]{new MainReactPackage(this.mConfig), new VectorIconsPackage(), new AmplitudeReactNativePackage(), new ImageResizerPackage(), new AsyncStoragePackage(), new RNDateTimePickerPackage(), new NetInfoPackage(), new ReactSliderPackage(), new RNGoogleSigninPackage(), new RNCPickerPackage(), new VoicePackage(), new ExpoModulesPackage(), new LottiePackage(), new RNAudioRecorderPlayerPackage(), new BackgroundTimerPackage(), new BlePlxPackage(), new ReactNativeBlobUtilPackage(), new RNCConfigPackage(), new RNDeviceInfo(), new DynamicFontsPackage(), new ReactNativeExceptionHandlerPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new RNGetRandomValuesPackage(), new ReactNativeGoogleMobileAdsPackage(), new MapsPackage(), new ReactNativeOneSignalPackage(), new PagerViewPackage(), new RNPDFPackage(), new RNPurchasesPackage(), new RandomBytesPackage(), new RNRatePackage(), new ReanimatedPackage(), new SafeAreaContextPackage(), new RNScreensPackage(), new RNSharePackage(), new SvgPackage(), new CameraPackage(), new RNCWebViewPackage(), new LaunchArgumentsPackage(), new RNPureJwtPackage()}));
    }
}
