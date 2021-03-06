package kryvyy.course.pllug.om.courseproject.presenter;

import java.util.List;

import kryvyy.course.pllug.om.courseproject.model_response.Photo;
import kryvyy.course.pllug.om.courseproject.repositories.ImageRepository;
import kryvyy.course.pllug.om.courseproject.repositories.InterfaceRepository;

/**
 * Created by vovak on 03.06.2018.
 */

public class ImagesPresenter implements InterfaceRepository.Images {
    private ImageRepository mImageRepository;

    public ImagesPresenter() {
        mImageRepository = new ImageRepository(this);
    }

    @Override
    public void getImage(Photo photo) {

    }

    @Override
    public void getImages(List<Photo> photos) {

    }
}
