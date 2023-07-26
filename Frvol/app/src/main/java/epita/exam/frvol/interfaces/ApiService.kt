package epita.exam.frvol.interfaces

import epita.exam.frvol.models.LoginRequest
import epita.exam.frvol.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("ept/frvol/auth/volunteer/signin")
    fun signIn(@Body body: LoginRequest): Call<LoginResponse>

}