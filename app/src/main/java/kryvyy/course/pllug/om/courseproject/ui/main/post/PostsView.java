package kryvyy.course.pllug.om.courseproject.ui.main.post;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Post;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class PostsView {
    private InterfaceView.Posts mInterfacePostsView;
    private PostAdapter mPostAdapter;

    public PostsView(InterfaceView.Posts mInterfacePostsView) {
        this.mInterfacePostsView = mInterfacePostsView;
    }

    public void displayListPost(List<Post> posts) {
        mPostAdapter = new PostAdapter(posts, mInterfacePostsView);
        mInterfacePostsView.setAdapterPost(mPostAdapter);
    }
}
