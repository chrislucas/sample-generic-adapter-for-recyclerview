package com.xp.samplegenericadapterforrecyclerview.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.Binder
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.BuilderHelperViewHolder
import com.xp.samplegenericadapterforrecyclerview.R

import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.SimpleViewHolderWithCardView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.GenericAdapterForRecyclerView
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.GenericAdapterForRecyclerViewWithFilter

class SampleListCardViewFragment : Fragment(), SearchView.OnQueryTextListener  {

    private var columnCount = 1
    private lateinit var filterAdapter : GenericAdapterForRecyclerViewWithFilter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_samplelistcardview_list, container, false)

        activity?.let {
            it.supportFragmentManager.beginTransaction()
                .replace(
                    R.id.layout_toolbar
                    , SearchFragment.newInstance()
                    , SearchFragment.getTag()
                ).commit()
        }
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter =
                    GenericAdapterForRecyclerView(
                        resources.getStringArray(R.array.loren_ipsum_samples).toList()
                        , generateBinderForCardView()
                    )
            }
        }
        return view
    }

    private fun generateBinderForCardView(): Binder<String> {
        return object :
            Binder<String> {
            override fun onClick(viewHolder: RecyclerView.ViewHolder, data: List<String>) {
                when (viewHolder) {
                    is SimpleViewHolderWithCardView -> {
                        viewHolder.viewRoot.setOnClickListener {
                            Log.i("TAG_${javaClass.simpleName}", data[viewHolder.adapterPosition])
                        }
                    }
                }
            }

            override fun fill(viewHolder: RecyclerView.ViewHolder, data: String) {
                val layout = viewHolder as SimpleViewHolderWithCardView
                layout.title.text = data
            }

            override fun getViewHolder(viewType: Int, viewRoot: ViewGroup): RecyclerView.ViewHolder =
                BuilderHelperViewHolder.builder(
                    viewType
                    , viewRoot
                )

            override fun getItemViewType(data: String): Int =
                BuilderHelperViewHolder.VIEW_HOLDER_SIMPLE_CARD_VIEW
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            filterAdapter.search(it)
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let {
            filterAdapter.search(it)
        }
        return true
    }


    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            SampleListCardViewFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }

        fun getTag0(): String = SampleListCardViewFragment::class.java.simpleName
    }
}
