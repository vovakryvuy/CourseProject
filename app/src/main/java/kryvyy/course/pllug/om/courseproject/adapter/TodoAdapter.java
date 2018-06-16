package kryvyy.course.pllug.om.courseproject.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.view.InterfaceView;

/**
 * Created by vovak on 16.06.2018.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> implements ClickCallback{
    private List<Todo> mTodoList;
    private InterfaceView.Todos mInterfaceTodosView;

    public TodoAdapter(List<Todo> mTodoList,InterfaceView.Todos itemClickListener) {
        this.mTodoList = mTodoList;
        mInterfaceTodosView = itemClickListener;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo,parent,false);
        return new TodoAdapter.ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvTitle.setText(getTitle(position));
    }

    private String getTitle(int position) {
        return mTodoList.get(position).getTitle();
    }

    @Override
    public int getItemCount() {
        return mTodoList.size();
    }

    @Override
    public void clickCallback(int item) {
        mInterfaceTodosView.itemClickListener(mTodoList.get(item));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private ClickCallback mClickCallBack;
        public TextView mTvTitle;

        public ViewHolder(View itemView,ClickCallback clickCallBack) {
            super(itemView);
            mClickCallBack = clickCallBack;
            itemView(itemView);
            itemView.setOnClickListener(this);

        }

        private void itemView(View itemView) {
            mTvTitle = itemView.findViewById(R.id.tvTitle);
        }

        @Override
        public void onClick(View v) {
            mClickCallBack.clickCallback(getAdapterPosition());
        }
    }
}
