package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.model.Post;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vovak on 02.06.2018.
 */

public class PostsRepository {
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private InterfaceRepository.Posts mInterfacePostsRepository;
    private Post mPost;
    private List<Post> mPosts;

    public PostsRepository (InterfaceRepository.Posts interfaceRepository) {
        this.mInterfacePostsRepository = interfaceRepository;
    }

    public void getPost(Integer postId){
        mInterfaceResponse.getPost(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                mPost = response.body();
                mInterfacePostsRepository.getPost(mPost);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    public void getPosts(){
        mPosts = new ArrayList<>();
        mInterfaceResponse.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                mPosts = response.body();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
