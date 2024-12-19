package rainbowfriends.daramserverdev.domain.auth.exception

@Deprecated(message = "Use JwtTokenService instead")
class TokenNotFoundException(message: String) : RuntimeException(message)