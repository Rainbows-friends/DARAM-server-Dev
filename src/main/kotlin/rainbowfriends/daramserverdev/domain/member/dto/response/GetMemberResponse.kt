package rainbowfriends.daramserverdev.domain.member.dto.response

import rainbowfriends.daramserverdev.global.member.enums.Roles

data class GetMemberResponse(
    val id: Long?,
    val name: String?,
    val grade: Int?,
    val classNum: Int?,
    val number: Int?,
    val floor: Int?,
    val room: Int?,
    val role: Roles?,
    val stay: Boolean?,
    val lateNumber: Long?
)