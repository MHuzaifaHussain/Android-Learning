package com.example.mynote;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerNotesAdapter extends RecyclerView.Adapter<RecyclerNotesAdapter.ViewHolder> {
    Context context;
    ArrayList<Note> arrNotes = new ArrayList<>();
    DatabaseHelper databaseHelper;

    public RecyclerNotesAdapter(Context context, ArrayList<Note> arrNotes, DatabaseHelper databaseHelper) {
        this.context = context;
        this.arrNotes = arrNotes;
        this.databaseHelper = databaseHelper;
    }

    @NonNull
    @Override
    public RecyclerNotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerNotesAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(arrNotes.get(position).getTitle());
        holder.txtContent.setText(arrNotes.get(position).getContent());
        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

               deleteItem(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llRow;
        TextView txtTitle, txtContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llRow = itemView.findViewById(R.id.llRow);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContext);
        }
    }
    public void deleteItem(int pos){
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle("Delete")
                .setMessage("Are you sure want to delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        databaseHelper.noteDao().deleteNote(new Note(arrNotes.get(pos).getId(),
                                arrNotes.get(pos).getTitle(), arrNotes.get(pos).getContent()));
                        ((MainActivity)context).showNotes();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
}
