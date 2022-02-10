package dev.ogabek.kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import dev.ogabek.kotlin.R
import dev.ogabek.kotlin.adapter.InfoPageAdapter
import dev.ogabek.signin_signup.model.InfoPage

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var adapter: InfoPageAdapter
    private lateinit var dotsIndicator: WormDotsIndicator

    private lateinit var skip: TextView;
    private lateinit var getStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {

        skip = findViewById(R.id.tv_skip)
        getStarted = findViewById(R.id.btn_get_started)

        viewPager = findViewById(R.id.view_pager)

        adapter = InfoPageAdapter(this, prepareInfoList())
        viewPager.adapter = adapter

        dotsIndicator = findViewById(R.id.dots_indicator)
        dotsIndicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 2) {
                    skip.visibility = View.GONE
                    getStarted.visibility = View.VISIBLE
                } else {
                    skip.visibility = View.VISIBLE
                    getStarted.visibility = View.GONE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })

    }

    private fun prepareInfoList(): List<InfoPage> {
        val infoList: ArrayList<InfoPage> = ArrayList()
        infoList.add(InfoPage("topup.json", "Say Hello to Global Top-Up", "Send mobile top-up to more than 500 networks in over 140 countries."))
        infoList.add(InfoPage("safe.json", "Safe Trusted & Fully Secure", "Encrypted transactions mean your payment & Privacy and Protected."))
        infoList.add(InfoPage("easy.json", "Easy to Use", "Pick a number, choose an amount, send your Top-up, Simple"))
        return infoList
    }
}