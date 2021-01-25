package com.example.drucomputerrepair.datasource

import com.example.drucomputerrepair.data.request.LoginRequest
import com.example.drucomputerrepair.data.response.LoginResponse

interface DataSource {
    fun login(req: LoginRequest): LoginResponse
}