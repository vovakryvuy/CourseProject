package kryvyy.course.pllug.om.courseproject.ui.main.album;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.databinding.FragmentLayoutBinding;
import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceFragment;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;

public class AlbumFragment extends Fragment implements InterfacePresenter.Albums {
    private AlbumPresenter mAlbumPresenter;
    private InterfaceFragment mInterfaceFragment;
    private FragmentLayoutBinding binding;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAlbumPresenter = new AlbumPresenter(this);
        mInterfaceFragment = (InterfaceFragment) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layout, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {
        binding.recycleView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        mAlbumPresenter.getAlbums();
    }

    @Override
    public void setAdapterAlbum(RecyclerView.Adapter adapter) {
        binding.recycleView.setAdapter(adapter);
        binding.progressBar.setVisibility(View.GONE);
        binding.recycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickAlbum(Album album) {
        mInterfaceFragment.openAlbum(album);
    }
}
