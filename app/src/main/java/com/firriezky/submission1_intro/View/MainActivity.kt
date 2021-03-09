package com.firriezky.submission1_intro.View

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.firriezky.submission1_intro.R
import com.firriezky.submission1_intro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var state = 0;
    lateinit var pref : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    lateinit var binding : ActivityMainBinding

    companion object{
        const val PREF_NAME = "razky"
        const val DEBUG_TAG = "razDAky"
        const val FIRST_LOGIN = "FIRST_LOGIN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pref = this.getSharedPreferences(PREF_NAME,0)
        editor= pref.edit()

        if (pref.getBoolean(FIRST_LOGIN,true)){
            editor.putBoolean(FIRST_LOGIN,false)
            editor.apply()
        }else{
            startActivity(Intent(this,RecyclerActivity::class.java))
        }

        val cursorImage = listOf(
            R.drawable.ic_cursor1,
            R.drawable.ic_cursor2,
            R.drawable.ic_cursor3
        )

        val onBoardImage = listOf(
            R.drawable.ic_onboarding1,
            R.drawable.ic_onboarding2,
            R.drawable.ic_onboarding3
        )

        val textList = listOf(
            getString(R.string.start_reading_for_your_future_investment),
            getString(R.string.keep_upgraded),
            getString(R.string.only_best_book)
        )

        binding.buttonNext.setOnClickListener {
            state++
            if (state<textList.size) {
                binding.title.text=textList[state]
                binding.imageCursor.setBackgroundResource(cursorImage[state])
                binding.imageOnboarding.setBackgroundResource((onBoardImage[state]))
            }else{
                startActivity(Intent(this,RecyclerActivity::class.java))
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val action: Int? =  event?.getActionMasked();
        return when (action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d(DEBUG_TAG, "Action was DOWN")
                true
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d(DEBUG_TAG, "Action was MOVE")
                true
            }
            MotionEvent.ACTION_UP -> {
                Log.d(DEBUG_TAG, "Action was UP")
                true
            }
            MotionEvent.ACTION_CANCEL -> {
                Log.d(DEBUG_TAG, "Action was CANCEL")
                true
            }
            MotionEvent.ACTION_OUTSIDE -> {
                Log.d(DEBUG_TAG, "Movement occurred outside bounds of current screen element")
                true
            }
            else -> super.onTouchEvent(event)
        }
        return super.onTouchEvent(event)



    }
}