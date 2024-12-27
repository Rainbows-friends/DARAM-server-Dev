package rainbowfriends.daramserverdev.domain.auth.service

interface ValidateTokenService {
    fun validateToken(token: String): Boolean
}