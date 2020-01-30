package com.example.recyclerdemo.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerdemo.R
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        button2.text = intent.getStringExtra("data")
    }
}
