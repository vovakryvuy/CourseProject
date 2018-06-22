package kryvyy.course.pllug.om.courseproject;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import kryvyy.course.pllug.om.courseproject.databinding.ActivityMainBinding;
import kryvyy.course.pllug.om.courseproject.fragments.AlbumFragment;
import kryvyy.course.pllug.om.courseproject.fragments.CommentsFragment;
import kryvyy.course.pllug.om.courseproject.fragments.ContactFragment;
import kryvyy.course.pllug.om.courseproject.fragments.DetailByPostFragment;
import kryvyy.course.pllug.om.courseproject.fragments.PhotosFragment;
import kryvyy.course.pllug.om.courseproject.fragments.PostsFragment;
import kryvyy.course.pllug.om.courseproject.fragments.ProfileFragment;
import kryvyy.course.pllug.om.courseproject.fragments.TodosFragment;
import kryvyy.course.pllug.om.courseproject.model_response.Album;
import kryvyy.course.pllug.om.courseproject.model_response.Post;
import kryvyy.course.pllug.om.courseproject.shared_preferences.PreferencesSignIn;

import static kryvyy.course.pllug.om.courseproject.fragments.CommentsFragment.ARGUMENT_FOR_COMMENTS_ID_USER;
import static kryvyy.course.pllug.om.courseproject.fragments.DetailByPostFragment.SERIALIZABLE_POST_KEY;
import static kryvyy.course.pllug.om.courseproject.fragments.PhotosFragment.ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY;
import static kryvyy.course.pllug.om.courseproject.fragments.PhotosFragment.ARGUMENT_FOR_PHOTOS_ID_USER;
import static kryvyy.course.pllug.om.courseproject.fragments.TodosFragment.AGRGUMENT_FOR_TODOS_USER_ID;

public class MainActivity extends AppCompatActivity implements ContactFragment {
    private FragmentManager mFragmentManager;
    private DrawerLayout mDrawerLayout;
    private ActivityMainBinding binding;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        initToolbar();
        initFragmentContainer();
        initNavigationView();
    }

    private void initToolbar() {
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setDisplayUseLogoEnabled(true);
        mActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mActionBar.setBackgroundDrawable(getDrawable(R.drawable.background_gradient));
    }

    private void initFragmentContainer() {
        if (findViewById(R.id.mainContentFrame) != null) {
            mFragmentManager = getSupportFragmentManager();
            starFragment();
        }
    }

    private void starFragment() {
        setFragmentInContainer(new ProfileFragment());
        mActionBar.setTitle(R.string.profile);
    }

    private void initNavigationView() {
        binding.navigationView.setNavigationItemSelectedListener(item -> {
            item.setChecked(true);
            switch (item.getItemId()) {
                case R.id.nav_profile:
                    setFragmentInContainer(new ProfileFragment());
                    mActionBar.setTitle(R.string.profile);
                    break;
                case R.id.nav_posts:
                    setFragmentInContainer(new PostsFragment());
                    mActionBar.setTitle(R.string.posts);
                    break;
                case R.id.nav_comments:
                    CommentsFragment commentsFragment = new CommentsFragment();
                    Bundle bundleComments = new Bundle();
                    // user id
                    bundleComments.putInt(ARGUMENT_FOR_COMMENTS_ID_USER, 1);
                    commentsFragment.setArguments(bundleComments);
                    setFragmentInContainer(commentsFragment);
                    mActionBar.setTitle(R.string.my_comments);
                    break;
                case R.id.nav_albums:
                    setFragmentInContainer(new AlbumFragment());
                    mActionBar.setTitle(R.string.albums);
                    break;
                case R.id.nav_images:
                    PhotosFragment photosFragment = new PhotosFragment();
                    Bundle bundlePhotos = new Bundle();
                    // user id
                    bundlePhotos.putInt(ARGUMENT_FOR_PHOTOS_ID_USER, 1);
                    photosFragment.setArguments(bundlePhotos);
                    setFragmentInContainer(photosFragment);
                    mActionBar.setTitle(R.string.my_images);
                    break;
                case R.id.nav_todos:
                    TodosFragment todosFragment = new TodosFragment();
                    Bundle bundleTodos = new Bundle();
                    // user id
                    bundleTodos.putInt(AGRGUMENT_FOR_TODOS_USER_ID, 1);
                    todosFragment.setArguments(bundleTodos);
                    setFragmentInContainer(todosFragment);
                    mActionBar.setTitle(R.string.my_todos);
                    break;
            }
            mDrawerLayout.closeDrawers();
            return true;
        });
    }

    private void setFragmentInContainer(Fragment fragment) {
        if (mFragmentManager != null) {
            mFragmentManager.beginTransaction().replace(R.id.mainContentFrame, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                if (binding.drawerLayout.isDrawerOpen(Gravity.START))
                    binding.drawerLayout.closeDrawers();
                else
                    binding.drawerLayout.openDrawer(Gravity.START);
                break;
            case R.id.log_out:
                logOut();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void logOut() {
        PreferencesSignIn.getInstance(this).setActiveSession(false);
        Intent intent = new Intent(this, AuthorizationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
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

    @Override
    public void openAlbum(Album album) {
        PhotosFragment photosFragment = new PhotosFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ARGUMENT_FOR_PHOTOS_ID_ALBUM_KEY, album.getId());
        photosFragment.setArguments(bundle);

        mFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.mainContentFrame, photosFragment).commit();
    }
}
