package com.example.movieuitemplate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieuitemplate.R;
import com.example.movieuitemplate.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    Context mContext;
    List<Movie> mList;
    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context mContext, List<Movie> mList, MovieItemClickListener listener) {
        this.mContext = mContext;
        this.mList = mList;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_movie,parent,false);
        return new MyViewHolder(view){

        };
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtTitle.setText(mList.get(position).getTitle());
        holder.imgMovie.setImageResource(mList.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private ImageView imgMovie;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtItemFilmName);
            imgMovie = itemView.findViewById(R.id.imgItem_movie);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movieItemClickListener.onMovieClick(mList.get(getAdapterPosition()),imgMovie);
                }
            });
        }
    }
}
