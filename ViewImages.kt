package com.example.gradletest.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.gradletest.Models.Images
import com.example.gradletest.R
import com.example.gradletest.adapter.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator
import org.json.JSONArray
import org.json.JSONObject

@Suppress("UNREACHABLE_CODE")
class Aucation_Screen : AppCompatActivity() {
    private lateinit var imagesModel: Images
    private    lateinit var context:Context
    lateinit var indecator: CircleIndicator
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var viewPager: ViewPager
    private var  imagesList: ArrayList<Images> = ArrayList()
    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("WrongConstant", "MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aucation_screen)
        context=this
        viewPager = findViewById(R.id.view_pager)
      
        val images = intent.extras!!.getString("images")
  

        val jsonImages: JSONArray = JSONArray(images)
        val sizeImage: Int = jsonImages.length()
        for (i in 0..sizeImage - 1) {
            val jsonObject: JSONObject = jsonImages.getJSONObject(i)
            val model: Images = Images(
                jsonObject.getString("add_id"),
                jsonObject.getString("image"),
            )
            imagesList.add(model)
            viewPagerAdapter = ViewPagerAdapter(this, imagesList)
            viewPager.adapter = viewPagerAdapter

        }

    }
}


