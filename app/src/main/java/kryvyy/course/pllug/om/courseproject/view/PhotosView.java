package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.PhotosAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;

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
