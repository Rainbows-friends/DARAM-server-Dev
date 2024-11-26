package rainbowfriends.daramserverv2.domain.notice.dto.response

import rainbowfriends.daramserverv2.global.member.enums.Roles
import java.time.LocalDateTime

data class NoticeResponse(
    val id: Long?,
    val title: String,
    val context: String,
    val author: Roles,
    val createdAt: LocalDateTime
)