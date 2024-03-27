package com.example.retrofitexample

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofitexample.Retrofit.Mainviewmodel

class MainActivity : AppCompatActivity() {
    private val viewmodel:Mainviewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel.post.observe(this, { mypost ->
            findViewById<TextView>(R.id.textpost).text = mypost.activity
        })

        val delayMillis = 2000L // 2 saniyə
        val progressBarVisible = true
       val progressBar = findViewById<ProgressBar>(R.id.progressbar)
        // Əgər 2 saniyədən az zaman keçibsə, proqress çubuğunu göstər
        if (progressBarVisible) {
            progressBar.visibility = android.widget.ProgressBar.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                // 2 saniyə sonra proqress çubuğunu gizlə
                progressBar.visibility = ProgressBar.INVISIBLE
            }, delayMillis)
        } else {
            // Əks halda, proqress çubuğunu gizlə
            progressBar.visibility = android.widget.ProgressBar.INVISIBLE
        }
    }
}