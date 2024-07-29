package expo.modules.av.player.datasource;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import expo.modules.av.ForwardingCookieHandler;
import java.util.Map;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

public class SharedCookiesDataSourceFactory implements DataSource.Factory {
    private final DataSource.Factory mDataSourceFactory;

    public SharedCookiesDataSourceFactory(Context context, String str, Map<String, Object> map, TransferListener transferListener) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(new JavaNetCookieJar(new ForwardingCookieHandler()));
        this.mDataSourceFactory = new DefaultDataSourceFactory(context, transferListener, (DataSource.Factory) new CustomHeadersOkHttpDataSourceFactory(builder.build(), str, map));
    }

    public DataSource createDataSource() {
        return this.mDataSourceFactory.createDataSource();
    }
}
