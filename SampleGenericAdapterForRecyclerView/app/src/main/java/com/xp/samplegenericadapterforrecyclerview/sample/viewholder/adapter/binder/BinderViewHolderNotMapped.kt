package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.R
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.SimpleViewHolderWithConstraintLayout

class BinderViewHolderNotMapped : Binder<String> {

    override fun onClick(viewHolder: RecyclerView.ViewHolder, data: List<String>) {
        viewHolder.itemView.setOnClickListener {
            Log.i("TAG_${javaClass.simpleName}"
                , "${viewHolder.adapterPosition}: ${data[viewHolder.adapterPosition]}")
        }
    }

    override fun getItemViewType(data: String): Int = BuilderHelperViewHolder.VIEW_HOLDER_NOT_MAPPED

    override fun fill(viewHolder: RecyclerView.ViewHolder, data: String) {
        val vh = viewHolder as SimpleViewHolderWithConstraintLayout
        vh.title.text = data
    }

    override fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder {
        val function: (Int, ViewGroup) -> RecyclerView.ViewHolder = { _, vr ->
            SimpleViewHolderWithConstraintLayout(
                LayoutInflater.from(vr.context).inflate(
                    R.layout.item_constraint_layout_not_mapped,
                    vr,
                    false
                )
            )
        }
        return BuilderHelperViewHolder.builder(viewType, viewRoot, function)
    }

}