package com.vimal.dynamicviewpager.activity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.URLUtil;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.vimal.dynamicviewpager.R;
import com.vimal.dynamicviewpager.adapter.ViewPagerCustomAdapter;
import com.vimal.dynamicviewpager.download.DownloadListener;
import com.vimal.dynamicviewpager.download.DownloadUtil;
import com.vimal.dynamicviewpager.download.InputParameter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewpager;
    SmartTabLayout tabLayout;
    File imageDir = new File(Environment.getExternalStorageDirectory() + File.separator + "VIMAL");
    String dir = imageDir + File.separator + "RingtoneOnline/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabLayout);


        List<String> tabs = new ArrayList<>();
        tabs.add("Fragment 1");
        tabs.add("Fragment 2");
        tabs.add("Fragment 3");
        tabs.add("Fragment 4");
        tabs.add("Fragment 5");
        tabs.add("Fragment 6");
        tabs.add("Fragment 7");
        tabs.add("Fragment 8");
        tabs.add("Fragment 9");
        tabs.add("Fragment 10");



        ViewPagerCustomAdapter adapter = new ViewPagerCustomAdapter(getSupportFragmentManager(), tabs);
        viewpager.setAdapter(adapter);
        tabLayout.setViewPager(viewpager); // set title to tabs
        viewpager.setCurrentItem(0);


        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                Log.e("vml", position + "method_call");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    void fileDownload(String path) {

        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        String base = "http://las.lyrically.co.in/AudioFile/";
        String url = base + path;
        String file_name = url.substring(url.lastIndexOf('/'));
        File filechk = new File(dir + file_name);

        if (filechk.exists()) {

        } else {
            if (URLUtil.isValidUrl("http://las.lyrically.co.in/AudioFile/" + path)) {

                DownloadUtil.getInstance()
                        .downloadFile(new InputParameter.Builder("http://las.lyrically.co.in/AudioFile/", path, dir + file_name)
                                .setCallbackOnUiThread(true)
                                .build(), new DownloadListener() {
                            @Override
                            public void onFinish(final File file) {
                                Toast.makeText(MainActivity.this, "File Downloaded", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onProgress(int progress, long downloadedLengthKb, long totalLengthKb) {
                                Log.e("vml","update progress");
                            }

                            @Override
                            public void onFailed(String errMsg) {
                                Toast.makeText(MainActivity.this, "Download Faild", Toast.LENGTH_SHORT).show();
                            }
                        });
            } else {
                Toast.makeText(MainActivity.this, "Error on Mp3path", Toast.LENGTH_SHORT).show();
            }

        }
    }


}