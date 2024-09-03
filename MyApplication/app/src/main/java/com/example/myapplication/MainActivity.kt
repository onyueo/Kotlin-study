package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
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

    }
}