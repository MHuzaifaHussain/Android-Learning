package com.example.firebasesample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()){
                Log.e("TokenDetails", "Token Failed to receive!");
                return;
            }
            String token = task.getResult();
            Log.d("TOKEN", token);
        });


        //Single Node Data
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("CopyWright");
        databaseReference.setValue("H-Codes, All rights Reserved");
        //Multiple Nested Child Data
        DatabaseReference contactRef = FirebaseDatabase.getInstance().getReference("contacts");
        String contactID=contactRef.push().getKey();
        ContactModel contactModel = new ContactModel("John", "0987654321");
        contactRef.child(contactID).setValue(contactModel);
        // Receiving Data
        contactRef.child(contactID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ContactModel contactModel1 = snapshot.getValue(ContactModel.class);
                Log.d("Contact", contactModel1.getName()+", "+contactModel1.getMobNo());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("DB Error", error.toString());

            }
        });
    }
}