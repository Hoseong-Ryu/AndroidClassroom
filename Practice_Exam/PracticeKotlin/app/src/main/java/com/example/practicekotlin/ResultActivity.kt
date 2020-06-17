package com.example.practicekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //버튼을 누르면 액티비티 변경해주기
        val bmi = intent.extras?.get("Bmi")
        when(bmi){
            0.0..18.0->{imageView.setImageResource(R.drawable.sad_face)}
            18.1..23.0 ->{imageView.setImageResource(R.drawable.smile_face)}
            else->{imageView.setImageResource(R.drawable.sad_face)}
        }

    }
}
