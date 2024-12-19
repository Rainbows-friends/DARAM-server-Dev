package rainbowfriends.daramserverdev.global.security.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.global.redis.RedisUtil
import rainbowfriends.daramserverdev.global.security.entity.Token

@Deprecated(message = "Use JwtTokenService instead")
@Component
class GetTokenEntity(private val redisUtil: RedisUtil) {
    fun getTokenEntity(token: String): Token {
        return redisUtil.get(token) as Token
    }
}