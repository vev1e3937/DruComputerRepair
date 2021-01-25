package com.example.drucomputerrepair.data.database

import org.jetbrains.exposed.sql.Table

object Faculty :Table ("faculty"){
    val faculty_id = integer("faculty_id").autoIncrement()
    val faculty_name = varchar("faculty_name",50)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(Faculty.faculty_id,name = "faculty_id")
}