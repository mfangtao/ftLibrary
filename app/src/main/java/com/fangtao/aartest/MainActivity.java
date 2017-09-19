package com.fangtao.aartest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.fangtao.ftlibrary.FTTest;

public class MainActivity extends AppCompatActivity {

    /**
     * Hello World!
     */
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        textview = (TextView) findViewById(R.id.textview);

        textview.setText(FTTest.getmInstance().getMsg());

    }
}
