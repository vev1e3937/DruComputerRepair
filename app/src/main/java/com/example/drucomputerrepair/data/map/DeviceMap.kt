package com.example.drucomputerrepair.data.map

import com.example.drucomputerrepair.data.database.Device
import com.example.drucomputerrepair.data.models.DeviceModel
import org.jetbrains.exposed.sql.ResultRow

object DeviceMap {
    fun toDevice(row: ResultRow)=DeviceModel(
        device_id = row[Device.device_id],
        device_code = row[Device.device_code],
        device_detail_id = row[Device.device_detail_id]
    )
}