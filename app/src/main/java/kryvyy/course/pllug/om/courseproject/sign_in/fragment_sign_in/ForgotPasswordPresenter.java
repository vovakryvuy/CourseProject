package kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactForgotPassword;

/**
 * Created by vovak on 27.05.2018.
 */

public class ForgotPasswordPresenter implements ContactForgotPassword.ContactForgotPresenter{
    private ContactForgotPassword.ContactForgotView mContactForgotView;
    private Context mContext;

    public ForgotPasswordPresenter(ContactForgotPassword.ContactForgotView mContactForgotView, Context mContext) {
        this.mContactForgotView = mContactForgotView;
        this.mContext = mContext;
    }

    @Override
    public void vereficationEmail(String email) {
        if (!TextUtils.isEmpty(email)){
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                mContactForgotView.showErrorMassage(mContext
                        .getString(R.string.toastSendPasswordEmail)+" "+email);
                mContactForgotView.openSignInFragment();
            } else{
                mContactForgotView.showErrorMassage(mContext.getString(R.string.toastInvalidEmailAddress));
            }
        }else {
            mContactForgotView.showErrorMassage(mContext.getString(R.string.toastMassageErEmail));
        }
    }
}
