package dmi.pmf.novica.mvparchitect.ui.games;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dmi.pmf.novica.mvparchitect.R;
import dmi.pmf.novica.mvparchitect.twitch.model.Top;

public class GamesAdapter extends RecyclerView.Adapter<GameItemViewHolder> {

    private List<Top> gameList = new ArrayList<>();

    @NonNull
    @Override
    public GameItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);

        return new GameItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GameItemViewHolder holder, int position) {
        Top top = gameList.get(position);
        holder.setGameName(top.getGame().getName());
        holder.setGameImage(top.getGame().getBox().getLarge());
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public void setGameList(List<Top> gameList) {
        this.gameList = gameList;
        notifyDataSetChanged();
    }
}
