package org.sheridan.capstoneprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

class CalenderMedicineView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calender_medicine_view)

        val textView3: TextView = findViewById(R.id.textView3)
        val addMed: ImageButton = findViewById(R.id.addMedImage)
        val intent = getIntent()

        val day = intent.getStringExtra("Day")
        val month = intent.getStringExtra("Month")
        val year = intent.getStringExtra("Year")

        textView3.text = "$month/$day/$year"

        addMed.setOnClickListener {
            val newIntent1 = Intent(this,AddMedicationInfo::class.java)
            startActivity(newIntent1)
        }


    }
}