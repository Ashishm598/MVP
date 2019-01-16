package application.builder;


import android.content.Context;


import api.API;
import dagger.Component;


@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, ApiServiceModule.class})
public interface AppComponent {

    API restAPI();

    Context context();

}
