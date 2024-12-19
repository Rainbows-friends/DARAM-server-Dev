package rainbowfriends.daramserverdev.domain.time.dto.response

import java.time.LocalDateTime

data class TimeFormattedResponse(
    val limitTime: LocalDateTime,
    val remainTime: String
)