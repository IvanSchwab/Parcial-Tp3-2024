package com.edu.grupo6.parcial_tp3_2024.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.edu.grupo6.parcial_tp3_2024.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)

        Handler().postDelayed({
            //val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:911"))

            //Logica Carga Forzada

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

    }

}