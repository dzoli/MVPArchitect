package dmi.pmf.novica.mvparchitect.ui.games;

import java.util.List;

import dmi.pmf.novica.mvparchitect.twitch.model.Top;

public interface GamesRepository {

    void getGamesFromAPI(GamesCallback gamesCallback);

}
