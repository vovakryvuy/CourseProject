package kryvyy.course.pllug.om.courseproject.repositories;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.model.Comment;
import kryvyy.course.pllug.om.courseproject.model.Photo;
import kryvyy.course.pllug.om.courseproject.model.Post;
import kryvyy.course.pllug.om.courseproject.model.profile.Profile;


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

    } interface Albums{
        void getAlbum(Album album);
        void getAlbums(List<Album> albums);

    } interface Profiles{
        void getProfile(Profile profile);
        void getProfiles(List<Profile> profiles);
    }
}
