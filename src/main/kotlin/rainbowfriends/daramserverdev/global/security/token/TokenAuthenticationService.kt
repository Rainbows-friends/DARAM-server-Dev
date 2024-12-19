package rainbowfriends.daramserverdev.global.security.token

import rainbowfriends.daramserverdev.global.member.enums.Roles

@Deprecated(message = "Use JwtTokenService instead")
interface TokenAuthenticationService {
    fun getRoleByToken(token: String): Roles
}