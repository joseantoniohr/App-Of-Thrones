package com.timplesoft.appofthrones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter: RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder> {

    constructor(): super() {
        itemClickListener = null
    }

    constructor(itemClickListener: ((Character, Int) -> Unit)): super() {
        this.itemClickListener = itemClickListener
    }

    private val items = mutableListOf<Character>()
    private val itemClickListener: ((Character, Int) -> Unit)?

    inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var character: Character? = null
            set(value) {
                itemView.findViewById<TextView>(R.id.label_name).text = value?.name
                field = value
            }

        init {
            itemView.setOnClickListener {
                character?.let {
                    itemClickListener?.invoke(character as Character, adapterPosition)
                }
            }
        }
    }

    fun setCharacters(characters: MutableList<Character>) {
        this.items.clear()
        this.items.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.items.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = this.items[position]

        holder.character = character
    }

}