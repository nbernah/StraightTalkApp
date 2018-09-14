package com.example.netlabs.straighttalk;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.viewmodel.SecondaryViewModel;
import com.example.netlabs.straighttalk.views.SecondaryRecyclerViewAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewSecondaryActivityFragment extends Fragment {
    RecyclerView Secondary_recyclerView;
    private SecondaryRecyclerViewAdapter recyclerViewAdapter;
    private SecondaryViewModel viewModel;

    public ViewSecondaryActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_view_secondary, container, false);

        Secondary_recyclerView = root.findViewById(R.id.Secondary_list_recyclerview);
        recyclerViewAdapter = new SecondaryRecyclerViewAdapter(getActivity());
        Secondary_recyclerView.setAdapter(recyclerViewAdapter);
        Secondary_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel = ViewModelProviders.of(this).get(SecondaryViewModel.class);
        viewModel.getSecondarySchools().observe(this, new Observer<List<Secondary>>() {
            @Override
            public void onChanged(@Nullable List<Secondary> secondary) {
                recyclerViewAdapter.setSecondary(secondary);
            }
        });

        return root;
    }

    public SecondaryRecyclerViewAdapter getAdapter() {
        return recyclerViewAdapter;
    }
}


