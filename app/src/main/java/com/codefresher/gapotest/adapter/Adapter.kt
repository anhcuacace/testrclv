package com.codefresher.gapotest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.gapotest.databinding.*

class Adapter(private val list: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()
    inner class ViewHolderFirst (v: ItemPostBinding) : RecyclerView.ViewHolder(v.root)
    inner class ViewHolderPhoto (v: ItemPhotoBinding) : RecyclerView.ViewHolder(v.root){

        init {
            val mList=listOf(1,2)
            val adapter=PostAdapter(mList)

            val layoutManager = LinearLayoutManager(
                v.rclV.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            layoutManager.initialPrefetchItemCount = mList.size
            v.rclV.layoutManager=layoutManager
            v.rclV.adapter=adapter
            v.rclV.setRecycledViewPool(viewPool)
        }
    }
    inner class ViewHolderVideo(v: PostViewTypeBinding) : RecyclerView.ViewHolder(v.root)
    inner class ViewHolderLink(v: PostViewType2Binding) : RecyclerView.ViewHolder(v.root)
    inner class ViewHolderEnd(v: ItemEndBinding) : RecyclerView.ViewHolder(v.root)

    override fun getItemViewType(position: Int): Int {
        return list[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> {
                val v = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderFirst(v)
            }
            1 -> {
                val v = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderPhoto(v)
            }
            2 -> {
                val v = PostViewTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderVideo(v)
            }
            3 -> {
                val v = PostViewType2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderLink(v)
            }
            else ->{
                val v = ItemEndBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolderEnd(v)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = list.size

}