package com.willmark.second.activity.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import com.willmark.second.R
import com.willmark.second.activity.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var textA:TextView
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private var launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val texts = data!!.getStringExtra("result")
            tv.text = texts
        }
    }

    private fun initViews() {
        tv = findViewById(R.id.text)
        textA = findViewById(R.id.text)
        textA.setOnClickListener{

            val user = User(age = 16, name = "Ulug'bek")
            openActivity(user)
        }
    }

    private fun openActivity(user: User) {
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("age", user.age)
        intent.putExtra("name",  user.name)
        launcher.launch(intent)
    }
}