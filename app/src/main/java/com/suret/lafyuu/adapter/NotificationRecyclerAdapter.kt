package com.suret.lafyuu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suret.lafyuu.R
import com.suret.lafyuu.model.NotificationModel

class NotificationRecyclerAdapter(
    private val notificationList: MutableList<NotificationModel>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<NotificationRecyclerAdapter.MyNotificationHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNotificationHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.notification_list_layout, parent, false)
        return MyNotificationHolder(view)
    }

    override fun onBindViewHolder(holder: MyNotificationHolder, position: Int) {
        holder.imageIcon.setImageResource(notificationList[position].imageIcon)
        holder.title.text = (holder.itemView.resources.getString(notificationList[position].title))
        holder.count.text = notificationList[position].notification
    }

    override fun getItemCount(): Int = notificationList.size

    inner class MyNotificationHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageIcon: ImageView = itemView.findViewById(R.id.icon_notification_item)
        val title: TextView = itemView.findViewById(R.id.title_notification_item)
        val count: TextView = itemView.findViewById(R.id.count_notification_item)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}