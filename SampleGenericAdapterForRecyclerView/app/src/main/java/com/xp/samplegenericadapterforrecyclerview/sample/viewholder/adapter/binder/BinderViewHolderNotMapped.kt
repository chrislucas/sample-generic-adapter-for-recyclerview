package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.R
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.SimpleViewHolderWithConstraintLayout

class BinderViewHolderNotMapped : Binder<String> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: String) {}

    override fun getItemViewType(data: String): Int = BuilderHelperViewHolder.VIEW_HOLDER_NOT_MAPPED

    override fun fill(viewHolder: RecyclerView.ViewHolder, data: String) {}

    override fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder =
        BuilderHelperViewHolder.builder(viewType, viewRoot = viewRoot) { _, vr ->
            SimpleViewHolderWithConstraintLayout(
                LayoutInflater.from(vr.context).inflate(
                    R.layout.item_constraint_layout_not_mapped,
                    vr,
                    false
                )
            )
        }
}