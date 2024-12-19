package rainbowfriends.daramserverdev.global.security.dto

@Deprecated("Use JwtTokenService instead")
data class TokenResponse(
    val accessToken: String
)