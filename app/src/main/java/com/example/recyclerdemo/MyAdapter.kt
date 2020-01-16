package com.example.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(var myList: ArrayList<String>): RecyclerView.Adapter<MyAdapter.MyHolder>() {



    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.textView // find
        var button = itemView.button

        init {
            button.setOnClickListener { v -> Toast.makeText(itemView.context,textView.text.toString(), Toast.LENGTH_SHORT).show() }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textView.text = myList[position]
    }


    fun deleteAt(position: Int) {

        notifyItemRemoved(position) // cap nhat lai giao dien
    }
}