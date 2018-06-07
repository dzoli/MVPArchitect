package dmi.pmf.novica.mvparchitect.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmi.pmf.novica.mvparchitect.R;
import dmi.pmf.novica.mvparchitect.root.App;
import dmi.pmf.novica.mvparchitect.twitch.TwitchAPI;
import dmi.pmf.novica.mvparchitect.twitch.model.Top;
import dmi.pmf.novica.mvparchitect.twitch.model.Twitch;
import dmi.pmf.novica.mvparchitect.ui.games.TopGamesActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject LoginActivityMVP.Presenter presenter;

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_lastname)
    EditText etLastname;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        App.getComponent().inject(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser(); // get default user
    }

    @Override
    public String getFirstName() {
        return etUsername.getText().toString();
    }

    @Override
    public String getLastName() {
        return etLastname.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "User is not available.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Please input username and password.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String fname) {
        etUsername.setText(fname);
    }

    @Override
    public void setLastName(String lname) {
        etLastname.setText(lname);
    }

    @Override
    public void showTopGamesActivity() {
        Intent intent = new Intent(LoginActivity.this, TopGamesActivity.class);
        startActivity(intent);
        finish();
    }
}
