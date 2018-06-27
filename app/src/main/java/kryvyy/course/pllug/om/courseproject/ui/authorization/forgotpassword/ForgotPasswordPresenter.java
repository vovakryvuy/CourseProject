package kryvyy.course.pllug.om.courseproject.ui.authorization.forgotpassword;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import kryvyy.course.pllug.om.courseproject.R;

public class ForgotPasswordPresenter implements InterfaceForgotPassword.ContactForgotPresenter {
    private InterfaceForgotPassword.ContactForgotView mContactForgotView;
    private Context mContext;

    public ForgotPasswordPresenter(InterfaceForgotPassword.ContactForgotView mContactForgotView, Context mContext) {
        this.mContactForgotView = mContactForgotView;
        this.mContext = mContext;
    }

    @Override
    public void vereficationEmail(String email) {
        if (!TextUtils.isEmpty(email)) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                mContactForgotView.showErrorMassage(mContext
                        .getString(R.string.toastSendPasswordEmail) + " " + email);
                mContactForgotView.openSignInFragment();
            } else {
                mContactForgotView.showErrorMassage(mContext.getString(R.string.toastInvalidEmailAddress));
            }
        } else {
            mContactForgotView.showErrorMassage(mContext.getString(R.string.toastMassageErEmail));
        }
    }
}
