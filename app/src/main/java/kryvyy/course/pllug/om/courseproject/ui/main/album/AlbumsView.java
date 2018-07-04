package kryvyy.course.pllug.om.courseproject.ui.main.album;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class AlbumsView {
    private InterfaceView.Albums mInterfaceAlbumsView;
    private AlbumAdapter mAlbumsAdapter;

    public AlbumsView(InterfaceView.Albums interfaceAlbumsView) {
        mInterfaceAlbumsView = interfaceAlbumsView;
    }

    public void displayListAlbums(List<Album> albums) {
        mAlbumsAdapter = new AlbumAdapter(albums, mInterfaceAlbumsView);
        mInterfaceAlbumsView.setAdapterAlbums(mAlbumsAdapter);
    }
}
