package kryvyy.course.pllug.om.courseproject.ui.main.album;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.ClickCallback;
import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

/**
 * Created by vovak on 09.06.2018.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> implements ClickCallback {
    private List<Album> mAlbumList;
    private InterfaceView.Albums mInterfaceAlbumsView;

    public AlbumAdapter(List<Album> albumList, InterfaceView.Albums itemClickListener) {
        this.mAlbumList = albumList;
        mInterfaceAlbumsView = itemClickListener;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album,parent,false);
        return new AlbumAdapter.ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvNameAlbum.setText(getNameAlbum(position));
    }

    private String getNameAlbum(int position) {
        String title = mAlbumList.get(position).getTitle();
        return title;
    }

    @Override
    public int getItemCount() {
        return mAlbumList.size();
    }

    @Override
    public void clickCallback(int item) {
        mInterfaceAlbumsView.itemClickListener(mAlbumList.get(item));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private ClickCallback mClickCallBack;
        public TextView mTvNameAlbum;

        public ViewHolder(View itemView,ClickCallback clickCallBack) {
            super(itemView);
            mClickCallBack = clickCallBack;
            itemView(itemView);
            itemView.setOnClickListener(this);
        }

        private void itemView(View itemView) {
            mTvNameAlbum = itemView.findViewById(R.id.tvNameAlbum);
        }

        @Override
        public void onClick(View v) {
            mClickCallBack.clickCallback(getAdapterPosition());
        }
    }
}
