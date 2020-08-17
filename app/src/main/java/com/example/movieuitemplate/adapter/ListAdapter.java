package com.example.movieuitemplate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieuitemplate.R;
import com.example.movieuitemplate.model.Movie;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context mContext;
    List<Movie> mList;

    public ListAdapter(Context mContext, List<Movie> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return getItemId(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_list,null);
        ImageView img = (ImageView) view.findViewById(R.id.imgListFilm);
        TextView txtTilte = (TextView) view.findViewById(R.id.txtListTilte);
        TextView txtDes = (TextView) view.findViewById(R.id.txtListDes);

        img.setImageResource(mList.get(i).getThumbnail());
        txtTilte.setText(mList.get(i).getTitle());
        txtDes.setText(mList.get(i).getDescription());

        return view;
    }
}
