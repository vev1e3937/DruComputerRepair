package com.example.drucomputerrepair.data.map

import com.example.drucomputerrepair.data.database.DeviceDetail
import com.example.drucomputerrepair.data.models.DeviceDetailModel
import org.jetbrains.exposed.sql.ResultRow

object DeviceDetailMap {
    fun toDeviceDetail(row: ResultRow)=DeviceDetailModel(
        device_detail_id = row[DeviceDetail.device_detail_id],
        device_detail_name = row[DeviceDetail.device_detail_name]
    )
}