package com.example.articlerecview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //connect RecyclerView from activity_main.xml
        recyclerView = findViewById(R.id.recyclerView)

        //create an adapter that we wrote earlier
        val adapter = RecViewAdapter()
        //create array of Person object that we will pass to RecyclerView as data
        var people: ArrayList<Person> = ArrayList()
        people.add(Person("John",25))
        people.add(Person("Barry",34))
        people.add(Person("Richard",51))
        people.add(Person("Sarah",45))
        //give RecyclerView the adapter that we created
        recyclerView.adapter = adapter
        //set layoutManager of RecyclerView to LinearLayout, so that it will be displayed as a list.
        recyclerView.layoutManager = LinearLayoutManager(this)
        //give data to adapter
        adapter.people = people

    }
}