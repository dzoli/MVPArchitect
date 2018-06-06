package dmi.pmf.novica.mvparchitect.ui.login;

public interface LoginRepository {

    User getUser();

    void saveUser(String fname, String lname);

}
