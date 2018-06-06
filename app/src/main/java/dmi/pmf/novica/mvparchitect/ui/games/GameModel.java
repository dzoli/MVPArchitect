package dmi.pmf.novica.mvparchitect.ui.games;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import dmi.pmf.novica.mvparchitect.twitch.model.Top;

public class GameModel implements GamesActivityMVP.Model {

    private GamesRepository gamesRepository;

    public GameModel(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public void getGamesFromAPI(GamesCallback gamesCallback) {
         gamesRepository.getGamesFromAPI(gamesCallback);
    }
}
