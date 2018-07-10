package me.pranay.drawit.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dashboard_adapter.view.*
import me.pranay.drawit.R

class DashboardAdapter(blogList:List<String>,val context:Context): RecyclerView.Adapter<DashboardAdapter.RecyclerViewHolder>() {

    private lateinit var listOfBlog: List<String>

    init {
        this.listOfBlog = blogList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_adapter, parent, false)
        return RecyclerViewHolder(v)
    }

    class RecyclerViewHolder(v: View?) : RecyclerView.ViewHolder(v) {
        fun bindItems(s: String) {
            itemView.tv_articleName.text=s
        }

    }

    override fun getItemCount(): Int =listOfBlog.size


    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindItems(listOfBlog[position])
    }



}


