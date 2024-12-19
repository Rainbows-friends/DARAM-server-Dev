package rainbowfriends.daramserverdev.domain.auth.service

import rainbowfriends.daramserverdev.global.security.dto.TokenResponse

@Deprecated(message = "Use JwtTokenService instead")
interface AdminAuthorizationService {
    fun authorizeAdmin(key: String): TokenResponse
}