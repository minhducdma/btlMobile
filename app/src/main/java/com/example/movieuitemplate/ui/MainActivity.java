package com.example.movieuitemplate.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.movieuitemplate.adapter.ListAdapter;
import com.example.movieuitemplate.adapter.SliderItemClickListener;
import com.example.movieuitemplate.model.Movie;
import com.example.movieuitemplate.adapter.MovieAdapter;
import com.example.movieuitemplate.adapter.MovieItemClickListener;
import com.example.movieuitemplate.R;
import com.example.movieuitemplate.model.Slider;
import com.example.movieuitemplate.adapter.SliderPageAdapter;
import com.example.movieuitemplate.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener, SliderItemClickListener {

    private List<Slider> lstSlider;
    private ViewPager sliderPager;
    private TabLayout indicator;
    private RecyclerView moviesRV;
    private RecyclerView moviesWeekRV;
    private ListView moviesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataSource data = new DataSource(this);

        inits();
        initslider(data);
        initRecycleBestPopular(data);
        initRecycleWeekPopular(data);
        initListFilm(data);
    }
    private void inits() {
        indicator = findViewById(R.id.indicator);
        sliderPager = findViewById(R.id.slider_pager);
        moviesRV = findViewById(R.id.rv_movie);
        moviesWeekRV = findViewById(R.id.rv_movieThisWeek);
        moviesList = findViewById(R.id.lstViewFilm);
    }

    private void initRecycleBestPopular(DataSource data) {
        //Set Thumbnail Image Recycle
        MovieAdapter adapterMovie = new MovieAdapter(this,data.GetListPopular(),this);
        moviesRV.setAdapter(adapterMovie);
        moviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initRecycleWeekPopular(DataSource data){
        //Set Thumbnail Image Recycle
        MovieAdapter adapterMovie = new MovieAdapter(this,data.GetListWeek(),this);
        moviesWeekRV.setAdapter(adapterMovie);
        moviesWeekRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    private void initslider(DataSource data) {


        lstSlider = data.GetSlider();
        //Set Slider
        SliderPageAdapter adapter = new SliderPageAdapter(this,lstSlider,this);
        sliderPager.setAdapter(adapter);

        //Set Slider auto slide
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(sliderPager,true);
    }

    private void initListFilm(DataSource data){
        final List<Movie> lstMovie = data.GetListPopular();

        ListAdapter myListAdapter= new ListAdapter(this,lstMovie);
        if (myListAdapter==null) {
            //do nothing return null
            return;
        }
        setHeightListView(myListAdapter);

        moviesList.setAdapter(myListAdapter);

        moviesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("Title",lstMovie.get(i).getTitle());
                b.putInt("ImgURL",lstMovie.get(i).getThumbnail());
                b.putInt("ImgURLCover",lstMovie.get(i).getCoverImage());
                b.putString("Description",lstMovie.get(i).getDescription());
                b.putString("UrlVideo",lstMovie.get(i).getStreamingLink());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    private void setHeightListView(ListAdapter myListAdapter) {
        //set listAdapter in loop for getting final size
        int totalHeight=0;
        for (int size=0; size < myListAdapter.getCount(); size++) {
            View listItem=myListAdapter.getView(size, null, moviesList);
            listItem.measure(0, 0);
            totalHeight+=listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params=moviesList.getLayoutParams();
        params.height=totalHeight + (moviesList.getDividerHeight() * (myListAdapter.getCount() - 1));
        moviesList.setLayoutParams(params);
    }


    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
        Bundle b = new Bundle();
        b.putString("Title",movie.getTitle());
        b.putInt("ImgURL",movie.getThumbnail());
        b.putInt("ImgURLCover",movie.getCoverImage());
        b.putString("Description",movie.getDescription());
        b.putString("UrlVideo",movie.getStreamingLink());
        intent.putExtras(b);
        //Create some animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView,"sharedImage");
        startActivity(intent,options.toBundle());
    }

    @Override
    public void onSliderClick(Slider slider) {
        Intent intent = new Intent(MainActivity.this, YouTubeActivity.class);
        Bundle b = new Bundle();
        b.putString("UrlVideo",slider.getUrl());
        intent.putExtras(b);
        startActivity(intent);
    }

    class  SliderTimer extends TimerTask{
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sliderPager.getCurrentItem() < lstSlider.size() - 1){
                        sliderPager.setCurrentItem(sliderPager.getCurrentItem()+1);
                    }else {
                        sliderPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}