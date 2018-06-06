package dmi.pmf.novica.mvparchitect.ui.login;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    @Singleton
    public LoginActivityMVP.Presenter providePresenter(LoginActivityMVP.Model model) {
        return new LoginActivityPresenter(model);
    }

    @Provides
    @Singleton
    public LoginActivityMVP.Model provideModel(LoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    @Singleton
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }

}
