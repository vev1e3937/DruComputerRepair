package com.example.drucomputerrepair.data.database

import org.jetbrains.exposed.sql.Table

object Device : Table("device") {
    val device_id = integer("device_id").autoIncrement()
    val room_id = integer("room_id").references(Room.room_id)
    val device_code = varchar("device_code",50)
    val device_detail_id = integer("device_detail_id").references(DeviceDetail.device_detail_id)

    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(Device.device_id,name = "device_id")
}