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
import android.widget.LinearLayout;
import android.widget.TextView;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.presenter.CommentsRresenter;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.ProfilePresenter;

/**
 * Created by vovak on 09.06.2018.
 */

public class DetailByPost extends Fragment implements InterfacePresenter.Profile, InterfacePresenter.Comments {
    public static final String SERIALIZABLE_POST_KEY = "serializable_post_key";
    private ProfilePresenter mProfilePresenter;
    private CommentsRresenter mCommentsRresenter;
    private TextView mTvNameUser,tvTitlePost,tvBodyPost;
    private LinearLayout mLayoutComments;
    private RecyclerView mRvComments;
    private Post mPost;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPost = (Post) getArguments().getSerializable(SERIALIZABLE_POST_KEY);
        mProfilePresenter = new ProfilePresenter(this);
        mCommentsRresenter = new CommentsRresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_post_layout, container, false);
        initView(view);
        setDate();
        return view;
    }

    private void setDate() {
        if (mPost!=null){
            setDatePost();
            getUserInformation(mPost.getUserId());
            getComments(mPost.getId());
        }
    }

    private void getComments(Integer id) {
        mCommentsRresenter.getCommentsByPost(id);
    }

    private void getUserInformation(Integer userId) {
        mProfilePresenter.getProfileById(userId);
    }

    private void setDatePost() {
        tvTitlePost.setText(mPost.getTitle());
        tvBodyPost.setText(mPost.getBody());
    }

    private void initView(View view) {
        mTvNameUser  = view.findViewById(R.id.tvNameUser);
        tvTitlePost = view.findViewById(R.id.tvTitlePost);
        tvBodyPost = view.findViewById(R.id.tvBodyPost);
        mLayoutComments = view.findViewById(R.id.layoutComments);
        mRvComments = view.findViewById(R.id.rvComments);
        mRvComments.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setUserName(String userName) {
        mTvNameUser.setText(userName);
    }

    @Override
    public void setAdapterCommests(RecyclerView.Adapter adapter) {
        mRvComments.setAdapter(adapter);
        if (adapter.getItemCount()!=0)
        mLayoutComments.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickComment(Comment comment) {

    }
}
