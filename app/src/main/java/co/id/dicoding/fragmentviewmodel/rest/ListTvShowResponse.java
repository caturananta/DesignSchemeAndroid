package co.id.dicoding.fragmentviewmodel.rest;

import java.util.ArrayList;

import co.id.dicoding.fragmentviewmodel.model.TvShow;

public class ListTvShowResponse {

    private ArrayList<TvShow> results;

    public ArrayList<TvShow> getResults() {
        return results;
    }

    public void setResults(ArrayList<TvShow> results) {
        this.results = results;
    }
}
