package rainbowfriends.daramserverdev.domain.notice.dto.request

import jakarta.validation.constraints.NotBlank

data class PostNoticeRequest(
    @field:NotBlank val title: String,
    @field:NotBlank val content: String
)