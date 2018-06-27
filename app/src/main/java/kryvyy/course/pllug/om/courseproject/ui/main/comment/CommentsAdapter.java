package kryvyy.course.pllug.om.courseproject.ui.main.comment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.ClickCallback;
import kryvyy.course.pllug.om.courseproject.data.model_response.Comment;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

/**
 * Created by vovak on 09.06.2018.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> implements ClickCallback {
    private List<Comment> mCommentList;
    private InterfaceView.Comments mInterfaceCommentsView;

    public CommentsAdapter(List<Comment> commentList,InterfaceView.Comments itemClickListener) {
        mCommentList = commentList;
        mInterfaceCommentsView = itemClickListener;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        return new CommentsAdapter.ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvTitleComment.setText(getTitle(position));
        holder.mTvEmailComment.setText(getEmail(position));
        holder.mTvBodyComment.setText(getBody(position));
    }

    private String getTitle(int position) {
        String title = mCommentList.get(position).getName();
        return title;
    }

    private String getEmail(int position) {
        String email = mCommentList.get(position).getEmail();
        return email;
    }

    private String getBody(int position) {
        String body = mCommentList.get(position).getBody();
        return body;
    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }

    @Override
    public void clickCallback(int item) {
        mInterfaceCommentsView.itemClickListner(mCommentList.get(item));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private ClickCallback mClickCallBack;
        public TextView mTvTitleComment,mTvEmailComment,mTvBodyComment;

        public ViewHolder(View itemView,ClickCallback clickCallBack) {
            super(itemView);
            mClickCallBack = clickCallBack;
            itemView(itemView);
            itemView.setOnClickListener(this);

        }

        private void itemView(View itemView) {
            mTvTitleComment = itemView.findViewById(R.id.tvTitleComment);
            mTvEmailComment = itemView.findViewById(R.id.tvEmailComment);
            mTvBodyComment = itemView.findViewById(R.id.tvBodyComment);
        }

        @Override
        public void onClick(View v) {
            mClickCallBack.clickCallback(getAdapterPosition());
        }
    }
}
