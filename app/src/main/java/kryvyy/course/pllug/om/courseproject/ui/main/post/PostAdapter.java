package kryvyy.course.pllug.om.courseproject.ui.main.post;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.ClickCallback;
import kryvyy.course.pllug.om.courseproject.data.model_response.Post;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

/**
 * Created by vovak on 03.06.2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> implements ClickCallback {
    private List<Post> mPostList;
    private InterfaceView.Posts mInterfacePostsView;

    public PostAdapter(List<Post> mPostList,InterfaceView.Posts itemClickListener) {
        this.mPostList = mPostList;
        mInterfacePostsView = itemClickListener;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvTitle.setText(getTitle(position));
        holder.mTvBody.setText(getBody(position));
    }

    private String getTitle(int position) {
        String title = mPostList.get(position).getTitle();
        return title;
    }

    private String getBody(int position) {
        String body = mPostList.get(position).getBody();
        return body;
    }

    @Override
    public int getItemCount() {
        return mPostList.size();
    }

    @Override
    public void clickCallback(int item) {
        mInterfacePostsView.itemClickListener(mPostList.get(item));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private ClickCallback mClickCallBack;
        public TextView mTvTitle;
        public TextView mTvBody;

        public ViewHolder(View itemView,ClickCallback clickCallBack) {
            super(itemView);
            mClickCallBack = clickCallBack;
            itemView(itemView);
            itemView.setOnClickListener(this);

        }

        private void itemView(View itemView) {
            mTvTitle = itemView.findViewById(R.id.tvItemTitle);
            mTvBody = itemView.findViewById(R.id.tvItemBody);
        }

        @Override
        public void onClick(View v) {
            mClickCallBack.clickCallback(getAdapterPosition());
        }
    }
}
