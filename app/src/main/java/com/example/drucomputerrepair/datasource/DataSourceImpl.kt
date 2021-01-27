package com.example.drucomputerrepair.datasource

import com.example.drucomputerrepair.data.database.Faculty
import com.example.drucomputerrepair.data.database.Users
import com.example.drucomputerrepair.data.map.FacultyMap
import com.example.drucomputerrepair.data.map.ProfileMap
import com.example.drucomputerrepair.data.models.FacultyModel
import com.example.drucomputerrepair.data.models.ProfileModel
import com.example.drucomputerrepair.data.request.LoginRequest
import com.example.drucomputerrepair.data.response.LoginResponse
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.andWhere
import org.jetbrains.exposed.sql.select
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
}