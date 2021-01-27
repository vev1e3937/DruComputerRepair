package com.example.drucomputerrepair.data.map

import com.example.drucomputerrepair.data.database.Faculty
import com.example.drucomputerrepair.data.database.Users
import com.example.drucomputerrepair.data.models.ProfileModel
import org.jetbrains.exposed.sql.ResultRow

object ProfileMap {
    fun toProfile(row: ResultRow)=ProfileModel(
        identity_id = row[Users.identity_id],
        full_name = row[Users.full_name],
        telephone = row[Users.telephone],
        faculty = row[Faculty.faculty_name]
    )
}