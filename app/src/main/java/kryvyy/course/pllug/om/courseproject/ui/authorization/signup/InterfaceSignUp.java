package kryvyy.course.pllug.om.courseproject.ui.authorization.signup;

public interface InterfaceSignUp {

    interface ContactSignUpPresenter {
        void vereficationSignUpData(String login, String email, String password);
    }

    interface ContactSignUpView {
        void showErrorMassage(String massage);

        void openSignInFragment();
    }
}
