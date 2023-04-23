package hu.bme.aut.android.bojackhorseman.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.bojackhorseman.MainActivity
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentCharacterItemBinding
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.ui.details.DetailsFragment
import hu.bme.aut.android.bojackhorseman.ui.edit.EditFragment


class CharactersRecyclerViewAdapter(
    private val values: List<Character>
) : RecyclerView.Adapter<CharactersRecyclerViewAdapter.ViewHolder>() {

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
        val item = values[position]
        holder.contentView.text = item.name
        holder.editButton.setOnClickListener {
            (it.context as MainActivity).supportFragmentManager.commit {
                replace(R.id.fragment_container, EditFragment.newInstance())
            }
        }
        holder.itemView.setOnClickListener {
            (it.context as MainActivity).supportFragmentManager.commit {
                replace(R.id.fragment_container, DetailsFragment.newInstance())
            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val contentView: TextView = binding.name
        val editButton: ImageButton = binding.editButton

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}