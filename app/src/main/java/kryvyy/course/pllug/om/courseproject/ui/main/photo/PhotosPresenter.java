package kryvyy.course.pllug.om.courseproject.ui.main.photo;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.data.repositories.InterfaceRepository;
import kryvyy.course.pllug.om.courseproject.data.repositories.PhotosRepository;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class PhotosPresenter implements InterfaceRepository.Images, InterfaceView.Photos {
    private PhotosRepository mPhotosRepository;
    private InterfacePresenter.Photos mInterfacePhotoPresenter;
    private PhotosView mPhotosView;

    public PhotosPresenter(InterfacePresenter.Photos interfacePhotoPresenter) {
        mInterfacePhotoPresenter = interfacePhotoPresenter;
        mPhotosRepository = new PhotosRepository(this);
        mPhotosView = new PhotosView(this);
    }

    public void getPhotosByAlbum(Integer idAlbum) {
        mPhotosRepository.getImageFromAlbum(idAlbum);
    }

    public void getPhotosByUser(Integer idUser) {
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
