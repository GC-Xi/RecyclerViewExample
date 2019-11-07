package com.xi_zz.recyclerviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person.view.*

data class Person(val name: String, val age: Int)

class PersonViewHolder(view: View, val clickAction: (Person) -> Unit) : RecyclerView.ViewHolder(view) {
    fun setItem(person: Person) {
        itemView.nameText.text = person.name
        itemView.setOnClickListener { clickAction(person) }
    }
}

class PersonsAdapter(
    private val context: Context,
    var persons: List<Person>,
    private val itemClickAction: (Person) -> Unit = {}
) : RecyclerView.Adapter<PersonViewHolder>() {

    // Create the view based on the person item and pass down the click function
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder =
        PersonViewHolder(LayoutInflater.from(context).inflate(R.layout.item_person, parent, false), itemClickAction)

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.setItem(persons[position])
    }

    override fun getItemCount(): Int = persons.size
}
