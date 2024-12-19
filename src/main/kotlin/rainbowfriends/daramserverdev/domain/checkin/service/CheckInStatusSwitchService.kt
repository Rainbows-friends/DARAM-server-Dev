package rainbowfriends.daramserverdev.domain.checkin.service

import rainbowfriends.daramserverdev.domain.checkin.dto.request.CheckInStatusSwitchRequest

interface CheckInStatusSwitchService {
    fun switchCheckInStatus(request: CheckInStatusSwitchRequest)
}