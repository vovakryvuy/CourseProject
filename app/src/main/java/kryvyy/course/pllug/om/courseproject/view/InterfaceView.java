package kryvyy.course.pllug.om.courseproject.view;

import kryvyy.course.pllug.om.courseproject.adapter.CommentsAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

/**
 * Created by vovak on 03.06.2018.
 */

public interface InterfaceView {
    interface Posts{
        void setAdapterPost(PostAdapter adapterPost);
        void itemClickListener(Post post);
    }
    interface Comments{
        void setAdapterComments(CommentsAdapter adapterComments);
        void itemClickListner(Comment comment);
    }
}
