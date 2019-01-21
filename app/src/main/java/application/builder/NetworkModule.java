package application.builder;

import android.content.Context;

import com.google.gson.GsonBuilder;
import com.twittersearch.ashish.twittersearch.BuildConfig;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import utils.AutoValueGsonFactory;
import utils.Util;
import utils.oauth1.Constants;
import utils.oauth1.Oauth1SigningInterceptor;

/**
 * Created by johns on 9/28/2017.
 */

@Module
public class NetworkModule {

    private static final int HTTP_READ_TIMEOUT = 25;
    private static final int HTTP_WRITE_TIMEOUT = 25;
    private static final int HTTP_CONNECT_TIMEOUT = 25;


    @AppScope
    @Provides
    OkHttpClient provideHttpClient(Oauth1SigningInterceptor OauthIntercepter, HttpLoggingInterceptor logger, Cache cache) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(logger);
        }

        builder.addInterceptor(OauthIntercepter);
        builder.cache(cache);
        builder.readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    @AppScope
    @Provides
    Oauth1SigningInterceptor provideOauthSigningInterceptor() {
        return new Oauth1SigningInterceptor.Builder()
                .consumerKey(Constants.oauth_consumer_key)
                .consumerSecret(Constants.oauth_consumer_secret)
                .accessToken(Constants.oauth_token)
                .accessSecret(Constants.oauth_token_secret)
                .random(Util.getRandom())
                .clock(Util.getCurrentTimeStamp())
                .build();

    }


    @AppScope
    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @AppScope
    @Provides
    Cache provideCache(File file) {
        return new Cache(file, 10 * 1024 * 1024);
    }

    @AppScope
    @Provides
    File provideCacheFile(Context context) {
        return context.getFilesDir();
    }

    @AppScope
    @Provides
    RxJava2CallAdapterFactory provideRxAdapter() {
        return RxJava2CallAdapterFactory.create();
    }


    @Provides
    GsonConverterFactory provideGsonClient() {
        return GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(AutoValueGsonFactory.create()).create());
    }
}
