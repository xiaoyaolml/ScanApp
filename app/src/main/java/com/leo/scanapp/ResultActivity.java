package com.leo.scanapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Information information = (Information) getIntent().getSerializableExtra(MainActivity.TAG);
        ((TextView)findViewById(R.id.result_tv_barcode)).setText(information.getBarcode());
        ((TextView)findViewById(R.id.result_tv_title)).setText(information.getTitle());
        ((TextView)findViewById(R.id.result_tv_author)).setText(information.getAuthor());
        ((TextView)findViewById(R.id.result_tv_price)).setText(String.valueOf(information.getPrice()));
        String[] dates = information.getCreatedAt().split(" ");
        ((TextView)findViewById(R.id.result_tv_date)).setText(dates[0]);
        ((TextView)findViewById(R.id.result_tv_content)).setText(information.getContent());
    }
}
