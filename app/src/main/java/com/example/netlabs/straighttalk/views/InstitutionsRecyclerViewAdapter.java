package com.example.netlabs.straighttalk.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.netlabs.straighttalk.R;
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
    public InstitutionsRecyclerViewAdapter.InstitutionsViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int i
    ) {
        View itemView = inflater.inflate(
                R.layout.view_institutions_list_item,
                viewGroup,
                false
        );
        return new InstitutionsRecyclerViewAdapter.InstitutionsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(
            @NonNull InstitutionsRecyclerViewAdapter
                    .InstitutionsViewHolder institutionsViewHolder, int i) {
//        if (detailsList != null) {
//            Institutions details = detailsList.get(i);
//            institutionsViewHolder.institutionsTitleTextView.setText(
//                    details.getStudentNumber() + ", " + details.getStudentNumber() + " <" +
//                            details.getRegistrationNumber() + ">");
//        } else {
//            institutionsViewHolder.institutionsTitleTextView.setText("No details");
//        }
    }

    @Override
    public int getItemCount() {
        if (detailsList != null) {
            return detailsList.size();
        }
        else return 0;
    }

//    public void setInstitutions(List<Institutions> detailsList) {
//        this.detailsList = detailsList;
//        notifyDataSetChanged();
//    }

    class InstitutionsViewHolder extends RecyclerView.ViewHolder {
        private final TextView institutionsTitleTextView;

        private InstitutionsViewHolder(View itemView) {
            super(itemView);
            institutionsTitleTextView = itemView.findViewById(R.id.institutions_title_textView);
        }
    }
}
