package rainbowfriends.daramserverdev.domain.notice.dto.response

import rainbowfriends.daramserverdev.global.member.enums.Roles
import java.time.LocalDateTime

data class NoticeResponse(
    val id: Long?,
    val title: String,
    val context: String,
    val author: Roles,
    val createdAt: LocalDateTime
)