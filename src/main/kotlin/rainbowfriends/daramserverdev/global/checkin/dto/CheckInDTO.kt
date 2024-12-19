package rainbowfriends.daramserverdev.global.checkin.dto

import rainbowfriends.daramserverdev.global.member.entity.Member
import java.time.LocalDateTime

data class CheckInDTO(
    val id: Long?,
    val user: Member,
    var checkinStatus: Boolean = false,
    val checkinDate: LocalDateTime? = null
)