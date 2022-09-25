package com.example.political_binner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    val listimg=ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        listimg.add(R.drawable.pti)
        for (i in 0 until listimg.size){
            showimg(listimg[i])

        }

    }
    fun showimg(img:Int){
        val imgview=ImageView(this)
        imgview.setBackgroundResource(img)
        flipper.addView(imgview)
        flipper.flipInterval=3000
        flipper.isAutoStart=true
        flipper.setInAnimation(this, android.R.anim.slide_in_left)
        flipper.setOutAnimation(this, android.R.anim.slide_out_right)
    }
}