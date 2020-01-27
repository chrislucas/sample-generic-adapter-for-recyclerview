package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface Binder<T> {

    //fun onClick(viewHolder: RecyclerView.ViewHolder, data: List<T>)

    fun onClick(viewHolder: RecyclerView.ViewHolder, data: T)

    fun getItemViewType(data : T) : Int

    fun fill(viewHolder: RecyclerView.ViewHolder, data: T)

    fun getViewHolder(viewType: Int, viewRoot: ViewGroup) : RecyclerView.ViewHolder

}