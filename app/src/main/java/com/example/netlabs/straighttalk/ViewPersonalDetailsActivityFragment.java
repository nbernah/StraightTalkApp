package com.example.netlabs.straighttalk;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;
import com.example.netlabs.straighttalk.viewmodel.PersonalDetailsViewModel;
import com.example.netlabs.straighttalk.views.PersonalDetailsRecyclerViewAdapter;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ViewPersonalDetailsActivityFragment extends Fragment {

    RecyclerView Personal_Details_recyclerView;
    private PersonalDetailsRecyclerViewAdapter recyclerViewAdapter;
    private PersonalDetailsViewModel viewModel;

    public ViewPersonalDetailsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_view_personal_details, container, false);

        Personal_Details_recyclerView = root.findViewById(R.id.Personal_Details_list_recyclerview);
        recyclerViewAdapter = new PersonalDetailsRecyclerViewAdapter(getActivity());
        Personal_Details_recyclerView.setAdapter(recyclerViewAdapter);
        Personal_Details_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewModel = ViewModelProviders.of(this).get(PersonalDetailsViewModel.class);
        viewModel.getPersonalDetails().observe(this, new Observer<List<PersonalDetails>>() {
            @Override
            public void onChanged(@Nullable List<PersonalDetails> personalDetails) {
                recyclerViewAdapter.setPersonalDetails(personalDetails);
            }
        });

        return root;
    }

    public PersonalDetailsRecyclerViewAdapter getAdapter() {
        return recyclerViewAdapter;
    }
}
