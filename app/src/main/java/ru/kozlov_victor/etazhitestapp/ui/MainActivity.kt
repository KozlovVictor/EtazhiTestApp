package ru.kozlov_victor.etazhitestapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kozlov_victor.etazhitestapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}