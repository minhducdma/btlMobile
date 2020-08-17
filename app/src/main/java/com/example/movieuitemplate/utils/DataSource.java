package com.example.movieuitemplate.utils;

import android.content.Context;

import com.example.movieuitemplate.R;
import com.example.movieuitemplate.model.Movie;
import com.example.movieuitemplate.model.Slider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {
    private Context context;

    public DataSource(Context context) {
        this.context = context;
    }

    public List<Movie> GetListPopular(){
        List<String> lstDes = Arrays.asList(context.getResources().getStringArray(R.array.description));
        List<String> lstUrl = Arrays.asList(context.getResources().getStringArray(R.array.url));
        List<String> lstTitle = Arrays.asList(context.getResources().getStringArray(R.array.title));
        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie(1,lstTitle.get(0),R.drawable.thumb1,R.drawable.slider2,lstDes.get(0),lstUrl.get(0)));
        lstMovie.add(new Movie(2,lstTitle.get(1),R.drawable.thumb2,R.drawable.slider1,lstDes.get(1),lstUrl.get(1)));
        lstMovie.add(new Movie(3,lstTitle.get(2),R.drawable.thumb3,R.drawable.slider3,lstDes.get(2),lstUrl.get(2)));
        lstMovie.add(new Movie(4,lstTitle.get(3),R.drawable.thumb4,R.drawable.slider4,lstDes.get(3),lstUrl.get(3)));
        lstMovie.add(new Movie(5,lstTitle.get(4),R.drawable.thumb5,R.drawable.slider5,lstDes.get(4),lstUrl.get(4)));
        lstMovie.add(new Movie(6,lstTitle.get(5),R.drawable.thumb6,R.drawable.slider6,lstDes.get(5),lstUrl.get(5)));
        lstMovie.add(new Movie(7,lstTitle.get(6),R.drawable.thumb7,R.drawable.slider7,lstDes.get(6),lstUrl.get(6)));
        lstMovie.add(new Movie(8,lstTitle.get(7),R.drawable.thumb8,R.drawable.slider8,lstDes.get(7),lstUrl.get(7)));
        return lstMovie;
    }

    public  List<Movie> GetListWeek(){
        List<String> lstTitle = Arrays.asList(context.getResources().getStringArray(R.array.title));
        List<String> lstDes = Arrays.asList(context.getResources().getStringArray(R.array.description));
        List<String> lstUrl = Arrays.asList(context.getResources().getStringArray(R.array.url));
        List<Movie> lstMovie = new ArrayList<>();
        lstMovie.add(new Movie(2,lstTitle.get(1),R.drawable.thumb2,R.drawable.slider1,lstDes.get(1),lstUrl.get(1)));
        lstMovie.add(new Movie(3,lstTitle.get(2),R.drawable.thumb3,R.drawable.slider3,lstDes.get(2),lstUrl.get(2)));
        lstMovie.add(new Movie(4,lstTitle.get(3),R.drawable.thumb4,R.drawable.slider4,lstDes.get(3),lstUrl.get(3)));
        lstMovie.add(new Movie(5,lstTitle.get(4),R.drawable.thumb5,R.drawable.slider5,lstDes.get(4),lstUrl.get(4)));
        lstMovie.add(new Movie(6,lstTitle.get(5),R.drawable.thumb6,R.drawable.slider6,lstDes.get(5),lstUrl.get(5)));
        return lstMovie;
    }

    public ArrayList GetSlider(){
        List<String> lstTitle = Arrays.asList(context.getResources().getStringArray(R.array.title));
        List<String> lstUrl = Arrays.asList(context.getResources().getStringArray(R.array.url));
        ArrayList lstSlider = new ArrayList<>();
        lstSlider.add(new Slider(1, R.drawable.slider2,lstTitle.get(0),lstUrl.get(1)));
        lstSlider.add(new Slider(2, R.drawable.slider1,lstTitle.get(1),lstUrl.get(0)));
        lstSlider.add(new Slider(3, R.drawable.slider3,lstTitle.get(2),lstUrl.get(2)));
        lstSlider.add(new Slider(4, R.drawable.slider5,lstTitle.get(4),lstUrl.get(4)));
        lstSlider.add(new Slider(5, R.drawable.slider6,lstTitle.get(5),lstUrl.get(5)));

        return lstSlider;
    }


}
