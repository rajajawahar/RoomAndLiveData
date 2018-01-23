package com.silicontechnologies.livedatasample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.silicontechnologies.livedatasample.viewmodel.UserViewModel
import android.arch.lifecycle.ViewModelProviders

class HomeActivity : AppCompatActivity() {

    var userViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel!!.init("rajajawahar");

    }
}
