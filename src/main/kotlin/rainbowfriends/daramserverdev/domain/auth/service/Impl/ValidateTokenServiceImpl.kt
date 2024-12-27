package rainbowfriends.daramserverdev.domain.auth.service.Impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.auth.service.ValidateTokenService
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenParserService

@Service
class ValidateTokenServiceImpl(private val jwtTokenParserService: JwtTokenParserService): ValidateTokenService {
    override fun validateToken(token: String): Boolean {
        return jwtTokenParserService.isTokenValid(token)
    }
}