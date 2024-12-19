package rainbowfriends.daramserverdev.domain.time.dto.response

import java.time.LocalDateTime

data class SecondsResponse(
    val limitTime: LocalDateTime,
    val seconds: Long
)