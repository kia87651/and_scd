package com.example.a405_16.scheduler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx = MainActivity.this;
        final CalendarView cal = findViewById(R.id.calendar);
        final TimePicker time = findViewById(R.id.timePicker);
        final TextView today = findViewById(R.id.today);
        today.setText(new SimpleDateFormat(
                "yyyy-MM-dd hh:mm").format(new Date()));
        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView date = findViewById(R.id.date);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);
        time.setVisibility(View.INVISIBLE);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayofMonth) {
                temp = year+"-"+(month+1)+"-"+dayofMonth;
            }
        });
        findViewById(R.id.rdDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.VISIBLE);
                time.setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.rdTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time.setVisibility(View.VISIBLE);
                cal.setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.confirmBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("선택한 날짜 : ", temp);
                String[] arr = temp.split("-");
                year.setText(arr[0]);
                month.setText(arr[1]);
                date.setText(arr[2]);
                hour.setText(time.getHour()+"");
                minute.setText(time.getMinute()+"");
            }
        });
    }
}
