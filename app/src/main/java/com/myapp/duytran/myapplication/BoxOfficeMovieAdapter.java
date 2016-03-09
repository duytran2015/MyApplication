package com.myapp.duytran.myapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.GregorianCalendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.JacksonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BoxOfficeMovieAdapter extends ArrayAdapter<BoxOfficeMovie> {

    private List<BoxOfficeMovie> boxOfficeMovieList;
    private Context context;

    public BoxOfficeMovieAdapter(Context context, int resource, List<BoxOfficeMovie> objects) {
        super(context, resource, objects);
        this.boxOfficeMovieList = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.activity_mainscreen_item, parent, false);

        final BoxOfficeMovie boxOfficeMovie = boxOfficeMovieList.get(position);

        // Lookup views within item layout
        TextView movieTitle = (TextView) view.findViewById(R.id.movieTitle);

        TextView movieVoteAverage = (TextView) view.findViewById(R.id.movieVoteAverage);

        TextView movieReleaseDate = (TextView) view.findViewById(R.id.movieReleaseDate);

        ImageView moviePosterImage = (ImageView) view.findViewById(R.id.moviePosterImage);

        // Populate the data into the template view using the data object
        movieTitle.setText(boxOfficeMovie.getTitle());

        movieVoteAverage.setText("Score: " + boxOfficeMovie.getVote_average() + "/10");

        movieReleaseDate.setText(boxOfficeMovie.getRelease_date());

        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w500"+boxOfficeMovie.getPoster_path())
                .into(moviePosterImage);

        // Add to Reminder
        Button watchTrailer = (Button) view.findViewById(R.id.watchTrailerButton);
        watchTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int maxResults = 5;

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.googleapis.com/youtube/v3/")
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build();
                YouTubeService service;
                service = retrofit.create(YouTubeService.class);
                Call<YouTubeSearchResults> trailerDataCall = service.getSearchResults(
                        "snippet",
                        maxResults,
                        boxOfficeMovie.getTitle() + " Trailer",
                        "AIzaSyDK_3O8U52tVapnTeIUiwXMfZaHWq4dgew"
                );

                trailerDataCall.enqueue(new Callback<YouTubeSearchResults>() {
                    @Override
                    public void onResponse(Response<YouTubeSearchResults> response) {
                        Intent trailerIntent = new Intent(context,TrailerViewActivity.class);
                        trailerIntent.putExtra("keyword", response.body().getItems().get(0).getId().getVideoId());
                        context.startActivity(trailerIntent);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("TEST", "Failed to get the result.", t);
                    }
                });
            }
        });

        Button addEvent = (Button) view.findViewById(R.id.addMovieButton);
        addEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get Year, Month, and Date from Release Date for Event
                String[] date = boxOfficeMovie.getRelease_date().split("-");
                int year = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]) - 1;
                int day = Integer.parseInt(date[2]);

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                GregorianCalendar startDate = new GregorianCalendar(year, month, day);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startDate.getTimeInMillis());
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, startDate.getTimeInMillis());
                context.startActivity(intent);
            }
        });

        return view;
    }

}
