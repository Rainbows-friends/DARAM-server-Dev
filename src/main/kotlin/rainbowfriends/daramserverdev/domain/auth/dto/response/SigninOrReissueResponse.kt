package rainbowfriends.daramserverdev.domain.auth.dto.response

import rainbowfriends.daramserverdev.global.member.enums.Roles

data class SigninOrReissueResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExpiresIn: String,
    val refreshTokenExpiresIn: String,
    val role: Roles
)