package kryvyy.course.pllug.om.courseproject.fragments;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.databinding.FragmentLayoutBinding;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.presenter.CommentsRresenter;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;

public class CommentsFragment extends Fragment implements InterfacePresenter.Comments {
    public static final String ARGUMENT_FOR_COMMENTS_ID_USER = "ARGUMENT_FOR_COMMENTS_ID_USER";
    private CommentsRresenter mCommentsRresenter;
    private Integer mIdUser;
    private FragmentLayoutBinding binding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIdUser = getArguments().getInt(ARGUMENT_FOR_COMMENTS_ID_USER);
        mCommentsRresenter = new CommentsRresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layout, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCommentsRresenter.getCommentsByUser(mIdUser);
    }

    @Override
    public void setAdapterCommests(RecyclerView.Adapter adapter) {
        binding.recycleView.setAdapter(adapter);
        binding.progressBar.setVisibility(View.GONE);
        binding.recycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickComment(Comment comment) {

    }
}
