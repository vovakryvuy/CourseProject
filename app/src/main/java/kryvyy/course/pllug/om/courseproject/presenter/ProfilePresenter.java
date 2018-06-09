package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.profile.Profile;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.repositories.ProfileRepository;

/**
 * Created by vovak on 03.06.2018.
 */

public class ProfilePresenter implements InterfaceRepository.Profiles{
    private ProfileRepository mProfileRepository;
    private InterfacePresenter.Profile mInterfaceProfilePresenter;

    public ProfilePresenter(InterfacePresenter.Profile interfacePresenter) {
        mInterfaceProfilePresenter = interfacePresenter;
        mProfileRepository = new ProfileRepository(this);
    }

    public void getProfileById(Integer idUser){
        mProfileRepository.getProfile(idUser);
    }

    @Override
    public void getProfile(Profile profile) {
        mInterfaceProfilePresenter.setUserName(profile.getUsername());
    }

    @Override
    public void getProfiles(List<Profile> profiles) {

    }
}
