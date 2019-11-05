package co.id.dicoding.fragmentviewmodel.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import co.id.dicoding.fragmentviewmodel.R;
import co.id.dicoding.fragmentviewmodel.adapter.MovieAdapter;
import co.id.dicoding.fragmentviewmodel.adapter.PageAdapter;
import co.id.dicoding.fragmentviewmodel.model.Movie;
import co.id.dicoding.fragmentviewmodel.model.MovieData;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private CarouselView carouselView;
    private final String TAG = MainFragment.class.getSimpleName();
    private Integer[] images = {R.drawable.banner_avengers, R.drawable.banner_joker2, R.drawable.banner_antman};
    private Integer[] movieImages = {R.drawable.mv_poster_aquaman, R.drawable.mv_poster_avengerinfinity, R.drawable.mv_poster_deadpool, R.drawable.mv_poster_marrypopins};
    private RecyclerView recyclerView;
    private ArrayList<Movie> list = new ArrayList<>();
    TabLayout tabLayout;
    TabItem tabMovie, tabTvShow;
    ViewPager viewPager;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.htab_viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) view.findViewById(R.id.htab_tabs);
        tabs.setupWithViewPager(viewPager);

        //        CarouselView
        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setImageListener(imageListener);
        carouselView.setPageCount(images.length);
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "Clicked item: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        list.addAll(MovieData.getListData());

//        Recyclerview
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        MovieAdapter movieAdapter = new MovieAdapter(list, getActivity());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        return view;
    }

    private void setupViewPager(ViewPager viewPager) {

        PageAdapter adapter = new PageAdapter(getChildFragmentManager());
        adapter.addFragment(new MovieTabFragment(), getString(R.string.content_movie));
        adapter.addFragment(new TvShowTabFragment(), getString(R.string.content_tv_shows));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };
}
