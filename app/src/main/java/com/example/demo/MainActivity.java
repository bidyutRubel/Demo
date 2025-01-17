package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView hotelCardView, transportserviceCardView, localguideCardView, touristattractionCardView;
    SliderView sliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //akash
        slide();

        hotelCardView = findViewById(R.id.HotelCardViewId);
        transportserviceCardView = findViewById(R.id.TransportServiceCardViewId);
        localguideCardView = findViewById(R.id.LocalGuideCardViewId);
        touristattractionCardView = findViewById(R.id.TouristAttractionCardViewId);

        hotelCardView.setOnClickListener(this);
        transportserviceCardView.setOnClickListener(this);
        localguideCardView.setOnClickListener(this);
        touristattractionCardView.setOnClickListener(this);
    }

    //akash
    private void slide() {
        sliderView = findViewById(R.id.imageSlider);

        final SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.setCount(5);

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEINROTATIONTRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                sliderView.setCurrentPagePosition(position);
            }
        });



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.HotelCardViewId) {
            Intent intent = new Intent(MainActivity.this, Hotel.class);
            startActivity(intent);
        } else if (v.getId() == R.id.TransportServiceCardViewId) {
            Intent intent = new Intent(MainActivity.this, TransportService.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.LocalGuideCardViewId) {
            Intent intent = new Intent(MainActivity.this, LocalGuide.class);
            startActivity(intent);
        } else if (v.getId() == R.id.TouristAttractionCardViewId) {
            Intent intent = new Intent(MainActivity.this, Tourist.class);
            startActivity(intent);
        }
    }
}

