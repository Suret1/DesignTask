package com.suret.lafyuu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suret.lafyuu.R
import com.suret.lafyuu.model.NotificationOfferModel

class OfferNotificationAdapter(private val offerList: MutableList<NotificationOfferModel>) :
    RecyclerView.Adapter<OfferNotificationAdapter.OfferViewHolder>() {

    inner class OfferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon : ImageView = itemView.findViewById(R.id.offer_icon_IW)
        val title : TextView = itemView.findViewById(R.id.offer_title_TV)
        val desc : TextView = itemView.findViewById(R.id.offer_desc_TV)
        val date : TextView = itemView.findViewById(R.id.offer_date_TV)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.notification_offer_layout, parent, false)
        return OfferViewHolder(view)
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.icon.setImageResource(offerList[position].icon)
        holder.title.text = offerList[position].title
        holder.desc.text = offerList[position].desc
        holder.date.text = offerList[position].date
    }

    override fun getItemCount(): Int = offerList.size
}