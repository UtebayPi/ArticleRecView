package com.example.articlerecview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//parent class for all RecyclerViews is written like this
class RecViewAdapter: RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {
    //this array will store data about all people, displayed in RecyclerView
    var people: ArrayList<Person> = ArrayList()
    set(value) {
        field = value
        notifyDataSetChanged() // This method updates RecyclerView, when new value is given
    }
    //this class is used to connect Views inside person_list_item, to objects in code, so that we can manipulate them.
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //TextViews from person_list_item.
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private var textAge: TextView = itemView.findViewById(R.id.textAge)
        //this method is used in  other place, it binds data from "people" array,
        //to Views inside every person_list_item, displayed in RecyclerView.
        fun bind(person: Person){
            textName.text = person.name
            textAge.text = person.age.toString()
        }
    }
    //this method connects people_list_item to RecyclerView, inflates it.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.person_list_item, parent, false)
        return ViewHolder(view)

    }
    //this method accepts and gives us ViewHolder object(class that we wrote before) connected to every person_list_item in RecyclerView,
    // and also it's position in RecyclerView. Using position, we give every person_list_item, it's own individual Person from people array,
    // and bind information from Person to that person_list_view.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(people[position])
    }
    //this method needs to return length of "people" array, that is it.
    override fun getItemCount(): Int {
        return people.size
    }
}