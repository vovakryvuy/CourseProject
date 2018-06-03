package kryvyy.course.pllug.om.courseproject.service_retrofit;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.model.Comment;
import kryvyy.course.pllug.om.courseproject.model.Photo;
import kryvyy.course.pllug.om.courseproject.model.Post;
import kryvyy.course.pllug.om.courseproject.model.Todo;
import kryvyy.course.pllug.om.courseproject.model.profile.Profile;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vovak on 02.06.2018.
 */

public interface InterfaceResponse {
    /**
    Get data by id
     */

    @GET("/users/{id}")
    Call<Profile> getProfile (@Path("id") Integer id);

    @GET("/posts/{id}")
    Call<Post> getPost (@Path("id") Integer id);

    @GET("/comments/{id}")
    Call<Comment> getComment (@Path("id") Integer id);

    @GET("/albums/{id}")
    Call<Album> getAlbum (@Path("id") Integer id);

    @GET("/photos/{id}")
    Call<Photo> getImage (@Path("id") Integer id);

    @GET("/todos/{id}")
    Call<Todo> getTodo (@Path("id") Integer id);

    /**
     Get all data
     */
    @GET("/albums")
    Call<List<Album>> getAlbums ();

    @GET("/users")
    Call<List<Profile>> getProfiles();

    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/comments")
    Call<List<Comment>> getComments ();

    @GET("/photos")
    Call<List<Photo>> getImageFromAlbum(@Query("albumId") Integer albumId);

    /* @GET("/users")
    Call<List<Profile>> getUsers ();

    @GET("/posts")
    Call<List<Post>> getPosts ();*/

   /* @GET("/comments")
    Call<Comment> getComment (@Path("id") Integer id);

    @GET("/photos/{id}")
    Call<Photo> getPhoto (@Path("id") Integer id);

    @GET("/todos/{id}")
    Call<Todo> getTodo (@Path("id") Integer id);*/

}
