package dmi.pmf.novica.mvparchitect.twitch;

import dmi.pmf.novica.mvparchitect.twitch.model.Twitch;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

public interface TwitchAPI {

    @Headers({
            "Client-ID: d8dzxx3c0rm02j6pl0whqjofexc7zh",
            "Accept: application/vnd.twitchtv.v5+json"
    })
    @GET("games/top")
    Call<Twitch> getTopGames();

}
