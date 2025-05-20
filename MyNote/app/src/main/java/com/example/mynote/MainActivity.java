package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btnCreateNote;
    FloatingActionButton fabAdd;
    RecyclerView recyclerNotes;
    DatabaseHelper databaseHelper;
    LinearLayout llNoNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVar();
        showNotes();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_note_lay);

                EditText edtTtle, edtContent;
                AppCompatButton btnAdd;

                edtTtle = dialog.findViewById(R.id.edtTitle);
                edtContent = dialog.findViewById(R.id.edtContent);
                btnAdd = dialog.findViewById(R.id.btnAdd);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String title =edtTtle.getText().toString();
                        String content =edtContent.getText().toString();
                        if (!content.equals("")){

                            databaseHelper.noteDao().addNote(new Note(title,content));
                            showNotes();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(MainActivity.this, "Please enter something!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
            }
        });
        btnCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabAdd.performClick();
            }
        });

    }

    public void showNotes() {
        ArrayList<Note> arrNotes = (ArrayList<Note>) databaseHelper.noteDao().getNotes();

        if (arrNotes.size()>0){
            recyclerNotes.setVisibility(View.VISIBLE);
            llNoNotes.setVisibility(View.GONE);
            recyclerNotes.setAdapter(new RecyclerNotesAdapter(this, arrNotes, databaseHelper));
        }else{
            llNoNotes.setVisibility(View.VISIBLE);
            recyclerNotes.setVisibility(View.GONE);
        }
    }

    private void initVar() {
        btnCreateNote= findViewById(R.id.btnCreateNote);
        fabAdd = findViewById(R.id.fabAdd);
        recyclerNotes = findViewById(R.id.recyclerNotes);
        recyclerNotes.setLayoutManager(new GridLayoutManager(this, 2));
        databaseHelper = DatabaseHelper.getInstance(this);
        llNoNotes = findViewById(R.id.llNoNotes);
    }
}