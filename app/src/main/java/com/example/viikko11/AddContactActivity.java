package com.example.viikko11;

import static com.example.viikko11.R.id.PersonalRadioButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddContactActivity extends AppCompatActivity {


    private EditText NameInput;
    private EditText LastNameInput;
    private EditText NumberInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        NameInput = findViewById(R.id.FirstNameEdit);
        LastNameInput = findViewById(R.id.LastNameEdit);
        NumberInput = findViewById(R.id.PhoneNumberEdit);

    }
    public void AddContactButton(View view){

        String firstName = null;
        String lastName = null;
        String number = null;
        String contactGroup = null;

        //tähän väliin lisää tietojen lisäys
        //tässä saadaan laatioista arvot
        firstName = NameInput.getText().toString();
        lastName = LastNameInput.getText().toString();
        number = NumberInput.getText().toString();


        RadioGroup rgContactType = findViewById(R.id.ContactTypeRadioGroup);
        int selectedId = rgContactType.getCheckedRadioButtonId();

        if (selectedId == R.id.PersonalRadioButton) {
            contactGroup = "personal";
        } else if (selectedId == R.id.WorkRadioButton) {
            contactGroup = "work";
        }
        Contact contact = new Contact(firstName, lastName, number, contactGroup);

        ContactStorage.getInstance().addContact(contact);
    }

}