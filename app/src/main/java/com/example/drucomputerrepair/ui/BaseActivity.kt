package com.example.drucomputerrepair.ui

import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import com.example.drucomputerrepair.datasource.DataSource
import com.example.drucomputerrepair.datasource.DataSourceImpl


import org.jetbrains.exposed.sql.Database

abstract class BaseActivity:AppCompatActivity() {
    val dataSource: DataSource = DataSourceImpl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userId =getSharedPreferences("file", AppCompatActivity.MODE_PRIVATE).getInt("userId",0)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())
        val host = "192.168.1.35"
        val databaseName = "repairdrudb"
        val url = "jdbc:mysql://$host:3306/$databaseName?useUnicode=true&characterEncoding=utf-8"
        Database.connect(
            url = url,
            driver = "com.mysql.jdbc.Driver",
            user = "computerrepair",
            password = "1234",
        )
    }

}