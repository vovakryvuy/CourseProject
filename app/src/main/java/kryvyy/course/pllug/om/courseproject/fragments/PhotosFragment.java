package kryvyy.course.pllug.om.courseproject.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.presenter.AlbumPresenter;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.PhotosPresenter;

/**
 * Created by vovak on 10.06.2018.
 */

public class PhotosFragment extends Fragment implements InterfacePresenter.Photos{
    public static final String ARGUMENT_ID_ALBUM_KEY = "ARGUMENT_ID_ALBUM_KEY";
    private PhotosPresenter mPhotosPresenter;
    private RecyclerView mRecyclerView;
    private Integer mIdAlbum = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIdAlbum = getArguments().getInt(ARGUMENT_ID_ALBUM_KEY);
        mPhotosPresenter = new PhotosPresenter(this);
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
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mPhotosPresenter.getPhotosByAlbum(mIdAlbum);
    }

    @Override
    public void setAdapterPhotos(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void clickPhoto(Photo photo) {

    }

}
