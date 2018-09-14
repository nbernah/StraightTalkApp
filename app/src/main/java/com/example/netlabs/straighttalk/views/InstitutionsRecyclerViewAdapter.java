package com.example.netlabs.straighttalk.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netlabs.straighttalk.model.database.entities.Institution;


import java.util.List;

public class InstitutionsRecyclerViewAdapter extends RecyclerView.Adapter<InstitutionsRecyclerViewAdapter.InstitutionsViewHolder> {
    LayoutInflater inflater;
    List<Institution> detailsList;

    public InstitutionsRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public InstitutionsRecyclerViewAdapter.InstitutionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InstitutionsRecyclerViewAdapter.InstitutionsViewHolder institutionsViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class InstitutionsViewHolder extends RecyclerView.ViewHolder {
        public InstitutionsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
