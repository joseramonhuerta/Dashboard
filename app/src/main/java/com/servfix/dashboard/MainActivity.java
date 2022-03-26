package com.servfix.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager(){
        ViewPager2 moviesViewPager = findViewById(R.id.moviesViewPager);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
          float r = 1 - Math.abs(position);
          page.setScaleY(0.85f + r * 0.15f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }

    private List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();

        Movie avenger = new Movie();
        avenger.poster = R.drawable.avengers;
        avenger.name = "The Avengers";
        avenger.category = "Science Fiction";
        avenger.releaseDate = "December 22, 2022";
        avenger.rating = 4.6f;
        movies.add(avenger);

        Movie aladin = new Movie();
        aladin.poster = R.drawable.aladin;
        aladin.name = "The Aladin";
        aladin.category = "Science Fiction";
        aladin.releaseDate = "December 23, 2022";
        aladin.rating = 4.8f;
        movies.add(aladin);

        Movie jumanji = new Movie();
        jumanji.poster = R.drawable.jumanji;
        jumanji.name = "Jumanji 2";
        jumanji.category = "Science Fiction";
        jumanji.releaseDate = "December 24, 2022";
        jumanji.rating = 4.4f;
        movies.add(jumanji);

        Movie zombiland = new Movie();
        zombiland.poster = R.drawable.zombiland;
        zombiland.name = "Zombieland 3";
        zombiland.category = "Science Fiction";
        zombiland.releaseDate = "December 25, 2022";
        zombiland.rating = 4.2f;
        movies.add(zombiland);

        return movies;

    }
}