package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.PostAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

/**
 * Created by vovak on 03.06.2018.
 */

public class PostsView {
    private InterfaceView.Posts mInterfacePostsView;
    private PostAdapter mPostAdapter;

    public PostsView(InterfaceView.Posts mInterfacePostsView) {
        this.mInterfacePostsView = mInterfacePostsView;
    }

    public void displayListPost(List<Post> posts){
        mPostAdapter = new PostAdapter(posts);
        mInterfacePostsView.setAdapterPost(mPostAdapter);
    }
}
