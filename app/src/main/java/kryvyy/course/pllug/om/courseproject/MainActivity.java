package kryvyy.course.pllug.om.courseproject;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import kryvyy.course.pllug.om.courseproject.fragments.AlbumFragment;
import kryvyy.course.pllug.om.courseproject.fragments.DetailByPostFragment;
import kryvyy.course.pllug.om.courseproject.fragments.PostsFragment;
import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Post;

import static kryvyy.course.pllug.om.courseproject.fragments.DetailByPostFragment.SERIALIZABLE_POST_KEY;

public class MainActivity extends AppCompatActivity implements ContactFragment  {
    private FragmentManager mFragmentManager;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        initFragmentContainer();
        initNavigationView();
    }

    private void initFragmentContainer() {
        if(findViewById(R.id.mainContentFrame) != null){
           /* if (savedInstanceState != null) { return;}*/
            mFragmentManager = getSupportFragmentManager();
            starFragmentSignIn();
        }
    }

    private void starFragmentSignIn() {

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
                        PostsFragment postsFragment = new PostsFragment();
                        mFragmentManager.beginTransaction()
                                .replace(R.id.mainContentFrame, postsFragment).commit();
                        break;
                    case R.id.nav_comments:

                        break;
                    case R.id.nav_albums:
                        AlbumFragment albumFragment = new AlbumFragment();
                        mFragmentManager.beginTransaction()
                                .replace(R.id.mainContentFrame, albumFragment).commit();
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


    @Override
    public void openPost(Post post) {
        DetailByPostFragment detailByPostFragment = new DetailByPostFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(SERIALIZABLE_POST_KEY, post);
        detailByPostFragment.setArguments(bundle);

        mFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.mainContentFrame, detailByPostFragment).commit();
    }
}
