package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String accessUrl = "https://akira-watson.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWebView = findViewById(R.id.button1);
        Button buttonBrowser = findViewById(R.id.button2);

        buttonWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.web);
                webView = findViewById(R.id.web_view);

                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setDomStorageEnabled(true);

                getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);

                webView.loadUrl(accessUrl);
            }
        });

        buttonBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(accessUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if( (event.getAction() == KeyEvent.ACTION_DOWN )
                && (keyCode == KeyEvent.KEYCODE_BACK) ){

            if(webView.canGoBack())
                webView.goBack();
            else
                finish();
        }

        return super.onKeyDown(keyCode, event);
    }
}
