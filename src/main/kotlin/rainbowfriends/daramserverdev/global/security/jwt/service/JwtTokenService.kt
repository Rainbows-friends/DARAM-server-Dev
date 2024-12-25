package rainbowfriends.daramserverdev.global.security.jwt.service

import rainbowfriends.daramserverdev.global.member.enums.Roles
import java.time.LocalDateTime
import java.util.*

interface JwtTokenService {
    fun generateAccessToken(userId: String, role: Roles): Pair<String, LocalDateTime>
    fun generateRefreshToken(userId: String, role: Roles): Pair<String, LocalDateTime>
}