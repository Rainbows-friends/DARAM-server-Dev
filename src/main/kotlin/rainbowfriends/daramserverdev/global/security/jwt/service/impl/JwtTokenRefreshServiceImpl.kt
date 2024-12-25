package rainbowfriends.daramserverdev.global.security.jwt.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.global.member.enums.Roles
import rainbowfriends.daramserverdev.global.redis.RedisUtil
import rainbowfriends.daramserverdev.global.security.exception.ExpiredTokenException
import rainbowfriends.daramserverdev.global.security.exception.InvalidRefreshTokenException
import rainbowfriends.daramserverdev.global.security.exception.RegenerateTokenFailedException
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenParserService
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenRefreshService
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenService
import java.time.LocalDateTime
import java.util.*

@Service
class JwtTokenRefreshServiceImpl(
    private val jwtTokenService: JwtTokenService,
    private val jwtTokenParserService: JwtTokenParserService,
    private val redisUtil: RedisUtil
) : JwtTokenRefreshService {

    override fun saveRefreshToken(userId: String, refreshToken: String) {
        redisUtil.set(refreshToken, userId, REFRESH_TOKEN_EXPIRATION_SECONDS)
    }

    override fun validateRefreshToken(refreshToken: String): Boolean {
        if (!redisUtil.exists(refreshToken)) throw InvalidRefreshTokenException("Refresh Token is invalid")
        if (!jwtTokenParserService.isTokenValid(refreshToken)) {
            redisUtil.delete(refreshToken)
            throw ExpiredTokenException("Refresh Token is expired")
        }
        return true
    }

    override fun regenerateToken(userId: String, refreshToken: String): Pair<Pair<String, LocalDateTime>, Pair<String, LocalDateTime>> {
        if (validateRefreshToken(refreshToken)) {
            val role: Roles = jwtTokenParserService.extractRole(refreshToken)
            val newAccessToken: Pair<String, LocalDateTime> = jwtTokenService.generateAccessToken(userId, role)
            val newRefreshToken: Pair<String, LocalDateTime> = jwtTokenService.generateRefreshToken(userId, role)
            redisUtil.delete(refreshToken)
            saveRefreshToken(userId, newRefreshToken.first)
            return Pair(
                Pair(newAccessToken.first, newAccessToken.second),
                Pair(newRefreshToken.first, newRefreshToken.second)
            )
        }
        throw RegenerateTokenFailedException("Token regeneration failed")
    }

    companion object {
        private const val REFRESH_TOKEN_EXPIRATION_SECONDS = 14 * 24 * 60 * 60
    }
}