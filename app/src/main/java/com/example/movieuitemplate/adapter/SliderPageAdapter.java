package com.example.movieuitemplate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.movieuitemplate.R;
import com.example.movieuitemplate.model.Slider;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SliderPageAdapter extends PagerAdapter {
    private Context mContext;
    private List<Slider> mList;
    private SliderItemClickListener sliderItemClickListener;

    public SliderPageAdapter(Context mContext, List<Slider> mList,SliderItemClickListener sliderItemClickListener) {
        this.mContext = mContext;
        this.mList = mList;
        this.sliderItemClickListener = sliderItemClickListener;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout = layoutInflater.inflate(R.layout.slider_item,null);

        ImageView sliderImage = sliderLayout.findViewById(R.id.imgFilm);
        TextView sliderTitle = sliderLayout.findViewById(R.id.txtFilmName);
        FloatingActionButton fplPlay = sliderLayout.findViewById(R.id.fltPlaySlider);
        sliderImage.setImageResource(mList.get(position).getImage());
        sliderTitle.setText(mList.get(position).getTitle());

        container.addView(sliderLayout);

        fplPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliderItemClickListener.onSliderClick(mList.get(position));
            }
        });

        return sliderLayout;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
