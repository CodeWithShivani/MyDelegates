package org.marg.mydelegatesapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.marg.mydelegatesapp.R;
import org.marg.mydelegatesapp.adapter.Dashborad_Adapter;
import org.marg.mydelegatesapp.adapter.SliderdashboardAdapter;
import org.marg.mydelegatesapp.model.Dashboard_Model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    ViewPager viewPager_dashboard;
    SliderdashboardAdapter sliderdashboardAdapter;
    Timer timer;
    Runnable Update;
    int[] Slidershow;
    int DELAY_MS = 3000, PERIOD_MS = 3000;
    int currentPage = 0;
    RecyclerView home_recycler;
    ArrayList<Dashboard_Model> dashboard_modelArrayList=new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        viewPager_dashboard=view.findViewById(R.id.viewPager_dashboard);
        home_recycler=view.findViewById(R.id.home_recycler);

        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.rumigate,"Lucknow"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.tajmahal,"Agra"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.varanasi,"Varanasi"));
        dashboard_modelArrayList.add(new Dashboard_Model(R.drawable.noida,"Greater Noida"));

        home_recycler.setHasFixedSize(true);
        home_recycler.setAdapter(new Dashborad_Adapter(dashboard_modelArrayList,getActivity()));

        Handler handler = new Handler();
        Update = new Runnable() {
            public void run() {
                if (currentPage == Slidershow.length - 1) {
                    currentPage = 0;
                }
                viewPager_dashboard.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        Slidershow= new int[]{R.drawable.indiatour, R.drawable.rumidarwaza, R.drawable.bada_immambada};

//        Slidershow = new int[]{R.drawable.indiatour, R.drawable.tajmahal, R.drawable.rumigate, R.drawable.varanasi, R.drawable.noida};

        sliderdashboardAdapter = new SliderdashboardAdapter(Slidershow, getActivity());
        viewPager_dashboard.setAdapter(sliderdashboardAdapter);
//        viewPager_dashboard.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.viewpager_margin_overlap_payment));
        viewPager_dashboard.setOffscreenPageLimit(Slidershow.length);
//        viewpagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        return view;
    }
}