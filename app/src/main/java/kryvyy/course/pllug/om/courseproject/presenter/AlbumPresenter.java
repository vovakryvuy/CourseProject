package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.repositories.AlbumRepository;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;

/**
 * Created by vovak on 03.06.2018.
 */

public class AlbumPresenter implements InterfaceRepository.Albums {
    private AlbumRepository mAlbumRepository;

    public AlbumPresenter(AlbumRepository mAlbumRepository) {
        this.mAlbumRepository = mAlbumRepository;
    }

    @Override
    public void getAlbum(Album album) {

    }

    @Override
    public void getAlbums(List<Album> albums) {

    }
}
