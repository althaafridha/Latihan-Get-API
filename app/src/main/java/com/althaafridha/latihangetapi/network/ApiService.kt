package com.althaafridha.latihangetapi.network

import com.althaafridha.latihangetapi.data.JsonUserResponseItem
import com.althaafridha.latihangetapi.data.UserItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
//	@GET("users")
//	@Headers("Authorization: token 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")
//	fun getListUsers(): Call<ArrayList<UserItem>>

	@GET("users")
	fun getListJsonUsers(): Call<ArrayList<JsonUserResponseItem>>

}