package rainbowfriends.daramserverdev.domain.auth.service.Impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.auth.dto.response.SigninOrReissueResponse
import rainbowfriends.daramserverdev.domain.auth.exception.ReissueTokenException
import rainbowfriends.daramserverdev.domain.auth.service.ReissueService
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.global.member.component.FindMember
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenParserService
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenRefreshService
import java.util.*

@Service
class ReissueServiceImpl(
    private val jwtTokenRefreshService: JwtTokenRefreshService,
    private val jwtTokenParserService: JwtTokenParserService,
    private val findMember: FindMember
) : ReissueService {
    override fun reissue(refreshToken: String): SigninOrReissueResponse {
        if (jwtTokenRefreshService.validateRefreshToken(refreshToken)) {
            val userId: String = jwtTokenParserService.extractUserId(refreshToken)
            val newRefreshToken: Pair<Pair<String, Date>, Pair<String, Date>> =
                jwtTokenRefreshService.regenerateToken(userId, refreshToken)
            return SigninOrReissueResponse(
                accessToken = newRefreshToken.first.first,
                refreshToken = newRefreshToken.second.first,
                accessTokenExpiresIn = newRefreshToken.first.second.toInstant().toString(),
                refreshTokenExpiresIn = newRefreshToken.second.second.toInstant().toString(),
                role = findMember.findMemberByEmail(userId)?.role
                    ?: throw MemberNotFoundException("Member Not Found")
            )
        } else {
            throw ReissueTokenException("Invalid Refresh Token")
        }
    }
}