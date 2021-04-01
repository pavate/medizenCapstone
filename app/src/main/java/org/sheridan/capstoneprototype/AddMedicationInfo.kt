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

            var fullName = binding.editMed.text.toString()
            var userDosage = if (binding.editDosage.text.toString().isNotEmpty()) binding.editDosage.text.toString().toInt() else -1
            var userfrequency = if (binding.editFrequency.text.toString().isNotEmpty()) binding.editFrequency.text.toString().toInt() else -1
            var userQuantity = if (binding.editQuantity.text.toString().isNotEmpty()) binding.editQuantity.text.toString().toInt() else -1
            var medDescription = binding.editDescription.text.toString()

            if (fullName.isNotEmpty() && userDosage != -1 && userfrequency != -1 && userQuantity != -1){
                val medicine = MedicineEntity(
                        0,
                        fullName,
                        userDosage,
                        userfrequency,
                        userQuantity,
                        medDescription
                )
                doAsync {
                    // do things in the background  // (1)
                    mDb.MedicineDao().insert(medicine)     // Put the student in database
                    uiThread {
                        // make changes to the UI   // (2)
                        toast("Record : " + medicine.fullName + " inserted.").show()
                    }
                }
            } else {
                toast("Required input missing").show()
            }
        }
    }
}
