package hu.bme.aut.android.bojackhorseman.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.bojackhorseman.R


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}