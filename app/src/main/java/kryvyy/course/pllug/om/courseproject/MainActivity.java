package kryvyy.course.pllug.om.courseproject;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import kryvyy.course.pllug.om.courseproject.model.Album;
import kryvyy.course.pllug.om.courseproject.repositories.AlbumRepository;
import kryvyy.course.pllug.om.courseproject.repositories.ImageRepository;
import kryvyy.course.pllug.om.courseproject.repositories.ProfileRepository;
import kryvyy.course.pllug.om.courseproject.service_retrofit.ServiceRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        initNavigationView();

        /////////
        testResponse();
    }

    private void testResponse() {
        ProfileRepository.getInstance().getProfiles();
    }

    private void initNavigationView() {
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()){
                    case R.id.nav_profile:

                        break;
                    case R.id.nav_posts:

                        break;
                    case R.id.nav_comments:

                        break;
                    case R.id.nav_albums:

                        break;
                    case R.id.nav_images:

                        break;
                    case R.id.nav_todos:

                        break;
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

}
