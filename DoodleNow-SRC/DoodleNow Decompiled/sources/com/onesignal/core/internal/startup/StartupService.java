package com.onesignal.core.internal.startup;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/core/internal/startup/StartupService;", "", "_bootstrapServices", "", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "_startableServices", "Lcom/onesignal/core/internal/startup/IStartableService;", "(Ljava/util/List;Ljava/util/List;)V", "bootstrap", "", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StartupService.kt */
public final class StartupService {
    private final List<IBootstrapService> _bootstrapServices;
    private final List<IStartableService> _startableServices;

    public StartupService(List<? extends IBootstrapService> list, List<? extends IStartableService> list2) {
        Intrinsics.checkNotNullParameter(list, "_bootstrapServices");
        Intrinsics.checkNotNullParameter(list2, "_startableServices");
        this._bootstrapServices = list;
        this._startableServices = list2;
    }

    public final void bootstrap() {
        for (IBootstrapService bootstrap : this._bootstrapServices) {
            bootstrap.bootstrap();
        }
    }

    public final void start() {
        for (IStartableService start : this._startableServices) {
            start.start();
        }
    }
}
