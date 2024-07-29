package com.onesignal.core.internal.application.impl;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.onesignal.common.threading.Waiter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/onesignal/core/internal/application/impl/ApplicationService$waitUntilSystemConditionsAvailable$2", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "onFragmentDetached", "", "fm", "Landroidx/fragment/app/FragmentManager;", "fragmentDetached", "Landroidx/fragment/app/Fragment;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationService.kt */
public final class ApplicationService$waitUntilSystemConditionsAvailable$2 extends FragmentManager.FragmentLifecycleCallbacks {
    final /* synthetic */ FragmentManager $manager;
    final /* synthetic */ Waiter $waiter;

    ApplicationService$waitUntilSystemConditionsAvailable$2(FragmentManager fragmentManager, Waiter waiter) {
        this.$manager = fragmentManager;
        this.$waiter = waiter;
    }

    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragmentDetached");
        super.onFragmentDetached(fragmentManager, fragment);
        if (fragment instanceof DialogFragment) {
            this.$manager.unregisterFragmentLifecycleCallbacks(this);
            this.$waiter.wake();
        }
    }
}
