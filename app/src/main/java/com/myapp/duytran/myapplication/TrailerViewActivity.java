package com.myapp.duytran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TrailerViewActivity extends AppCompatActivity{
    private WebView youTubeWeb;
    private String videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailerview_item);

        Intent intentExtras = getIntent();
        Bundle extrasBundle = intentExtras.getExtras();
        videoId = extrasBundle.getString("keyword");

        youTubeWeb = (WebView) findViewById(R.id.youtube_trailer_view);
        String trailerPath = "https://www.youtube.com/watch?v="+videoId;
        youTubeWeb.setWebViewClient(new MyBrowser());

        youTubeWeb.getSettings().setLoadsImagesAutomatically(true);
        youTubeWeb.getSettings().setJavaScriptEnabled(true);
        youTubeWeb.loadUrl(trailerPath);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        youTubeWeb.destroy();
    }
}
