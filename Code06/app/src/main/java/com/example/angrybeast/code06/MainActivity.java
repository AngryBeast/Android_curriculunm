package com.example.angrybeast.code06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private String[] titles = null;
//    private String[] authors = null;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        titles = getResources().getStringArray(R.array.titles);
//        authors = getResources().getStringArray(R.array.authors);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this,android.R.layout.simple_list_item_1,titles);
//
//
//        ListView lvNewsList = findViewById(R.id.lv_news_list);
//        lvNewsList.setAdapter(adapter);
//    }





//    private String[] titles = null;
//    private String[] authors = null;
//    private static final String NEWS_TITLE = "news_title";
//    private static  final String NEWS_AUTHOR = "news_author";
//    //private static final String NEWS_ID = "news_id";
//
//
//    private  List<News> newsList = new ArrayList<>();
//    private List<Map<String, String>> dataList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        initData();
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,dataList, android.R.layout.simple_list_item_2
//        ,new String[]{NEWS_TITLE,NEWS_AUTHOR},
//                new int[]{android.R.id.text1,android.R.id.text2});
//
//        ListView lvNewList = findViewById(R.id.lv_news_list);
//        lvNewList.setAdapter(simpleAdapter);
//    }
//
//    private void initData(){
//        int length;
//        titles = getResources().getStringArray(R.array.titles);
//        authors = getResources().getStringArray(R.array.authors);
//
//        if(titles.length > authors.length){
//            length = authors.length;
//        }
//        else {
//            length = titles.length;
//        }
//
//        for (int i = 0; i < length; i++) {
//            Map map = new HashMap();
//            map.put(NEWS_TITLE,titles[i]);
//            map.put(NEWS_AUTHOR,authors[i]);
//            dataList.add(map);
//        }
//    }
//




    private String[] titles = null;
    private String[] authors = null;
    private static final String NEWS_TITLE = "news_title";
    private static  final String NEWS_AUTHOR = "news_author";
    private static final String NEWS_ID = "news_id";


    private  List<News> newsList = new ArrayList<>();
    //private List<Map<String, String>> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

//        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,dataList, android.R.layout.simple_list_item_2
//                ,new String[]{NEWS_TITLE,NEWS_AUTHOR},
//                new int[]{android.R.id.text1,android.R.id.text2});
//
//        ListView lvNewList = findViewById(R.id.lv_news_list);
//        lvNewList.setAdapter(simpleAdapter);

        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, R.layout.list_item, newsList);

        ListView lvNewList = findViewById(R.id.lv_news_list);

        lvNewList.setAdapter(newsAdapter);
    }

    private void initData(){
        int length;
        titles = getResources().getStringArray(R.array.titles);
        authors = getResources().getStringArray(R.array.authors);
        TypedArray images = getResources().obtainTypedArray(R.array.images);

        if(titles.length > authors.length){
            length = authors.length;
        }
        else {
            length = titles.length;
        }

//        for (int i = 0; i < length; i++) {
//            Map map = new HashMap();
//            map.put(NEWS_TITLE,titles[i]);
//            map.put(NEWS_AUTHOR,authors[i]);
//            dataList.add(map);
//        }

        for (int i = 0; i < length; i++) {
            News news = new News();
            news.setTitle(titles[i]);
            news.setAuthor(authors[i]);
            news.setImageId(images.getResourceId(i,0));

            newsList.add(news);
        }
    }



}
