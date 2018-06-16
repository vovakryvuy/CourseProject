package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.PhotosAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.repositories.PhotosRepository;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.view.InterfaceView;
import kryvyy.course.pllug.om.courseproject.view.PhotosView;

/**
 * Created by vovak on 03.06.2018.
 */

public class PhotosPresenter implements InterfaceRepository.Images, InterfaceView.Photos {
    private PhotosRepository mPhotosRepository;
    private InterfacePresenter.Photos mInterfacePhotoPresenter;
    private PhotosView mPhotosView;

    public PhotosPresenter(InterfacePresenter.Photos interfacePhotoPresenter) {
        mInterfacePhotoPresenter = interfacePhotoPresenter;
        mPhotosRepository = new PhotosRepository(this);
        mPhotosView = new PhotosView(this);
    }

    public void getPhotosByAlbum(Integer idAlbum){
        mPhotosRepository.getImageFromAlbum(idAlbum);
    }

    public void getPhotosByUser(Integer idUser){
        mPhotosRepository.getImageFromUserAlbum(idUser);
    }

    @Override
    public void getImage(Photo photo) {

    }

    @Override
    public void getImages(List<Photo> photos) {
        mPhotosView.displayListPhotos(photos);
    }

    @Override
    public void setAdapterPhotos(PhotosAdapter adapterPhotos) {
        mInterfacePhotoPresenter.setAdapterPhotos(adapterPhotos);
    }

    @Override
    public void itemClickListener(Photo photo) {
        mInterfacePhotoPresenter.clickPhoto(photo);
    }
}
