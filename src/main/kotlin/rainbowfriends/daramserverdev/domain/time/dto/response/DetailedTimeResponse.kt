package rainbowfriends.daramserverdev.domain.time.dto.response

import java.time.LocalDateTime

data class DetailedTimeResponse(
    val limitTime: LocalDateTime,
    val hours: Long,
    val minutes: Long,
    val seconds: Long
)