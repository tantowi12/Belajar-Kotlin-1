package com.example.belajarkotlindasar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.example.belajarkotlindasar.R

class WalkThroughAdapter (val context: Context): PagerAdapter() {

    val imgArray: IntArray = intArrayOf(R.drawable.satu, R.drawable.dua, R.drawable.tiga )
    val titleArray: Array<String> = arrayOf("Keep Clean Starts From Our Surrounding Environment",
        "Throw trash in its place", "So that our environment can still survive until our children and grandchildren later")
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return imgArray.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.slide_walkthrough, container,false)

        val txtTitle: TextView = view.findViewById(R.id.tv_Title)
        val img: ImageView = view.findViewById(R.id.iv_Img)

        txtTitle.text = titleArray[position]
        img.setImageDrawable(ContextCompat.getDrawable(context, imgArray[position]))
        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view: View = `object` as View
        container.removeView(view)
    }
}