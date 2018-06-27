package kryvyy.course.pllug.om.courseproject.data.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.data.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.data.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private InterfaceRepository.Albums mInterfaceAlbumsRepository;
    private Album mAlbum;
    private List<Album> mAlbums;

    public AlbumRepository(InterfaceRepository.Albums interfaceAlbumsRepository) {
        this.mInterfaceAlbumsRepository = interfaceAlbumsRepository;
    }

    public void getAlbumById(Integer id) {
        mInterfaceResponse.getAlbum(id).enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                mAlbum = response.body();
                mInterfaceAlbumsRepository.getAlbum(mAlbum);
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

            }
        });
    }

    public void getAllAlbums() {
        mAlbums = new ArrayList<>();
        mInterfaceResponse.getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                mAlbums = response.body();
                mInterfaceAlbumsRepository.getAlbums(mAlbums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}
