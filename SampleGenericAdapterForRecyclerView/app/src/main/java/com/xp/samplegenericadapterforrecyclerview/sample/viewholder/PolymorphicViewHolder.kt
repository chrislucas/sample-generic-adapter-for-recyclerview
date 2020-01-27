package com.xp.samplegenericadapterforrecyclerview.sample.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PolymorphicViewHolder(itemView: View, fn : () -> RecyclerView.ViewHolder ?) : RecyclerView.ViewHolder(itemView)