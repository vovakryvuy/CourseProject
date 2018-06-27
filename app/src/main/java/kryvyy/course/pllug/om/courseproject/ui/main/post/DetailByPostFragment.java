package kryvyy.course.pllug.om.courseproject.ui.main.post;


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
import kryvyy.course.pllug.om.courseproject.databinding.FragmentDetailPostLayoutBinding;
import kryvyy.course.pllug.om.courseproject.data.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.data.model_response.Post;
import kryvyy.course.pllug.om.courseproject.data.model_response.profile.Profile;
import kryvyy.course.pllug.om.courseproject.ui.main.comment.CommentsRresenter;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.ui.main.profile.ProfilePresenter;

public class DetailByPostFragment extends Fragment implements InterfacePresenter.Profiles, InterfacePresenter.Comments {
    public static final String SERIALIZABLE_POST_KEY = "serializable_post_key";
    private ProfilePresenter mProfilePresenter;
    private CommentsRresenter mCommentsRresenter;
    private Post mPost;
    private FragmentDetailPostLayoutBinding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_post_layout, container, false);
        initView();
        setDate();
        return binding.getRoot();
    }

    private void setDate() {
        if (mPost != null) {
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
        binding.tvTitlePost.setText(mPost.getTitle());
        binding.tvBodyPost.setText(mPost.getBody());
    }

    private void initView() {
        binding.rvComments.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setAdapterCommests(RecyclerView.Adapter adapter) {
        binding.rvComments.setAdapter(adapter);
        if (adapter.getItemCount() != 0)
            binding.progressBar.setVisibility(View.GONE);
        binding.layoutComments.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickComment(Comment comment) {

    }

    @Override
    public void setProfile(Profile profile) {
        binding.tvNameUser.setText(profile.getUsername());
    }
}
