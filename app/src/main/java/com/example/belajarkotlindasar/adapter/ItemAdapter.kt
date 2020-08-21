package com.example.belajarkotlindasar.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarkotlindasar.R
import com.example.belajarkotlindasar.model.Item

class ItemAdapter(val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val items : MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        holder.bindmodel(items[position])
    }

    fun setItem(data: List<Item>){
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val Title : TextView = item.findViewById(R.id.txt_title)
        val Description : TextView = item.findViewById(R.id.txt_deskrip)

        fun bindmodel(i: Item) {

            Title.text = i.getTitle()
            Description.text = i.getDescription()
        }
    }
}