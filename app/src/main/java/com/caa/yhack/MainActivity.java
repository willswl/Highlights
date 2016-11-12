package com.caa.yhack;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.caa.yhack.spec.HomePageObject;
import com.caa.yhack.views.VideoArrayAdapter;
import com.caa.yhack.youtube.Video;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView wideList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        wideList = (ListView) findViewById(R.id.parallaxListView);

        loadHomeObjects();

    }

    public void loadHomeObjects() {

        new GetVideos().execute();

    }


    private HomePageObject[] getTestVids() {

        List<HomePageObject> list = new ArrayList<HomePageObject>();
        list.add(new Video("YouTube Collection", "Y_UmWdcTrrc", 0, 1, 5, false));
        list.add(new Video("GMail Tap", "1KhZKNZO8mQ", 0, 1, 5, false));
        list.add(new Video("Chrome Multitask", "UiLSiqyDf4Y", 0, 1, 5, false));
        list.add(new Video("Google Fiber", "re0VRK6ouwI", 0, 1, 5, false));
        list.add(new Video("Autocompleter", "blB_X38YSxQ", 0, 1, 5, false));
        list.add(new Video("GMail Motion", "Bu927_ul_X0", 0, 1, 5, false));
        list.add(new Video("Translate for Animals", "3I24bSteJpw", 0, 1, 5, false));

        return list.toArray(new HomePageObject[0]);

    }

    private class GetVideos extends AsyncTask<Void, Void, HomePageObject[]> {

        @Override
        protected HomePageObject[] doInBackground(Void ... params) {

            HomePageObject[] homePageObjects = getTestVids();
            return homePageObjects;

        }

        @Override
        protected void onPostExecute(HomePageObject[] result) {
            VideoArrayAdapter adapter = new VideoArrayAdapter(context, result);
            wideList.setAdapter(adapter);
        }

        @Override
        protected void onPreExecute() {}

    }

}
