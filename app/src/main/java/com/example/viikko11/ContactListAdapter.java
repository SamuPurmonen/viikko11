package com.example.viikko11;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactListAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private Context context;
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ContactListAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.contactviewholder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.Fullname.setText(contacts.get(position).getFullName());
        holder.number.setText(contacts.get(position).getNumber());
        holder.group.setText(contacts.get(position).getContactGroup());

        holder.CDelete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ContactStorage.getInstance().removeContact(contacts.get(pos).getNumber());
            notifyItemRemoved(pos);
        });

        holder.CDetails.setOnClickListener(view ->{
            int pos = holder.getAdapterPosition();

            if (holder.number.getVisibility() == view.VISIBLE) {


            } else {
                holder.number.setVisibility(View.VISIBLE);
                holder.group.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }


}
