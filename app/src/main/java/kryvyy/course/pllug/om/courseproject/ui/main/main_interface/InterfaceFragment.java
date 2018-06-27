package kryvyy.course.pllug.om.courseproject.ui.main.main_interface;

import kryvyy.course.pllug.om.courseproject.data.model_response.Album;
import kryvyy.course.pllug.om.courseproject.data.model_response.Post;

public interface InterfaceFragment {
    void openPost(Post post);

    void openAlbum(Album album);
}
