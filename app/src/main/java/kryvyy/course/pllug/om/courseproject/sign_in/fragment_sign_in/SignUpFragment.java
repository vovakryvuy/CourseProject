package kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in;

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
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignIn;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignUp;

public class SignUpFragment extends Fragment implements View.OnClickListener,ContactSignUp.ContactSignUpView{
    private ContactSignIn.ContactSignInFragment mContactSignInFragment;
    private ContactSignUp.ContactSignUpPresenter mContactSignUpPresenter;
    private EditText mEtLogin,mEtPassword,mEtEmail;
    private Button mBtSignIn,mBtSignUp;
    private Context mContext;
    private TextView mTvForgotPassword;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mContactSignInFragment = (ContactSignIn.ContactSignInFragment) context;
        mContactSignUpPresenter = new SignUpPresenter(this,context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_sign_up,container,false);
        initView(view);
        initListener();
        return view;
    }

    private void initView(View view) {
        mEtLogin  = view.findViewById(R.id.edLogin);
        mEtPassword = view.findViewById(R.id.edPassword);
        mEtEmail = view.findViewById(R.id.edEmail);
        mBtSignIn = view.findViewById(R.id.btSignIn);
        mBtSignUp = view.findViewById(R.id.btSignUp);
        mTvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        mTvForgotPassword.setPaintFlags(mTvForgotPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    private void initListener() {
        mBtSignIn.setOnClickListener(this);
        mBtSignUp.setOnClickListener(this);
        mTvForgotPassword.setOnClickListener(this);
    }

    @Override
    public void showErrorMassage(String massage) {
        Toast.makeText(mContext,massage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void openSignInFragment() {
        mContactSignInFragment.openSignInFragment();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btSignUp:
                mContactSignUpPresenter.vereficationSignUpData(mEtLogin.getText().toString(),
                        mEtEmail.getText().toString(),mEtPassword.getText().toString());
                break;
            case R.id.btSignIn:
                mContactSignInFragment.openSignInFragment();
                break;

            case R.id.tvForgotPassword:
                mContactSignInFragment.openForgotPasswordFragment();
                break;
        }
    }
}
