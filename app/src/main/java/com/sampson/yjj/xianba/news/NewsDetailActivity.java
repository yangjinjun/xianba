package com.sampson.yjj.xianba.news;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sampson.yjj.xianba.R;

public class NewsDetailActivity extends AppCompatActivity {

    private WebView news_webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        showProgressDialog("","正在加载");
        init();
        hideProgressDialog();
    }
    private void init(){
        String url = getIntent().getStringExtra("url");
        news_webview = (WebView)findViewById(R.id.news_webview);
        news_webview.getSettings().setJavaScriptEnabled(true);
        news_webview.setWebViewClient(new WebViewClient());
        news_webview.loadUrl(url);
    }
    private ProgressDialog progressDialog;
    public void showProgressDialog(String title, String message) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, title,message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }
        progressDialog.show();
    }
    /*
 * 隐藏提示加载
 */
    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }
}
