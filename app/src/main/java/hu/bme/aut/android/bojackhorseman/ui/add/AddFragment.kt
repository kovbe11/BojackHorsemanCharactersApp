package hu.bme.aut.android.bojackhorseman.ui.add

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.android.bojackhorseman.databinding.FragmentAddBinding
import hu.bme.aut.android.bojackhorseman.model.Character

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private var character: Character? = null
    private lateinit var viewModel: AddViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.saveButton.setOnClickListener {
            viewModel.onCreate(Character(3, "create", "create", "create"))
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity())[AddViewModel::class.java]
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddFragment()
    }
}