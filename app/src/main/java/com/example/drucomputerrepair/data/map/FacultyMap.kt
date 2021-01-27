package com.example.drucomputerrepair.data.map

import com.example.drucomputerrepair.data.database.Faculty
import com.example.drucomputerrepair.data.models.FacultyModel
import org.jetbrains.exposed.sql.ResultRow

object FacultyMap {
    fun toFaculty(row: ResultRow)=FacultyModel(
        faculty_id = row[Faculty.faculty_id],
        faculty_name = row[Faculty.faculty_name]
    )
}