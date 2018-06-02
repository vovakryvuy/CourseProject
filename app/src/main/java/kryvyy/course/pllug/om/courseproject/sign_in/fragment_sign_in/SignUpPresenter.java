package kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.shared_preferences.PreferencesSignIn;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignIn;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignUp;

/**
 * Created by vovak on 27.05.2018.
 */

public class SignUpPresenter implements ContactSignUp.ContactSignUpPresenter {
    private ContactSignUp.ContactSignUpView mContactSignUpView;
    private Context mContext;
    private PreferencesSignIn mPref;

    public SignUpPresenter(ContactSignUp.ContactSignUpView contactSignUpView, Context context) {
        this.mContactSignUpView = contactSignUpView;
        this.mContext = context;
        mPref = PreferencesSignIn.getInstance(mContext);
    }

    @Override
    public void vereficationSignUpData(String login, String email, String password) {
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            stringBuilder.append(mContext.getResources().getString(R.string.toastMassage)+" ");
        if (TextUtils.isEmpty(login))
            stringBuilder.append(mContext.getResources().getString(R.string.login)+" ");
        if (TextUtils.isEmpty(email))
            stringBuilder.append(mContext.getResources().getString(R.string.email)+" ");
        if (TextUtils.isEmpty(password))
            stringBuilder.append(mContext.getResources().getString(R.string.password));
        if (!TextUtils.isEmpty(stringBuilder))
            mContactSignUpView.showErrorMassage(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(login) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            checkData(login,password,email);
        }
    }

    private void checkData(String login, String password, String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (email.equals(mPref)){
                mContactSignUpView.showErrorMassage(mContext.getString(R.string.toastEmailRegister));
            }else {
                mPref.saveLoginPasswordEmail(login,password,email);
                mContactSignUpView.showErrorMassage(mContext.getString(R.string.toastSuccessfullRegister));
                mContactSignUpView.openSignInFragment();
            }
        }else {
            mContactSignUpView.showErrorMassage(mContext.getString(R.string.toastInvalidEmailAddress));
        }
    }
}
