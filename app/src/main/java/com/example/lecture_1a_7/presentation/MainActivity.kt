package com.example.lecture_1a_7.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lecture_1a_7.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = 31231
    }
}