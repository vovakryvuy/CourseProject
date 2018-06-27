package kryvyy.course.pllug.om.courseproject.ui.main.album;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.data.repositories.AlbumRepository;
import kryvyy.course.pllug.om.courseproject.data.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class AlbumPresenter implements InterfaceRepository.Albums, InterfaceView.Albums {
    private AlbumRepository mAlbumRepository;
    private InterfacePresenter.Albums mInterfaceAlbumsPresenter;
    private AlbumsView mAlbumsView;

    public AlbumPresenter(InterfacePresenter.Albums interfaceAlbumsPresenter) {
        mInterfaceAlbumsPresenter = interfaceAlbumsPresenter;
        mAlbumRepository = new AlbumRepository(this);
        mAlbumsView = new AlbumsView(this);
    }

    public void getAlbums() {
        mAlbumRepository.getAllAlbums();
    }

    @Override
    public void getAlbum(Album album) {

    }

    @Override
    public void getAlbums(List<Album> albums) {
        mAlbumsView.displayListAlbums(albums);
    }

    @Override
    public void setAdapterAlbums(AlbumAdapter adpterAlbums) {
        mInterfaceAlbumsPresenter.setAdapterAlbum(adpterAlbums);
    }

    @Override
    public void itemClickListener(Album album) {
        mInterfaceAlbumsPresenter.clickAlbum(album);
    }
}