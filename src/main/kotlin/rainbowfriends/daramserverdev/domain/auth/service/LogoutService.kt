package rainbowfriends.daramserverdev.domain.auth.service

import jakarta.servlet.http.HttpServletRequest

@Deprecated(message = "Use JwtTokenService instead")
interface LogoutService {
    fun logout(request: HttpServletRequest)
}