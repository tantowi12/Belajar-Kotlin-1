package com.example.belajarkotlindasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_item.*

class DetailItem : AppCompatActivity() {

    var b : Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_item)

        detailItem()
    }

    fun detailItem(){

        b = intent.extras

        tv_Title_Detail.text = b?.getString("title")
        tv_Description_Detail.text = b?.getString("description")
    }
}