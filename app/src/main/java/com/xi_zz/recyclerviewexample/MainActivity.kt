package com.xi_zz.recyclerviewexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val people = listOf(
            Person("Hallie Valentine", 20),
            Person("Catriona Farrow", 25),
            Person("Samson Goddard", 30),
            Person("Rocco Weber", 35),
            Person("Mujtaba Espinosa", 40),
            Person("Jocelyn Levy", 45),
            Person("Suraj Marriott", 50),
            Person("Shiv Adam", 55),
            Person("Saira Leblanc", 60),
            Person("Wendy Brookes", 65)
        )

        personList.adapter = PersonsAdapter(this, people) { person ->
            Toast.makeText(this, "${person.name}'s age: ${person.age}", Toast.LENGTH_SHORT).show()
        }
    }
}
