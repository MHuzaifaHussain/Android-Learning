package com.example.recylerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrContact = ArrayList<ContactModel>()

        arrContact.add(ContactModel(R.drawable.images,"A", "0987654321"))
        arrContact.add(ContactModel(R.drawable.images,"B", "0887654321"))
        arrContact.add(ContactModel(R.drawable.images,"C", "0787654321"))
        arrContact.add(ContactModel(R.drawable.images,"D", "0687654321"))
        arrContact.add(ContactModel(R.drawable.images,"E", "0587654321"))
        arrContact.add(ContactModel(R.drawable.images,"F", "0487654321"))
        arrContact.add(ContactModel(R.drawable.images,"G", "0387654321"))
        arrContact.add(ContactModel(R.drawable.images,"H", "0287654321"))
        arrContact.add(ContactModel(R.drawable.images,"I", "0187654321"))
        arrContact.add(ContactModel(R.drawable.images,"J", "0087654321"))
        arrContact.add(ContactModel(R.drawable.images,"K", "0997654321"))
        arrContact.add(ContactModel(R.drawable.images,"L", "0887654321"))
        arrContact.add(ContactModel(R.drawable.images,"M", "0777654321"))
        arrContact.add(ContactModel(R.drawable.images,"N", "0667654321"))
        arrContact.add(ContactModel(R.drawable.images,"O", "0557654321"))
        arrContact.add(ContactModel(R.drawable.images,"P", "0447654321"))
        arrContact.add(ContactModel(R.drawable.images,"Q", "0337654321"))
        arrContact.add(ContactModel(R.drawable.images,"R", "0227654321"))
        arrContact.add(ContactModel(R.drawable.images,"S", "0117654321"))
        arrContact.add(ContactModel(R.drawable.images,"T", "0007654321"))
        arrContact.add(ContactModel(R.drawable.images,"U", "0999654321"))
        arrContact.add(ContactModel(R.drawable.images,"V", "0888654321"))
        arrContact.add(ContactModel(R.drawable.images,"W", "0777654321"))
        arrContact.add(ContactModel(R.drawable.images,"X", "0666654321"))
        arrContact.add(ContactModel(R.drawable.images,"Y", "0555654321"))
        arrContact.add(ContactModel(R.drawable.images,"Z", "0444654321"))

        recylerView.layoutManager= GridLayoutManager(this,3)
        val recylerAdapter = RecylerContactAdapter(this, arrContact)
        recylerView.adapter = recylerAdapter
    }

}