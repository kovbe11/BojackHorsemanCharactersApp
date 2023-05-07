package hu.bme.aut.android.bojackhorseman.ui.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentAddBinding
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.ui.list.CharactersFragment

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: AddViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.saveButton.setOnClickListener {
            val characterName = binding.characterName.str()
            val voiceActor = binding.voiceActor.str()
            val species = binding.species.str()
            if (characterName.isEmpty() or voiceActor.isEmpty() or species.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            viewModel.onCreate(
                Character(
                    name = characterName,
                    voiceActor = voiceActor,
                    species = species
                )
            )
            parentFragmentManager.commit {
                replace(R.id.fragment_container, CharactersFragment.newInstance())
            }
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity())[AddViewModel::class.java]
    }

    private fun EditText.str() = this.text.toString()

    companion object {
        @JvmStatic
        fun newInstance() =
            AddFragment()
    }
}