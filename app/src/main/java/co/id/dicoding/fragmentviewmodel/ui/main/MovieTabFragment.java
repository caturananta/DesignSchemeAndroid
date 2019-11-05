package co.id.dicoding.fragmentviewmodel.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.id.dicoding.fragmentviewmodel.R;
import co.id.dicoding.fragmentviewmodel.adapter.MovieAdapter;
import co.id.dicoding.fragmentviewmodel.model.Movie;
import co.id.dicoding.fragmentviewmodel.model.MovieData;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieTabFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Movie> list = new ArrayList<>();

    public MovieTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie_tab, container, false);

        list.addAll(MovieData.getListData());

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        MovieAdapter movieAdapter = new MovieAdapter(list, getActivity());
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        return view;
    }

}
