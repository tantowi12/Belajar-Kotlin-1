package com.example.belajarkotlindasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.belajarkotlindasar.adapter.WalkThroughAdapter
import kotlinx.android.synthetic.main.activity_walk_through.*

class WalkThroughActivity : AppCompatActivity() {

    lateinit var wkAdapter: WalkThroughAdapter
    val dots = arrayOfNulls<TextView>(3)
    var currentPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)

        wkAdapter = WalkThroughAdapter(this)
        vvWalkThrough.adapter = wkAdapter

        dotIndicator(currentPage)

        initAction()
    }

    fun initAction() {
        vvWalkThrough.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                dotIndicator(position)
                currentPage = position
            }

        })

        tvLanjutkan.setOnClickListener {
            if (vvWalkThrough.currentItem + 1 < dots.size) {
                vvWalkThrough.currentItem +=1
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tvLewati.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun dotIndicator(p: Int) {
        llDots.removeAllViews()

        for (i in 0..dots.size-1) {
            dots[i] = TextView(this)
            dots[i]?.textSize = 35f
            dots[i]?.setTextColor(resources.getColor(R.color.colorYellow))
            dots[i]?.text = Html.fromHtml("&#8226;")

            llDots.addView(dots[i])
        }

        if (dots.size > 0) {
            dots[p]?.setTextColor(resources.getColor(R.color.colorBlueLight))
        }
    }
}