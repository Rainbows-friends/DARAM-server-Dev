package rainbowfriends.daramserverdev.global.checkin.component

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.global.checkin.exception.LateNumberRaiseFailException
import rainbowfriends.daramserverdev.global.checkin.repository.CheckInRepository
import rainbowfriends.daramserverdev.global.log.logger
import rainbowfriends.daramserverdev.global.member.repository.MemberRepository
import java.time.LocalDate

@Component
class LateNumberUpdater(
    private val checkInRepository: CheckInRepository,
    private val memberRepository: MemberRepository
) {

    @Transactional
    fun lateNumberRaise(date: LocalDate) {
        try {
            logger().info("Starting lateNumberRaise process for date: $date")
            val checkIns = checkInRepository.findByCheckinInfoDate(date)
                .filter { !it.checkinStatus }
            logger().info("Fetched ${checkIns.size} check-ins with checkinStatus = false")
            val memberIds = checkIns.mapNotNull { it.user.id }
            logger().info("Extracted member IDs: $memberIds")
            val members = memberRepository.findAllById(memberIds).associateBy { it.id }
            logger().info("Fetched ${members.size} members from memberRepository")
            checkIns.forEach { checkIn ->
                val memberId = checkIn.id
                val member = members[memberId]
                if (member == null) {
                    logger().error("Member with ID $memberId not found")
                    throw MemberNotFoundException("Member with ID $memberId not found")
                }
                val previousLateNumber = member.lateNumber ?: 0
                member.lateNumber = previousLateNumber + 1
                logger().info(
                    "Updated lateNumber for Member ID $memberId: Previous=$previousLateNumber, New=${member.lateNumber}"
                )
            }
            memberRepository.saveAll(members.values)
            logger().info("Saved all updated members successfully")
        } catch (e: MemberNotFoundException) {
            logger().error("Failed to process late numbers due to missing member: ${e.message}")
            throw LateNumberRaiseFailException("Late Number Raise failed: ${e.message}" + e)
        } catch (e: Exception) {
            logger().error("Unexpected error during late number update", e)
            throw LateNumberRaiseFailException("Late Number Raise failed" + e)
        }
    }
}