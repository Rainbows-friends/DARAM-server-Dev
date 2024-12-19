package rainbowfriends.daramserverdev.domain.checkin.service

import rainbowfriends.daramserverdev.domain.checkin.dto.response.GetCheckInResponse

interface MissedCheckInMemberService {
    fun getMissedCheckInMember(): List<GetCheckInResponse>
}