package com.firriezky.submission1_intro.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firriezky.submission1_intro.Model.Book
import com.firriezky.submission1_intro.databinding.ListRecycler1Binding

class BookAdapter() : RecyclerView.Adapter<BookAdapter.BookHolder>() {
    lateinit var binding : ListRecycler1Binding
    lateinit var adapterClickerInterface: AdapterClicker

    var listData = mutableListOf<Book>()

    fun setAdapterClicker(adapterClicker: AdapterClicker){
        adapterClickerInterface = adapterClicker
    }

    fun setData(list : MutableList<Book>){
        listData.addAll(list)
    }

    inner class BookHolder(v:View) : RecyclerView.ViewHolder(v){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        binding = ListRecycler1Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookHolder(binding.root)
    }

    override fun getItemCount(): Int {
      return  listData.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {

        holder.itemView.setOnClickListener {
            adapterClickerInterface.onClick(listData[position])
        }

            listData[position].let {book ->
                binding.apply {
                    labelBookTitle.text = book.title
                    labelBookDesc.text = book.desc
                    labelBookAuthor.text=book.author

                    btnSeeDetail.setOnClickListener {
                        adapterClickerInterface.onClick(book)
                    }
                }
            }

            Glide.with(binding.root.context)
                .load(listData[position].image)
                .into(binding.imageRv)

    }

    interface AdapterClicker{
        fun onClick(data:Book)
    }
}