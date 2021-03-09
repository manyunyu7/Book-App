package com.firriezky.submission1_intro.View

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {


    fun String.ShowLongToastr(){
        Toast.makeText(applicationContext,this,Toast.LENGTH_LONG).show()
    }


}