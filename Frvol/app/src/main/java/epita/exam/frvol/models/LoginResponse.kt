package epita.exam.frvol.models

data class LoginResponse(
    val userId: String,
    val userName: String,
    val token: String,
    val message: String,
    val code: String
)
