package dmi.pmf.novica.mvparchitect.root;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application application;

    public AppModule(@NonNull Application application){
        this.application = application;
    }

    @Named("app_context")
    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }

}
