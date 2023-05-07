package hu.bme.aut.android.bojackhorseman.ui.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentCharactersListBinding
import hu.bme.aut.android.bojackhorseman.ui.add.AddFragment

class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding

    private lateinit var viewModel: CharactersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersListBinding.inflate(inflater, container, false)
        val adapter = CharactersRecyclerViewAdapter()
        with(binding.characters) {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

        viewModel.characters.observe(viewLifecycleOwner) { characters ->
            adapter.submitList(characters)
        }

        binding.fab.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack("characters")
                replace(R.id.fragment_container, AddFragment.newInstance())
            }
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity())[CharactersViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadCharacters()
    }

    companion object {

        @JvmStatic
        fun newInstance() = CharactersFragment()
    }
}