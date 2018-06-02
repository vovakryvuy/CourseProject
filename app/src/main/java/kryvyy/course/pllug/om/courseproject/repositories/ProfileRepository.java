package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Photo;
import kryvyy.course.pllug.om.courseproject.model.profile.Profile;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vovak on 02.06.2018.
 */

public class ProfileRepository {
    private static ProfileRepository ourInstance = new ProfileRepository();
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private Profile mProfile;
    private List<Profile> mProfiles;

    public static ProfileRepository getInstance() {
        return ourInstance;
    }

    public Profile getProfile(Integer profileId){
       mInterfaceResponse.getProfile(profileId).enqueue(new Callback<Profile>() {
           @Override
           public void onResponse(Call<Profile> call, Response<Profile> response) {
               mProfile = response.body();
           }

           @Override
           public void onFailure(Call<Profile> call, Throwable t) {

           }
       });
        return mProfile;
    }

    public List<Profile> getProfiles(){
        mProfiles = new ArrayList<>();
        mInterfaceResponse.getProfiles().enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                mProfiles = response.body();
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {

            }
        });
        return mProfiles;
    }
}
