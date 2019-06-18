package com.example.dars_27_gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.viewpager.widget.ViewPager
import com.example.dars_27_gallery.adapter.ImageAdapter
import com.example.dars_27_gallery.adapter.ImagePagerAdapter
import com.example.dars_27_gallery.common.Constants
import com.example.dars_27_gallery.common.CubeOutRotationTransformation
import com.example.dars_27_gallery.common.ItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity
    : AppCompatActivity(),
    ItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf(*Constants.IMAGE_IDS)

        setUpRv(imageList)
        setUpViewPager(imageList)
    }
    //https://github.com/dipanshukr/Viewpager-Transformation/wiki/Cube-Out-Transformation

    private fun setUpViewPager(imageList: List<Int>) {
        val pagerAdapter = ImagePagerAdapter(
            supportFragmentManager
            , imageList
        )
        view_pager.adapter = pagerAdapter
//        view_pager.offscreenPageLimit
        view_pager.setPageTransformer(true, CubeOutRotationTransformation())
        view_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                rv.scrollToPosition(position)
            }
        })
    }

    private fun setUpRv(imageList: List<Int>) {
        rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.adapter = ImageAdapter(this, imageList)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(rv)
    }

    override fun onItemClick(index: Int) {
        view_pager.currentItem = index
    }

}
