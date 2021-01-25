package com.example.drucomputerrepair.data.database

import org.jetbrains.exposed.sql.Table

object Role : Table("role") {
    val role_id = integer("role_id").autoIncrement()
    val role_name = varchar("role_name",50)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(Role.role_id, name = "role_id")
}