package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.repositories.CommentsRepository;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;

/**
 * Created by vovak on 03.06.2018.
 */

public class CommentsRresenter implements InterfaceRepository.Comments {
    private CommentsRepository mCommentsRepository;

    public CommentsRresenter() {
        mCommentsRepository = new CommentsRepository(this);
    }

    @Override
    public void getComment(Comment comment) {

    }

    @Override
    public void getComments(List<Comment> comments) {

    }
}
