package com.example.webviewtest;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        WebView bannerWebView = (WebView) findViewById(R.id.bannerWebviewContainer);
        loadAd(bannerWebView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadAd(WebView bannerView) {
        bannerView.getSettings().setJavaScriptEnabled(true);
        float density = getResources().getDisplayMetrics().density;
        int width = getResources().getDisplayMetrics().widthPixels;

        Float screenWidthInPixel = width / density;

        Log.i("info", "screen width in pixel = " + screenWidthInPixel);

        Float expandRate =  (float) screenWidthInPixel / 320f;
        Log.i("info","expaned rate: " + expandRate.toString());

        bannerView.loadDataWithBaseURL(
                null,
                "<html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=" + expandRate + ", user-scalable=no\">" +
                        "</head>" +
                        "<body style=\"margin: 0; display=table;\">" +
                        "Ad Begin<br/>" +
                        "<img width='320' height='50' src=\"http://www.naylor.com/wp-content/uploads/2015/08/320x50Naylor.jpg\" />" +
                        "<br/>" +
                        "Ad End<br/>" +
                        "</body>" +
                        "</html>",
                "text/html",
                "utf-8",
                null);
    }
}
