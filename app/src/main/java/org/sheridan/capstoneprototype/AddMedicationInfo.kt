package org.sheridan.capstoneprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.sheridan.capstoneprototype.database.Medicine.MedicineDataBase
import org.sheridan.capstoneprototype.database.Medicine.MedicineEntity
import org.sheridan.capstoneprototype.database.User.UserDatabase
import org.sheridan.capstoneprototype.database.User.UserEntity

import org.sheridan.capstoneprototype.databinding.ActivityAddMedicationInfoBinding



class AddMedicationInfo : AppCompatActivity() {
    private lateinit var mDb: MedicineDataBase
    private lateinit var binding: ActivityAddMedicationInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        mDb = MedicineDataBase.getInstance(applicationContext)
        super.onCreate(savedInstanceState)
        binding = ActivityAddMedicationInfoBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.addMedButton.setOnClickListener {

//            var medName = binding.editMed.text.toString()
//            var medDosage = binding.editDosage.text.toString().toInt()
//            var medFrequency = binding.editFrequency.text.toString().toInt()
//            var medQuantity = binding.editQuantity.text.toString().toInt()
//            var medDescription = binding.editDescription.text.toString()

            val medicine = MedicineEntity(
                    0,
                    fullName = "testMed",
                    userDosage = 5,
                    userfrequency =  3,
                    userQuantity =  6,
                    medDescription = "Its a med to help you get good grades"
            )
            doAsync {
                // do things in the background  // (1)
                mDb.MedicineDao().insert(medicine)     // Put the student in database
                uiThread {
                    // make changes to the UI   // (2)
                    toast("Record : " + medicine.fullName + " inserted.")
                }
            }


        }




    }
}