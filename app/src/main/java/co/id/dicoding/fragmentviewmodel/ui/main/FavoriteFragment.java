package co.id.dicoding.fragmentviewmodel.ui.main;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.id.dicoding.fragmentviewmodel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {


    public static FavoriteFragment newInstance() {
        return new FavoriteFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

}
