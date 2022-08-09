package com.althaafridha.latihangetapi.data

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("UserItem")
	val userItem: List<UserItem?>? = null
)