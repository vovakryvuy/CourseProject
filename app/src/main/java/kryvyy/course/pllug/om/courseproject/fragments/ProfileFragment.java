package kryvyy.course.pllug.om.courseproject.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.databinding.FragmentProfileBinding;
import kryvyy.course.pllug.om.courseproject.model_response.profile.Profile;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.ProfilePresenter;

/**
 * Created by vovak on 11.06.2018.
 */

public class ProfileFragment extends Fragment implements InterfacePresenter.Profiles{
    private ProfilePresenter mProfilePresenter;
    FragmentProfileBinding binding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mProfilePresenter = new ProfilePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        View view = binding.getRoot();
        initListener();
        //todo id user
        mProfilePresenter.getProfileById(1);
        return view;
    }

    private void initListener() {
       /* binding.tvWebsite.setOnClickListener(this);
        binding.tvPhone.setOnClickListener(this);
        binding.tvEmail.setOnClickListener(this);*/
    }

    @Override
    public void setProfile(Profile profile) {
        binding.tvUserName.setText(profile.getUsername());
        binding.tvEmail.setText(profile.getEmail());
        binding.tvPhone.setText(profile.getPhone());
        binding.tvWebsite.setText(profile.getWebsite());
    }
}
