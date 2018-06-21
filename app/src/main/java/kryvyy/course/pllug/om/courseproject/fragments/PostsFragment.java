package kryvyy.course.pllug.om.courseproject.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
import kryvyy.course.pllug.om.courseproject.databinding.FragmentLayoutBinding;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.PostsPresenter;

public class PostsFragment extends Fragment implements InterfacePresenter {
    private PostsPresenter mPostsPresenter;
    private ContactFragment mContactFragment;
    private FragmentLayoutBinding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layout, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPostsPresenter.getPosts();
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        binding.recycleView.setAdapter(adapter);
        binding.progressBar.setVisibility(View.GONE);
        binding.recycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickItemPost(Post post) {
        Log.d("TAg", post.getBody());
        mContactFragment.openPost(post);
    }
}
