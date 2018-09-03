package com.example.eduardoshinkawa.rickymortykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.example.eduardoshinkawa.rickymortykotlin.Models.Characters
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val call = RetrofitInitializer().characterService().list()
        call.enqueue(object : Callback<Characters>{
            override fun onResponse(call: Call<Characters>, response: Response<Characters>) {
                val list = response.body()
                list?.let {
                    configureList(list)
                }
            }

            override fun onFailure(call: Call<Characters>, t: Throwable) {
                println("deu ruim" + t.message)
            }
        })
    }

    private fun configureList(characters: Characters) {
        val recyclerView = recyclerView_main
        recyclerView.adapter = MainAdapter(characters, this)
        val layoutManager = StaggeredGridLayoutManager(
                1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
    }
}
