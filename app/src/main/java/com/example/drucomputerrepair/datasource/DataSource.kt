package com.example.drucomputerrepair.datasource

import com.example.drucomputerrepair.data.models.*
import com.example.drucomputerrepair.data.request.InsertJobRequest
import com.example.drucomputerrepair.data.request.LoginRequest
import com.example.drucomputerrepair.data.response.InsertJobResponse
import com.example.drucomputerrepair.data.response.LoginResponse

interface DataSource {
    fun login(req: LoginRequest): LoginResponse
    fun profile(user:Int): ProfileModel
    fun faculty(user:Int): FacultyModel
    fun roomnumber(room:Int): List<RoomModel>
    fun devicecode(room:Int): List<DeviceModel>
    fun devicename(device_detail_id:Int): List<DeviceDetailModel>
    fun problem ():List<ProblemModel>
    fun insertjob (req: InsertJobRequest): InsertJobResponse
}