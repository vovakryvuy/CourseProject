package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.AlbumAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Album;

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
