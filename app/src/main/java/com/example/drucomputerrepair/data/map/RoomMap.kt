package com.example.drucomputerrepair.data.map

import com.example.drucomputerrepair.data.database.Room
import com.example.drucomputerrepair.data.models.RoomModel
import org.jetbrains.exposed.sql.ResultRow

object RoomMap {
    fun toRoom(row: ResultRow)=RoomModel(
        room_id = row[Room.room_id],
        room_number = row[Room.room_number],
        faculty_id = row[Room.faculty_id]
    )
}