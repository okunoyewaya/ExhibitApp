package com.example.exhibitapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exhibitapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.parent_recyclerview.view.*
import com.example.exhibitapp.models.Exhibit
import com.example.exhibitapp.models.ExhibitItem

class ParentAdapter: RecyclerView.Adapter<ParentAdapter.TitleViewHolder>() {

    inner class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object: DiffUtil.ItemCallback<ExhibitItem>() {
        override fun areItemsTheSame(oldItem: ExhibitItem, newItem: ExhibitItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ExhibitItem, newItem: ExhibitItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_recyclerview, parent, false)

        return TitleViewHolder(view)
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        val exhibitItem = differ.currentList[position]
        val childAdapter = ChildAdapter(exhibitItem.images as ArrayList<String>)
        holder.itemView.apply {
            tvTitle.text = exhibitItem.title
            rvChild.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            rvChild.adapter = childAdapter
        }
    }

}