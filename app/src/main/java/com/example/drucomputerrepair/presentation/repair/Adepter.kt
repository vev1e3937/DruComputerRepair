package com.example.drucomputerrepair.presentation.repair

import android.content.Context
import android.view.View
import com.example.drucomputerrepair.R
import com.example.drucomputerrepair.data.models.DeviceDetailModel
import com.example.drucomputerrepair.data.models.DeviceModel
import com.example.drucomputerrepair.data.models.ProblemModel
import com.example.drucomputerrepair.data.models.RoomModel
import com.example.drucomputerrepair.ui.BaseSpinner
import kotlinx.android.synthetic.main.activity_repair.view.*
import kotlinx.android.synthetic.main.item_spinner_base.view.*

class RoomAdepter(
    context:Context,
list:MutableList<RoomModel>
):BaseSpinner<RoomModel>(context, list){
    override fun getLayout(): Int = R.layout.item_spinner_base
    override fun View.onBindViewHolder(data: RoomModel) {
        tvSpinnerBase.text=data.room_number
    }
}

class DeviceAdepter(
    context: Context,
    list: MutableList<DeviceModel>

):BaseSpinner<DeviceModel>(context,list){
    override fun getLayout(): Int = R.layout.item_spinner_base
    override fun View.onBindViewHolder(data:DeviceModel){
        tvSpinnerBase.text=data.device_code
    }
}
class DeviceDetailAdepter(
    context: Context,
    list: MutableList<DeviceDetailModel>
):BaseSpinner<DeviceDetailModel>(context,list){
    override fun getLayout(): Int = R.layout.item_spinner_base
    override  fun  View.onBindViewHolder(data:DeviceDetailModel){
        tvSpinnerBase.text=data.device_detail_name
    }
}
class ProblemAdepter(
    context: Context,
    list: MutableList<ProblemModel>
):BaseSpinner<ProblemModel>(context,list){
    override fun getLayout(): Int = R.layout.item_spinner_base
    override  fun  View.onBindViewHolder(data:ProblemModel){
        tvSpinnerBase.text=data.problem_name
    }
}

