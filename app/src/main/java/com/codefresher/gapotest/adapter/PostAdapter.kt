package com.codefresher.gapotest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codefresher.gapotest.databinding.ItemCmtBinding
import com.codefresher.gapotest.databinding.PostBinding

class PostAdapter(private val list: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    inner class ViewHolderPost (v: PostBinding) : RecyclerView.ViewHolder(v.root)
    inner class ViewHolderItemCmt(v: ItemCmtBinding) : RecyclerView.ViewHolder(v.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType==1){
            val v = PostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderPost(v)
        }else{
            val v = ItemCmtBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            Log.e("==js","dã có data")
            ViewHolderItemCmt(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return list[position]
    }

    override fun getItemCount(): Int =list.size

}