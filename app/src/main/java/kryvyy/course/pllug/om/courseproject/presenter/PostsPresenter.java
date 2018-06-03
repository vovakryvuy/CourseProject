package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.repositories.PostsRepository;
import kryvyy.course.pllug.om.courseproject.view.InterfaceView;
import kryvyy.course.pllug.om.courseproject.view.PostsView;

/**
 * Created by vovak on 03.06.2018.
 */

public class PostsPresenter implements InterfaceRepository.Posts, InterfaceView.Posts,Interface {
    private PostsRepository mPostsRepository;
    private InterfacePresenter mInterfacePresenter;
    private PostsView mPostsView;

    public PostsPresenter(InterfacePresenter interfacePresenter) {
        mInterfacePresenter = interfacePresenter;
        mPostsRepository = new PostsRepository(this);
        mPostsView = new PostsView(this);
    }

    public void getPost(Integer postId){
        mPostsRepository.getPost(postId);
    }

    public void getPosts(){
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
}
