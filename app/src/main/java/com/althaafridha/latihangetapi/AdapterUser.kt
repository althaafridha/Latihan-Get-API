package com.althaafridha.latihangetapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.latihangetapi.data.UserItem
import com.althaafridha.latihangetapi.databinding.ItemUserBinding
import com.bumptech.glide.Glide

class AdapterUser : RecyclerView.Adapter<AdapterUser.UserViewHolder>() {

	private val listUser = ArrayList<UserItem>()

	inner class UserViewHolder(val itemUser: ItemUserBinding) : RecyclerView.ViewHolder(itemUser.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
		ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)

	override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
		holder.itemUser.apply {
			with(listUser[position]){
				textView.text = login
				Glide.with(imageView.context).load(avatarUrl).into(imageView)
			}
		}
	}

	override fun getItemCount() = listUser.size

	fun setUser(user: ArrayList<UserItem>){
		this.listUser.clear()
		this.listUser.addAll(user)

	}
}
