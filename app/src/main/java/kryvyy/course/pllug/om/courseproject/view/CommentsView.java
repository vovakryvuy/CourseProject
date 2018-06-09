package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.CommentsAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

/**
 * Created by vovak on 09.06.2018.
 */

public class CommentsView {
    private InterfaceView.Comments mInterfaceCommentsView;
    private CommentsAdapter mCommentsAdapter;

    public CommentsView(InterfaceView.Comments interfaceCommentsView) {
        this.mInterfaceCommentsView = interfaceCommentsView;
    }

    public void displayListComments(List<Comment> commentList){
        mCommentsAdapter = new CommentsAdapter(commentList,mInterfaceCommentsView);
        mInterfaceCommentsView.setAdapterComments(mCommentsAdapter);
    }
}
