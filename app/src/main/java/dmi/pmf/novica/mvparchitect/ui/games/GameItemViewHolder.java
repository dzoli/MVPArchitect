package dmi.pmf.novica.mvparchitect.ui.games;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmi.pmf.novica.mvparchitect.R;

public class GameItemViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.tv_game_name)
    TextView tvGameName;

    @BindView(R.id.iv_game)
    ImageView ivGame;

    public GameItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setGameName(String gameName){
        tvGameName.setText(gameName);
    }

    public void setGameImage(String imageUrl){
        Picasso.get().load(imageUrl).into(ivGame);
    }

}
