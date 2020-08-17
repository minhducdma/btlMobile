package com.example.movieuitemplate.adapter;

import android.widget.ImageView;

import com.example.movieuitemplate.model.Movie;

public interface MovieItemClickListener {
    void onMovieClick(Movie movie, ImageView movieImageView);
}

