package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var claimService : ClaimService = ClaimService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)
        //
        val bView : Button = findViewById(R.id.add_btn)
        bView.setOnClickListener{
            val title = findViewById<EditText>(R.id.claim_title).text.toString()
            val date = findViewById<EditText>(R.id.date).text.toString()
            if(inputValidated(title,date)) {
                val cObj = claimService.add(Claim(UUID.randomUUID(),title,date, false))
                findViewById<TextView>(R.id.message).text = "<Claim is being processed...>"
            }
        }
    }

    fun inputValidated(title:String?, date:String?) : Boolean {
        if(title.isNullOrBlank() || date.isNullOrBlank()){
            findViewById<TextView>(R.id.message).text = "<ERROR - fields may not be empty!>"
            return false
        }
        else if(date.count() != 10){
            findViewById<TextView>(R.id.message).text = "<ERROR - date should be in XXXX-XX-XX format!>"
            return false
        }
        else{
            return true
        }
    }

}