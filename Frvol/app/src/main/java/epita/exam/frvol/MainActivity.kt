package epita.exam.frvol

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import epita.exam.frvol.activities.HomeActivity
import epita.exam.frvol.activities.RegistrationIntro
import android.util.Patterns
import android.widget.EditText
import epita.exam.frvol.interfaces.ApiService
import epita.exam.frvol.models.LoginRequest
import epita.exam.frvol.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.MessageDigest
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://francevolunteer.tam.name.vn:8081/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {

//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val btnSignIn = findViewById<Button>(R.id.button_sign_in)
//        val tvSignup = findViewById<TextView>(R.id.tv_signup)
//        val tvForgot = findViewById<TextView>(R.id.tv_forgot)
//
//        tvSignup.setOnClickListener {
//            val intent = Intent(this, RegistrationIntro::class.java)
//            startActivity(intent)
//        }
//
//        btnSignIn.setOnClickListener {
//            //val intent = Intent(this, HomeActivity::class.java)
//            //startActivity(intent)
//            val email = findViewById<EditText>(R.id.edit_text_email).text.toString().trim()
//            val password = findViewById<EditText>(R.id.edit_text_password).text.toString().trim()
//
//            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                // Invalid email format
//                findViewById<EditText>(R.id.edit_text_email).error = "Invalid email"
//                return@setOnClickListener
//            }
//
//            if (password.isEmpty()) {
//                // Empty password
//                findViewById<EditText>(R.id.edit_text_password).error = "Password cannot be empty"
//                return@setOnClickListener
//            }
//
//            // Encrypt the password
//            //val encryptedPassword = encryptPassword(password)
//            val encryptedPassword = password
//
//            // Create the API service
//            val apiService = retrofit.create(ApiService::class.java)
//
//            // Create the request body
//            val request = LoginRequest(email, encryptedPassword)
//
//            // Make the API call
//            val call = apiService.signIn(request)
//
//            // Handle the API response
//            call.enqueue(object : Callback<LoginResponse> {
//                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                    if (response.isSuccessful) {
//                        val loginResponse = response.body()
//                        Log.d("API_RESPONSE", loginResponse.toString())
//                        if (loginResponse != null && loginResponse.code == "200") {
//                            val intent = Intent(this@MainActivity, HomeActivity::class.java)
//                            val gson = Gson()
//                            val jsonString = gson.toJson(loginResponse)
//                            intent.putExtra("loginResponse", jsonString)
//                            startActivity(intent)
//                        } else {
//                            Log.e("TAG", "3. Call Login api failed")
//                        }
//                    } else {
//                        Log.e("TAG", "1. Call Login api failed")
//                    }
//                }
//
//                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                    Log.e("TAG", "2. Call Login api failed")
//                }
//            })
//
//
//        }
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.event_detail)
        //setContentView(R.layout.splash)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.event_list1)
        //setContentView(R.layout.rewards)
    }

    private fun encryptPassword(password: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(password.toByteArray())
        return hash.joinToString("") {
            "%02x".format(it)
        }
    }

}