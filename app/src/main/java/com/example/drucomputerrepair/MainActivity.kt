package com.example.drucomputerrepair

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btn_Profile.setOnClickListener {
            startActivity(Intent(baseContext, ProfileActivity::class.java))
        }
        bt_repair.setOnClickListener {
            startActivity(Intent(baseContext, RepairActivity::class.java))
        }
    }
}