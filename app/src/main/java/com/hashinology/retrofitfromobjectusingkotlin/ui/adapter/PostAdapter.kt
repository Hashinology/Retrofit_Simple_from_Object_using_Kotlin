package com.hashinology.retrofitfromobjectusingkotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.retrofitfromobjectusingkotlin.R
import com.hashinology.retrofitfromobjectusingkotlin.models.MyDataPost

class PostAdapter(
    val myDataPost: MyDataPost,
    val context: Context,
    val itemClcikListner: ItemClcikListner
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = myDataPost.get(position)
        holder.tvUserID.text = post.userId.toString()
        holder.tvID.text = post.id.toString()
        holder.tvTitle.text = post.title
        holder.tvBody.text = post.body
    }

    override fun getItemCount(): Int {
        return myDataPost.size
    }

    inner class PostViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val tvUserID = itemView.findViewById<TextView>(R.id.tvUsrId)
        val tvID = itemView.findViewById<TextView>(R.id.tvID)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvBody = itemView.findViewById<TextView>(R.id.tvBody)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View) {
            itemClcikListner.getItemClickListner(p0, adapterPosition)
        }
    }
}