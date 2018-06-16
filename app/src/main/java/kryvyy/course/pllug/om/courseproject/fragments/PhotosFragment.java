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
    public static final String ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY = "ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY";
    public static final String ARGUMENT_FOR_PHOTOS_ID_USER = "ARGUMENT_FOR_PHOTOS_ID_USER";
    private PhotosPresenter mPhotosPresenter;
    private RecyclerView mRecyclerView;
    private Integer mIdAlbum;
    private Integer mIdUser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIdAlbum = getArguments().getInt(ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY);
        mIdUser = getArguments().getInt(ARGUMENT_FOR_PHOTOS_ID_USER);
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
        getPhotos();

    }

    private void getPhotos() {
        if (mIdAlbum!=null && mIdAlbum != 0)
            mPhotosPresenter.getPhotosByAlbum(mIdAlbum);
        else if (mIdUser!=null && mIdUser != 0)
            mPhotosPresenter.getPhotosByUser(mIdUser);
    }

    @Override
    public void setAdapterPhotos(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void clickPhoto(Photo photo) {

    }

}