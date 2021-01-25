package com.example.drucomputerrepair.data.database

import org.jetbrains.exposed.sql.Table

object Problem :Table("problem") {
    val problem_id = integer("problem_id").autoIncrement()
    val problem_name = varchar("problem_name",50)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(Problem.problem_id,name = "problem_id")
}