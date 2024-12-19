package rainbowfriends.daramserverdev.domain.checkin.dto.request

import jakarta.validation.constraints.NotNull

class CheckInStatusSwitchRequest {
    @field:NotNull val studentId: Short? = null
}