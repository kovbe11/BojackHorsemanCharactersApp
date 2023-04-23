package hu.bme.aut.android.bojackhorseman.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hu.bme.aut.android.bojackhorseman.databinding.FragmentEditBinding

class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        binding.saveButton.setOnClickListener {
            TODO("Save to db, pass data")
        }
        binding.deleteButton.setOnClickListener {
            TODO("Delete from db")
        }
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = EditFragment()
    }
}