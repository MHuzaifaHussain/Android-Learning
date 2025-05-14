package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContacts =new ArrayList<>();

    RecyclerContactAdapter adapter;
    RecyclerView recyclerView;
    FloatingActionButton btnOpenDialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.recyclerContact);
        btnOpenDialogue= findViewById(R.id.btnOpenDialogue);


        btnOpenDialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_uupdate_lay);

                EditText edtName= dialog.findViewById(R.id.edtName);
                EditText edtNumber= dialog.findViewById(R.id.edtNumber);
                AppCompatButton btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name ="", number= "";
                        if(!edtName.getText().toString().equals("")){
                         name = edtName.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this, "Please enter contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals("")) {

                             number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(MainActivity.this, "Please enter contact Number", Toast.LENGTH_SHORT).show();

                        }

                        arrContacts.add(new ContactModel(R.drawable.logo,name, number));

                        adapter.notifyItemInserted(arrContacts.size()-1);


                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });





        recyclerView.setLayoutManager(new LinearLayoutManager(this));




//        ContactModel model = new ContactModel(R.drawable.logo, "A", "33345689"); 2nd way, only used when a object is to be used again and again
        arrContacts.add(new ContactModel(R.drawable.logo, "A", "33345689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "B", "33945689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "C", "33845689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "D", "33545689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "E", "33245689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "F", "33645689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "G", "33349689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "H", "33348689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "I", "33347689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "J", "33346689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "K", "33399689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "L", "33678689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "M", "33789689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "N", "33234689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "O", "33123689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "p", "33468569"));
        arrContacts.add(new ContactModel(R.drawable.logo, "Q", "33459748"));
        arrContacts.add(new ContactModel(R.drawable.logo, "R", "33456846"));
        arrContacts.add(new ContactModel(R.drawable.logo, "S", "33475689"));
        arrContacts.add(new ContactModel(R.drawable.logo, "T", "33348889"));
        arrContacts.add(new ContactModel(R.drawable.logo, "Y", "33345589"));
        arrContacts.add(new ContactModel(R.drawable.logo, "V", "33343389"));
        arrContacts.add(new ContactModel(R.drawable.logo, "W", "33342289"));
        arrContacts.add(new ContactModel(R.drawable.logo, "X", "33341189"));
        arrContacts.add(new ContactModel(R.drawable.logo, "Y", "33348889"));
        arrContacts.add(new ContactModel(R.drawable.logo, "Z", "33342689"));


        adapter = new RecyclerContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}