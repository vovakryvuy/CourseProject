package kryvyy.course.pllug.om.courseproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in.ForgotPasswordFragment;
import kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in.SignInFragment;
import kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in.SignUpFragment;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignIn;

public class AuthorizationActivity extends AppCompatActivity implements ContactSignIn.ContactSignInFragment {
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        initFragmentContainer();
    }

    private void initFragmentContainer() {
        if (findViewById(R.id.fargmentContainerAuthorization) != null) {
            mFragmentManager = getSupportFragmentManager();
            starFragmentSignIn();
        }
    }

    private void starFragmentSignIn() {
        SignInFragment signInFragment = new SignInFragment();
        mFragmentManager.beginTransaction()
                .replace(R.id.fargmentContainerAuthorization, signInFragment).commit();
    }

    @Override
    public void openSignUpFragment() {
        SignUpFragment signUpFragment = new SignUpFragment();
        mFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.fargmentContainerAuthorization, signUpFragment).commit();
    }

    @Override
    public void openForgotPasswordFragment() {
        ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment();
        mFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.fargmentContainerAuthorization, forgotPasswordFragment).commit();
    }

    @Override
    public void openSignInFragment() {
        starFragmentSignIn();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
