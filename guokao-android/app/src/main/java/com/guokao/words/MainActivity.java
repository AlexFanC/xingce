package com.guokao.words;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.graphics.Color;
import android.widget.TextView;
public final class MainActivity extends Activity {
private WebView webView;
@Override public void onCreate(Bundle state) {
super.onCreate(state);
try {
webView=new WebView(this);
webView.setBackgroundColor(Color.WHITE);
WebSettings s=webView.getSettings();
s.setJavaScriptEnabled(true);
s.setDomStorageEnabled(true);
s.setAllowFileAccess(true);
s.setDefaultTextEncodingName("UTF-8");
webView.setWebViewClient(new WebViewClient());
webView.setWebChromeClient(new WebChromeClient());
setContentView(webView);
webView.loadUrl("file:///android_asset/index.html");
} catch(Throwable ex){
TextView t=new TextView(this);
t.setPadding(24,48,24,24);
t.setText("应用启动异常："+ex.toString());
setContentView(t);
}
}
@Override public void onBackPressed(){
if(webView!=null && webView.canGoBack()) webView.goBack();
else super.onBackPressed();
}
@Override protected void onDestroy(){
if(webView!=null){webView.destroy();webView=null;}
super.onDestroy();
}
}