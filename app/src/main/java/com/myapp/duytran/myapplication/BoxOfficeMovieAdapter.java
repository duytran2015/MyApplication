package com.myapp.duytran.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BoxOfficeMovieAdapter extends BaseAdapter {

    private List<BoxOfficeMovie> boxOfficeMovieList;
    private Context context;

    public BoxOfficeMovieAdapter(List<BoxOfficeMovie> boxOfficeMovieList, Context context) {
        this.boxOfficeMovieList = boxOfficeMovieList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return boxOfficeMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return boxOfficeMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.activity_mainscreen_item, parent, false);
        }
        // Lookup views within item layout
        TextView movieTitle = (TextView) convertView.findViewById(R.id.movieTitle);

        TextView movieVoteAverage = (TextView) convertView.findViewById(R.id.movieVoteAverage);

        TextView movieStatus = (TextView) convertView.findViewById(R.id.movieStatus);

        TextView movieReleaseDate = (TextView) convertView.findViewById(R.id.movieReleaseDate);

        ImageView moviePosterImage = (ImageView) convertView.findViewById(R.id.moviePosterImage);

        // Populate the data into the template view using the data object
        movieTitle.setText(boxOfficeMovieList.get(position).getTitle());

        movieVoteAverage.setText("Score: " + boxOfficeMovieList.get(position).getVote_average());

        movieStatus.setText(boxOfficeMovieList.get(position).getStatus());

        movieReleaseDate.setText(boxOfficeMovieList.get(position).getRelease_date());

        Picasso.with(context).load(boxOfficeMovieList.get(position).getPoster_path()).into(moviePosterImage);
        // Return the completed view to render on screen
        return convertView;
    }
}
