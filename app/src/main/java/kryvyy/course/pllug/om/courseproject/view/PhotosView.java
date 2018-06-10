package kryvyy.course.pllug.om.courseproject.view;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.adapter.AlbumAdapter;
import kryvyy.course.pllug.om.courseproject.adapter.PhotosAdapter;
import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Photo;

/**
 * Created by vovak on 10.06.2018.
 */

public class PhotosView {
    private InterfaceView.Photos mInterfacePhotosView;
    private PhotosAdapter mPhotosAdapter;

    public PhotosView(InterfaceView.Photos interfacePhotosView) {
        mInterfacePhotosView = interfacePhotosView;
    }

    public void displayListPhotos(List<Photo> Photos){
        mPhotosAdapter = new PhotosAdapter(Photos,mInterfacePhotosView);
        mInterfacePhotosView.setAdapterPhotos(mPhotosAdapter);
    }
}
