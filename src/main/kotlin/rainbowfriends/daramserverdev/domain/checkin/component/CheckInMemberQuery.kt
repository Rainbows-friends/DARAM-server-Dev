package rainbowfriends.daramserverdev.domain.checkin.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.checkin.dto.enums.GetCheckInComponentAction
import rainbowfriends.daramserverdev.global.checkin.entity.CheckIn
import rainbowfriends.daramserverdev.global.checkin.repository.CheckInRepository
import java.time.LocalDate

@Component
class CheckInMemberQuery(private val checkInRepository: CheckInRepository) {
    fun getCheckInMember(action: GetCheckInComponentAction, date: LocalDate): List<CheckIn> =
        when (action) {
            GetCheckInComponentAction.GET_CHECKED_IN_MEMBER -> getCheckInMember(date)
            GetCheckInComponentAction.GET_MISSED_CHECK_IN_MEMBER -> getMissedCheckInMember(date)
        }

    private fun getMissedCheckInMember(date: LocalDate): List<CheckIn> {
        return checkInRepository.findByCheckinInfoDateAndCheckinStatus(date, false)
    }

    private fun getCheckInMember(date: LocalDate): List<CheckIn> {
        return checkInRepository.findByCheckinInfoDateAndCheckinStatus(date, true)
    }
}