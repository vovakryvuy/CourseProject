package kryvyy.course.pllug.om.courseproject.ui.main.post;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Post;
import kryvyy.course.pllug.om.courseproject.data.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.data.repositories.PostsRepository;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class PostsPresenter implements InterfaceRepository.Posts, InterfaceView.Posts {
    private PostsRepository mPostsRepository;
    private InterfacePresenter mInterfacePresenter;
    private PostsView mPostsView;

    public PostsPresenter(InterfacePresenter interfacePresenter) {
        mInterfacePresenter = interfacePresenter;
        mPostsRepository = new PostsRepository(this);
        mPostsView = new PostsView(this);
    }

    public void getPost(Integer postId) {
        mPostsRepository.getPost(postId);
    }

    public void getPosts() {
        mPostsRepository.getPosts();
    }

    @Override
    public void getPost(Post post) {

    }

    @Override
    public void getPosts(List<Post> posts) {
        mPostsView.displayListPost(posts);
    }

    @Override
    public void setAdapterPost(PostAdapter adapterPost) {
        mInterfacePresenter.setAdapter(adapterPost);
    }

    @Override
    public void itemClickListener(Post post) {
        mInterfacePresenter.clickItemPost(post);
    }

}
