package com.example.lenovo.androidbookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        titleArrayList = new ArrayList<String>();

        titleArrayList.add(Constants.WHAT_IS_ANDROID);
        titleArrayList.add(Constants.HISTORY_AND_VERSION);
        titleArrayList.add(Constants.INSTALLING_SOFTWARE_ANDROIDSTUDIO);
        titleArrayList.add(Constants.INSTALLING_SOFTWARE_ECLIPSE);
        titleArrayList.add(Constants.HELLO_ANDROID_EXAMPLE);
        titleArrayList.add(Constants.INTERNAL_DETAILS_HELLOWORLD);
        titleArrayList.add(Constants.DVM);
        titleArrayList.add(Constants.ANDROID_MANIFEST_FILE);
        titleArrayList.add(Constants.ANDROID_CORE_BUILDING_BLOCK);
        titleArrayList.add(Constants.SOFTWARE_STACK);
        titleArrayList.add(Constants.ANDROID_EMULATOR);
        titleArrayList.add(Constants.R_JAVA_FILE);
        titleArrayList.add(Constants.HIDE_TITLE_BAR);
        titleArrayList.add(Constants.SCREEN_ORIENTATION);



        mRecyclerView = findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adaptor = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemclick(View v, int postion) {

                Intent desIntent = new Intent(mContext,DescriptionActivity.class);
                desIntent.putExtra("titles",titleArrayList.get(postion));

                startActivity(desIntent);



                Toast.makeText(mContext,"Clicked "+titleArrayList.get(postion),Toast.LENGTH_SHORT).show();


            }
        });


mRecyclerView.setAdapter(adaptor);

    }
}
