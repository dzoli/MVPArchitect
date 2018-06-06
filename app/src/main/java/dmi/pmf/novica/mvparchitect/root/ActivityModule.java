package dmi.pmf.novica.mvparchitect.root;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }


    @Named("activity_context") // dagger don't know which context provide when (app or activity)
    @Provides
    @ActivityScope
    public Context context() {
        return context;
    }

}
