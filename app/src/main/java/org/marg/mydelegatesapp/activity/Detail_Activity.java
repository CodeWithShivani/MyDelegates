package org.marg.mydelegatesapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import org.marg.mydelegatesapp.R;
import org.marg.mydelegatesapp.adapter.Dashborad_Adapter;
import org.marg.mydelegatesapp.adapter.SliderdashboardAdapter;
import org.marg.mydelegatesapp.databinding.ActivityDetailBinding;
import org.marg.mydelegatesapp.model.Dashboard_Model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Detail_Activity extends AppCompatActivity {
    SliderdashboardAdapter sliderdashboardAdapter;
    Timer timer;
    Runnable Update;
    int[] Slidershow;
    String title;
    int DELAY_MS = 3000, PERIOD_MS = 3000;
    int currentPage = 0;
    ActivityDetailBinding detailBinding;
    ArrayList<Dashboard_Model> dashboard_modelArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());

        title=getIntent().getStringExtra("title");
        detailBinding.toolbarTitle.setText(title);


        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.bada_immambada,"Bara Imambara"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.rumidarwaza,"Rumi Darwaza"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.chota_imambada,"Chota Imambara"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.residency,"The Residency, Lucknow"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.ambedkarpark,"Ambedkar Memorial Park"));

        detailBinding.detailsRecycler.setHasFixedSize(true);
        detailBinding.detailsRecycler.setAdapter(new Dashborad_Adapter(dashboard_modelArrayList,getApplicationContext()));

        Handler handler = new Handler();
        Update = new Runnable() {
            public void run() {
                if (currentPage == Slidershow.length - 1) {
                    currentPage = 0;
                }
                detailBinding.viewPagerDetails.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        Slidershow= new int[]{R.drawable.lucknow_slider1,R.drawable.lucknow_slider2};

        sliderdashboardAdapter = new SliderdashboardAdapter(Slidershow, getApplicationContext());
        detailBinding.viewPagerDetails.setAdapter(sliderdashboardAdapter);
        detailBinding.viewPagerDetails.setOffscreenPageLimit(Slidershow.length);
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    public void goBack(View view) {finish();
    }
}