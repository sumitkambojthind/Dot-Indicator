package com.example.dotindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var img1:ImageView
    private lateinit var img2:ImageView
    private lateinit var img3:ImageView
    private lateinit var viewPage2: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img1=findViewById(R.id.img1_iv)
        img2=findViewById(R.id.img2_iv)
        img3=findViewById(R.id.img3_iv)
        viewPage2=findViewById(R.id.view_page2)

        var imgLst = listOf(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background)

        val adapter=ViewPageAdapter(this,imgLst)
        viewPage2.adapter=adapter

        // for dot indicator

        viewPage2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                changeColor()
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }

        })
    }
    fun changeColor(){
        when(viewPage2.currentItem){
            0->{
                img1.setBackgroundColor(applicationContext.resources.getColor(R.color.red))
                img2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                img3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
            }
            1->{
                img1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                img2.setBackgroundColor(applicationContext.resources.getColor(R.color.red))
                img3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
            }
            2->{
                img1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                img2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                img3.setBackgroundColor(applicationContext.resources.getColor(R.color.red))
            }
        }
    }
}