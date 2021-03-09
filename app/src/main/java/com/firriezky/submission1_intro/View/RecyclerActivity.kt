package com.firriezky.submission1_intro.View

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.firriezky.submission1_intro.Model.Book
import com.firriezky.submission1_intro.Model.BookData
import com.firriezky.submission1_intro.R
import com.firriezky.submission1_intro.Util.Util
import com.firriezky.submission1_intro.databinding.ActivityRecyclerViewBinding

class RecyclerActivity : BaseActivity() {
    lateinit var adapterBook: BookAdapter
    lateinit var binding: ActivityRecyclerViewBinding

    private var list: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Util.setStatusBarColor(this, R.color.bluish1)

        adapterBook = BookAdapter()
        adapterBook.setAdapterClicker(object : BookAdapter.AdapterClicker{
            override fun onClick(data: Book) {
                data.title.ShowLongToastr()
                val intent = Intent(applicationContext,DestinationActivity::class.java)
                intent.apply {
                    putExtra("TITLE" , data.title)
                    putExtra("AUTHOR" , data.author)
                    putExtra("DESC" , data.desc)
                    putExtra("IMAGE" , data.image)
                }
                startActivity(intent)
            }

        })

        binding.myProfile.setOnClickListener {
            startActivity(Intent(this,MyProfileActivity::class.java))
        }


        list.addAll(BookData.bookData)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapterBook.setData(list)
            adapter = adapterBook
        }


    }
}