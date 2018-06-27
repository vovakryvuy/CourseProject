package kryvyy.course.pllug.om.courseproject.ui.authorization.forgotpassword;

public interface InterfaceForgotPassword {

    interface ContactForgotPresenter {
        void vereficationEmail(String email);
    }

    interface ContactForgotView {
        void showErrorMassage(String massage);

        void openSignInFragment();
    }
}
