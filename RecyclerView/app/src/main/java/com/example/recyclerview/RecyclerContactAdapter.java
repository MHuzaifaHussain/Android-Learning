package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {


    Context context;
    ArrayList<ContactModel> arrContacts;

    private int lastPosition = -1;

    private int position;

    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        this.position = position;
        ContactModel model = (ContactModel) arrContacts.get(position);
//        holder.getAdapterPosition(position);
        holder.imgContact.setImageResource(model.img);
        holder.txtName.setText(model.name);
        holder.txtNumber.setText(model.number);


        setAnimation(holder.itemView,position);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog= new Dialog(context);
                dialog.setContentView(R.layout.add_uupdate_lay);

                EditText edtName= dialog.findViewById(R.id.edtName);
                EditText edtNumber= dialog.findViewById(R.id.edtNumber);
                AppCompatButton btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtTitle= dialog.findViewById(R.id.txtTitle);

                txtTitle.setText("Update Contact");
                btnAction.setText("Update");

                edtName.setText((arrContacts.get(position)).name);
                edtNumber.setText((arrContacts.get(position)).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name ="", number= "";
                        if(!edtName.getText().toString().equals("")){
                            name = edtName.getText().toString();
                        }else{
                            Toast.makeText(context, "Please Enter Contact Name", Toast.LENGTH_SHORT).show();
                        }
                        if(!edtNumber.getText().toString().equals("")) {

                            number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(context, "Please enter contact Number", Toast.LENGTH_SHORT).show();

                        }

                        arrContacts.set(position, new ContactModel(arrContacts.get(position).img,name, number));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are You sure want to delete?")
                        .setIcon(R.drawable.ic_baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {

        return arrContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout llRow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName= itemView.findViewById(R.id.txtName);
            txtNumber= itemView.findViewById(R.id.txtNumber);
            imgContact= itemView.findViewById(R.id.imgContact);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }

    private void setAnimation(View viewToAnimate, int position){

        if (position> lastPosition){


        Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewToAnimate.startAnimation(slideIn);
        lastPosition=position;
    }}
}
