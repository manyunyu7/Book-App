package com.firriezky.submission1_intro.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firriezky.submission1_intro.R
import com.firriezky.submission1_intro.Util.Util

class MyProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Util.setStatusBarColor(this, R.color.bluish1)
    }
}