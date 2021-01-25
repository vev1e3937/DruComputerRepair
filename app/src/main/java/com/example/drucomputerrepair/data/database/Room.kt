package com.example.drucomputerrepair.data.database

import org.jetbrains.exposed.sql.Table

object Room : Table("room") {
    val room_id = integer("room_id").autoIncrement()
    val room_number = varchar("room_number", 50)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(Room.room_id,name = "room_id")
}