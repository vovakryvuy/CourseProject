package kryvyy.course.pllug.om.courseproject.fragments;


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
import kryvyy.course.pllug.om.courseproject.databinding.FragmentLayoutBinding;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.PhotosPresenter;

public class PhotosFragment extends Fragment implements InterfacePresenter.Photos {
    public static final String ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY = "ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY";
    public static final String ARGUMENT_FOR_PHOTOS_ID_USER = "ARGUMENT_FOR_PHOTOS_ID_USER";
    private PhotosPresenter mPhotosPresenter;
    private Integer mIdAlbum;
    private Integer mIdUser;
    private FragmentLayoutBinding binding;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layout, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        getPhotos();
    }

    private void getPhotos() {
        if (mIdAlbum != null && mIdAlbum != 0)
            mPhotosPresenter.getPhotosByAlbum(mIdAlbum);
        else if (mIdUser != null && mIdUser != 0)
            mPhotosPresenter.getPhotosByUser(mIdUser);
    }

    @Override
    public void setAdapterPhotos(RecyclerView.Adapter adapter) {
        binding.recycleView.setAdapter(adapter);
        binding.progressBar.setVisibility(View.GONE);
        binding.recycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickPhoto(Photo photo) {

    }

}
