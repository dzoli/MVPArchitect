package dmi.pmf.novica.mvparchitect.ui.games;

import android.support.annotation.NonNull;

import java.util.List;

import dmi.pmf.novica.mvparchitect.twitch.model.Top;

public class GamePresenter implements GamesActivityMVP.Presenter, GamesCallback{

    GamesActivityMVP.View view;
    GamesActivityMVP.Model model;

    public GamePresenter(GamesActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void getAllData() {
        if (view != null) {
            model.getGamesFromAPI(this);
        }
    }

    @Override
    public void setView(GamesActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void onSuccess(@NonNull List<Top> gamesList) {
        view.fillAdapter(gamesList);
    }

    @Override
    public void onError(@NonNull Throwable throwable) {
        view.showLoadErrorMessage();
    }
}
