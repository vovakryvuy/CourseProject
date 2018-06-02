package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.model.Photo;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vovak on 02.06.2018.
 */

public class ImageRepository {
    private static ImageRepository ourInstance = new ImageRepository();
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private Photo mPhoto;
    private List<Photo> mPhotos;

    public static ImageRepository getInstance() {
        return ourInstance;
    }

    public Photo getImage(Integer imageId){
        mInterfaceResponse.getImage(imageId).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                mPhoto = response.body();
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });
        return mPhoto;
    }

    public List<Photo> getImageFromAlbum(Integer albumId){
        mPhotos = new ArrayList<>();
        mInterfaceResponse.getImageFromAlbum(albumId).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                mPhotos = response.body();
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
        return mPhotos;
    }

}