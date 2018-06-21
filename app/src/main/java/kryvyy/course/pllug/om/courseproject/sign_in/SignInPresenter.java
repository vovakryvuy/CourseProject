package kryvyy.course.pllug.om.courseproject.sign_in;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.shared_preferences.PreferencesSignIn;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignIn;

/**
 * Created by vovak on 26.05.2018.
 */

public class SignInPresenter implements ContactSignIn.ContactSignInPresenter {
    private ContactSignIn.ContactSignInView mContactSignInView;
    private PreferencesSignIn mPref;
    private Context mContext;

    public SignInPresenter(ContactSignIn.ContactSignInView contactSignInView, Context context) {
        this.mContactSignInView = contactSignInView;
        this.mContext = context;
        mPref = PreferencesSignIn.getInstance(mContext);
    }

    @Override
    public void vereficationLoginPassword(String login, String password) {
        if (TextUtils.isEmpty(login) && TextUtils.isEmpty(password)){
            showMassageEmpty(mContext.getString(R.string.login)+ " "+mContext.getString(R.string.and)
                    +" "+mContext.getString(R.string.password));
        }else if(TextUtils.isEmpty(login)){
            showMassageEmpty(mContext.getString(R.string.login));
        }else if(TextUtils.isEmpty(password)){
            showMassageEmpty(mContext.getString(R.string.password));
        }else {
            checkLoginPassword(login,password);
        }
    }

    private void checkLoginPassword(String login, String password) {
        String savedLogin = mPref.getLogin();
        String savedPassword = mPref.getPassword();
        if (!TextUtils.equals(login,savedLogin) && !TextUtils.equals(password,savedPassword)){
            showMassage(mContext.getString(R.string.notCorrect)
                    +" " + mContext.getString(R.string.login)
                    +" " + mContext.getString(R.string.and)
                    +" " + mContext.getString(R.string.password)
            );
        }else if(!TextUtils.equals(login,mPref.getLogin())){
            showMassage(mContext.getString(R.string.notCorrect)
                    + " " + mContext.getString(R.string.login));
        }else if (!TextUtils.equals(password,mPref.getPassword())){
            showMassage(mContext.getString(R.string.notCorrect)
                    +" " + mContext.getString(R.string.password));
        }else {
            mContactSignInView.action();
            mPref.setActiveSession(true);
        }
    }

    private void showMassage(String massage) {
        mContactSignInView.showErrorMassage(massage);
    }

    private void showMassageEmpty(String massage) {
        mContactSignInView.showErrorMassage(mContext.getString(R.string.toastMassage,massage));
    }


}
