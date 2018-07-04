package kryvyy.course.pllug.om.courseproject.ui.main.main_interface;

import kryvyy.course.pllug.om.courseproject.ui.main.album.AlbumAdapter;
import kryvyy.course.pllug.om.courseproject.ui.main.comment.CommentsAdapter;
import kryvyy.course.pllug.om.courseproject.ui.main.photo.PhotosAdapter;
import kryvyy.course.pllug.om.courseproject.ui.main.post.PostAdapter;
import kryvyy.course.pllug.om.courseproject.ui.main.todo.TodoAdapter;
import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.data.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.data.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.data.model_response.Post;
import kryvyy.course.pllug.om.courseproject.data.model_response.Todo;

public interface InterfaceView {
    interface Posts {
        void setAdapterPost(PostAdapter adapterPost);

        void itemClickListener(Post post);
    }

    interface Comments {
        void setAdapterComments(CommentsAdapter adapterComments);

        void itemClickListner(Comment comment);
    }

    interface Albums {
        void setAdapterAlbums(AlbumAdapter adpterAlbums);

        void itemClickListener(Album album);
    }

    interface Photos {
        void setAdapterPhotos(PhotosAdapter adapterPhotos);

        void itemClickListener(Photo photo);
    }

    interface Todos {
        void setAdapterTodos(TodoAdapter adapterTodos);

        void itemClickListener(Todo todo);
    }

}
