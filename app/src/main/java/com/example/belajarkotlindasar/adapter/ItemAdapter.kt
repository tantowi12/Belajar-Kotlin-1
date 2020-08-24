package com.example.belajarkotlindasar.adapter

import android.content.Context
import android.content.Intent
import android.location.Location
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarkotlindasar.DetailItem
import com.example.belajarkotlindasar.LocationFragment
import com.example.belajarkotlindasar.R
import com.example.belajarkotlindasar.listener.OnItemClickListener
import com.example.belajarkotlindasar.model.Item

class ItemAdapter(val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val items : MutableList<Item> = mutableListOf()
    private var onSelectedListener : OnItemClickListener? = null

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

    fun getItems(): MutableList<Item> {
        return items
    }

    inner class ItemViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        val Title : TextView = item.findViewById(R.id.txt_title)
        val Description : TextView = item.findViewById(R.id.txt_deskrip)
        val cardView1 : CardView = item.findViewById(R.id.cv_item1)



        fun bindmodel(a: Item) {

            Title.text = a.getTitle()
            Description.text = a.getDescription()

//            cardView1.setOnClickListener {
//                var i = Intent(context, DetailItem::class.java)
//                i.putExtra("title", a.getTitle())
//                i.putExtra("description", a.getDescription())
//                context.startActivity(i)
//            }
        }

        init {
            cardView1.setOnClickListener{ onSelectedListener?.onItemClick(it, layoutPosition)}
        }
    }

    fun setonClickItemListener(onClickItemListener: OnItemClickListener) {
        this.onSelectedListener = onClickItemListener
    }
}