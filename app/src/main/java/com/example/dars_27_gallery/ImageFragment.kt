package com.example.dars_27_gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_image.*

private const val KEY = "key"
private const val NOT_FOUND = 0

class ImageFragment : Fragment() {

    private var drawableId: Int = NOT_FOUND

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drawableId = arguments?.getInt(KEY, NOT_FOUND) ?: NOT_FOUND
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (drawableId != NOT_FOUND) {
            iv.setImageResource(drawableId)
        }
    }

    companion object {
        fun create(@DrawableRes id: Int): ImageFragment {
            val fr = ImageFragment()
            val bundle = Bundle()
            bundle.putInt(KEY, id)
            fr.arguments = bundle
            return fr
        }
    }
}