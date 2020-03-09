package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter

import android.widget.Filter
import android.widget.Filterable
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.Binder

class GenericAdapterForRecyclerViewWithFilter<T>(
    private var data: List<T>,
    private val binder: Binder<T>,
    private val filter: Filter
) : GenericAdapterForRecyclerView<T>(data, binder), Filterable {

    private val originalData = arrayListOf(data)

    fun search(text: String) {
        filter.filter(text)
    }

    override fun getFilter(): Filter = filter
}

