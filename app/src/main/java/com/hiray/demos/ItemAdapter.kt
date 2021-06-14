package com.hiray.demos

import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by hiray on 2018/5/24.
 *@author hiray
 */
class ItemAdapter(private var items: ArrayList<String>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var layoutInflater: LayoutInflater? = null
    private val layoutId = R.layout.demo_item


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(layoutInflater?.inflate(layoutId, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = items[holder.adapterPosition]
    }


    class ItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var textView: AppCompatTextView = itemView?.findViewById(R.id.item_name) as AppCompatTextView
    }
}