package kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in;

public interface ContactForgotPassword {

    interface ContactForgotPresenter {
        void vereficationEmail(String email);
    }

    interface ContactForgotView {
        void showErrorMassage(String massage);

        void openSignInFragment();
    }
}
