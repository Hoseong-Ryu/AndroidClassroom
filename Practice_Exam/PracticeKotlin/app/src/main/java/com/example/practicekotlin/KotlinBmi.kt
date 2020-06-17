package com.example.practicekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin_bmi.*
import kotlin.math.pow

class KotlinBmi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_bmi)
        btn.setOnClickListener {
            val height = height.text.toString().toDouble()

            val weight = weight.text.toString().toDouble()

            //몸무게 / (키/100 ^ 2)
            val result = weight / (height/100).pow(2.0)

            Toast.makeText(this,"몸무게 : $weight$ | 키 : $height$",Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ResultActivity:: class.java)
            intent.putExtra("Bmi",result)
            startActivity(intent)

        }

    }
}
