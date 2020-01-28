package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.Binder


open class GenericAdapterForRecyclerView<T>(
    private val data: List<T>,
    private val binder: Binder<T>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val vh = binder.getViewHolder(viewType, parent)
        binder.onClick(vh, data)
        return vh
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binder.fill(holder, data[position])
    }

    override fun getItemViewType(position: Int): Int = binder.getItemViewType(data[position])

}