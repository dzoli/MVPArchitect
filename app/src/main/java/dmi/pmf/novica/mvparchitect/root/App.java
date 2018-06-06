package dmi.pmf.novica.mvparchitect.root;

import android.app.Activity;
import android.app.Application;

import dmi.pmf.novica.mvparchitect.ui.games.DaggerGamesComponent;
import dmi.pmf.novica.mvparchitect.ui.games.GamesComponent;
import dmi.pmf.novica.mvparchitect.ui.games.GamesModule;
import dmi.pmf.novica.mvparchitect.ui.login.LoginModule;
import dmi.pmf.novica.mvparchitect.twitch.TwitchModule;

public class App extends Application {

    private static ApplicationComponent component;

    private static GamesComponent gamesComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        component = buildAppComponent();
        gamesComponent = buildGameComponent();
    }

    private GamesComponent buildGameComponent() {
        return DaggerGamesComponent.builder()
                .activityModule(new ActivityModule(getApplicationContext()))
                .gamesModule(new GamesModule())
                .twitchModule(new TwitchModule())
                .build();
    }

    private ApplicationComponent buildAppComponent() {
        return DaggerApplicationComponent.builder()
                    .appModule(new AppModule(this))
                    .loginModule(new LoginModule())
                    .build();
    }

    public static GamesComponent getGamesComponent() {
        return gamesComponent;
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
