package rainbowfriends.daramserverdev.domain.notice.dto.request

import rainbowfriends.daramserverdev.global.member.enums.Roles

data class PatchNoticeRequest(
    val title: String? = null,
    val content: String? = null,
    val author: Roles? = null
)