package com.suret.taskdesign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suret.taskdesign.R
import com.suret.taskdesign.model.NotificationOfferModel

class FeedRecyclerAdapter(private val feedList: MutableList<NotificationOfferModel>) :
    RecyclerView.Adapter<FeedRecyclerAdapter.FeedViewHolder>() {


    inner class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.feed_icon_IW)
        val title: TextView = itemView.findViewById(R.id.feed_title_TV)
        val desc: TextView = itemView.findViewById(R.id.feed_desc_TV)
        val date: TextView = itemView.findViewById(R.id.feed_date_TV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FeedViewHolder(layoutInflater.inflate(R.layout.feed_list_layout, parent, false))
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.icon.setImageResource(feedList[position].icon)
        holder.title.text = feedList[position].title
        holder.desc.text = feedList[position].desc
        holder.date.text = feedList[position].date
    }

    override fun getItemCount(): Int = feedList.size
}