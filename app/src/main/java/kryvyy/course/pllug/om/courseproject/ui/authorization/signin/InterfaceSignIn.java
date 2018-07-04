package kryvyy.course.pllug.om.courseproject.ui.authorization.signin;

public interface InterfaceSignIn {

    interface ContactSignInFragment {
        void openSignUpFragment();

        void openForgotPasswordFragment();

        void openSignInFragment();

        void startMainActivity();
    }


    interface ContactSignInPresenter {
        void vereficationLoginPassword(String login, String password);
    }

    interface ContactSignInView {
        void showErrorMassage(String massage);

        void action();
    }

}
