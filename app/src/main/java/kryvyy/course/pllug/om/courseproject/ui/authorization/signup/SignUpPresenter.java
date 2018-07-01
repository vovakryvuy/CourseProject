package kryvyy.course.pllug.om.courseproject.ui.authorization.signup;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.data.shared_preferences.PreferencesSignIn;

public class SignUpPresenter implements InterfaceSignUp.ContactSignUpPresenter {
    private InterfaceSignUp.ContactSignUpView mContactSignUpView;
    private Context mContext;
    private PreferencesSignIn mPref;

    public SignUpPresenter(InterfaceSignUp.ContactSignUpView contactSignUpView, Context context) {
        this.mContactSignUpView = contactSignUpView;
        this.mContext = context;
        mPref = PreferencesSignIn.getInstance(mContext);
    }

    @Override
    public void vereficationSignUpData(String login, String email, String password) {
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            stringBuilder.append(mContext.getResources().getString(R.string.toastMassageRegistationFail)).append(" ");
            if (TextUtils.isEmpty(login))
                stringBuilder.append(mContext.getResources().getString(R.string.login)).append(" ");
            if (TextUtils.isEmpty(email))
                stringBuilder.append(mContext.getResources().getString(R.string.email)).append(" ");
            if (TextUtils.isEmpty(password))
                stringBuilder.append(mContext.getResources().getString(R.string.password));
            if (!TextUtils.isEmpty(stringBuilder))
                mContactSignUpView.showErrorMassage(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(login) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
            checkData(login, password, email);
        }
    }

    private void checkData(String login, String password, String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (email.equals(mPref.getEmail())) {
                mContactSignUpView.showErrorMassage(mContext.getString(R.string.toastEmailRegister));
            } else {
                mPref.saveLoginPasswordEmail(login, password, email);
                mContactSignUpView.showErrorMassage(mContext.getString(R.string.toastSuccessfullRegister));
                mContactSignUpView.openSignInFragment();
            }
        } else {
            mContactSignUpView.showErrorMassage(mContext.getString(R.string.toastInvalidEmailAddress));
        }
    }
}
