package kryvyy.course.pllug.om.courseproject.ui.authorization.forgotpassword;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.data.shared_preferences.PreferencesSignIn;

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
                if (PreferencesSignIn.getInstance(mContext).getEmail().equals(email)){
                    mContactForgotView.showErrorMassage(mContext
                            .getString(R.string.toastViewPassword) + " " + PreferencesSignIn.getInstance(mContext).getPassword());
                    mContactForgotView.openSignInFragment();
                }else {
                    mContactForgotView.showErrorMassage(mContext.getString(R.string.this_email_is_not_register));
                }
            } else {
                mContactForgotView.showErrorMassage(mContext.getString(R.string.toastInvalidEmailAddress));
            }
        } else {
            mContactForgotView.showErrorMassage(mContext.getString(R.string.toastMassageErEmail));
        }
    }
}
