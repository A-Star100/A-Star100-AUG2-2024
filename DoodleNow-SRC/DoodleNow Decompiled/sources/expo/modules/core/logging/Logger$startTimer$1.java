package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"expo/modules/core/logging/Logger$startTimer$1", "Lexpo/modules/core/logging/LoggerTimer;", "stop", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Logger.kt */
public final class Logger$startTimer$1 implements LoggerTimer {
    final /* synthetic */ Function1<Long, String> $logFormatter;
    final /* synthetic */ long $start;
    final /* synthetic */ Logger this$0;

    Logger$startTimer$1(Logger logger, Function1<? super Long, String> function1, long j) {
        this.this$0 = logger;
        this.$logFormatter = function1;
        this.$start = j;
    }

    public void stop() {
        Logger.log$default(this.this$0, LogType.Timer, this.$logFormatter.invoke(Long.valueOf(System.currentTimeMillis() - this.$start)), (Throwable) null, 4, (Object) null);
    }
}
