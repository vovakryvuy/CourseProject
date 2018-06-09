package kryvyy.course.pllug.om.courseproject.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kryvyy.course.pllug.om.courseproject.ContactFragment;
import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.PostsPresenter;

public class PostsFragment extends Fragment implements InterfacePresenter {
    private PostsPresenter mPostsPresenter;
    private ContactFragment mContactFragment;
    private RecyclerView mRecyclerView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPostsPresenter = new PostsPresenter(this);
        mContactFragment = (ContactFragment) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPostsPresenter.getPosts();
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void clickItemPost(Post post) {
        Log.d("TAg", post.getBody());
        mContactFragment.openPost(post);
    }
}
