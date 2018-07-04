package kryvyy.course.pllug.om.courseproject.ui.main.comment;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.data.repositories.CommentsRepository;
import kryvyy.course.pllug.om.courseproject.data.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class CommentsRresenter implements InterfaceRepository.Comments, InterfaceView.Comments {
    private CommentsRepository mCommentsRepository;
    private CommentsView mCommentsView;
    private InterfacePresenter.Comments mInterfaceCommentsPresenter;

    public CommentsRresenter(InterfacePresenter.Comments interfaceCommentsPresenter) {
        mInterfaceCommentsPresenter = interfaceCommentsPresenter;
        mCommentsRepository = new CommentsRepository(this);
        mCommentsView = new CommentsView(this);
    }

    public void getCommentsByPost(Integer idPost) {
        mCommentsRepository.getCommentsByIdPost(idPost);
    }

    public void getCommentsByUser(Integer idUser) {
        mCommentsRepository.getCommentsByUser(idUser);
    }

    @Override
    public void getComment(Comment comment) {
    }

    @Override
    public void getComments(List<Comment> comments) {
        mCommentsView.displayListComments(comments);
    }


    @Override
    public void setAdapterComments(CommentsAdapter adapterComments) {
        mInterfaceCommentsPresenter.setAdapterCommests(adapterComments);
    }

    @Override
    public void itemClickListner(Comment comment) {
        mInterfaceCommentsPresenter.clickComment(comment);
    }
}
