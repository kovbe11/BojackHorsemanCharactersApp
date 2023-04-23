package hu.bme.aut.android.bojackhorseman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.bojackhorseman.ui.welcome.WelcomeScreenFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            this.replace(R.id.fragment_container, WelcomeScreenFragment.newInstance());
        }
    }

}