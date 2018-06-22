package kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in;

public interface ContactSignIn {

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
