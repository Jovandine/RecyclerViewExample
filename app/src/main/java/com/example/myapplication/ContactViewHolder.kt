package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    private val contactName: TextView = itemView.findViewById(R.id.item_contact_name)
    private val contactLastMessage: TextView = itemView.findViewById(R.id.item_contact_last_message)

    fun bind(item: ContactViewData) {
        contactName.text = item.name
        contactLastMessage.text = item.lastMessage
    }
}