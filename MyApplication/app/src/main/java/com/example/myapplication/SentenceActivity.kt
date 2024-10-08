package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sentence)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 전체 데이터
        val sentenceList = mutableListOf<String>()
        sentenceList.add("이것은 명언입니다111")
        sentenceList.add("이것은 명언입니다2222")
        sentenceList.add("이것은 명언입니다33333")
        sentenceList.add("이것은 명언입니다44444")
        sentenceList.add("이것은 명언입니다5555")


        // activity_sentence연결작업
        val senTenceAdapter = GoodwordListViewAdpater(sentenceList)

        val listview = findViewById<ListView>(R.id.sentenceListView)

        listview.adapter = senTenceAdapter

    }
}