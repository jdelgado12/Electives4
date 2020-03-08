package com.example.spellingbee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sample_slide extends AppCompatActivity{

    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private Button startButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_slide);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

//        viewPager.addOnPageChangeListener(viewListener);
    }
//    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//
//            if (position == 0) {
//
//                startButton.setVisibility(View.INVISIBLE);
//            }
//            else if (position == 1){
//                startButton.setVisibility(View.VISIBLE);
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    };



}
