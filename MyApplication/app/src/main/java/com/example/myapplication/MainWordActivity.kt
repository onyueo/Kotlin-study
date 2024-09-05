package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainWordBinding

class MainWordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_word)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 명언 리스트 데이터
        val sentenceList = mutableListOf<String>()
        sentenceList.add("이것은 명언입니다111")
        sentenceList.add("이것은 명언입니다2222")
        sentenceList.add("이것은 명언입니다33333")
        sentenceList.add("이것은 명언입니다44444")
        sentenceList.add("이것은 명언입니다5555")


        // 전체 명언보기 이동
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_word)
        binding.showAllBtn.setOnClickListener {
            Log.d("MainWordActivity", "전체 명언 보기 버튼 클릭됨")
            var intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }

        // 텍스트 변경
        binding.goodWordText.setText(sentenceList.random())

    }
}
