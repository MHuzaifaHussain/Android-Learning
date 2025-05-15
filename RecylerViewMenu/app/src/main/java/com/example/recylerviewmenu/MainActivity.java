package com.example.recylerviewmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AppCompatButton btnList1, btnList2, btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrid =findViewById(R.id.btngrid);
        btnList1 =findViewById(R.id.btnList1);
        btnList2 =findViewById(R.id.btnList2);
        recyclerView = findViewById(R.id.recylerView);

        ArrayList<Food> foods = new ArrayList<>();

        foods.add(new Food("Arabian Delight", R.drawable.arabian_delight));
        foods.add(new Food("Arabian Shawarma", R.drawable.arabian_shawarma));
        foods.add(new Food("Biriyani", R.drawable.biriyani));
        foods.add(new Food("Qorma", R.drawable.qorma));
        foods.add(new Food("Ravi Charga", R.drawable.ravi_charga));
        foods.add(new Food("KFC", R.drawable.kfc));
        foods.add(new Food("Saviour Foods", R.drawable.saviour_foods));

        FoodAdapter adapter = new FoodAdapter(this,foods);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        btnList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(linearLayoutManager);
            }
        });

        btnList2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(linearLayoutManager1);
            }
        });

        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });
         recyclerView.setAdapter(adapter);
    }
}