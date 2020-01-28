package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.SimpleViewHolderWithTextView

class BinderViewHolderTextView :
    Binder<String> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: List<String>) {
        val viewRoot = viewHolder as SimpleViewHolderWithTextView
        viewRoot.itemRoot.setOnClickListener {
            Log.i("TAG_${javaClass.simpleName}", data[viewHolder.adapterPosition])
        }
    }

    override fun fill(viewHolder: RecyclerView.ViewHolder, data: String) {
        val vh = viewHolder as SimpleViewHolderWithTextView
        vh.textView.text = data
    }

    override fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder =
        BuilderHelperViewHolder.builder(viewType, viewRoot)

    override fun getItemViewType(data: String): Int = BuilderHelperViewHolder.VIEW_HOLDER_TEXT_VIEW
}