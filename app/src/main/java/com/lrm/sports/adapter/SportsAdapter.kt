package com.lrm.sports.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lrm.sports.R
import com.lrm.sports.data.SportsData
import com.lrm.sports.model.Sport


class SportsAdapter(
    private val context: Context,
    private val onItemClicked: (Sport) -> Unit
) : RecyclerView.Adapter<SportsAdapter.MyViewHolder>() {

    private val dataList = SportsData.getSportsData()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sportsTitle: TextView = view.findViewById(R.id.sportsTitle)
        val sportsImage: ImageView = view.findViewById(R.id.sportsImage)
        val sportsSubtitle: TextView = view.findViewById(R.id.sportsSubtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.sports_list_item, parent, false)

        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sport = dataList[position]

        holder.sportsTitle.text = context.resources.getString(sport.titleResourceId)
        holder.sportsImage.setImageResource(sport.imageResourceId)
        holder.sportsSubtitle.text = context.resources.getString(sport.subTitleResourceId)

        holder.itemView.setOnClickListener {
            onItemClicked(sport)
        }
    }

}