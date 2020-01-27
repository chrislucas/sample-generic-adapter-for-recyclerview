package com.xp.samplegenericadapterforrecyclerview.sample.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.R

class SimpleViewHolderWithTextView(val itemRoot: View) : RecyclerView.ViewHolder(itemRoot) {
    val textView = itemRoot.findViewById<TextView>(R.id.title)
}