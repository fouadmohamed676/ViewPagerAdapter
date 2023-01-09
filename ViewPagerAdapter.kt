package com.example.gradletest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.gradletest.utils.Network
import com.example.gradletest.Models.Images
import com.example.gradletest.R
import com.squareup.picasso.Picasso

class ViewPagerAdapter (private val mContext: Context, private val itemList: ArrayList<Images>) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(mContext)
        val view =    layoutInflater!!.inflate(R.layout.images_list_item, container, false)
        val image: ImageView = view.findViewById(R.id.image_det_list_item_) as ImageView
        val path:String =Network.image_url+itemList[position].image
        Picasso.get().load(path).into(image)
//        Log.e("path path"," path path.. $path")
        container.addView(view, position)
        return view
    }
    override fun getCount(): Int {
        return itemList.size
    }
    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}