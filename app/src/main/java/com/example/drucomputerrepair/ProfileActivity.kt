package com.example.drucomputerrepair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drucomputerrepair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val userId = getSharedPreferences("file", MODE_PRIVATE).getInt("userId",0)

        val profile=dataSource.profile(userId)
        tv_member.text=profile.identity_id
        tv_full_name.text=profile.full_name
        tv_agency.text=profile.faculty
        tv_phone.text=profile.telephone

    }
}