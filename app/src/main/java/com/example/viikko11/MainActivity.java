package com.example.viikko11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {


    private ContactStorage cs;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });



        cs = ContactStorage.getInstance();
        recyclerView = findViewById(R.id.ListContactsRv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), cs.getContacts()));



    }
    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), cs.getContacts())); // Refresh adapter
    }


    public void AddContactActivityButton(View view){
        //nappi joka siirtää addcontact activityyn
        Intent intent = new Intent(this, AddContactActivity.class);
        startActivity(intent);
    }



    public void SortAlphabeticallyButton(View view){
        //järkkää asiat aakkosjärjestykseen etunimen mukaan


        Collections.sort(cs.getContacts(), new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return Integer.valueOf((o1.firstName).compareTo(o2.firstName));
            }
        });

        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), cs.getContacts()));

    }

    public void SortByGroupButton(View view){
        //järkkää asiat aakkosjärjestykseen etunimen mukaan


        Collections.sort(cs.getContacts(), new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return Integer.valueOf((o1.contactGroup).compareTo(o2.contactGroup));
            }
        });

        recyclerView.setAdapter(new ContactListAdapter(getApplicationContext(), cs.getContacts()));

    }
}