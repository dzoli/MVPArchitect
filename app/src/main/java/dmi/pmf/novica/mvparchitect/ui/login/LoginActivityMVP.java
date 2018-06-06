package dmi.pmf.novica.mvparchitect.ui.login;

public interface LoginActivityMVP {

    interface View {
        String getFirstName();
        String getLastName();

        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();

        void setFirstName(String fname);
        void setLastName(String lname);

        void showTopGamesActivity();
    }

    interface Presenter {
        void setView(LoginActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }

    interface Model {
        void createUser(String fname, String lname);

        User getUser();
    }

}
