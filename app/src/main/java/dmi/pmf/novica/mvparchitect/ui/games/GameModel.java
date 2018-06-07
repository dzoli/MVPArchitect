package dmi.pmf.novica.mvparchitect.ui.games;

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
