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

import kryvyy.course.pllug.om.courseproject.ContactFragment;
import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.presenter.AlbumPresenter;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;


public class AlbumFragment extends Fragment implements InterfacePresenter.Albums {
    private AlbumPresenter mAlbumPresenter;
    private RecyclerView mRecyclerView;
    private ContactFragment mContactFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mAlbumPresenter = new AlbumPresenter(this);
        mContactFragment = (ContactFragment) context;
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
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mAlbumPresenter.getAlbums();
    }

    @Override
    public void setAdapterAlbum(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void clickAlbum(Album album) {
        mContactFragment.openAlbum(album);
    }
}
