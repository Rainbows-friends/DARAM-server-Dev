package rainbowfriends.daramserverdev.domain.dev.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Controller
@RequestMapping
class DevController {
    @GetMapping
    fun devServer(model: Model): String {
        val serverTime: LocalDateTime = LocalDateTime.now()
        model.addAttribute("serverTime", serverTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        return "index"
    }

    @GetMapping("/serverTime")
    fun getServerTime(): String {
        val serverTime: LocalDateTime = LocalDateTime.now()
        return serverTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}