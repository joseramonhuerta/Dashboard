package com.servfix.dashboard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>{

    private final List<Movie> movies;
    //private final MoviesListerner moviesListerner;

    public MoviesAdapter(List<Movie> movies){
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new MovieViewHolder(
                 LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_movie,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesAdapter.MovieViewHolder holder, int position){
        holder.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount(){
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{

       private final RoundedImageView imagePoster;
       private final TextView textName, textCategory, textReleaseDate;
       private final RatingBar ratingBar;

        MovieViewHolder(View view){
            super(view);
            imagePoster = view.findViewById(R.id.imagePoster);
            textName = view.findViewById(R.id.textName);
            textCategory = view.findViewById(R.id.textCategory);
            textReleaseDate = view.findViewById(R.id.textReleaseDate);
            ratingBar = view.findViewById(R.id.ratingBar);
        }

        void setMovie(Movie movie){
            imagePoster.setImageResource(movie.poster);
            textName.setText(movie.name);
            textCategory.setText(movie.category);
            textReleaseDate.setText(movie.releaseDate);
            ratingBar.setRating(movie.rating);
        }

    }

    private Bitmap getConversionImage(String encodedImage){
        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}