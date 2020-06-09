package com.example.messenger;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static DataDB dataDB;
    int cnt = 0;
    public static DataAdapter adapter;
    public static RecyclerView rvData;
    public static ArrayList<Data> dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataDB = new DataDB(this);
//        dataDB.insertData(new Data(1,"James","Thank You! That was very helpful!","https://www.dw.com/image/50621524_401.jpg"));
//        dataDB.insertData(new Data(2,"Will Kenny", "I know.. I'm trying to get the funds","https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"));
//        dataDB.insertData(new Data(3,"Beth Williams","I'm looking for tips around capturing the milky way. I have a 6D with a 24-100mm ...","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQsg6KXHm6o4SYhPycSwdsJnlGOWCVyIhWBWcg5y8_pki6coDzG&usqp=CAU"));
//        dataDB.insertData(new Data(4,"Rev Shawn", "Wanted to ask if you're available for a portrait shoot next week.","https://akcdn.detik.net.id/visual/2019/06/21/9cf8e008-2efd-4e1e-bcea-f9255bec46b0_169.jpeg?w=650"));


        dat = dataDB.getAllData();

        rvData = (RecyclerView) findViewById(R.id.rvData);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvData.setLayoutManager(linearLayoutManager);

        adapter = new DataAdapter(this,dat);
        rvData.setAdapter(adapter);

    }
}
