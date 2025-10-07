package com.example.portfolioapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Handle the splash screen transition.
        installSplashScreen()

        setContentView(R.layout.activity_main)

        val nameText = findViewById<TextView>(R.id.nameText)
        val roleText = findViewById<TextView>(R.id.roleText)
        val profileImage = findViewById<ImageView>(R.id.profileImage)

        val githubBtn = findViewById<ImageButton>(R.id.githubButton)
        val emailBtn = findViewById<ImageButton>(R.id.emailButton)
        val linkedinBtn = findViewById<ImageButton>(R.id.linkedinButton)
        val instaBtn = findViewById<ImageButton>(R.id.instaButton)

        profileImage.animate()
            .alpha(1f)
            .scaleX(1.1f)
            .scaleY(1.1f)
            .setDuration(1000)
            .start()

        startTypewriterEffect(nameText, "Kishan Garhwal")

        githubBtn.setOnClickListener {
            openLink("https://github.com/Kishan8548")
        }

        emailBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:kishangarhwal@gmail.com")
            }
            startActivity(intent)
        }

        linkedinBtn.setOnClickListener {
            openLink("https://www.linkedin.com/in/kishan-garhwal-122298331?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app")
        }

        instaBtn.setOnClickListener {
            openLink("https://www.instagram.com/hy.kishan_")
        }
    }

    private fun startTypewriterEffect(textView: TextView, text: String) {
        var i = 0
        val delay: Long = 60
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                if (i <= text.length) {
                    textView.text = text.substring(0, i)
                    i++
                    handler.postDelayed(this, delay)
                }
            }
        })
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
