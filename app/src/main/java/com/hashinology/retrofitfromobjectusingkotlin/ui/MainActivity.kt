package com.hashinology.retrofitfromobjectusingkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.hashinology.retrofitfromobjectusingkotlin.R
import com.hashinology.retrofitfromobjectusingkotlin.models.MyDataPost
import com.hashinology.retrofitfromobjectusingkotlin.remote.RetrofitClient
import com.hashinology.retrofitfromobjectusingkotlin.ui.adapter.ItemClcikListner
import com.hashinology.retrofitfromobjectusingkotlin.ui.adapter.PostAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ItemClcikListner {
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    private fun getData() {
        val call: Call<MyDataPost> = RetrofitClient().getRetrofitInstance().apiInterface?.getPost()!!
        call.enqueue(object : Callback<MyDataPost?> {
            override fun onResponse(call: Call<MyDataPost?>, response: Response<MyDataPost?>) {
                if(response.isSuccessful){
                    setRescylerview(response)
                }
            }

            override fun onFailure(call: Call<MyDataPost?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setRescylerview(response: Response<MyDataPost?>) {
        postAdapter = PostAdapter(response.body()!!, this, this)
        rvOnline.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun getItemClickListner(view: View, position: Int) {
        Toast.makeText(this@MainActivity, "Current Position is: "+position, Toast.LENGTH_LONG).show()
    }
}