package rainbowfriends.daramserverdev.domain.checkin.service.impl

import org.springframework.stereotype.Service
import rainbowfriends.daramserverdev.domain.checkin.component.CheckInMemberQuery
import rainbowfriends.daramserverdev.domain.checkin.dto.enums.GetCheckInComponentAction
import rainbowfriends.daramserverdev.domain.checkin.dto.response.GetCheckInResponse
import rainbowfriends.daramserverdev.domain.checkin.service.CheckedInMemberService
import rainbowfriends.daramserverdev.global.checkin.dto.CheckInDTO
import java.time.LocalDate

@Service
class CheckedInMemberServiceImpl(private val checkInMemberQuery: CheckInMemberQuery) : CheckedInMemberService {
    override fun getCheckedInMember(): List<GetCheckInResponse> {
        val checkInData: List<CheckInDTO> = checkInMemberQuery.getCheckInMember(
            GetCheckInComponentAction.GET_CHECKED_IN_MEMBER,
            LocalDate.now()
        ).map {
            CheckInDTO(
                id = it.id,
                user = it.user,
                checkinStatus = it.checkinStatus,
                checkinDate = it.checkinDate
            )
        }
        return checkInData.map { checkIn ->
            GetCheckInResponse(
                id = checkIn.id,
                user = checkIn.user.toDto(),
                checkinStatus = checkIn.checkinStatus,
                checkinDate = String.format(
                    "%02d:%02d:%02d",
                    checkIn.checkinDate?.hour,
                    checkIn.checkinDate?.minute,
                    checkIn.checkinDate?.second
                )
            )
        }
    }
}