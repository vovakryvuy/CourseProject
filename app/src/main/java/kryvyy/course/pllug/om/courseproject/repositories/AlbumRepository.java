package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vovak on 02.06.2018.
 */

public class AlbumRepository {
    private static AlbumRepository ourInstance = new AlbumRepository();
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private Album mAlbum;
    private List<Album> mAlbums;
    public static AlbumRepository getInstance() {
        return ourInstance;
    }

    public Album getAlbumById(Integer id){
        mInterfaceResponse.getAlbum(id).enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                mAlbum = response.body();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

            }
        });
        return mAlbum;
    }

    public List<Album> getAllAlbums(){
        mAlbums = new ArrayList<>();
        mInterfaceResponse.getAlbums().enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                mAlbums = response.body();
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
        return mAlbums;
    }
}
