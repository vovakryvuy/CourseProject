package kryvyy.course.pllug.om.courseproject.ui.main.photo;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.data.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfaceView;

public class PhotosView {
    private InterfaceView.Photos mInterfacePhotosView;
    private PhotosAdapter mPhotosAdapter;

    public PhotosView(InterfaceView.Photos interfacePhotosView) {
        mInterfacePhotosView = interfacePhotosView;
    }

    public void displayListPhotos(List<Photo> Photos) {
        mPhotosAdapter = new PhotosAdapter(Photos, mInterfacePhotosView);
        mInterfacePhotosView.setAdapterPhotos(mPhotosAdapter);
    }
}
