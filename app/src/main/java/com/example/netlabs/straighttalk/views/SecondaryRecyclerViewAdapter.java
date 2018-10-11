package com.example.netlabs.straighttalk.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.netlabs.straighttalk.R;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;

import java.util.List;

public class SecondaryRecyclerViewAdapter extends RecyclerView.Adapter<SecondaryRecyclerViewAdapter.SecondaryViewHolder> {
    LayoutInflater inflater;
    List<Secondary> SchoolsList;

    public SecondaryRecyclerViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SecondaryViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup, int i
    ) {
        View itemView = inflater.inflate(
                R.layout.view_secondary_list_item,
                viewGroup,
                false
        );
        return new SecondaryRecyclerViewAdapter.SecondaryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(
            @NonNull SecondaryRecyclerViewAdapter
                    .SecondaryViewHolder secondaryViewHolder, int i) {
//        if (SchoolsList != null) {
//            Secondary schools = SchoolsList.get(i);
//            secondaryViewHolder.secondaryTitleTextView.setText(
//                    schools.getSsName() + ", " + schools.getSsStream() + " <" +
//                            schools.getSsForm() + ">");
//        } else {
//            secondaryViewHolder.secondaryTitleTextView.setText("No details");
//        }
    }

    @Override
    public int getItemCount() {
        if (SchoolsList != null) {
            return SchoolsList.size();
        } else return 0;
    }

    public void setSecondary(List<Secondary> SchoolsList) {
        this.SchoolsList = SchoolsList;
        notifyDataSetChanged();
    }

    class SecondaryViewHolder extends RecyclerView.ViewHolder {
        private final TextView secondaryTitleTextView;

        private SecondaryViewHolder(View itemView) {
            super(itemView);
            secondaryTitleTextView = itemView.findViewById(R.id.secondary_title_textView);
        }
    }
}