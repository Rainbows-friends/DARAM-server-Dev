package rainbowfriends.daramserverdev.domain.member.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestBody
import rainbowfriends.daramserverdev.domain.member.service.CurrentMemberInquiryService
import rainbowfriends.daramserverdev.domain.member.dto.request.PatchRoomRequest
import rainbowfriends.daramserverdev.domain.member.service.MemberInquiryService
import rainbowfriends.daramserverdev.domain.member.service.PatchRoomService

@RestController
@RequestMapping("/member")
class MemberController(
    private val allMemberInquiryService: MemberInquiryService,
    private val currentMemberInquiryService: CurrentMemberInquiryService,
    private val patchRoomService: PatchRoomService
) {
    @GetMapping
    fun getAllMember(
        @RequestParam(required = false) id: Long?,
        @RequestParam(required = false) stay: Boolean?,
        @RequestParam(required = false) floor: Int?,
        @RequestParam(required = false) room: Int?,
        @RequestParam(required = false) grade: Int?,
        @RequestParam(required = false) classNum: Int?
    ) = allMemberInquiryService.getAllMember(id, stay, floor, room, grade, classNum)

    @GetMapping("/current")
    fun getCurrentMember(request: HttpServletRequest) = currentMemberInquiryService.getCurrentMember(request)

    @PatchMapping("/room")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun patchRoom(@RequestBody patchRoomRequest: PatchRoomRequest) {
        patchRoomService.patchRoom(patchRoomRequest)
    }
}