package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.CommentsAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;

public class CommentsView {
    private InterfaceView.Comments mInterfaceCommentsView;
    private CommentsAdapter mCommentsAdapter;

    public CommentsView(InterfaceView.Comments interfaceCommentsView) {
        this.mInterfaceCommentsView = interfaceCommentsView;
    }

    public void displayListComments(List<Comment> commentList) {
        mCommentsAdapter = new CommentsAdapter(commentList, mInterfaceCommentsView);
        mInterfaceCommentsView.setAdapterComments(mCommentsAdapter);
    }
}
