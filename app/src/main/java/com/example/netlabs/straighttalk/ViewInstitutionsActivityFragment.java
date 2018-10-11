package com.example.netlabs.straighttalk;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netlabs.straighttalk.model.database.entities.Institutions;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;
import com.example.netlabs.straighttalk.viewmodel.InstitutionsViewModel;
import com.example.netlabs.straighttalk.viewmodel.PersonalDetailsViewModel;
import com.example.netlabs.straighttalk.views.InstitutionsRecyclerViewAdapter;
import com.example.netlabs.straighttalk.views.PersonalDetailsRecyclerViewAdapter;

import java.util.List;

public class ViewInstitutionsActivityFragment extends Fragment {
    RecyclerView Institutions_recyclerView;
    private InstitutionsRecyclerViewAdapter recyclerViewAdapter;
    private InstitutionsViewModel viewModel;

    public ViewInstitutionsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_view_institutions, container, false);

        Institutions_recyclerView = root.findViewById(R.id.Institutions_list_recyclerview);
        recyclerViewAdapter = new InstitutionsRecyclerViewAdapter(getActivity());
        Institutions_recyclerView.setAdapter(recyclerViewAdapter);
        Institutions_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        viewModel.getInstitutions().observe((LifecycleOwner) this, new Observer<List<Institutions>>() {
//            @Override
//            public void onChanged(@Nullable List<Institutions> institutions) {
//                recyclerViewAdapter.setInstitutions(institutions);
//            }
//        });

        return root;
    }

    public InstitutionsRecyclerViewAdapter getAdapter() {
        return recyclerViewAdapter;
    }
}
