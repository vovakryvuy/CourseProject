package kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in;

public interface ContactSignUp {

    interface ContactSignUpPresenter {
        void vereficationSignUpData(String login, String email, String password);
    }

    interface ContactSignUpView {
        void showErrorMassage(String massage);

        void openSignInFragment();
    }
}
