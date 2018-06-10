package kryvyy.course.pllug.om.courseproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.ImageLoader;
import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.view.InterfaceView;

/**
 * Created by vovak on 10.06.2018.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> implements ClickCallback{
    private List<Photo> mPhotoList;
    private InterfaceView.Photos mInterfacePhotosView;
    private ImageLoader mImageLoader;

    public PhotosAdapter(List<Photo> PhotoList, InterfaceView.Photos itemClickListener) {
        this.mPhotoList = PhotoList;
        mInterfacePhotosView = itemClickListener;
        mImageLoader = ImageLoader.getInstance();
    }

    @NonNull
    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);
        return new PhotosAdapter.ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.ViewHolder holder, int position) {
        setPhoto(holder.mIvPhoto,position);
        holder.mTvPhotoTitle.setText(getPhotoTitle(position));
    }

    private String getPhotoTitle(int position) {
        String title;
        title = mPhotoList.get(position).getTitle();
        return title;
    }

    private void setPhoto(ImageView mIvPhoto, int position) {
        mImageLoader.loadPhoto(mIvPhoto,mPhotoList.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    @Override
    public void clickCallback(int item) {
        mInterfacePhotosView.itemClickListener(mPhotoList.get(item));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private ClickCallback mClickCallBack;
        public ImageView mIvPhoto;
        public TextView mTvPhotoTitle;


        public ViewHolder(View itemView,ClickCallback clickCallBack) {
            super(itemView);
            mClickCallBack = clickCallBack;
            itemView(itemView);
            itemView.setOnClickListener(this);
        }

        private void itemView(View itemView) {
            mIvPhoto = itemView.findViewById(R.id.ivPhoto);
            mTvPhotoTitle = itemView.findViewById(R.id.tvPhotoTitle);
        }

        @Override
        public void onClick(View v) {
            mClickCallBack.clickCallback(getAdapterPosition());
        }
    }
}
