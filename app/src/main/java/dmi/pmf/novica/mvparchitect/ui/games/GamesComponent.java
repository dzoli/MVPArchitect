package dmi.pmf.novica.mvparchitect.ui.games;

import dagger.Component;
import dmi.pmf.novica.mvparchitect.root.ActivityModule;
import dmi.pmf.novica.mvparchitect.root.ActivityScope;
import dmi.pmf.novica.mvparchitect.twitch.TwitchModule;

@Component(modules = {ActivityModule.class, GamesModule.class, TwitchModule.class})
@ActivityScope
public interface GamesComponent {

    void inject(TopGamesActivity target);

}
