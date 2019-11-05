package co.id.dicoding.fragmentviewmodel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import co.id.dicoding.fragmentviewmodel.R;
import co.id.dicoding.fragmentviewmodel.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviesViewHolder> implements Filterable {

    private ArrayList<Movie> listMovie;
    private ArrayList<Movie> filterList;
    private Context mContext;

    public MovieAdapter(ArrayList<Movie> list, Context context) {
        this.listMovie = list;
        this.mContext = context;
        this.filterList = list;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder movieViewHolder, int i) {
        final Movie movie = filterList.get(i);

        movieViewHolder.movieTitle.setText(movie.getTitle());
        Glide.with(movieViewHolder.itemView.getContext())
                .load(movie.getTitle().equals("Avenger") ? R.drawable.mv_poster_avengerinfinity :
                        movie.getTitle().equals("Aquaman") ? R.drawable.mv_poster_aquaman :
                            movie.getTitle().equals("Deadpool") ? R.drawable.mv_poster_deadpool : R.drawable.mv_poster_marrypopins)
                .into(movieViewHolder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Movie> filteredResults = null;
                if (constraint.length() == 0) {
                    filteredResults = listMovie;
                } else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filterList = (ArrayList<Movie>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder {
        ImageView moviePoster;
        TextView movieTitle;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.iv);
            movieTitle = itemView.findViewById(R.id.tv);
        }
    }

    protected ArrayList<Movie> getFilteredResults(String constraint) {
        ArrayList<Movie> results = new ArrayList<>();

        for (Movie item : listMovie) {
            if (item.getTitle().toLowerCase().contains(constraint)) {
                results.add(item);
                Log.e("filtermovie", "getFilteredResults: " + item.getTitle());
            }
        }
        return results;
    }
}
