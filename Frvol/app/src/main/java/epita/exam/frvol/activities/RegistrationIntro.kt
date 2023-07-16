package epita.exam.frvol.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import epita.exam.frvol.R

class RegistrationIntro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_intro)

        val btnStartApplication = findViewById<Button>(R.id.btn_start_application)
        btnStartApplication.setOnClickListener {
            val intent = Intent(this, RegistrationPersonalInfor::class.java)
            startActivity(intent)
        }
    }

}