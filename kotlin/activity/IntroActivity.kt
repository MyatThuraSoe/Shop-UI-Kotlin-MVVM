package com.example.mtbazaar.activity

import android.content.Intent
import android.os.Bundle
import com.example.mtbazaar.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {

    private lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Corrected the spelling of 'setOnClickListener'
        binding.startBtn.setOnClickListener {
            // Corrected the parameter name in the Intent constructor
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))
        }
    }
}
