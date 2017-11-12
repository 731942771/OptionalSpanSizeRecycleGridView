package com.cuiweiyou.optionalspansizerecyclegridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.cuiweiyou.cvuratiolibrary.CVURatioLayoutManager;
import com.cuiweiyou.cvuratiolibrary.CVURatioUtil;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 40个假数据
        ArrayList<PictureBean > mPS = PictureFactory.getPictures(140);

        Collections.sort(mPS, new PictureCompartor());   // 0.重要！！！先按目标排版排序！！！

        int columns = 6;                                 // 1.将屏幕分为多少列
        CVURatioUtil.ratio(columns, mPS);                // 2.对datas进行处理

        CVURatioLayoutManager mGridLytManager = new CVURatioLayoutManager(this, columns, mPS);  // 3.指定布局管理器

        PictureAdapter mAdapter = new PictureAdapter(mPS);   // 普通适配器

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rlv);
        mRecyclerView.setLayoutManager(mGridLytManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}



