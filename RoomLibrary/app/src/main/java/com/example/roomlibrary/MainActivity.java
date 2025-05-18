package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    AppCompatEditText edtTitle, edtAmount;
    AppCompatButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);
        edtTitle= findViewById(R.id.edtName);
        edtAmount=findViewById(R.id.edtAmount);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title= edtTitle.getText().toString();
                String amount= edtAmount.getText().toString();
                databaseHelper.expenseDao().addTx(
                        new Expense(title, amount)
                );
                ArrayList<Expense> arrExpenses = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();
                for(int i = 0; i<arrExpenses.size();i++){
                    Log.d("Data", "Title" + arrExpenses.get(i).getTitle() + " Amount: "+arrExpenses.get(i).getAmount());
                }
            }
        });


    }
}