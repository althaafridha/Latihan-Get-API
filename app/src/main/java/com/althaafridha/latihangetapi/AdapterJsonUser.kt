package com.althaafridha.latihangetapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.latihangetapi.data.JsonUserResponseItem
import com.althaafridha.latihangetapi.databinding.ItemUserBinding

class AdapterJsonUser: RecyclerView.Adapter<AdapterJsonUser.JsonUserViewModel>() {

	private val listJsonUser = ArrayList<JsonUserResponseItem>()

	inner class JsonUserViewModel(val itemJsonUser: ItemUserBinding): RecyclerView.ViewHolder(itemJsonUser.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = JsonUserViewModel(
		ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)

	override fun onBindViewHolder(holder: JsonUserViewModel, position: Int) {
		holder.itemJsonUser.apply {
			with(listJsonUser[position]){
				textView.text = name
				textView2.text = email
				textView3.text = "latitude: " + address?.geo?.lat
			}
		}
	}

	override fun getItemCount() = listJsonUser.size

	fun setData(data: ArrayList<JsonUserResponseItem>){
		this.listJsonUser.clear()
		this.listJsonUser.addAll(data)
	}
}