package rainbowfriends.daramserverdev.global.checkin.component

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import rainbowfriends.daramserverdev.domain.member.exception.MemberNotFoundException
import rainbowfriends.daramserverdev.global.checkin.exception.LateNumberRaiseFailException
import rainbowfriends.daramserverdev.global.checkin.repository.CheckInRepository
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
            val checkIns = checkInRepository.findByCheckinInfoDate(date)
                .filter { !it.checkinStatus }
            val memberIds = checkIns.mapNotNull { it.id }
            val members = memberRepository.findAllById(memberIds).associateBy { it.id }
            checkIns.forEach { checkIn ->
                val member = members[checkIn.id]
                    ?: throw MemberNotFoundException("Member with ID ${checkIn.id} not found")
                member.lateNumber = (member.lateNumber ?: 0) + 1
            }
            memberRepository.saveAll(members.values)
        } catch (_: Exception) {
            throw LateNumberRaiseFailException("Late Number Raise failed")
        }
    }
}