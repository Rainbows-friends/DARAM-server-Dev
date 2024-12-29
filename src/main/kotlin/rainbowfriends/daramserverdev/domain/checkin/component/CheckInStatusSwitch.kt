package rainbowfriends.daramserverdev.domain.checkin.component

import org.springframework.stereotype.Component
import rainbowfriends.daramserverdev.domain.checkin.service.CheckInTransaction
import rainbowfriends.daramserverdev.global.log.logger
import rainbowfriends.daramserverdev.global.redis.redisson.util.DistributedLock
import rainbowfriends.daramserverdev.global.util.ParseStudentId.parseStudentId
import java.time.LocalDate

@Component
class CheckInStatusSwitch(
    private val checkInTransaction: CheckInTransaction,
    private val distributedLock: DistributedLock
) {

    fun switchCheckInStatus(studentId: Short?, date: LocalDate): Boolean {
        if (studentId == null) return false
        val lockKey = "check-in:$date"
        return distributedLock.executeWithLock(lockKey, 5L, 10L) {
            handleCheckInStatusSwitch(studentId, date)
        }
    }

    private fun handleCheckInStatusSwitch(studentId: Short, date: LocalDate): Boolean {
        return try {
            val (grade,classNum,number) = parseStudentId(studentId.toString())
            logger().info("CheckInStatusSwitch: $grade $classNum $number")
            val user = checkInTransaction.getMemberDto(grade, classNum, number)
            val checkIn = checkInTransaction.getCheckInRecord(user, date)
            checkInTransaction.checkInDateModify(checkIn)
            checkInTransaction.toggleCheckInStatus(checkIn)
            true
        } catch (_: Exception) {
            false
        }
    }
}
