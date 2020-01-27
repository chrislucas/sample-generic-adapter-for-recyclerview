package com.xp.samplegenericadapterforrecyclerview.sample.viewholder

import android.widget.Filter
import android.widget.Filterable
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.GenericAdapterForRecyclerView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.Binder

class GenericAdapterForRecyclerViewWithFilter<T>(
    private val data: List<T>,
    private val binder: Binder<T>,
    private val filter: Filter
) : GenericAdapterForRecyclerView<T>(data, binder), Filterable {

    override fun getFilter(): Filter = filter
}

