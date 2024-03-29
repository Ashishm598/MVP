package application.builder;

import api.API;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiServiceModule {


    @AppScope
    @Provides
    API provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJava2CallAdapterFactory rxAdapter) {
        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(API.BASE_URL)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxAdapter)
                .build();

        return retrofit.create(API.class);
    }
}
