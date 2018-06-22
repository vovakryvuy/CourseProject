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

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.databinding.FragmentProfileBinding;
import kryvyy.course.pllug.om.courseproject.model_response.profile.Profile;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.ProfilePresenter;

public class ProfileFragment extends Fragment implements InterfacePresenter.Profiles {
    FragmentProfileBinding binding;
    private ProfilePresenter mProfilePresenter;

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
        // id user
        mProfilePresenter.getProfileById(1);
        return view;
    }

    @Override
    public void setProfile(Profile profile) {
        binding.tvUserName.setText(profile.getUsername());
        binding.tvEmail.setText(profile.getEmail());
        binding.tvPhone.setText(profile.getPhone());
        binding.tvWebsite.setText(profile.getWebsite());
        binding.tvStreet.setText(profile.getAddress().getStreet());
        binding.tvCity.setText(profile.getAddress().getCity());
        binding.tvSuite.setText(profile.getAddress().getSuite());
        binding.tvZipcode.setText(profile.getAddress().getZipcode());
        binding.tvNameCompany.setText(profile.getCompany().getName());
        binding.tvCatchPhrase.setText(profile.getCompany().getCatchPhrase());
        binding.progressBar.setVisibility(View.GONE);
        binding.layoutProfile.setVisibility(View.VISIBLE);
    }
}
