package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.IntDef
import androidx.recyclerview.widget.RecyclerView
import com.xp.samplegenericadapterforrecyclerview.R
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.PolymorphicViewHolder
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.SimpleViewHolderWithCardView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.SimpleViewHolderWithTextView

class BuilderHelperViewHolder {

    companion object {

        @IntDef(
            VIEW_HOLDER_SIMPLE_CARD_VIEW,
            VIEW_HOLDER_TEXT_VIEW
        )
        @Retention(AnnotationRetention.SOURCE)
        annotation class ViewType
        const val VIEW_HOLDER_SIMPLE_CARD_VIEW = 0
        const val VIEW_HOLDER_TEXT_VIEW = 1

        @JvmStatic
        fun builder(
            @ViewType viewType: Int
            , viewRoot: ViewGroup
            , createViewHolder: () -> RecyclerView.ViewHolder? = { null }
        ): RecyclerView.ViewHolder {
            return when (viewType) {
                VIEW_HOLDER_SIMPLE_CARD_VIEW -> {
                    SimpleViewHolderWithCardView(LayoutInflater.from(viewRoot.context).inflate(
                        R.layout.item_card_view, viewRoot, false))
                }
                VIEW_HOLDER_TEXT_VIEW ->{
                    SimpleViewHolderWithTextView(LayoutInflater.from(viewRoot.context).inflate(
                        R.layout.item_text_view, viewRoot, false))
                }
                else -> {
                    PolymorphicViewHolder(viewRoot, createViewHolder)
                }
            }
        }
    }

}