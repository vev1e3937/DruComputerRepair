package com.example.drucomputerrepair.datasource

import com.example.drucomputerrepair.data.database.*
import com.example.drucomputerrepair.data.map.*
import com.example.drucomputerrepair.data.models.*
import com.example.drucomputerrepair.data.request.LoginRequest
import com.example.drucomputerrepair.data.response.LoginResponse
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DataSourceImpl : DataSource {
    override fun login(req: LoginRequest): LoginResponse {
        val response = LoginResponse()

        if (req.username.isBlank()) {
            response.message = "Username empty"
        } else if (req.password.isBlank()) {
            response.message = "Password empty"
        } else {
            val result = transaction {
                addLogger(StdOutSqlLogger)
                Users.select { Users.username eq req.username }
                    .andWhere { Users.password eq req.password }
                    .count()
                    .toInt()
            }
            if (result == 0) {
                response.success = false
                response.message = "Password incorrect"
            } else  {
                val userId = transaction {
                    Users.select { Users.username eq req.username }
                        .andWhere { Users.password eq req.password }
                        .map { it[Users.user_id] }
                        .single()
                }
                response.userId = userId
                response.success = true
                response.message = "Login success"
            }
        }
        return response
    }

    override fun profile(user:Int):ProfileModel{
        return transaction {
            addLogger(StdOutSqlLogger)
            (Users innerJoin Faculty)
                .slice(
                    Users.identity_id,
                    Users.full_name,
                    Users.telephone,
                    Faculty.faculty_name
                )
                .select { Users.user_id eq user }
                .map { ProfileMap.toProfile(it) }
                .single()
        }
    }
    override fun faculty(user:Int):FacultyModel{
        return transaction {
            addLogger(StdOutSqlLogger)
            (Users innerJoin  Faculty)
                .slice(
                    Faculty.faculty_id,
                    Faculty.faculty_name
                )
                .select { Users.user_id eq user }
                .map {FacultyMap.toFaculty(it)}
                .single()
        }
    }
    override fun roomnumber(faculty:Int): List<RoomModel> {
        return transaction {
            addLogger(StdOutSqlLogger)
            Room
                .select{Room.faculty_id eq faculty}
                .map { RoomMap.toRoom(it) }
        }
    }

    override fun devicecode(room:Int): List<DeviceModel>{
        return  transaction {
            addLogger(StdOutSqlLogger)
            Device
                .select{Device.room_id eq room}
                .map { DeviceMap.toDevice(it) }
        }
    }

    override fun devicename(device_detail_id:Int): List<DeviceDetailModel>{
        return transaction {
            addLogger(StdOutSqlLogger)
            DeviceDetail
                .select{DeviceDetail.device_detail_id eq device_detail_id}
                .map { DeviceDetailMap.toDeviceDetail(it) }
        }
    }
    override fun problem ():List<ProblemModel>{
        return transaction {
            addLogger(StdOutSqlLogger)
            Problem
                .selectAll()
                .map { ProblemMap.toProblem(it) }
        }
    }
}