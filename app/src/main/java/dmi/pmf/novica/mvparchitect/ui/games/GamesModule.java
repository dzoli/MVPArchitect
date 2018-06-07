package dmi.pmf.novica.mvparchitect.ui.games;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dmi.pmf.novica.mvparchitect.root.ActivityScope;
import dmi.pmf.novica.mvparchitect.twitch.TwitchAPI;

@Module
public class GamesModule {

    @Provides
    @ActivityScope
    public LinearLayoutManager provideLinearLayoutManager(@Named("activity_context") Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    @ActivityScope
    public GamesAdapter provideGamesAdapter() {
        return new GamesAdapter();
    }

    @Provides
    @ActivityScope
    public GamesRepository provideNetworkRepository(TwitchAPI twitchAPI) {
        return new NetworkRepository(twitchAPI); // twitch is obtained from TwitchModule
    }

    @Provides
    @ActivityScope
    public GamesActivityMVP.Model provideModel(GamesRepository gamesRepository) {
        return new GameModel(gamesRepository);
    }

    @Provides
    @ActivityScope
    public GamesActivityMVP.Presenter providePresenter(GamesActivityMVP.Model model) {
        return new GamePresenter(model);
    }

}
