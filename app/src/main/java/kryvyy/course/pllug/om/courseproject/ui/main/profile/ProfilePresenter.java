package kryvyy.course.pllug.om.courseproject.ui.main.profile;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.profile.Profile;
import kryvyy.course.pllug.om.courseproject.data.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.data.repositories.ProfileRepository;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;

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
