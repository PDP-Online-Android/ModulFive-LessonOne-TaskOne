package dev.ogabek.java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.model.InfoPage;

public class InfoPageAdapter extends PagerAdapter {

    Context context;
    List<InfoPage> infoPages;

    public InfoPageAdapter(Context context, List<InfoPage> infoPages) {
        this.context = context;
        this.infoPages = infoPages;
    }

    @Override
    public int getCount() {
        return infoPages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_view, container, false);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.item_lottie_animation);
        TextView title = view.findViewById(R.id.item_title);
        TextView text = view.findViewById(R.id.item_text);

        InfoPage infoPage = infoPages.get(position);

        lottieAnimationView.setAnimation(infoPage.getAnimation());
        title.setText(infoPage.getTitle());
        text.setText(infoPage.getText());

        ViewPager viewPager = (ViewPager) container;
        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
