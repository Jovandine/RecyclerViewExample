package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactViewHolder>() {

    private var items: List<ContactViewData> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.item_contact,
            parent,
            false
        )

        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
        val item = items.getOrNull(position) ?: return

        holder.bind(item)
    }

    fun submitItems(items: List<ContactViewData>) {
        this.items = items
        notifyDataSetChanged()
    }
}