package com.example.eduardoshinkawa.rickymortykotlin
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eduardoshinkawa.rickymortykotlin.Models.CharacterRM
import com.example.eduardoshinkawa.rickymortykotlin.Models.Characters
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(private val characters: Characters,
                  private val context: Context): Adapter<MainAdapter.ViewHolder>() {

    override fun onBindViewHolder( holder: ViewHolder, position: Int ) {
        val character = characters.results[position]
        holder?.let {
            it.bindView(character)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.video_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(character: CharacterRM) {
            val title = itemView.profile_name
            val desc = itemView.profile_desc

            title.text = character.name
            desc.text = character.species
        }

    }

}