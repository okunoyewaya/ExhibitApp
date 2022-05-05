package com.example.exhibitapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exhibitapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.child_recyclerview_item.view.*


class ChildAdapter(private var exhibitImageList: ArrayList<String>) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_recyclerview_item, parent, false)

        return ChildViewHolder(view)
    }

    override fun getItemCount() = exhibitImageList.count()

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val exhibitImageItem = exhibitImageList[position]
        holder.itemView.apply {
            Picasso.get().load(exhibitImageItem).into(ivImage)
        }
    }

}