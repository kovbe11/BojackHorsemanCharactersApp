package hu.bme.aut.android.bojackhorseman.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import hu.bme.aut.android.bojackhorseman.R
import hu.bme.aut.android.bojackhorseman.databinding.FragmentWelcomeScreenBinding
import hu.bme.aut.android.bojackhorseman.ui.list.CharactersFragment

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding
    private lateinit var analytics: FirebaseAnalytics

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        analytics = Firebase.analytics
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, null)

        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, CharactersFragment.newInstance())
            }
        }
        binding.crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WelcomeScreenFragment()
    }
}