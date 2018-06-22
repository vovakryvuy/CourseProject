package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosRepository {
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private InterfaceRepository.Images mInterfaceImagesRepository;
    private Photo mPhoto;
    private List<Photo> mPhotos;

    public PhotosRepository(InterfaceRepository.Images interfaceImagesRepository) {
        this.mInterfaceImagesRepository = interfaceImagesRepository;
    }

    public void getImage(Integer imageId) {
        mInterfaceResponse.getImage(imageId).enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                mPhoto = response.body();
                mInterfaceImagesRepository.getImage(mPhoto);
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });
    }

    public void getImageFromAlbum(Integer albumId) {
        mPhotos = new ArrayList<>();
        mInterfaceResponse.getImageFromAlbum(albumId).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                mPhotos = response.body();
                mInterfaceImagesRepository.getImages(mPhotos);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }

    public void getImageFromUserAlbum(Integer idUser) {
        mPhotos = new ArrayList<>();
        mInterfaceResponse.getImageFromAlbumUser(idUser).enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                mPhotos = response.body();
                mInterfaceImagesRepository.getImages(mPhotos);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });
    }
}