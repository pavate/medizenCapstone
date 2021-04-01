package org.sheridan.capstoneprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.sheridan.capstoneprototype.database.User.UserDatabase
import org.sheridan.capstoneprototype.database.User.UserEntity
import org.sheridan.capstoneprototype.databinding.ActivityEditProfileBinding

class EditProfile : AppCompatActivity() {
    private lateinit var mDb: UserDatabase
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        mDb = UserDatabase.getInstance(applicationContext)
        binding = ActivityEditProfileBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.btnSave.setOnClickListener {

            var fullName = binding.etName.text.toString()
            var userEmail = binding.etEmail.text.toString()
            var age =  binding.etAge.text.toString()
            var userPassword = binding.etPassword.text.toString()
            var userPassword2 = binding.etPassword2.text.toString()

            if (fullName.isNotEmpty() && userEmail.isNotEmpty() && age.isNotEmpty()) {
                if (userPassword.equals(userPassword2)) {
                    val user = UserEntity(
                            0,
                            fullName,
                            userEmail,
                            age.toInt(),
                            userPassword
                    )
                    doAsync {
                        // do things in the background  // (1)
                        mDb.userDao().insert(user)     // Put the student in database
                        uiThread {
                            // make changes to the UI   // (2)
                            toast("Record : " + user.fullName + " inserted.").show()
                        }
                    }
                } else {
                    toast("Password doesn't match").show()
                }
            } else {
                toast("Missing user input").show()
            }
        }
    }
}
