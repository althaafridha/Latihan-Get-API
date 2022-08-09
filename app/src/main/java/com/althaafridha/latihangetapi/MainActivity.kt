package com.althaafridha.latihangetapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.althaafridha.latihangetapi.data.JsonUserResponseItem
import com.althaafridha.latihangetapi.databinding.ActivityMainBinding
import com.althaafridha.latihangetapi.data.UserItem
import com.althaafridha.latihangetapi.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

	private var _binding: ActivityMainBinding? = null
	private val binding get() = _binding as ActivityMainBinding

//	private val adapterUser = AdapterUser()
	private val adapterJsonUser = AdapterJsonUser()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)


//		get API
//		getDataApi()
		getDataJsonApi()

//		set layout manager dan adapter
	}

	private fun getDataJsonApi() {
		ApiConfig.getApiService().getListJsonUsers().enqueue(object : Callback<ArrayList<JsonUserResponseItem>> {
			override fun onResponse(
				call: Call<ArrayList<JsonUserResponseItem>>,
				response: Response<ArrayList<JsonUserResponseItem>>
			) {
				response.body()?.let {
					setJsonData(it)
				}
			}

			override fun onFailure(call: Call<ArrayList<JsonUserResponseItem>>, t: Throwable) {
				Log.e("TAG", "onFailure: $t", )
			}

		})
	}

	private fun setJsonData(data: ArrayList<JsonUserResponseItem>) {
		binding.rvList.apply {
			layoutManager = LinearLayoutManager(applicationContext)
			adapter = adapterJsonUser
			adapterJsonUser.setData(data)
		}
	}

//	fun setData(data: ArrayList<UserItem>){
//		binding.rvList.apply {
//			setHasFixedSize(true)
//			layoutManager = LinearLayoutManager(applicationContext)
//			adapter = adapterUser
//			adapterUser.setUser(data)
//		}
//	}

//	private fun getDataApi() {
//		ApiConfig.getApiService().getListUsers().enqueue(object : Callback<ArrayList<UserItem>> {
//			override fun onResponse(
//				call: Call<ArrayList<UserItem>>,
//				response: Response<ArrayList<UserItem>>
//			) {
//				response.body()?.let {
////					adapterUser.setUser(it)
//					setData(it)
//				}
//			}
//
//			override fun onFailure(call: Call<ArrayList<UserItem>>, t: Throwable) {
//				Log.e("TAG", "onFailure: $t")
//			}
//
//		})
//	}
}