package rainbowfriends.daramserverdev.global.security.jwt.service

import io.jsonwebtoken.Claims
import rainbowfriends.daramserverdev.global.member.enums.Roles

interface JwtTokenParserService {
    fun extractUserId(token: String): String
    fun extractRole(token: String): Roles
    fun isTokenValid(token: String): Boolean
    fun parseClaims(token: String): Claims
}