package org.marg.mydelegatesapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.squareup.picasso.Picasso;

import org.marg.mydelegatesapp.R;

public class SliderdashboardAdapter extends PagerAdapter {

    int[] str;
    Context ctx;

    public SliderdashboardAdapter(int[] str, Context ctx) {
        this.str = str;
        this.ctx = ctx;
    }

    private LayoutInflater layoutInflater;

    @Override
    public int getCount() {
        return str.length;
        //return array_image.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_card_slider, container, false);
      ImageView img=view.findViewById(R.id.card_logo);

//         ImageView imageView=new ImageView ( R.id.card_logo );
//         img.setBackgroundResource(str.length);
//         img.setScaleType(ImageView.ScaleType.FIT_XY);

        Picasso.get().load(str[position])
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(img);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


}
