package com.suret.lafyuu.adapter

import android.content.Context
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import coil.load
import com.suret.lafyuu.R
import com.suret.lafyuu.model.SalesModel

class ItemPagerAdapter(val list: List<SalesModel>) : PagerAdapter() {

    override fun getCount(): Int = list.size


    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater =
            container.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val slideLayout: View = layoutInflater.inflate(R.layout.sale_item_layout, container, false)

        val imageView = slideLayout.findViewById<ImageView>(R.id.sales_imageView)
        val textView = slideLayout.findViewById<TextView>(R.id.sales_textView)
        val hourTV = slideLayout.findViewById<TextView>(R.id.hour_tv)
        val minuteTV = slideLayout.findViewById<TextView>(R.id.minute_tv)
        val secondTV = slideLayout.findViewById<TextView>(R.id.second_tv)

        container.addView(slideLayout)

        imageView.load(list[position].imageUrl) {
            crossfade(true)
        }
        textView.text = list[position].title

        object : CountDownTimer(list[position].date, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                hourTV.text = (millisUntilFinished / (1000 * 60 * 60) % 24).toString()
                minuteTV.text = ((millisUntilFinished / (1000 * 60)) % 60).toString()
                secondTV.text = (millisUntilFinished / 1000 % 60).toString()
            }

            override fun onFinish() {
            }
        }.start()

        return slideLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}

