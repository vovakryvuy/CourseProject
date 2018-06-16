package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.model_response.profile.Profile;


/**
 * Created by vovak on 03.06.2018.
 */

public interface InterfaceRepository {

    interface Posts{
      void getPost(Post post);
      void getPosts(List<Post> posts);
    }
    interface Comments{
        void getComment(Comment comment);
        void getComments(List<Comment> comments);
    }
    interface Images{
        void getImage(Photo photo);
        void getImages(List<Photo> photos);
    }
    interface Albums{
        void getAlbum(Album album);
        void getAlbums(List<Album> albums);
    }
    interface Profiles{
        void getProfile(Profile profile);
        void getProfiles(List<Profile> profiles);
    }
    interface Todos{
        void getTodo(Todo todo);
        void getTodos(List<Todo> todos);
    }
}
