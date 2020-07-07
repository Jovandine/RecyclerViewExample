package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val CONTACT_COUNT = 50

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initContactList()
        loadContacts()
    }

    private fun initContactList() {
        adapter = ContactAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.contact_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun loadContacts() {
        val result = getContacts()
        showContactList(result)
    }

    private fun showContactList(contacts: List<ContactViewData>) {
        adapter.submitItems(contacts)
    }

    private fun getContacts(): List<ContactViewData> {
        val result: MutableList<ContactViewData> = mutableListOf()
        repeat(CONTACT_COUNT) {
            result.add(
                ContactViewData(
                    id = it.toString(),
                    name = "User name $it",
                    lastMessage = "Last message $it"
                )
            )
        }

        return result
    }
}