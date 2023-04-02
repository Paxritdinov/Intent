package com.willmark.second.activity.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.willmark.second.R

@Suppress("DEPRECATION")
class SecondActivity : AppCompatActivity() {
    private val TAG = SecondActivity::class.java.toString()
    private lateinit var textB:TextView
    private lateinit var textC:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
    }

    private fun backToFinish(){
        val returnIntent = Intent()
        returnIntent.putExtra("result", "Do your best")
        setResult(RESULT_OK, returnIntent)
        finish()
    }
    private fun initViews(){
        textB = findViewById(R.id.ageText)
        textC = findViewById(R.id.nameText)
        val textName = intent.getSerializableExtra("name")
        val textAge = intent.getSerializableExtra("age")
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            backToFinish()
        }
        textB.text = textAge.toString()
        textC.text = textName.toString()
        Log.d(TAG, "initViews: name $textName")
        Log.d(TAG, "initViews: age $textAge")
    }
}