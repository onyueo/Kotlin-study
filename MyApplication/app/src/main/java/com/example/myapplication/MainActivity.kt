package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step1 클릭감지
        val img = findViewById<ImageView>(R.id.cat_1)
        img.setOnClickListener {
            Toast.makeText(this, "1번 클릭", Toast.LENGTH_LONG).show()

            // Step2 화면클릭시 다른페이지 보여줌
            val intent = Intent(this, ImgActivity::class.java)
            intent.putExtra("data", "1")
            startActivity(intent)
        }

        val img2 = findViewById<ImageView>(R.id.cat_2)
        val img3 = findViewById<ImageView>(R.id.cat_3)
        val img4 = findViewById<ImageView>(R.id.cat_4)
        val img5 = findViewById<ImageView>(R.id.cat_5)
        val img6 = findViewById<ImageView>(R.id.cat_6)

        img2.setOnClickListener {
            val intent = Intent(this, ImgActivity::class.java)
            intent.putExtra("data", "2")
            startActivity(intent)
        }

        img3.setOnClickListener {
            val intent = Intent(this, ImgActivity::class.java)
            intent.putExtra("data", "3")
            startActivity(intent)
        }

        img4.setOnClickListener {
            val intent = Intent(this, ImgActivity::class.java)
            intent.putExtra("data", "4")
            startActivity(intent)
        }

        img5.setOnClickListener {
            val intent = Intent(this, ImgActivity::class.java)
            intent.putExtra("data", "5")
            startActivity(intent)
        }

        img6.setOnClickListener {
            val intent = Intent(this, ImgActivity::class.java)
            intent.putExtra("data", "6")
            startActivity(intent)
        }


        // 랜덤 햄서터 페이지 이동
        val dice = findViewById<Button>(R.id.dice)
        dice.setOnClickListener {
            val intent = Intent(this, DiceActivity::class.java)
            startActivity(intent)
        }

        // 명함 페이지 이동
        val goodword = findViewById<Button>(R.id.goodWord)
        goodword.setOnClickListener {
            val intent = Intent(this, MainWordActivity::class.java)
            startActivity(intent)
        }


    }


    override fun onBackPressed() {
        if (isDouble) {
            super.onBackPressed() // 기본 동작 호출
        } else {
            isDouble = true
            Toast.makeText(this, "한번 더 누르면 종료!.", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({ isDouble = false }, 2000)
        }
    }
}