package com.example.movieuitemplate.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieuitemplate.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView imgMovie, imgCover;
    private TextView txtTitle,txtDescription;
    private String url;

    private FloatingActionButton flplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        init();
        flplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetailActivity.this,YouTubeActivity.class);
                Bundle b = new Bundle();
                b.putString("UrlVideo",url);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    void init(){
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        imgMovie = findViewById(R.id.imgFilm);
        Glide.with(this).load(b.getInt("ImgURL")).into(imgMovie);
        imgMovie.setImageResource(b.getInt("ImgURL"));

        imgCover = findViewById(R.id.imgBackground);
        Glide.with(this).load(b.getInt("ImgURLCover")).into(imgCover);
        imgCover.setImageResource(b.getInt("ImgURLCover"));

        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText(b.getString("Title"));

        txtDescription = findViewById(R.id.txtDescription);
        txtDescription.setText(b.getString("Description"));

        url = b.getString("UrlVideo");

        flplay = findViewById(R.id.fltPlay);
    }
}