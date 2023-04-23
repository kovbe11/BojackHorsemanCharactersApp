package hu.bme.aut.android.bojackhorseman.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.bojackhorseman.databinding.CharactersListBinding
import hu.bme.aut.android.bojackhorseman.placeholder.PlaceholderContent

class CharacterFragment : Fragment() {

    private lateinit var binding: CharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharactersListBinding.inflate(inflater, container, false)

        with(binding.characters) {
            layoutManager = LinearLayoutManager(context)
            adapter = CharactersRecyclerViewAdapter(PlaceholderContent.ITEMS)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = CharacterFragment()
    }
}