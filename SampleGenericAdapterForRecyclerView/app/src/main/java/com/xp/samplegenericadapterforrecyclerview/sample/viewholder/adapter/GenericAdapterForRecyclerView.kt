package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.Binder


class GenericAdapterForRecyclerView<T>(private val data: List<T>, private val binder: Binder<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return binder.getViewHolder(viewType, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binder.fill(holder, data[position])
        binder.onClick(holder, data[position])
    }


    override fun getItemViewType(position: Int): Int = binder.getItemViewType(data[position])

}