package com.example.recylerviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_row.view.*
import java.security.AccessControlContext

class RecylerContactAdapter(val context: Context,val arrContact: ArrayList<ContactModel>): RecyclerView.Adapter<RecylerContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgContact = itemView.imgContact
        val txtName = itemView.txtName
        val txtNumber = itemView.txtNumber
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_row, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.imgContact.setImageResource(arrContact[position].img)
        holder.txtName.text= arrContact[position].name
        holder.txtNumber.text= arrContact[position].number
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

}