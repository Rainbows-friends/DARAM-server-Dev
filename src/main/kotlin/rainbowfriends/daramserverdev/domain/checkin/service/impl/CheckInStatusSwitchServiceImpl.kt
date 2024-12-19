package rainbowfriends.daramserverdev.domain.checkin.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.checkin.component.CheckInStatusSwitch
import rainbowfriends.daramserverdev.domain.checkin.dto.request.CheckInStatusSwitchRequest
import rainbowfriends.daramserverdev.domain.checkin.service.CheckInStatusSwitchService
import rainbowfriends.daramserverdev.global.checkin.exception.CheckInStatusSwitchException
import java.time.LocalDate

@Service
class CheckInStatusSwitchServiceImpl(private val checkInStatusSwitch: CheckInStatusSwitch): CheckInStatusSwitchService {
    override fun switchCheckInStatus(request: CheckInStatusSwitchRequest) {
        if (!checkInStatusSwitch.switchCheckInStatus(
            date = LocalDate.now(),
            studentId = request.studentId
        )){
            throw CheckInStatusSwitchException("CheckIn Status Switch Failed")
        }
    }
}