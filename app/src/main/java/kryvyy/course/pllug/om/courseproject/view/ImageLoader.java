package kryvyy.course.pllug.om.courseproject.view;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {
    private static final ImageLoader ourInstance = new ImageLoader();

    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        return ourInstance;
    }

    public void loadPhoto(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
