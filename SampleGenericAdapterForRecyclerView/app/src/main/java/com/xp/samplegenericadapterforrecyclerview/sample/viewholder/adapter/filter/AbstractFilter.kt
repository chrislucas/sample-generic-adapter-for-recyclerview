package com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.filter

import android.widget.Filter

abstract class AbstractFilter<T>(
    private val originalList: MutableList<T>,
    private val predicate: (T, CharSequence) -> Boolean
) : Filter() {

    private val filterResults = FilterResults()

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        if (constraint.isNullOrEmpty()) {
            constraintException()
        } else {
            val copy = originalList.toList()
            val filteredList = filter(copy, constraint)
            originalList.let {
                it.clear()
                it.addAll(filteredList)
            }
        }

        return filterResults.also {
            it.values = originalList
        }
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        if (originalList.isNullOrEmpty()) {
            searchableListException()
        } else {
            notifyChange()
        }
    }

    abstract fun constraintException()

    abstract fun searchableListException()

    abstract fun notifyChange()

    private fun filter(searchableList: List<T>, text: CharSequence) =
        searchableList.filter { predicate(it, text) }
}