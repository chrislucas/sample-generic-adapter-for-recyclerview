package com.xp.samplegenericadapterforrecyclerview.views

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment

import com.xp.samplegenericadapterforrecyclerview.R

/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {

    private var queryListener: QueryListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is QueryListener) {
            queryListener = context
        }
    }

    private interface QueryListener : SearchView.OnQueryTextListener

    companion object {
        fun newInstance() = SearchFragment()

        fun getTag(): String = SearchFragment::class.java.simpleName
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.let {
            it.menuInflater.inflate(R.menu.menu_search, menu)
        }
        menu?.apply {
            val menuSearch : MenuItem = this.findItem(R.id.search_bar_item)
            val searchView = menuSearch.actionView as SearchView
            queryListener?.let {
                searchView.setOnQueryTextListener(it)
            }
        }
    }

}
