package com.example.practicekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        KotlinButton.setOnClickListener{
            val intent = Intent(this,KotlinBmi::class.java)
            startActivity(intent)
        }
        JavaButton.setOnClickListener {
            val intent = Intent(this,JavaBmi::class.java)
            startActivity(intent)
        }
    }
}
