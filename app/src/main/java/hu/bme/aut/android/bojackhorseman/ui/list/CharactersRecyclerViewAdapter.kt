package hu.bme.aut.android.bojackhorseman.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.bojackhorseman.databinding.CharacterItemBinding
import hu.bme.aut.android.bojackhorseman.model.Character

class CharactersRecyclerViewAdapter(
    private val values: List<Character>
) : RecyclerView.Adapter<CharactersRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.contentView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val contentView: TextView = binding.name

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}