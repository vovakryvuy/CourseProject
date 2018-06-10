package kryvyy.course.pllug.om.courseproject.presenter;

import android.support.v7.widget.RecyclerView;

import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

/**
 * Created by vovak on 03.06.2018.
 */

public interface InterfacePresenter {
    void setAdapter(RecyclerView.Adapter adapter);
    void clickItemPost(Post post);
    public interface Profile{
        void setUserName(String userName);
    }
    public interface Comments{
        void setAdapterCommests(RecyclerView.Adapter adapter);
        void clickComment(Comment comment);
    }
    public interface Albums{
        void setAdapterAlbum(RecyclerView.Adapter adapter);
        void clickAlbum(Album album);
    }
    public  interface Photos{
        void setAdapterPhotos(RecyclerView.Adapter adapter);
        void clickPhoto(Photo photo);
    }
}
