package kryvyy.course.pllug.om.courseproject.presenter;

import android.support.v7.widget.RecyclerView;

import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.model_response.profile.Profile;

/**
 * Created by vovak on 03.06.2018.
 */

public interface InterfacePresenter {
    void setAdapter(RecyclerView.Adapter adapter);
    void clickItemPost(Post post);

    interface Profiles{
        void setProfile(Profile profile);
    }
    interface Comments{
        void setAdapterCommests(RecyclerView.Adapter adapter);
        void clickComment(Comment comment);
    }
    interface Albums{
        void setAdapterAlbum(RecyclerView.Adapter adapter);
        void clickAlbum(Album album);
    }
    interface Photos{
        void setAdapterPhotos(RecyclerView.Adapter adapter);
        void clickPhoto(Photo photo);
    }
    interface Todos{
        void setAdapterTodos(RecyclerView.Adapter adapter);
        void clickTodos(Todo todos);
    }

}
