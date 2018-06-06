package dmi.pmf.novica.mvparchitect.ui.games;

import android.support.annotation.NonNull;

import java.util.List;

import dmi.pmf.novica.mvparchitect.twitch.model.Top;

public interface GamesCallback {

    void onSuccess(@NonNull List<Top> gamesList);

    void onError(@NonNull Throwable throwable);

}
