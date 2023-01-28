package org.marg.mydelegatesapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import org.marg.mydelegatesapp.R;
import org.marg.mydelegatesapp.adapter.SliderdashboardAdapter;
import org.marg.mydelegatesapp.fragment.HomeFragment;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame, new HomeFragment()).commit();





    }
}