package com.example.binding_ex

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.binding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1번 방식 - findViewById
//        val btn = findViewById<Button>(R.id.testBtn)
//        btn.setOnClickListener {
//            Toast.makeText(this, "Click!", Toast.LENGTH_LONG).show()
//        }

        // 2번 방식 - dataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.testBtn.setOnClickListener {
            Toast.makeText(this, "Click!", Toast.LENGTH_LONG).show()
        }

    }
}