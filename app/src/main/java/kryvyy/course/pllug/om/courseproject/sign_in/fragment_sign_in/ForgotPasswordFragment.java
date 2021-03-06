package kryvyy.course.pllug.om.courseproject.sign_in.fragment_sign_in;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactForgotPassword;
import kryvyy.course.pllug.om.courseproject.sign_in.interface_sign_in.ContactSignIn;

/**
 * Created by vovak on 26.05.2018.
 */

public class ForgotPasswordFragment extends Fragment implements ContactForgotPassword.ContactForgotView ,
        View.OnClickListener{
    private ContactSignIn.ContactSignInFragment mContactSignInFragment;
    private ContactForgotPassword.ContactForgotPresenter mContactForgotPresenter;
    private Context mContext;
    private EditText mEtEmail;
    private Button mBtSend;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mContactSignInFragment = (ContactSignIn.ContactSignInFragment) context;
        mContactForgotPresenter = new ForgotPasswordPresenter(this,context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password,container,false);
        initView(view);
        initListener();
        return view;
    }

    private void initView(View view) {
        mEtEmail = view.findViewById(R.id.edEmail);
        mBtSend = view.findViewById(R.id.btSendNewPassword);
    }

    private void initListener() {
        mBtSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btSendNewPassword:
                mContactForgotPresenter.vereficationEmail(mEtEmail.getText().toString());
                break;
        }
    }

    @Override
    public void showErrorMassage(String massage) {
        Toast.makeText(mContext,massage,Toast.LENGTH_LONG).show();
    }

    @Override
    public void openSignInFragment() {
        mContactSignInFragment.openSignInFragment();
    }


}
