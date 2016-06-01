package com.example.sekarselvi.mahendraresult;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
    private WebView mWebView;
    ProgressBar progressBar;

    /* renamed from: com.example.sekarselvi.mahendraresult.MainActivity.1 */
    class C01461 implements OnClickListener {
        C01461() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    /* renamed from: com.example.sekarselvi.mahendraresult.MainActivity.2 */
    class C01472 implements OnClickListener {
        C01472() {
        }

        public void onClick(DialogInterface dialog, int id) {
            MainActivity.this.finish();
        }
    }

    private class HelloWebViewClient extends WebViewClient {
        private HelloWebViewClient() {
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            webView.loadUrl(url);
            return true;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            MainActivity.this.progressBar.setVisibility(8);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0148R.layout.activity_main);
        this.mWebView = (WebView) findViewById(C0148R.id.activity_main_webview);
        this.progressBar = (ProgressBar) findViewById(C0148R.id.progressBar1);
        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        this.mWebView.loadUrl("http://117.239.243.251/result/");
        this.mWebView.setWebViewClient(new HelloWebViewClient());
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.mWebView.canGoBack()) {
            return super.onKeyDown(keyCode, event);
        }
        this.mWebView.goBack();
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0148R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        Builder alertDialogBuilder = new Builder(this);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder.setMessage("Do you really want to exit?").setCancelable(false).setPositiveButton("Yes", new C01472()).setNegativeButton("No", new C01461());
        alertDialogBuilder.create().show();
    }
}
