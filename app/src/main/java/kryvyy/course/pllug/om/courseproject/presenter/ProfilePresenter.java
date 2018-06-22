package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.profile.Profile;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.repositories.ProfileRepository;

public class ProfilePresenter implements InterfaceRepository.Profiles{
    private ProfileRepository mProfileRepository;
    private InterfacePresenter.Profiles mInterfaceProfilePresenter;
    private Profile mProfile;

    public ProfilePresenter(InterfacePresenter.Profiles interfacePresenter) {
        mInterfaceProfilePresenter = interfacePresenter;
        mProfileRepository = new ProfileRepository(this);
    }

    public void getProfileById(Integer idUser){
        mProfileRepository.getProfile(idUser);
    }

    @Override
    public void getProfile(Profile profile) {
        mProfile  = profile;
        mInterfaceProfilePresenter.setProfile(profile);
    }

    @Override
    public void getProfiles(List<Profile> profiles) {

    }
}
