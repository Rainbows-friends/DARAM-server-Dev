package rainbowfriends.daramserverdev.domain.checkin.dto.response

import rainbowfriends.daramserverdev.global.member.dto.MemberDTO

data class GetCheckInResponse(
    val id: Long?,
    val user: MemberDTO,
    var checkinStatus: Boolean,
    val checkinDate: String?
)