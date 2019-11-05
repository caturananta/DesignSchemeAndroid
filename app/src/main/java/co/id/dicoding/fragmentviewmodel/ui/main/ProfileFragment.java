package co.id.dicoding.fragmentviewmodel.ui.main;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.id.dicoding.fragmentviewmodel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    Button btnIg;
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnIg = (Button) view.findViewById(R.id.btnInstagram);
        btnIg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnInstagram) {
            Uri uri = Uri.parse("https://www.instagram.com/catur_ananta/");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/catur_ananta/")));
            }
        }
    }
}
