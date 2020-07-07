package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactViewHolder(
    itemView: View,
    private val contactClickListener: ContactClickListener
) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener
{

    private val contactName: TextView = itemView.findViewById(R.id.item_contact_name)
    private val contactLastMessage: TextView = itemView.findViewById(R.id.item_contact_last_message)

    private var item: ContactViewData? = null

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        item?.let {
            contactClickListener.onContactClick(it)
        }
    }

    fun bind(item: ContactViewData) {
        this.item = item
        contactName.text = item.name
        contactLastMessage.text = item.lastMessage
    }
}