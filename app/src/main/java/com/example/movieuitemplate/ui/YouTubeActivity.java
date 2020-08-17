package com.example.movieuitemplate.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.example.movieuitemplate.R;


public class YouTubeActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_you_tube);
        hideActionBar();
        inits();
    }

    private void inits() {
        webView = findViewById(R.id.webViewID);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String url = b.getString("UrlVideo");

        String html = "<iframe width=\"100%\" height=\"100%\" frameborder=\"0\" src=\"https://www.youtube.com/embed/"+url+"\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" style=\"overflow:hidden;overflow-x:hidden;overflow-y:hidden;height:100%;width:100%;position:absolute;top:0px;left:0px;right:0px;bottom:0px\" allowfullscreen></iframe>";
        webView.loadData(html,"text/html", null);
    }
    private void hideActionBar(){
        getSupportActionBar().hide();
    }
    private void setFullScreen(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}