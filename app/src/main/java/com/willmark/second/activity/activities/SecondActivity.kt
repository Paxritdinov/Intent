package com.willmark.second.activity.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.willmark.second.R

class SecondActivity : AppCompatActivity() {
    val TAG = SecondActivity::class.java.toString()
    private lateinit var textB:TextView
    private lateinit var textC:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initViews()
    }

    private fun initViews(){
        textB = findViewById(R.id.IdText)
        textC = findViewById(R.id.nameText)
        var textName = intent.getSerializableExtra("name")
        var textId = intent.getSerializableExtra("id")

        textB.text = textId.toString()
        textC.text = textName.toString()
        Log.d(TAG, "initViews: name $textName")
        Log.d(TAG, "initViews: id $textId")
    }
}