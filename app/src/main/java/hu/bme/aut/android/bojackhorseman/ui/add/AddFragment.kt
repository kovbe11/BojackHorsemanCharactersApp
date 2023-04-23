package hu.bme.aut.android.bojackhorseman.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hu.bme.aut.android.bojackhorseman.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.saveButton.setOnClickListener {
            TODO("Save to db, pass data")
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddFragment()
    }
}