package com.example.lenovo.androidbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DescriptionActivity extends AppCompatActivity {
    private static final String TAG = "DescriptionActivity";
    private Context mContext;
    private Bundle extras;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        mContext = DescriptionActivity.this;

        webView = findViewById(R.id.simpleWebView);

        extras = getIntent().getExtras();
        if (!extras.equals(null)) {

            String data = extras.getString("titles");

            Log.d(TAG, "onCreate: the coming data is "+data);

            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl(url);

            WebSettings webSettings = webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setJavaScriptEnabled(true);
        }


    }
}
