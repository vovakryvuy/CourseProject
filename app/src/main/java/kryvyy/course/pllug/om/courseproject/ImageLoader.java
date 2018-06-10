package kryvyy.course.pllug.om.courseproject;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by vovak on 10.06.2018.
 */

public class ImageLoader {
    private static final ImageLoader ourInstance = new ImageLoader();

    public static ImageLoader getInstance() {
        return ourInstance;
    }

    private ImageLoader() {
    }

    public void loadPhoto(ImageView imageView,String url){
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
