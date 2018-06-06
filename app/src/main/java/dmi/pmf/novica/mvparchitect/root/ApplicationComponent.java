package dmi.pmf.novica.mvparchitect.root;

import javax.inject.Singleton;

import dagger.Component;
import dmi.pmf.novica.mvparchitect.ui.login.LoginActivity;
import dmi.pmf.novica.mvparchitect.ui.login.LoginModule;
import dmi.pmf.novica.mvparchitect.twitch.TwitchModule;

@Component(modules = {AppModule.class, LoginModule.class})
@Singleton
public interface ApplicationComponent {

    // where to do injection given from modules
    void inject(LoginActivity loginActivity);

}
