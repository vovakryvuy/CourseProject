package kryvyy.course.pllug.om.courseproject.fragments;

import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

public interface ContactFragment {
    void openPost(Post post);

    void openAlbum(Album album);
}
