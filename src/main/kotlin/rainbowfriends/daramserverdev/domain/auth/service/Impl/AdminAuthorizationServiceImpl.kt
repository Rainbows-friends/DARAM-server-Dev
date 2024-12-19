package rainbowfriends.daramserverdev.domain.auth.service.Impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.auth.service.AdminAuthorizationService
import rainbowfriends.daramserverdev.global.security.dto.TokenResponse
import rainbowfriends.daramserverdev.global.security.key.component.GetKeyOfRole
import rainbowfriends.daramserverdev.global.security.key.component.VerifyKey
import rainbowfriends.daramserverdev.global.security.token.TokenService
import java.security.InvalidKeyException

@Deprecated(message = "Use JwtTokenService instead")
@Service
class AdminAuthorizationServiceImpl(
    private val tokenService: TokenService,
    private val verifyKey: VerifyKey,
    private val getKeyOfRole: GetKeyOfRole
) : AdminAuthorizationService {
    override fun authorizeAdmin(key: String): TokenResponse {
        if (verifyKey.verifyKey(key)) {
            return tokenService.generateTokenDto(key, getKeyOfRole.getKeyOfRole(key))
        }
        else {
            throw InvalidKeyException("Invalid Key")
        }
    }
}