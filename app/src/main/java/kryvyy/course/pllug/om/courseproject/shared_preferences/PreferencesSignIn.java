package kryvyy.course.pllug.om.courseproject.shared_preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by vovak on 26.05.2018.
 */

public class PreferencesSignIn {
    private static final PreferencesSignIn ourInstance = new PreferencesSignIn();
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences.Editor mEditor;
    private static final String SHARED_PREFERENCES_SIGN_IN = "shared_preferences_sign_in";
    private static final String KEY_LOGIN = "key_login";
    private static final String KEY_PASSWORD = "key_password";
    private static final String KEY_EMAIL = "key_email";
    private static  final String KEY_ACTIVE_SESSION = "key_active_session";

    public static PreferencesSignIn getInstance(Context context) {
       if (mSharedPreferences == null){
           mSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_SIGN_IN,Activity.MODE_PRIVATE);
           mEditor = mSharedPreferences.edit();
       }
        return ourInstance;
    }

    public void saveLoginPasswordEmail(String login, String password,String email){
        mEditor.putString(KEY_LOGIN,login);
        mEditor.putString(KEY_PASSWORD,password);
        mEditor.putString(KEY_EMAIL,email);
        mEditor.apply();
    }

    public void setActiveSession(Boolean activeSession){
        mEditor.putBoolean(KEY_ACTIVE_SESSION,activeSession);
        mEditor.apply();
    }

    public void clearLoginPassword(){
        mEditor.clear();
        mEditor.apply();
    }
    public String getLogin(){
        return mSharedPreferences.getString(KEY_LOGIN,"");
    }

    public  String getPassword(){
        return mSharedPreferences.getString(KEY_PASSWORD,"");
    }

    public  String getEmail(){
        return mSharedPreferences.getString(KEY_EMAIL,"");
    }

    public boolean getActiveSession() {return mSharedPreferences.getBoolean(KEY_ACTIVE_SESSION,false);
    }
}
