package kryvyy.course.pllug.om.courseproject.view;

import kryvyy.course.pllug.om.courseproject.adapter.AlbumAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.CommentsAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.PhotosAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.TodoAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;

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
