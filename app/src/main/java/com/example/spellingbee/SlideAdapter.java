package com.example.spellingbee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.zip.Inflater;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public int[] lst_image= {
            R.drawable.tuts_easy1,
            R.drawable.tuts_easy2
    };

    public SlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_image.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
    inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.slide, container, false);
    LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slideLinearLayout);
    ImageView imgslide = (ImageView) view.findViewById(R.id.slideimg);
    container.addView(view);
    imgslide.setImageResource(lst_image[position]);
    return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }
}
