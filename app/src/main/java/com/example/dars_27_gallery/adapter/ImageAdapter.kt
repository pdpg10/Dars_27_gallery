package com.example.dars_27_gallery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.dars_27_gallery.R
import com.example.dars_27_gallery.common.ItemClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.rv_item_layout.*

class ImageAdapter(
    context: Context,
    private val list: List<Int>
) : RecyclerView.Adapter<ImageAdapter.ImageVH>() {

    private val inflater by lazy { LayoutInflater.from(context) }
    private val listener by lazy { context as ItemClickListener }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageVH {
        val v = inflater.inflate(R.layout.rv_item_layout, parent, false)
        return ImageVH(v, listener)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(
        holder: ImageVH,
        position: Int
    ) {
        holder.onBind(list[position])
    }


    class ImageVH(
        override val containerView: View,
        listener: ItemClickListener
    ) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        init {
            containerView.setOnClickListener { listener.onItemClick(adapterPosition) }
        }

        fun onBind(@DrawableRes id: Int) {
            iv.setImageResource(id)
        }
    }
}