package com.example.myapplication

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityDiceBinding
import kotlin.random.Random

class DiceActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dice)

        // 바인딩해서 id값이 dice1인것의 이미지뷰를 가져옴
        val diceImg1 = binding.dice1
        val diceImg2 = binding.dice2

        binding.diceBtn.setOnClickListener {
            var num1 = Random.nextInt(1, 7)
            var num2 = Random.nextInt(1, 7)

            // 바인딩해서 가져온 이미지뷰의 이미지소스를 drawable에 있는 이미지로 바꿈!
            diceImg1.setImageResource(getDiceImageResource(num1))
            diceImg2.setImageResource(getDiceImageResource(num2))
        }


        // -----------------------------------------------------------

        val list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("안녕하세요", "내용입니다"))
        list_item.add(ListViewModel("오늘의 햄스터", "???!"))
        list_item.add(ListViewModel("햄픽!", "골라골라!"))


        val listview = findViewById<ListView>(R.id.mainListview)
        val listAdapter = ListViewAdapter(list_item)

        listview.adapter = listAdapter



    }

    // 주어진 숫자에 따라 이미지 리소스를 반환하는 함수
    private fun getDiceImageResource(num: Int): Int {
        return when (num) {
            1 -> R.drawable.ham1
            2 -> R.drawable.ham2
            3 -> R.drawable.ham3
            4 -> R.drawable.ham4
            5 -> R.drawable.ham5
            6 -> R.drawable.ham6
            else -> R.drawable.ham1 // 기본값
        }
    }

}