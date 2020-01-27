package com.xp.samplegenericadapterforrecyclerview.sample.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.R

class SimpleViewHolderWithCardView(val viewRoot: View) : RecyclerView.ViewHolder(viewRoot) {
    val title : TextView = viewRoot.findViewById(R.id.text_view_title)
}