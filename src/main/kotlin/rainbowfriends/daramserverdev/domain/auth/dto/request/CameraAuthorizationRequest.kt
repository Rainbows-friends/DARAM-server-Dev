package rainbowfriends.daramserverdev.domain.auth.dto.request

import jakarta.validation.constraints.NotBlank

data class CameraAuthorizationRequest(
    @field:NotBlank val key: String
)