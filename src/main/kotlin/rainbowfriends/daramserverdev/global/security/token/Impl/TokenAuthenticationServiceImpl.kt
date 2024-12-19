package rainbowfriends.daramserverdev.global.security.token.Impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.global.member.enums.Roles
import rainbowfriends.daramserverdev.global.security.component.GetTokenEntity
import rainbowfriends.daramserverdev.global.security.token.TokenAuthenticationService
import rainbowfriends.daramserverdev.global.security.token.TokenService

@Deprecated(message = "Use JwtTokenService instead")
@Service
class TokenAuthenticationServiceImpl(private val tokenService: TokenService,private val getTokenEntity: GetTokenEntity): TokenAuthenticationService {
    override fun getRoleByToken(token: String): Roles {
        return getTokenEntity.getTokenEntity(token).role
    }
}