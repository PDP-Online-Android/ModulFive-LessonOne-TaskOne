package dev.ogabek.java.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.adapter.InfoPageAdapter;
import dev.ogabek.java.model.InfoPage;

public class MainActivity extends AppCompatActivity {

    private WormDotsIndicator dotsIndicator;
    private ViewPager viewPager;
    private TextView skip;
    private Button getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        dotsIndicator = findViewById(R.id.dots_indicator);
        viewPager = findViewById(R.id.view_pager);
        skip = findViewById(R.id.tv_skip);
        getStarted = findViewById(R.id.btn_get_started);

        InfoPageAdapter adapter = new InfoPageAdapter(this, prepareInfoList());
        viewPager.setAdapter(adapter);

        dotsIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    skip.setVisibility(View.GONE);
                    getStarted.setVisibility(View.VISIBLE);
                } else {
                    skip.setVisibility(View.VISIBLE);
                    getStarted.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private List<InfoPage> prepareInfoList() {
        List<InfoPage> infoList = new ArrayList<>();
        infoList.add(new InfoPage("topup.json", "Say Hello to Global Top-Up", "Send mobile top-up to more than 500 networks in over 140 countries."));
        infoList.add(new InfoPage("safe.json", "Safe Trusted & Fully Secure", "Encrypted transactions mean your payment & Privacy and Protected."));
        infoList.add(new InfoPage("easy.json", "Easy to Use", "Pick a number, choose an amount, send your Top-up, Simple"));
        return infoList;
    }
}