package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImgActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_img)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 상세화면 데이터 가져옴
        val getData = intent.getStringExtra("data")
        val catImg = findViewById<ImageView>(R.id.imgArea)
        Toast.makeText(this, getData, Toast.LENGTH_LONG).show()

        val imageResId = when (getData) {
            "1" -> R.drawable.cat1
            "2" -> R.drawable.cat2
            "3" -> R.drawable.cat3
            "4" -> R.drawable.cat4
            "5" -> R.drawable.cat5
            "6" -> R.drawable.cat6
            else -> R.drawable.cat1 // 기본 이미지 (선택적)
        }

        catImg.setImageResource(imageResId)

    }
}