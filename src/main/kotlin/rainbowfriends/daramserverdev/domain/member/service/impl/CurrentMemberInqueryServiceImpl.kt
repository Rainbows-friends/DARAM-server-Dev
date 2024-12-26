package rainbowfriends.daramserverdev.domain.member.service.impl

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.auth.exception.TokenNotFoundException
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.domain.member.service.CurrentMemberInqueryService
import rainbowfriends.daramserverdev.global.member.component.FindMember
import rainbowfriends.daramserverdev.global.member.dto.MemberDTO
import rainbowfriends.daramserverdev.global.security.jwt.service.JwtTokenParserService

@Service
class CurrentMemberInqueryServiceImpl(
    private val jwtTokenParserService: JwtTokenParserService,
    private val findMember: FindMember
) : CurrentMemberInqueryService {
    override fun getCurrentMember(request: HttpServletRequest): MemberDTO {
        return findMember.findMemberByEmail(
            if (request.getHeader("Authorization") == null) throw TokenNotFoundException("Token not found")
            else
                jwtTokenParserService.extractUserId(
                    request.getHeader("Authorization").substring(7)
                )
        )
            ?.toDto() ?: throw MemberNotFoundException("Member not found")
    }
}