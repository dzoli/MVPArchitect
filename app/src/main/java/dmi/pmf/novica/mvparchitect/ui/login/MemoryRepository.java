package dmi.pmf.novica.mvparchitect.ui.login;

public class MemoryRepository implements LoginRepository{

    private User user;

    @Override
    public User getUser() {

        if (user == null) {
            User user = new User("Novica", "Bjelica");
            user.setId(0);
            return user;
        }else {
            return user;
        }
    }

    @Override
    public void saveUser(String fname, String lname) {
        if (user == null) {
            user = getUser();
        }else{
            user = new User(fname, lname);
        }
    }
}
