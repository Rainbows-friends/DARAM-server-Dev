package rainbowfriends.daramserverdev.domain.member.service

import jakarta.servlet.http.HttpServletRequest
import rainbowfriends.daramserverdev.global.member.dto.MemberDTO

interface CurrentMemberInqueryService {
    fun getCurrentMember(request: HttpServletRequest): MemberDTO
}