package com.baehoons.jetpacktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.baehoons.jetpacktest.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }
}
