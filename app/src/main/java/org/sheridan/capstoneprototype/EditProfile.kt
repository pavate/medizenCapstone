package org.sheridan.capstoneprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.sheridan.capstoneprototype.database.User.UserDatabase
import org.sheridan.capstoneprototype.database.User.UserEntity

class EditProfile : AppCompatActivity() {
    private lateinit var mDb: UserDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        mDb = UserDatabase.getInstance(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val etName: TextView = findViewById(R.id.etName)
        val etEmail: TextView = findViewById(R.id.etEmail)
        val etAge: TextView = findViewById(R.id.etAge)
        val etPassword: TextView = findViewById(R.id.etPassword)
        val btnSave: Button = findViewById(R.id.btnSave)

//        val name = etName.getText().toString()
//        val uEmail = etEmail.getText().toString()
//        val age = etAge.getText().toString().toInt()
//        val pasword = etPassword.getText().toString()


        btnSave.setOnClickListener {
            val user = UserEntity(
                0,
                fullName = "testuser",
                userEmail = "testuser@gmail.com",
                age =  35,
                userPassword = "password"
            )
            doAsync {
                // do things in the background  // (1)
                mDb.userDao().insert(user)     // Put the student in database
                uiThread {
                    // make changes to the UI   // (2)
                    toast("Record : " + user.fullName + " inserted.")
                }
            }
        }

    }
}