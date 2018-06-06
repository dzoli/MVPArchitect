package dmi.pmf.novica.mvparchitect.ui.games;

import java.util.List;

import dmi.pmf.novica.mvparchitect.twitch.model.Top;

public interface GamesActivityMVP {

    interface View {
        void showLoadErrorMessage();

        void fillAdapter(List<Top> games);
    }

    interface Presenter {
        void setView(GamesActivityMVP.View view);

        void getAllData();
    }

    interface Model {
        void getGamesFromAPI(GamesCallback gamesCallback);
    }

}
