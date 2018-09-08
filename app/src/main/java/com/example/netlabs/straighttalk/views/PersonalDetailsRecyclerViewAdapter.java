package com.example.netlabs.straighttalk.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.netlabs.straighttalk.R;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;

import java.util.List;

public class PersonalDetailsRecyclerViewAdapter extends RecyclerView.Adapter<PersonalDetailsRecyclerViewAdapter.PersonalDetailsViewHolder> {

    LayoutInflater inflater;
    List<PersonalDetails> detailsList;

    public PersonalDetailsRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public PersonalDetailsRecyclerViewAdapter.PersonalDetailsViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int i
    ) {
        View itemView = inflater.inflate(
                R.layout.view_personal_details_list_item,
                viewGroup,
                false
        );
        return new PersonalDetailsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(
            @NonNull PersonalDetailsRecyclerViewAdapter
                    .PersonalDetailsViewHolder personalDetailsViewHolder, int i) {
        if (detailsList != null) {
            PersonalDetails details = detailsList.get(i);
            personalDetailsViewHolder.personalDetailsTitleTextView.setText(
                    details.getStudFamilyName() + ", " + details.getStudGivenName() + " <" +
            details.getStudContactEmail() + ">");
        } else {
            personalDetailsViewHolder.personalDetailsTitleTextView.setText("No details");
        }
    }

    @Override
    public int getItemCount() {
        if (detailsList != null) {
            return detailsList.size();
        }
        else return 0;
    }

    public void setPersonalDetails(List<PersonalDetails> detailsList) {
        this.detailsList = detailsList;
        notifyDataSetChanged();
    }

    class PersonalDetailsViewHolder extends RecyclerView.ViewHolder {
        private final TextView personalDetailsTitleTextView;

        private PersonalDetailsViewHolder(View itemView) {
            super(itemView);
            personalDetailsTitleTextView = itemView.findViewById(R.id.personal_details_title_textView);
        }
    }
}
