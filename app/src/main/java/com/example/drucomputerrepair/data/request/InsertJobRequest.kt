package com.example.drucomputerrepair.data.request

import org.joda.time.DateTime

data class InsertJobRequest(
    val user_id: Int,
    val problem_id: Int,
    val status_id: Int,
    val repair_date: DateTime,
    val detail:String,
    val device_id:Int
)
