package co.id.dicoding.fragmentviewmodel.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import co.id.dicoding.fragmentviewmodel.R;
import co.id.dicoding.fragmentviewmodel.ui.main.FavoriteFragment;
import co.id.dicoding.fragmentviewmodel.ui.main.MainFragment;
import co.id.dicoding.fragmentviewmodel.ui.main.ProfileFragment;
import co.id.dicoding.fragmentviewmodel.ui.main.SearchFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        BottomNavigationView navView = findViewById(R.id.navigation);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(getColor(R.color.white));
        }
        if (savedInstanceState == null) {
            navView.setSelectedItemId(R.id.nav_home);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, MainFragment.newInstance())
                            .commitNow();
                    return true;
                case R.id.nav_search:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, SearchFragment.newInstance())
                            .commitNow();
                    return true;
                case R.id.nav_favorite:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, FavoriteFragment.newInstance())
                            .commitNow();
                    return true;
                case R.id.nav_profile:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, ProfileFragment.newInstance())
                            .commitNow();
                    return true;
            }
            return false;
        }
    };
}
