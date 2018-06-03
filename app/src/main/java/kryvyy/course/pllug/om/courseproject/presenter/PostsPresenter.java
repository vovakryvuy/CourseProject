package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Post;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.repositories.PostsRepository;

/**
 * Created by vovak on 03.06.2018.
 */

public class PostsPresenter implements InterfaceRepository.Posts {
    private PostsRepository mPostsRepository;

    public PostsPresenter() {
        mPostsRepository = new PostsRepository(this);
    }

    @Override
    public void getPost(Post post) {

    }

    @Override
    public void getPosts(List<Post> posts) {

    }
}
