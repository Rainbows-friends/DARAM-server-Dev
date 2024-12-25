package rainbowfriends.daramserverdev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import java.util.TimeZone

@SpringBootApplication
@EntityScan(
    basePackages = [
        "rainbowfriends.daramserverdev.global.security.key.entity",
        "rainbowfriends.daramserverdev.domain.notice.entity",
        "rainbowfriends.daramserverdev.global.member.entity",
        "rainbowfriends.daramserverdev.global.checkin.entity"
    ]
)
@EnableScheduling
class DaramServerDevApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    runApplication<DaramServerDevApplication>(*args)
}