package rainbowfriends.daramserverdev.global.security.exception

@Deprecated(message = "Use JwtTokenService instead")
class TokenFormatException(message: String) : RuntimeException(message)