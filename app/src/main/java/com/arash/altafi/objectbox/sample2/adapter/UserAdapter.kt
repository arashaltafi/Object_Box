package com.arash.altafi.objectbox.sample2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arash.altafi.objectbox.R
import com.arash.altafi.objectbox.sample2.model.User2

class UserAdapter(
    var context: Context,
    private val data: ArrayList<User2>,
    private val callback: UserAdapterInterface
) : RecyclerView.Adapter<UserAdapter.UserVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return UserVH(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val item = data[position]

        holder.userName.text = item.userName
        holder.email.text = item.userEmail

        holder.delete.setOnClickListener {
            callback.delete(item)
        }

        holder.update.setOnClickListener {
            callback.update(item)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addUserData(userData:ArrayList<User2>){
        data.apply {
            clear()
            addAll(userData)
        }
        notifyDataSetChanged()
    }

    class UserVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val email: TextView = itemView.findViewById(R.id.email)
        val delete: ImageView = itemView.findViewById(R.id.button_delete)
        val update: ImageView = itemView.findViewById(R.id.button_update)
    }

    interface UserAdapterInterface {
        fun delete(item: User2)
        fun update(item: User2)
    }
}