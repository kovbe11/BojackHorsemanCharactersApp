package hu.bme.aut.android.bojackhorseman.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentWelcomeScreenBinding
import hu.bme.aut.android.bojackhorseman.ui.list.CharactersFragment

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, CharactersFragment.newInstance())
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WelcomeScreenFragment()
    }
}