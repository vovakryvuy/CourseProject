package kryvyy.course.pllug.om.courseproject;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import kryvyy.course.pllug.om.courseproject.databinding.SplashscreenBinding;
import kryvyy.course.pllug.om.courseproject.shared_preferences.PreferencesSignIn;

public class SplashActivity extends Activity {
    private static final int SPLASH_DISPLAY_TIME = 1000;
    private SplashscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.splashscreen);
        checkSession();
    }

    private void checkSession() {
        if (PreferencesSignIn.getInstance(this).getActiveSession()) {
            openMainScreen();
        } else {
            Intent intent = new Intent(this, AuthorizationActivity.class);
            SplashActivity.this.startActivity(intent);
            SplashActivity.this.finish();
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    private void openMainScreen() {
        new Handler().postDelayed(this::mainScreen, SPLASH_DISPLAY_TIME);
    }

    private void mainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
        binding.progressBar.setVisibility(View.GONE);
    }
}
