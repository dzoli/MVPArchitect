package dmi.pmf.novica.mvparchitect.ui.games;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmi.pmf.novica.mvparchitect.R;
import dmi.pmf.novica.mvparchitect.root.ActivityModule;
import dmi.pmf.novica.mvparchitect.root.App;
import dmi.pmf.novica.mvparchitect.twitch.TwitchAPI;
import dmi.pmf.novica.mvparchitect.twitch.TwitchModule;
import dmi.pmf.novica.mvparchitect.twitch.model.Top;
import dmi.pmf.novica.mvparchitect.twitch.model.Twitch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopGamesActivity extends AppCompatActivity implements GamesActivityMVP.View{

    @BindView(R.id.rv_games)
    RecyclerView rvGames;

    @Inject GamesActivityMVP.Presenter presenter;

    @Inject GamesAdapter gamesAdapter;
    @Inject LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_games);
        ButterKnife.bind(this);
        App.getGamesComponent().inject(this);

        rvGames.setAdapter(gamesAdapter);
        rvGames.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getAllData();
    }

    @Override
    public void showLoadErrorMessage() {
        Toast.makeText(this, "Error while loading data.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fillAdapter(List<Top> games) {
        gamesAdapter.setGameList(games);
    }
}
