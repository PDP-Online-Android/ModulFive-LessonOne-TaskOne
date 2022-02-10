package dev.ogabek.kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import dev.ogabek.kotlin.R
import dev.ogabek.signin_signup.model.InfoPage

class InfoPageAdapter(
    private val context: Context,
    private val infoList: List<InfoPage>
): PagerAdapter() {

    override fun getCount() = infoList.size

    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context.applicationContext).inflate(R.layout.item_view, container, false)
        val info = infoList[position]

        val lottieAnimationView: LottieAnimationView = view.findViewById(R.id.item_lottie_animation)
        val title: TextView = view.findViewById(R.id.item_title)
        val text: TextView = view.findViewById(R.id.item_text)

        lottieAnimationView.setAnimation(info.animation)
        title.text = info.title
        text.text = info.text

        val viewPager = container as ViewPager
        viewPager.addView(view, 0)

        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }

}