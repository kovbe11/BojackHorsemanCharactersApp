package hu.bme.aut.android.bojackhorseman.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentDetailsBinding
import hu.bme.aut.android.bojackhorseman.model.Character
import hu.bme.aut.android.bojackhorseman.ui.edit.EditFragment

class DetailsFragment(private val character: Character) : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.characterName.text = character.name
        binding.voiceActor.text = character.voiceActor
        binding.species.text = character.species

        binding.editButton.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack("details")
                replace(R.id.fragment_container, EditFragment.newInstance(character))
            }
        }
        return binding.root
    }


    companion object {
        fun newInstance(character: Character) =
            DetailsFragment(character)
    }
}