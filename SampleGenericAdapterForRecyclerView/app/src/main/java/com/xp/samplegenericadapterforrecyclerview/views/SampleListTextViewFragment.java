package com.xp.samplegenericadapterforrecyclerview.views;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xp.samplegenericadapterforrecyclerview.R;
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.GenericAdapterForRecyclerView;
import com.xp.samplegenericadapterforrecyclerview.sample.viewholder.adapter.binder.BinderViewHolderNotMapped;

import java.util.Arrays;


public class SampleListTextViewFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SampleListTextViewFragment() {
    }


    public static SampleListTextViewFragment newInstance(int columnCount) {
        SampleListTextViewFragment fragment = new SampleListTextViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_samplelisttextview_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new GenericAdapterForRecyclerView<>(
                    Arrays.asList(getResources().getStringArray(R.array.loren_ipsum_samples))
                    , new BinderViewHolderNotMapped())
            );
        }
        return view;
    }

    public static String getTag0() {
        return SampleListTextViewFragment.class.getSimpleName();
    }
}
