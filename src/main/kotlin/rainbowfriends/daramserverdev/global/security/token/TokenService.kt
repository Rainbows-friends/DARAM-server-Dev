package rainbowfriends.daramserverdev.global.security.token

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import rainbowfriends.daramserverdev.global.member.enums.Roles
import rainbowfriends.daramserverdev.global.security.dto.TokenResponse

@Deprecated(message = "Use JwtTokenService instead")
interface TokenService {
    fun generateTokenDto(key: String, role: Roles): TokenResponse
    fun deleteToken(token: String)
    fun decodeToken(token: String): UsernamePasswordAuthenticationToken
    fun validateToken(token: String): Boolean
}