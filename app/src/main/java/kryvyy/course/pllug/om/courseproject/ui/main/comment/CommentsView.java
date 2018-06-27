package kryvyy.course.pllug.om.courseproject.ui.main.comment;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

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
