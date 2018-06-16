package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.ArrayList;
import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.service_retrofit.InterfaceResponse;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vovak on 02.06.2018.
 */

public class CommentsRepository {
    //private static CommentsRepository ourInstance = new CommentsRepository();
    private InterfaceResponse mInterfaceResponse = ServiceRetrofit.getInterfaceResponse();
    private InterfaceRepository.Comments mInterfaceCommentsRepository;
    private Comment mComment;
    private List<Comment> mComments;

    public CommentsRepository (InterfaceRepository.Comments interfaceRepository) {
        this.mInterfaceCommentsRepository = interfaceRepository;
    }

    public void getComment(Integer id){
       mInterfaceResponse.getComment(id).enqueue(new Callback<Comment>() {
           @Override
           public void onResponse(Call<Comment> call, Response<Comment> response) {
               mComment = response.body();
               mInterfaceCommentsRepository.getComment(mComment);
           }

           @Override
           public void onFailure(Call<Comment> call, Throwable t) {

           }
       });
    }

    public void getCommentsByIdPost(Integer idPost){
        mComments = new ArrayList<>();
        mInterfaceResponse.getCommentsByPostId(idPost).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                mComments = response.body();
                mInterfaceCommentsRepository.getComments(mComments);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    public void getCommentsByUser(Integer idUser){
        mComments = new ArrayList<>();
        mInterfaceResponse.getCommentsByUserId(idUser).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                mComments = response.body();
                mInterfaceCommentsRepository.getComments(mComments);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }

    public void getComments(){
        mComments = new ArrayList<>();
        mInterfaceResponse.getComments().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                mComments = response.body();
                mInterfaceCommentsRepository.getComments(mComments);
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }
}
