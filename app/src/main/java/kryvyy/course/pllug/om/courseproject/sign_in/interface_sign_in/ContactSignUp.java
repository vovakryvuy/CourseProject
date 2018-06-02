package kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in;

/**
 * Created by vovak on 27.05.2018.
 */

public interface ContactSignUp {

    interface ContactSignUpFragment{
        void openSignInFragment();
        void openForgotFragment();
    }

    interface ContactSignUpPresenter{
        void vereficationSignUpData(String login,String email,String password);
    }

    interface ContactSignUpView {
        void showErrorMassage(String massage);
        void openSignInFragment();
        void openForgotPassword();
    }
}
