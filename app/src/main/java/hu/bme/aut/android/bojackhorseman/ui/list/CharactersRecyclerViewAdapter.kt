package hu.bme.aut.android.bojackhorseman.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.bojackhorseman.MainActivity
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentCharacterItemBinding
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.ui.details.DetailsFragment
import hu.bme.aut.android.bojackhorseman.ui.edit.EditFragment


class CharactersRecyclerViewAdapter :
    ListAdapter<Character, CharactersRecyclerViewAdapter.ViewHolder>(CharacterItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.contentView.text = item.name
        holder.editButton.setOnClickListener {
            (it.context as MainActivity).supportFragmentManager.commit {
                addToBackStack("characters")
                replace(R.id.fragment_container, EditFragment.newInstance(item))
            }
        }
        holder.itemView.setOnClickListener {
            (it.context as MainActivity).supportFragmentManager.commit {
                addToBackStack("characters")
                replace(R.id.fragment_container, DetailsFragment.newInstance(item))
            }
        }
    }

    inner class ViewHolder(binding: FragmentCharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val contentView: TextView = binding.name
        val editButton: ImageButton = binding.editButton

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}

object CharacterItemCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem == newItem
}