package rainbowfriends.daramserverdev.domain.member.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import rainbowfriends.daramserverdev.domain.member.service.MemberInqueryService

@RestController
@RequestMapping("/member")
class MemberController(
    private val allMemberInqueryService: MemberInqueryService
) {
    @GetMapping
    fun getAllMember(
        @RequestParam(required = false) id: Long?,
        @RequestParam(required = false) stay: Boolean?,
        @RequestParam(required = false) floor: Int?,
        @RequestParam(required = false) room: Int?,
        @RequestParam(required = false) grade: Int?,
        @RequestParam(required = false) classNum: Int?
    ) = allMemberInqueryService.getAllMember(id, stay, floor, room, grade, classNum)
}