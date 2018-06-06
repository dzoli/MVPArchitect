package dmi.pmf.novica.mvparchitect.ui.login;

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String fname, String lname) {
        repository.saveUser(fname, lname);
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
