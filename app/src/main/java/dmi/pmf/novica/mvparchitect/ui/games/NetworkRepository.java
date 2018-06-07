package dmi.pmf.novica.mvparchitect.ui.games;

import dmi.pmf.novica.mvparchitect.twitch.TwitchAPI;
import dmi.pmf.novica.mvparchitect.twitch.model.Twitch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepository implements GamesRepository {

    private TwitchAPI twitchAPI;

    public NetworkRepository(TwitchAPI twitchAPI) {
        this.twitchAPI = twitchAPI;
    }

    @Override
    public void getGamesFromAPI(final GamesCallback gamesCallback) {
        twitchAPI.getTopGames().enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                gamesCallback.onSuccess(response.body().getTop());
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                gamesCallback.onError(t);
                t.printStackTrace();
            }
        });
    }
}
