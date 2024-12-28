package rainbowfriends.daramserverdev.domain.member.service

import rainbowfriends.daramserverdev.domain.member.dto.response.GetMemberResponse

interface MemberInquiryService {
    fun getAllMember(
        id: Long?,
        stay: Boolean?,
        floor: Int?,
        room: Int?,
        grade: Int?,
        classNum: Int?
    ): List<GetMemberResponse>
}