package rainbowfriends.daramserverdev.domain.time.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import rainbowfriends.daramserverdev.domain.time.dto.enums.GetRemainTimeServiceAction
import rainbowfriends.daramserverdev.domain.time.service.RemainTimeService

@RestController
@RequestMapping("/time")
class TimeController(private val remainTimeService: RemainTimeService) {
    @GetMapping("/remaintime")
    fun getRemainTime(@RequestParam(name = "responsetype") responseType: String): Any {
        return remainTimeService.getRemainTime(GetRemainTimeServiceAction.from(responseType))
    }
}