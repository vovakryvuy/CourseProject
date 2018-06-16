package kryvyy.course.pllug.om.courseproject.fragments;

import android.content.Context;
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
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.presenter.CommentsRresenter;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;

/**
 * Created by vovak on 16.06.2018.
 */

public class CommentsFragment extends Fragment implements InterfacePresenter.Comments{
    public static final String ARGUMENT_ID_USER = "ARGUMENT_ID_USER";
    private CommentsRresenter mCommentsRresenter;
    private RecyclerView mRecyclerView;
    private Integer mIdUser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIdUser = getArguments().getInt(ARGUMENT_ID_USER);
        mCommentsRresenter = new CommentsRresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mCommentsRresenter.getCommentsByUser(mIdUser);
    }

    @Override
    public void setAdapterCommests(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void clickComment(Comment comment) {

    }
}
