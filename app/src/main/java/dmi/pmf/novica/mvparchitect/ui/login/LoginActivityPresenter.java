package dmi.pmf.novica.mvparchitect.ui.login;

import android.support.annotation.NonNull;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @NonNull
    private LoginActivityMVP.View view; //inject with method
    private LoginActivityMVP.Model model; //inject with dagger

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void loginButtonClicked() { // tell view what to do when button is clicked
        if (view != null) {
            if (view.getFirstName().trim().equals("") ||
                    view.getLastName().trim().equals(""))
                view.showInputError();
            else{
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
                view.showTopGamesActivity();
            }
        }
    }

    @Override
    public void getCurrentUser() { // tell view to show current user
        User user = model.getUser();

        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        }else {
            if (view != null) {
                view.setFirstName(user.getFname());
                view.setLastName(user.getLname());
            }
        }
//        if (user != null) {
//            if (view != null) {
//                view.setFirstName(user.getFname());
//                view.setLastName(user.getLname());
//            }
//        }
    }
}
