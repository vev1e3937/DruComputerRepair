package com.example.drucomputerrepair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drucomputerrepair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_repair.*

class RepairActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repair)
        val userId = getSharedPreferences("file", MODE_PRIVATE).getInt("userId",0)

        val faculty=dataSource.faculty(userId)
        tv_faculty_name.text=faculty.faculty_name
    }
}