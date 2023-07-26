package epita.exam.frvol.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import epita.exam.frvol.MainActivity
import epita.exam.frvol.R
import epita.exam.frvol.models.LoginResponse
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)

        // handle sign out
        val imgSignout = findViewById<ImageView>(R.id.img_signout)
        imgSignout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Retrieve the loginResponse JSON string from the Intent extras
        val jsonString = intent.getStringExtra("loginResponse")
        val loginResponse = parseJsonToLoginResponse(jsonString)

        // Print the userId and token from the LoginResponse
        println("UserId: ${loginResponse.userId}")
        println("Token: ${loginResponse.token}")
    }

    private fun parseJsonToLoginResponse(jsonString: String?): LoginResponse {
        // Parse the JSON string and create a LoginResponse object
        val jsonObject = JSONObject(jsonString)
        val userId = jsonObject.optString("userId")
        val userName = jsonObject.optString("userName")
        val token = jsonObject.optString("token")
        val message = jsonObject.optString("message")
        val code = jsonObject.optString("code")

        return LoginResponse(userId, userName, token, message, code)
    }

}