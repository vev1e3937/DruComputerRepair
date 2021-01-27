package com.example.drucomputerrepair.presentation.repair

import android.content.Context
import android.os.Bundle
import com.example.drucomputerrepair.R
import com.example.drucomputerrepair.data.models.DeviceDetailModel
import com.example.drucomputerrepair.data.models.DeviceModel
import com.example.drucomputerrepair.data.models.ProblemModel
import com.example.drucomputerrepair.data.models.RoomModel
import com.example.drucomputerrepair.ui.BaseActivity
import com.example.drucomputerrepair.ui.onItemSelected
import kotlinx.android.synthetic.main.activity_repair.*

class RepairActivity : BaseActivity() {
    private lateinit var room: RoomModel
    private var roomId : Int?=null
    private lateinit var device: DeviceModel
    private var detailId : Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repair)
        val userId = getSharedPreferences("file", MODE_PRIVATE).getInt("userId",0)

        val faculty=dataSource.faculty(userId)
        tv_faculty_name.text=faculty.faculty_name
        val faculty_Id=faculty.faculty_id
        setRoom(faculty_Id)
        setProblem()



    }

    private fun setRoom(faculty:Int) {
        val list=dataSource.roomnumber(faculty)as MutableList<RoomModel>
        bar_spinner_room.adapter=RoomAdepter(baseContext,list)
        bar_spinner_room.onItemSelected<RoomModel> {
          room=it
            roomId=it.room_id
            setDevice(roomId!!)

        }
    }

    private fun setDevice(room:Int){
        val list=dataSource.devicecode(room)as MutableList<DeviceModel>
        bar_spinner_device.adapter=DeviceAdepter(baseContext,list)
        bar_spinner_device.onItemSelected<DeviceModel> {
            device=it
            detailId=it.device_detail_id
            setDeviceDetail(detailId!!)

        }
    }

    private fun setDeviceDetail(device:Int){
        val list=dataSource.devicename(device)as MutableList<DeviceDetailModel>
        bar_spinner_device_name.adapter=DeviceDetailAdepter(baseContext,list)
        bar_spinner_device_name.onItemSelected<DeviceDetailModel> {

        }
    }

    private fun setProblem(){
        val list=dataSource.problem()as MutableList<ProblemModel>
        bar_spinner_problem.adapter=ProblemAdepter(baseContext,list)
        bar_spinner_problem.onItemSelected<ProblemModel> {

        }
    }

}