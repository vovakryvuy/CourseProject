package kryvyy.course.pllug.om.courseproject.ui.authorization.signin;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kryvyy.course.pllug.om.courseproject.R;

public class SignInFragment extends Fragment implements InterfaceSignIn.ContactSignInView, View.OnClickListener {
    private InterfaceSignIn.ContactSignInFragment mContactSignInFragment;
    private InterfaceSignIn.ContactSignInPresenter mContactSignInPresenter;
    private EditText mEtLogin, mEtPassword;
    private Button mBtLogin, mBtSignUp;
    private TextView mTvForgotPassword;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContactSignInFragment = (InterfaceSignIn.ContactSignInFragment) context;
        mContactSignInPresenter = new SignInPresenter(this, context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initView(View view) {
        mEtLogin = view.findViewById(R.id.edLogin);
        mEtPassword = view.findViewById(R.id.edPassword);
        mBtLogin = view.findViewById(R.id.btLogin);
        mBtSignUp = view.findViewById(R.id.btSignUp);
        mTvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        mTvForgotPassword.setPaintFlags(mTvForgotPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    private void initListener() {
        mBtSignUp.setOnClickListener(this);
        mTvForgotPassword.setOnClickListener(this);
        mBtLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSignUp:
                mContactSignInFragment.openSignUpFragment();
                break;
            case R.id.tvForgotPassword:
                mContactSignInFragment.openForgotPasswordFragment();
                break;
            case R.id.btLogin:
                mContactSignInPresenter
                        .vereficationLoginPassword(mEtLogin.getText().toString(),
                                mEtPassword.getText().toString());
                break;
        }
    }

    @Override
    public void showErrorMassage(String massage) {
        Toast.makeText(getContext(), massage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void action() {
        mContactSignInFragment.startMainActivity();
    }
}
