package com.example.dotindicator

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(val context: Context, private val images:List<Int>):RecyclerView.Adapter<ViewPageAdapter.ViewPageViewHolder>() {
    inner class ViewPageViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.item_img_iv)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPageAdapter.ViewPageViewHolder {
         val view=LayoutInflater.from(context).inflate(R.layout.list_items,parent,false)
        return ViewPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPageAdapter.ViewPageViewHolder, position: Int) {
     val perticularImg=images[position]
        holder.imageView.setImageResource(perticularImg)
    }

    override fun getItemCount(): Int {
       return images.size
    }
}