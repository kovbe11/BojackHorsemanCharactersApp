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

// TODO wire in character
class DetailsFragment(private val character: Character? = null) : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.editButton.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, EditFragment.newInstance()) //TODO pass data
            }
        }
        return binding.root
    }


    companion object {
        fun newInstance() =
            DetailsFragment()
    }
}