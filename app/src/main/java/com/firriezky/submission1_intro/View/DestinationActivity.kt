package com.firriezky.submission1_intro.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.firriezky.submission1_intro.R
import com.firriezky.submission1_intro.Util.Util
import com.firriezky.submission1_intro.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {

    lateinit var binding: ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Util.setStatusBarColor(this, R.color.bluish1)


        binding.apply {
            labelBookAuthor.text= intent.getStringExtra("AUTHOR")
            labelBookDesc.text= intent.getStringExtra("DESC")
            labelBookTitle.text= intent.getStringExtra("TITLE")

            Glide.with(applicationContext)
                .load(intent.getIntExtra("IMAGE",R.drawable.book_5_towers))
                .into(imageDest)
        }


    }
}