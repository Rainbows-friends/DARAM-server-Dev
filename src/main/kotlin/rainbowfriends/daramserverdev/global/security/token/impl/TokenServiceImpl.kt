package rainbowfriends.daramserverdev.global.security.token.impl

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.global.member.enums.Roles
import rainbowfriends.daramserverdev.global.security.component.DecodeToken
import rainbowfriends.daramserverdev.global.security.component.DeleteToken
import rainbowfriends.daramserverdev.global.security.component.GenerateToken
import rainbowfriends.daramserverdev.global.security.component.ValidateToken
import rainbowfriends.daramserverdev.global.security.dto.TokenResponse
import rainbowfriends.daramserverdev.global.security.token.TokenService

@Deprecated(message = "Use JwtTokenService instead")
@Service
class TokenServiceImpl(
    private val generateToken: GenerateToken,
    private val decodeToken: DecodeToken,
    private val validateToken: ValidateToken,
    private val deleteToken: DeleteToken
) : TokenService {
    override fun generateTokenDto(key: String, role: Roles): TokenResponse {
        return TokenResponse(generateToken.generateToken(role))
    }

    override fun deleteToken(token: String): Unit {
        deleteToken.deleteToken(token)
    }

    override fun decodeToken(token: String): UsernamePasswordAuthenticationToken {
        return decodeToken.decodeToken(token)
    }

    override fun validateToken(token: String): Boolean {
        return validateToken.validateToken(token)
    }
}