package org.sheridan.capstoneprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val calender: CalendarView = findViewById(R.id.calendarView)
        val textView1: TextView = findViewById(R.id.showDate)
        calender.setOnClickListener {

        }
        calender.setOnDateChangeListener(){ calendarView: CalendarView, i: Int, i1: Int, i2: Int ->
            Toast.makeText(this,"Calender Clicked", Toast.LENGTH_SHORT).show()
            val month = i1
            val day = i2
            val year = i
            textView1.text = month.toString() + day.toString() + year.toString()
            val newIntent3 = Intent(this,CalenderMedicineView::class.java)
            val finalMonth = month.toString()
            val finalDay = day.toString()
            val finalYear = year.toString()
            newIntent3.putExtra("Month",finalMonth)
            newIntent3.putExtra("Day",finalDay)
            newIntent3.putExtra("Year",finalYear)
            startActivity(newIntent3)



        }

    }

    fun showNext(view: View) {
        val newIntent1 = Intent(this,AddMedicationInfo::class.java)
        startActivity(newIntent1)
    }

    fun editPage(view: View) {
        val newIntent2 = Intent(this,EditProfile::class.java)
        startActivity(newIntent2)

    }
}