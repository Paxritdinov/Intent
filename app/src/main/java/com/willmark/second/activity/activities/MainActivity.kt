package com.willmark.second.activity.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.willmark.second.R
import com.willmark.second.activity.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var textA:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textA = findViewById(R.id.text)
        textA.setOnClickListener{

            val user = User("1", "Ulug'bek")
            openActivity(user)
        }
    }

    private fun openActivity(user: User) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("id", user.id)
        intent.putExtra("name",  user.name)
        startActivity(intent)
    }
}