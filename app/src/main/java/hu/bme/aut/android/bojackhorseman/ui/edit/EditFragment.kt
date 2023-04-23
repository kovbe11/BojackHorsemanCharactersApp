package hu.bme.aut.android.bojackhorseman.ui.edit

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.android.bojackhorseman.databinding.FragmentEditBinding
import hu.bme.aut.android.bojackhorseman.model.Character

// TODO wire character in
class EditFragment(private val character: Character? = null) : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private lateinit var viewModel: EditViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        binding.saveButton.setOnClickListener {
            viewModel.onUpdate(Character(1, "edited", "edited", "edited"))
        }
        binding.deleteButton.setOnClickListener {
            viewModel.onDelete(Character(2, "toDelete", "toDelete", "toDelete"))
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity())[EditViewModel::class.java]
    }


    companion object {
        @JvmStatic
        fun newInstance() = EditFragment()
    }
}