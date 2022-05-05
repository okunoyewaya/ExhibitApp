package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exhibitapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.child_recyclerview_item.view.*
import kotlinx.android.synthetic.main.parent_recyclerview.view.*


class ChildAdapter(val ExhibitImageList: ArrayList<String>) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildAdapter.ChildViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_recyclerview_item, parent, false)

        return ChildViewHolder(view)
    }

    override fun getItemCount() = ExhibitImageList.count()

    override fun onBindViewHolder(holder: ChildAdapter.ChildViewHolder, position: Int) {
        val exhibitImageItem = ExhibitImageList[position]
        holder.itemView.apply {
            Picasso.get().load(exhibitImageItem).into(ivImage)
        }
    }

}