package hu.bme.aut.android.bojackhorseman.ui.edit

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
import hu.bme.aut.android.bojackhorseman.databinding.FragmentEditBinding
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.ui.list.CharactersFragment

class EditFragment(private val character: Character) : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private lateinit var viewModel: EditViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        binding.characterName.setValue(character.name)
        binding.voiceActor.setValue(character.voiceActor)
        binding.species.setValue(character.species)
        binding.saveButton.setOnClickListener {
            val characterName = binding.characterName.str()
            val voiceActor = binding.voiceActor.str()
            val species = binding.species.str()
            if (characterName.isEmpty() or voiceActor.isEmpty() or species.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            viewModel.onUpdate(Character(character.id, characterName, voiceActor, species))
            parentFragmentManager.commit {
                replace(R.id.fragment_container, CharactersFragment.newInstance())
            }
        }
        binding.deleteButton.setOnClickListener {
            viewModel.onDelete(character)
            parentFragmentManager.commit {
                replace(R.id.fragment_container, CharactersFragment.newInstance())
            }
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity())[EditViewModel::class.java]
    }

    private fun EditText.setValue(str: String) = this.text.insert(0, str)

    private fun EditText.str() = this.text.toString()

    companion object {
        @JvmStatic
        fun newInstance(character: Character) = EditFragment(character)
    }
}