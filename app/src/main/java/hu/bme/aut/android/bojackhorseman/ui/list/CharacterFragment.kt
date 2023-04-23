package hu.bme.aut.android.bojackhorseman.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentCharactersListBinding
import hu.bme.aut.android.bojackhorseman.placeholder.PlaceholderContent
import hu.bme.aut.android.bojackhorseman.ui.add.AddFragment

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersListBinding.inflate(inflater, container, false)

        with(binding.characters) {
            layoutManager = LinearLayoutManager(context)
            adapter = CharactersRecyclerViewAdapter(PlaceholderContent.ITEMS)
        }

        binding.fab.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, AddFragment.newInstance())
            }
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = CharacterFragment()
    }
}