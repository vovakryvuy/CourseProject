package kryvyy.course.pllug.om.courseproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

/**
 * Created by vovak on 03.06.2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> mPostList;

    public PostAdapter(List<Post> mPostList) {
        this.mPostList = mPostList;
    }

    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
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

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTvTitle;
        public TextView mTvBody;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView(itemView);
        }

        private void itemView(View itemView) {
            mTvTitle = itemView.findViewById(R.id.tvItemTitle);
            mTvBody = itemView.findViewById(R.id.tvItemBody);
        }
    }
}
