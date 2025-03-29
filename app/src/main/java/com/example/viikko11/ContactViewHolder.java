package com.example.viikko11;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    TextView Fullname, number, group;
    Button CDetails, CDelete;


    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        Fullname = itemView.findViewById(R.id.ContactNameText);
        number = itemView.findViewById(R.id.ContactNumberText);
        group = itemView.findViewById(R.id.ContactGroupText);

        CDetails = itemView.findViewById(R.id.ContactDetailsButton);
        CDelete = itemView.findViewById(R.id.ContactDeleteButton);
    }
}
