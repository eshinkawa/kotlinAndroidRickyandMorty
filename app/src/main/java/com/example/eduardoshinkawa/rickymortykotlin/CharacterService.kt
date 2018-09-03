package com.example.eduardoshinkawa.rickymortykotlin
import com.example.eduardoshinkawa.rickymortykotlin.Models.Characters
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    fun list() : Call<Characters>
}