package rainbowfriends.daramserverdev.global.security.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.auth.exception.TokenNotFoundException
import rainbowfriends.daramserverdev.global.redis.RedisUtil

@Deprecated(message = "Not used anymore")
@Component
class DeleteToken(private val redisUtil: RedisUtil) {
    fun deleteToken(token: String) {
        if (redisUtil.exists(token)) {
            redisUtil.delete(token)
        } else {
            throw TokenNotFoundException("Token Not Found")
        }
    }
}