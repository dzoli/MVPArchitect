package dmi.pmf.novica.mvparchitect;


import org.junit.Before;
import org.junit.Test;

import dmi.pmf.novica.mvparchitect.ui.login.LoginActivityMVP;
import dmi.pmf.novica.mvparchitect.ui.login.LoginActivityPresenter;
import dmi.pmf.novica.mvparchitect.ui.login.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockkLoginView;

    LoginActivityPresenter presenterImpl;
    User user;

    // before methods clean all

    // this method will be run for every test
    // so if we have 4 tests in a file
    // it will be run 4 times once before each

    // we use mock interfaces for View and Model
    // it is easier to mock interfaces with mockito

    // but we will test Presenter interactions it this file
    // this is why we use concrete impl for Presenter rather than interface
    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class); // this is a mock object we can tell when to do things!
        user = new User("Fox","Mulder");

        // whenever our code calls the getUser() method from the mockito repository
        // it will return user we created
//        when(mockLoginModel.getUser()).thenReturn(user); // define how mockLoginModel will behave

        mockkLoginView = mock(LoginActivityMVP.View.class);

        presenterImpl = new LoginActivityPresenter(mockLoginModel); // concrete implementation

        presenterImpl.setView(mockkLoginView);
    }

    // presenter.getCurrentUser()
    @Test
    public void noInteractionWithView(){
        presenterImpl.setView(null);

        presenterImpl.getCurrentUser();

        // checks that when the presenter.getCurrentUser() method is called
        // if view is null then there is no interactions with view
        verifyZeroInteractions(mockkLoginView);
    }

    // presenter.getCurrentUser()
    @Test
    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent(){

        when(mockLoginModel.getUser()).thenReturn(user); // user is set in setup method

        presenterImpl.getCurrentUser();

        // verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        // verify the view interactions
        verify(mockkLoginView, times(1)).setFirstName("Fox");
        verify(mockkLoginView, times(1)).setLastName("Mulder");
        verify(mockkLoginView, never()).showUserNotAvailable();
    }

    // presenter.getCurrentUser()
    @Test
    public void shouldShowErrorMessageWhenUserIsNull(){

        when(mockLoginModel.getUser()).thenReturn(null);

        presenterImpl.getCurrentUser();

        //verify model interactions
        verify(mockLoginModel, times(1)).getUser();

        //verify view interactions
        verify(mockkLoginView, never()).setFirstName("Fox");
        verify(mockkLoginView, never()).setLastName("Mulder");
        verify(mockkLoginView, times(1)).showUserNotAvailable();
    }


    // presenter.loginButtonClicked()
    @Test
    public void shouldCreateErrorMessageIfFieldAreEmpty(){

        // set up the view mock
        when(mockkLoginView.getFirstName()).thenReturn("");

        presenterImpl.loginButtonClicked();

        verify(mockkLoginView, times(1)).getFirstName();
        verify(mockkLoginView, never()).getLastName();  // lazy argument evaluation for T || XXX
        verify(mockkLoginView, times(1)).showInputError();

        when(mockkLoginView.getFirstName()).thenReturn("Dana");
        when(mockkLoginView.getLastName()).thenReturn("");

        presenterImpl.loginButtonClicked(); // test Last name null

        verify(mockkLoginView, times(2)).getFirstName();
        verify(mockkLoginView, times(1)).getLastName(); // lazy arg evaluation
        verify(mockkLoginView, times(2)).showInputError();
    }

    // presenter.loginButtonClicked()
    @Test
    public void shouldBeAbleToSaveValidUser(){
        when(mockkLoginView.getFirstName()).thenReturn("Novica");
        when(mockkLoginView.getLastName()).thenReturn("Bjelica");

        presenterImpl.loginButtonClicked(); // save the valid user


        // called 2 times first is check if it is null,
        // second is to get values
        verify(mockkLoginView, times(2)).getFirstName();
        verify(mockkLoginView, times(2)).getLastName();

        // make sure that repository saved the user
        verify(mockLoginModel, times(1)).createUser("Novica", "Bjelica");

        // make sure that view showed the user saved message
        verify(mockkLoginView, times(1)).showUserSavedMessage();
    }

}
