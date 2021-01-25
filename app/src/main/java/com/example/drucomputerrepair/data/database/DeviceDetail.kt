package com.example.drucomputerrepair.data.database

import org.jetbrains.exposed.sql.Table

object DeviceDetail:Table("device_detail") {
    val device_detail_id =integer("device_detail_id").autoIncrement()
    val device_detail_name=varchar("device_detail_name",50)
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(DeviceDetail.device_detail_id,name = "PK_device_detail_id")
}