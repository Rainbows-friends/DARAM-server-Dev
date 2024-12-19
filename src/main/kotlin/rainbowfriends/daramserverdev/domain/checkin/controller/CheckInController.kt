package rainbowfriends.daramserverdev.domain.checkin.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import rainbowfriends.daramserverdev.domain.checkin.dto.request.CheckInStatusSwitchRequest
import rainbowfriends.daramserverdev.domain.checkin.dto.response.GetCheckInResponse
import rainbowfriends.daramserverdev.domain.checkin.service.CheckInStatusSwitchService
import rainbowfriends.daramserverdev.domain.checkin.service.CheckedInMemberService
import rainbowfriends.daramserverdev.domain.checkin.service.MissedCheckInMemberService

@RestController
@RequestMapping("/checkin")
class CheckInController(
    private val checkedInMemberService: CheckedInMemberService,
    private val missedCheckInMemberService: MissedCheckInMemberService,
    private val checkInStatusSwitchService: CheckInStatusSwitchService
) {
    @GetMapping("/checkin")
    fun getCheckInMember(): List<GetCheckInResponse> {
        return checkedInMemberService.getCheckedInMember()
    }

    @GetMapping("/uncheckin")
    fun getUnCheckInMember(): List<GetCheckInResponse> {
        return missedCheckInMemberService.getMissedCheckInMember()
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun switchCheckInStatus(@RequestBody request: CheckInStatusSwitchRequest) {
        checkInStatusSwitchService.switchCheckInStatus(request)
    }
}