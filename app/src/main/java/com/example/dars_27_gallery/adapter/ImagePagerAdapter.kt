package com.example.dars_27_gallery.adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.dars_27_gallery.ImageFragment

class ImagePagerAdapter(
    fm: FragmentManager,
    private val list: List<Int>
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = ImageFragment.create(list[position])

    override fun getCount() = list.size
}