package com.example.drucomputerrepair.datasource

import com.example.drucomputerrepair.data.models.FacultyModel
import com.example.drucomputerrepair.data.models.ProfileModel
import com.example.drucomputerrepair.data.request.LoginRequest
import com.example.drucomputerrepair.data.response.LoginResponse

interface DataSource {
    fun login(req: LoginRequest): LoginResponse
    fun profile(user:Int): ProfileModel
    fun faculty(user:Int): FacultyModel
}